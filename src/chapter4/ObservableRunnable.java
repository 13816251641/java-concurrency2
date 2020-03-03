package chapter4;

/**
 * 抽象类,实现了Runnable
 */
public abstract class ObservableRunnable implements Runnable {
    final protected LifeCycleListener listener;

    public ObservableRunnable(final LifeCycleListener listener){
        this.listener = listener;
    }

    protected void notifyChange(final RunnableEvent event){
        listener.onEvent(event);
    }

    public enum RunnableState{
        RUNNING,ERROR,DONE;
    }

    protected static class RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state,Thread thread,Throwable cause){
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public Thread getThread(){
            return this.thread;
        }

        public RunnableState getState(){
            return this.state;
        }

        public Throwable getCause(){
            return this.cause;
        }

    }
}
