package RPC;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Inicia o registro RMI na porta 1101
            LocateRegistry.createRegistry(1101);

            // Cria a instância do serviço de calculadora
            CalculatorImpl calc = new CalculatorImpl();

            // Registra o serviço de calculadora com o nome "CalculatorService"
            Naming.rebind("rmi://localhost:1101/CalculatorService", calc);

            System.out.println("Servidor de calculadora pronto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
