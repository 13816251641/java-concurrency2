package chapter11;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 */
public class ExecutionTask extends Thread {

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        Context context = new Context();
        queryFromDBAction.execute(context);
        System.out.println("The name query successful");
        queryFromHttpAction.execute(context);
        System.out.println("The card id query successful");
        System.out.println("The Name is"+context.getName()+" and CardId is "+context.getCardId());
    }
}
