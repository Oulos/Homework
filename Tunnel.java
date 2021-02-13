package HW_5;

import java.util.concurrent.ArrayBlockingQueue;

public class Tunnel extends Stage {

    private ArrayBlockingQueue<Car> tunnelWidth;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.tunnelWidth = new ArrayBlockingQueue<>(MainClass.CARS_COUNT / 2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                tunnelWidth.put(c);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                tunnelWidth.take();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
