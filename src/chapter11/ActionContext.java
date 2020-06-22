package chapter11;

/**
 * @Auther lujieni
 * @Date 2020/5/25
 */
public class ActionContext {

    /*
       赋初值,jdk8以后静态变量已存入堆中
     */
    private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    /*
        申明ActionContext是单例
     */
    private ActionContext(){

    }

    private static class ActionContextHolder{
        private final static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getInstance(){
        return ActionContextHolder.actionContext;
    }

    public Context getContext(){
        return threadLocal.get();
    }

}
