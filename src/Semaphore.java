import static java.lang.Thread.sleep;

public class Semaphore 
{
    public static int queue;
    Semaphore(int num)
    {
        queue=num;
    }
    public synchronized void P(Device ob){
        queue--;
        //out.println(queue);
        if(queue<0) {
            try {
                sleep(200);
                System.out.println(ob.getName() + " arrived and waiting");               
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {        
            System.out.println(ob.getName() + " arrived");           
        }       
    }
    public synchronized void V() {
        queue++;
        if (queue <= 0)
            notify();
        
    }
}
