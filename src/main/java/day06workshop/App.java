package day06workshop;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // instantiates a file/directory object and creates dir if does not exist
        String dirPath = "./data";
        File newDirectory = new File(dirPath);

        if(newDirectory.exists()) {
            System.out.println("Directory already exists");
        } else {
            newDirectory.mkdir();
        }

        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket s = ss.accept();

            Thread thread = new Thread(new CookieClientHandler(s));
            thread.start();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
