package HW_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier stageCounter;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }



    public Car(Race race, int speed, CyclicBarrier stageCounter) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.stageCounter = stageCounter;

    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            stageCounter.await();
            } catch (Exception e) {
            e.printStackTrace();
        }
        int countOfStages = race.getStages().size();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            countOfStages--;
            if (countOfStages == 0 && !race.getWinner()) {
                race.setWinner();
                System.out.println(this.name + " WIN");
            }
        }
        try {
            stageCounter.await();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
