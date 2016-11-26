package ispu442.mobileprint.utilities;


import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import ispu442.mobileprint.activities.MainActivity;

public class NotificationHelper {

    private static final int ORDERS_UPDATE_ID = 1111;

    public static void OrdersUpdateNotify(Context context)
    {
        Intent intent = new Intent(context, MainActivity.class);
        Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(android.support.v7.appcompat.R.drawable.notification_template_icon_bg)
                .setContentTitle("Обновление списка заказао")
                .setContentText("Проверьте ваш заказ")
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(PendingIntent.getActivities(context, 0, new Intent[] {
                        intent }, PendingIntent.FLAG_CANCEL_CURRENT))
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(ORDERS_UPDATE_ID, notification);
    }
}
