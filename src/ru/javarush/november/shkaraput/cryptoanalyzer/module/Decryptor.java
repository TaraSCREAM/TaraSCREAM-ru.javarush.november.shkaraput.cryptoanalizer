package ru.javarush.november.shkaraput.cryptoanalyzer.module;

import java.nio.file.Path;
import java.util.List;

public class Decryptor {
    private int key;
    private final Path filePath;
    private final Path alphabetPath;

    public Decryptor(Path filePath, Path alphabetPath, int key) {
        this.key = key;
        this.filePath = filePath;
        this.alphabetPath = alphabetPath;
    }

    public void start() {
        key = prepareDecryptionKey();
        new Encryptor(filePath, alphabetPath, key).start();
    }

    private int prepareDecryptionKey() {
        List<Character> alphabet = new AlphabetCreator().createList(alphabetPath);
        key = alphabet.size() - (key % alphabet.size());
        return key;
    }
}
