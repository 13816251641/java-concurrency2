package chapter7.demo1;

/**
 * @Auther lujieni
 * @Date 2020/4/16
 */
public class UsePersonThread extends Thread {
    private final Person person;

    public UsePersonThread(Person person){
        this.person=person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+" print "+person);
        }
    }
}
