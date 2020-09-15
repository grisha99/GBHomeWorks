package java3.homeworkfive.race;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{

    private static int CAR_NUMBER;

    static {
        CAR_NUMBER = 0;

    }

    private Race race;
    private int speed;
    private String name;
    private int prepareTime;
    private CyclicBarrier startBarrier; // для одновременного старта
    private CountDownLatch endBarrier;  // подсчет пришедших к финишу


    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public Car(Race race, int speed, CyclicBarrier cbStart, CountDownLatch cdEnd) {
        CAR_NUMBER++;
        this.race = race;
        this.speed = speed;
        name = "Гонщик №" + CAR_NUMBER;
        prepareTime = (500 + (int)(Math.random() * 800));
        startBarrier = cbStart;
        endBarrier = cdEnd;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " готовится");
            Thread.sleep(prepareTime);
            System.out.println(name + " готов");
            startBarrier.await();                       // ждем всех участников на старте
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (race.getWinner() == null) {     // если победителя еще нет, значит это мы, ставим себя
            race.setWinner(this);
        }

        endBarrier.countDown();     // доехали до финиша, уменьшение счетчика участников
    }
}
