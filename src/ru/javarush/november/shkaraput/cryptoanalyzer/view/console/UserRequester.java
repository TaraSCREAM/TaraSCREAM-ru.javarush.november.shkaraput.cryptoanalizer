package ru.javarush.november.shkaraput.cryptoanalyzer.view.console;

import java.io.File;
import java.nio.file.Path;

public class UserRequester {
    private final Path defaultExample = Path.of("files/EN_example.txt");
    private final Path defaultAlphabet = Path.of("files/EN_alphabet.txt");
    private final ConsolePrinter printer = ConsolePrinter.getInstance();
    private final ConsoleReader consoleReader = new ConsoleReader();

    public Path getFilePath() {
        printer.printf("Please, input correct path to your txt file%n");
        return getPath(consoleReader.readText());
    }

    public Path getAlphabetPath() {
        printer.printf("Please, input correct path to your alphabet file%nor press ENTER to use default (English)%n");
        String pathname = consoleReader.readText();
        if (pathname.equals("")){
            return defaultAlphabet;
        }
        return getPath(pathname);
    }

    private Path getPath(String pathname) {
        File file = new File(pathname);
        if (file.isFile()) {
            return Path.of(pathname);
        } else {
            printer.printf("Can't find the file. Please input path again%n");
            return getPath(consoleReader.readText());
        }
    }

    public int getKey() {
        printer.printf("Please, input an integer key%n");
        return consoleReader.readInt();
    }

    public Path getExamplePath() {
        printer.printf("You can upload some txt file with text of the same author to increase Brute Force accuracy.%n");
        printer.printf("Please input an example file path or press ENTER to use default (English)%n");
        String pathname = consoleReader.readText();
        if (pathname.equals("")){
            return defaultExample;
        }
        return getPath(pathname);
    }

    public boolean getIsCorrect(String sample) {
        printer.printf("Please look at the following sample%n*****%n%s...%n*****%nIs it correct? (yes/no)%n", sample);
        String answer = consoleReader.readText().toLowerCase();
        if (answer.equals("yes")) {
            return true;
        } else if (answer.equals("no")) {
            return false;
        } else {
            printer.printf("This is not a valid answer. Try again%n");
            return getIsCorrect(sample);
        }
    }
}
