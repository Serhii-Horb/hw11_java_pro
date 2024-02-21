package org.example.Ex1;
/* Вы автоматизируете бизнес риелторов. у вас есть класс:
public class House {
    int area; //площадь дома
    int price; // цена
    String city; // город
    boolean hasFurniture; //продается с мебелью
}
По умолчанию в вашем информационном хранилище дома сортируются по цене.
Но иногда клиент хочет видеть информацию о домах в конкретном городе и осортированную по цене.
Реализуйте компаратор, который вы можете применить для показа клиенту в требуемом им формате.
А если клиенту неожиданно захочет увидеть информацию, отсортированную в формате:
"город - площадь дома", что вы будете делать?*/
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class House implements Comparable<House> {
    private int area; //площадь дома
    private int price; // цена
    private String city; // город
    private boolean hasFurniture; //продается с мебелью

    public House(int area, int price, String city, boolean hasFurniture) {
        this.area = area;
        this.price = price;
        this.city = city;
        this.hasFurniture = hasFurniture;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isHasFurniture() {
        return hasFurniture;
    }

    public void setHasFurniture(boolean hasFurniture) {
        this.hasFurniture = hasFurniture;
    }

    @Override
    public String toString() {
        return "House {" +
                "area = " + area +
                ", price = " + price +
                ", city = '" + city + '\'' +
                ", hasFurniture = " + hasFurniture +
                '}';
    }

//    @Override
//    public int compare(House o1, House o2) {
//        int result = o1.getPrice() - o2.getPrice();
//        if (o1.getPrice() - o2.getPrice() == 0) {return 0;}
//        return result < 0 ? -1 : 1;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        if (area != house.area) return false;
        if (price != house.price) return false;
        if (hasFurniture != house.hasFurniture) return false;
        return Objects.equals(city, house.city);
    }

    @Override
    public int hashCode() {
        int result = area;
        result = 31 * result + price;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (hasFurniture ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(House o) {
        return Integer.compare(this.getPrice(), o.getPrice());
    }


}
