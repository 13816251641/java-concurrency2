package chapter1;

/**
 * double check方式,阿君说会有空指针问题,因为
 * 编译器会帮我们进行优化,导致即使SingletonObject4
 * 的实例存在,里面依赖的其他属性也还没有初始化
 *
 * 这样实现的单例其实是不安全的，执行语句4时，实际包含3个步骤：
 * a. 给SingletonObject4分配内存
 * b. 在内存中初始化SingletonObject4对象
 * c. 将内存地址赋给SingletonObject4变量（这时SingletonObject4变量就不为null了）
 *
 * volatile:读操作在写操作的后面
 *
 *
 * 4是一个复杂的步骤,涉及到给SingletonObject4分配内存,但这时候可能instance不为空但里面
 * 的参数还没赋值,这样就会有问题
 *
 */
public class SingletonObject4 {
    private static SingletonObject4 instance;
    private SingletonObject4(){

    }
    public static SingletonObject4 getInstance(){
        if(null == instance) //1
            synchronized (SingletonObject4.class){ //2
                if (null == instance){ //3
                    instance = new SingletonObject4();//4
                }
            }
        return SingletonObject4.instance;
    }
}
