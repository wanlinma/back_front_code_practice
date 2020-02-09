import java.util.concurrent.TimeUnit;

public class Test {
    private  CallableDemo c;

    public Test(CallableDemo c) {
        this.c = c;
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.HOURS.toSeconds(1));
    }
}
