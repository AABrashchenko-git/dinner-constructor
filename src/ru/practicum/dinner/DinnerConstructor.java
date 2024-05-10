package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();

    ArrayList<String> dishesInput = new ArrayList<>();
    Random random = new Random();

    public void showMenu(){
        if(menu.isEmpty()){
            System.out.println("На данный момент не добавлено ни одного блюда!");
        } else {
            System.out.println(menu);
        }
    }

    public void dishToMenu(String dishType, String dishName) {
        if (menu.containsKey(dishType)) {
            ArrayList<String> dishesSet = menu.get(dishType);
            dishesSet.add(dishName);
        } else {
            ArrayList<String> dishesSet = new ArrayList<>();
            dishesSet.add(dishName);
            menu.put(dishType, dishesSet);
        }


        System.out.println(menu);
    }

    public void getDishCombo(int numberOfCombos, ArrayList<String> dishInput) {
        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> randomDishes = new ArrayList<>();
            System.out.println("Комбо " + i);
            for (String dishType : dishInput) {
                String randomDish = menu.get(dishType).get(random.nextInt(dishesInput.size()));
                randomDishes.add(randomDish);
            }
            System.out.println(dishesInput);
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
