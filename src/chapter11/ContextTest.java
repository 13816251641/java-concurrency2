package chapter11;

import java.util.stream.IntStream;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 */
public class ContextTest {

    public static void main(String[] args) {
        IntStream.rangeClosed(1,5).forEach(i->{
            new Thread(new ExecutionTask()).start();
        });
    }
}
