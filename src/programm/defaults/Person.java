package programm.defaults;

public class Person {
    //ok
    private String name; //Поле не может быть null, Строка не может быть пустой
    //ok
    private String passportID; //Строка не может быть пустой, Длина строки не должна быть больше 34, Длина строки должна быть не меньше 4, Поле может быть null
    //ok
    private Color eyeColor; //Поле может быть null
    //ok
    private Color hairColor; //Поле может быть null
    //ok
    private Country nationality; //Поле может быть null
    //ok but not null exc
    private Location location; //Поле может быть null

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}