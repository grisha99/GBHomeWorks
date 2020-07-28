package homeworkeight.additionaltasks;

import javax.jws.Oneway;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * Дан массив целых чисел и ещё одно целое число.
 * Удалите все вхождения этого числа из массива (пропусков быть не должно).
 *
 */
public class RemoveNumFromArr {

    public static int [] testArr= {3,4,2,5,6,9,1,5,8,9,1};

    public static int [] removeValue(int [] arr, int valueToRemove) {
        int offSet = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToRemove) {
                offSet++;                       // кол-во элементов под удаление
            }
        }

        int [] resultArr = new int[arr.length - offSet];    // иассив после удаления
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != valueToRemove) {          // добавляем элемент, если не равен удаляемому
                resultArr[j] = arr[i];
                j++;
            }
        }

        return resultArr;
    }
}
