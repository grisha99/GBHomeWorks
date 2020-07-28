package homeworkeight.additionaltasks;

import java.util.Arrays;

/**
 *
 * Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
 *
 */

public class PrimeNumder {

    private String primeNumString = "";
    private String delimiter = ",";
    private int [] primeNumArr;

    public PrimeNumder(int lastNumber) {
        String [] tmpArr;
        if (lastNumber < 2) {
            System.out.println("не правильное конечное число, должно быть >=2");
            return;
        }

        boolean isPrime = true;
        for (int i = 3; i <= lastNumber; i += 2) {
            isPrime = true;
            for (int j = 2; j * 2 <= i; j++) {  // (j * 2 <= i) делитель больше половины делимого, нет смысла продолжать
                    if (j + 1 != i) {       // само на себя число делить не будем
                        if (i % (j + 1) == 0) { // число не простое, делится на что-то еще
                            isPrime = false;
                            break;
                        }
                    }
            }
            if (isPrime) {      // число простое
                if (i + 2 <= lastNumber) {
                    primeNumString = primeNumString + String.valueOf(i) + delimiter;
                } else {                            //  если элемент последний, разделитель не ставим
                    primeNumString = primeNumString + String.valueOf(i);
                }
            }
        }
        tmpArr = primeNumString.split(delimiter);
        primeNumArr = new int[tmpArr.length];
        for (int i = 0; i < tmpArr.length; i++) {       // заполняем массив числами из строки
            primeNumArr[i] = Integer.parseInt(tmpArr[i]);
        }
     }

    public void info() {
        System.out.println(Arrays.toString(primeNumArr));
    }
}
