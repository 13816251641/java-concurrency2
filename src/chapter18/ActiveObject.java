package chapter18;

/**
 * @Auther lujieni
 * @Date 2020/6/9
 * 接受异步消息的主动方法
 */
public interface ActiveObject {

    Result makeString(int count,char fillChar);

    void displayString(String text);

}
