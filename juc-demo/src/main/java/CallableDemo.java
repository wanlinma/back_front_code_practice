import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {


    @Override
    public String call() throws Exception {
        System.out.println("call 调用...");
        Thread.sleep(3000);
        return "call over";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask futureTask = new FutureTask(callableDemo);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());// get 一般放在最后
        /**
         * call 调用...
         * call over
         */
    }

}
