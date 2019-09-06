package Messenger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client
{

	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Name : ");
		String name = scanner.nextLine();
		
		System.out.print("Source Port : ");
		int sourcePort = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Destination IP Address : ");
		String destinationIP = scanner.nextLine();
		
		System.out.print("Destination Port : ");
		int destinationPort = Integer.parseInt(scanner.nextLine());
		
		Channel channel = new Channel();
		channel.bind(sourcePort);
		channel.start();
		
		System.out.println("Started.");
		
		InetSocketAddress address = new InetSocketAddress(destinationIP, destinationPort);
		
		while(true)
		{
			String msg = scanner.nextLine();
			
			if(msg.isEmpty())
				break;
			
			msg = name + " :  " + msg;
			
			channel.sendTo(address, msg);
			System.out.println(msg);
		}
		
		scanner.close();
		channel.stop();
		
		System.out.println("Closed.");
	}

}

//10.100.168.27
//10.100.52.211