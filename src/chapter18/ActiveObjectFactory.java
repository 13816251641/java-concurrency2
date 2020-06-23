package chapter18;

/**
 * @Auther lujieni
 * @Date 2020/6/22
 */
public class ActiveObjectFactory {

    private ActiveObjectFactory(){

    }

    public static ActiveObject init(){
        Servant servant = new Servant();
        ActivationQueue queue = new ActivationQueue();
        SchedulerThread schedulerThread = new SchedulerThread(queue);//SchedulerThread是一个线程
        ActiveObjectProxy proxy = new ActiveObjectProxy(schedulerThread,servant);
        schedulerThread.start();
        return proxy;
    }


}
