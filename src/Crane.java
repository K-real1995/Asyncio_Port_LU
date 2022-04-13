public class Crane implements Runnable{

    public Port port;

    public Crane(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (Port.piers.size()!=0){
            try {
                port.loadingShip();
            } catch (InterruptedException e) {
            }
        }
    }
}
