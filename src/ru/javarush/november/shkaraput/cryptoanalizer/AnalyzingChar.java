package ru.javarush.november.shkaraput.cryptoanalizer;

public class AnalyzingChar implements Comparable<AnalyzingChar> {
    private final char value;
    private int count = 0;

    public AnalyzingChar(char value) {
        this.value = value;
    }

    public char getChar() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }

    @Override
    public int compareTo(AnalyzingChar anotherAnalyzingChar) {
        return Integer.compare(this.count, anotherAnalyzingChar.count);
    }
}
