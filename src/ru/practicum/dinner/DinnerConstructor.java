package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();
    ArrayList<String> dishesInput = new ArrayList<>();
    Random random = new Random();

    public void dishToMenu(String dishType, String dishName) {
        if (menu.containsKey(dishType)) {
            ArrayList<String> dishesSet = menu.get(dishType);
            if (dishesSet.contains(dishName)) {
                System.out.println("Данное блюдо уже присутствует в меню! Попробуйте еще раз");
                return;
            }
            dishesSet.add(dishName);
        } else {
            ArrayList<String> dishesSet = new ArrayList<>();
            dishesSet.add(dishName);
            menu.put(dishType, dishesSet);
        }
        System.out.println("В меню добавлено блюдо с типом " + dishType + " и названием " + dishName);
    }

    public void getDishCombo(int numberOfCombos, ArrayList<String> dishesInput) {
        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> randomDishes = new ArrayList<>();
            System.out.println("Комбо " + i);
            for (String dishType : dishesInput) {
                String randomDish = menu.get(dishType).get(random.nextInt(menu.get(dishType).size()));
                randomDishes.add(randomDish);
            }
            System.out.println(randomDishes);
        }
    }

    public boolean checkType(String type) {
        boolean isInMenu = false;
        for (String dishType : menu.keySet()) {
            if (type.equalsIgnoreCase(dishType)) {
                isInMenu = true;
            }
        }
        return isInMenu;
    }
}
