package chapter18;

/**
 * @Auther lujieni
 * @Date 2020/6/23
 * 一个客户线程,持续调用activeObject.displayString(text)方法
 */
public class DisplayClientThread extends Thread {

    private final ActiveObject activeObject;

    public DisplayClientThread(String name,ActiveObject activeObject){
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try {
            for(int i=0;true;i++){
                String text=Thread.currentThread().getName()+"=>"+i;//Chris=>0
                activeObject.displayString(text);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
