package cryptoanalizer.util;

import cryptoanalizer.AnalyzingChar;
import cryptoanalizer.Ticket;
import cryptoanalizer.util.io.ConsoleReader;
import cryptoanalizer.view.console.MenuChoice;
import cryptoanalizer.view.console.Message;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyzer {
    private static List<Character> alphabet;
    private static final StringBuilder sample = new StringBuilder();

    private Analyzer() {
    }

    public static void run(Ticket ticket) {
        ticket.setChoice(MenuChoice.DECRYPT.getChoice());
        alphabet = ticket.getAlphabetList();
        getSample(ticket);
        List<AnalyzingChar> exampleCharList = new ArrayList<>();
        List<AnalyzingChar> encryptedCharList = new ArrayList<>();
        for (Character character : ticket.getAlphabetList()) {
            exampleCharList.add(new AnalyzingChar(character));
            encryptedCharList.add(new AnalyzingChar(character));
        }
        try (BufferedReader exampleReader = new BufferedReader(new FileReader(ticket.getExample().toFile()));
             FileReader enFileReader = new FileReader(ticket.getFilePath().toFile());
             BufferedReader encryptedReader = new BufferedReader(enFileReader)) {

            getAnalytics(encryptedCharList, encryptedReader);
            getAnalytics(exampleCharList, exampleReader);


        } catch (IOException e) {
            e.printStackTrace();
        }
        int exIndex = alphabet.indexOf(exampleCharList.get(0).getChar());
        for (AnalyzingChar aChar : encryptedCharList) {
            int anIndex = alphabet.indexOf(aChar.getChar());
            ticket.setKey(anIndex - exIndex);
            String testSample = Encryptor.runSample(ticket, sample.toString());
            Message.validateSample(testSample);
            boolean isValid = getValidation();
            if (isValid) break;
        }
        Encryptor.run(ticket);

    }

    private static void getSample(Ticket ticket) {
        try (BufferedReader br = new BufferedReader(new FileReader(ticket.getFilePath().toFile()))) {
            for (int i = 0; i < 3; i++) {
                sample.append("\n");
                sample.append(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean getValidation() {
        String answer = ConsoleReader.readText();
        if (answer.equals("yes")) {
            return true;
        } else if (answer.equals("no")) {
            return false;
        } else {
            Message.wrongChoice();
            return getValidation();
        }
    }

    private static void getAnalytics(List<AnalyzingChar> list, BufferedReader reader) throws IOException {
        while (reader.ready()) {
            char symbol = (char) reader.read();
            symbol = Character.toLowerCase(symbol);
            if (alphabet.contains(symbol)) {
                int index = alphabet.indexOf(symbol);
                list.get(index).increaseCount();
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
    }
}

