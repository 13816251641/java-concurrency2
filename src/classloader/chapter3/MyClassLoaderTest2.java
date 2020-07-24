package classloader.chapter3;

/**
 * 1.类加载器的委托是优先交给父亲加载器去尝试加载
 * 2.父类加载器和子类加载器其实是一种包含关系,或者包含关系
 */
public class MyClassLoaderTest2 {

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader1 = new MyClassLoader("MyClassLoader-1");
        MyClassLoader classLoader2 = new MyClassLoader("MyClassLoader-2",classLoader1);//这个是亮点


        /*
           MyClassLoader2的dir设置为d盘路径下,但d盘路径下根本没有对应的类,但还是能够加载成功
           原因就是classLoader2设置了parent为classLoader1,它交给classLoader1去加载了
         */
        classLoader2.setDir("D:/abc");
        Class<?> aClass = classLoader2.loadClass("classloader.chapter3.MyObject");
        System.out.println(aClass);
        System.out.println( ((MyClassLoader)aClass.getClassLoader()).getClassLoaderName() );
    }


}