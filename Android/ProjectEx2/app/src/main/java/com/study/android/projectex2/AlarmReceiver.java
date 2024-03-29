package com.study.android.projectex2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "lecture";

    //각 알림을 식별하는 점수
    public static final int NOTIFICATION_ID = 1;

    Context context;

    NotificationManager notificationManager;
    PendingIntent pendingIntent;

    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    public void onReceive(final Context context, Intent intent)
    {

        this.context = context;
        // PowerManager는 Device의 전원 상태를 제어할수 잇게 도와준다.
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"");
        wakeLock.acquire();

        Log.d(TAG,"alarmGO!");

        Toast toast = Toast.makeText(context,"알람이 울립니다.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,200);
        toast.show();

        wakeLock.release();

        try {
            intent = new Intent(context, removeActivity.class);
            pendingIntent = PendingIntent.getActivity(context, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Log.d("ServicePending++ : ",""+pendingIntent.toString());
            pendingIntent.send();
        } catch(PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
        notification();
    }

    void notification(){
        Intent intent = new Intent();

        intent = PendingIntent.getActivity(this, 0,

                new Intent(getApplicationContext(), AlarmReceiver.class), PendingIntent.FLAG_UPDATE_CURRENT);



        Notification.Builder builder = new Notification.Builder(this)



        출처: https://yeolco.tistory.com/86?category=757621 [열코의 프로그래밍 일기]

        // 알람 사운드 설정
       // Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

//        Uri ringtoneUri = intent.getParcelableExtra("링톤울려라");
//        final Ringtone ringtone = RingtoneManager.getRingtone(this, ringtoneUri);  //받은 Uri로 링톤 생성
//        ringtone.play();

        //큰 아이콘 설정 (기본 아이콘 ic_menu_gallert를 뜨워주는 형태)
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),android.R.drawable.ic_menu_gallery);

        //노티피케이션을 생성할때 매개변수는 PendingIntent이므로 Intent를 PendingIntent로 만들어 주어야 함.
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        //노티피케이션 빌더 : 위에서 생성한 이미지나 텍스트 ,사운드등을 설정

        builder.setSmallIcon(android.R.drawable.ic_menu_gallery)
                //.setLargeIcon(bitmap)
                .setContentTitle("알람")
                .setContentText("저는 알람 이에욧!")
                .setDefaults(Notification.DEFAULT_ALL) // 알림, 사운드 진동 설정
                .setAutoCancel(true) // 알림 터치시 반응 후 삭제
                //.setSound(soundUri)
                .setSound(RingtoneManager
                        .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setBadgeIconType(android.R.drawable.btn_star)
                .setContentIntent(pendingIntent);

        notificationManager = (NotificationManager)getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());


    }

    }

