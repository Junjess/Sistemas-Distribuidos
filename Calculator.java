package RPC;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface remota para operações matemáticas
public interface Calculator extends Remote {
    double add(double num1, double num2) throws RemoteException;
    double sub(double num1, double num2) throws RemoteException;
    double mult(double num1, double num2) throws RemoteException;
    double div(double num1, double num2) throws RemoteException;
}
