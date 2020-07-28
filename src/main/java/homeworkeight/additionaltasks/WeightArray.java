package homeworkeight.additionaltasks;

/**
 *
 * Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
 * Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом,
 * с учётом его веса. Пример: Дан массив [1, 2, 3], и массив весов [1, 2, 10].
 * В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и
 * в десять раз реже, чем значение «3».
 *
 */

public class WeightArray {

    private int [] valuseArr;
    private int [] weightArr;
    private int [] weightLine;
    private int weightSum;

    public WeightArray(int [] valueArr, int [] weightArr) {
        if (valueArr.length != weightArr.length) {
            System.out.println("Массив значений и массив весов должны быть одинаковой длинны");
            return;
        }
        this.valuseArr = valueArr;
        this.weightArr = weightArr;

        for (int weight : weightArr) {  // подсчет суммы весов
            weightSum += weight;
        }

        weightLine = new int[weightSum];    // массив длинной на все веса
        int counter = 0;
        for (int i = 0; i < valueArr.length; i++) {         // берем значение
            for (int j = 0; j < this.weightArr[i]; j++) {   // столько элементов, сколько веса у этого значения
                weightLine[counter] = valueArr[i];          // заполняем значениями
                counter++;
            }

        }
    }

    public int getValue() {
        int tmpVal = (int) (Math.random() * weightLine.length);
        return weightLine[tmpVal];
    }

}
