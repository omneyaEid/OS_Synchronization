//thread class

public class Device extends Thread {

    public static Router sharedRouter;
    public boolean enter = false;
    public int assignedrouter;

    Device(String deviceName, Router r) {
        super(deviceName); //the name of this thread which is the client name
        sharedRouter = r;
    }

    @Override
    public void run() {
        sharedRouter.router.P(this); /* as a start first till the semaphore that a new one has arrived */

        try {
            assignedrouter = sharedRouter.occupy(this); //occupy is a synchronized so not two client enter at the same time to get router
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Connection " + assignedrouter + ": " + this.getName() + sharedRouter.release());
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        System.out.println("Connection " + assignedrouter + ": " + this.getName() + sharedRouter.leave(this));
        sharedRouter.router.V();
    }
}
