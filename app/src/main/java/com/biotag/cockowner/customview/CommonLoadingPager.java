package com.biotag.cockowner.customview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.biotag.cockowner.R;
import com.biotag.cockowner.utils.UIUtils;


/**
 * Created by duanfangfang on 2016/9/21.
 */
public abstract class CommonLoadingPager extends NewLoadingPager {

    protected TextView mTvHint;//加载为空时的提示
    protected View mRefreshButton;

    public CommonLoadingPager(Context context) {
        super(context);
    }

    @Override
    public View createLoadingView() {
        return UIUtils.inflate(R.layout.loading);
    }

    @Override
    protected View createEmptyView() {
        View emptyView = UIUtils.inflate(R.layout.empty);
        mTvHint = (TextView) emptyView.findViewById(R.id.tv_hint);
        return emptyView;
    }

    @Override
    public View createErrorView() {
        View refresh_view = UIUtils.inflate(R.layout.refresh);
        mRefreshButton = refresh_view.findViewById(R.id.refreshbutton);
        mRefreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        return refresh_view;
    }


}
