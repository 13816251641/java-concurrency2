package chapter9;

import java.util.LinkedList;

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
                    return null;
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
