package chapter1;

/**
 * 阿君喜欢的单例模式,利用静态内部类实现
 */
public class SingletonObject6 {

    private void show(){
        System.out.println("show");
    }

    private SingletonObject6(){
    }
    private static class InstanceHolder{
        private final static SingletonObject6 instance = new SingletonObject6();
        static {
            System.out.println("static代码块");
        }
        public InstanceHolder(){
            System.out.println("InstanceHolder");
        }
    }
    public static SingletonObject6 getInstance(){
        return InstanceHolder.instance;//外部类可以访问内部类私有的属性及方法
    }
    public static void main(String[] args) {
        SingletonObject6.getInstance();
        SingletonObject6.getInstance();

/*        SingletonObject6 s = new SingletonObject6();
        s.show();*/


    }
}
