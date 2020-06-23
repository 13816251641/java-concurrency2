package chapter18;

/**
 * @Auther lujieni
 * @Date 2020/6/22
 */
public class ActiveObjectFactory {

    private ActiveObjectFactory(){

    }

    public static ActiveObject init(){
        Servant servant = new Servant();//工作类
        ActivationQueue queue = new ActivationQueue();//任务队列
        SchedulerThread schedulerThread = new SchedulerThread(queue);//SchedulerThread是一个线程
        ActiveObjectProxy proxy = new ActiveObjectProxy(schedulerThread,servant);
        schedulerThread.start();//启动线程
        return proxy;
    }


}
