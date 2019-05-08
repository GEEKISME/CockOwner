package com.biotag.cockowner.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.biotag.cockowner.R;
import com.biotag.cockowner.utils.MobclickAgentWrapper;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.config.CaocConfig;

public class ErrorActivity extends UserBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        String errorinfo = CustomActivityOnCrash.getAllErrorDetailsFromIntent(ErrorActivity.this, getIntent());
        MobclickAgentWrapper.onEvent(ErrorActivity.this,"进入到ErrorActivity页面，发生的错误是："+ errorinfo);
        //        RxToast.info(ErrorActivity.this,errorinfo, Toast.LENGTH_SHORT,false).show();

        initview();

    }

    private void initview() {
        Button btn_restart = findViewById(R.id.btn_restart);
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CaocConfig config = CustomActivityOnCrash.getConfigFromIntent(getIntent());
                CustomActivityOnCrash.restartApplication(ErrorActivity.this,config);
            }
        });
    }
}
