package programm.defaults;

/**
 * Класс {@code Coordinates} отвечает за месторасположение дракона.
 */
public class Coordinates {
    private final long x; //Значение поля должно быть больше -198
    private final long y;

    public Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }
}