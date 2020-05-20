package chapter9;

/**
 * @Auther lujieni
 * @Date 2020/5/20
 */
public class SuspensionClient {

    public static void main(String[] args) throws Exception{
        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue,"Alex").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();

        //serverThread.join();不能用,因为最后ServerThread已经wait了,没有人再来notify它
        Thread.sleep(11_000);
        serverThread.close();

    }
}
