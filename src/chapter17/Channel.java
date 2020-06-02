package chapter17;

import java.util.Arrays;

/**
 * @Auther lujieni
 * @Date 2020/6/2
 */
public class Channel {

    private final static int MAX_REQUEST = 100;

    private final Request [] requestQueue;//流水线滚动台

    private int head;

    private int tail;

    private int count;

    private final WorkerThread[] workerPool;//工人池

    public Channel(int workers){
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.workerPool = new WorkerThread[workers];
        this.init();
    }

    private void init(){
        for(int i=0;i<workerPool.length;i++){
            workerPool[i]=new WorkerThread("Worker-"+i,this);
        }
    }

    /**
     * let all of worker to work
     */
    public void startWorker(){
        Arrays.asList(workerPool).forEach(t->{
            t.start();
        });
    }

    /**
     * 往流水线上放
     * @param request
     */
    public synchronized void put(Request request){
        while(count>requestQueue.length){
            try{
                this.wait();
            }catch (InterruptedException e){

            }
        }
        this.requestQueue[tail]=request;
        this.tail=(tail+1)%requestQueue.length;
        this.count++;
        this.notifyAll();
    }

    /**
     * 从流水线上取
     * @return
     */
    public synchronized Request take(){
        while (count==0){
            try{
                this.wait();
            }catch (InterruptedException e){

            }
        }
        Request request = this.requestQueue[head];
        this.head=(this.head+1)%this.requestQueue.length;
        this.count--;
        this.notifyAll();
        return request;
    }
}
