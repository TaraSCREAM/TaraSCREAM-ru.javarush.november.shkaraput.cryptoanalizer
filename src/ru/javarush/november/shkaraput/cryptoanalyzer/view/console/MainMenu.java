package ru.javarush.november.shkaraput.cryptoanalyzer.view.console;

import java.util.List;

public class MainMenu {
    private final ConsolePrinter printer = ConsolePrinter.getInstance();
    private final ConsoleReader consoleReader = new ConsoleReader();


    public void printStartMessage() {
        printer.printf("Hello! Welcome to cryptoanalyzer \"CryptoBro\"\n");
    }

    public void printMainMenu() {
        List<String> menuItems = Choice.getMenuItems();
        printer.printf("Please make your choice%n");
        for (String item : menuItems) {
            printer.printf("%s%n", item);
        }
    }

    public Choice getUserChoice() {
        int userChoice = consoleReader.readInt();
        if (Choice.getNumbersOfChoice().contains(userChoice)) {
            return Choice.values()[userChoice - 1];
        } else {
            printer.printf("This is not a valid choice. Please try again%n");
            return getUserChoice();
        }
    }

    public void printResumeMessage() {
        printer.printf("Success! Your new file is located in the same directory%nPress ENTER to continue");
        consoleReader.readText();
    }

    public void printExitMessage() {
        printer.printf("Thank you for using.");
    }
}