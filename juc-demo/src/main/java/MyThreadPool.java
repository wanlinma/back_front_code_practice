import java.util.concurrent.*;

public class MyThreadPool {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + "正在服务");
                try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            });
        }
        System.out.println("xx");
        executorService.shutdown();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    }
}
/*
xx
    pool-1-thread-3正在服务
    pool-1-thread-2正在服务
    pool-1-thread-1正在服务
    pool-1-thread-4正在服务
    pool-1-thread-5正在服务
    pool-1-thread-4正在服务
    pool-1-thread-3正在服务
    pool-1-thread-2正在服务
    pool-1-thread-1正在服务
    pool-1-thread-5正在服务
 */
