package chapter4;

public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject){
        System.out.println(this.getClass().getName());
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();

}
