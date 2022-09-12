package cryptoanalizer.util;

import cryptoanalizer.Ticket;
import cryptoanalizer.util.io.ConsoleReader;
import cryptoanalizer.util.io.Reader;
import cryptoanalizer.view.console.Message;
import cryptoanalizer.view.console.Request;

import java.io.File;
import java.nio.file.Path;



import static cryptoanalizer.view.console.Request.*;

public class TicketMaker {

    private TicketMaker() {

    }

    public static Ticket createTicket(int choice) {
        Ticket ticket = new Ticket();
        ticket.setChoice(choice);
        Message.sendToGet(FILEPATH);
        ticket.setFilePath(existingPath(ConsoleReader.readText(), FILEPATH));
        Message.sendToGet(ALPHABET);
        Path alphabetPath = existingPath(ConsoleReader.readText(), ALPHABET);
        ticket.setAlphabetList(Reader.readAlphabet(alphabetPath));
        Message.sendToGet(KEY);
        ticket.setKey(ConsoleReader.readInt());
        return ticket;

    }

    private static Path existingPath(String filePath, Request request) {
        File file = new File(filePath);
        if (file.isFile()) {
            return Path.of(filePath);
        } else {
            Message.notExist(request);
            return existingPath(ConsoleReader.readText(), request);
        }
    }

}
