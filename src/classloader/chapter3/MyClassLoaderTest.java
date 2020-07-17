package classloader.chapter3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        MyClassLoader classLoader = new MyClassLoader("MyClassLoader");
        Class<?> aClass = classLoader.loadClass("classloader.chapter3.MyObject");//不会初始化
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());

        Object obj = aClass.newInstance();
        Method hello = aClass.getMethod("hello", null);
        Object result = hello.invoke(obj, null);
        System.out.println(result);
    }
}