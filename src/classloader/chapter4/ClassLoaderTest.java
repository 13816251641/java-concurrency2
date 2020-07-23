package classloader.chapter4;


import java.lang.reflect.Method;

public class ClassLoaderTest {


    public static void main(String[] args) throws Exception{
        DecryptClassLoader classLoader = new DecryptClassLoader();
        /* name就是class文件中的包名+类名,必须和class文件中的相一致这点很重要!!! */
        Class<?> myObject = classLoader.loadClass("classloader.chapter3.MyObject");
        System.out.println(myObject);

        Object obj = myObject.newInstance();
        Method hello = myObject.getMethod("hello", null);
        Object result = hello.invoke(obj, null);
        System.out.println(result);
    }
}