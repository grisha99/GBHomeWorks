package java3.homeworksix;

public class ArrUtils {

    public static boolean getDigit(int[] arr) {

        int [] regNum = {1, 4};

        if (arr == null) {
            return false;
        }
        for (int i = 0; i < regNum.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (regNum[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int [] getDigitArray(int [] arr) throws RuntimeException {

        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Не правильный входной параметр");
        }

        int reqNum = 4;
        int [] result = null;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == reqNum) {
                if (i < arr.length - 1) {
                    result = new int[arr.length - 1 - i];
                    int k = 0;
                    for (int j = i + 1; j < arr.length; j++) {
                        result[k] = arr[j];
                        k++;
                    }
                    break;
                } else {
                    return new int[]{};
                }
            }
        }

        if (result == null) {
            throw new RuntimeException("Искомые данные не найдены");
        }

        return result;

    }
}
