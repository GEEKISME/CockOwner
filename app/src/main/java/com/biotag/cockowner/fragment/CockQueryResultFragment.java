package com.biotag.cockowner.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.JavaBean.CockSearchBean;
import com.biotag.cockowner.JavaBean.CockSearchResultBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.adapter.CockListViewAdapter;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.customview.CommonLoadingPager;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.GetJson;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.biotag.cockowner.utils.UIUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * Created by Lxh on 2017/8/10.
 */

public class CockQueryResultFragment extends BaseFragment {

    private static final String ARG_QUERYCONDITION = "CockQueryResultFragment";
    private String[] querycondition;
    private ArrayList<String> contestList = new ArrayList();
    private ArrayList<Integer> contestIdList = new ArrayList<>();


    public static CockQueryResultFragment newInstance(String[] querycondition) {
        Bundle args = new Bundle();
        args.putStringArray(ARG_QUERYCONDITION, querycondition);
        CockQueryResultFragment fragment = new CockQueryResultFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private CockQueryResultListview contentview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        querycondition = getArguments().getStringArray(ARG_QUERYCONDITION);
        initcontestlist();
    }

    private void initcontestlist() {
        contestList.add("All");
        contestIdList.add(124213);
        int contestnum = SharedPreferencesUtils.getInt(getContext(), "contestsize", 0);
        if (contestnum > 0) {
            for (int j = 0; j < contestnum; j++) {
                contestList.add(SharedPreferencesUtils.getString(getContext(), "contest" + (j + 1), ""));
                contestIdList.add(SharedPreferencesUtils.getInt(getContext(), "contestid" + (j + 1), 0));
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentview = new CockQueryResultListview(getContext(), querycondition);
        contentview.show();
        return contentview;
    }

    //============================================================
    class CockQueryResultListview extends CommonLoadingPager {
        private Context context;
        private int currentIndex = 1;
        private String[] querycondition;
        private CockSearchResultBean cockSearchResultBean;
        private ArrayList<CockSearchResultBean.ValuesBean> cockSearchResultList = new ArrayList<>();
        private XRecyclerView xrcv_cockqueryresult;
        private TextView tv_derby_value, tv_chipnumber_value, tv_stage_value,tv_status_value;
        private TextView tv_derby,tv_chipnumber,tv_stage,tv_status;
        private RelativeLayout rl_derby, rl_chipnum, rl_stage,rl_status;
        private CockListViewAdapter cockListViewAdapter;
        private String derbySelection;

        public CockQueryResultListview(Context context, String[] querycondition) {
            super(context);
            this.context = context;
            this.querycondition = querycondition;
        }

        @Override
        protected View createEmptyView() {
            View emptyView = UIUtils.inflate(R.layout.empty);
            mTvHint = (TextView) emptyView.findViewById(R.id.tv_hint);
            mTvHint.setText("There is no qualified Gamefowl !");
            return emptyView;
        }

        @Override
        public View createSuccessView() {
            RelativeLayout rootview = new RelativeLayout(getContext());
            rootview.setBackgroundColor(UIUtils.getColor(R.color.white));
            View MyQueryCockListView = UIUtils.inflate(R.layout.cockqueryresult_layout);
            //=============================================
            rl_chipnum = (RelativeLayout) MyQueryCockListView.findViewById(R.id.rl_chipnum);
            rl_derby   = (RelativeLayout) MyQueryCockListView.findViewById(R.id.rl_derby);
            rl_stage   = (RelativeLayout) MyQueryCockListView.findViewById(R.id.rl_stage);
            rl_status  = (RelativeLayout) MyQueryCockListView.findViewById(R.id.rl_status);
            //=============================================
            tv_derby = (TextView)MyQueryCockListView.findViewById(R.id.tv_derby);
            tv_derby_value = (TextView)MyQueryCockListView.findViewById(R.id.tv_derby_value);
            tv_chipnumber = (TextView)MyQueryCockListView.findViewById(R.id.tv_chipnumber);
            tv_chipnumber_value = (TextView) MyQueryCockListView.findViewById(R.id.tv_chipnumber_value);
            tv_stage_value = (TextView) MyQueryCockListView.findViewById(R.id.tv_stage_value);
            tv_stage = (TextView)MyQueryCockListView.findViewById(R.id.tv_stage);
            tv_status = (TextView)MyQueryCockListView.findViewById(R.id.tv_status);
            tv_status_value = (TextView)MyQueryCockListView.findViewById(R.id.tv_status_value);

            
            
            
            //+++++++++++++++++++++++++++++++++++++++
            tv_chipnumber.setText(GetAttrString.getCock_ChipCode());
            tv_derby.setText(GetAttrString.getCock_no());
            tv_stage.setText(GetAttrString.getCurrentStage());
            tv_status.setText(GetAttrString.getCurrentStatus());
            //+++++++++++++++++++++++++++++++++++++++
            if(querycondition[0].equals("str")){
                rl_chipnum.setVisibility(GONE);
            }else {
                tv_chipnumber_value.setText(querycondition[0]);
            }
            

//            if(querycondition[1].equals("1")){
//                tv_derby_value.setText(SharedPreferencesUtils.getString(context,"contest0",""));
//            }else if(querycondition[1].equals("2")){
//                tv_derby_value.setText(SharedPreferencesUtils.getString(context,"contest1",""));
//            }else if(querycondition[1].equals("3")){
//                tv_derby_value.setText(SharedPreferencesUtils.getString(context,"contest2",""));
//            }else {
//                tv_derby_value.setText("All");
//            }
            tv_derby_value.setText(querycondition[2]);

            if(querycondition[3].equals("1")){
                tv_stage_value.setText("1st");
            }else if(querycondition[3].equals("2")){
                tv_stage_value.setText("2nd");
            }else if(querycondition[3].equals("3")){
                tv_stage_value.setText("3rd");
            }else {
                tv_stage_value.setText("All");
            }

//            int contestnum = SharedPreferencesUtils.getInt(context, "contestsize", 0);
//            contestnum++;
//            for (int i = 0; i <contestnum ; i++) {
//                if(contestIdList.get(i).equals(querycondition[1])){
//                    tv_derby_value.setText(contestList.get(i));
//                    derbySelection = contestList.get(i);
//                }
//            }


            if(querycondition[4].equals("1")){
                tv_status_value.setText(GetAttrString.getStatusData_cocks_cStatus_normal());
            }else if(querycondition[4].equals("2")){
                tv_status_value.setText(GetAttrString.getStatusData_cocks_cStatus_abort());
            }else if(querycondition[4].equals("3")){
                tv_status_value.setText(GetAttrString.getStatusData_cocks_cStatus_lost());
            }else {
                tv_status_value.setText("All");
            }
            xrcv_cockqueryresult = (XRecyclerView) MyQueryCockListView.findViewById(R.id.xrcv_cockqueryresult);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            rootview.addView(MyQueryCockListView, lp);
            xrcv_cockqueryresult.setPullRefreshEnabled(false);
            xrcv_cockqueryresult.setLayoutManager(new GridLayoutManager(getContext(), 2));
            int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dimen_5);
            xrcv_cockqueryresult.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
            xrcv_cockqueryresult.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    xrcv_cockqueryresult.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    ThreadManager.getInstance().execute(new Runnable() {
                        boolean isLoadMore = false;
                        @Override
                        public void run() {
                            initgetdata();
                            if(cockSearchResultBean!=null&&cockSearchResultBean.getValues().size()>0){
                                currentIndex++;
                                cockSearchResultList.addAll(cockSearchResultBean.getValues());
                                isLoadMore = true;
                            }
                            UIUtils.post(new Runnable() {
                                @Override
                                public void run() {
                                    xrcv_cockqueryresult.refreshComplete();
                                    if(isLoadMore){
                                        cockListViewAdapter.notifyDataSetChanged();
                                    }
                                }
                            });
                            UIUtils.post(new Runnable() {
                                @Override
                                public void run() {
                                    xrcv_cockqueryresult.loadMoreComplete(false);
                                }
                            });
                        }
                    });
                }
            });
            cockListViewAdapter = new CockListViewAdapter(cockSearchResultList, context,getActivity());
            xrcv_cockqueryresult.setAdapter(cockListViewAdapter);

