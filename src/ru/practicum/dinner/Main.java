package ru.practicum.dinner;

import java.util.Scanner;

public class Main {
    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("-".repeat(20));
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.dishToMenu(dishType, dishName);
    }

    private static void generateDishCombo() {
        if(dc.menu.isEmpty()){
            System.out.println("На данный момент не добавлено ни одного блюда!");
            return;
        }
        dc.dishesInput.clear();

        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos;

        try {
            numberOfCombos = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Введите целое число!");
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                dc.dishesInput.add(nextItem);
            } else {
                System.out.println("Такого типа блюд пока нет! Попробуйте еще раз");
                return;
            }
            nextItem = scanner.nextLine();
        }
        System.out.println("Будем генерировать комбо-обеды из следующих типов блюд: " + dc.dishesInput);
        dc.getDishCombo(numberOfCombos, dc.dishesInput);
    }
}
