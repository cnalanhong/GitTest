package reflect;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class otherTest {
    @Test
    public void test() {
        Class clazz = Reflect.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0].getTypeName());
    }

    @Test
    public void test1() {
        Class clazz = Reflect.class;
        Class[] interfaces = clazz.getInterfaces();
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();

        for (Class c : interfaces1
        ) {
            System.out.println(c);
        }


    }

    @Test
    public void test2() {
        Class clazz = Reflect.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage.getName());

    }

    @Test
    public void test3() {
        Class clazz = Reflect.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations
        ) {
            System.out.println(anno);
        }

    }

    @Test
    public void test4() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class clazz = Reflect.class;
        Reflect reflect = (Reflect) clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(reflect, "alan");
        System.out.println(name.get(reflect));
        ;

    }

    @Test
    public void test5() throws NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Reflect.class;
        Reflect reflect = (Reflect) clazz.newInstance();
        Method show = clazz.getDeclaredMethod("display", String.class, int.class, Reflect.class);

        Object o = show.invoke(reflect, "alan", 10, reflect);
        System.out.println(o);
    }

    @Test
    public void test6() throws NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object a;
        String b = "heloo";
        a = b;
        System.out.println(a);
    }

    @Test
    public void LambdaTest() {
        happyTime(500.0, aaa -> System.out.println("here is the money" + aaa));
    }

    public void happyTime(Double money, Consumer<Double> con) {
        con.accept(money);


    }

    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean1.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println(user);
    }

}


