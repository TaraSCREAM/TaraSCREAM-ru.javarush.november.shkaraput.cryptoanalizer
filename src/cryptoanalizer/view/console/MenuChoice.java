package cryptoanalizer.view.console;

public enum MenuChoice {
    ENCRYPT(1, "1. Зашифровка данных"),
    DECRYPT(2, "2. Расшифровка данных"),
    ANALISE(3, "3. Анализ"),
    EXIT(4, "4. Выход");

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
