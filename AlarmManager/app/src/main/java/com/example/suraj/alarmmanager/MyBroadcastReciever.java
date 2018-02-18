package com.example.suraj.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by suraj on 29/1/18.
 */

public class MyBroadcastReciever extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context,Intent intent){
        mp=MediaPlayer.create(context,R.raw.incoming_message);
        mp.start();
        Toast.makeText(context, "Alarm...", Toast.LENGTH_SHORT).show();
    }
}
