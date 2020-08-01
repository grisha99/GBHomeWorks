package homeworkten;

public class HomeWorkTenMine {

    private static String [][] arr = {
            {"12", "4", "7", "9"},
            {"20", "2", "1", "3"},
            {"7", "4", "ASD", "15"},
            {"5", "2", "1", "3"}
    };

    public static void main(String[] args) {
        try {
            System.out.println("Сумма элементов массива: " + HomeWorkTenTasks.arrTest(arr));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Сумма элементов массива до ошибки: " + e.getSumma());
        }

    }
}
