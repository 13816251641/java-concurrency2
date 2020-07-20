package classloader.chapter3;

/**
 * 1.类加载器的委托是优先交给父亲加载器去尝试加载
 * 2.父类加载器和子类加载器其实是一种包含关系,或者包含关系
 */
public class MyClassLoaderTest2 {

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader1 = new MyClassLoader("MyClassLoader-1");
        MyClassLoader classLoader2 = new MyClassLoader("MyClassLoader-2",classLoader1);//这个是亮点

        classLoader2.setDir("D:/abc");
        Class<?> aClass = classLoader2.loadClass("classloader.chapter3.MyObject");
        System.out.println(aClass);
        System.out.println( ((MyClassLoader)aClass.getClassLoader()).getClassLoaderName() );
    }


}