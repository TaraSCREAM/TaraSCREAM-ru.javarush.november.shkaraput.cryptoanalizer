package cryptoanalizer.view.console;

import cryptoanalizer.util.io.ConsoleReader;

public class Message {


    private static final String tryAgain = "Please try again \n";
    private static final String startMessage = "Hello! Welcome to cryptoanalyzer \"CryptoBro\"";

    private Message() {

    }

    public static void sendToGet(Request request) {
        System.out.printf("Please, input %s%n", request);
    }

    public static void showStartMessage() {
        System.out.println(startMessage);
    }

    public static void notNumber() {
        System.out.printf("This is not a number. %s", tryAgain);
    }

    public static void notExist(Request request) {
        System.out.printf("Can't find the %s%n %s", request, tryAgain);
    }

    public static void wrongChoice() {
        System.out.printf("This is not a valid choice. %s", tryAgain);
    }

    public static void done(int choice) {
        String process = MenuChoice.values()[choice - 1].getProcess();
        System.out.printf("%s is successfully complete. Press Enter to continue.%n", process);
        ConsoleReader.readText();
    }


    public static void exit() {
        System.out.println(MenuChoice.EXIT.getProcess());
    }

    public static void validateSample(String sample) {
        System.out.printf("Please look at following sample:%n%s...%nIs it correct& (yes/no)%n", sample);
    }
}
