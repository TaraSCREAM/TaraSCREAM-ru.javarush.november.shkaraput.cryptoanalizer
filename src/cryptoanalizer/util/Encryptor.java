package cryptoanalizer.util;

import cryptoanalizer.Ticket;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.List;

public class Encryptor {
    public static void run(Ticket ticket) {
        List<Character> alphabet = ticket.getAlphabetList();
        int key = encryptingKey(ticket);
        /*
            read part of file
            encrypting
            write to new file
        */
        //reading
        try (BufferedReader reader = new BufferedReader(new FileReader(ticket.getFilePath().toFile()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(writableFile(ticket)))) {
            while (reader.ready()) {

                //encrypting
                char character = (char) reader.read();

                if (alphabet.contains(character)) {
                    int index = (alphabet.indexOf(character) + key) % alphabet.size();
                    character = index != -1 ? alphabet.get(index) : alphabet.get(alphabet.size() + index);
                }
                writer.append(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DONE");
    }

    private static int encryptingKey(Ticket ticket) {
        int key = ticket.getKey();
        List<Character> alphabet = ticket.getAlphabetList();
        if (ticket.getChoice() == 1) {
            key = key % alphabet.size();
        } else {
            key = (key % alphabet.size()) * -1;
        }
        return key;
    }

    private static File writableFile(Ticket ticket) {
        Path path = ticket.getFilePath();
        Path newPath;
        String name = path.getFileName().toString().replaceAll(".txt", "_processed.txt");
        newPath = Path.of(path.getParent().toString(), name);
        return newPath.toFile();
    }

}
