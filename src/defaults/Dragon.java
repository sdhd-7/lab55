package defaults;

import java.time.LocalDateTime;


public class Dragon {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    //ok
    private String name; //Поле не может быть null, Строка не может быть пустой
    //ok
    private Coordinates coordinates; //Поле не может быть null
    //ok
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    //ok
    private int age; //Значение поля должно быть больше 0
    //ok
    private boolean speaking;
    //ok
    private DragonType type; //Поле не может быть null
    //ok
    private DragonCharacter character; //Поле не может быть null
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpeaking(boolean speaking) {
        this.speaking = speaking;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public void setKiller(Person killer) {
        this.killer = killer;
    }
}