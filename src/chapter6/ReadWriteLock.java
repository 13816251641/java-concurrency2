package chapter6;

/**
 * 最重要的锁对象
 * @Auther lujieni
 * @Date 2020/4/14
 */
public class ReadWriteLock {
    private int readingReaders=0;//可以有多个
    private int writingWriters=0;//最多只有一个
    private int waitingWriters=0;
    private boolean preferWriter=true;//默认喜欢写

    public ReadWriteLock(){
        this(true);
    }

    public ReadWriteLock(boolean preferWriter){
        this.preferWriter=preferWriter;
    }


    public synchronized void readLock() throws InterruptedException{
        try{
            /*
                read被阻塞的条件放宽了
             */
            while (writingWriters>0 || (preferWriter && waitingWriters>0)){
                this.wait();
            }
            this.readingReaders++;
        }finally {
        }
    }

    public synchronized void readUnlock(){
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock()throws InterruptedException{
        this.waitingWriters++;
        try{
            while (writingWriters>0||readingReaders>0){
                this.wait();
            }
            this.writingWriters++;
        }finally {
            this.waitingWriters--;
        }
    }

    public synchronized void writeUnlock(){
        this.writingWriters--;
        this.notifyAll();
    }

}
