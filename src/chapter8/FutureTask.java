package chapter8;

/**
 * 对任务的封装
 * @param <T>
 */
@FunctionalInterface
public interface FutureTask<T>  {

    T call();

}
