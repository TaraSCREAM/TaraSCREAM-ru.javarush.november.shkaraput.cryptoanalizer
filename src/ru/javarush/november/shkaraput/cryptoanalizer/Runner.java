package ru.javarush.november.shkaraput.cryptoanalizer;

import ru.javarush.november.shkaraput.cryptoanalizer.util.TicketMaker;
import ru.javarush.november.shkaraput.cryptoanalizer.util.io.ConsoleReader;
import ru.javarush.november.shkaraput.cryptoanalizer.view.console.MainMenu;
import ru.javarush.november.shkaraput.cryptoanalizer.view.console.Message;

public class Runner {
    private Runner() {}

    public static void run() {
        MainMenu.showMenu();
        int choice = setChoice();
        if (choice == 4) {
            CryptoAnalyzer.setRunning(false);
            return;
        }
        Ticket ticket = TicketMaker.createTicket(choice);
        if (choice != 3) {
            ticket.encrypt();
        } else {
            ticket.analyze();
        }
    }

    private static int setChoice() {
        int choice = ConsoleReader.readInt();
        if (choice > 0 && choice < 5) {
            return choice;
        } else {
            Message.wrongChoice();
            return setChoice();
        }
    }
}
