package chapter1;

/**
 * double check方式,阿君说会有空指针问题,因为
 * 编译器会帮我们进行优化,导致即使SingletonObject4
 * 的实例存在,里面依赖的其他属性也还没有初始化
 */
public class SingletonObject4 {
    private static SingletonObject4 instance;
    private SingletonObject4(){

    }
    public static SingletonObject4 getInstance(){
        if(null == instance)
            synchronized (SingletonObject4.class){
                if (null == instance){
                    instance = new SingletonObject4();
                }
            }
        return SingletonObject4.instance;
    }
}
