package java3.homeworkone;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWorkOneTasks {

    /**
     *
     * Написать метод, который меняет два элемента массива местами.
     * (массив может быть любого ссылочного типа);
     *
     * @param arr   массив для замены элементов0
     * @param src   индекс первого элемента
     * @param dst   индекс второго элемента
     * @param <T>   тип элементов массива
     */

    public static <T> void swapElement(T[] arr, int src, int dst){
        if (!(src >= 0 && src <= arr.length - 1)) {
            return;
        }
        if (!(dst >= 0 && dst <= arr.length - 1)) {
            return;
        }
        T tempElement;
        tempElement = arr[src];
        arr[src] = arr[dst];
        arr[dst] = tempElement;

    }

    /**
     *
     * Написать метод, который преобразует массив в ArrayList;
     *
     * @param arr   массив для преобразования
     * @param <T>   тип элементов массива
     * @return      ArrayList элементов с типом T
     */

    public static <T> ArrayList<T> arrayToArrayList(T[] arr) {

        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void testArrays() {

        String [] testArrayString = {"bmw", "lada", "mercedes", "mazda", "kia"};

        System.out.println(Arrays.toString(testArrayString));
        HomeWorkOneTasks.swapElement(testArrayString, 0, 2);
        System.out.println(Arrays.toString(testArrayString));

    }

    /**
     *
     * Проверка задания с коробками фруктов
     *
     */

    public static void testBox() {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();


        for (int i = 0; i < 6; i++) {
            appleBox1.putFruitInBox(new Apple());
            appleBox2.putFruitInBox(new Apple());
        }

        for (int i = 0; i < 8; i++) {
            orangeBox1.putFruitInBox(new Orange());
        }

        System.out.println("Вес appleBox1: " + appleBox1.getWeight());
        System.out.println("Вес appleBox2: " + appleBox2.getWeight());
        System.out.println("Вес orangeBox2: " + orangeBox1.getWeight());
        System.out.println("Сравнение веса appleBox1 и appleBox2: " + appleBox1.compareBox(appleBox2));
        System.out.println("Сравнение веса appleBox2 и orangeBox1: " + appleBox2.compareBox(orangeBox1));
        System.out.println("Перекладываем фрукты из appleBox1 в appleBox2 ");
        appleBox1.moveToAnotherBox(appleBox2);
        System.out.println("Сравнение веса appleBox2 и orangeBox1 после перекладывания: " + appleBox2.compareBox(orangeBox1));
        System.out.println("Вес appleBox1: " + appleBox1.getWeight());
        System.out.println("Вес appleBox2: " + appleBox2.getWeight());
        System.out.println("Вес orangeBox2: " + orangeBox1.getWeight());
    }

}
