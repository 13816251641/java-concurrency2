package chapter4.demo;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update(){
        System.out.println("BinaryObserver:"+subject.getState());
    }


}
