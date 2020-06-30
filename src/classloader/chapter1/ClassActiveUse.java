package classloader.chapter1;

/**
 * @Auther lujieni
 * @Date 2020/6/30
 * 对类的主动调用才会执行初始化操作
 */
public class ClassActiveUse {

    public static void main(String[] args) throws Exception {
        /*
            new Obj();
            System.out.println(I.a);
        */
        //System.out.println(Obj.salary);
        //Obj.printSalary();

        //Class.forName("classloader.chapter1.Obj");

        /*
           调用子类的静态字段,会先初始化父类再初始化子类
           System.out.println(Child.age);
         */

        /*
           用子类调用父类的salary,只会初始化父类!!!
         */
        System.out.println(Child.salary);
    }

}

class Obj{
    public static long salary = 100000L;

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
