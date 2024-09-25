import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Consumer {
    public static void main(String[] args) {
        try {
            // Cria um ServerSocket na porta 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Consumer: Aguardando conexão...");

            // Aguarda o Producer conectar
            Socket socket = serverSocket.accept();
            System.out.println("Consumer: Conectado ao Producer!");

            // Lê os dados recebidos do Producer
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String receivedValue;
            while ((receivedValue = in.readLine()) != null) {
                System.out.println("Consumer: Recebeu valor " + receivedValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
