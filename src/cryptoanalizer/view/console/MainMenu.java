package cryptoanalizer.view.console;

import static cryptoanalizer.view.console.MenuChoice.*;

public class MainMenu {
    private MainMenu() {

    }
    private static String message = "Please make your choice\n%s\n%s\n%s\n%s\n";
    public static void showMenu() {
        System.out.printf(message, ENCRYPT, DECRYPT, ANALISE, EXIT);
    }

}
