package chapter7.demo2;

/**
 * @Auther lujieni
 * @Date 2020/4/19
 * 原本是想比较无锁和加锁之间的性能差异,但感觉并不明显。
 * 猜想是jdk做了优化?
 */
public class ImmutablePerformance {


    public static void main(String[] args) throws InterruptedException{
        long startTimestamp = System.currentTimeMillis();
        ImmutableObj immutableObj= new ImmutableObj("Alex");//10793
        //SyncObj syncObj=new SyncObj();//10168 10343
        Thread t1=new Thread(){
            @Override
            public void run() {
                for(long l=0;l<1000000;l++){
                    System.out.println(Thread.currentThread().getName()+" = "+immutableObj.toString());
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                for(long l=0;l<1000000;l++){
                    System.out.println(Thread.currentThread().getName()+" = "+immutableObj.toString());
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long endTimestamp=System.currentTimeMillis();
        System.out.println("Elapsed time "+(endTimestamp-startTimestamp));

    }

}

final class ImmutableObj{
    private final String name;

    ImmutableObj(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "name='" + name + '\'' +
                '}';
    }
}

class SyncObj{
    private String name;

    public synchronized void setName(String name){
        this.name=name;
    }

    @Override
    public synchronized String toString() {
        return "SyncObj{" +
                "name='" + name + '\'' +
                '}';
    }
}
