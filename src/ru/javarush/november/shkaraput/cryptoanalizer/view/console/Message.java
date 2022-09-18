package ru.javarush.november.shkaraput.cryptoanalizer.view.console;

import ru.javarush.november.shkaraput.cryptoanalizer.util.io.ConsoleReader;

public class Message {


    private static final String tryAgain = "Please try again \n";
    private static final String startMessage = "Hello! Welcome to cryptoanalyzer \"CryptoBro\"\n";

    private Message() {}

    public static void sendToGet(Request request) {
        printf("Please, input %s%n", request);
    }

    public static void showStartMessage() {
        printf(startMessage);
    }

    public static void notNumber() {
        printf("This is not a number. %s", tryAgain);
    }

    public static void notExist(Request request) {
        printf("Can't find the %s%n %s", request, tryAgain);
    }

    public static void wrongChoice() {
        printf("This is not a valid choice. %s", tryAgain);
    }

    public static void done(int choice) {
        String process = MenuChoice.values()[choice - 1].getProcess();
        printf("%s is successfully complete. Press Enter to continue.%n", process);
        ConsoleReader.readText();
    }

    public static void exit() {
        printf(MenuChoice.EXIT.getProcess());
    }

    public static void validateSample(String sample) {
        printf("Please look at following sample:%n%s...%nIs it correct& (yes/no)%n", sample);
    }

    protected static void printf(String message) {
        printf(message, "");
    }

    @SuppressWarnings("java:S106")
    protected static void printf(String message, Object... args) {
        System.out.printf(message, args);
    }
}
