package cryptoanalizer.util.io;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private Reader() {

    }

    public static List<Character> readToList(Path path) {
        List<Character> list = new ArrayList<>();
        try (java.io.FileReader reader = new java.io.FileReader(path.toFile())) {
            while (reader.ready()) {
                list.add((char) reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
