package ru.javarush.november.shkaraput.cryptoanalizer.util.io;

import ru.javarush.november.shkaraput.cryptoanalizer.view.console.Message;

import java.util.Scanner;



public class ConsoleReader {
    private static Scanner console = new Scanner(System.in);
    public static String readText() {
            return console.nextLine();

    }

    private ConsoleReader() {}

    public static int readInt() {
        int result;
        try {
            result = Integer.parseInt(readText());
            return Math.abs(result);
        } catch (NumberFormatException e) {
            Message.notNumber();
            return readInt();
        }
    }
}
