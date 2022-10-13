package ru.javarush.november.shkaraput.cryptoanalyzer.module;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;


public class BruteForce {
    private final Path filePath;
    private final Path examplePath;
    private final List<Character> alphabet;
    private List<Character> sortedFileAlphabet;
    private List<Character> sortedExampleAlphabet;

    public BruteForce(Path filePath, Path alphabetPath, Path examplePath) {
        this.filePath = filePath;
        this.alphabet = new AlphabetCreator().createList(alphabetPath);
        this.examplePath = examplePath;
    }

    public void start() {
        sortedFileAlphabet = sortByStatistic(filePath);
        sortedExampleAlphabet = sortByStatistic(examplePath);
    }

    public int getDelta() {
        int idTopChar = alphabet.indexOf(sortedExampleAlphabet.get(0));
        int idCheckingChar = alphabet.indexOf(sortedFileAlphabet.get(0));
        int delta = (idCheckingChar - idTopChar);
        if (delta < 0) {
            delta += alphabet.size();
        }
        sortedFileAlphabet.remove(0);
        return delta;
    }

    public String getSampleByDelta(int delta) {
        delta = alphabet.size() - (delta % alphabet.size());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            for (int i = 0; i < 100; i++) {
                char symbol = (char) reader.read();
                boolean isUpperCase = Character.isUpperCase(symbol);
                symbol = Character.toLowerCase(symbol);
                if (alphabet.contains(symbol)) {
                    int index = (alphabet.indexOf(symbol) + delta) % alphabet.size();
                    symbol = alphabet.get(index);
                }
                builder.append(isUpperCase ? Character.toUpperCase(symbol) : symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private List<Character> sortByStatistic(Path path) {
        Map<Character, Integer> collector = new AlphabetCreator().createMap(alphabet);
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            while (reader.ready()) {
                char symbol = (char) reader.read();
                symbol = Character.toLowerCase(symbol);
                if (collector.containsKey(symbol)) {
                    collector.computeIfPresent(symbol, (k, v) -> v + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<Character, Integer>> statList = new ArrayList<>(collector.entrySet());
        statList.sort(Map.Entry.comparingByValue());
        Collections.reverse(statList);

        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : statList) {
            result.add(entry.getKey());
        }

        return result;
    }
}
