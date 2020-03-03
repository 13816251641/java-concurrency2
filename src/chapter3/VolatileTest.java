package chapter3;

/**
 * 如果不添加volatile参数,localValue就永远等于INIT_VALUE,
 * 貌似是INIT_VALUE这个字段线程内没有修改就不会再从主memory
 * 中获取新的值
 */
public class VolatileTest {
    private static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(()->{
            int localValue = INIT_VALUE;
              while (localValue < MAX_LIMIT){
                 if (localValue != INIT_VALUE){
                     System.out.printf("The value updated to [%d]\n",INIT_VALUE);
                     localValue = INIT_VALUE;
                 }
              }
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
