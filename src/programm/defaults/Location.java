package programm.defaults;

public class Location {
    private Long x; //Поле не может быть null
    private Long y; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле не может быть null

    public Location(Long x, Long y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}