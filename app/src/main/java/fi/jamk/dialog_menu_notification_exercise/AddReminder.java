package fi.jamk.dialog_menu_notification_exercise;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;

/**
 * Created by Jere on 14.9.2017.
 */

public class AddReminder {


    public AddReminder(Context context, long delay, int notificationId, String message){

        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.asd);
        Notification.Builder builder = new Notification.Builder(context)
                .setContentTitle("New timed notification!")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_stat_thumb_up)
                .setLargeIcon(icon)
                .setAutoCancel(true);

        Notification notification = builder.build();
        Intent notificationIntent = new Intent(context, MyNotificationPublisher.class);
        notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, notificationId);
        notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, notificationId, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + (delay*1000);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);

    }

}
