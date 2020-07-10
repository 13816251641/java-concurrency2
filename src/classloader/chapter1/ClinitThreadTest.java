package classloader.chapter1;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * jvm会保证类加载的线程安全
 */
public class ClinitThreadTest {
    public static void main(String[] args) {
        new Thread(()->new SimpleObject()).start();
        new Thread(()->new SimpleObject()).start();

    }

    static class SimpleObject{
        private static AtomicBoolean init = new AtomicBoolean(true);

        static {
            System.out.println(Thread.currentThread().getName()+" i will be init");
            while (init.get()){

            }
            System.out.println(Thread.currentThread().getName()+" i am finished");
        }
    }
}