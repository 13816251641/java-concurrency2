package chapter11;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 */
public class QueryFromHttpAction {

    public void execute(){
        Context context = ActionContext.getInstance().getContext();
        String cardId = getCardId(context.getName());
        context.setCardId(cardId);
    }

    private String getCardId(String name){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "2323212312312321112"+Thread.currentThread().getId();
    }

}
