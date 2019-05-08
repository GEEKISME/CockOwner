package com.biotag.cockowner.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.biotag.cockowner.JavaBean.InputCockGameResultBean;
import com.biotag.cockowner.JavaBean.InputCockGameResultResultBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;

public class InputGameResultActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private RelativeLayout portrait_backbtn;
    private RelativeLayout rl_back;
    private TextView activity_title;
    private TextView nextstep;
    private RelativeLayout share;
    private RelativeLayout activity_title_bar;
    private TextView wincockchip;
    private RadioButton rb_cock1;
    private RadioButton rb_cock2;
    private RadioGroup rg_cockchipcode;
    private Button btn_query;
    private RelativeLayout activity_input_game_result;
    private Bundle bundle = null;
    private InputCockGameResultResultBean icgBean;
    private Context context = this;
    public static final int SUCCESS_POST = 0;
    public static final int FAIL_POST = 1;

    static class InputGameResultHandler extends Handler{
        private WeakReference<InputGameResultActivity>inputGameResultActivityWeakReference;
        public InputGameResultHandler(InputGameResultActivity inputGameResultActivity){
            inputGameResultActivityWeakReference = new WeakReference<InputGameResultActivity>(inputGameResultActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            InputGameResultActivity inputGameResultActivity = inputGameResultActivityWeakReference.get();
            if(inputGameResultActivity!=null){
                switch (msg.what){
                    case SUCCESS_POST:
//                        Toast.makeText(inputGameResultActivity, inputGameResultActivity.getResources().getString(R.string.uploadsuccess), Toast.LENGTH_SHORT).show();
                        RxToast.success(inputGameResultActivity, inputGameResultActivity.getResources().getString(R.string.uploadsuccess), Toast.LENGTH_SHORT, true).show();

                        inputGameResultActivity.btn_query.setEnabled(false);
                        break;
                    case FAIL_POST:
//                        Toast.makeText(inputGameResultActivity, inputGameResultActivity.getResources().getString(R.string.uploadfailed), Toast.LENGTH_SHORT).show();
                        RxToast.error(inputGameResultActivity, inputGameResultActivity.getResources().getString(R.string.uploadfailed), Toast.LENGTH_SHORT, true).show();

                        inputGameResultActivity.btn_query.setEnabled(false);
                        break;
                }
            }
        }
    }

    private InputGameResultHandler handler  = new InputGameResultHandler(this);

//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case SUCCESS_POST:
//                    Toast.makeText(context, getResources().getString(R.string.uploadsuccess), Toast.LENGTH_SHORT).show();
//                    btn_query.setEnabled(false);
//                    break;
//                case FAIL_POST:
//                    Toast.makeText(context, getResources().getString(R.string.uploadfailed), Toast.LENGTH_SHORT).show();
//                    btn_query.setEnabled(false);
//                    break;
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_game_result);
        bundle = getIntent().getExtras();
        initView();
        initlistener();

    }

    private void initlistener() {
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        activity_title.setText(getResources().getString(R.string.uploadgameresult));
        rg_cockchipcode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==rb_cock2.getId()){
                    RadioButton rb = (RadioButton)group.findViewById(checkedId);
                    rb.setChecked(true);
                    rb_cock1.setChecked(false);
                }
            }
        });
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        portrait_backbtn = (RelativeLayout) findViewById(R.id.portrait_backbtn);
        rl_back = (RelativeLayout) findViewById(R.id.rl_back);
        activity_title = (TextView) findViewById(R.id.activity_title);
        nextstep = (TextView) findViewById(R.id.nextstep);
        share = (RelativeLayout) findViewById(R.id.share);
        activity_title_bar = (RelativeLayout) findViewById(R.id.activity_title_bar);
        wincockchip = (TextView) findViewById(R.id.wincockchip);
        rb_cock1 = (RadioButton) findViewById(R.id.rb_cock1);
        rb_cock2 = (RadioButton) findViewById(R.id.rb_cock2);
        rg_cockchipcode = (RadioGroup) findViewById(R.id.rg_cockchipcode);
        btn_query = (Button) findViewById(R.id.btn_query);
        activity_input_game_result = (RelativeLayout) findViewById(R.id.activity_input_game_result);

        btn_query.setOnClickListener(this);

        rb_cock1.setText(bundle.getString("cock_chip1"));
        rb_cock2.setText(bundle.getString("cock_chip2"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_query:
                uploadingGameResult();
                break;
        }
    }

    private void uploadingGameResult() {
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                InputCockGameResultBean cgrb = new InputCockGameResultBean();
                cgrb.setId(bundle.getInt("id"));
                cgrb.setCock_chip1(bundle.getString("cock_chip1"));
                cgrb.setCock_chip2(bundle.getString("cock_chip2"));
                RadioButton rb = (RadioButton)findViewById(rg_cockchipcode.getCheckedRadioButtonId());
                cgrb.setWin_cock(rb.getText().toString());
                cgrb.setCreateAt(bundle.getString("createAt"));
                String requl = Constants.SET_WINCOCK_URL;
                String content  = new Gson().toJson(cgrb);
                Log.i(Constants.TAG,content);
                icgBean=OkhttpPlusUtil.getInstance().post(requl,content, InputCockGameResultResultBean.class);
                if(icgBean!=null){
                    if(icgBean.isIsSuccess()){
                        handler.sendEmptyMessage(SUCCESS_POST);
                    }else {
                        handler.sendEmptyMessage(FAIL_POST);
                    }
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
