package chapter18;

/**
 * @Auther lujieni
 * @Date 2020/6/9
 * 对应ActiveObject的每一个方法
 */
public abstract class MethodRequest {

    protected final Servant servant;

    protected final FutureResult futureResult;

    public MethodRequest(Servant servant,FutureResult futureResult){
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();



}
