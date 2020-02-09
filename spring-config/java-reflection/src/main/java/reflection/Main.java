package reflection;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import org.springframework.util.ReflectionUtils;
import org.testng.annotations.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

@Data
public class Main {
    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException, IntrospectionException {

//        Class<?> pClass = Class.forName("reflection.Person");
        // 类信息
        System.out.println("----------------------类反射信息----------------------");
//        System.out.println("getSimpleName:"+pClass.getSimpleName()); // Person // 得到类名 Person
//        System.out.println("getName:"+pClass.getName()); // reflection.Person // 得到全类名
//        System.out.println("Modifier:"+Modifier.toString(pClass.getModifiers())); // public // 返回类 修饰符 private public ...
//        Annotation[] annotations = pClass.getAnnotations();
//        for (int i = 0; i < annotations.length; i++) {
//            System.out.println("Annotation："+annotations[i]);
//        }
//        Class<?> superclass = pClass.getSuperclass();
//        System.out.println("superclass:"+superclass); // java 单继承多实现 // class java.lang.Object
//        Class<?>[] interfaces = pClass.getInterfaces();
//        for (int i = 0; i < interfaces.length; i++) {
//            System.out.println("interfaces getName:"+interfaces[i].getName()); // java.lang.Comparable // java.lang.Runnable
//        }
//        Class<?>[] classes = pClass.getClasses();
//        for (int i = 0; i < classes.length; i++) {
//            System.out.println("classes getName "+classes[i].getName());
//        }

        // 字段信息
        System.out.println("----------------------字段反射信息----------------------");
//        Field[] fields = pClass.getFields(); // 方法返回所有可访问的公共字段在类中声明或继承自超类。
//        for (int i = 0; i < fields.length; i++) {
//            System.out.print("field getName:"+fields[i].getName()+"\n"); // staticValue
//            System.out.print("field getType:"+fields[i].getType()+"\n"); // char
//        }

//        Field[] declaredFields = pClass.getDeclaredFields(); // 方法返回所有字段只出现在类的声明中(不是从继承的字段)。
//        for (int i = 0; i < declaredFields.length; i++) {
//            System.out.print("declaredFields getName:"+declaredFields[i].getName()+"\n"); // name // staticValue
//            System.out.print("declaredFields getType:"+declaredFields[i].getType()+"\n"); // class java.lang.String // char
//            System.out.print("declaredFields getChar:"+declaredFields[1].getChar("staticValue")+"\n"); // 静 // 静
//            System.out.print("declaredFields getGenericType:"+declaredFields[i].getGenericType()+"\n"); // class java.lang.String // char
//        }

        // 方法信息
//        Method print = pClass.getDeclaredMethod("print", String.class);
//        print.invoke(pClass.newInstance(),"张三"); // null-张三

//        Method[] declaredMethods = pClass.getDeclaredMethods();  // 返回 Object类方法、类、接口里声明的方法、包括 pubilc ,protected,private default,除了继承的方法
//        for (int i = 0; i < declaredMethods.length; i++) {
//            System.out.println("---------------------- 方法反射信息 ----------------------");
//            Class<?> returnType = declaredMethods[i].getReturnType();
//            System.out.println("declaredMethods getReturnType getName "+returnType.getName()); // void  boolean  java.lang.String int int ...
//            Class<?>[] classes = returnType.getClasses();
//
//            for (int i1 = 0; i1 < classes.length; i1++) {
//                System.out.println("classes getName:"+classes[i1].getName());
//            }
//
//            System.out.println("declaredMethods getName :"+declaredMethods[i].getName()); // run equals
//            Class<?>[] exceptionTypes = declaredMethods[i].getExceptionTypes(); // java.lang.ArrayIndexOutOfBoundsException
//            Type[] genericExceptionTypes = declaredMethods[i].getGenericExceptionTypes();
//
//            for (int i1 = 0; i1 < genericExceptionTypes.length; i1++) {
//                System.out.println("genericExceptionTypes getTypeName:"+genericExceptionTypes[i1].getTypeName()); // java.lang.ArrayIndexOutOfBoundsException
//            }
//
//            for (int i1 = 0; i1 < exceptionTypes.length; i1++) {
//                System.out.println("exceptionTypes getName :"+exceptionTypes[i1].getName());
//            }
//            //
//            System.out.println("----------------------方法参数反射信息----------------------");
//            Parameter[] parameters = declaredMethods[i].getParameters();
//            for (int j = 0; j < parameters.length; j++) {
//                int modifiers = parameters[j].getModifiers();
//                int mod = modifiers & Modifier.parameterModifiers();
//                System.out.println("mod:"+mod);
//                System.out.println("parameter modifiers:"+modifiers);
//                System.out.println("parameter modifiers String:"+Modifier.toString(modifiers));
//                int parameterModifiers = Modifier.parameterModifiers();
//                System.out.println("parameter parameterModifiers String:"+Modifier.toString(parameterModifiers));
//                System.out.println("parameter parameterModifiers:"+parameterModifiers);
//                System.out.println("parameter getType().getSimpleName():"+parameters[j].getType().getSimpleName());
//                System.out.println("parameter getType().getName():"+parameters[j].getType().getName());
//                String typeName = parameters[j].getParameterizedType().getTypeName();
//                System.out.println("parameter getParameterizedType().getTypeName():"+typeName);
//                String name = parameters[j].getDeclaringExecutable().getName();
//                System.out.println("parameter getDeclaringExecutable().getName():"+name);
//            }
//
//        }

        System.out.println("---------------------- 构造方法反射 ----------------------");
//        Constructor<?>[] constructors = pClass.getDeclaredConstructors(); // 方法返回当前和超类的所有公共构造函数
//        pClass.getDeclaredConstructors();// 方法返回当前类的所有声明的构造函数。
////        getConstructor(Class<?>... parameterTypes) // 参数类型获取构造函数对象。
////        getDeclaredConstructor(Class<?>... parameterTypes)  // 参数类型获取构造函数对象。
//
//
//        for (int i = 0; i < constructors.length; i++) {
//            int mod = constructors[i].getModifiers() & Modifier.constructorModifiers();
//            String modifier = Modifier.toString(mod);
//            String constructorName = constructors[i].getName();
//            System.out.print(modifier + " " + constructorName+" " +"(");
//            Parameter[] parameters = constructors[i].getParameters();
//            String temp="";
//            if (parameters.length==0) {
//                System.out.println(temp+")");
//            }
//            for (Parameter parameter : parameters) {
//                int modP = parameter.getModifiers() & Modifier.parameterModifiers();
//                String modifierP = Modifier.toString(modP);
//                String paramType = parameter.getType().getSimpleName();
//                String parmName  = parameter.getName();
////                String ParameterizedTypeName = parameter.getParameterizedType().getTypeName(); // java.lang.String
//                temp = modifierP+" "+ paramType +" " + parmName;
//                System.out.println(temp+")");
//                temp="";
//            }


////            System.out.println("constructors[i] getName："+constructors[i].getName()); // reflection.Person // reflection.Person  // reflection 是 包名 。
//
////            System.out.println("constructors[i] getParameterCount:"+constructors[i].getParameterCount()); //  0 1
//            System.out.println("constructors[i] getModifiers: "+Modifier.toString(constructors[i].getModifiers())); // public public // default 构造器 输出的是空
//            System.out.println("constructors[i] getModifiers & :"+getModifiers(constructors[i])); //public public  // default 构造器 输出的是空
//        }

        System.out.println("---------------------- 反射对象创建 ----------------------");
//        Class<Person> personClass = Person.class; // Class 引用 ，创建该类对象，等效使用 new 运算符的无参构造
//        Person person = personClass.newInstance();
//        Constructor<Person> personConstructor = personClass.getDeclaredConstructor(String.class);
//        Person person = personConstructor.newInstance("张三");
//        person.print("12"); // 张三 12
        System.out.println("---------------------- 反射字段访问 ----------------------");
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
//        Field name = personClass.getDeclaredField("name");  // Class reflection.Main can not access a member of class reflection.Person with modifiers "private" // protected public 可以
//        name.set(person,"张三");
//        System.out.println(name.get(person));
//        person.print("12"); // 张三-12


//        name.setAccessible(true);
//        name.set(person,"张三");
//        System.out.println(name.get(person));
//        person.print("12"); // 张三-12

//         给 ArrayList 赋值
//        Field list = personClass.getDeclaredField("list");
//        System.out.println(list.getGenericType().getTypeName()); // java.util.List<java.lang.String>
//        list.setAccessible(true);
//        list.set(person, Arrays.asList("1,2,3"));
//        System.out.println(list.get(person)); // [1,2,3]

//        Field[] declaredFields = personClass.getDeclaredFields();
//        for (Field field : declaredFields) {
//
//            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),Person.class);
//            Method readMethod = propertyDescriptor.getReadMethod();// 获取 get 方法
//            Object invoke = readMethod.invoke(Person.class.newInstance());
//            System.out.println(invoke);
//        }




        // 展开数组
//        int[] ids = new int[2];
//        Class<? extends int[]> aClass = ids.getClass();
//
//        Object newArray = Array.newInstance(aClass.getComponentType(), 3);
//        System.arraycopy(ids,0,newArray,0,2);
//        System.out.println(Arrays.toString((int[]) newArray));

        // 多此一举
//        int[] oldArray = new int[2];
//        oldArray[0]=1;
//        oldArray[1]=2;
//        int [] newArray = new int[3];
//        System.arraycopy(oldArray,0,newArray,0,2);
//        System.out.println(Arrays.toString(newArray));


    }
//    public static String getModifiers(Executable exec) {
//        int mod = exec.getModifiers();
//        if (exec instanceof Method) {
//            mod = mod & Modifier.methodModifiers();
//        } else if (exec instanceof Constructor) {
//            mod = mod & Modifier.constructorModifiers();
//        }
//        return Modifier.toString(mod);
//    }


    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Person person = new Person("张三");

        Class personClass = person.getClass();
        Person personNewInstance = (Person)personClass.newInstance();
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            System.out.println(name);
            field.setAccessible(true);
            Object o = personClass.getField(name).get(person);
            field.set(personNewInstance,o);
        }
        System.out.println(personNewInstance);
    }
}
