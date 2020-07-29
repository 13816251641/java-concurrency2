package classloader.chapter6;

import classloader.chapter1.Singleton;
import classloader.chapter3.MyClassLoader;
import sun.reflect.Reflection;

import java.sql.DriverManager;

public class ThreadContextClassLoader {

    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);//app加载器

        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());//MyClassLoader加载器
        System.out.println(String.class.getClassLoader());

    }

}