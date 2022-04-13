public class GetShip implements Runnable {

    Port port;

    public GetShip(Port port){
        this.port = port;
    }

    @Override
    public void run() {
        while (Port.piers.size()!=0){
            port.getShip();
        }
    }
}
