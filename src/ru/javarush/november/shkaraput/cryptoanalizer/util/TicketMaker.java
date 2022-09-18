package ru.javarush.november.shkaraput.cryptoanalizer.util;

import ru.javarush.november.shkaraput.cryptoanalizer.Ticket;
import ru.javarush.november.shkaraput.cryptoanalizer.util.io.ConsoleReader;
import ru.javarush.november.shkaraput.cryptoanalizer.util.io.Reader;
import ru.javarush.november.shkaraput.cryptoanalizer.view.console.Message;
import ru.javarush.november.shkaraput.cryptoanalizer.view.console.Request;

import java.io.File;
import java.nio.file.Path;

public class TicketMaker {

    private TicketMaker() {}

    public static Ticket createTicket(int choice) {
        Ticket ticket = new Ticket();
        ticket.setChoice(choice);
        Message.sendToGet(Request.FILEPATH);
        ticket.setFilePath(getPath(ConsoleReader.readText(), Request.FILEPATH));
        Message.sendToGet(Request.ALPHABET);
        Path alphabetPath = getPath(ConsoleReader.readText(), Request.ALPHABET);
        ticket.setAlphabetList(Reader.readToList(alphabetPath));
        if (choice != 3) {
            Message.sendToGet(Request.KEY);
            ticket.setKey(ConsoleReader.readInt());
        } else {
            Message.sendToGet(Request.EXAMPLE);
            ticket.setExample(getPath(ConsoleReader.readText(), Request.EXAMPLE));
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
