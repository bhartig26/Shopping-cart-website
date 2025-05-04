import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {
    public ServerImpl() throws RemoteException {
        super();
    }

    public double Addition(double a, double b) throws RemoteException {
        return a + b;
    }

    public double Substraction(double a, double b) throws RemoteException {
        return a - b;
    }

    public double Multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    public double Division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        if (a == 0) {
            return 0;
        }
        return a / b;
    }
}
