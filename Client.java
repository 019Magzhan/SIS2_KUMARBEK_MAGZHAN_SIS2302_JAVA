import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);


           while(true){
               System.out.println("Enter 3D object name:");
               String message = scanner.nextLine();
            out.println(message);

//            String serverResponse = in.readLine();
//            System.out.println("Answer server: " + serverResponse);
//            String Type= scanner.nextLine();
//            out.println(Type);
        if(message.equalsIgnoreCase("Q")){
            break;
        }

        if(message.equalsIgnoreCase("Circle")){
            String serverrespone= in.readLine();
            System.out.println(serverrespone);
            String radius= scanner.nextLine();
            out.println(radius);
        }
        String response=in.readLine();
               System.out.println(response);

           }
            in.close();
            out.close();
            socket.close();
            scanner.close();
        } catch (IOException ja) {
            ja.printStackTrace();
        }
        }
    }
