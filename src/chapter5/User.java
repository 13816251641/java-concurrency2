package chapter5;

/**
 * @Auther lujieni
 * @Date 2020/4/13
 */
public class User extends Thread {
    private String myName;
    private String myAddress;
    private Gate gate;

    public User(String myName,String myAddress,Gate gate){
        this.myName=myName;
        this.myAddress=myAddress;
        this.gate=gate;
    }

    @Override
    public void run() {
        while (true){
            /*
                线程安全问题
             */
            gate.pass(myName,myAddress);
        }
    }
}
