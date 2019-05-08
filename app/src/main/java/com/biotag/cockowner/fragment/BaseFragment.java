package com.biotag.cockowner.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Lxh on 2017/8/9.
 */

public class BaseFragment extends SupportFragment {
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }
}
