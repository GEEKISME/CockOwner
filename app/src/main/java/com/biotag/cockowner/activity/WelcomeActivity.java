package com.biotag.cockowner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.biotag.cockowner.JavaBean.AppVersionBean;
import com.biotag.cockowner.JavaBean.VersionUrlBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.Service.AppDownloadService;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.NetCheckUtil;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;

public class WelcomeActivity extends UserBaseActivity {
    public static final int NO_NEED = 1;
    public static final int NEED = 2;
    public static final int I_DONT_CARE = 3;
    private String newestVersion;


    static class WelcomeHandler extends Handler {
        private WeakReference<WelcomeActivity> welcomeActivityWeakReference;

        public WelcomeHandler(WelcomeActivity welcomeActivity) {
            welcomeActivityWeakReference = new WeakReference<WelcomeActivity>(welcomeActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            final WelcomeActivity welcomeActivity = welcomeActivityWeakReference.get();
            if (welcomeActivity != null) {
                switch (msg.what) {
                    case NO_NEED:
                        this.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(welcomeActivity, LoginActivity.class);
                                welcomeActivity.startActivity(intent);
                                welcomeActivity.finish();
                                welcomeActivity.overridePendingTransition(R.anim.activity_in_from_left, R.anim.activity_out_to_right);

                            }
                        }, 1000);
                        break;
                    case NEED:
                        //只有在WiFi状态下才会下载apk
                        if (NetCheckUtil.getNetworkType(welcomeActivity) == NetCheckUtil.NETTYPE_WIFI) {
                            welcomeActivity.appDownloadUrl = SharedPreferencesUtils.getString(welcomeActivity,
                                    "appdownloadurl", "");
                            Intent intent = new Intent(welcomeActivity, AppDownloadService.class);
                            intent.putExtra("appurl", welcomeActivity.appDownloadUrl);
                            intent.putExtra("newestVersion", welcomeActivity.newestVersion);
                            welcomeActivity.startService(intent);
                            Log.i(Constants.TAG, "service has been started");
                        }
                        this.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(welcomeActivity, LoginActivity.class);
                                welcomeActivity.startActivity(intent);
                                welcomeActivity.finish();
                            }
                        }, 1000);
                        break;
                    case I_DONT_CARE:
                        this.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(welcomeActivity, LoginActivity.class);
                                welcomeActivity.startActivity(intent);
                                welcomeActivity.finish();
                            }
                        }, 1000);
                        break;
                }
            }
        }
    }

    private WelcomeHandler handler = new WelcomeHandler(this);

    //    private Handler handler = new Handler(){
    //        @Override
    //        public void handleMessage(Message msg) {
    //            switch (msg.what){
    //                case NO_NEED:
    //                    handler.postDelayed(new Runnable() {
    //                        @Override
    //                        public void run() {
    //                            Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
    //                            startActivity(intent);
    //                            finish();
    //                        }
    //                    },1000);
    //                    break;
    //                case NEED:
    //                    //只有在WiFi状态下才会下载apk
    //                    if(NetCheckUtil.getNetworkType(WelcomeActivity.this)==NetCheckUtil.NETTYPE_WIFI){
    //                        appDownloadUrl = SharedPreferencesUtils.getString(context,"appdownloadurl","");
    //                        Intent intent = new Intent(WelcomeActivity.this, AppDownloadService.class);
    //                        intent.putExtra("appurl",appDownloadUrl);
    //                        intent.putExtra("newestVersion",newestVersion);
    //                        startService(intent);
    //                        Log.i(Constants.TAG,"service 启动了");
    //                    }
    //                    handler.postDelayed(new Runnable() {
    //                        @Override
    //                        public void run() {
    //                            Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
    //                            startActivity(intent);
    //                            finish();
    //                        }
    //                    },1000);
    //                    Log.i(Constants.TAG,"要跳转去loginAc了");
    //                    break;
    //                case I_DONT_CARE:
    //                    handler.postDelayed(new Runnable() {
    //                        @Override
    //                        public void run() {
    //                            Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
    //                            startActivity(intent);
    //                            finish();
    //                        }
    //                    },1000);
    //                    break;
    //            }
    //        }
    //    };
    private String appNo, appDownloadUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
//        Log.i("tms","welcome");
//        try {
//            PackageManager pm = getPackageManager();
//            PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
//            appNo = pi.versionName;
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        appDownloadUrl = SharedPreferencesUtils.getString(context, "appdownloadurl", "");
//        //        Log.i(Constants.TAG,"appDownloadUrl is "+appDownloadUrl);
//        checkNewAppVersion();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.activity_in_from_left, R.anim.activity_out_to_right);

            }
        }, 1000);
    }

    private void checkNewAppVersion() {
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String requl = Constants.APP_VERSION;
                AppVersionBean avb = OkhttpPlusUtil.getInstance().get(requl, AppVersionBean.class);
                if (avb != null && avb.isIsSuccess()) {
                    String versionurl = avb.getValues();
                    VersionUrlBean vub = new Gson().fromJson(versionurl, VersionUrlBean.class);
                    Log.i(Constants.TAG, "server 的 appno is " + vub.getOwner_version().getNo());
                    if (!appNo.equals(vub.getOwner_version().getNo())) {
                        //如果appNo不一致，先把最新的版本号存入newestVersion,只有当新版本的apk下载成功后才会把newestversion 写入sp
                        newestVersion = vub.getOwner_version().getNo();
                        SharedPreferencesUtils.saveString(context, "appdownloadurl", vub.getOwner_version().getUrl());
                        handler.sendEmptyMessage(NEED);
                    } else {
                        handler.sendEmptyMessage(NO_NEED);
                    }
                } else {
                    handler.sendEmptyMessage(I_DONT_CARE);
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
