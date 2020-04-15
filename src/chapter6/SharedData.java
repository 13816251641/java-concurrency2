package chapter6;

/**
 * @Auther lujieni
 * @Date 2020/4/15
 * 资源对象
 */
public class SharedData {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size){
        buffer=new char[size];
        for(int i=0;i<size;i++){
            this.buffer[i]='*';
        }
    }

    public void write(char c)throws InterruptedException{
        try{
            lock.writeLock();
            doWrite(c);
        }finally {
            lock.writeUnlock();
        }
    }

    public char[] read() throws InterruptedException{
        try {
            lock.readLock();
            return doRead();
        }finally {
            lock.readUnlock();
        }
    }

    private void doWrite(char c){
        for(int i=0;i<buffer.length;i++){
            buffer[i]=c;
            slowly(10);
        }
    }



    private char[] doRead(){
        char[] newBuf=new char[buffer.length];
        for(int i=0;i<buffer.length;i++){
            newBuf[i]=buffer[i];
        }
        return newBuf;
    }

    private void slowly(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
