package java3.homeworkfive.race;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{

    private static int RACER_LIMIT; // кол-во одновременных гонщиков в тоннеле
    private Semaphore sLimit;

    public Tunnel(int length, int carCount) {
        this.length = length;
        description = "Тоннель " + length + " метров";
        RACER_LIMIT = carCount / 2; // В тоннель не может заехать одновременно больше половины участников
        sLimit = new Semaphore(RACER_LIMIT,true);

    }

    @Override
    public void go(Car c) {
        try {
            try {

                if (sLimit.availablePermits() == 0) {   // тоннель занят, ждем
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                }
                sLimit.acquire();   // занимаем тоннель или становимся в очередь
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                sLimit.release();   // освобождаем тоннель
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
