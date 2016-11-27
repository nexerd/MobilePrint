package ispu442.mobileprint.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import ispu442.mobileprint.broadcastrecivers.OrdersUpdateReceiver;
import ispu442.mobileprint.contolers.OrderController;
import ispu442.mobileprint.contolers.UserController;
import ispu442.mobileprint.utilities.AsyncAction;
import ispu442.mobileprint.utilities.NotificationHelper;

public class OrderService extends Service {

    AsyncAction work;
    static Context context = null;

    private final class UpdateOrders implements AsyncAction.Action
    {
        private long waitTime = 5000;
        @Override
        public void Execute()
        {
            long endTime = System.currentTimeMillis() + waitTime;
            while (true) {
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            if (UserController.IsSignedIn() && OrderController.UpdateOrders())
                            {
                                Intent intent = new Intent(OrdersUpdateReceiver.ACTION_NAME);
                                sendBroadcast(intent);
                                ((OnOrdersUpdate)context).UpdateOrders();
                            }
                            wait(endTime - System.currentTimeMillis());
                        }
                        catch (InterruptedException e) {

                        }
                    }
                }
                endTime += waitTime;
            }

        }
    }

   public static void SetContext(Context _context)
   {
       context = _context;
   }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        if (context != null)
            work = new AsyncAction(new UpdateOrders());
        return START_STICKY;
    }

    public interface OnOrdersUpdate
    {
        void UpdateOrders();
    }
}
