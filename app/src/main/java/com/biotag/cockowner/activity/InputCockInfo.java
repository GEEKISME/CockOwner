package com.biotag.cockowner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.customdialog.RxToast;

import static com.biotag.cockowner.activity.RecordCockInfoPartOneActivity.REQUESTCODE_BREEDID;
import static com.biotag.cockowner.activity.RecordCockInfoPartOneActivity.REQUESTCODE_CHIPNUM;
import static com.biotag.cockowner.activity.RecordCockInfoPartOneActivity.REQUESTCODE_FARMUSERID;
import static com.biotag.cockowner.activity.RecordCockInfoPartOneActivity.REQUESTCODE_IMPORTERID;
import static com.biotag.cockowner.activity.RecordCockInfoPartOneActivity.REQUESTCODE_SERIALNUM;

public class InputCockInfo extends AppCompatActivity {
    private RelativeLayout titlebar_recordcockinfopartone,rl_back,share;
    private TextView activity_title, nextstep;
    private ImageView iv_clear;
    private EditText et_chipnum;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_cockinfo);
        intent = getIntent();
        initview();
    }

    private void initview() {
        //editext与iv_clear 的初始化
        et_chipnum = (EditText)findViewById(R.id.editTxt);
        iv_clear = (ImageView)findViewById(R.id.iv_clear);
        iv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_chipnum.setText("");
            }
        });
        //===================================
        String oriinfo  = intent.getStringExtra("oriinfo");
        et_chipnum.setText(oriinfo);
        //====================================================
        titlebar_recordcockinfopartone = (RelativeLayout)findViewById(R.id.titlebar_recordcockinfopartone);
        //===================返回键的事件
        rl_back = (RelativeLayout)titlebar_recordcockinfopartone.findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //  title设置
        activity_title = (TextView)titlebar_recordcockinfopartone.findViewById(R.id.activity_title);
        switch (intent.getIntExtra("cockinfo",0)){
            case REQUESTCODE_CHIPNUM:
                activity_title.setText("Cock Chip Number");
                break;
            case REQUESTCODE_SERIALNUM:
                activity_title.setText(getResources().getString(R.string.cockNo_));
                break;
            case REQUESTCODE_BREEDID:
                activity_title.setText(getResources().getString(R.string.species));
                break;
            case REQUESTCODE_FARMUSERID:
                activity_title.setText("Farm User ID");
                break;
            case REQUESTCODE_IMPORTERID:
                activity_title.setText(getResources().getString(R.string.importerid));
                break;


        }
        share = (RelativeLayout) titlebar_recordcockinfopartone.findViewById(R.id.share);
        share.setVisibility(View.VISIBLE);
        nextstep = (TextView)titlebar_recordcockinfopartone.findViewById(R.id.nextstep);
        nextstep.setText(GetAttrString.getBasic_confirm());
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ThreadManager.getInstance().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        //检验输入的信息是否合法，芯片号是否存在
//                        if(isSerialnumExist()){
//                            Intent intent = new Intent();
//                            intent.putExtra("chipnum",et_chipnum.getText().toString());
//                            setResult(RESULT_OK,intent);
//                            finish();
//                        }
//                    }
//                });
                if(et_chipnum.getText().toString()!=null&&et_chipnum.getText().toString().trim().length()>0){
                    Intent intent = new Intent();
                    intent.putExtra("cockinforeturn", et_chipnum.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }else {
//                    Toast.makeText(InputCockInfo.this, "data cann't be empty !", Toast.LENGTH_SHORT).show();
                    RxToast.warning(InputCockInfo.this, "data cann't be empty !", Toast.LENGTH_SHORT, true).show();

                }
            }
        });


    }

    private boolean isSerialnumExist(){
        return false;
    }
}
