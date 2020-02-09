package config.aop;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Service
public class MyDo {

    public void print(@RequestParamValid String name,@RequestParamValid String name2){
        System.out.println(name+" "+name2);
    }
    public void print2(String name){
        System.out.println(name);
    }
}
