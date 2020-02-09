
import java.util.concurrent.TimeUnit;

class Phone {
    Object object = new Object();

    public void sendSMS() throws Exception {
        synchronized (object) {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("------sendSMS");
        }

    }

    public void sendEmail() throws Exception {
        System.out.println("------sendEmail");
    }

    public void getHello() {
        System.out.println("------getHello");
    }

}

public class Lock_8 {
    public static void main(String[] args) throws Exception {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        System.out.println("-----------处理--------");
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();
        new Thread(() -> {
            try {
                phone.sendEmail();
                //phone.getHello();
                //phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}


