import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ship implements Runnable{

    public Port port;

    public Ship(Port port) {
        this.port = port;
    }

    public static List<Product> getRandomShip() {
        Random r = new Random();
        int x = r.nextInt(1, 7);
        return Arrays.asList(new Product[x]);
    }


    @Override
    public void run() {
//        while (Port.piers.size()!=0){
            port.loadingShip();
        }
    }


