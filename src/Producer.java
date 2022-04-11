public class Producer implements Runnable {

    public Port port;

    public Producer(Port port){
        this.port = port;
    }

    @Override
    public void run() {
        port.deliveryOfGoods();
    }
}

