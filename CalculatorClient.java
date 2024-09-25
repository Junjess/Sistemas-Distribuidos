package RPC;

import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Localiza o serviço remoto pelo nome registrado no servidor
            // Mudança principal: o cliente precisa localizar o objeto remoto
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost:1101/CalculatorService");

            // Exemplos de chamadas remotas para as operações matemáticas
            double num1 = 12;
            double num2 = 4;

            // Mudança: Cada operação é uma chamada remota, invocada via RMI
            System.out.println("Adição de " + num1 + " + " + num2 + " = " + calc.add(num1, num2));
            System.out.println("Subtração de " + num1 + " - " + num2 + " = " + calc.sub(num1, num2));
            System.out.println("Multiplicação de " + num1 + " * " + num2 + " = " + calc.mult(num1, num2));
            System.out.println("Divisão de " + num1 + " / " + num2 + " = " + calc.div(num1, num2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
