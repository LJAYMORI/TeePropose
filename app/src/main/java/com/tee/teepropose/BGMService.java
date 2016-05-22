package com.tee.teepropose;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Jonguk on 2016. 5. 22..
 */
public class BGMService extends Service {

    private static final String TAG = "BGMService";
    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.bgm_expanded_1);
//        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return START_NOT_STICKY;
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

    }
    public void onPause() {

    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        player = null;
    }

    @Override
    public void onLowMemory() {
    }
}
