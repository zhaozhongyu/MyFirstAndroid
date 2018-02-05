package com.zzy.myapplication1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MyService.MyBinder myBinder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.i(TAG, "onCreate: hello world!");
        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "hello world!", Toast.LENGTH_SHORT).show();
            }
        });

        Button second = (Button)findViewById(R.id.FruitListView);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FruitListView.class);
                startActivity(intent);
            }
        });
        Button second2 = (Button)findViewById(R.id.FruitRecycleView);
        second2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FruitRecycleView.class);
                startActivity(intent);
            }
        });
        Button sendNotification = (Button) findViewById(R.id.sendNotification);
        sendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                //NotificationChannel channelbody = new NotificationChannel(channel,"消息推送",NotificationManager.IMPORTANCE_DEFAULT);
                String channelid = "channelid";
                String channelname = "channelname";
                Notification notification;
                Intent intent = new Intent(MainActivity.this, FruitRecycleView.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0); //设置点击通知的响应
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    int importance = NotificationManager.IMPORTANCE_LOW;
                    NotificationChannel mChannel = manager.getNotificationChannel(channelid);;
                    if (mChannel == null) {
                        mChannel = new NotificationChannel(channelid, channelname, importance);
                        mChannel.setDescription("My Channel");
                        // 设置通知出现时的闪灯（如果 android 设备支持的话）
                        mChannel.enableLights(true);
                        mChannel.setLightColor(Color.RED);
                        // 设置通知出现时的震动（如果 android 设备支持的话）
                        mChannel.enableVibration(true);
                        mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                        manager.createNotificationChannel(mChannel);
                    }
                    notification = new NotificationCompat.Builder(MainActivity.this, channelid )
                            .setContentTitle("This is Title")
                            .setContentText("This is content Text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.drawable.logo)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon128))
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent)
                            .build();
                } else {
                    notification = new NotificationCompat.Builder(MainActivity.this )
                            .setContentTitle("This is Title")
                            .setContentText("This is content Text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.drawable.logo)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon128))
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent) //设置点击通知的响应
                            .build();
                }

                manager.notify(1, notification);

            }
        });

        Button StartService = (Button) findViewById(R.id.startService);
        StartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        Button StopService = (Button) findViewById(R.id.stopService);
        StopService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });

        Button bindService= (Button) findViewById(R.id.bindService);
        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
        });

        Button unbindService= (Button) findViewById(R.id.unbindService);
        unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(connection);
            }
        });

    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            myBinder = (MyService.MyBinder)iBinder;
            myBinder.startBind();
            myBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "click Add.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "click remove.", Toast.LENGTH_SHORT).show();
                break;
            default:

        }
        return true;
    }
}
