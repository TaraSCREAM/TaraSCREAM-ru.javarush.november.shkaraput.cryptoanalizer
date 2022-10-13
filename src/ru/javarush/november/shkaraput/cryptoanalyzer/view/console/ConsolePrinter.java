package ru.javarush.november.shkaraput.cryptoanalyzer.view.console;

public class ConsolePrinter {
    private static final ConsolePrinter INSTANCE = new ConsolePrinter();

    private ConsolePrinter() {}

    static ConsolePrinter getInstance() {
        return INSTANCE;
    }

    void printf(String message) {
        printf(message, "");
    }

    @SuppressWarnings("java:S106")
    void printf(String message, Object... args) {
        System.out.printf(message, args);
    }
}
