package chapter18;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 */
public class RealResult implements Result {

    private final Object resultValue;

    public RealResult(Object resultValue){
        this.resultValue = resultValue;
    }

    @Override
    public Object getResultValue() {
        return resultValue;
    }
}
