package chapter1;

/**
 * effective java 推荐的单例模式,利用枚举类来解决
 */
public class SingletonObject8 {
    private SingletonObject8(){
    }

    private enum Singleoton{
        INSTANCE;
        private final SingletonObject8 instance;
        Singleoton(){
            instance = new SingletonObject8();
        }
        public SingletonObject8 getInstance(){
            return instance;
        }
    }

    public static SingletonObject8 getInstance(){
        return Singleoton.INSTANCE.getInstance();
    }


}
