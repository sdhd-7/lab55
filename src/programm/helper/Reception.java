package programm.helper;

import java.util.Scanner;

/**
 * Класс {@code Reception} выполняет считывание команд пользователя из консоли.
 */
public class Reception {
    private String sinp = "";
    private String[] scom;
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
    public void go() {
        Scanner scanner = new Scanner(System.in);
        while (!sinp.equals("exit")) {

            sinp = scanner.nextLine();
            scom = sinp.trim().split(" ");

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
                    break;
                case "update":
                    break;
                case "remove_by_id":
                    break;
                case "execute_script":
                    break;
                case "add_if_max":
                    break;
                case "remove_all_by_type":
                    break;
                case "count_by_age":
                    maker.count_by_age(Integer.parseInt(scom[1]));
                    break;
                case "filter_by_character":
                    break;
                case "show":
                    maker.show();
                    break;
                case "save":
                    break;
                case "remove_first":
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
