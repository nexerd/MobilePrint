package ispu442.mobileprint.broadcastrecivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import ispu442.mobileprint.utilities.NotificationHelper;

public class OrdersUpdateReceiver extends BroadcastReceiver{

    public static final String ACTION_NAME = "ORDERS_UPDATE";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        NotificationHelper.OrdersUpdateNotify(context);
    }
}
