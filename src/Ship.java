import java.util.ArrayList;
import java.util.Random;

public class Ship {

    public String name;
    public int size;
    public ArrayList<Product> compartment;

    public Ship(String name, Integer size, ArrayList<Product> compartment) {
        this.name = name;
        this.size = size;
        this.compartment = compartment;
    }

    public static Ship getRandomShip() {
        ArrayList<Product> compartment = new ArrayList<>();
        return new Ship(getRandomShipName(), getRandomSize(), compartment);
    }

    public static String getRandomShipName() {
        String[] titles = {"Москва", "Адмирал Кузнецов", "Петр Великий", "Адмирал Нахимов", "Цезарь Кунников", "Варяг",
                "Дмитрий Донской", "Маршал Устинов", "Адмирал Макаров", "Петр Моргунов", "Адмирал Григорович", "Адмирал Трибуц",
                "Адмирал Ушаков", "Самум", "Юрий Долгорукий", "Карелия", "Кореец", "Комунна", "Северодвинск", "Иван Грен"};
        Random r = new Random();
        int x = r.nextInt(titles.length);
        return titles[x];
    }

    public static int getRandomSize() {
        Random r = new Random();
        return r.nextInt(1, 10);
    }
}



