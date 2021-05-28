import static java.lang.Thread.sleep;
public class Router 
{
    public boolean[] routerArray;
    public int routerNum;
    public Semaphore router;
    public int nOccupied;
    Router(int number)
    { 
        routerNum = number;
        router = new Semaphore(routerNum);
        routerArray = new boolean[routerNum];
    }
    //methods
    public synchronized int occupy(Device ob) throws InterruptedException {        
        for (int i = 0; i < routerNum; i++) {
            if (routerArray[i] == false) { /* means It's available for being occupied */
                nOccupied++;
                ob.assignedrouter = i+1;
                System.out.println("Connection " + ob.assignedrouter + ": " + ob.getName() + " occupied");
                routerArray[i] = true;
                sleep(100);
                break;
            }
        }       
        return ob.assignedrouter;
        
    }
    public String release() throws InterruptedException {
        String val = " performs online activity";
        sleep(1000);
        return val;
    }    
    public synchronized String leave(Device ob) {
        { /* means It's available for being occupied */
            nOccupied--;
            routerArray[ob.assignedrouter-1] = false;
        }
        
       //no need for notify here as it already called from the client after finishing the leave function
        notify();
        return " Logged out";
    }  
}
