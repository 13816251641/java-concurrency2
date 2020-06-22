package chapter11;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 * 模拟访问db数据库
 */
public class QueryFromDBAction {

    public void execute(){
        try{
            Thread.sleep(1000L);
            String name = "Alex "+Thread.currentThread().getName();
            ActionContext.getInstance().getContext().setName(name);//存入线程上下文中
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
