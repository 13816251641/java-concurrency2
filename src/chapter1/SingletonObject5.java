package chapter1;

/**
 * double check方式,阿君说会有空指针问题,因为
 * 编译器会帮我们进行优化,导致即使SingletonObject4
 * 的实例存在,里面依赖的其他属性也还没有初始化
 */
public class SingletonObject5 {
    private static SingletonObject5 instance;
    private SingletonObject5(){

    }
    public static SingletonObject5 getInstance(){
        if(null == instance)
            synchronized (SingletonObject5.class){
                if (null == instance){
                    instance = new SingletonObject5();
                }
            }
        return SingletonObject5.instance;
    }
}
