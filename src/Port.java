import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Port {

    static LinkedList<Product> wareHouse = new LinkedList<>();
    static ArrayBlockingQueue<Ship> piers = new ArrayBlockingQueue<>(10);

    static int invoice = 0;
    Ship ship;

    public synchronized void deliveryOfGoods(){
        for (int i = 0; i < invoice ; i++) {
            Product product = Product.getRandomProduct();
            wareHouse.add(product);
            System.out.println("Поставщик с товаром: " + product.title + ", прибыл и отгрузил товар на склад");
            System.out.println("Количество товаров на складе: " + wareHouse.size());
            notify();
        }
        notify();
    }


    public synchronized void loadingShip() throws InterruptedException {

        while (wareHouse.isEmpty() | ship.size == ship.compartment.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        for (int i = 0; i < ship.size; i++) {
            System.out.println("Товар: " + wareHouse.get(0).title + " погружен на корабль");
            ship.compartment.add(wareHouse.poll());
            System.out.println("Количество товаров на складе: " + wareHouse.size());

        }
        System.out.println("Корабль " + ship.name + " загружен и готов к отплытию");
        notify();

    }



    public synchronized void getShip() {
        ship = piers.poll();
        System.out.println("В порт на погрузку прибыл корабль " + ship.name + " количество грузовых отсеков: " + ship.size);
        notify();
        while (ship.size != ship.compartment.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
    }


    public static void loadingPort(){
        Random r = new Random();
        int x = r.nextInt(1,10);
        for (int i = 0; i < x; i++) {
            piers.add(Ship.getRandomShip());
        }
    }

    public static void productCount(){
        ArrayList<Integer> productCount = new ArrayList<>();
        for (Ship pier : piers) {
            productCount.add(pier.size);
        }
        int sum = 0;
        for (Integer integer : productCount) {
            sum+=integer;
        }
        invoice = sum;
    }
}
