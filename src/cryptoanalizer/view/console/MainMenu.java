package cryptoanalizer.view.console;

import static cryptoanalizer.view.console.MenuChoice.*;

public class MainMenu {
    private static String message = "Выберите один из пунктов меню, и введите соответствующий номер\n%s\n%s\n%s\n%s\n";
    public static void showMenu() {
        System.out.printf(message, ENCRYPT, DECRYPT, ANALISE, EXIT);
    }

}
