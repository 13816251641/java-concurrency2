package chapter2;


import java.util.Optional;
import java.util.stream.IntStream;

/**
 * 1.所有的对象都会有一个wait set,用来存放调用了该对象wait之后进入block状态线程
 * 2.线程被notify之后,不一定立即得到执行
 * 3.线程从wait set中被唤醒顺序不一定FIFO(先进先出)
 * 4.线程被唤醒后,必须重新获取锁
 */
public class WaitSet {
    private static final Object LOCK = new Object();
    public static void main(String[] args) throws InterruptedException{
        IntStream.rangeClosed(1,10).forEach(i->new Thread(String.valueOf(i)){
            @Override
            public void run() {
               synchronized (LOCK){
                   try {
                       Optional.of(Thread.currentThread().getName()+" will come to wait set.").ifPresent(System.out::println);
                       LOCK.wait();
                       Optional.of(Thread.currentThread().getName()+" will leave to wait set.").ifPresent(System.out::println);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }.start());
        Thread.sleep(1000);

        IntStream.rangeClosed(1,10).forEach(i->{
            synchronized (LOCK){
                LOCK.notify();//notify不会立即释放锁
                try {
                    Thread.sleep(7_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
