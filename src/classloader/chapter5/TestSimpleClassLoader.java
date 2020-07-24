package classloader.chapter5;

public class TestSimpleClassLoader {

    public static void main(String[] args) throws Exception {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("classloader.chapter5.MyObject");
        System.out.println(aClass.getClassLoader());
    }
}