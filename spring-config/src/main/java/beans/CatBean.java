package beans;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
@ToString
public class CatBean {
    private String name;
    private Integer age;
}
