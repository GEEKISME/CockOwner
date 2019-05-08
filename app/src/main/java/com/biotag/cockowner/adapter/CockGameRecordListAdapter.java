package com.biotag.cockowner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biotag.cockowner.JavaBean.CockGameRecordResultBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customview.MyTextView;
import com.biotag.cockowner.interfaces.RcvOnGameRecordItemClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * Created by Lxh on 2017/8/24.
 */

public class CockGameRecordListAdapter extends XRecyclerView.Adapter<CockGameRecordListAdapter
        .CockGameRecordItemHolder> {
    private ArrayList<CockGameRecordResultBean.ValuesBean> cockGameRecordList = null;
    private Context context;
//    private RadioButton wincockRadiobutton;
    private String wincocktag = "1", wincockchipcode;
//    private InputCockGameResultResultBean icgBean = null;
    private CockGameRecordResultBean.ValuesBean vb = null;
    private RcvOnGameRecordItemClickListener rcvOnGameRecordItemClickListener;

    public void setRcvOnGameRecordItemClickListener(RcvOnGameRecordItemClickListener rcvOnGameRecordItemClickListener) {
        this.rcvOnGameRecordItemClickListener = rcvOnGameRecordItemClickListener;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //    public interface ShowToast{
    //        void showToastBySignal(int signal);
    //    }
    //    private ShowToast showToast;
    //
    //    public void setShowToast(ShowToast showToast) {
    //        this.showToast = showToast;
    //    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public CockGameRecordListAdapter(ArrayList<CockGameRecordResultBean.ValuesBean> cockGameRecordList, Context
            context) {
        this.cockGameRecordList = cockGameRecordList;
        this.context = context;
    }


    //    private Handler handler = new Handler(){
    //        @Override
    //        public void handleMessage(Message msg) {
    //            switch (msg.what){
    //                case 1:
    //                    if(wincockchipcode.equals(vb.getCock_chip1())){
    //                        holder.radiobtn_2.setVisibility(View.GONE);
    //                    }else {
    //                        holder.radiobtn_1.setVisibility(View.GONE);
    //                    }
    //                    Toast.makeText(context, GetAttrString.getGameResultUploadSucc(), Toast.LENGTH_SHORT).show();
    //                    break;
    //                case 0:
    //                    Toast.makeText(context,GetAttrString.getGameResultUploadFail(),Toast.LENGTH_SHORT).show();
    //                    break;
    //            }
    //        }
    //    };


    @Override
    public CockGameRecordItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cockgamerecorditem, parent, false);
        return new CockGameRecordItemHolder(v);
    }

    @Override
    public void onBindViewHolder(final CockGameRecordItemHolder holder, final int position) {
        holder.metal1.setVisibility(View.GONE);
        holder.metal2.setVisibility(View.GONE);
        vb = cockGameRecordList.get(position);
        wincockchipcode = vb.getCock_chip1();//首先默认赢得比赛的斗鸡是chip1, 等checkchange改变时在改变这个值，有默认值可以防止空指针
        holder.tv_createby.setText(GetAttrString.getGames_createat());
//        holder.tv_orgname.setText(GetAttrString.getOrganization_orgname());
        holder.tv_resulttime.setText(GetAttrString.getGames_resulttime());
        //        holder.tv_wincock.setText(GetAttrString.getGames_wincock());
//        holder.tv_wincock1.setText(GetAttrString.getGames_wincock());
        holder.tv_chip1.setText(GetAttrString.getCockA());
        holder.tv_chip2.setText(GetAttrString.getCockB());
        holder.radiobtn_1.setText("A");
        holder.radiobtn_2.setText("B");

        holder.tv_chip1_vlaue.setText(vb.getCock_chip1());
        holder.tv_chip2_vlaue.setText(vb.getCock_chip2());
        //======字符串截取操作
        String s = vb.getCreateAt();
        String a[] = s.split("T");
        StringBuilder sb = new StringBuilder();
        sb.append(a[0]);
        s = a[1];
        String b[] = s.split(":");
        for (int i = 1; i < 10; i++) {
            if (b[0].equals("0" + i)) {
                b[0].substring(1);
            }
        }
        sb.append("  ").append(b[0]).append(":").append(b[1]);
        holder.tv_createby_value.setText(sb.toString());
        //========字符串截取操作
        if (vb.getWin_cock() != null && vb.getWin_cock().trim().length() > 0) {
            if (vb.getWin_cock().equals(vb.getCock_chip1())) {
                holder.metal1.setVisibility(View.VISIBLE);
            } else {
                holder.metal2.setVisibility(View.VISIBLE);
            }
            holder.btn_postwincock.setVisibility(View.GONE);
            holder.rl_wincock_choose.setVisibility(View.GONE);
            holder.aline_wincock.setVisibility(View.GONE);
            holder.rl_resulttime.setVisibility(View.VISIBLE);
            holder.aline_gameresult.setVisibility(View.GONE);
            holder.ll_cardview.setBackgroundResource(R.color.lightyellow);
            //=============================
            String k = (String) vb.getResult_time();
            String c[] = k.split("T");
            StringBuilder sbr = new StringBuilder();
            sbr.append(c[0]);
            k = c[1];
            String d[] = k.split(":");
            sbr.append("  ").append(d[0]).append(":").append(d[1]);
            holder.tv_resulttime_vlaue.setText(sbr.toString());
            //====
            holder.rl_wincock_choose.setVisibility(View.VISIBLE);
            holder.aline_wincock.setVisibility(View.VISIBLE);
            holder.tv_wincock1_value.setText(vb.getWin_cock().trim());

        } else {
            //            holder.rl_wrapall.setVisibility(View.GONE);
            //            holder.ll_cardview.setVisibility(View.GONE);

            //            holder.btn_postwincock.setVisibility(View.VISIBLE);
            holder.tv_wincock1_value.setText("Undetermined");
            holder.rl_orgname.setVisibility(View.GONE);
            holder.aline_orgname.setVisibility(View.GONE);
            holder.rl_wincock_choose.setVisibility(View.VISIBLE);
            holder.aline_wincock.setVisibility(View.VISIBLE);
            holder.rl_resulttime.setVisibility(View.GONE);
            holder.aline_gameresult.setVisibility(View.GONE);
            holder.btn_postwincock.setVisibility(View.GONE);
            holder.ll_cardview.setBackgroundResource(R.color.light);
        }

        //=========================
        holder.tv_orgname_vlaue.setText(vb.getOrgName());
        holder.tv_creatoruser.setText(GetAttrString.getGames_creatoruser());
        holder.tv_creatoruser_value.setText(vb.getCreator_name());
        //选择哪只斗鸡是win
        holder.rg_wincock.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == holder.radiobtn_2.getId()) {
                    RadioButton rb = group.findViewById(checkedId);
                    rb.setChecked(true);
                    wincocktag = (String) rb.getTag();
                    wincockchipcode = vb.getCock_chip2();
                    holder.radiobtn_1.setChecked(false);

                } else {
                    wincocktag = "1";
                    wincockchipcode = vb.getCock_chip1();
                }
                Log.i(Constants.TAG, "now the tag is " + wincocktag);
            }
        });

        //        if(wincocktag.equals("1")){
        //            wincockchipcode = vb.getCock_chip1();
        //        }else if(wincocktag.equals("2")){
        //            wincockchipcode = vb.getCock_chip2();
        //        }
        holder.btn_postwincock.setOnClickListener(new View.OnClickListener() {
//            AlertDialog ab = null;

            @Override
            public void onClick(View v) {

                if (rcvOnGameRecordItemClickListener != null) {
                    rcvOnGameRecordItemClickListener.onGameRecordItemClickListener(holder, position);
                }

//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("");
//                if (wincocktag.equals("1")) {
//                    builder.setMessage(GetAttrString.getCockA() + " : " + GetAttrString.getSetWinCock());
//                    Log.i(Constants.TAG, "xianzai wincock" + vb.getCock_chip1());
//                } else if (wincocktag.equals("2")) {
//                    builder.setMessage(GetAttrString.getCockB() + " : " + GetAttrString.getSetWinCock());
//                    Log.i(Constants.TAG, "xianzai wincock" + vb.getCock_chip2());
//                }
//                builder.setPositiveButton(GetAttrString.getBasic_confirm(), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        ThreadManager.getInstance().execute(new Runnable() {
//                            @Override
//                            public void run() {
//                                InputCockGameResultBean cgrb = new InputCockGameResultBean();
//                                cgrb.setId(vb.getId());
//                                cgrb.setCock_chip1(vb.getCock_chip1());
//                                cgrb.setCock_chip2(vb.getCock_chip2());
//                                if (wincocktag.equals("1")) {
//                                    cgrb.setWin_cock(vb.getCock_chip1());
//                                    wincockchipcode = vb.getCock_chip1();
//                                } else if (wincocktag.equals("2")) {
//                                    cgrb.setWin_cock(vb.getCock_chip2());
//                                    wincockchipcode = vb.getCock_chip2();
//                                }
//                                Log.i(Constants.TAG, "set de wincock is " + wincockchipcode);
//                                cgrb.setCreateAt(vb.getCreateAt());
//                                String requl = Constants.SET_WINCOCK_URL;
//                                String content = new Gson().toJson(cgrb);
//                                Log.i(Constants.TAG, content);
//                                icgBean = OkhttpPlusUtil.getInstance().post(requl, content,
//                                        InputCockGameResultResultBean.class);
//                                if (icgBean.isIsSuccess()) {
//                                    handler.sendEmptyMessage(1);
//                                } else {
//                                    handler.sendEmptyMessage(0);
//                                }
//                            }
//                        });
//                    }
//                });
//                builder.setNegativeButton(GetAttrString.getBasic_cancel(), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        ab.dismiss();
//                    }
//                });
//                ab = builder.create();
//                ab.show();
            }
        });
        //        holder.cardView.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                if(vb.getWin_cock()==null||vb.getWin_cock().equals("")){
        //                    Intent intent = new Intent(UIUtils.getContext(), InputGameResultActivity.class);
        //                    Bundle bundle = new Bundle();
        //                    bundle.putInt("id",vb.getId());
        //                    bundle.putString("cock_chip1",vb.getCock_chip1());
        //                    bundle.putString("cock_chip2",vb.getCock_chip2());
        //                    bundle.putInt("org_id",vb.getOrg_id());
        //                    bundle.putInt("createUser",vb.getCreateUser());
        //                    bundle.putString("createAt",vb.getCreateAt());
        //                    bundle.putString("OrgName",vb.getOrgName());
        //                    bundle.putString("creator_name",vb.getCreator_name());
        //                    intent.putExtras(bundle);
        //                    context.startActivity(intent);
        //                }
        //            }
        //        });
    }

    @Override
    public int getItemCount() {
        return cockGameRecordList.size();
    }

    public class CockGameRecordItemHolder extends RecyclerView.ViewHolder {
        RelativeLayout rl_wrapall;
//        CardView cardView;
        RelativeLayout rl_chip1, rl_chip2, rl_resulttime, rl_orgname, rl_createby,
                rl_wincock_choose, rl_creatorUser;
        TextView tv_chip1, tv_chip2, tv_resulttime, tv_orgname,
                tv_createby, tv_wincock1, tv_creatoruser;
        TextView tv_chip1_vlaue, tv_chip2_vlaue, tv_resulttime_vlaue, tv_createby_value, tv_creatoruser_value,tv_wincock1_value;
        MyTextView tv_orgname_vlaue;
        View aline_wincock, aline_gameresult,aline_orgname;
        public Button btn_postwincock;
        public RadioButton radiobtn_1;
        public RadioButton radiobtn_2;
        public RadioGroup rg_wincock;
        ImageView metal1, metal2;
        LinearLayout ll_cardview;

        public CockGameRecordItemHolder(View itemView) {
            super(itemView);

            tv_wincock1_value = itemView.findViewById(R.id.tv_wincock1_value);
            ll_cardview = itemView.findViewById(R.id.ll_cardview);
            metal1 = itemView.findViewById(R.id.metal1);
            metal2 = itemView.findViewById(R.id.metal2);
            aline_wincock = itemView.findViewById(R.id.aline_wincock);
            aline_gameresult = itemView.findViewById(R.id.aline_gameresult);
            aline_orgname = itemView.findViewById(R.id.aline_orgname);
            btn_postwincock = itemView.findViewById(R.id.btn_postwincock);
            rg_wincock = itemView.findViewById(R.id.rg_wincock);
            //===================================================================
            rl_createby = itemView.findViewById(R.id.rl_createby);
            rl_wrapall = itemView.findViewById(R.id.rl_wrapall);
            //            cardView = (CardView)itemView.findViewById(R.id.cardview);
            rl_chip1 = itemView.findViewById(R.id.rl_chip1);
            rl_chip2 = itemView.findViewById(R.id.rl_chip2);
            rl_resulttime = itemView.findViewById(R.id.rl_resulttime);
            rl_orgname = itemView.findViewById(R.id.rl_orgname);
            rl_wincock_choose = itemView.findViewById(R.id.rl_wincock_choose);
            rl_creatorUser = itemView.findViewById(R.id.rl_creatorUser);
            //================================================================================
            tv_chip1 = itemView.findViewById(R.id.tv_chip1);
            tv_chip2 = itemView.findViewById(R.id.tv_chip2);
            tv_wincock1 = itemView.findViewById(R.id.tv_wincock1);
            tv_resulttime = itemView.findViewById(R.id.tv_resulttime);
            tv_orgname = itemView.findViewById(R.id.tv_orgname);
            tv_creatoruser = itemView.findViewById(R.id.tv_creatoruser);
            tv_createby = itemView.findViewById(R.id.tv_createby);
            tv_creatoruser_value = itemView.findViewById(R.id.tv_creatoruser_value);
            //================================================================================
            tv_chip1_vlaue = itemView.findViewById(R.id.tv_chip1_value);
            tv_chip2_vlaue = itemView.findViewById(R.id.tv_chip2_value);
            tv_resulttime_vlaue = itemView.findViewById(R.id.tv_resulttime_value);
            tv_orgname_vlaue = itemView.findViewById(R.id.tv_orgname_value);
            tv_createby_value = itemView.findViewById(R.id.tv_createby_value);
            //=====================
            radiobtn_1 = itemView.findViewById(R.id.radiobtn_1);
            radiobtn_2 = itemView.findViewById(R.id.radiobtn_2);
        }
    }


}
