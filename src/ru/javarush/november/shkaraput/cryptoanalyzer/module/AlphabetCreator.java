package ru.javarush.november.shkaraput.cryptoanalyzer.module;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class AlphabetCreator {
    List<Character> createList(Path alphabetPath) {
        List<Character> characterList = new ArrayList<>();
        try (FileReader reader = new FileReader(alphabetPath.toFile())) {
            while (reader.ready()) {
                characterList.add((char) reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterList;
    }

    Map<Character, Integer> createMap(List<Character> alphabet) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (Character character : alphabet) {
            characterMap.put(character, 0);
        }
        return characterMap;
    }

}


