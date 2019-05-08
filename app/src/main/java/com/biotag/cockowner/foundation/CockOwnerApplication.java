package com.biotag.cockowner.foundation;

import android.app.Activity;
import android.app.Application;
import android.os.Environment;
import android.os.Handler;

import com.biotag.cockowner.R;
import com.biotag.cockowner.activity.ErrorActivity;
import com.biotag.cockowner.activity.LoginActivity;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import cat.ereza.customactivityoncrash.config.CaocConfig;

/**
 * Created by Lxh on 2017/8/9.
 */

public class CockOwnerApplication extends Application {
    protected static CockOwnerApplication mInstance;
    private static Handler mMainThreadHandler;
    private static int mMainThreadId;
    private List<Activity> mList = new LinkedList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mMainThreadHandler = new Handler();
        mMainThreadId = android.os.Process.myTid();
        //创建cockowner文件夹，用于缓存等
        File dir = new File(Environment.getExternalStorageDirectory() + "/cockowner/");
        if (!dir.exists()) dir.mkdirs();
        Logger.addLogAdapter(new AndroidLogAdapter());
        //custom activity crash
        CaocConfig.Builder.create().backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //default: CaocConfig
                // .BACKGROUND_MODE_SHOW_CUSTOM
                .enabled(true) //default: true
                .showErrorDetails(true) //default: true
                .showRestartButton(true) //default: true
                .logErrorOnRestart(true) //default: true
                .trackActivities(true) //default: false
                .minTimeBetweenCrashesMs(2000) //default: 3000
                .errorDrawable(R.mipmap.customactivityoncrash_error_image) //default: bug image
                .restartActivity(LoginActivity.class) //default: null (your app's launch activity)
                .errorActivity(ErrorActivity.class) //default: null (default error activity)
                //                .eventListener(null) //default: null
                .apply();

    }

    public static CockOwnerApplication getApplication() {
        return mInstance;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public int getActivitySize() {
        return mList.size();
    }

}
