package com.biotag.cockowner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biotag.cockowner.JavaBean.DerbyOptionBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.customview.MyLinearLayout;
import com.biotag.cockowner.customview.SmoothCheckBox;
import com.biotag.cockowner.interfaces.RcvOnItemClickListener;

import java.util.ArrayList;

/**
 * Created by Lxh on 2017/11/27.
 */

public class DerbyOptionsAdapter extends RecyclerView.Adapter<DerbyOptionsAdapter.DerbyOptionViewHolder> {
    private ArrayList<DerbyOptionBean> derbyOptionBeanslist;
    private Context context;
    private RcvOnItemClickListener rcvOnItemClickListener;

    public void setRcvOnItemClickListener(RcvOnItemClickListener rcvOnItemClickListener) {
        this.rcvOnItemClickListener = rcvOnItemClickListener;
    }

    public DerbyOptionsAdapter(ArrayList<DerbyOptionBean> derbyOptionBeanslist, Context context) {
        this.derbyOptionBeanslist = derbyOptionBeanslist;
        this.context = context;
    }

    @Override
    public DerbyOptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_derby_list_options_item,parent,false);
        return new DerbyOptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DerbyOptionViewHolder holder, final int position) {
        holder.tv.setText(derbyOptionBeanslist.get(position).getDerbyoption());

        holder.mll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rcvOnItemClickListener!=null){
                    rcvOnItemClickListener.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return derbyOptionBeanslist.size();
    }

    class DerbyOptionViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        SmoothCheckBox scb;
        MyLinearLayout mll;
        DerbyOptionViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            scb = itemView.findViewById(R.id.scb);
            mll = itemView.findViewById(R.id.ll_derbyoption);
        }
    }
}
