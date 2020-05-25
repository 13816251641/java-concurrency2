package chapter11;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 */
public class QueryFromDBAction {

    public void execute(Context context){
        try{
            Thread.sleep(1000L);
            String name = "Alex "+Thread.currentThread().getName();
            context.setName(name);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
