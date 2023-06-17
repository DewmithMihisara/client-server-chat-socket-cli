import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(3001);
            Socket socket=serverSocket.accept();
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

            String str="";
            String str2;
            while(!str.equals("stop")){
                str=dataInputStream.readUTF();
                System.out.println("client says: "+str);
                str2=bufferedReader.readLine();
                dataOutputStream.writeUTF(str2);
                dataOutputStream.flush();
            }
            dataInputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}