import sun.misc.ThreadGroupUtils;

import java.util.concurrent.TimeUnit;

public class MyThreadGroup {
    public static void main(String[] args) {
        ThreadGroup group1 = new ThreadGroup("group1");
        new Thread(group1,()->{
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread1").start();
        new Thread(group1, ()->{
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread2").start();
        System.out.println(group1.activeCount());
    }
}
