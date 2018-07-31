import java.io.*;
import java.net.*;
public class ClientSend{
  public static void main (String[] args)   {
    if (args.length != 3) {
       System.out.println("Usage: java ClientSide IP port message");
       System.exit(0);
    }
    String serverName = args[0];
    int serverPort = Integer.parseInt(args[1]);
    String message = args[2];
    try {
       Socket s = new Socket(serverName, serverPort);
       DataOutputStream dos = new DataOutputStream(s.getOutputStream());
       dos.writeUTF(message);
       dos.close();  // and flush
    }
    catch(Exception e) { System.out.println(e); }
 }
}
