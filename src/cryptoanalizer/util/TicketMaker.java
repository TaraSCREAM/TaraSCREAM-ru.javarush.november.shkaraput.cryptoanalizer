package cryptoanalizer.util;

import cryptoanalizer.Ticket;
import cryptoanalizer.util.io.ConsoleReader;
import cryptoanalizer.view.console.Message;
import cryptoanalizer.view.console.Request;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import static cryptoanalizer.view.console.Request.*;

public class TicketMaker {

    public static Ticket createTicket() {
        Ticket ticket = new Ticket();
        Message.sendToGet(FILEPATH);
        ticket.setFilePath(existingPath(ConsoleReader.readText(), FILEPATH));
        Message.sendToGet(ALPHABET);
        ticket.setAlphabetList(createAlphabet());
        Message.sendToGet(KEY);
        ticket.setKey(ConsoleReader.readInt());
        return ticket;

    }

    private static Path existingPath(String filePath, Request request) {
        File file = new File(filePath);
        if (file.exists()) {
            return Path.of(filePath);
        } else {
            Message.notExist(request);
            return existingPath(ConsoleReader.readText(), request);
        }
    }

    private static List<Character> createAlphabet() {
        Message.sendToGet(ALPHABET);
        Path path = existingPath(ConsoleReader.readText(), ALPHABET);
        return null;

    }
}
