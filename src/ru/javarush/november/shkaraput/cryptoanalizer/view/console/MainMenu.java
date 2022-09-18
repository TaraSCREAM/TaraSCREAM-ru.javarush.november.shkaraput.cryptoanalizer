package ru.javarush.november.shkaraput.cryptoanalizer.view.console;

import static ru.javarush.november.shkaraput.cryptoanalizer.view.console.MenuChoice.*;
import static ru.javarush.november.shkaraput.cryptoanalizer.view.console.Message.printf;

public class MainMenu {
    private MainMenu() {}
    private static String message = "Please make your choice\n%s\n%s\n%s\n%s\n";
    public static void showMenu() {
        printf(message, ENCRYPT, DECRYPT, ANALISE, EXIT);
    }
}
