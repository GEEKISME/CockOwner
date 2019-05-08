package com.biotag.cockowner.interfaces;

import com.biotag.cockowner.adapter.CockGameRecordListAdapter;

/**
 * Created by Lxh on 2017/11/30.
 */

public interface RcvOnGameRecordItemClickListener {
    void onGameRecordItemClickListener(CockGameRecordListAdapter.CockGameRecordItemHolder holder, int position);
}
