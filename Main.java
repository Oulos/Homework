package HW_4;

public class Main {
    static Object monitor = new Object();
    static volatile String letter = "A";


    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (!letter.equals("A")) {
                                monitor.wait();
                            }
                            System.out.print("A");
                            letter = "B";
                            monitor.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (!letter.equals("B")) {
                                monitor.wait();
                            }
                            System.out.print("B");
                            letter = "C";
                            monitor.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (!letter.equals("C")) {
                                monitor.wait();
                            }
                            System.out.print("C");
                            letter = "A";
                            monitor.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }

}
