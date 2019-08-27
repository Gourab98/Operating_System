
package Socket_Using_UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Client {

    
    public static void main(String[] args) throws Exception {
        
         BufferedReader clientRead =new BufferedReader(new InputStreamReader(System.in));
      
      InetAddress IP = InetAddress.getByName("10.100.51.133");
      //InetAddress IP = InetAddress.getLocalHost();
     
      DatagramSocket clientSocket = new DatagramSocket();
      
    //  byte[] buf =null;
      
      while(true)    
      {
      byte[] sendbuffer = new byte[1024];
      byte[] receivebuffer = new byte[1024];
      
      System.out.print("\nClient: ");
      String clientData = clientRead.readLine();
      sendbuffer = clientData.getBytes();        
      DatagramPacket sendPacket =
      new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9776);
      clientSocket.send(sendPacket);
      if(clientData.equalsIgnoreCase("bye"))
      {
          System.out.println("Connection ended by client");
          break;
      }
      DatagramPacket receivePacket =
      new DatagramPacket(receivebuffer, receivebuffer.length);
      clientSocket.receive(receivePacket);
      String serverData = new String(receivePacket.getData());
      System.out.print("\nServer: " + serverData);
      
      }
      clientSocket.close();
    }
    
}