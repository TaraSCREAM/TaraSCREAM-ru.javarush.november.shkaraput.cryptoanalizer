package cryptoanalizer.util;

import cryptoanalizer.Ticket;
import cryptoanalizer.view.console.Message;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Encryptor {
    public static void run(Ticket ticket) {
        List<Character> alphabet = ticket.getAlphabetList();
        int key = encryptingKey(ticket);

        try (BufferedReader reader = new BufferedReader(new FileReader(ticket.getFilePath().toFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(createFileName(ticket)))) {

            writer.write("");

            while (reader.ready()) {
                char character = (char) reader.read();
                character = Character.toLowerCase(character);
                if (alphabet.contains(character)) {
                    int index = (alphabet.indexOf(character) + key) % alphabet.size();
                    character = alphabet.get(index);
                }

                writer.append(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Message.done(ticket.getChoice());
    }

    private static int encryptingKey(Ticket ticket) {
        int key = ticket.getKey();
        List<Character> alphabet = ticket.getAlphabetList();
        if (ticket.getChoice() == 1) {
            key = key % alphabet.size();
        } else {
            key = alphabet.size() - (key % alphabet.size());
        }
        return key;
    }

    private static File createFileName(Ticket ticket) {
        Path path = ticket.getFilePath();
        Path newPath;
        String name = path.getFileName().toString().replaceAll(".txt", "_crypted.txt");
        newPath = Path.of(path.getParent().toString(), name);
        return newPath.toFile();
    }

    public static String runSample(Ticket ticket, String sample) {
        int key = encryptingKey(ticket);
        List<Character> alphabet = ticket.getAlphabetList();
        char[] chars = sample.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Character.toLowerCase(chars[i]);
            if (alphabet.contains(chars[i])) {
                int index = (alphabet.indexOf(chars[i]) + key) % alphabet.size();
                chars[i] = alphabet.get(index);
            }
        }

        return new String(chars);
    }
}
