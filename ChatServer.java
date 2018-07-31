import java.io.*;
import java.net.*;

public class ChatServer {
   public static void main (String[] args) throws Exception {
     ServerSocket ss = new ServerSocket(5566); // specify port number.
     System.out.println("Server listening at " + InetAddress.getLocalHost() +
                        " on port " + ss.getLocalPort());
     while (true) {
        Socket s = ss.accept();  //wait for new client to call
        DataInputStream dis = new DataInputStream(s.getInputStream());
        String message = dis.readUTF();
        String message.replaceAll("\\s+","");
        System.out.println(s.getRemoteSocketAddress()+"$ "+message);

     try {
        String[] parts = message.split(":");
          if (parts[0].equals("Tom") && parts[1].equals("123")) {
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("Login Name : "+parts[0]+"\nPassword : "+parts[1]);
        s.close();
         } else {
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("Login Name : "+parts[0]+"\nPassword : "+parts[1]);
        s.close();
         }
       }
     catch(Exception e) {
        DataOutputStream dos = new DataOutputStream(s.getOutPutStream());
        dos.writeUTF("Error Input");
        s.close();
      }
    }
  }
}
