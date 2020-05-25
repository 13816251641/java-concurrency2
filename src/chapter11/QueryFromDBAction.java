package chapter11;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 */
public class QueryFromDBAction {

    public void execute(){
        try{
            Thread.sleep(1000L);
            String name = "Alex "+Thread.currentThread().getName();
            ActionContext.getInstance().getContext().setName(name);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
