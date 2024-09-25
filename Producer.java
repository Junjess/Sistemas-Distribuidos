
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.net.Socket;
    import java.util.concurrent.Semaphore;
    
    public class Producer {
        private static int valor = 0;
        private static Semaphore semaforo = new Semaphore(1);
    
        public static void main(String[] args) {
            try {
                // Conecta ao consumer na porta 5000
                Socket socket = new Socket("localhost", 5000);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    
                while (true) {
                    // Incrementa o valor com controle do semáforo
                    semaforo.acquire();
                    valor++;
                    out.println(valor); // Envia o valor incrementado ao Consumer
                    semaforo.release();
    
                    System.out.println("Producer: Enviando valor " + valor);
                    Thread.sleep(1000); // Espera 1 segundo antes de incrementar novamente
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

