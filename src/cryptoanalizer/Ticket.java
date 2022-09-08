package cryptoanalizer;

import java.nio.file.Path;
import java.util.List;

public class Ticket {
    private Path filePath;

    private int key;

    public Path getFilePath() {
        return filePath;
    }

    private List<Character> alphabetList;

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
}
