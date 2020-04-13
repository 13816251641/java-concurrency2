package chapter4.demo;


public class ObserverClient {

    public static void main(String[] args) {
         final Subject subject = new Subject();
         new BinaryObserver(subject);
         new OctalObserver(subject);
         subject.setState(20);

    }

}
