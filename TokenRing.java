import java.util.*;

public class TokenRing{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of Nodes : ");
        int n=sc.nextInt();
        System.out.println("Ring Formed is :");
        for(int i=0;i<n;i++){
            System.out.print(i+" ");
        }
        System.out.println(0);

        int choice =0;
        do{
            System.out.println("Enter Sender : ");
        int sender=sc.nextInt();
        if(sender>=n){
            System.out.println("Invalid sender");
            return;
        }

        System.out.println("Enter Reciever : ");
        int reciever=sc.nextInt();
        if(reciever>=n){
            System.out.println("Invalid reciever");
            return;
        }

        System.out.println("Enter Data : ");
        int data=sc.nextInt();

        int token=0;

        for(int i=0;i<sender;i++){
            System.out.print(" "+i+"->");
        }
        System.out.println(" "+sender);
        System.out.println("Sender is sending Data");

        for(int i=sender;i!=reciever;i=(i+1)%n){
            System.out.println("Data "+data+" Forwarded by "+i);
        }
        System.out.println("Reciver "+reciever+" gets data " +data);
        token=sender;
        System.out.println("Press 1 to continue else 0");
        choice=sc.nextInt();
        }while(choice==1);
    }
}