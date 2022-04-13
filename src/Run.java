public class Run {
    public static void main(String[] args) {
        System.out.println("Рабочий день в порту начался!");
        Port.loadingPort();
        Port.productCount();
        System.out.println(Port.invoice);
        System.out.println("Количество кораблей на сегодняшней погрузке: " + Port.piers.size());
        Port port = new Port();
        Producer producer = new Producer(port);
        Crane crane = new Crane(port);
        GetShip ship = new GetShip(port);
        new Thread(ship).start();
        new Thread(producer).start();
        new Thread(crane).start();

    }
}
