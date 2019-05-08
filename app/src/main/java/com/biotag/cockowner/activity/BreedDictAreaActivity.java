package com.biotag.cockowner.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.utils.SharedPreferencesUtils;

import static com.biotag.cockowner.activity.RecordCockInfoPartOneActivity.REQUESTCODE_BREEDID;

public class BreedDictAreaActivity extends AppCompatActivity {
    private AutoCompleteTextView autotext;
    private Intent intent;
    private Context context = this;
    private String[] breedNameArray;
    private int[] breedIdArray;
    private int breedId ;
    private int breedNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_dict_area);
        intent = getIntent();
        initview();
    }

    private void initview() {
        RelativeLayout titlebar_breeddictarea = findViewById(R.id.titlebar_breeddictarea);
        RelativeLayout rl_back = titlebar_breeddictarea.findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        RelativeLayout share = titlebar_breeddictarea.findViewById(R.id.share);

        TextView nextstep = titlebar_breeddictarea.findViewById(R.id.nextstep);
        share.setVisibility(View.VISIBLE);
        nextstep.setVisibility(View.VISIBLE);
        nextstep.setText(GetAttrString.getBasic_confirm());
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String breedName = autotext.getText().toString();
                for (int i = 0; i <breedNum ; i++) {
                    if(breedNameArray[i].equals(breedName)){
                        Intent intent = new Intent();
                        intent.putExtra("cockinforeturn_breedid",breedIdArray[i]);
                        intent.putExtra("cockinforeturn_breedname",breedNameArray[i]);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                }


            }
        });
        //==================================
        autotext = findViewById(R.id.autotext);
        autotext.setThreshold(1);
        breedNum = SharedPreferencesUtils.getInt(context, Constants.BREED_NUM,0);
        if(breedNum!=0){
            breedNameArray = new String[breedNum];
            breedIdArray = new int[breedNum];
            for (int i = 0; i < breedNum; i++) {
                breedNameArray[i] = SharedPreferencesUtils.getString(context,"breedName"+i,"");
                breedIdArray[i]   = SharedPreferencesUtils.getInt(context,"breedid"+i,0);
            }
            ArrayAdapter<String> breedNameArrayadapter = new ArrayAdapter<String>(context, android.R.layout
                    .simple_list_item_1, breedNameArray);
            autotext.setAdapter(breedNameArrayadapter);
        }


        //==============================================================
        String oriinfo = intent.getStringExtra("oriinfo");
        autotext.setText(oriinfo);
        TextView activity_title = titlebar_breeddictarea.findViewById(R.id.activity_title);
        switch (intent.getIntExtra("cockinfo",0)){
            case REQUESTCODE_BREEDID:
                activity_title.setText(GetAttrString.getCock_breedid());
                break;
        }
    }
}
