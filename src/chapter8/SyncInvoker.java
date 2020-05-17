package chapter8;

/**
 * 同步调用方法,必然会阻塞
 * @Auther lujieni
 * @Date 2020/4/19
 */
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
        String result = get();
        System.out.println(result);
    }

    public static String get() throws InterruptedException{
        Thread.sleep(10_000);
        return "finish";
    }

}
