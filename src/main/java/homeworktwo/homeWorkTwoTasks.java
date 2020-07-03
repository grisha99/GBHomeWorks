package homeworktwo;

public class homeWorkTwoTasks {

    public void setAndInvertArray(){
        int [] arr = new int[] { 1, 0, 0, 1, 0, 1, 1, 0, 0, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }

    public void setAndFillIntArray(){
        int [] arr = new int [8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }

    public void setIntArrayAndChangeValue() {
        int [] arr = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
    }

    public void fillArrayDiagonal() {
        int [][] arr = new int[5][5];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {                       //диагональ левао верх в право низ
                    arr[i][j] = 1;
                }
                if (j == arr[i].length - 1 - i) {   //диагональ право верх в лево низ
                    arr[i][j] = 1;
                }
            }
        }
    }

    public void findMinMaxArrayValue() {
        int [] arr = new int[] { 4, 15, 23, 7, 34, 32, 11, 14, 3, 28};
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int currentValue: arr) {
            if (minValue > currentValue) {
                minValue = currentValue;
            }
            if (maxValue < currentValue) {
                maxValue = currentValue;
            }
        }
    }

    public boolean checkBalance(int [] arr) {
        // возвращаем false если массив пустой или его длинна 1 (нет левой или правой части)
        if ((arr.length == 0) || (arr.length == 1)) {
            return false;
        }

        int leftSideSum = 0;
        int rightSideSum;
        for (int i = 0; i < arr.length; i++) {
            leftSideSum += arr[i];
            rightSideSum = 0;
            for (int j = arr.length - 1; j > i; j--) {
                rightSideSum += arr[j];
            }
            if (leftSideSum == rightSideSum) {
                return true;
            }
        }
        return false;
    }

    public void shiftArray(int [] arr, int shiftSize) {
        if ((arr.length == 0) || (arr.length == 1)) { // пустой массив или сдвигать один элемент нет смысла
            return;
        }
        boolean isLeftShift = false;
        if (shiftSize < 0) {
            isLeftShift = true;
            shiftSize = shiftSize * -1;
        }
        while (arr.length < shiftSize) {           // размер сдвига больше размера массива, корректируем его
            shiftSize = shiftSize - arr.length;
        }
        if (isLeftShift) {                         // пересчет сдвига влево, в сдвиг вправо
            shiftSize = arr.length - shiftSize;
        }
        if ((arr.length == shiftSize) || (shiftSize == 0)) {              //ничего не сдвигаем, массив не изменится
            return;
        }

        int tempDigitFirst;
        int tempDigitSecond;

        for (int i = 1; i <= shiftSize; i++) {
            tempDigitFirst = arr[0];
            for (int j = 1; j < arr.length; j++) {
                tempDigitSecond = arr[j];
                arr[j] = tempDigitFirst;
                tempDigitFirst = tempDigitSecond;
            }
            arr[0] = tempDigitFirst;
        }
    }


}
