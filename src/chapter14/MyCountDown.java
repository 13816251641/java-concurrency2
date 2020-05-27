package chapter14;

/**
 * @Auther lujieni
 * @Date 2020/5/27
 */
public class MyCountDown {
    private final int total;
    private int counter;

    public MyCountDown(int total) {
        this.total = total;
    }

    public void countDown(){
        synchronized (this){
            counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while (counter!=total){
                this.wait();
            }
        }
    }


}
