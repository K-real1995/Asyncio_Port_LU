import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Port {

    static LinkedList<Product> wareHouse = new LinkedList<>();
    static ArrayBlockingQueue<List<Product>> piers = new ArrayBlockingQueue<>(10);

    static int invoice = 0;

    public synchronized void deliveryOfGoods(){

        for (int i = 0; i < invoice ; i++){
          Product product = Product.getRandomProduct();
          wareHouse.add(product);
          System.out.println("Поставщик с товаром: " + product.title + ", прибыл и отгрузил товар на склад");
          System.out.println("Количество товаров на складе: " + wareHouse.size());
        }
    }


    public synchronized void loadingShip(){
        while (piers.size() != 0) {
            List<Product> ship = piers.poll();
            System.out.println("В порт на погрузку прибыл корабль, количество грузовых отсеков: " + ship.size());
            while (wareHouse.isEmpty() || ship.size() > wareHouse.size()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < ship.size(); i++) {
                System.out.println("Товар: " + wareHouse.getFirst().title + " погружен на корабль");
                ship.set(i, wareHouse.getFirst());
                wareHouse.remove(0);
                System.out.println("Количество товаров на складе: " + wareHouse.size());
            }

            System.out.println("Корабль загружен и готов к отплытию");
        }
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
        for (List<Product> pier : piers) {
            productCount.add(pier.size());
        }
        int sum = 0;
        for (Integer integer : productCount) {
            sum+=integer;
        }
        invoice = sum;
    }
}
