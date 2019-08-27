package Socket_ToCommunicate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Client started");
            System.out.print("Give The Ip Address of The Server :");
            String host = input.next();
            Socket socket = new Socket(host, 9999);
            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                System.out.println("Enter your Messages : ");
                String str = userinput.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(str);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(in.readLine());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}