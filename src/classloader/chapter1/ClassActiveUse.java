package classloader.chapter1;

import java.util.Random;

/**
 * @Auther lujieni
 * @Date 2020/6/30
 * 对类的主动调用才会执行初始化操作
 */
public class ClassActiveUse {

    public static void main(String[] args) throws Exception {

        /*
            new一个对象肯定会执行初始化
            new Obj();
         */

        /*
            非final类型的静态变量会执行初始化
            System.out.println(Obj.salary);
         */

        /*
           调用静态方法会执行初始化
           Obj.printSalary();
         */

        /*
          调用Class.forName会执行初始化
          Class.forName("classloader.chapter1.Obj");
         */


        /*
           调用子类的静态字段,会先初始化父类再初始化子类
           System.out.println(Child.age);
        */

        /*
         2
           用子类调用父类的静态成员,只会初始化父类!!!
           System.out.println(Child.salary);
         */

        /*
         3
           static final修饰的基本变量不会触发初始化,会在编译期间放入常量池
           System.out.println(Obj.age);
        */

        /*
         4
           Obj.x在编译期间无法得出,所以会导致初始化
         */
        //System.out.println(Obj.x);
    }

}

class Obj{
    public static long salary = 100000L;

    public static final int age = 28;

    public static final int x = new Random().nextInt(100);


    static {
        System.out.println("Obj 被初始化");
    }

    public static void printSalary(){
        System.out.println("printSalary");
    }
}

class Child extends Obj{
    public static int age = 29;

    static {
        System.out.println("Child 被初始化");
    }
}



interface I{
    int a = 10;
}

//访问某个类或者接口的的静态变量,或者对该静态变量进行赋值操作
//1.对某个类的静态变量进行读写 ->class
//2.对接口中静态变量进行读取   ->interface
