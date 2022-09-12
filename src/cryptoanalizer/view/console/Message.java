package cryptoanalizer.view.console;

public class Message {

    private static final String tryAgain = "Please try again \n";
    private static final String startMessage = "Hello! Welcome to cryptoanalyzer \"CryptoBro\"";
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

    public static void done() {
        System.out.println();
    }

    public static void exit() {
        System.out.println(MenuChoice.EXIT.getProcess());
    }
}
