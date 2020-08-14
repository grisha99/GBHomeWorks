package homeworkthirteen;

import java.util.Arrays;

public class ThreadTimeTest {

    static final int size = 10000000;
    static final int halfSize = size / 2;

    private static float [] createAndFillArr () {
        float[] result = new float[size];

        Arrays.fill(result, 1);

        return result;
    }

    public static void noThreadTimeTest() {
        float[] arr = createAndFillArr();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long endTime = System.currentTimeMillis();

        System.out.print("Время выполнения теста без потоков: ");
        System.out.println(endTime - startTime + " миллисекунд.");
    }

    public static void threadTimeTest() {
        float[] arr = createAndFillArr();

        long startTime = System.currentTimeMillis();

        float [] arrPart1 = new float[halfSize];
        float [] arrPart2 = new float[halfSize];

        // разделения массива для потоков
        System.arraycopy(arr, 0, arrPart1, 0, halfSize );
        System.arraycopy(arr, halfSize, arrPart2, 0, halfSize );

        // Создаем два независимых потока
        MyThread thread1 = new MyThread(arrPart1);
        MyThread thread2 = new MyThread(arrPart2);

        // запуск потоков
        thread1.start();
        thread2.start();

        try {               // ожидание завершения работы потоков
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // получаем результат вычислений
        arrPart1 = thread1.getOutArr();
        arrPart2 = thread2.getOutArr();

        // склеивание массива
        System.arraycopy(arrPart1, 0, arr, 0, halfSize);
        System.arraycopy(arrPart2, 0, arr, halfSize, halfSize);

        long endTime = System.currentTimeMillis();

        System.out.print("Время выполнения теста в 2 потока: ");
        System.out.println(endTime - startTime + " миллисекунд.");

        if (!thread1.isAlive() && !thread2.isAlive()) {
            System.out.println("Оба потока закончили работу");
        } else {
            System.out.println("Потоки еще работают....");
        }
    }
}
