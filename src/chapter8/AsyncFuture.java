package chapter8;

/**
 * @Auther lujieni
 * @Date 2020/5/17
 */
public class AsyncFuture<T> implements Future<T> {

    /*
      不需要加volatile,因为有synchronized关键字
     */
    private boolean done = false;

    private T result;

    public void done(T result){
        synchronized (this){
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }

    /*
        主线程可以问AsyncFuture要数据,但如果任务还没
        完成就会阻塞
     */
    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while(!done){
                this.wait();
            }
        }
        return result;
    }
}
