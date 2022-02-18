package programm.defaults;

import java.time.LocalDateTime;

/**
 * Класс {@code Dragon} отвечает за информацию о драконах.
 */
public class Dragon {
    /**
     * Уникальный номер дракона.
     */
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * Имя дракона.
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * Месторасположение дракона.
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * Дата и время создание экземпляра.
     */
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * Возраст дракона.
     */
    private int age; //Значение поля должно быть больше 0
    /**
     * Флаг, умеет ли дракон разговаривать.
     */
    private boolean speaking;
    /**
     * Типа дракона.
     */
    private DragonType type; //Поле не может быть null
    /**
     * Характер дракона.
     */
    private DragonCharacter character; //Поле не может быть null
    /**
     * Информация о драконоборце.
     */
    private Person killer; //Поле может быть null

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setSpeaking(boolean speaking) {
        this.speaking = speaking;
    }

    public void setKiller(Person killer) {
        this.killer = killer;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}