public class Run {
    public static void main(String[] args){
        System.out.println("Рабочий день в порту начался!");
        Port.loadingPort();
        Port.productCount();
        System.out.println("Количество кораблей на сегодняшней погрузке: " + Port.piers.size());
        Port port = new Port();
        Producer producer = new Producer(port);
        Ship ship = new Ship(port);
        new Thread(producer).start();
        new Thread(ship).start();
    }
}
