import java.util.Scanner;
public class Network
{
    public static void main(String [] args) throws InterruptedException
    {
       int nRouters;
        Scanner input = new Scanner(System.in);
        System.out.println("What is number of WI-FI Connections?");
        nRouters = input.nextInt();        
        Router router = new Router (nRouters);     
        System.out.println("What is number of devices Clients want to connect? ");
        int nDevice = input.nextInt();
        Device[] device = new Device[nDevice];
        System.out.println("What is the devices's Name?");
        input=new Scanner(System.in);
        for (int j = 0; j < nDevice; j++) {
            String divicesNames = input.nextLine();
            device[j] = new Device(divicesNames,router);
        }
        
        for(int m=0 ; m<nRouters ; m+=nRouters){
            for (int j = 0; j < nDevice; j++) {
            
            device[j].start();
            
        }
            Thread.sleep(10000);
        }
        
    }
}
