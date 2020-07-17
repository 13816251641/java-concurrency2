package classloader.chapter2;

public class BootClassLoader {

    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("sun.boot.class.path"));//rt.jar包中含有java.lang.*的代码
        System.out.println(System.getProperty("java.ext.dirs"));

        Class<?> aClass = Class.forName("classloader.chapter1.Singleton");
        System.out.println(aClass.getClassLoader());//AppClassLoader
        System.out.println(aClass.getClassLoader().getParent());//ExtClassLoader
        System.out.println(aClass.getClassLoader().getParent().getParent());//Bootstrap 用c++编写的,所以为null
    }
}