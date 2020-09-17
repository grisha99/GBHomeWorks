package java3.homeworksix;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;

import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class ArrUtilsTest {

    int[] strToIntArr(String str) {
        if (str.equals("null")) {
            return null;
        }
        return Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
    }


    @CsvSource({
            "true, 0:2:4:7:5:-3:21:8",
            "true, 0:2:3:7:1:-3:21:8",
            "true, 1:2:4:7:5:-3:21:8",
            "false, 6:2:0:7:5:-3:21:8",
            "false, null"
    })
    @ParameterizedTest
    @DisplayName("Тест входных параметров")
    public void getDigitTest(boolean result, String str) {

        Assertions.assertEquals(result, ArrUtils.getDigit(strToIntArr(str)));
    }

    @Test
    @DisplayName("Тест на пустой массив")
    public void getDigitEmptyTest() {

        Assertions.assertEquals(false, ArrUtils.getDigit(new int[]{}));
    }

    @ParameterizedTest
    @CsvSource({
            "7:5:-3:21:8, 0:2:4:7:5:-3:21:8",
            "8, 0:2:3:7:1:-3:4:8"
    })
    @DisplayName("Массив после последней четверки")
    public void getDigitArrayTest(String result, String strArrIn) {
        Assertions.assertArrayEquals(strToIntArr(result), ArrUtils.getDigitArray(strToIntArr(strArrIn)));
    }

    @Test
    @DisplayName("Массив с четверкой в конце ")
    public void getDigitArrayEmptyTest() {

        Assertions.assertArrayEquals(new int[]{}, ArrUtils.getDigitArray(new int[]{1,3,6,7,4}));
    }

    @Test
    @DisplayName("Массив после последней четверкой с исключением")
    public void getDigitArrayTest() {
        Assertions.assertThrows(RuntimeException.class, () -> ArrUtils.getDigitArray(null));
        Assertions.assertThrows(RuntimeException.class, () -> ArrUtils.getDigitArray(new int[]{}));
        Assertions.assertThrows(RuntimeException.class, () -> ArrUtils.getDigitArray(new int[]{1,3,6,7,5}));
    }


}
