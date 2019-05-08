package com.biotag.cockowner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.GetAttrString;

public class MemoActivity extends AppCompatActivity {
    private RelativeLayout rl_back;
    private RelativeLayout share;
    private TextView activity_title,nextstep;
    private EditText et_memo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        Intent intent = getIntent();
        String oriinfo = intent.getStringExtra("oriinfo");
        initview();
        initlistener();
        et_memo.setText(oriinfo);

//        throw new RuntimeException("Boom");
    }

    private void initlistener() {
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_in_from_left,R.anim.activity_out_to_right);
            }
        });
        activity_title.setText(GetAttrString.getCock_memo());
        nextstep.setText(GetAttrString.getBasic_confirm());
        nextstep.setTextColor(getResources().getColor(R.color.advance_red));
        share.setVisibility(View.VISIBLE);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_memo.getText().toString().trim().length() != 0){
                    Intent intent = new Intent();
                    intent.putExtra("cockinforeturn",et_memo.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                    overridePendingTransition(R.anim.activity_in_from_left,R.anim.activity_out_to_right);
                }
            }
        });
    }

    private void initview() {
        RelativeLayout titlebar_memo = findViewById(R.id.titlebar_memo);
        rl_back = titlebar_memo.findViewById(R.id.rl_back);
        share = titlebar_memo.findViewById(R.id.share);
        activity_title = titlebar_memo.findViewById(R.id.activity_title);
        nextstep = titlebar_memo.findViewById(R.id.nextstep);
        et_memo = findViewById(R.id.et_memo);
    }
}
