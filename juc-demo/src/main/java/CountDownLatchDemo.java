import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6; i++) //6个上自习的同学，各自离开教室的时间不一致
        {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 号同学离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t****** 班长关门走人，main线程是班长");
    /**
         1	 号同学离开教室
         2	 号同学离开教室
         3	 号同学离开教室
         4	 号同学离开教室
         6	 号同学离开教室
         5	 号同学离开教室
         main	****** 班长关门走人，main线程是班长
     */
    }
}
