package day06workshop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CookieClientHandler implements Runnable {

    String dirPath = "./data";
    String filename = "cookie.txt";
    List<String> cookieItems = null;
    final Socket s;

    public CookieClientHandler(Socket s) {
        this.s = s;
    }

    public void readCookieFile() throws IOException {
        cookieItems = new ArrayList<>();

        File file = new File(dirPath + File.separator + filename);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String readString = "";

        while ((readString = br.readLine()) != null) {
            cookieItems.add(readString);
        }
        br.close();
    }

    public String returnCookie() {
        Random random = new Random();

        if (cookieItems != null) {
            return cookieItems.get(random.nextInt(cookieItems.size()));
        } else {
            return "no cookies found!";
        }
    }

    public void showCookies() {
        if (cookieItems != null) {
            cookieItems.forEach(c -> System.out.println(c));
        }
    }

    @Override
    public void run() {

        try {
            this.readCookieFile();
            InputStream is = s.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            OutputStream os = s.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            String line = "";

            while (!line.equals("close")) {
                line = dis.readUTF();

                if (line.equalsIgnoreCase("get-cookie")) {
                    String cookieValue = this.returnCookie();
                    dos.writeUTF(cookieValue);
                    dos.flush();
                }
            }
            dos.close();
            bos.close();
            os.close();
            dis.close();
            bis.close();
            is.close();
        } catch (IOException ex) {
        }
    }
}