            return rootview;
        }

        @Override
        public LoadResult load() {
            try {
                initgetdata();
                if(cockSearchResultBean==null){
                    return check(cockSearchResultBean);
                }else if(cockSearchResultBean!=null){
                    currentIndex++;
                    cockSearchResultList.addAll(cockSearchResultBean.getValues());
                    return check(cockSearchResultList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return LoadResult.STATE_ERROR;
        }

        private void initgetdata() {
            CockSearchBean csb = new CockSearchBean();
            csb.setCurrIndex(currentIndex);
            csb.setOwnerID(SharedPreferencesUtils.getInt(context,Constants.ID,-1));
            csb.setPageSize(10);
            csb.setBreedID(0);
            //设置cstatus
            if (querycondition[4].equals("1")) {
                csb.setcStatus((byte)1);
            }else if(querycondition[4].equals("2")){
                csb.setcStatus((byte)2);
            }else if(querycondition[4].equals("3")){
                csb.setcStatus((byte)3);
            }else csb.setcStatus((byte)0);
            // 设置chipcode
            if(!querycondition[0].equals("str")){
                csb.setChipCode(querycondition[0]);
            }

            String str;


            //设置cockno  不用设置cockno 了，也就是不传derby了
//            String str ;
//            if(querycondition[1].equals("1")){
//                str = SharedPreferencesUtils.getString(context,"contest0","");
//                try {
//                    str = URLEncoder.encode(str,"utf-8");
////                    csb.setCockNo(str);
//                    csb.setCockNo("derbytest");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }else if(querycondition[1].equals("2")){
//                str = SharedPreferencesUtils.getString(context,"contest1","");
//                try {
//                    str = URLEncoder.encode(str,"utf-8");
////                    csb.setCockNo(str);
//                    csb.setCockNo("derbytest");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }else if(querycondition[1].equals("3")){
//                str = SharedPreferencesUtils.getString(context,"contest2","");
//                try {
//                    str = URLEncoder.encode(str,"utf-8");
////                    csb.setCockNo(str);
//                    csb.setCockNo("derbytest");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//            }else {
////                csb.setCockNo("");
//                csb.setCockNo("derbytest");
//            }
            if(querycondition[1].equals("124213")){
                csb.setCockNo("");
            }else {
                csb.setCockNo(querycondition[1]);
            }
            csb.setFarmID(SharedPreferencesUtils.getInt(context,Constants.FARMIDLOGIN,0));

            //设置regdate 的level
            if(querycondition[3].equals("1")){
                csb.setLevel(1);
            }else if(querycondition[3].equals("2")){
                csb.setLevel(2);
            }else if(querycondition[3].equals("3")){
                csb.setLevel(3);
            }else csb.setLevel(0);

            csb.setOrgID(0);
            csb.setIsImport("");
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            String content = gson.toJson(csb);
            String requl = Constants.QUERY_COCK_URL;
            requl = GetJson.replace(requl, "{strQuery}", content);
            cockSearchResultBean = OkhttpPlusUtil.getInstance().get(requl, CockSearchResultBean.class);

        }


        class SpaceItemDecoration extends XRecyclerView.ItemDecoration {
            int space;

            public SpaceItemDecoration(int space) {
                this.space = space;
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                //每一个一个的格子都设一个左边和底部的间距
                outRect.bottom = space * 4;
                outRect.left = 0;
                //由于每行都只有2个，所以第一个都是2的倍数，把左边距设为0
                if (parent.getChildLayoutPosition(view) % 2 == 0) {
                    outRect.right = 0;
                }
            }
        }
    }
}
