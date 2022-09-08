package cryptoanalizer.util;

public class MenuSwitcher {
    public static void makeChoice(int choice) throws InterruptedException {
        switch (choice) {
            case 1: Thread.sleep(1); break;
            case 4: Thread.sleep(1); break;
            case 2: Thread.sleep(1); break;
            case 3: Thread.sleep(1); break;
        }
    }
}
