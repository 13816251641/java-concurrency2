package chapter1;

/**
 * 解决double check的空指针问题
 */
public class SingletonObject6 {
    private static volatile SingletonObject6 instance;
    private SingletonObject6(){

    }
    public static SingletonObject6 getInstance(){
        if(null == instance)
            synchronized (SingletonObject6.class){
                if (null == instance){
                    instance = new SingletonObject6();
                }
            }
        return SingletonObject6.instance;
    }
}
