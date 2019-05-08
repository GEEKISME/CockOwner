package com.biotag.cockowner.activity;

import android.os.Bundle;

import com.biotag.cockowner.utils.MobclickAgentWrapper;

import me.yokeyword.fragmentation.SupportActivity;

public class SuperBaseActivity extends SupportActivity {

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
