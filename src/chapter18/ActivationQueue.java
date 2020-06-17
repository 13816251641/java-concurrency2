package chapter18;

import java.util.LinkedList;

/**
 * @Auther lujieni
 * @Date 2020/6/17
 */
public class ActivationQueue {
    private final static int MAX_METHOD_REQUEST_QUEUE_SIZE = 100;
    private final LinkedList<MethodRequest> methodQueue;

    public ActivationQueue(){
        methodQueue = new LinkedList<>();
    }

    public synchronized void put(MethodRequest request){
        while (methodQueue.size() >= MAX_METHOD_REQUEST_QUEUE_SIZE){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.methodQueue.addLast(request);
        this.notifyAll();
    }

    public synchronized MethodRequest take(){
        while (methodQueue.isEmpty()){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notifyAll();
        MethodRequest methodRequest = methodQueue.removeFirst();
        return methodRequest;
    }


}
