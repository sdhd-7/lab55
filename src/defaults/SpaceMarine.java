package defaults;

import java.time.ZonedDateTime;

public class SpaceMarine {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    //ok
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    //ok
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    //ok
    private Long health; //Поле может быть null, Значение поля должно быть больше 0
    //ok
    private int heartCount; //Значение поля должно быть больше 0, Максимальное значение поля: 3
    //ok
    private String achievements; //Поле может быть null
    //ok
    private Weapon weaponType; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public void setHeartCount(int heartCount) {
        this.heartCount = heartCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }

}
