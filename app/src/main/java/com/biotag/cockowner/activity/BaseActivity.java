package com.biotag.cockowner.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.biotag.cockowner.utils.MobclickAgentWrapper;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
