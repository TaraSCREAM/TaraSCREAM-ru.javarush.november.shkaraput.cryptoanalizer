package ru.javarush.november.shkaraput.cryptoanalyzer.module;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Encryptor {
    private final int key;
    private final Path filePath;
    private final Path alphabetPath;
    private final Path destinationPath;

    public Encryptor(Path filePath, Path alphabetPath, int key) {
        this.key = key;
        this.filePath = filePath;
        this.alphabetPath = alphabetPath;
        this.destinationPath = createDestPath();
    }

    public void start() {
        List<Character> alphabet = new AlphabetCreator().createList(alphabetPath);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath.toFile()))) {
            writer.write("");
            while (reader.ready()) {
                Character character = (char) reader.read();
                boolean isUpperCase = Character.isUpperCase(character);
                character = Character.toLowerCase(character);
                if (alphabet.contains(character)) {
                    int index = (alphabet.indexOf(character) + key) % alphabet.size();
                    character = alphabet.get(index);
                }
                if (isUpperCase) {
                    character = Character.toUpperCase(character);
                }
                writer.append(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Path createDestPath() {
        Path path = filePath;
        Path destPath;
        String name = path.getFileName().toString().replaceAll(".txt", "_crypted.txt");
        destPath = Path.of(path.getParent().toString(), name);
        return destPath;
    }
}
