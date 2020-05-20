package chapter7.demo1;

import java.util.stream.IntStream;

/**
 * Person是不可变对象(只提供了get方法),当然线程安全
 * @Auther lujieni
 * @Date 2020/4/16
 *
 */
public class ImmutableClient {

    public static void main(String[] args) {
        Person person = new Person("Alex","Gansu");
        /* 左闭右开 */
        IntStream.range(0,5).forEach(i->{
            new UsePersonThread(person).start();
        });
    }


}
