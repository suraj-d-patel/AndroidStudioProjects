package com.vamediabox.suraj;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by suraj-patel on 11/1/18.
 */

public class HelloService extends Service {
    int mStartMode;
    IBinder mBinder;
    boolean mAllowRebind;

    @Override
    public void onCreate(){

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
     return mStartMode;
    }
    @Override
    public IBinder onBind(Intent intent){
        return mBinder;
    }

}


