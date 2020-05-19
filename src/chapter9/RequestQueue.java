package chapter9;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther lujieni
 * @Date 2020/5/19
 */
public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest(){
        synchronized (queue){
            while (queue.size()==0){
                try {
                    queue.wait();//会释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.removeFirst();
        }
    }

    public void putRequest(Request request){
        synchronized (queue){
            queue.add(request);
            queue.notifyAll();
        }
    }


}
