package chapter16;

/**
 * @Auther lujieni
 * @Date 2020/5/29
 */
public class CounterTest {

    public static void main(String[] args) throws Exception{
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();

        Thread.sleep(10_000);
        counterIncrement.close();

    }



}
