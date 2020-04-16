package chapter7;

import java.util.stream.IntStream;

/**
 * @Auther lujieni
 * @Date 2020/4/16
 */
public class ImmutableClient {

    public static void main(String[] args) {
        Person person=new Person("Alex","Gansu");
        IntStream.range(0,5).forEach(i->{
            new UsePersonThread(person).start();
        });
    }


}
