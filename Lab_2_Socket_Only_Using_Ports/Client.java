
package Socket_Using_Ports;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("Localhost",3333);
       DataInputStream dis =new DataInputStream(s.getInputStream());
        DataOutputStream dos =new DataOutputStream(s.getOutputStream());
        InputStreamReader isr =new InputStreamReader(System.in);
        BufferedReader stdin =new BufferedReader(isr);
        
        String s1="",s2="";
        while(!s1.equals("end"))
        {
          s2=stdin.readLine();
          dos.writeUTF(s2);
          dos.flush();
          s1=dis.readUTF();
            System.out.println("Server :"+s1);
        } 
        
        dos.close();
        s.close();
    }
    
}
