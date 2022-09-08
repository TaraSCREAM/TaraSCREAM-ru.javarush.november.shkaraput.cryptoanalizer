package cryptoanalizer.view.console;

public enum Request {
    FILEPATH("путь к вашему файлу"),
    ALPHABET("путь к файлу с алфавитом"),
    KEY("ключ");

    private String text;
    private Request(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

}
