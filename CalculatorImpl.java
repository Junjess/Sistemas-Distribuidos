package RPC;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator{

    // Construtor necessário para tratar RemoteException
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    // Implementação do método de adição
    public double add(double num1, double num2) throws RemoteException {
        return num1 + num2;
    }

    // Implementação do método de subtração
    public double sub(double num1, double num2) throws RemoteException {
        return num1 - num2;
    }

    // Implementação do método de multiplicação
    public double mult(double num1, double num2) throws RemoteException {
        return num1 * num2;
    }

    // Implementação do método de divisão
    public double div(double num1, double num2) throws RemoteException {
        if (num2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
        return num1 / num2;
    }
}
    

