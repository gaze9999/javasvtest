import java.util.Scanner;
import java.io.*;
import java.net.*;

class ChatClient {
  public static void main(String[] args) throws IOException {
     Scanner stdIn = new Scanner(System.in);

     System.out.print("輸入帳號 : ");
     String name = stdIn.nextLine();
     System.out.print("輸入密碼 : ");
     String pass = stdIn.nextLine();

     String serverName = args[0];
     int serverPort = Integer.parseInt(args[1]);
     Socket s = new Socket(serverName, serverPort);
     DataOutputStream dos = new DataOutputStream(s.getOutputStream());
     dos.writeUTF(name+":"+pass);
     DataInputStream dis= new DataInputStream(s.getInputStream());
     String message = dis.readUTF();
     System.out.println(message);
     dos.close();
  }
}
