package programm;

import programm.helper.Init;
import programm.helper.Reception;

import java.io.IOException;

/**
 * Класс для запуска интерактивного режима взаимодействия.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Reception start = new Reception(new Init(args[0]));
        start.go();
    }
}
