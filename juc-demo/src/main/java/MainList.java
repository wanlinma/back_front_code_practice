import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class MainList {
    public static void main(String[] args) {

//        List<String> list = new CopyOnWriteArrayList();
//        for (int i = 0; i < 30; i++) {
//            int finalI = i;
//            new Thread(()->{
//                list.add(String.valueOf(finalI));
//                System.out.println(list);
//            }).start();
//        }
        System.out.println(MainList.test());

        HashSet<Object> objects = new HashSet<>();

        HashMap<String, String> stringStringHashMap = new HashMap<>(20);
        System.out.println(stringStringHashMap.size());

        new ConcurrentHashMap<>();
        new CopyOnWriteArrayList<>();
        new CopyOnWriteArraySet<>();


    }

    public static boolean test() {
        try {
            System.out.println("try 内");
            return true;
        } finally {
            System.out.println("finally 内");
        }
    }

}
