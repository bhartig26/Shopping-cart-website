import java.rmi.*;
import java.util.Scanner;


public class Client{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        try{
        String serverURL="rmi://localhost/Server";
        ServerIntf serverIntf=(ServerIntf) Naming.lookup(serverURL);

        System.out.println("Enter first number : ");
        double a= sc.nextDouble();
        
        System.out.println("Enter second number : ");
        double b= sc.nextDouble();

        System.out.println("Resultssss");
        System.out.println("Addition : "+serverIntf.Addition(a, b));
        System.out.println("Substraction : "+serverIntf.Substraction(a, b));
        System.out.println("Multiplication : "+serverIntf.Multiplication(a, b));
        System.out.println("Division : "+serverIntf.Division(a, b));
        }catch(Exception e){
            System.out.println("Client exception: " + e.getMessage());
        }finally{
            sc.close();
        }
    }

}