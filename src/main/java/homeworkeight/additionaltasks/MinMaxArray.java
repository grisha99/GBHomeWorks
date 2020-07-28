package homeworkeight.additionaltasks;

/**
 *
 * Заполните массив случайным числами и выведете максимальное, минимальное и среднее значение.
 *
 */

public class MinMaxArray {

    private int [] arr;
    private int minValue;
    private int maxValue;
    private double meanValue;

    public MinMaxArray(int count) {
        double tmpSum = 0.00;
        arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 400);
        }
        minValue = maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
           if (minValue > arr[i]) {
               minValue = arr[i];
           }
           if (maxValue < arr[i]) {
               maxValue = arr[i];
           }
           tmpSum += arr[i];
        }
        meanValue = tmpSum / arr.length;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public double getMeanValue() {
        return meanValue;
    }
}
