package cryptoanalizer;

import cryptoanalizer.view.console.Message;

public class CryptoAnalyzer {
    private static boolean isRunning = true;


    public static void main(String[] args) {
        Message.showStartMessage();
        while (isRunning == true) {
            Runner.run();
        }
    }
    public static void setRunning(boolean running) {
        isRunning = running;
    }
}
