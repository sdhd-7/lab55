package programm.helper;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс {@code Reception} выполняет считывание команд пользователя из консоли.
 */
public class Reception {
    private String sinp = "";
    private final Init maker;

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
                    maker.help();
                    break;
                case "exit":
                    maker.exit();
                    break;
                case "clear":
                    maker.clear();
                    break;
                case "add":
                    maker.add(scanner);
                    break;
                case "info":
                    maker.info();
                    break;
                case "update":
                    maker.update(Long.parseLong(scom[1]), scanner);
                    break;
                case "remove_by_id":
                    maker.remove_by_id(Long.parseLong(scom[1]));
                    break;
                case "execute_script":
                    maker.execute_script(scom[1]);
                    break;
                case "add_if_max":
                    maker.add_if_max(scanner);
                    break;
                case "remove_all_by_type":
                    maker.remove_all_by_type(scom[1]);
                    break;
                case "count_by_age":
                    maker.count_by_age(Integer.parseInt(scom[1]));
                    break;
                case "filter_by_character":
                    maker.filter_by_character(scom[1]);
                    break;
                case "show":
                    maker.show();
                    break;
                case "save":
                    maker.save();
                    break;
                case "remove_first":
                    maker.remove_first();
                    break;
                case "history":
                    maker.history();
                    break;
                default:
                    System.out.println("Введена неверная команда, чтобы ознакомиться со списком доступных команд, введите команду help");
                    break;
            }
        }
    }


}
