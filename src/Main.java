import defaults.SpaceMarine;
import defaults.Weapon;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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
                    Integer id = Integer.parseInt(curr[1]);

                    //создание нового объекта
                    SpaceMarine temp = new SpaceMarine();

                    //присвоение имени флота
                    String tmp;
                    System.out.println("Введите название флота: ");
                    tmp = scanner.nextLine();
                    while (tmp.equals("")) {
                        System.out.println("Название не может быть пустым, введите название: ");
                        tmp = scanner.nextLine();
                    }
                    temp.setName(tmp);

                    //дата создания
                    temp.setCreationDate(ZonedDateTime.now(ZoneId.systemDefault()));

                    //HP
                    System.out.println("Введите количество здоровья: ");
                    tmp = scanner.nextLine();
                    System.out.println(tmp);
                    long hp;
                    if (!tmp.equals("")) {
                        hp = Long.parseLong(tmp);
                        while (hp <= 0) {
                            System.out.println("Здоровье не может быть меньше нуля: ");
                            hp = Long.parseLong(scanner.nextLine());
                        }
                        temp.setHealth(hp);
                    }

                    //heart count
                    System.out.println("Введите запас прочности: ");
                    int hc = Integer.parseInt(scanner.nextLine());
                    while (!(hc > 0 && hc <= 3)) {
                        System.out.println("Запас прочности должен быть больше 0 и не больше 3: ");
                        hc = Integer.parseInt(scanner.nextLine());
                    }
                    temp.setHeartCount(hc);

                    //achivments
                    System.out.println("Введите достижения флота: ");
                    tmp = scanner.nextLine();
                    temp.setName(tmp);

                    //weapon
                    boolean fl = true;
                    while (fl) {
                        System.out.println("Выберите один из данных типов вооружения\nBOLT_PISTOL\n" +
                                "PLASMA_GUN\n" +
                                "INFERNO_PISTOL\n" +
                                "MISSILE_LAUNCHER");
                        tmp = scanner.nextLine();
                        fl = false;
                        switch (tmp) {
                            case "BOLT_PISTOL":
                                temp.setWeaponType(Weapon.BOLT_PISTOL);
                                break;
                            case "PLAZMA_GUN":
                                temp.setWeaponType(Weapon.PLASMA_GUN);
                                break;
                            case "INFERNO_PISTOL":
                                temp.setWeaponType(Weapon.INFERNO_PISTOL);
                                break;
                            case "MISSILE_LAUNCHER":
                                temp.setWeaponType(Weapon.MISSILE_LAUNCHER);
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
