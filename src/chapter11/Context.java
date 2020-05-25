package chapter11;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 */
public class Context {

    private String name;

    private String cardId;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
