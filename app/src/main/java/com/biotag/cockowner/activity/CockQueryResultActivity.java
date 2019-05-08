package com.biotag.cockowner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.fragment.CockQueryResultFragment;

import me.yokeyword.fragmentation.SupportFragment;

public class CockQueryResultActivity extends SuperBaseActivity {

    private static final String CHIP_NUMBER = "chipnumber";
    private static final String DERBY = "derby";
    private static final String STAGE = "stage";
    private static final String STATUS = "status";
    public static final int FIRST = 0;
    private SupportFragment[] mFragments = new SupportFragment[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cock_query_result);
        Intent intent = getIntent();
        String chipnumer = intent.getStringExtra(CHIP_NUMBER);
        String derby = intent.getStringExtra(DERBY);
        String stage = intent.getStringExtra(STAGE);
        String status = intent.getStringExtra(STATUS);
        String derbysele = intent.getStringExtra("derbysele");
        String[] querycondition = new String[]{chipnumer, derby, derbysele, stage, status};
        
        initview();
        if(savedInstanceState==null){
            mFragments[FIRST] = CockQueryResultFragment.newInstance(querycondition);
            loadMultipleRootFragment(R.id.fl_queryresult_content,FIRST,mFragments[FIRST]);
        }else {
            mFragments[FIRST] = findFragment(CockQueryResultFragment.class);
        }


    }

    private void initview() {
        RelativeLayout titlebar_queryresult = findViewById(R.id.titlebar_queryresult);
        RelativeLayout rl_back = titlebar_queryresult.findViewById(R.id.rl_back);
        TextView activity_title = titlebar_queryresult.findViewById(R.id.activity_title);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        activity_title.setText(GetAttrString.getSearchResult());
    }
}
