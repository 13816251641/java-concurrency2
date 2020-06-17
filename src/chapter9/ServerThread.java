package chapter9;

import java.util.Random;

/**
 * @Auther lujieni
 * @Date 2020/5/20
 * 不断处理任务
 */
public class ServerThread extends Thread {
    private final RequestQueue queue;

    private final Random random;

    private volatile boolean flag = false;//必须要加,多个线程下的可见性

    public ServerThread(RequestQueue queue){
        this.queue = queue;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        /*
            这里线程有3个地方可能被中断
            1.queue.getRequest中阻塞后被打断返回null
            2.Thread.sleep阻塞返回return
            3.正好读到flag

         */
        while (!flag){
            Request request = queue.getRequest();
            if(null == request){
                System.out.println("Receive the empty request.");
                continue;
            }
            System.out.println("Server->"+request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void close(){
        this.flag = true;
        this.interrupt();//打断ServerThread这个线程
    }
}
