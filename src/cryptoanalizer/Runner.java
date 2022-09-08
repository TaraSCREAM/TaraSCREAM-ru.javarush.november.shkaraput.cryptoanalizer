package cryptoanalizer;

import cryptoanalizer.util.TicketMaker;
import cryptoanalizer.util.io.ConsoleReader;
import cryptoanalizer.view.console.MainMenu;
import cryptoanalizer.view.console.Message;

public class Runner {
    public static void main(String[] args) {
        Message.showStartMessage();
        MainMenu.showMenu();
        int choice = ConsoleReader.readInt();
        Ticket ticket = TicketMaker.createTicket();



    }
}
