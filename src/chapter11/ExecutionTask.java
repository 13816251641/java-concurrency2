package chapter11;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 * ExecutionTask就是一个线程
 */
public class ExecutionTask extends Thread {

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        queryFromDBAction.execute();
        System.out.println("The name query successful");
        queryFromHttpAction.execute();
        System.out.println("The card id query successful");
        Context context = ActionContext.getInstance().getContext();
        System.out.println("The Name is"+context.getName()+" and CardId is "+context.getCardId());
    }
}
