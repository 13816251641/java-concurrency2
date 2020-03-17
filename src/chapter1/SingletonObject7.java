package chapter1;

/**
 * effective java 推荐的单例模式,利用枚举类来解决
 */
public class SingletonObject7 {
    private SingletonObject7(){
    }

    private enum Singleoton{
        INSTANCE;
        private final SingletonObject7 instance;
        Singleoton(){
            instance = new SingletonObject7();
        }
        public SingletonObject7 getInstance(){
            return instance;
        }
    }

    public static SingletonObject7 getInstance(){
        return Singleoton.INSTANCE.getInstance();
    }


}
