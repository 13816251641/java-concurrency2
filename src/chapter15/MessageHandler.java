package chapter15;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Auther lujieni
 * @Date 2020/5/28
 */
public class MessageHandler {

    private final static Random random = new Random(System.currentTimeMillis());

    private final static Executor executor = Executors.newFixedThreadPool(5);

    public void request(Message message){
        /* executor.execute()方法本身就是异步的 */
        executor.execute(()->{
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The message will be handle by "+Thread.currentThread().getName()+" "+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

      /*
        自己创建线程
        new Thread(()->{
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The message will be handle by "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
      */
    }
}
