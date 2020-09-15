package java3.homeworkfive.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * Организуем гонки:
 * Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
 * В туннель не может заехать одновременно больше половины участников (условность).
 * Попробуйте всё это синхронизировать.
 * Только после того как все завершат гонку, нужно выдать объявление об окончании.
 * Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.
 *
 */

public class Competition {

    static class RaceIsStart implements Runnable {

        @Override
        public void run() {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
    }

    public static final int CAR_COUNT = 4;

    public static void startRace() {
        CyclicBarrier cbStart = new CyclicBarrier(CAR_COUNT, new RaceIsStart());    // ожидание страта
        CountDownLatch cdEnd = new CountDownLatch(CAR_COUNT);                       // ожмдание конца гонки

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(50, CAR_COUNT), new Road(40));
        Car[] cars = new Car[CAR_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cbStart, cdEnd);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            cdEnd.await();      // ждем всех на финише
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            System.out.println("Победитель: " + race.getWinner().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

}


