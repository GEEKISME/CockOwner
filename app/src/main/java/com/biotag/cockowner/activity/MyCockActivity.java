package com.biotag.cockowner.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.biotag.cockowner.R;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.fragment.MyCockFragment;

import me.yokeyword.fragmentation.SupportFragment;

public class MyCockActivity extends SuperBaseActivity {


    public static final int FIRST = 0;
    private SupportFragment[] mFragments = new SupportFragment[1];
    private Context context = MyCockActivity.this;
    private long mExiteTime;
    //    private AppDownLoadReceiver receiver;
    //    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_layout);

        if (savedInstanceState == null) {
            mFragments[FIRST] = MyCockFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_content, FIRST, mFragments[FIRST]);
        } else {
            mFragments[FIRST] = findFragment(MyCockFragment.class);
        }
        //        receiver = new AppDownLoadReceiver();
        //        filter = new IntentFilter();
        //        filter.addAction("com.biotag.cockowner.finish");
        //        registerReceiver(receiver,filter);


    }

//    //放在onResume 中可以给Appdownloadservice 充足的时间去下载apk
//    @Override
//    protected void onResume() {
//        super.onResume();
//        String apkstatus = SharedPreferencesUtils.getString(context, "apkstatus", "0");
//        Log.i(Constants.TAG, " apk status from local is " + apkstatus);
//        if (apkstatus.equals("1")) {  //如果apkstatus 不等于1 的话说明
//
//            Intent intent = new Intent(MyCockActivity.this, AppDownloadService.class);
//            stopService(intent);
//            Log.i(Constants.TAG, "the current apkstatus is " + apkstatus);
//            Log.i(Constants.TAG, "the service has been shut down");
//
//            //            //===================
//            //            final SweetAlertDialog sd = new SweetAlertDialog(context);
//            //            sd.setContentText("The new version has been downloaded in wifi state,restart the app now ？");
//            //            sd.setCancelable(false);
//            //            sd.setCanceledOnTouchOutside(false);
//            //            sd.setConfirmText("Confirm");
//            //            sd.setCancelText("Cancel");
//            //            sd.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//            //                @Override
//            //                public void onClick(SweetAlertDialog sweetAlertDialog) {
//            //
//            //                }
//            //            });
//            //            sd.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//            //                @Override
//            //                public void onClick(SweetAlertDialog sweetAlertDialog) {
//            //                    sd.dismiss();
//            //                    //确定要安装新版本后将Sharepreference 中的apkstatus置为“0”
//            //                    SharedPreferencesUtils.saveString(context,"apkstatus","0");
//            //                    Log.i(Constants.TAG,"将apkstatus置为“0”后取到的apkstatus 是"+ SharedPreferencesUtils
//            // .getString(context,"apkstatus","0"));
//            //                    Intent intent1 = new Intent();
//            //                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            //                    intent1.setAction(Intent.ACTION_VIEW);
//            //                    intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            //                    intent1.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//            //                    File apkfile = new File(Environment.getExternalStorageDirectory()+"/cockowner/",
//            // COCK_APK);
//            //                    intent1.setDataAndType(FileUtils.getUriForFile(context,apkfile),"application/vnd
//            // .android.package-archive");
//            //                    startActivity(intent1);
//            //                    Log.i(Constants.TAG,"apk 安装完成了");
//            //                }aa
//            //            });
//            //            sd.show();
//            //==========================
//            final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(context);
//            rxDialogSureCancel.getContentView().setText(GetAttrString.getRestartAppnow());
//            rxDialogSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    rxDialogSureCancel.cancel();
//                    SharedPreferencesUtils.saveString(context, "apkstatus", "0");
//                    Intent intent1 = new Intent();
//                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent1.setAction(Intent.ACTION_VIEW);
//                    intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    intent1.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//                    File apkfile = new File(Environment.getExternalStorageDirectory() + "/cockowner/", COCK_APK);
//                    intent1.setDataAndType(FileUtils.getUriForFile(context, apkfile), "application/vnd.android" +
//                            ".package-archive");
//                    startActivity(intent1);
//                    Log.i(Constants.TAG, "apk has been installed");
//                }
//            });
//            rxDialogSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    rxDialogSureCancel.dismiss();
//                }
//            });
//            rxDialogSureCancel.show();
//            //===================
//            //            AlertDialog ab = null;
//            //            AlertDialog.Builder builder = new AlertDialog.Builder(context);
//            //            builder.setTitle("Update tip");
//            //            builder.setMessage("The new version has been downloaded in wifi state,restart the app now ？");
//            //            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
//            //                @Override
//            //                public void onClick(DialogInterface dialog, int which) {
//            //                    //确定要安装新版本后将Sharepreference 中的apkstatus置为“0”
//            //                    SharedPreferencesUtils.saveString(context,"apkstatus","0");
//            //                    Log.i(Constants.TAG,"将apkstatus置为“0”后取到的apkstatus 是"+ SharedPreferencesUtils
//            // .getString(context,"apkstatus","0"));
//            //                    Intent intent1 = new Intent();
//            //                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            //                    intent1.setAction(Intent.ACTION_VIEW);
//            //                    intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            //                    intent1.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//            //                    File apkfile = new File(Environment.getExternalStorageDirectory()+"/cockowner/",
//            // COCK_APK);
//            //                    intent1.setDataAndType(FileUtils.getUriForFile(context,apkfile),"application/vnd
//            // .android.package-archive");
//            //                    startActivity(intent1);
//            //                    Log.i(Constants.TAG,"apk 安装完成了");
//            //                }
//            //            });
//            //            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            //                @Override
//            //                public void onClick(DialogInterface dialog, int which) {
//            //                }
//            //            });
//            //            ab = builder.create();
//            //            ab.show();
//        }
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (System.currentTimeMillis() - mExiteTime > 2000) {
                //                Toast.makeText(context, "Pressing again will exit the App", Toast.LENGTH_SHORT)
                // .show();
                RxToast.info(context, "Pressing again will exit the App.", Toast.LENGTH_SHORT, true).show();

                mExiteTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //页面销毁时，无论apkfile 下载成功或者失败，都应将appDownloadservice 关掉,且如果apkfile 存在的话，将其删除，这样的话，下次在对比版本重新下载
//        Intent intent = new Intent(MyCockActivity.this, AppDownloadService.class);
//        stopService(intent);
//        File apkfile = new File(Environment.getExternalStorageDirectory() + "/cockowner/", COCK_APK);
//        if (apkfile.exists()) {
//            apkfile.delete();
//            Log.i(Constants.TAG, "apkfile has been deleted");
//        } else {
//            Log.i(Constants.TAG, "apk file has been deleted");
//        }

        //        unregisterReceiver(receiver);
    }

    //    class AppDownLoadReceiver extends BroadcastReceiver{
    //
    //        @Override
    //        public void onReceive(final Context context, Intent intent) {
    //            AlertDialog ab = null;
    //            AlertDialog.Builder builder = new AlertDialog.Builder(context);
    //            builder.setTitle("Update tip");
    //            builder.setMessage("已经在WiFi下下载好了新版本的安装包，现在重启APP吗？");
    //            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
    //                @Override
    //                public void onClick(DialogInterface dialog, int which) {
    //                    Intent intent1 = new Intent();
    //                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //                    intent1.setAction(Intent.ACTION_VIEW);
    //                    File apkfile = new File(Environment.getExternalStorageDirectory()+"/cockowner/",COCK_APK);
    //                    intent1.setDataAndType(FileUtils.getUriForFile(context,apkfile),"application/vnd.android.package-archive");
    //                    startActivity(intent1);
    //                }
    //            });
    //            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    //                @Override
    //                public void onClick(DialogInterface dialog, int which) {
    //                }
    //            });
    //            ab = builder.create();
    //            ab.show();
    //        }
    //    }

    //

//        public void startActivity(final Intent intent){
//            try {
//                try {
//                    super.startActivity(intent);
//                    overridePendingTransition(R.anim.activity_in_form_right,R.anim.activity_out_to_left);
//                }catch (ActivityNotFoundException e){
//                    e.printStackTrace();
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String isExitApp = intent.getStringExtra("isExitApp");
        if(isExitApp.equals("1")){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
    }
}
