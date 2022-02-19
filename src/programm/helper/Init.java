package programm.helper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import programm.defaults.*;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Выполняет команды по обработке коллекции.
 */

public class Init {
    private final LinkedList<Dragon> dragons = new LinkedList<>();
    private final LinkedList<String> history_list = new LinkedList<>();
    private final Gson gson = new Gson();
    private boolean wasStart = false;
    private final String filename;
    private final Date initdate;

    public Init(String filename) throws IOException {
        this.filename = filename;
        System.out.println(filename);
        this.initdate = new Date();
        this.load();
        wasStart = true;
    }

    /**
     * Метод, который поддерживает не более 15 элементов в истории.
     */
    private void historyCheck() {
        while (history_list.size() > 15) {
            history_list.removeLast();
        }
    }

    /**
     * Завершает работу программы без сохранения.
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * Выводит список доступных команд для пользователя.
     */
    public void help() {
        history_list.addFirst("help");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "history : вывести последние 15 команд (без их аргументов)\n" +
                "remove_all_by_type type : удалить из коллекции все элементы, значение поля type которого эквивалентно заданному\n" +
                "count_by_age age : вывести количество элементов, значение поля age которых равно заданному\n" +
                "filter_by_character character : вывести элементы, значение поля character которых равно заданному");
    }

    /**
     * Удаляет все элементы из коллекции.
     */
    public void clear() {
        history_list.addFirst("clear");
        dragons.clear();
        System.out.println("Коллекция успешно очищена");
    }

    /**
     * Выводит последние 15 команд пользователя.
     */
    public void history() {
        historyCheck();
        int ind = 1;
        for (String tmp : history_list) {
            System.out.println(ind + ") ->" + tmp);
            ind++;
        }
        history_list.addFirst("history");
    }

    /**
     * Считает количество драконов чей возраст равен {@code age}.
     *
     * @param age : Возраст по которому мы считаем драконов.
     */
    public void count_by_age(int age) {
        int count = 0;
        for (Dragon tmp : dragons) {
            if (tmp.getAge() == age)
                count++;
        }
        System.out.println("В коллекции нашлось " + count + " драконов в возрасте " + age);
    }

    /**
     * Выводит все объекты коллекции в консоль.
     */
    public void show() {
        history_list.addFirst("show");
        for (Dragon tmp : dragons)
            System.out.println(gson.toJson(tmp));
    }

    /**
     * Создает экземпляр класса {@code Dragon}, параметры которого вводит пользователь.
     *
     * @param scanner : поток ввода консоли.
     * @return : возвращает экземпляр класса {@code Dragon}.
     */
    private Dragon newDragon(Scanner scanner) {
        //создание нового объекта
        Dragon temp = new Dragon();

        temp.setId((long) (Math.random() * 543323));

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

        //age
        System.out.println("Введите возраст дракона: ");
        tmp = scanner.nextLine();
        int age;
        if (!tmp.equals("")) {
            age = Integer.parseInt(tmp);
            while (age <= 0) {
                System.out.println("Возраст не может быть меньше нуля: ");
                age = Integer.parseInt(scanner.nextLine());
            }
            temp.setAge(age);
        }

        //speak
        System.out.println("Умеет ли дракон разговаривать Y/N?: ");
        tmp = scanner.nextLine();
        while (!(tmp.equals("Y") || tmp.equals("N"))) {
            System.out.println("Умеет ли дракон разговаривать, введите Y/n?: ");
            tmp = scanner.nextLine();
        }
        temp.setSpeaking(tmp.equals("Y"));

        //coordinates x y
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
            System.out.println("Выберите один из данных характеров дракона\nWISE\n" +
                    "EVIL\n" +
                    "CHAOTIC_EVIL\n" +
                    "FICKLE");
            tmp = scanner.nextLine();
            fl = false;
            switch (tmp) {
                case "EVIL":
                    temp.setCharacter(DragonCharacter.EVIL);
                    break;
                case "WISE":
                    temp.setCharacter(DragonCharacter.WISE);
                    break;
                case "CHAOTIC_EVIL":
                    temp.setCharacter(DragonCharacter.CHAOTIC_EVIL);
                    break;
                case "FICKLE":
                    temp.setCharacter(DragonCharacter.FICKLE);
                    break;
                default:
                    fl = true;
                    break;
            }
        }

        //Killer

        System.out.println("Жив ли дракон? Y/N");

        tmp = scanner.nextLine();
        while (!(tmp.equals("Y") || tmp.equals("N"))) {
            System.out.println("Жив ли дракон, введите Y/n?: ");
            tmp = scanner.nextLine();
        }
        if (tmp.equals("Y")) {
            temp.setKiller(null);
        } else {
            Person lol = new Person();

            //name killer
            System.out.println("Введите имя драконоборца: ");
            tmp = scanner.nextLine();
            while (tmp.equals("")) {
                //System.out.println("Имя не может быть пустым, введите имя: ");
                tmp = scanner.nextLine();
            }
            lol.setName(tmp);

            //killer passport
            System.out.println("Введите паспорт драконоборца: ");
            tmp = scanner.nextLine();
            while (!(tmp.length() < 35 && tmp.length() >= 4 || tmp.length() == 0)) {
                System.out.println("количество символов в паспорте должно быть не меньше 4 и не больше 34, введите паспорт: ");
                tmp = scanner.nextLine();
            }
            lol.setPassportID(tmp.length() == 0 ? tmp : null);

            //hair color
            fl = true;
            while (fl) {
                System.out.println("Выберите один из данных цветов волос драконоборца\n" +
                        "BLACK\n" +
                        "BLUE\n" +
                        "WHITE\n" +
                        "YELLOW\n" +
                        "BROWN");
                tmp = scanner.nextLine();
                fl = false;
                switch (tmp) {
                    case "BLACK":
                        lol.setHairColor(Color.BLACK);
                        break;
                    case "BLUE":
                        lol.setHairColor(Color.BLUE);
                        break;
                    case "WHITE":
                        lol.setHairColor(Color.WHITE);
                        break;
                    case "YELLOW":
                        lol.setHairColor(Color.YELLOW);
                        break;
                    case "BROWN":
                        lol.setHairColor(Color.BROWN);
                        break;
                    case "":
                        lol.setHairColor(null);
                        break;
                    default:
                        fl = true;
                        break;
                }
            }

            //eyes color
            {
                fl = true;

                while (fl) {
                    System.out.println("Выберите один из данных цветов зрачка драконоборца\n" +
                            "BLACK\n" +
                            "BLUE\n" +
                            "WHITE\n" +
                            "YELLOW\n" +
                            "BROWN");
                    tmp = scanner.nextLine();
                    fl = false;
                    switch (tmp) {
                        case "BLACK":
                            lol.setEyeColor(Color.BLACK);
                            break;
                        case "BLUE":
                            lol.setEyeColor(Color.BLUE);
                            break;
                        case "WHITE":
                            lol.setEyeColor(Color.WHITE);
                            break;
                        case "YELLOW":
                            lol.setEyeColor(Color.YELLOW);
                            break;
                        case "BROWN":
                            lol.setEyeColor(Color.BROWN);
                            break;
                        case "":
                            lol.setEyeColor(null);
                            break;
                        default:
                            fl = true;
                            break;
                    }

                }
            }

            //nationality

            {
                fl = true;
                while (fl) {
                    System.out.println("Выберите одну из данных национальностей драконоборца\n" +
                            "GERMANY\n" +
                            "ITALY\n" +
                            "SOUTH_KOREA");
                    tmp = scanner.nextLine();
                    fl = false;
                    switch (tmp) {
                        case "GERMANY":
                            lol.setNationality(Country.GERMANY);
                            break;
                        case "ITALY":
                            lol.setNationality(Country.ITALY);
                            break;
                        case "SOUTH_KOREA":
                            lol.setNationality(Country.SOUTH_KOREA);
                            break;
                        case "":
                            lol.setHairColor(null);
                            break;
                        default:
                            fl = true;
                            break;
                    }
                }
            }

            //location
            System.out.println("Знаете ли вы месторасположение драконоборца? Y/N");

            tmp = scanner.nextLine();
            while (!(tmp.equals("Y") || tmp.equals("N"))) {
                System.out.println("Знаете ли вы месторасположение драконоборца, введите Y/N?: ");
                tmp = scanner.nextLine();
            }
            if (tmp.equals("N")) {
                lol.setLocation(null);
            } else {
                System.out.println("Введите координату X: ");
                tmp = scanner.nextLine();
                while (tmp.equals("")) {

                    System.out.println("Введите координату X: ");
                    tmp = scanner.nextLine();
                }
                x = Long.parseLong(tmp);
                System.out.println("Введите координату Y: ");
                tmp = scanner.nextLine();
                while (tmp.equals("")) {

                    System.out.println("Введите координату Y: ");
                    tmp = scanner.nextLine();
                }
                y = Long.parseLong(tmp);
                System.out.println("Укажите название местности: ");
                tmp = scanner.nextLine();
                while (tmp.equals("")) {

                    System.out.println("Укажите название местности: ");
                    tmp = scanner.nextLine();
                }
                lol.setLocation(new Location(x, y, tmp));
            }
            temp.setKiller(lol);
        }
        return temp;
    }

    /**
     * Добавление нового элемента в коллекцию.
     *
     * @param s поток ввода через консоль.
     */
    public void add(Scanner s) {
        history_list.addFirst("add");
        dragons.addFirst(this.newDragon(s));
        System.out.println("Элемент успешно добавлен");
    }

    /**
     * Вывод информации о коллекции.
     */
    public void info() {
        history_list.addFirst("info");
        System.out.println("Тип коллекции: " + dragons.getClass() +
                "\nДата инициализации: " + initdate +
                "\nКоличество элементов: " + dragons.size());
    }

    /**
     * Удаляет первый элемент коллекции.
     */
    public void remove_first() {
        history_list.addFirst("remove_last");
        if (dragons.size() == 0)
            System.out.println("Коллекция пуста");
        else {
            dragons.removeFirst();
            System.out.println("Первый элемент успешно удален");
        }
    }

    /**
     * Сохранят коллекцию в файл.
     */
    public void save() {
        history_list.addFirst("save");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)))) {
            writer.write(gson.toJson(dragons));
            System.out.println("Данные успешно сохранены");
        } catch (Exception ex) {
            System.out.println("Коллекция не может быть записана в файл.");
        }
    }

    /**
     * Добавляет в коллекцию новый элемент, если он больше максимального.
     *
     * @param sc Поток ввода из консоли.
     */
    public void add_if_max(Scanner sc) {
        history_list.addFirst("add_if_max");
        if (dragons.size() != 0) {
            Dragon mainCompetitor = newDragon(sc);
            Dragon competitor = Collections.max(dragons);
            if (competitor.compareTo(mainCompetitor) < 0) {
                dragons.add(mainCompetitor);
                System.out.println("Элемент успешно добавлен.");
            } else System.out.println("Не удалось добавить элемент.");
        } else System.out.println("Элемент не с чем сравнивать. Коллекция пуста.");
    }

    /**
     * Загружает данные о коллекции из файла формата json.
     *
     * @throws IOException Выбрасывает ошибки связанные с работой файла.
     */
    public void load() throws IOException {
        history_list.addFirst("load");
        int beginSize = dragons.size();
        File jsonCollection = new File(filename);
        try {
            if (!jsonCollection.exists()) throw new FileNotFoundException();
        } catch (FileNotFoundException ex) {
            System.out.println("Файла по указанному пути не существует.");
            if (!wasStart) System.exit(1);
            else return;  //без return выкидывает exception, если удалить файл во время работы программы и вызвать load
        }
        try {
            if (!jsonCollection.canRead() || !jsonCollection.canWrite()) throw new SecurityException();
        } catch (SecurityException ex) {
            System.out.println("Файл защищён от чтения и/или записи. Для работы программы нужны оба разрешения.");
            if (!wasStart) System.exit(1);
            else return; //без return выкидывает exception, если удалить файл во время работы программы и вызвать load
        }
        try {
            if (jsonCollection.length() == 0) throw new JsonSyntaxException("");
        } catch (JsonSyntaxException ex) {
            System.out.println("Файл пуст.");
            if (!wasStart) System.exit(1);
            else return; //без return выкидывает exception, если удалить файл во время работы программы и вызвать load
        }
        try (BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(jsonCollection)))) {
            System.out.println("Идёт загрузка коллекции " + jsonCollection.getAbsolutePath());
            String nextLine;
            StringBuilder result = new StringBuilder();
            while ((nextLine = inputStreamReader.readLine()) != null) {
                result.append(nextLine);
            }
            Type collectionType = new TypeToken<LinkedList<Dragon>>() {
            }.getType();
            try {
                LinkedList<Dragon> addedDragon = gson.fromJson(result.toString(), collectionType);
                for (Dragon s : addedDragon) {
                    if (!dragons.contains(s)) dragons.add(s);
                }
            } catch (JsonSyntaxException ex) {
                System.out.println("Ошибка синтаксиса Json. Коллекция не может быть загружена.");
                System.exit(1);
            }
            System.out.println("Коллекций успешно загружена. Добавлено " + (dragons.size() - beginSize) + " элементов.");
        }
    }
}
