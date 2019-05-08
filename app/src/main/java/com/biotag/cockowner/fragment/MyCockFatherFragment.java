package com.biotag.cockowner.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biotag.cockowner.R;
import com.biotag.cockowner.adapter.ViewPagerFragmentAdapter;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Lxh on 2017/8/9.
 */

public class MyCockFatherFragment extends BaseFragment {
    protected String                     TAG              = "MyCockFatherFragment";
    protected static String              ARG              = "titles";
    protected ArrayList<SupportFragment> supportFragments =new ArrayList<>();

    protected TabLayout mTab;
    protected ViewPager mViewPager;
    protected String[]  mTitles;

    public static MyCockFatherFragment newInstance(String[] titles) {

        Bundle args = new Bundle();
        args.putStringArray(ARG,titles);
        MyCockFatherFragment fragment = new MyCockFatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitles = getArguments().getStringArray(ARG);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_fragment,container,false);
        initview(view);
        return view;
    }

    protected void initview(View view) {
        mTab = (TabLayout)view.findViewById(R.id.tab);
        mViewPager = (ViewPager)view.findViewById(R.id.viewPager);
        if (mTitles!=null) {
            for (int i = 0; i < mTitles.length;i++){
                mTab.addTab(mTab.newTab());
            }
            mViewPager.setAdapter(new ViewPagerFragmentAdapter(getChildFragmentManager(), mTitles,supportFragments));//实现了viewpager与supportFragments集合
            mTab.setupWithViewPager(mViewPager);//中的SupportFragment的结合
        }
    }


}
