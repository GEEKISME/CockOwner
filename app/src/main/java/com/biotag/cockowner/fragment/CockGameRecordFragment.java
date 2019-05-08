package com.biotag.cockowner.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.biotag.cockowner.JavaBean.CockGameRecordBean;
import com.biotag.cockowner.JavaBean.CockGameRecordResultBean;
import com.biotag.cockowner.JavaBean.InputCockGameResultBean;
import com.biotag.cockowner.JavaBean.InputCockGameResultResultBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.adapter.CockGameRecordListAdapter;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customdialog.RxDialogSureCancel;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.customview.CommonLoadingPager;
import com.biotag.cockowner.interfaces.RcvOnGameRecordItemClickListener;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.GetJson;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.biotag.cockowner.utils.UIUtils;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Lxh on 2017/8/24.
 */

public class CockGameRecordFragment extends BaseFragment {
    private String chipCocde;
    public static final String CHIPCODE = "chipcode";

    private CockGameRecordListView contentview;

    public static CockGameRecordFragment newInstance(String chipcode) {
        Bundle args = new Bundle();
        args.putString(CHIPCODE, chipcode);
        CockGameRecordFragment fragment = new CockGameRecordFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chipCocde = getArguments().getString(CHIPCODE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        contentview = new CockGameRecordListView(getContext(), chipCocde);
        contentview.show();
        return contentview;
    }

    static class GameRecordListHandler extends Handler {
        private WeakReference<CockGameRecordFragment> cockGameRecordFragmentWeakReference;

        public GameRecordListHandler(CockGameRecordFragment cockGameRecordFragment) {
            cockGameRecordFragmentWeakReference = new WeakReference<CockGameRecordFragment>
                    (cockGameRecordFragment);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CockGameRecordFragment cockGameRecordFragment = cockGameRecordFragmentWeakReference.get();
            if (cockGameRecordFragment != null) {
                switch (msg.what) {
                    case Constants.SETWICOCK_SUC:
                        Log.i(Constants.TAG,"shoudao suc");
                        cockGameRecordFragment.contentview.holder1.btn_postwincock.setEnabled(false);
                        if (cockGameRecordFragment.contentview.holder1.radiobtn_1.isChecked()) {
                            cockGameRecordFragment.contentview.holder1.radiobtn_2.setVisibility(View.GONE);
                        } else {
                            cockGameRecordFragment.contentview.holder1.radiobtn_1.setVisibility(View.GONE);
                        }
//                        Toast.makeText(cockGameRecordFragment.getContext(), GetAttrString.getGameResultUploadSucc(),
//                                Toast.LENGTH_SHORT).show();
                        RxToast.success(cockGameRecordFragment.getContext(),GetAttrString.getGameResultUploadSucc(), Toast.LENGTH_SHORT, true).show();

                        break;
                    case Constants.SETWICOCK_FAI:
                        Log.i(Constants.TAG,"shoudao fai");
//                        Toast.makeText(cockGameRecordFragment.getContext(), GetAttrString.getGameResultUploadFail(),
//                                Toast.LENGTH_SHORT).show();
                        RxToast.error(cockGameRecordFragment.getContext(),GetAttrString.getGameResultUploadFail(), Toast.LENGTH_SHORT, true).show();

                        break;
                }
            }

        }
    }

    //===============================================================
    class CockGameRecordListView extends CommonLoadingPager {

        private Context context;
        private String chipCode;
        private XRecyclerView xrcv_cockgame_record;
        private CockGameRecordResultBean cockGameRecordResultBean;
        private CockGameRecordListAdapter.CockGameRecordItemHolder holder1 = null;
        private ArrayList<CockGameRecordResultBean.ValuesBean> cockGameRecordList = new ArrayList<>();
        private CockGameRecordListAdapter cockGameRecordListAdapter;

        //============================================================


        GameRecordListHandler handler = new GameRecordListHandler(CockGameRecordFragment.this);

        //============================================================

        public CockGameRecordListView(Context context, String chipCode) {
            super(context);
            this.context = context;
            this.chipCode = chipCode;
        }

        @Override
        public View createEmptyView() {
            View emptyview = UIUtils.inflate(R.layout.empty);
            mTvHint = (TextView) emptyview.findViewById(R.id.tv_hint);
            mTvHint.setText("No gamerecord found !");
            return emptyview;
        }

        @Override
        public View createSuccessView() {
            RelativeLayout rootview = new RelativeLayout(getContext());
            rootview.setBackgroundColor(UIUtils.getColor(R.color.white));
            View MyCockGameRecordListView = UIUtils.inflate(R.layout.cockgame_record_layout);
            xrcv_cockgame_record = (XRecyclerView) MyCockGameRecordListView.findViewById(R.id.xrcv_cockgame_record);
            xrcv_cockgame_record.setLayoutManager(new LinearLayoutManager(getContext()));
            cockGameRecordListAdapter = new CockGameRecordListAdapter(cockGameRecordList, getContext());
            xrcv_cockgame_record.setAdapter(cockGameRecordListAdapter);
            cockGameRecordListAdapter.setRcvOnGameRecordItemClickListener(new RcvOnGameRecordItemClickListener() {
                @Override
                public void onGameRecordItemClickListener(final CockGameRecordListAdapter.CockGameRecordItemHolder holder,
                                                          final int position) {
                    //===========================
                    final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(context);
                    holder1 = holder;
                    if(holder1.radiobtn_1.isChecked()){
                        rxDialogSureCancel.getContentView().setText(GetAttrString.getCockA() + " : " + GetAttrString.getSetWinCock());
                    }else if(holder1.radiobtn_2.isChecked()){
                        rxDialogSureCancel.getContentView().setText(GetAttrString.getCockB() + " : " + GetAttrString.getSetWinCock());
                    }
                    rxDialogSureCancel.getSureView().setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rxDialogSureCancel.dismiss();
                            ThreadManager.getInstance().execute(new Runnable() {
                                @Override
                                public void run() {
                                    InputCockGameResultBean cgrb = new InputCockGameResultBean();
                                    cgrb.setId(cockGameRecordList.get(position).getId());
                                    cgrb.setCock_chip1(cockGameRecordList.get(position).getCock_chip1());
                                    cgrb.setCock_chip2(cockGameRecordList.get(position).getCock_chip2());
                                    if(holder1.radiobtn_1.isChecked()){
                                        cgrb.setWin_cock(cockGameRecordList.get(position).getCock_chip1());
                                    }else {
                                        cgrb.setWin_cock(cockGameRecordList.get(position).getCock_chip2());
                                    }
                                    cgrb.setCreateAt(cockGameRecordList.get(position).getCreateAt());
                                    String requl = Constants.SET_WINCOCK_URL;
                                    String content = new Gson().toJson(cgrb);
                                    Log.djson(Constants.TAG,content);
                                    InputCockGameResultResultBean icgBean = OkhttpPlusUtil.getInstance().post(requl,content,InputCockGameResultResultBean.class);
                                    if(icgBean.isIsSuccess()){
                                        handler.sendEmptyMessage(Constants.SETWICOCK_SUC);
                                        Log.i(Constants.TAG,"fachu 1");
                                    }else {
                                        handler.sendEmptyMessage(Constants.SETWICOCK_FAI);
                                        Log.i(Constants.TAG,"fachu 0");
                                    }
                                }
                            });
                        }
                    });
                    rxDialogSureCancel.getCancelView().setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rxDialogSureCancel.dismiss();
                        }
                    });
                    rxDialogSureCancel.show();
                    //===========================
//                    AlertDialog ab = null;
//                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                    builder.setTitle("");
//                    holder1 = holder;
//                    if (holder1.radiobtn_1.isChecked()) {
//                        Log.i(Constants.TAG, "position 是  " + position + "  选中的是A");
//                        builder.setMessage(GetAttrString.getCockA() + " : " + GetAttrString.getSetWinCock());
//
//                    } else if (holder1.radiobtn_2.isChecked()) {
//                        Log.i(Constants.TAG, "position 是  " + position + "  选中的是B");
//                        builder.setMessage(GetAttrString.getCockB() + " : " + GetAttrString.getSetWinCock());
//                    }
//                    builder.setNegativeButton(GetAttrString.getBasic_cancel(), new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                        }
//                    });
//                    builder.setPositiveButton(GetAttrString.getBasic_confirm(), new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
////                            holder1.btn_postwincock.setEnabled(false);
//                            ThreadManager.getInstance().execute(new Runnable() {
//                                @Override
//                                public void run() {
//                                    InputCockGameResultBean cgrb = new InputCockGameResultBean();
//                                    cgrb.setId(cockGameRecordList.get(position).getId());
//                                    cgrb.setCock_chip1(cockGameRecordList.get(position).getCock_chip1());
//                                    cgrb.setCock_chip2(cockGameRecordList.get(position).getCock_chip2());
//                                    if(holder1.radiobtn_1.isChecked()){
//                                        cgrb.setWin_cock(cockGameRecordList.get(position).getCock_chip1());
//                                    }else {
//                                        cgrb.setWin_cock(cockGameRecordList.get(position).getCock_chip2());
//                                    }
//                                    cgrb.setCreateAt(cockGameRecordList.get(position).getCreateAt());
//                                    String requl = Constants.SET_WINCOCK_URL;
//                                    String content = new Gson().toJson(cgrb);
//                                    InputCockGameResultResultBean icgBean = OkhttpPlusUtil.getInstance().post(requl,content,InputCockGameResultResultBean.class);
//                                    if(icgBean.isIsSuccess()){
//                                        handler.sendEmptyMessage(Constants.SETWICOCK_SUC);
//                                        Log.i(Constants.TAG,"fachu 1");
//                                    }else {
//                                        handler.sendEmptyMessage(Constants.SETWICOCK_FAI);
//                                        Log.i(Constants.TAG,"fachu 0");
//                                    }
//                                }
//                            });
//                        }
//                    });
//                    ab = builder.create();
//                    ab.show();
                }
            });
            xrcv_cockgame_record.setPullRefreshEnabled(false);
            xrcv_cockgame_record.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    xrcv_cockgame_record.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    xrcv_cockgame_record.loadMoreComplete(false);
                }
            });
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            rootview.addView(MyCockGameRecordListView, lp);
            return rootview;
        }

        @Override
        public LoadResult load() {
            try {
                initdata();
                if (cockGameRecordResultBean == null) {
                    return check(cockGameRecordResultBean);
                } else if (cockGameRecordResultBean != null) {
                    cockGameRecordList.addAll(cockGameRecordResultBean.getValues());
                    return check(cockGameRecordList);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return LoadResult.STATE_ERROR;
        }

        private void initdata() {
            CockGameRecordBean crb = new CockGameRecordBean();
            crb.setCock_chip1(chipCode);
            String content = new Gson().toJson(crb);
            String requl = Constants.GAME_RECORD_URL;
            requl = GetJson.replace(requl, "{strQuery}", content);
            cockGameRecordResultBean = OkhttpPlusUtil.getInstance().get(requl, CockGameRecordResultBean.class);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (contentview != null ) {

            contentview.handler.removeCallbacksAndMessages(null);
        }
    }
}
