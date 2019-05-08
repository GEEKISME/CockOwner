package com.biotag.cockowner.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.biotag.cockowner.utils.UIUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lxh on 2017/9/27.
 */

public class AppDownloadService extends Service {

    public static final String COCK_APK = "BIRDENTITY.apk";
    private OkHttpClient client = new OkHttpClient();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String appurl = "";
        if(intent!=null){
             appurl= intent.getStringExtra("appurl");
        }
        final String newestVersion = intent.getStringExtra("newestVersion");
        Log.i(Constants.TAG,"the src acquired is "+appurl);
        Request apkdown = new Request.Builder()
                .url(appurl).build();
        client.newCall(apkdown).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(Constants.TAG,"downloading is processing ");
                InputStream is = response.body().byteStream();
                File apkfile = new File(Environment.getExternalStorageDirectory()+"/BIRDENTITY/",COCK_APK);
                FileOutputStream fos = new FileOutputStream(apkfile);
                byte[] b = new byte[1024];
                int num = -1 ;
                while ((num = is.read(b))!=-1){
                    fos.write(b,0,num);
                    Log.i(Constants.TAG,"downloading....");
                    fos.flush();
                }
                fos.close();
                is.close();
                //下载成功之后将sp中的apkstatus 改为 1
                Log.i(Constants.TAG,"the apk file is downloaded successfully");
//                Intent intent = new Intent("com.biotag.cockowner.finish");
//                intent.putExtra("key","finish");
//                sendBroadcast(intent);
                SharedPreferencesUtils.saveString(UIUtils.getContext(),"newestVersion",newestVersion);
                SharedPreferencesUtils.saveString(UIUtils.getContext(),"apkstatus","1");
                Log.i(Constants.TAG,"apkstatus has been set 1");

            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}

