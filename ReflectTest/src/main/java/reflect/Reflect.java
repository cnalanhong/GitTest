package reflect;

@MyAnnotation
public class Reflect extends ReflectFather<Integer> implements Comparable<String> {
    @MyAnnotation
    private String name;
    public int age;
    String address;
    Integer id;


    @MyAnnotation(value = "hi")
    public void show() {
        System.out.println("hello");
    }

    public String display(String name, int age, Reflect reflect) {
        return name + age;
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }
}
