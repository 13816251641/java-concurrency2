package chapter4.demo;

public abstract class Observer {
    protected Subject subject;

    /**
     * 初始化构造函数
     * @param subject
     */
    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();

}
