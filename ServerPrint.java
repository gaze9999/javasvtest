import java.io.*;
import java.net.*;
public class ServerPrint {
   public static void main (String[] args) throws Exception {
     ServerSocket ss = new ServerSocket(1234); // specify port number.
     System.out.println("Server listening at " + InetAddress.getLocalHost() +
                        " on port " + ss.getLocalPort());
     while (true) {
        Socket  s = ss.accept();  //wait for new client to call
        DataInputStream dis= new DataInputStream(s.getInputStream());
        String  message = dis.readUTF();  // wait for client to send
        System.out.println(message);
     }
   }
}
