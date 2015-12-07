import java.io.*;
import java.net.Socket;

/**
 * Created by saoirse on 07/12/2015.
 */
public class client {

    public static void main(String[] args) throws IOException {

        Socket sock = new Socket("localhost", 12345);
        File myfile = new File("cute.txt");
        byte[] mybytearray = new byte[(int) myfile.length()];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myfile));
        bis.read(mybytearray, 0, mybytearray.length);
        OutputStream os = sock.getOutputStream();

        os.write(mybytearray, 0, mybytearray.length);
        System.out.println("copied");
        os.flush();
        sock.close();


    }
}
