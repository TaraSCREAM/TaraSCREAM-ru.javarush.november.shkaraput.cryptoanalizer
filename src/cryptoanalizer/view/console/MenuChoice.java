package cryptoanalizer.view.console;

public enum MenuChoice {
    ENCRYPT(1, "1. Encrypt"),
    DECRYPT(2, "2. Decrypt"),
    ANALISE(3, "3. Analyze"),
    EXIT(4, "4. Exit");

    private int number;
    private String item;

    MenuChoice(int number, String item) {
        this.number = number;
        this.item = item;
    }

    public int getChoice() {
        return number;
    }

    @Override
    public String toString() {
        return this.item;
    }
}
