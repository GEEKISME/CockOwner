package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.progressindicator.AVLoadingIndicatorView;

public class LoadingMoreFooter extends LinearLayout {

    private SimpleViewSwithcer progressCon;
    private Context mContext;
    public final static int STATE_LOADING = 0;
    public final static int STATE_COMPLETE = 1;
    public final static int STATE_NOMORE = 2;
    private TextView mText;
    private TextView nodata;
	public LoadingMoreFooter(Context context) {
		super(context);
		initView(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public LoadingMoreFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

    public void initView(Context context ){
        mContext = context;
        setGravity(Gravity.CENTER);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);
        progressCon = new SimpleViewSwithcer(context);
        progressCon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        AVLoadingIndicatorView progressView = new  AVLoadingIndicatorView(this.getContext());
        progressView.setIndicatorColor(0xffB5B5B5);
        progressView.setIndicatorId(ProgressStyle.BallSpinFadeLoader);
        progressCon.setView(progressView);

        addView(progressCon);

        mText = new TextView(context);
        mText.setTextColor(Color.parseColor("#FF8e8e8e"));
        mText.setText("Loading...");
        mText.setTextSize(12);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins( 0,-(int)getResources().getDimension(R.dimen.textandiconmargin),0,0 );

        mText.setLayoutParams(layoutParams);
        addView(mText);

        nodata = new TextView(context);
        LinearLayout.LayoutParams layoutParams1 =new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams1.setMargins(0,(int)getResources().getDimension(R.dimen.margin),0,(int)getResources().getDimension(R.dimen.margin));
        nodata.setLayoutParams(layoutParams1);
        nodata.setTextSize(12);
        nodata.setTextColor(Color.parseColor("#FF8e8e8e"));
        nodata.setVisibility(GONE);
        addView(nodata);
    }

    public void setProgressStyle(int style) {
        if(style == ProgressStyle.SysProgress){
            ProgressBar progressBar =new ProgressBar(mContext);
            Drawable d = this.getResources().getDrawable(R.drawable.loading_more);
            d.setBounds(1,1,16,16);
            progressBar.setIndeterminateDrawable(d);
            progressCon.setView(progressBar);
        }else{
            AVLoadingIndicatorView progressView = new  AVLoadingIndicatorView(this.getContext());
            progressView.setIndicatorColor(0xffB5B5B5);
            progressView.setIndicatorId(style);
            progressCon.setView(progressView);
        }
    }

    public void  setState(int state) {
        switch(state) {
            case STATE_LOADING:
                progressCon.setVisibility(View.VISIBLE);
                mText.setText(mContext.getText(R.string.listview_loading));
                this.setVisibility(View.VISIBLE);
                    break;
            case STATE_COMPLETE:
                mText.setText(mContext.getText(R.string.listview_loading));
                this.setVisibility(View.GONE);
                break;
            case STATE_NOMORE:
                mText.setVisibility(GONE);
                progressCon.setVisibility(View.GONE);
                nodata.setVisibility(VISIBLE);
                //nodata.setText(mContext.getText(R.string.nomore_loading));
                this.setVisibility(View.VISIBLE);
                break;
        }

    }
}
