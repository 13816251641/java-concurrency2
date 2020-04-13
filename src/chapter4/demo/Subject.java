package chapter4.demo;

import chapter4.demo.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState(){
        return this.state;
    }
    public void setState(int state){
        if(this.state == state)
            return;
        this.state = state;
        notifyAllObserver();

    }
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 必须private,不然任意Observer的实现类都可以调用
     */
    private void notifyAllObserver(){
        observers.forEach(Observer::update);
    }




}
