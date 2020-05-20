package chapter6;

/**
 * @Auther lujieni
 * @Date 2020/4/15
 */
public class ReaderWorker extends Thread {

    private final SharedData data;

    public ReaderWorker(SharedData data){
        this.data = data;
    }

    @Override
    public void run() {
        try{
            while (true){
                char[] readBuf = data.read();//buf里面的全都读取出来
                System.out.println(Thread.currentThread().getName()+" reads "+String.valueOf(readBuf));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
