package cryptoanalizer.view.console;

public enum Request {
    FILEPATH("path to your file"),
    ALPHABET("path to your alphabet.txt file"),
    KEY("key");

    private String text;
    private Request(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

}
