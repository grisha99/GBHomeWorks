package homeworkten;

public class MyArrayDataException extends Exception{

    private int summa;

    public MyArrayDataException(int row, int col, int sumResult) {

        super("Ошибка в массиве, столбец: " + col + ", строка: " + row);
        summa = sumResult;
    }

    public int getSumma() {
        return summa;
    }
}
