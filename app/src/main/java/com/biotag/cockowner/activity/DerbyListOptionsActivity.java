package com.biotag.cockowner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.JavaBean.DerbyOptionBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.adapter.DerbyOptionsAdapter;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customview.SmoothCheckBox;
import com.biotag.cockowner.interfaces.RcvOnItemClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class DerbyListOptionsActivity extends AppCompatActivity {
    private RelativeLayout share;
    private TextView activity_title;
    private XRecyclerView lv_derbyoption;
    private ArrayList<DerbyOptionBean> derbyOptionsBeanList = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derby_list_options);
        initview();
        initdata();
        DerbyOptionsAdapter adapter = new DerbyOptionsAdapter(derbyOptionsBeanList, this);
        adapter.setRcvOnItemClickListener(new RcvOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(DerbyListOptionsActivity.this, "当前被点击的position 是"+position, Toast.LENGTH_SHORT).show();
                DerbyOptionBean bean = derbyOptionsBeanList.get(position);
                bean.setChecked(!bean.isChecked());
                SmoothCheckBox smoothCheckBox = (SmoothCheckBox)view.findViewById(R.id.scb);
                smoothCheckBox.setChecked(bean.isChecked(),true);
                Log.i(Constants.TAG,"走的接口,position "+ position+"的ischeck 的值是 "+bean.isChecked());
            }
        });

        lv_derbyoption.setAdapter(adapter);
        activity_title.setText("Derby Options");
        share.setVisibility(View.VISIBLE);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                for (int i = 0; i < derbyOptionsBeanList.size(); i++) {
                    DerbyOptionBean bean = derbyOptionsBeanList.get(i);
                    if(bean.isChecked()){
                        sb.append(bean.getDerbyoption());
                        sb.append(",");
                    }
                }
                String derbyselected = sb.toString();
//                derbyselected.substring(0,derbyselected.lastIndexOf(","));
                Log.i(Constants.TAG,"derbyselected acquired is "+derbyselected);
                intent.putExtra("derbyselected",derbyselected);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    private void initdata() {
        ArrayList<String> contestlist = getIntent().getStringArrayListExtra("contestlist");
        for (int i = 0; i < contestlist.size(); i++) {
            derbyOptionsBeanList.add(new DerbyOptionBean(false,contestlist.get(i)));
        }
    }

    private void initview() {
        RelativeLayout titlebar_derbyoption = findViewById(R.id.titlebar_derbyoption);
        RelativeLayout rl_back = titlebar_derbyoption.findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        share = titlebar_derbyoption.findViewById(R.id.share);
        activity_title = titlebar_derbyoption.findViewById(R.id.activity_title);
        TextView nextstep = titlebar_derbyoption.findViewById(R.id.nextstep);
        nextstep.setText(GetAttrString.getBasic_confirm());
        lv_derbyoption = findViewById(R.id.lv_derbyoption);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        lv_derbyoption.setLayoutManager(manager);
    }
}
