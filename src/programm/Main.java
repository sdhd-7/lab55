package programm;

import programm.helper.Init;
import programm.helper.Reception;

/**
 * @author Mikhail Gorbatov 336498
 */
public class Main {
    public static void main(String[] args) {
        Reception start = new Reception(new Init("C:\\Users\\adgjw\\IdeaProjects\\lab5\\data.json"));
        start.go();
    }
}
