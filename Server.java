import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket=new ServerSocket(12345);
            Socket socket=serverSocket.accept();
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String clientMessage;

            while(true){
           clientMessage=in.readLine();
           if(clientMessage.equalsIgnoreCase("Q")){
                    break;
                }
           if(clientMessage.equalsIgnoreCase("Circle")){
               out.println("Enter Radius");
               String radiusString=in.readLine();
               int R=Integer.parseInt(radiusString);
               double area = Math.PI*R*R;
               out.println("Area = " + area);
           }else{
               out.println();
           }
//           if(clientMessage.equalsIgnoreCase("Rectangle")){
//               double area=
//           }

//                System.out.println("Client Says: " + clientMessage);
//                out.println("Client connected. Client says: " + clientMessage);
            }

            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        }
        catch (IOException ja){
            ja.printStackTrace();
        }
        }
    }

