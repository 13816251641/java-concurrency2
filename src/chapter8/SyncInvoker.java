package chapter8;

/**
 * 同步调用方法,必然会阻塞
 * @Auther lujieni
 * @Date 2020/4/19
 */
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
       /* String result = get();
        System.out.println(result);*/

        FutureService futureService = new FutureService();
        /*
            异步方式一
            Future<String> future = futureService.submit(() -> {
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "success";
            });
            System.out.println("do other thing");
            Thread.sleep(1_000);
            System.out.println(future.get());
        */

       /*
            异步方式二
        */
        futureService.submit(()->{
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "success";
        },(result)->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
        System.out.println("do other thing");
        System.out.println(Thread.currentThread().getName());

    }

    public static String get() throws InterruptedException{
        Thread.sleep(10_000);
        return "finish";
    }

}
