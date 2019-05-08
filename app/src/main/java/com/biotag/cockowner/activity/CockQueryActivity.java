package com.biotag.cockowner.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;

import static com.biotag.cockowner.activity.RecordCockInfoPartOneActivity.REQUEST_PERMISSION_CAMERA;

public class CockQueryActivity extends UserBaseActivity {

    private static final String CHIP_NUMBER = "chipnumber";
    private static final String DERBY = "derby";
    private static final String STAGE = "stage";
    private static final String STATUS = "status";

    private RelativeLayout rl_back,wrap_barscan;
    private Button btn_query;
    private TextView activity_title;
    private EditText et_chipcode;
    private RadioGroup rg_stagegroup,rg_statugroup,rg_derbygroup;
    private RadioButton rb1, rb2, rb3,rbs1,rbs2,rbs3,rb4,rbs4,rbd1,rbd2,rbd3,rbd4;
//    private NiceSpinner ninespinner;
    private Context context = this;
    private static final int REQ_BAR = 1;
    private ArrayList<String> contestList = new ArrayList<>();
    private ArrayList<Integer> contestIdList = new ArrayList<>();
    private NiceSpinner niceSpinner;
    private int derbyid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cock_query);
        initcontestlist();
        initView();
        initlistener();

    }

    private void initcontestlist() {
        contestList.add("All");
        contestIdList.add(124213);
        int contestnum = SharedPreferencesUtils.getInt(context, "contestsize", 0);
        if (contestnum > 0) {
            for (int j = 0; j < contestnum; j++) {
                contestList.add(SharedPreferencesUtils.getString(context, "contest" + (j + 1), ""));
                contestIdList.add(SharedPreferencesUtils.getInt(context, "contestid" + (j + 1), 0));
            }
        }
    }

    private void initlistener() {
        rg_derbygroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==rbd2.getId()||checkedId==rbd3.getId()||checkedId==rbd4.getId()){
                    RadioButton rb = (RadioButton)group.findViewById(checkedId);
                    rb.setChecked(true);
                    rbd1.setChecked(false);
                }
            }
        });
        rg_stagegroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if ( checkedId == rb2.getId() || checkedId == rb3.getId()||checkedId==rb4.getId()) {
                    RadioButton rb = (RadioButton) group.findViewById(checkedId);
                    rb.setChecked(true);
                    rb1.setChecked(false);
                }
            }
        });

        rg_statugroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if ( checkedId == rbs2.getId() || checkedId == rbs3.getId()||checkedId==rbs4.getId()) {
                    RadioButton rb = (RadioButton) group.findViewById(checkedId);
                    rb.setChecked(true);
                    rbs1.setChecked(false);
                }
            }
        });

        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkQueryCondition();
            }
        });

        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        activity_title.setText(GetAttrString.getCockQuery());
        wrap_barscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CockQueryActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CAMERA);
                    return;
                }
                Intent intent = new Intent(context, SecondActivity.class);
                startActivityForResult(intent, REQ_BAR);
            }
        });

    }


    private void checkQueryCondition() {
        Intent intent = new Intent(CockQueryActivity.this, CockQueryResultActivity.class);
        String chipnumber = et_chipcode.getText().toString();
//        RadioButton rbd = (RadioButton)findViewById(rg_derbygroup.getCheckedRadioButtonId());
//        derby = rbd.getTag().toString();//derby 的值是1,2,3,4
//        derby = ninespinner.getText().toString();
//        if(derby.equals("BULLANG BULLANG")){
//            derby = "1";
//        }else if(derby.equals("President's Cup")){
//            derby = "2";
//        } else if (derby.equals("SABAYAN")) {
//            derby = "3";
//        }else {
//            derby = "4";
//        }

        RadioButton rb = (RadioButton) findViewById(rg_stagegroup.getCheckedRadioButtonId());
        String stage = rb.getTag().toString();
        RadioButton rbs = (RadioButton)findViewById(rg_statugroup.getCheckedRadioButtonId());
        String status = rbs.getTag().toString();
        if(chipnumber ==null|| chipnumber.trim().length()==0){
            intent.putExtra(CHIP_NUMBER, "str");
        }else if(chipnumber !=null&& chipnumber.trim().length()>0) {
            intent.putExtra(CHIP_NUMBER, chipnumber);
        }
        String derby = niceSpinner.getText().toString();
        for (int i = 0; i < contestList.size(); i++) {
            if (derby.equals(contestList.get(i))) {
                derbyid = contestIdList.get(i);
            }
        }
        intent.putExtra("derbysele", derby);
        intent.putExtra(DERBY,String.valueOf(derbyid));
        intent.putExtra(STAGE, stage);
        intent.putExtra(STATUS, status);
        startActivity(intent);
        overridePendingTransition(R.anim.activity_in_form_right,R.anim.activity_out_to_left);
    }

    private void initView() {
        niceSpinner = findViewById(R.id.nicespinner);
        niceSpinner.setDropDownListPaddingBottom(500);
        niceSpinner.canScrollVertically(BIND_AUTO_CREATE);
        niceSpinner.attachDataSource(contestList);
        wrap_barscan = findViewById(R.id.wrap_barscan);
        RelativeLayout titlebar = findViewById(R.id.titlebar);
        rl_back = titlebar.findViewById(R.id.rl_back);
        activity_title = titlebar.findViewById(R.id.activity_title);
        TextView tv_phase = findViewById(R.id.tv_phase);
        tv_phase.setText(GetAttrString.getCurrentStageOptions());
        TextView tv_status = findViewById(R.id.tv_status);
        tv_status.setText(GetAttrString.getCurrentStatusOption());
        et_chipcode = findViewById(R.id.et_chipcode);
        et_chipcode.setHint(GetAttrString.getCock_ChipCode());
        rg_derbygroup = findViewById(R.id.rg_derbygroup);
        rg_stagegroup = findViewById(R.id.rg_stagegroup);
        rg_statugroup = findViewById(R.id.rg_statugroup);


        btn_query = findViewById(R.id.btn_query);
        btn_query.setText(GetAttrString.getQuery());
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        rb1.setText(GetAttrString.getLevel1());
        rb2.setText(GetAttrString.getLevel2());
        rb3.setText(GetAttrString.getLevel3());
        rb4.setText(GetAttrString.getAlllv());
        rbs1 = (RadioButton)findViewById(R.id.rbs1);
        rbs2 = (RadioButton)findViewById(R.id.rbs2);
        rbs3 = (RadioButton)findViewById(R.id.rbs3);
        rbs4 = (RadioButton)findViewById(R.id.rbs4);

        rbs1.setText(GetAttrString.getnormal());
        rbs2.setText(GetAttrString.getabort());
        rbs3.setText(GetAttrString.getlost());
        rbs4.setText(GetAttrString.getAlllv());
        rbd1 = (RadioButton)findViewById(R.id.rbd1);
        rbd2 = (RadioButton)findViewById(R.id.rbd2);
        rbd3 = (RadioButton)findViewById(R.id.rbd3);
        rbd4 = (RadioButton)findViewById(R.id.rbd4);
        rbd4.setText("All");

//        ninespinner = (NiceSpinner)findViewById(R.id.ninespinner);
//        ArrayList<String> derbylist = new ArrayList<>();
//        int nums = SharedPreferencesUtils.getInt(context,"contestsize",0);
//        Log.i(Constants.TAG,"nums is "+ nums);
//        if(nums!=0){
//            for (int i = 0; i < nums; i++) {
//                int s =i+1;
//                String temp = SharedPreferencesUtils.getString(context,"contest"+s,"");
//                Log.i("nkk","temp is "+temp);
//                derbylist.add(SharedPreferencesUtils.getString(context,"contest"+s,""));
//            }
//            ninespinner.attachDataSource(derbylist);
//        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQ_BAR&&resultCode==RESULT_OK&& data!=null){
            final Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            if(bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS){
                String result = bundle.getString(CodeUtils.RESULT_STRING);
                et_chipcode.setText(result);
            }
        }
    }
}
