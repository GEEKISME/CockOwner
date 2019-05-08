package com.biotag.cockowner.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.biotag.cockowner.R;
import com.biotag.cockowner.customview.SystemBarTintManager;
import com.biotag.cockowner.utils.MobclickAgentWrapper;

/**
 * Created by Lxh on 2017/9/15.
 */

public class UserBaseActivity extends Activity {
    protected Context context ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View fullscreen_rly = findViewById(R.id.rootview);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            if(fullscreen_rly!=null){
                fullscreen_rly.setFitsSystemWindows(true);
                setStatusStyle();
            }
        }
        this.context = this;
    }

    private void setStatusStyle() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.black);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean b) {
        Window window = getWindow();
        WindowManager.LayoutParams winparam = window.getAttributes();
        final int bit = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if(b){
            winparam.flags |=bit;

        }else {

            winparam.flags &=~bit;
        }
        window.setAttributes(winparam);
    }

//    public void startActivity(final Intent intent){
//        try {
//            try {
//                super.startActivity(intent);
//                overridePendingTransition(R.anim.activity_in_form_right,R.anim.activity_out_to_left);
//            }catch (ActivityNotFoundException e){
//                e.printStackTrace();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

//    public void finish(){
//        try {
//            super.finish();
//            overridePendingTransition(R.anim.activity_in_from_left, R.anim.activity_out_to_right);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgentWrapper.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgentWrapper.onPause(this);
    }
}
