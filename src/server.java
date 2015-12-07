import com.sun.corba.se.spi.activation.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by saoirse on 07/12/2015.
 */
public class server {

    public static void main(String[] args ) throws IOException {
        ServerSocket servsocket = new ServerSocket(12345);
        while(true) {

            Socket socket = servsocket.accept();
            byte[] mybyteArray = new byte[1024];

            InputStream is = socket.getInputStream();

            FileOutputStream fos = new FileOutputStream("cute.txt");

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int bytesRead = is.read(mybyteArray, 0, mybyteArray.length);

            bos.write(mybyteArray, 0, bytesRead);

            System.out.println("file-made");

            bos.close();
            socket.close();
        }




    }

}
