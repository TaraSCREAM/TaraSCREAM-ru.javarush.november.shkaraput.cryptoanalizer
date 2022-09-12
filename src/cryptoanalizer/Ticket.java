package cryptoanalizer;

import cryptoanalizer.util.Encryptor;

import java.nio.file.Path;
import java.util.List;

public class Ticket {
    private int choice;
    private Path filePath;
    private List<Character> alphabetList;

    private int key;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public Path getFilePath() {
        return filePath;
    }


    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public List<Character> getAlphabetList() {
        return alphabetList;
    }

    public void setAlphabetList(List<Character> alphabetList) {
        this.alphabetList = alphabetList;
    }




    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void encrypt() {
        Encryptor.run(this);
    }
}
