import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

public class MyCustomThreadPoolExecutors {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                2,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

/*        ThreadPoolExecutor.AbortPolicy;
        ThreadPoolExecutor.DiscardOldestPolicy;
        ThreadPoolExecutor.CallerRunsPolicy;
        ThreadPoolExecutor.DiscardPolicy;*/
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName() + "运行");
                try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            });
        }
        threadPoolExecutor.shutdown();
    }
}
