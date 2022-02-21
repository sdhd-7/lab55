package programm;

import programm.helper.Init;
import programm.helper.Reception;

import java.io.IOException;

/**
 * @author Mikhail Gorbatov 336498
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Reception start = new Reception(new Init(args[0]));
        start.go();
    }
}
