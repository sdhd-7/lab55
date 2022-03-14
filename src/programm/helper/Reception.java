package programm.helper;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс {@code Reception} выполняет считывание команд пользователя из консоли.
 */
public class Reception {
    private final Init maker;
    private String sinp = "";

    /**
     * Добавляет объект управления коллекцией.
     *
     * @param maker : объект управления коллекцией {@code Init}.
     */
    public Reception(Init maker) {
        this.maker = maker;
    }

    /**
     * Метод, который преобразует команды пользователя в команды для класса управления коллекцией {@code Init}
     */
    public void go() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            sinp = scanner.nextLine();
            String[] scom = sinp.trim().split(" ");

            switch (scom[0]) {
                case "":
                    break;
                case "help":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.help();
                    break;
                case "exit":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.exit();
                    break;
                case "clear":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.clear();
                    break;
                case "add":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.add(scanner);
                    break;
                case "info":
                    maker.info();
                    break;
                case "update":
                    try {
                        maker.update(Long.parseLong(scom[1]), scanner);
                    } catch (Exception ex) {
                        maker.wrong();
                    }
                    break;
                case "remove_by_id":
                    try {
                        maker.remove_by_id(Long.parseLong(scom[1]));
                    } catch (Exception ex) {
                        maker.wrong();
                    }
                    break;
                case "execute_script":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.execute_script(scom[1]);
                    break;
                case "add_if_max":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.add_if_max(scanner);
                    break;
                case "remove_all_by_type":
                    maker.remove_all_by_type(scom[1]);
                    break;
                case "count_by_age":
                    try {
                        maker.count_by_age(Integer.parseInt(scom[1]));
                    } catch (Exception ex) {
                        maker.wrong();
                    }
                    break;
                case "filter_by_character":
                    maker.filter_by_character(scom[1]);
                    break;
                case "show":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.show();
                    break;
                case "save":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.save();
                    break;
                case "remove_first":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.remove_first();
                    break;
                case "history":
                    if (scom.length != 1) {
                        maker.wrong();
                        break;
                    }
                    maker.history();
                    break;
                default:
                    maker.wrong();
                    break;
            }
        }
    }


}
