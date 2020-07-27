package classloader.chapter5;

public class RuntimePackage {

    public static void main(String[] args) throws Exception{
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("classloader.chapter5.MyObject");
        System.out.println(aClass.getClassLoader());//SimpleClassLoader

        /*
            阿君说加载RuntimePackage的类加载器和加载MyObject的类加载器命名空间不同,
            不同命名空间下的类加载器之间的类互相不可访问
         */
        MyObject myObject = (MyObject)aClass.newInstance();
    }


}