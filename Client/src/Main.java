import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",3001);
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

            String str="";
            String str2;
            while(!str.equals("stop")){
                str=bufferedReader.readLine();
                dataOutputStream.writeUTF(str);
                dataOutputStream.flush();
                str2=dataInputStream.readUTF();
                System.out.println("Server says: "+str2);
            }

            dataOutputStream.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}