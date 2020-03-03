package chapter1;

/**
 * 阿君喜欢的单例模式
 */
public class SingletonObject7 {
    private SingletonObject7(){
    }
    private static class InstanceHolder{
        private final static SingletonObject7 instance = new SingletonObject7();
        static {
            System.out.println("static代码块");
        }
        public InstanceHolder(){
            System.out.println("InstanceHolder");
        }
    }
    public static SingletonObject7 getInstance(){
        return InstanceHolder.instance;//外部类可以访问内部类私有的属性及方法
    }
    public static void main(String[] args) {
        SingletonObject7.getInstance();
        SingletonObject7.getInstance();

    }
}
