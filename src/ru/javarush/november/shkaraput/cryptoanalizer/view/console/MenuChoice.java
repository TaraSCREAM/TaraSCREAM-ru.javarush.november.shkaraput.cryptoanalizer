package ru.javarush.november.shkaraput.cryptoanalizer.view.console;

public enum MenuChoice {
    ENCRYPT(1, "1. Encrypt", "Encrypting"),
    DECRYPT(2, "2. Decrypt", "Decrypting"),
    ANALISE(3, "3. Analyze", "Analyzing"),
    EXIT(4, "4. Exit","Thank you for using.");

    private int number;
    private String item;
    private String process;

    MenuChoice(int number, String item, String process) {
        this.number = number;
        this.item = item;
        this.process = process;
    }

    public int getChoice() {
        return number;
    }

    public String getProcess() {
        return process;
    }

    @Override
    public String toString() {
        return this.item;
    }
}
