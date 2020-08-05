package homeworkten;

public class HomeWorkTenTasks {

    public static int arrTest(String [][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Размер массива не правильный!");
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i + 1, j + 1, sum);
                }
            }

        }
        return sum;
    }
}
