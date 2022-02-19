package reflect;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MethodTest {
    @Test
    public void test1() throws ClassNotFoundException {
        Class clazz1 = Class.forName("reflect.Reflect");
        Method[] methods = clazz1.getMethods();
        for (Method m : methods
        ) {
            System.out.print(m.getName());
            int modifiers = m.getModifiers();
            System.out.println(" " + Modifier.toString(modifiers));

        }
    }

    @Test
    public void test2() throws ClassNotFoundException {
        Class clazz1 = Class.forName("reflect.Reflect");
        Method[] methods = clazz1.getDeclaredMethods();
        for (Method m : methods
        ) {
            String s = Modifier.toString(m.getModifiers());
            String name = m.getReturnType().getName();
            Parameter[] parameters = m.getParameters();
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations
            ) {
                System.out.println("注解是"+a);
            }
            for (Parameter p: parameters
                 ) {
                System.out.println("参数是" + p.getType().getName());

            }
            System.out.println("\n" +s   + " " + name);
        }
        System.out.println("version1");
    }
}
