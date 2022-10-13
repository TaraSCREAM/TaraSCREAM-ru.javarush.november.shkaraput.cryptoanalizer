package ru.javarush.november.shkaraput.cryptoanalyzer.view.console;

import java.util.ArrayList;
import java.util.List;

public enum Choice {
    ENCRYPT(1, "1. Encrypt"),
    DECRYPT(2, "2. Decrypt"),
    BRUTEFORCE(3, "3. Brute Force"),
    EXIT(4, "4. Exit");

    private final int number;
    private final String menuItem;

    Choice(int number, String menuText) {
        this.number = number;
        this.menuItem = menuText;
    }


    static List<String> getMenuItems() {
        List<String> menuItems = new ArrayList<>();
        for (int i = 0; i < Choice.values().length; i++) {
            menuItems.add(Choice.values()[i].menuItem);
        }
        return menuItems;
    }

    static List<Integer> getNumbersOfChoice(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < Choice.values().length; i++) {
            numbers.add(Choice.values()[i].number);
        }
        return numbers;
    }

}
