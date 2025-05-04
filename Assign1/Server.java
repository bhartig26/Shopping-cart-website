import java.rmi.*;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerImpl serverImpl = new ServerImpl();
            Naming.rebind("Server", serverImpl);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}