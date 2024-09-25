import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    // Variável compartilhada
    private static int valor = 0;
    
    // Semáforo para controle de acesso ao recurso
    private static Semaphore semaforo = new Semaphore(1);

    public static void main(String[] args) {
        // Thread Producer (Produtor)
        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    // O semáforo é adquirido antes de alterar a variável
                    semaforo.acquire();
                    valor++; // Incrementa o valor
                    System.out.println("Producer: Incrementado para " + valor);
                    semaforo.release(); // Libera o semáforo após o incremento
                    Thread.sleep(1000); // Espera 1 segundo
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Thread Consumer (Consumidor)
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    // O semáforo é adquirido antes de acessar a variável
                    semaforo.acquire();
                    System.out.println("Consumer: Valor atual " + valor);
                    semaforo.release(); // Libera o semáforo após ler a variável
                    Thread.sleep(1000); // Espera 1 segundo
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Iniciar as threads
        producer.start();
        consumer.start();
    }
}

