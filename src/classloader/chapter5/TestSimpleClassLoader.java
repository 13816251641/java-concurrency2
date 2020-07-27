package classloader.chapter5;

public class TestSimpleClassLoader {

    public static void main(String[] args) throws Exception {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("classloader.chapter5.MyObject");
        //Class<?> aClass = simpleClassLoader.loadClass("java.lang.Person");java.lang的包名是被禁止的
        System.out.println(aClass.getClassLoader());
    }
}