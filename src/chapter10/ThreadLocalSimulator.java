package chapter10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther lujieni
 * @Date 2020/5/21
 * 始终以当前线程作为key值
 */
public class ThreadLocalSimulator<T> {

    private final Map<Thread,T> storage = new HashMap<>();

    public void set (T t){
        /* 加锁是因为HashMap线程不安全 */
        synchronized (this){
            Thread key = Thread.currentThread();
            storage.put(key,t);
        }
    }

    public T get(){
        synchronized (this){
            Thread key = Thread.currentThread();
            T value = storage.get(key);
            if(value == null){
                return initialValue();
            }
            return value;
        }
    }

    public T initialValue(){
        return null;
    }



}
