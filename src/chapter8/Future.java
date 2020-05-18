package chapter8;

/**
 * Future和AsyncFuture是对结果的封装
 * @param <T>
 */
public interface Future<T> {

    T get() throws InterruptedException;

}
