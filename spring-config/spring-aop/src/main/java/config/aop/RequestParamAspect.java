package config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
public class RequestParamAspect {
    @Pointcut(value = "execution(* config.aop.*.* (..))")
    public void pointCut(){
    }

    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around");
//        Method[] declaredMethods = joinPoint.getClass().getDeclaredMethods();
        Method[] declaredMethods = joinPoint.getClass().getMethods();
        Annotation[] annotations = joinPoint.getClass().getAnnotations();
        int modifiers = joinPoint.getClass().getModifiers();
        Class<?> superclass = joinPoint.getClass().getSuperclass();

//        System.out.println(superclass); // class java.lang.Object
//        System.out.println(modifiers); // 1
//        for (int i = 0; i < annotations.length; i++) {
//            System.out.println(annotations[i]);
//        }
//        for (int i = 0; i < declaredMethods.length; i++) {
//            System.out.println(declaredMethods[i].getName());
//        }
//        System.out.println(declaredMethods);
        Object[] args = joinPoint.getArgs();
//        System.out.println("getSignature"+joinPoint.getSignature());  // void config.aop.MyDo.print(String,String)
        for (Method method : declaredMethods) {
            Parameter[] parameters = method.getParameters();
//            System.out.println("参数个数："+parameters.length);
            for (int i = 0; i < parameters.length; i++) {
                //  获取所有的参数// 看那个位置的参数有验证
//                parameters[i].
                boolean annotationPresent = parameters[i].isAnnotationPresent(RequestParamValid.class);
                if (annotationPresent) {
                    args[i] = "修改后："+args[i];
                }

            }
        }

        return joinPoint.proceed();
    }
}
