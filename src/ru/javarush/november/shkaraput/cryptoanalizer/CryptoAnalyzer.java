package ru.javarush.november.shkaraput.cryptoanalizer;

import ru.javarush.november.shkaraput.cryptoanalizer.view.console.Message;

public class CryptoAnalyzer {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        Message.showStartMessage();
        while (isRunning) {
            Runner.run();
        }
        Message.exit();
    }
    public static void setRunning(boolean running) {
        isRunning = running;
    }
}