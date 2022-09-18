package ru.javarush.november.shkaraput.cryptoanalizer.util;

import ru.javarush.november.shkaraput.cryptoanalizer.util.io.Reader;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AlphabetCreator {

    private AlphabetCreator() {}

    public static List<Character> create(Path path) {
        return Reader.readToList(path);
    }

    public static List<Character> createCryptoAlphabet(List<Character> alphabet, int key, int choice) {
        List<Character> cryptoAlphabet = new ArrayList<>(alphabet.size());
        for (int i = 0; i < alphabet.size(); i++) {
            int index;
            if (choice == 1) {
                index = (i + key % alphabet.size()) % alphabet.size();
            } else {
                index = (i - key % alphabet.size()) % alphabet.size();
            }
            Character ch = alphabet.get(index);
            cryptoAlphabet.add(ch);
        }
        return cryptoAlphabet;
    }

}
