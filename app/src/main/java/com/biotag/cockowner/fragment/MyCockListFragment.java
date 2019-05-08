package com.biotag.cockowner.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.biotag.cockowner.activity.RecordCockInfoPartOneActivity;
import com.biotag.cockowner.adapter.CockListViewAdapter;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customview.CommonLoadingPager;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.GetJson;
import com.biotag.cockowner.utils.MobclickAgentWrapper;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.biotag.cockowner.utils.UIUtils;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Lxh on 2017/8/9.
 */

public class MyCockListFragment extends BaseFragment {



    public static MyCockListFragment newInstance() {
        Bundle args = new Bundle();
        MyCockListFragment fragment = new MyCockListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private MyCockListView contentview;

    static class MyCockListHandler extends Handler{
        private WeakReference<MyCockListFragment> myCockListFragmentWeakReference;
        public MyCockListHandler(MyCockListFragment myCockListFragment){
            myCockListFragmentWeakReference = new WeakReference<MyCockListFragment>(myCockListFragment);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MyCockListFragment myCockListFragment = myCockListFragmentWeakReference.get();
            if(myCockListFragment!=null){
                if(msg.what == 0){
                    Log.i(Constants.TAG,"the message from handler has been received ,prepare to refresh adapter ");
                    if(myCockListFragment.contentview.cockListViewAdapter!=null){
                        myCockListFragment.contentview.cockListViewAdapter.notifyDataSetChanged();
                        Log.i(Constants.TAG,"the adapter has been refreshed");
                    }
                }
            }
        }
    }

    private MyCockListHandler handler = new MyCockListHandler(MyCockListFragment.this);

//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            if(msg.what == 0){
//                Log.i(Constants.TAG,"收到了handler的消息，准备刷新适配器");
//                if(contentview.cockListViewAdapter!=null){
//                    contentview.cockListViewAdapter.notifyDataSetChanged();
//                    Log.i(Constants.TAG,"适配器已经刷新了");
//                }
//            }
//        }
//    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        Log.i(Constants.TAG,"eventbus has been registered");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentview = new MyCockListView(getContext());
        contentview.show();
        return contentview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//        Log.i(Constants.TAG,"注销了eventbus");
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventMainThread(String event){
        if(event.equals("refreshcocklist")){
            Log.i(Constants.TAG,"eventbus has received the message that addition of a new cock");
            Log.i(Constants.TAG,"cock list's size before inserting operation  "+contentview.cockSearchResultList.size());
            if(contentview.getCurrentState()==4){
                contentview.setIndex(1);
                contentview.show();
            }else {
                /**
                 * 刷新数据
                 * 从page=1重新获取10条数据
                 * 数据获取成功后 重置page参数
                 */
                CockSearchBean csb = new CockSearchBean();
                csb.setOwnerID(SharedPreferencesUtils.getInt(getContext(),Constants.ID,-1));
                csb.setPageSize(10);
                csb.setcStatus((byte)1);
                csb.setBreedID(1);
                csb.setChipCode("");
                csb.setCockNo("");
                csb.setCurrIndex(1);//重新从index=1 开始取数据
                csb.setIsImport("");
                csb.setFarmID(SharedPreferencesUtils.getInt(UIUtils.getContext(),Constants.FARMIDLOGIN,0));
                csb.setOrgID(0);
                String content = new Gson().toJson(csb);
                String requl = Constants.QUERY_COCK_URL;
                requl = GetJson.replace(requl,"{strQuery}",content);
                contentview.cockSearchResultBean = OkhttpPlusUtil.getInstance().get(requl,CockSearchResultBean.class);
                if(contentview.cockSearchResultBean!=null&&contentview.cockSearchResultBean.getValues().size()>0){
                    contentview.setIndex(2);
                    contentview.cockSearchResultList.clear();
                    contentview.cockSearchResultList.addAll(0,contentview.cockSearchResultBean.getValues());
                    Message message = Message.obtain();
                    message.what = 0;
                    handler.sendMessage(message);
                    Log.i(Constants.TAG,"the operation of acquiring data successed，handler send the message ");
                }


            }
        }
    }

    class MyCockListView extends CommonLoadingPager {
        private int index = 1 ;
        private Context context;
        private RelativeLayout rl_additem,rl_additems;
        private XRecyclerView xrcv;
        private CockListViewAdapter cockListViewAdapter;
        private CockSearchResultBean cockSearchResultBean;
        private ArrayList<CockSearchResultBean.ValuesBean> cockSearchResultList = new ArrayList<>();


        public void setIndex(int index) {
            this.index = index;
        }

        public int getCurrentState() {
            return mState;
        }


        public MyCockListView(Context context) {
            super(context);
            this.context = context;
        }

        @Override
        protected View createEmptyView() {
            View emptyView = UIUtils.inflate(R.layout.empty);
            mTvHint = (TextView)emptyView.findViewById(R.id.tv_hint);
            rl_additems = (RelativeLayout)emptyView.findViewById(R.id.rl_additems);
            mTvHint.setText(GetAttrString.getNocockInYourname());
            rl_additems.setVisibility(VISIBLE);
            rl_additems.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), RecordCockInfoPartOneActivity.class);
                    startActivity(intent);
//                    getActivity().overridePendingTransition(R.anim.activity_in_from_down,R.anim.activity_out_from_up);
//                    getActivity().overridePendingTransition(R.anim.activity_in_from_down,0);
                }
            });
            return emptyView;
        }

        @Override
        public View createSuccessView() {
            RelativeLayout rootview = new RelativeLayout(getContext());
            rootview.setBackgroundColor(UIUtils.getColor(R.color.white));
            View myCockListview = UIUtils.inflate(R.layout.mycock_listview);
            xrcv = (XRecyclerView) myCockListview.findViewById(R.id.xrcv_refresh);
            rl_additem = (RelativeLayout) myCockListview.findViewById(R.id.rl_additem);
            //==================================================================================
            //==判断是否是个人鸡主还是养殖场用户
//            boolean isPerson = SharedPreferencesUtils.getBoolean(context, Constants.ISPERSONAL, false);
//            if (isPerson) {
//                rl_additem.setVisibility(VISIBLE);
//            }else{
//                rl_additem.setVisibility(VISIBLE);
//            }
            rl_additem.setVisibility(VISIBLE);

            //====================================================================================
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            rootview.addView(myCockListview, lp);
            rl_additem.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    MobclickAgentWrapper.onEvent(context,"addcockbtn click");
                    Intent intent = new Intent(getContext(), RecordCockInfoPartOneActivity.class);
                    startActivity(intent);
//                    getActivity().overridePendingTransition(R.anim.activity_in_from_down,R.anim.activity_out_from_up);
//                    getActivity().overridePendingTransition(R.anim.activity_in_from_down,0);

                }
            });
            xrcv.setLayoutManager(new GridLayoutManager(getContext(), 2));
            int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dimen_5);
            xrcv.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
            xrcv.setPullRefreshEnabled(false);
            xrcv.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    xrcv.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    ThreadManager.getInstance().execute(new Runnable() {
                        private boolean isLoadMore = false;
                        @Override
                        public void run() {
                            initgetdata();
                            if(cockSearchResultBean!=null&&cockSearchResultBean.getValues().size()>0){
                                cockSearchResultList.addAll(cockSearchResultBean.getValues());
                                isLoadMore = true;
                                Log.i(Constants.TAG,cockSearchResultList.size()+"");
                            }
                            UIUtils.post(new Runnable() {
                                @Override
                                public void run() {
                                    xrcv.refreshComplete();
                                    if(isLoadMore){
                                        cockListViewAdapter.notifyDataSetChanged();
                                    }
                                }
                            });
                            UIUtils.post(new Runnable() {
                                @Override
                                public void run() {
                                    xrcv.loadMoreComplete(false);
                                }
                            });
                        }
                    });
                }
            });
            cockListViewAdapter = new CockListViewAdapter(cockSearchResultList, context, getActivity());
            xrcv.setAdapter(cockListViewAdapter);
            return rootview;
        }

        @Override
        public LoadResult load() {
            try {
                initgetdata();
                if(cockSearchResultBean==null){
                    return check(cockSearchResultBean);
                }else if(cockSearchResultBean!=null){
                    cockSearchResultList.addAll(cockSearchResultBean.getValues());
                    return check(cockSearchResultList);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return LoadResult.STATE_ERROR;
        }

        private void initgetdata() {
//            try {
//                Thread.sleep(3000);//loading 页面总算是出来了
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            CockSearchBean csb = new CockSearchBean();
            boolean isPersonl = SharedPreferencesUtils.getBoolean(context,Constants.ISPERSONAL,false);
            if(isPersonl){
                csb.setOwnerID(SharedPreferencesUtils.getInt(context,Constants.ID,-1));
            }
            csb.setCurrIndex(index);
            csb.setPageSize(10);
            csb.setBreedID(0);
            csb.setcStatus((byte) 0);
            csb.setChipCode("");
            csb.setCockNo("");
            csb.setFarmID(SharedPreferencesUtils.getInt(context,Constants.FARMIDLOGIN,0));
            csb.setLevel(0);
            csb.setOrgID(0);
            csb.setIsImport("");
            String content = new Gson().toJson(csb);
            String requl = Constants.QUERY_COCK_URL;
            requl = GetJson.replace(requl, "{strQuery}", content);
            cockSearchResultBean = OkhttpPlusUtil.getInstance().get(requl, CockSearchResultBean.class);
            index++;
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
