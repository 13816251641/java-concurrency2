package chapter6;

/**
 * @Auther lujieni
 * @Date 2020/4/15
 */
public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);//10个*
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new WriterWork(sharedData,"abcdefghi").start();
        new WriterWork(sharedData,"123456789").start();
    }
}
