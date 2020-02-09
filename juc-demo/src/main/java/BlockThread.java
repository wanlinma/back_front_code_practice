import java.util.concurrent.BlockingQueue;

public class BlockThread {

    public void change(String   str) {
        str= new String("xxx");
    }


    public static void main(String[] args) {
        BlockThread blockThread = new BlockThread();
        String s = "abc";
        blockThread.change(s);
    }
}
