package chapter15;

import java.util.stream.IntStream;

/**
 * @Auther lujieni
 * @Date 2020/5/28
 */
public class PreThreadClient {

    public static void main(String[] args) {
        final MessageHandler handler = new MessageHandler();
        IntStream.rangeClosed(1,10).forEach(i->{
            handler.request(new Message(String.valueOf(i)));
        });
    }
}
