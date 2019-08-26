
package Socket_Using_Ports;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss =new ServerSocket(3333);
        Socket s = ss.accept();//Establish Connection
        DataInputStream dis =new DataInputStream(s.getInputStream());
        DataOutputStream dos =new DataOutputStream(s.getOutputStream());
        InputStreamReader isr =new InputStreamReader(System.in);
        BufferedReader stdin =new BufferedReader(isr);
        
        String s1="",s2="";
        while(!s1.equals("end"))
        {
            s1=dis.readUTF();
            System.out.println("Client :"+s1);
            s2=stdin.readLine();
            dos.writeUTF(s2);
            dos.flush();
        }
        dis.close();
        s.close();
        ss.close();
        
        
    }
    
}
