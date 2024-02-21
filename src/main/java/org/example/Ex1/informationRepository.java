package org.example.Ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class informationRepository {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
        House house1 = new House(55, 70, "Днепр", true);
        House house2 = new House(95, 90, "Днепр", true);
        House house3 = new House(70, 35, "Кривой Рог", false);
        House house4 = new House(75, 40, "Кривой Рог", false);
        House house5 = new House(150, 250, "Киев", true);
        House house6 = new House(137, 200, "Киев", true);
        House house7 = new House(140, 170, "Одесса", false);
        House house8 = new House(84, 77, "Одесса", false);
        House house9 = new House(120, 140, "Львов", true);
        House house10 = new House(100, 100, "Львов", true);
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        houses.add(house4);
        houses.add(house5);
        houses.add(house6);
        houses.add(house7);
        houses.add(house8);
        houses.add(house9);
        houses.add(house10);
        System.out.println(houses);

        Collections.sort(houses);
        System.out.println(houses);

        // Реализуйте компаратор, который вы можете применить для показа клиенту в требуемом им формате.
        Comparator<House> houseComparatorByPrise = new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        };

        // Но иногда клиент хочет видеть информацию о домах в конкретном городе и отсортированную по цене.
        List<House> sortByCity = infoByCity("Киев", houses);
        Collections.sort(sortByCity, houseComparatorByPrise);
        System.out.println(sortByCity);

        Comparator<House> houseComparatorByArea = new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                return Integer.compare(o1.getArea(), o2.getArea());
            }
        };

        Comparator<House> houseComparatorByCity = new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        };

        Comparator<House> houseComparatorByHasFurniture = new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                return Boolean.compare(o1.isHasFurniture(), o2.isHasFurniture());
            }
        };

        // А если клиенту неожиданно захочет увидеть информацию, отсортированную в формате:
        // "город - площадь дома", что вы будете делать?
        Comparator<House> houseComparatorByCityAndArea = new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                int result = o1.getCity().compareTo(o2.getCity());
                if (result == 0) {
                    result = Integer.compare(o1.getArea(), o2.getArea());
                }
                return result;
            }
        };

    }

    public static List<House> infoByCity(String city, List<House> houses) {
        List<House> selectedHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++) {
            if (city.equals(houses.get(i).getCity())) {
                selectedHouses.add(houses.get(i));
            }
        }
        return selectedHouses;
    }
}