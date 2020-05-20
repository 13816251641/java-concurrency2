package chapter9;

import java.util.Random;

/**
 * @Auther lujieni
 * @Date 2020/5/20
 */
public class ServerThread extends Thread {
    private final RequestQueue queue;

    private final Random random;

    private volatile boolean flag = false;

    public ServerThread(RequestQueue queue){
        this.queue = queue;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        /*
            这里线程有3个地方可能被中断
            1.正好读到flag
            2.queue.getRequest中阻塞被打断返回null
            3.Thread.sleep阻塞返回return
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
        this.interrupt();
    }
}
