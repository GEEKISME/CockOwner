package com.biotag.cockowner.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.GetAttrString;

/**
 * Created by Lxh on 2017/8/9.
 */

public class MyCockFragment extends BaseFragment {

    private View rootview = null;
    public static MyCockFragment newInstance() {
        Bundle args = new Bundle();
        MyCockFragment fragment = new MyCockFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.home_fragment_layout,container,false);
        initview(savedInstanceState);
        return rootview;
    }

    private void initview(Bundle savedInstanceState) {
        if(savedInstanceState==null){
            loadRootFragment(R.id.fl_container,MyCockSonFragment.newInstance(new String[]{GetAttrString.getMy_cock()}));
        }
    }


}
