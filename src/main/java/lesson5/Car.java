package lesson5;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {

    private static int CARS_COUNT;

    CountDownLatch countDownLatchStart;

    CountDownLatch countDownLatchOver;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(MainClass.CARS_COUNT);



    static {
        CARS_COUNT = 0;

    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch countDownLatchStart, CountDownLatch countDownLatchOver) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.countDownLatchStart = countDownLatchStart;
        this.countDownLatchOver = countDownLatchOver;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            countDownLatchStart.countDown();
            cyclicBarrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        countDownLatchOver.countDown();
    }
}
