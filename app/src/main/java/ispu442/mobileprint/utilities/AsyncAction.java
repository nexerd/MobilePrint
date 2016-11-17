package ispu442.mobileprint.utilities;

public class AsyncAction implements Runnable {
    private Thread t;
    private Action action;

    public AsyncAction(Action action)
    {
        this.action = action;
        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        action.Execute();
    }

    public interface Action
    {
        void Execute();
    }
}
