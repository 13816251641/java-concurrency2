package chapter12;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 */
public class BalkingData {
    private String fileName;
    private String content;
    private boolean changed;

    public BalkingData(String fileName,String content){
        this.fileName=fileName;
        this.content=content;
        this.changed=true;
    }

    public synchronized void change(String newContent){
        this.content=newContent;
        this.changed=true;
    }

    public synchronized void save(){
        if(!changed)
            return;
        doSave();
        this.changed=false;
    }

    private void doSave(){
        System.out.println("doSave");
    }

}
