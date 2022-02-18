package programm.defaults;

/**
 * Класс {@code Coordinates} отвечает за месторасположение дракона.
 */
public class Coordinates {
    private long x; //Значение поля должно быть больше -198
    private long y;

    public Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}