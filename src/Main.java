import defoult.SpaceMarine;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String filename;
        Map<Integer, SpaceMarine> kek = new TreeMap<Integer, SpaceMarine>();
        kek.put(123, new SpaceMarine());
        Scanner scanner = new Scanner(System.in);
        String s;
        s = scanner.nextLine();
        while (!Objects.equals(s, "exit")) {

            String[] curr = s.split(" ");
            switch (curr[0]) {
                case ("insert"):
                    Integer id = Integer.getInteger(curr[1]);
                    SpaceMarine temp = new SpaceMarine();


            }

            s = scanner.nextLine();
        }

    }
}
