package chapter4.demo;


public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("OctalObserver:"+subject.getState());
    }
}
