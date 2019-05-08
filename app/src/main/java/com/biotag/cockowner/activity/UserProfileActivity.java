package com.biotag.cockowner.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.DownloadBuilder;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.CustomDownloadFailedListener;
import com.allenliu.versionchecklib.v2.callback.CustomVersionDialogListener;
import com.biotag.cockowner.JavaBean.AppVersionBean;
import com.biotag.cockowner.JavaBean.VersionUrlBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customdialog.BaseDialog;
import com.biotag.cockowner.customdialog.RxDialogSureCancel;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.MobclickAgentWrapper;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;

import static com.biotag.cockowner.common.Constants.NEED_DOWNLOAD_APK;
import static com.biotag.cockowner.common.Constants.POOR_NET_WORK;
import static com.biotag.cockowner.common.Constants.UNNECESSARY_DOWNLOAD_APK;

public class UserProfileActivity extends UserBaseActivity {
    private String appNo,appDownloadUrl,apkPath;


    private UserProAcHandler handler = new UserProAcHandler(this);

    private DownloadBuilder builder;
    static class UserProAcHandler extends Handler{
        WeakReference<UserProfileActivity> userProfileActivityWeakReference;
        public UserProAcHandler(UserProfileActivity userProfileActivity){
            userProfileActivityWeakReference = new WeakReference<UserProfileActivity>(userProfileActivity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            UserProfileActivity userProfileActivity = userProfileActivityWeakReference.get();
            if (userProfileActivity!=null) {
                switch (msg.what){
                    case UNNECESSARY_DOWNLOAD_APK:
                        RxToast.success(userProfileActivity,"Current version is the newest !", Toast.LENGTH_SHORT).show();
                        MobclickAgentWrapper.onEvent(userProfileActivity,"Unnecessary download apk");
                        break;
                    case NEED_DOWNLOAD_APK:
//                        if (NetCheckUtil.getNetworkType(userProfileActivity) == NetCheckUtil.NETTYPE_WIFI) {
//
//                        }else {
//
//                        }
                        MobclickAgentWrapper.onEvent(userProfileActivity,"need download apk file");
                        userProfileActivity.builder = AllenVersionChecker.getInstance().downloadOnly(userProfileActivity.crateUIData());
                        userProfileActivity.builder
                                .setForceRedownload(true)
                                .setShowDownloadingDialog(true)
                                .setShowNotification(false)
                                .setShowDownloadFailDialog(true)
                                .setCustomVersionDialogListener(userProfileActivity.createCustomDialogTwo())
                                .setCustomDownloadFailedListener(userProfileActivity.createCustomDownloadFailedDialog())
                                .setDownloadAPKPath(userProfileActivity.apkPath)
                                .excuteMission(userProfileActivity);
                        break;
                    case POOR_NET_WORK:
                        MobclickAgentWrapper.onEvent(userProfileActivity,"bad network");
                        RxToast.error(userProfileActivity,"Poor network !",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

        }


    }

    private CustomDownloadFailedListener createCustomDownloadFailedDialog() {
        return (context, versionBundle) -> {
            BaseDialog baseDialog = new BaseDialog(context, R.style.BaseDialog, R.layout.custom_download_failed_dialog);
            return baseDialog;
        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        iniPrecess();//预处理
        initview();
    }

    private void iniPrecess() {
        try {
            apkPath=Environment.getExternalStorageDirectory()+"/BIRDENTITY/";
            PackageManager pm = getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
            appNo = pi.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initview() {
        ProgressBar progressBar = findViewById(R.id.progress_bar) ;
        RelativeLayout rl_checknewversion = findViewById(R.id.rl_checknewversion);
        rl_checknewversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobclickAgentWrapper.onEvent(UserProfileActivity.this,"check new version clicked");

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
                                SharedPreferencesUtils.saveString(context, "appdownloadurl", vub.getOwner_version().getUrl());
                                appDownloadUrl = vub.getOwner_version().getUrl();
                                handler.sendEmptyMessage(NEED_DOWNLOAD_APK);
                            } else {
                                handler.sendEmptyMessage(UNNECESSARY_DOWNLOAD_APK);
                            }
                        } else {
                            handler.sendEmptyMessage(POOR_NET_WORK);
                        }
                    }
                });

            }
        });
        RelativeLayout titlebar_userprofile = findViewById(R.id.titlebar_userprofile);
        RelativeLayout rl_back = titlebar_userprofile.findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_fade,R.anim.activity_out_to_right);
            }
        });
        TextView activitytitle = titlebar_userprofile.findViewById(R.id.activity_title);
        activitytitle.setText(SharedPreferencesUtils.getString(UserProfileActivity.this, Constants.USERNAME,""));
//        activitytitle.setAllCaps(false);
        activitytitle.setTextColor(getResources().getColor(R.color.advance_red));
        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(UserProfileActivity.this);
                rxDialogSureCancel.getContentView().setText("Will you logout the app and switch user ?");
                rxDialogSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSureCancel.dismiss();
                        Intent intent = new Intent(UserProfileActivity.this, MyCockActivity.class);
                        intent.putExtra("isExitApp","1");
                        startActivity(intent);
                        finish();
                    }
                });
                rxDialogSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSureCancel.dismiss();
                    }
                });
                rxDialogSureCancel.show();
            }
        });
        TextView tv_username = findViewById(R.id.tv_username);
        tv_username.setText(SharedPreferencesUtils.getString(UserProfileActivity.this,Constants.USERNAME,""));
        TextView tv_address = findViewById(R.id.tv_address);
        tv_address.setText(SharedPreferencesUtils.getString(UserProfileActivity.this,Constants.OADDRESS,""));
        TextView tv_phone = findViewById(R.id.tv_phone);
        tv_phone.setText(SharedPreferencesUtils.getString(UserProfileActivity.this,Constants.OTEL,""));
        RelativeLayout rl_farmlabel = findViewById(R.id.rl_farmlabel);
        TextView tv_farmlabel = findViewById(R.id.tv_farmlabel);
        boolean isperson = SharedPreferencesUtils.getBoolean(UserProfileActivity.this,Constants.ISPERSONAL,false);
        if(isperson){
            rl_farmlabel.setVisibility(View.INVISIBLE);
        }else {
            String s  = SharedPreferencesUtils.getString(UserProfileActivity.this,Constants.FARMNAME,"");
            if(s!=null&&s.trim().length()>0){
                tv_farmlabel.setText(s);
            }
        }
    }

    private UIData crateUIData() {
        UIData uiData = UIData.create();
        uiData.setTitle(getString(R.string.update_title));
        uiData.setDownloadUrl(appDownloadUrl);
        Log.i(Constants.TAG,"appDownloadUrl is "+ appDownloadUrl);
        uiData.setContent(getString(R.string.updatecontent));
        return uiData;
    }

    private CustomVersionDialogListener createCustomDialogTwo() {
        return (context, versionBundle) -> {
            BaseDialog baseDialog = new BaseDialog(context, R.style.BaseDialog, R.layout.custom_dialog_two_layout);
            baseDialog.setCanceledOnTouchOutside(true);
            return baseDialog;
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
