import java.util.Random;

public class Product {
    public String title;
    public String shipFrom;
    public int count;
    public int price;


    public Product(String title, String shipFrom, int count, int price){
        this.title = title;
        this.shipFrom = shipFrom;
        this.count = count;
        this.price = price;
    }

    public static Product getRandomProduct(){
        return new Product(getRandomTitle(),getRandomCountry(),getRandomCount(),getRandomPrice());
    }


    public static String getRandomTitle(){
        String[] titles = {"рис", "мука", "сахар","яблоки","мандарины","апельсины","огурцы","помидоры","пиво","вино","водка",
        "шампиньоны","колбаса","мясо","шоколад","сыр","груши","цветы","мёд","одежда","обувь","аксессуары","автомобили",
        "бытовая химия","мебель","игрушки","спортивные товары","музыкальные товары","бытовая электроника","компьютерная техника"};
        Random r = new Random();
        int x = r.nextInt(titles.length);
        return titles[x];
    }

    public static String getRandomCountry(){
        String[] country = {"Аргентина","Бразилия","Нидерланды","Чили","Куба","Доминикана","Пуэрто-Рико","Италия","Франция",
        "Испания","Венесуэла","Австралия","Новая Зеландия","Китай","Тайвань","ОАЭ","Катар","Турция","Исландия","Финляндия",
        "Норвегия","Швеция","Юар","Мадагаскар","Сомали","Тунис","Занзибар","США","Канада","Мексика","Ирлания","Англия","Шотландия"};
        Random r = new Random();
        int x = r.nextInt(country.length);
        return country[x];
    }


    public static int getRandomCount(){
        Random r = new Random();
        return r.nextInt(100);
    }

    public static int getRandomPrice(){
        Random r = new Random();
        return r.nextInt(100);
    }
}
