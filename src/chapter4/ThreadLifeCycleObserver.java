package chapter4;

import java.util.List;

public class ThreadLifeCycleObserver implements LifeCycleListener{

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids){
         if (ids == null || ids.isEmpty()){
             return;
         }
         ids.stream().forEach(id -> new Thread(new ObservableRunnable(this) {//this是接口的实现类
             //new了一个ObservableRunnable的实现类,所以要实现run方法
             @Override
             public void run() {
                 try {
                     //调用父类的方法
                     notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                     System.out.println("query for the id "+id);
                     Thread.sleep(1000L);
                     notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                 }catch (Exception e){
                     notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                 }
             }
         },id).start());


    }


    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("The runnable ["+event.getThread().getName()+"] data changed and state is["+event.getState());
            if(event.getCause() != null){
                System.out.println("The runnable ["+event.getThread().getName()+"] process failed");
                event.getCause().printStackTrace();
            }
        }
    }
}
