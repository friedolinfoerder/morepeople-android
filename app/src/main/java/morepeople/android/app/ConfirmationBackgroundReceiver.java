package morepeople.android.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by schreon on 3/13/14.
 */
public class ConfirmationBackgroundReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ComponentName confirmationBackgroundService = new ComponentName(context, ConfirmationBackgroundReceiver.class);
        startWakefulService(context, (intent.setComponent(confirmationBackgroundService)));
        setResultCode(Activity.RESULT_OK);
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }
}