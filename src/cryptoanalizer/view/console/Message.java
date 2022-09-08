package cryptoanalizer.view.console;

public class Message {
    private static String startMessage = "Привет! Добро пожаловать в Криптоанализатор \"КриптоБро\"";
    public static void sendToGet(Request request) {
        System.out.printf("Пожалуйста, укажите %s\n", request);
    }
    public static void showStartMessage() {
        System.out.println(startMessage);
    }

    public static void notNumber() {
        System.out.println("Введено не число. Попробуйте еще раз");
    }

    public static void notExist(Request request) {
        System.out.printf("Не найден %s\nПопробуйте еще раз\n", request);
    }
}
