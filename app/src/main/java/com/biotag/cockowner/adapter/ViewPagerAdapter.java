package com.biotag.cockowner.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Lxh on 2017/9/20.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private ArrayList<ImageView> ivList = new ArrayList<>();

    public ViewPagerAdapter(ArrayList<ImageView> ivList) {
        this.ivList = ivList;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(ivList.get(position));
        return ivList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
