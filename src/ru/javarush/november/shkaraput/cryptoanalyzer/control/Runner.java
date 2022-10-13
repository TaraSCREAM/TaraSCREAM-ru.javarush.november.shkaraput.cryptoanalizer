package ru.javarush.november.shkaraput.cryptoanalyzer.control;

import ru.javarush.november.shkaraput.cryptoanalyzer.module.*;
import ru.javarush.november.shkaraput.cryptoanalyzer.view.console.*;


import java.nio.file.Path;

public class Runner {
    MainMenu menu = new MainMenu();
    UserRequester requester = new UserRequester();

    public void run() {
        menu.printStartMessage();
        boolean isRunning = true;
        while (isRunning) {
            menu.printMainMenu();
            Choice userChoice = menu.getUserChoice();
            switch (userChoice) {
                case ENCRYPT:
                    encrypt();
                    break;
                case DECRYPT:
                    decrypt();
                    break;
                case BRUTEFORCE:
                    bruteforce();
                    break;
                case EXIT:
                    menu.printExitMessage();
                    isRunning = false;
                    break;
            }
        }
    }

    private void encrypt() {
        Path filePath = requester.getFilePath();
        Path alphabetPath = requester.getAlphabetPath();
        int key = requester.getKey();
        Encryptor encryptor = new Encryptor(filePath, alphabetPath, key);
        encryptor.start();
        menu.printResumeMessage();
    }

    private void decrypt() {
        Path filePath = requester.getFilePath();
        Path alphabetPath = requester.getAlphabetPath();
        int key = requester.getKey();
        Decryptor decryptor = new Decryptor(filePath, alphabetPath, key);
        decryptor.start();
        menu.printResumeMessage();
    }

    private void bruteforce() {
        Path filePath = requester.getFilePath();
        Path alphabetPath = requester.getAlphabetPath();
        Path examplePath = requester.getExamplePath();
        BruteForce bF = new BruteForce(filePath, alphabetPath, examplePath);
        bF.start();
        boolean isCorrect = false;
        while (!isCorrect) {
            int delta = bF.getDelta();
            String sample = bF.getSampleByDelta(delta);
            isCorrect = requester.getIsCorrect(sample);
            if (isCorrect) {
                new Decryptor(filePath, alphabetPath, delta).start();
            }
        }
        menu.printResumeMessage();
    }
}