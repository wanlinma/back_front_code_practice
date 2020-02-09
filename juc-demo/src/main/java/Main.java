import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    airConditioner.printValue1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    airConditioner.printValue2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    airConditioner.printValue3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

    }
}

class AirConditioner //资源类
{
    private int number = 1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printValue1() throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            // 干活
            number = 2;
            printf(Thread.currentThread().getName(), 5);
            condition2.signal();
        } finally {
            lock.unlock();
        }

    }

    public void printValue2() throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            // 干活
            number = 3;
            printf(Thread.currentThread().getName(), 10);
            condition3.signal();
        } finally {
            lock.unlock();
        }

    }

    public void printValue3() throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            // 干活
            number = 1;
            printf(Thread.currentThread().getName(), 15);
            condition1.signal();
        } finally {
            lock.unlock();
        }

    }


    public static void printf(String name, int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(name + "\t" + j);
        }
    }
}