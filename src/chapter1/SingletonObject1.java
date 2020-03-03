package chapter1;

/**
 * 饿汉加载,绝对没问题
 */
public class SingletonObject1 {

    private static final SingletonObject1 instance = new SingletonObject1();//放入堆中

    /*
       私有构造方法,外部不能直接new
     */
    private SingletonObject1(){

    }

    public static SingletonObject1 getInstance(){
        return instance;
    }

}
