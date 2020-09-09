package chapter3;

/**
 * 如果不添加volatile参数,localValue就永远等于INIT_VALUE,
 * 貌似是INIT_VALUE这个字段线程内没有修改就不会再从主memory中获取新的值
 * 如果在代码中添加System.out打印这个问题又能解决,很奇怪!!!
 * 所以还是加上volatile避免问题的发生
 */
public class VolatileTest {
    private static volatile int INIT_VALUE = 0; //静态变量放在堆中
    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(()->{
            int localValue = INIT_VALUE;
              while (localValue < MAX_LIMIT){
                  //System.out.println("a");
                  if (localValue != INIT_VALUE){
                     System.out.printf("The value updated to [%d]\n",INIT_VALUE);
                     localValue = INIT_VALUE;
                 }
              }

          /*
             while(true){
                 System.out.println("Reader:INIT_VALUE="+INIT_VALUE);
             }
          */

        },"READER").start();

        new Thread(()->{
              int localValue = INIT_VALUE;
              while (INIT_VALUE < MAX_LIMIT){
                  System.out.printf("Update the value to [%d]\n",++localValue);
                  INIT_VALUE = localValue;
                  try {
                      Thread.sleep(500);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
        },"UPDATER").start();
    }
}
