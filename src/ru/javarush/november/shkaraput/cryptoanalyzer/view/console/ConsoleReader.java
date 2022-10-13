package ru.javarush.november.shkaraput.cryptoanalyzer.view.console;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner console = new Scanner(System.in);
    private final ConsolePrinter printer = ConsolePrinter.getInstance();



    String readText() {
        return console.nextLine();
    }

    int readInt() {
        int result;
        try {
            result = Integer.parseInt(readText());
            return Math.abs(result);
        } catch (NumberFormatException e) {
            printer.printf("This is not a number. Please try again%n");
            return readInt();
        }
    }
}
