package com.biotag.cockowner.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.fragment.CockGameRecordFragment;

import me.yokeyword.fragmentation.SupportFragment;

public class CockGameRecordActivity extends SuperBaseActivity {
    private Context context = this;
    private SupportFragment[] mFragments = new SupportFragment[1];
    public static final int FIRST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cock_game_info);
        String chipcode = getIntent().getStringExtra("cockchipcode");
        Log.i(Constants.TAG, chipcode);
        initView();
        if (savedInstanceState == null) {
            mFragments[FIRST] = CockGameRecordFragment.newInstance(chipcode);
            loadMultipleRootFragment(R.id.fl_cockgamerecord_content, FIRST, mFragments[FIRST]);
        } else {
            mFragments[FIRST] = findFragment(CockGameRecordFragment.class);
        }
        //        initdata();
    }


    private void initView() {
        RelativeLayout titlebar_cockgame = findViewById(R.id.titlebar_cockgame);
        RelativeLayout rl_back = titlebar_cockgame.findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_in_from_left, R.anim.activity_out_to_right);

            }
        });
        TextView activity_title = titlebar_cockgame.findViewById(R.id.activity_title);
        activity_title.setText(GetAttrString.getCock_gamerecord());
    }
}
