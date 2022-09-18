package ru.javarush.november.shkaraput.cryptoanalizer.view.console;

public enum Request {
    FILEPATH("path to your file"),
    ALPHABET("path to your alphabet.txt file"),
    KEY("key"), 
    EXAMPLE("path to your example file.\nIt needs for analyzing");

    private String text;
    private Request(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
