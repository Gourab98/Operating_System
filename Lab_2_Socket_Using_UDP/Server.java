
package Socket_Using_UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Server {

   
    public static void main(String[] args) throws Exception {
        
         DatagramSocket serverSocket = new DatagramSocket(9776);
         boolean bye=false;
     
      while(true) 
        {
          byte[] receivebuffer = new byte[1024];
          byte[] sendbuffer  = new byte[1024];
          DatagramPacket recvdpkt = new DatagramPacket(receivebuffer, receivebuffer.length);
          serverSocket.receive(recvdpkt);
          InetAddress IP = recvdpkt.getAddress();
          int portno = recvdpkt.getPort();
          String clientdata = new String(recvdpkt.getData());
          System.out.println("\nClient : "+ clientdata);
          System.out.print("\nServer : ");
          BufferedReader serverRead = new BufferedReader(new InputStreamReader (System.in) );
          String serverdata = serverRead.readLine();
          
          sendbuffer = serverdata.getBytes();
          DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP,portno);
          serverSocket.send(sendPacket); 
         
          if(serverdata.equalsIgnoreCase("bye"))
          {
              System.out.println("connection ended by server");
              break;
          }
          
          
      }
        serverSocket.close();
    }
            
    }
