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
        ticket.setFilePath(getPath(ConsoleReader.readText(), FILEPATH));
        Message.sendToGet(ALPHABET);
        Path alphabetPath = getPath(ConsoleReader.readText(), ALPHABET);
        ticket.setAlphabetList(Reader.readToList(alphabetPath));
        if (choice != 3) {
            Message.sendToGet(KEY);
            ticket.setKey(ConsoleReader.readInt());
        } else {
            Message.sendToGet(EXAMPLE);
            ticket.setExample(getPath(ConsoleReader.readText(), EXAMPLE));

        }
        return ticket;

    }

    private static Path getPath(String filePath, Request request) {
        File file = new File(filePath);
        if (file.isFile()) {
            return Path.of(filePath);
        } else {
            Message.notExist(request);
            return getPath(ConsoleReader.readText(), request);
        }
    }

}
