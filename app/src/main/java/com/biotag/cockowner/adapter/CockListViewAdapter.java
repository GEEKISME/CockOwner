package com.biotag.cockowner.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.JavaBean.CockSearchResultBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.activity.CockDetailActivity;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.utils.GetJson;
import com.biotag.cockowner.utils.PicassoUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * Created by Lxh on 2017/8/9.
 */

public class CockListViewAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private static final int ITEM_LEFT = 0;
    private static final int ITEM_RIGHT = 1;

    private ArrayList<CockSearchResultBean.ValuesBean> cockSearchResultList = new ArrayList<>();
    private Context context ;
    private Activity activity;

    public CockListViewAdapter(ArrayList<CockSearchResultBean.ValuesBean> cockSearchResultList, Context context,Activity activity) {
        this.cockSearchResultList = cockSearchResultList;
        this.context = context ;
        this.activity = activity;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return ITEM_LEFT;
        } else {
            return ITEM_RIGHT;
        }
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        XRecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case ITEM_LEFT:
                holder = new CockItemHolder(LayoutInflater.from(context).inflate(R.layout.fragment_discovery_cmv,
                        parent, false));
                break;
            case ITEM_RIGHT:
                holder = new CockItemHolder(LayoutInflater.from(context).inflate(R.layout
                        .fragment_discovery_cmv_left, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        CockItemHolder holder1 = (CockItemHolder) holder;
        final CockSearchResultBean.ValuesBean vb = cockSearchResultList.get(position);
        holder1.tv_chipnumber.setText(GetAttrString.getCock_ChipCode() + ":" + vb.getChipCode());
        holder1.tv_serialnumber.setText(GetAttrString.getCock_no() + ":" + vb.getCockNo());
        holder1.rl_cockinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CockDetailActivity.class);
                intent.putExtra("cockid", vb.getID());
                context.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_in_form_right,R.anim.activity_out_to_left);
            }
        });
        String requl = Constants.COCKIMG_URL;
        requl = GetJson.replace(requl, "{chipcode}", vb.getChipCode());
        String[] tem = vb.getCreateAt().split("T");
        String[] tem1 = tem[0].split("-");
        String s = tem1[0] + tem1[1] + tem1[2];
        requl = GetJson.replace(requl, "{20170907}", s);
        requl = GetJson.replace(requl, "{skin}", "skin");
        PicassoUtil.getInstance().loadImage(context, requl, holder1.iv_cockimg);

        //        String requls = Constants.COCKIMGSECONDVERSION_URL;
        //        String date = vb.getBirth();
        //        String[] dates = date.split("-");
        //        StringBuffer sb = new StringBuffer();
        //        date = sb.append(dates[2]).append(dates[0]).append(dates[1]).toString();
        //        requls = GetJson.replace(requls,"{20170907}",date);
        //        requls = GetJson.replace(requls,"{skin}","skin");
        //        requls = GetJson.replace(requls,"{chipcode}",vb.getChipCode());
        //        Log.i(Constants.TAG,"图片的地址是"+requls);
        //        PicassoUtil.getInstance().loadImage(context,requls,holder1.iv_cockimg);

    }

    @Override
    public int getItemCount() {
        return cockSearchResultList.size();
    }

    class CockItemHolder extends XRecyclerView.ViewHolder {
        ImageView iv_cockimg;
        TextView tv_serialnumber;
        TextView tv_chipnumber;
        RelativeLayout rl_cockinfo;

        CockItemHolder(View itemView) {
            super(itemView);
            iv_cockimg = itemView.findViewById(R.id.cockImg);
            tv_serialnumber = itemView.findViewById(R.id.tv_serialnumber);
            tv_chipnumber = itemView.findViewById(R.id.tv_chipnumber);
            rl_cockinfo = itemView.findViewById(R.id.rl_cockinfo);
        }
    }

}
