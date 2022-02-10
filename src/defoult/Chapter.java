package defoult;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int marinesCount; //Значение поля должно быть больше 0, Максимальное значение поля: 1000

    public Chapter(String name, int marinesCount) {
        this.marinesCount = marinesCount;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarinesCount(int marinesCount) {
        this.marinesCount = marinesCount;
    }
}
