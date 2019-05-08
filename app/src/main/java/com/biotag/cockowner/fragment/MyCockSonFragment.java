package com.biotag.cockowner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.biotag.cockowner.R;
import com.biotag.cockowner.activity.CockQueryActivity;
import com.biotag.cockowner.activity.UserProfileActivity;

/**
 * Created by Lxh on 2017/8/9.
 */

public class MyCockSonFragment extends MyCockFatherFragment {

    public static MyCockSonFragment newInstance(String[] titles) {
        Bundle args = new Bundle();
        args.putStringArray(ARG,titles);
        MyCockSonFragment fragment = new MyCockSonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mTitles = getArguments().getStringArray(ARG);
        supportFragments.add(MyCockListFragment.newInstance());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_mainlayout_fragment,container,false);
        initview(view);
        return view;
    }

    @Override
    protected void initview(View view) {
        super.initview(view);
        mTab.setSelectedTabIndicatorHeight(0);
        RelativeLayout rl_search_go = view.findViewById(R.id.rl_search_go);
        RelativeLayout rl_back = view.findViewById(R.id.rl_back);
        ImageView iv_back = view.findViewById(R.id.iv_back);
        iv_back.setImageDrawable(getResources().getDrawable(R.drawable.usernames));
        rl_search_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CockQueryActivity.class);
                startActivity(intent);
//                getActivity().overridePendingTransition(R.anim.activity_in_from_up,R.anim.activity_out_from_down);
//                getActivity().overridePendingTransition(R.anim.activity_in_from_up,0);
            }
        });

        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), UserProfileActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_in_form_right,R.anim.activity_out_fade);
            }
        });

    }


}
