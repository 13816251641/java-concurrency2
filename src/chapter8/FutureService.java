package chapter8;

import java.util.function.Consumer;

/**
 * @Auther lujieni
 * @Date 2020/5/17
 * 核心 沟通了任务和结果
 * 它必然是异步的,因为new了一个线程
 */
public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> task){
        AsyncFuture<T> asyncFuture = new AsyncFuture<>();
        new Thread(()->{
            T result = task.call();
            asyncFuture.done(result);
        }).start();

        return asyncFuture;
    }

    public <T> void submit(final FutureTask<T> task, Consumer<T> consumer){
        new Thread(()->{
            T result = task.call();
            consumer.accept(result);
        }).start();
    }
}
