import defaults.Coordinates;
import defaults.Dragon;
import defaults.DragonType;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Dragon> current = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String s;
        s = scanner.nextLine();
        while (!s.equals("exit")) {

            String[] curr = s.split(" ");
            switch (curr[0]) {
                case ("add"):
                    Integer id = Integer.parseInt(curr[1]);

                    //создание нового объекта
                    Dragon temp = new Dragon();

                    //присвоение имени дракона
                    String tmp;
                    System.out.println("Введите имя дракона: ");
                    tmp = scanner.nextLine();
                    while (tmp.equals("")) {
                        System.out.println("Имя не может быть пустым, введите Имя: ");
                        tmp = scanner.nextLine();
                    }
                    temp.setName(tmp);

                    //дата создания
                    temp.setCreationDate(LocalDateTime.now());
                    System.out.println(LocalDateTime.now());

                    //age
                    System.out.println("Введите возраст дракона: ");
                    tmp = scanner.nextLine();
                    System.out.println(tmp);
                    int age;
                    if (!tmp.equals("")) {
                        age = Integer.parseInt(tmp);
                        while (age <= 0) {
                            System.out.println("Здоровье не может быть меньше нуля: ");
                            age = Integer.parseInt(scanner.nextLine());
                        }
                        temp.setAge(age);
                    }

                    //heart count
                    System.out.println("Умеет ли дракон разговаривать Д/Н?: ");
                    tmp = scanner.nextLine();
                    while (!(tmp.equals("Д") || tmp.equals("Н"))) {
                        System.out.println("Умеет ли дракон разговаривать, введите Д/Н?: ");
                        tmp = scanner.nextLine();
                    }
                    temp.setSpeaking(tmp.equals("Д"));

                    //coord x y
                    System.out.println("Введите координату X: ");
                    long x = Long.parseLong(scanner.nextLine());
                    while (x <= -198) {
                        System.out.println("Введите координату X, она должна быть больше -198: ");
                        x = Long.parseLong(scanner.nextLine());
                    }

                    System.out.println("Введите координату Y: ");
                    long y = Long.parseLong(scanner.nextLine());
                    while (y <= -198) {
                        System.out.println("Введите координату Y, она должна быть больше -198: ");
                        y = Long.parseLong(scanner.nextLine());
                    }

                    temp.setCoordinates(new Coordinates(x, y));

                    //dragon type
                    boolean fl = true;
                    while (fl) {
                        System.out.println("Выберите один из данных типов дракона\nWATER\n" +
                                "UNDERGROUND\n" +
                                "AIR\n" +
                                "FIRE");
                        tmp = scanner.nextLine();
                        fl = false;
                        switch (tmp) {
                            case "UNDERGROUND":
                                temp.setType(DragonType.UNDERGROUND);
                                break;
                            case "WATER":
                                temp.setType(DragonType.WATER);
                                break;
                            case "AIR":
                                temp.setType(DragonType.AIR);
                                break;
                            case "FIRE":
                                temp.setType(DragonType.FIRE);
                                break;
                            default:
                                fl = true;
                                break;
                        }
                    }

                    //dragon character
                    fl = true;
                    while (fl) {
                        System.out.println("Выберите один из данных типов вооружения\nWATER\n" +
                                "UNDERGROUND\n" +
                                "AIR\n" +
                                "FIRE");
                        tmp = scanner.nextLine();
                        fl = false;
                        switch (tmp) {
                            case "UNDERGROUND":
                                temp.setType(DragonType.UNDERGROUND);
                                break;
                            case "WATER":
                                temp.setType(DragonType.WATER);
                                break;
                            case "AIR":
                                temp.setType(DragonType.AIR);
                                break;
                            case "FIRE":
                                temp.setType(DragonType.FIRE);
                                break;
                            default:
                                fl = true;
                                break;
                        }
                    }


            }

            s = scanner.nextLine();
        }

    }
}
