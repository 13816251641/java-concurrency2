package chapter6;

import java.util.Random;

/**
 * @Auther lujieni
 * @Date 2020/4/15
 */
public class WriterWork extends Thread {

    private static final Random random = new Random(System.currentTimeMillis());
    private final SharedData data;
    private final String filter;
    private int index;

    public WriterWork(SharedData data,String filter){
        this.data=data;
        this.filter=filter;
    }

    @Override
    public void run() {
        try {
            while (true){
                char c=nextChar();
                data.write(c);//c是啥buff里面都是c
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar(){
        char c=filter.charAt(index);
        index++;
        if(index>=filter.length()){
            index=0;
        }
        return c;
    }
}
