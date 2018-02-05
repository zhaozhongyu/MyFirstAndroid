package com.zzy.myapplication1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    String TAG = "MyService";
    public MyService() {
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("MyService", "onCreate execute");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("MyService", "onStartCommand execute");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MyService", "onDestroy execute");
    }

    public MyBinder myBinder = new MyBinder();
    class MyBinder extends Binder{

        public void startBind(){
            Log.d("MyService", "startBind execute");
        }

        public int getProgress() {
            Log.d(TAG, "getProgress: execute");
            return 0;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("MyService", "onBind execute");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent){
        Log.d("MyService", "onUnbind execute");
        return true;
    }
}
