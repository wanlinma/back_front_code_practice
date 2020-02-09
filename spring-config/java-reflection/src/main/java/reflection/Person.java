package reflection;

import lombok.Data;

import java.util.List;
@Data
public class Person   implements Comparable<Integer>,Runnable {
    private String name;
    private List<String> list;
    public int[] arrInt;
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void print(String age){
        System.out.println("Person.print:"+name+"-"+age);
    }


    public Boolean print(String age,String email){
        System.out.println("age:"+age+",eamil:"+email);
        return true;
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }

    @Override
    public void run() throws ArrayIndexOutOfBoundsException {

    }


}
