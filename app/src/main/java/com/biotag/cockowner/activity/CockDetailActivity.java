package com.biotag.cockowner.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.biotag.cockowner.JavaBean.AllOrgBean;
import com.biotag.cockowner.JavaBean.CockDetailInfoBean;
import com.biotag.cockowner.JavaBean.FixCockRegDateResultBean;
import com.biotag.cockowner.JavaBean.FixCockStatusResultBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.adapter.ViewPagerAdapter;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customdialog.RxDialogEditSureCancel;
import com.biotag.cockowner.customdialog.RxDialogSureCancel;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.customview.PinchImageView;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.GetJson;
import com.biotag.cockowner.utils.MobclickAgentWrapper;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.biotag.cockowner.utils.PicassoUtil;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.michael.easydialog.EasyDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class CockDetailActivity extends UserBaseActivity {

    private LinearLayout rl_refresh;
    private Context context = CockDetailActivity.this;
    private CockDetailInfoBean cockDetailInfoBean = null;
    private CockDetailInfoBean.ValuesBean valueBean = null;
    private FixCockStatusResultBean fixCockStatusResultBean = null;
    private FixCockStatusResultBean fixCockDerbyResultBean = null;
    private FixCockRegDateResultBean fixCockRegDateResultBean = null;
    private FixCockRegDateResultBean fixCockWeightResultBean = null;
    private RelativeLayout rl_weight, rl_wrapviewpager,rl_orgname,rl_cockowner_record,rl_breedName,basicInfo,rl_importerid,rl_cockstatustwooftime,rl_cockstatusthreeoftime,rl_memo,rl_associationid,rl_chipnumber_record,rl_serialnumber_record,rl_cockstatusoneoftime;
    private TextView tv_weight_revu,tv_dictName_revu, tv_breedName_revu,tv_cockowner_revu,tv_orgname_revu, tv_associationid_revu,tv_importerid_revu,tv_isforeigncock_revu,tv_farmname_revu,tv_cockstatusthreeoftime_revu,tv_cockstatustwooftime_revu,tv_creatAt_revu,tv_cockstatusoneoftime_revu,tv_chipnumber_revu,tv_serialnumber_revu,tv_memo_revu,tv_birthday_revu,tv_cockstatus_revu;
    private ProgressBar mProgressbar;
    private String selectStatus, selectRegDate, mainfederation, federation, breedname, chipcode, selectderby;
    private ImageView arrow_importer1, arrow_importer2, arrow_importer3;
    private int id; //传递过来的斗鸡的iD
    private ViewPager viewpager;
    private RadioGroup rg_iv;
    private RadioButton rb_1;


    //====
    private ArrayList<ImageView> ivList = new ArrayList<>();
    private ArrayList<String> motherOrg = new ArrayList<>();
    private ArrayList<Integer> motherid = new ArrayList<>();
    private ArrayList<String> sonOrg = new ArrayList<>();
    private ArrayList<Integer> sonOrgid = new ArrayList<>();
    private ArrayList<String> sonOrgs = new ArrayList<>();
    private ArrayList<Integer> sonOrgsid = new ArrayList<>();
    private AllOrgBean allOrgBean = null;
    private int i = 0;
    private ArrayList<String> contestList = new ArrayList<>();
    private ArrayList<Integer> contestIdList = new ArrayList<>();
    private SweetAlertDialog sweetAlertDialog;
    private int derbyidselected = -1;


    static class CockHandler extends Handler {
        private WeakReference<CockDetailActivity> cockDetailActivityWeakReference;

        public CockHandler(CockDetailActivity cockDetailActivity) {
            cockDetailActivityWeakReference = new WeakReference<CockDetailActivity>(cockDetailActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            CockDetailActivity cockDetailActivity = cockDetailActivityWeakReference.get();
            if (cockDetailActivity != null) {
                switch (msg.what) {
                    case Constants.GET_ALLORG:
                        Log.i(Constants.TAG, "the org has been acquired,start to acquire data");
                        for (int i = 0; i < cockDetailActivity.allOrgBean.getValues().size(); i++) {
                            AllOrgBean.ValuesBean vb = cockDetailActivity.allOrgBean.getValues().get(i);
                            if (vb.getParentID() == 0) {
                                cockDetailActivity.motherOrg.add(vb.getOrgName());
                                cockDetailActivity.motherid.add(vb.getId());
                            } else {
                                if (vb.getParentID() == 2) {
                                    cockDetailActivity.sonOrg.add(vb.getOrgName());
                                    cockDetailActivity.sonOrgid.add(vb.getId());
                                } else {
                                    cockDetailActivity.sonOrgs.add(vb.getOrgName());
                                    cockDetailActivity.sonOrgsid.add(vb.getId());
                                }
                            }
                        }
                        cockDetailActivity.initdata();
                        break;
                    case Constants.GETDATA_SUCCESS:
                        cockDetailActivity.valueBean = cockDetailActivity.cockDetailInfoBean.getValues();
                        cockDetailActivity.setLayout();
                        cockDetailActivity.showLoading(false);
                        if(cockDetailActivity.rl_refresh.getVisibility()==View.VISIBLE){
                            cockDetailActivity.rl_refresh.setVisibility(View.GONE);
                        }
                        break;
                    case Constants.SUCCESS_FIX_COCK_DERBY:
                        cockDetailActivity.tv_serialnumber_revu.setText(cockDetailActivity.selectderby);
                        //                        cockDetailActivity.right_arrow_derbyentry.setVisibility(View
                        // .INVISIBLE);
                        //                        cockDetailActivity.rl_serialnumber_record.setClickable(false);
                        MobclickAgentWrapper.onEvent(cockDetailActivity, "cockderby change suc");
                        //                        Toast.makeText(cockDetailActivity, "Derby Setting Successful!",
                        // Toast.LENGTH_SHORT).show();
                        RxToast.success(cockDetailActivity, cockDetailActivity.getResources().getString(R.string.operationsucceed), Toast.LENGTH_SHORT, true).show();

                        break;
                    case Constants.FAIL_FIX_COCK_DERBY:
                        //                        Toast.makeText(cockDetailActivity, "Derby Setting fail!", Toast
                        // .LENGTH_SHORT).show();
                        RxToast.error(cockDetailActivity, cockDetailActivity.getResources().getString(R.string.operationfailed), Toast.LENGTH_SHORT, true).show();

                        break;
                    case Constants.GETDATA_FAIL:
                        cockDetailActivity.showLoading(false);
                        cockDetailActivity.basicInfo.setVisibility(View.GONE);
                        cockDetailActivity.rl_serialnumber_record.setClickable(false);
                        cockDetailActivity.rl_refresh.setVisibility(View.VISIBLE);
                        break;
                    case Constants.SUCCESS_FIX_COCK_STATUS:
                        //                        Toast.makeText(cockDetailActivity, GetAttrString
                        // .getDB_PROC_cocks_update_status_msg_0(),
                        //                                Toast.LENGTH_SHORT).show();
                        RxToast.success(cockDetailActivity, cockDetailActivity.getResources().getString(R.string.operationsucceed), Toast.LENGTH_SHORT, true).show();


                        cockDetailActivity.tv_cockstatus_revu.setText(cockDetailActivity.selectStatus);
                        break;
                    case Constants.FAIL_FIX_COCK_STATUS:
                        //                        Toast.makeText(cockDetailActivity, GetAttrString
                        // .getDB_PROC_cocks_update_status_msg_2(),
                        //                                Toast.LENGTH_SHORT).show();
                        RxToast.error(cockDetailActivity, cockDetailActivity.getResources().getString(R.string.operationfailed), Toast.LENGTH_SHORT, true).show();


                        break;
                    case Constants.SUCCESS_FIX_COCK_WEIGHT:
                        String cockweight = msg.getData().getString("cockweight");
                        cockDetailActivity.tv_weight_revu.setText(cockweight+" kg");
                        RxToast.success(cockDetailActivity,cockDetailActivity.getResources().getString(R.string.operationsucceed), Toast.LENGTH_SHORT, true).show();
                        break;
                    case Constants.NEED_DOWNLOAD_APK:
                        RxToast.error(cockDetailActivity, cockDetailActivity.getResources().getString(R.string.operationfailed), Toast.LENGTH_SHORT, true).show();
                        break;
                    case Constants.SUCCESS_FIX_COCK_REGDATE_ONE:
                        String lvSelect = msg.getData().getString("lvSelect");
                        assert lvSelect != null;
                        switch (lvSelect) {
                            case "1st":
                                cockDetailActivity.tv_cockstatusoneoftime_revu.setText(lvSelect);
                                cockDetailActivity.arrow_importer1.setVisibility(View.INVISIBLE);
                                cockDetailActivity.rl_cockstatusoneoftime.setClickable(false);
                                break;
                            case "2nd":
                                cockDetailActivity.tv_cockstatustwooftime_revu.setText(lvSelect);
                                cockDetailActivity.arrow_importer2.setVisibility(View.INVISIBLE);
                                cockDetailActivity.rl_cockstatustwooftime.setClickable(false);
                                break;
                            case "3rd":
                                cockDetailActivity.tv_cockstatusthreeoftime_revu.setText(lvSelect);
                                cockDetailActivity.arrow_importer3.setVisibility(View.INVISIBLE);
                                cockDetailActivity.rl_cockstatusthreeoftime.setClickable(false);
                                break;
                        }
                        //                        Toast.makeText(cockDetailActivity, cockDetailActivity.getResources
                        // ().getString(R.string
                        //                                .operationsucceed), Toast.LENGTH_SHORT).show();
                        RxToast.success(cockDetailActivity, cockDetailActivity.getResources().getString(R.string.operationsucceed), Toast.LENGTH_SHORT, true).show();

                        break;
                    case Constants.FAIL_FIX_COCK_REGDATE_ONE:
                        //                        Toast.makeText(cockDetailActivity, cockDetailActivity.getResources
                        // ().getString(R.string
                        //                                .operationfailed), Toast.LENGTH_SHORT).show();
                        RxToast.error(cockDetailActivity, cockDetailActivity.getResources().getString(R.string
                                .operationfailed), Toast.LENGTH_SHORT, true).show();

                        break;
                }
            }
        }
    }

    private CockHandler handler = new CockHandler(this);
    private void setLayout() {
        rl_serialnumber_record.setClickable(true);
        chipcode = valueBean.getChipCode();
        tv_chipnumber_revu.setText(chipcode);
        //=============================================================
        String derby = valueBean.getDerby();

        if (derby != null && !derby.equals("")) {
            tv_serialnumber_revu.setText(derby.trim());
            //            tv_serialnumber_revu.setText(derby);
            //            right_arrow_derbyentry.setVisibility(View.INVISIBLE);
            //            rl_serialnumber_record.setClickable(false);
        }
        //=============================================================
        tv_memo_revu.setText(valueBean.getMemo());
        //=====================
        tv_birthday_revu.setText(valueBean.getBirth());
        federation = String.valueOf(valueBean.getOrgName());
        tv_associationid_revu.setText(federation);
        //根据子机构的id来得到母机构到底是哪个
        int orgid = valueBean.getOrgID();
        for (int i = 0; i < sonOrgid.size(); i++) {
            if (orgid == sonOrgid.get(i)) {
                tv_orgname_revu.setText(motherOrg.get(0));
                mainfederation = motherOrg.get(0);

            }
        }
        for (int i = 0; i < sonOrgsid.size(); i++) {
            if (orgid == sonOrgsid.get(i)) {
                tv_orgname_revu.setText(motherOrg.get(1));
                mainfederation = motherOrg.get(1);
            }
        }
        //===
        int status = valueBean.getCStatus();
        if (status == 1) {
            tv_cockstatus_revu.setText(GetAttrString.getStatusData_cocks_cStatus_normal());
        } else if (status == 2) {
            tv_cockstatus_revu.setText(GetAttrString.getStatusData_cocks_cStatus_abort());
        } else if (status == 3) {
            tv_cockstatus_revu.setText(GetAttrString.getStatusData_cocks_cStatus_lost());
        }
        //===
        String dated = valueBean.getCreateAt();
        String[] s1 = dated.split("T");
        dated = s1[0];
        String[] t = dated.split("-");
        tv_creatAt_revu.setText(new StringBuilder().append(t[1]).append("-").append(t[2]).append("-").append(t[0])
                .toString());
        String regdate1 = (String) valueBean.getRegDate1();
        String regdate2 = (String) valueBean.getRegDate2();
        String regdate3 = (String) valueBean.getRegDate3();
        //===============regdate1,regdate2,regdate3 的显示逻辑
        if (regdate1 == null && regdate2 == null && regdate3 == null) {
            rl_cockstatustwooftime.setVisibility(View.GONE);
            rl_cockstatusthreeoftime.setVisibility(View.GONE);
            //            tv_cockstatusoneoftime_revu.setText(regdate1);
            //
        }
        if (regdate1 != null && regdate2 == null && regdate3 == null) {
            String[] arrays1 = regdate1.split("T");
            tv_cockstatusoneoftime_revu.setText(arrays1[0]);
            arrow_importer1.setVisibility(View.GONE);
            rl_cockstatusthreeoftime.setVisibility(View.GONE);
        } else if (regdate1 != null && regdate2 != null && regdate3 == null) {
            String[] arrays1 = regdate1.split("T");
            String[] arrays2 = regdate2.split("T");
            tv_cockstatusoneoftime_revu.setText(arrays1[0]);
            arrow_importer1.setVisibility(View.GONE);
            tv_cockstatustwooftime_revu.setText(arrays2[0]);
            arrow_importer2.setVisibility(View.GONE);
        } else if (regdate1 != null && regdate2 != null && regdate3 != null) {
            String[] arrays1 = regdate1.split("T");
            String[] arrays2 = regdate2.split("T");
            String[] arrays3 = regdate3.split("T");
            arrow_importer1.setVisibility(View.GONE);
            arrow_importer2.setVisibility(View.GONE);
            arrow_importer3.setVisibility(View.GONE);
            tv_cockstatusoneoftime_revu.setText(arrays1[0]);
            tv_cockstatustwooftime_revu.setText(arrays2[0]);
            tv_cockstatusthreeoftime_revu.setText(arrays3[0]);
        }

        //        tv_cockstatustwooftime_revu.setText((String)valueBean.getRegDate2());
        //        tv_cockstatusthreeoftime_revu.setText((String)valueBean.getRegDate3());
        //=====
        boolean isImport = valueBean.isIsImport();
        if (isImport) {
            tv_isforeigncock_revu.setText(GetAttrString.getYes());
        } else {
            tv_isforeigncock_revu.setText(GetAttrString.getNo());
        }
        if (isImport) {
            if (valueBean.getImporterName() != null) {
                tv_importerid_revu.setText((String) valueBean.getImporterName());
            } else {
                tv_importerid_revu.setText("");
            }

        } else {
            rl_importerid.setVisibility(View.GONE);
        }
        //=====
        tv_farmname_revu.setText(valueBean.getMFarmName());
        tv_cockowner_revu.setText(valueBean.getOwnerName());
        breedname = valueBean.getBreedName();
        tv_breedName_revu.setText(breedname);
        tv_dictName_revu.setText(valueBean.getDictName());
        float weight = ((float) valueBean.getOrgID()) / 100;
        tv_weight_revu.setText(weight + " kg");
        //=================================================viewpager 的处理
        // 初始化ivList集合，并给集合中的两个imageview用picasso加载上图片
        for (int i = 0; i < 2; i++) {
            final PinchImageView iv = new PinchImageView(this);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setAdjustViewBounds(true);
            iv.setMaxHeight(200);
            iv.setMaxHeight(200);
            String requl = Constants.COCKIMG_URL;
            requl = GetJson.replace(requl, "{chipcode}", valueBean.getChipCode());
            String[] temp = valueBean.getCreateAt().split("T");
            String[] temp1 = temp[0].split("-");
            String s = temp1[0] + temp1[1] + temp1[2];
            requl = GetJson.replace(requl, "{20170907}", s);
            if (i == 0) {
                requl = GetJson.replace(requl, "{skin}", "skin");
                Log.i(Constants.TAG, "skin's imgsrc is" + requl);
                PicassoUtil.getInstance().loadnormalImage(context, requl, iv);
                ivList.add(iv);
            } else {
                requl = GetJson.replace(requl, "{skin}", "leg");
                Log.i(Constants.TAG, "leg's imgsrc is " + requl);
                PicassoUtil.getInstance().loadnormalImage(context, requl, iv);
                ivList.add(iv);
            }
        }

        initviewpageradapter();
        viewpagerOperation();


        //===============
        //============================加载斗鸡图片
        //暂时去掉高斯模糊
        //        NewCommmonMethod.getInstance().setHeadBackGround(requl,newlayer,true);
        //=============== 需要传还有创建日期的
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cock_detail_1);
        Intent intent = getIntent();
        id = intent.getIntExtra("cockid", 21);
        //        Toast.makeText(context, "cockid is" + id , Toast.LENGTH_SHORT).show();

        initview();
        showLoading(true);
        initcontestoption();
        getAllOrg();
    }

    private void initcontestoption() {
        int contestnum = SharedPreferencesUtils.getInt(context, "contestsize", 0);
        if (contestnum > 0) {
            for (int j = 0; j < contestnum; j++) {
                contestList.add(SharedPreferencesUtils.getString(context, "contest" + (j + 1), ""));
                contestIdList.add(SharedPreferencesUtils.getInt(context, "contestid" + (j + 1), 0));
            }
        }
    }

    private void viewpagerOperation() {
        viewpager.setCurrentItem(0);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                RadioButton rb = (RadioButton) rg_iv.getChildAt(position);
                rg_iv.check(rb.getId());
                if (i == 0) {
                    if (rb_1.isChecked()) {
                        rb_1.setChecked(false);
                    }
                    i++;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:

                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;
                }
            }
        });
    }

    private void initviewpageradapter() {
        ViewPagerAdapter vpa = new ViewPagerAdapter(ivList);
        viewpager.setAdapter(vpa);
    }

    private void getAllOrg() {
        if (!sweetAlertDialog.isShowing()) {
            showLoading(true);
        }
        //整体思路：首先去sharepreference 去拿母机构与子机构，若能拿到则构建ArrayList，若拿不到则下载母机构子机构的列表，并将母机构子机构的id，名字，以及各自的
        //的数目存储到sharepreference中，方便之后构建Arraylist
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String requl = Constants.ALLORG_URL;
                allOrgBean = OkhttpPlusUtil.getInstance().get(requl, AllOrgBean.class);
                if (allOrgBean != null && allOrgBean.isIsSuccess() && allOrgBean.getValues().size() > 0) {

                    Log.i(Constants.TAG, "motherOrg's size " + motherOrg.size());
                    Log.i(Constants.TAG, "sonOrg 's size " + sonOrg.size());
                    Log.i(Constants.TAG, "sonOrgs's size" + sonOrgs.size());
                    handler.sendEmptyMessage(Constants.GET_ALLORG);
                } else {
                    handler.sendEmptyMessage(Constants.GETDATA_FAIL);
                }
            }
        });
    }

    private void initdata() {
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String query_url = Constants.QUERY_COCK_BY_ID_URL;
                query_url = GetJson.replace(query_url, "{id}", String.valueOf(id));//用id拉取斗鸡的详细信息
                cockDetailInfoBean = OkhttpPlusUtil.getInstance().get(query_url, CockDetailInfoBean.class);
                if (cockDetailInfoBean != null && cockDetailInfoBean.isIsSuccess()) {
                    handler.sendEmptyMessage(Constants.GETDATA_SUCCESS);
                } else {
                    handler.sendEmptyMessage(Constants.GETDATA_FAIL);
                }
            }
        });
    }

    private void initview() {
        //获取数据失败时显示的布局
        rl_refresh = findViewById(R.id.rl_refresh);
        TextView refreshbutton = rl_refresh.findViewById(R.id.refreshbutton);
        refreshbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllOrg();
            }
        });
        //
        rl_wrapviewpager = findViewById(R.id.rl_wrapviewpager);
        rg_iv = findViewById(R.id.rg_iv);
        rb_1 = rg_iv.findViewById(R.id.rb_1);
//        RadioButton rb_2 = rg_iv.findViewById(R.id.rb_2);
        viewpager = findViewById(R.id.viewpager);
        arrow_importer1 = findViewById(R.id.arrow_importer1);
        arrow_importer2 = findViewById(R.id.arrow_importer2);
        arrow_importer3 = findViewById(R.id.arrow_importer3);
        mProgressbar = findViewById(R.id.progressbar);
        sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        RelativeLayout titlebar_cockdetail = findViewById(R.id.titlebar_cockdetail);
        RelativeLayout rl_back = titlebar_cockdetail.findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_in_from_left, R.anim.activity_out_to_right);

            }
        });
        TextView activity_title = titlebar_cockdetail.findViewById(R.id.activity_title);
        activity_title.setText(GetAttrString.getCockDetailInfo());
        RelativeLayout rl_cockgameinfo = findViewById(R.id.rl_cockgameinfo);
        rl_cockgameinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CockDetailActivity.this, CockGameRecordActivity.class);
                intent.putExtra("cockchipcode", valueBean.getChipCode());
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in_form_right, R.anim.activity_out_to_left);

            }
        });
        RelativeLayout rl_cockstatus = findViewById(R.id.rl_cockstatus);
        rl_cockstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCockStatusDialog();
            }
        });
        //++++++++++++++++++++++++++++++++++++++++++++++++
        TextView tv_cockstatus = findViewById(R.id.tv_cockstatus);
        tv_cockstatus.setText(GetAttrString.getCock_cstatus());
        //+++++++++++++++++++++++++++++++++++++++++++++++++++
        tv_cockstatus_revu = findViewById(R.id.tv_cockstatus_revu);
//        TextView btn_reportlost = findViewById(R.id.btn_reportlost);
        TextView tv_cockgameinfo = findViewById(R.id.tv_cockgameinfo);
        tv_cockgameinfo.setText(GetAttrString.getCockGameRecord());
//        TextView tv_games = findViewById(R.id.tv_games);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        TextView tv_chipnumber_record = findViewById(R.id.tv_chipnumber_record);
        tv_chipnumber_record.setText(GetAttrString.getCock_ChipCode());
        //+++++++++++++++++++++++++++++++++++++++++++++
        tv_chipnumber_revu = findViewById(R.id.tv_chipnumber_revu);
        rl_chipnumber_record = findViewById(R.id.rl_chipnumber_record);
        rl_chipnumber_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chipcode!=null&&chipcode.length()>0){
                    View view = LayoutInflater.from(context).inflate(R.layout.easydialog_layout, null);
                    TextView tv_chipcode = view.findViewById(R.id.tv_federation);
                    tv_chipcode.setText(chipcode);
                    new EasyDialog(context).setLayout(view).setBackgroundColor(context.getResources().getColor(R.color
                            .background_color_blue)).setLocationByAttachedView(rl_chipnumber_record).setGravity
                            (EasyDialog.GRAVITY_TOP).setAnimationAlphaShow(600, 0.0f, 1.0f).setAnimationAlphaDismiss(600,
                            1.0f, 0.0f).setTouchOutsideDismiss(true).setMatchParent(true).setMarginLeftAndRight(24, 24)
                            .show();
                }
            }
        });
        //+++++++++++++++++++++++++++++
        TextView tv_serialnumber_record = findViewById(R.id.tv_serialnumber_record);
        tv_serialnumber_record.setText(GetAttrString.getCock_no());
        //+++++++++++++++++++++++++++++
        tv_serialnumber_revu = findViewById(R.id.tv_serialnumber_revu);
        rl_serialnumber_record = findViewById(R.id.rl_serialnumber_record);
        rl_serialnumber_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final OptionsPickerView contestOption = new OptionsPickerView.Builder(context, new OptionsPickerView
                        .OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(final int options1, int options2, int options3, View v) {

                        selectderby = contestList.get(options1);
                        selectderby = contestList.get(options1);

                        for (int i = 0; i < contestList.size(); i++) {
                            if (selectderby.equals(contestList.get(i))) {
                                derbyidselected = contestIdList.get(i);
                            }
                        }
                        final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(context);
                        rxDialogSureCancel.getContentView().setText(GetAttrString.getSetCockDerby()+ selectderby+" ?");
                        rxDialogSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                rxDialogSureCancel.dismiss();
                            }
                        });
                        rxDialogSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                rxDialogSureCancel.dismiss();
                                try {
                                    JSONObject object = new JSONObject();
                                    object.put(Constants.ID, valueBean.getID());
                                    object.put(Constants.DERBY, derbyidselected);
                                    final String content = object.toString();
                                    Log.i(Constants.TAG, "content is " + content);
                                    ThreadManager.getInstance().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            //告诉server 该编号斗鸡的derby
                                            fixCockDerbyResultBean = OkhttpPlusUtil.getInstance().post(Constants
                                                    .FIX_COCK_DERBY_URL, content, FixCockStatusResultBean.class);
                                            boolean isSuccessful = fixCockDerbyResultBean.isIsSuccess();
                                            if (isSuccessful) {
                                                handler.sendEmptyMessage(Constants.SUCCESS_FIX_COCK_DERBY);
                                            } else {
                                                handler.sendEmptyMessage(Constants.FAIL_FIX_COCK_DERBY);
                                            }
                                        }
                                    });
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        rxDialogSureCancel.show();

                        //=================================================================================

                        //                        AlertDialog ab = null;
                        //                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        //                        builder.setTitle("Tip");
                        //                        builder.setMessage("Derby can be modified once only , will you set
                        // the Derby \" " +
                        //                                contestList.get(options1) + " \"?");
                        //                        builder.setNegativeButton("Cancel", new DialogInterface
                        // .OnClickListener() {
                        //                            @Override
                        //                            public void onClick(DialogInterface dialog, int which) {
                        //
                        //                            }
                        //                        });
                        //                        builder.setPositiveButton("Confirm", new DialogInterface
                        // .OnClickListener() {
                        //                            @Override
                        //                            public void onClick(DialogInterface dialog, int which) {
                        //                                selectderby = contestList.get(options1);
                        //                                int derbyidselected = -1;
                        //                                for (int i = 0; i < contestList.size(); i++) {
                        //                                    if (selectderby.equals(contestList.get(i))) {
                        //                                        derbyidselected = contestIdList.get(i);
                        //                                    }
                        //                                }
                        //
                        //                                try {
                        //                                    JSONObject object = new JSONObject();
                        //                                    object.put(Constants.ID, valueBean.getID());
                        //                                    object.put(Constants.DERBY, derbyidselected);
                        //                                    final String content = object.toString();
                        //                                    Log.i(Constants.TAG, "content is " + content);
                        //                                    ThreadManager.getInstance().execute(new Runnable() {
                        //                                        @Override
                        //                                        public void run() {
                        //                                            //告诉server 该编号斗鸡的derby
                        //                                            fixCockDerbyResultBean = OkhttpPlusUtil
                        // .getInstance().post(Constants
                        //                                                    .FIX_COCK_DERBY_URL, content,
                        // FixCockStatusResultBean.class);
                        //                                            boolean isSuccessful = fixCockDerbyResultBean
                        // .isIsSuccess();
                        //                                            if (isSuccessful) {
                        //                                                handler.sendEmptyMessage(Constants
                        // .SUCCESS_FIX_COCK_DERBY);
                        //                                            } else {
                        //                                                handler.sendEmptyMessage(Constants
                        // .FAIL_FIX_COCK_DERBY);
                        //                                            }
                        //                                        }
                        //                                    });
                        //                                } catch (JSONException e) {
                        //                                    e.printStackTrace();
                        //                                }
                        //                            }
                        //                        });
                        //                        ab = builder.create();
                        //                        ab.show();
                    }
                }).setDividerColor(Color.BLACK).setTextColorCenter(Color.BLACK).setContentTextSize(20)
                        .setSelectOptions(0).isDialog(false).setOutSideCancelable(true).setSubmitText(GetAttrString
                                .getBasic_confirm()).setCancelText(GetAttrString.getBasic_cancel()).build();

                contestOption.setPicker(contestList);
                contestOption.show();
            }
        });
        //++++++++++++++++++++++++++++++++++++++++++++++++++++
        TextView tv_memo = findViewById(R.id.tv_memo);
        tv_memo.setText(GetAttrString.getCock_memo());
        //++++++++++++++++++++++++++++++++++++++++++++++++++++
        tv_memo_revu = findViewById(R.id.tv_memo_revu);
        rl_memo = findViewById(R.id.rl_memo);
        rl_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueBean.getMemo()!=null&&valueBean.getMemo().trim().length()>0){
                    View view = LayoutInflater.from(context).inflate(R.layout.easydialog_layout, null);
                    TextView tv_federation = view.findViewById(R.id.tv_federation);
                    tv_federation.setText(valueBean.getMemo());
                    new EasyDialog(context).setLayout(view).setBackgroundColor(context.getResources().getColor(R.color
                            .background_color_blue)).setLocationByAttachedView(rl_memo).setGravity(EasyDialog
                            .GRAVITY_TOP).setAnimationAlphaShow(600, 0.0f, 1.0f).setAnimationAlphaDismiss(600, 1.0f,
                            0.0f).setTouchOutsideDismiss(true).setMatchParent(false).setMarginLeftAndRight(24, 24).show();
                }
            }
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
        TextView tv_birthday = findViewById(R.id.tv_birthday);
        tv_birthday.setText(GetAttrString.getCock_birth());
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
        tv_birthday_revu = findViewById(R.id.tv_birthday_revu);
//        RelativeLayout rl_birthday = findViewById(R.id.rl_birthday);
        //+++++++++++++++++++++++++++++++++++++++++++
        TextView tv_associationid = findViewById(R.id.tv_associationid);
        tv_associationid.setText(GetAttrString.getCock_org());
        //+++++++++++++++++++++++++++++++++++++++++++
        tv_associationid_revu = findViewById(R.id.tv_associationid_revu);
        rl_associationid = findViewById(R.id.rl_associationid);
        rl_associationid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(context).inflate(R.layout.easydialog_layout, null);
                TextView tv_federation = view.findViewById(R.id.tv_federation);
                tv_federation.setText(federation);
                new EasyDialog(context).setLayout(view).setBackgroundColor(context.getResources().getColor(R.color
                        .background_color_blue)).setLocationByAttachedView(rl_associationid).setGravity(EasyDialog
                        .GRAVITY_TOP).setAnimationAlphaShow(600, 0.0f, 1.0f).setAnimationAlphaDismiss(600, 1.0f,
                        0.0f).setTouchOutsideDismiss(true).setMatchParent(false).setMarginLeftAndRight(24, 24).show();
            }
        });
//        ImageView right_arrow_status = findViewById(R.id.right_arrow_status);
//        ImageView right_arrow_derbyentry = findViewById(R.id.right_arrow_derbyentry);
//        TextView tv_creatAt = findViewById(R.id.tv_creatAt);
        tv_creatAt_revu = findViewById(R.id.tv_creatAt_revu);
//        RelativeLayout rl_creatAt = findViewById(R.id.rl_creatAt);
        //++++++++++++++++++++++++++++++++++++++++
        //================================================================================
        TextView tv_cockstatusoneoftime = findViewById(R.id.tv_cockstatusoneoftime);
        tv_cockstatusoneoftime.setText(GetAttrString.getCock_regdate1());
        tv_cockstatusoneoftime_revu = findViewById(R.id.tv_cockstatusoneoftime_revu);
        rl_cockstatusoneoftime = findViewById(R.id.rl_cockstatusoneoftime);

        TextView tv_cockstatustwooftime = findViewById(R.id.tv_cockstatustwooftime);
        tv_cockstatustwooftime.setText(GetAttrString.getCock_regdate2());
        tv_cockstatustwooftime_revu = findViewById(R.id.tv_cockstatustwooftime_revu);
        rl_cockstatustwooftime = findViewById(R.id.rl_cockstatustwooftime);

        TextView tv_cockstatusthreeoftime = findViewById(R.id.tv_cockstatusthreeoftime);
        tv_cockstatusthreeoftime.setText(GetAttrString.getCock_regdate3());
        tv_cockstatusthreeoftime_revu = findViewById(R.id.tv_cockstatusthreeoftime_revu);
        rl_cockstatusthreeoftime = findViewById(R.id.rl_cockstatusthreeoftime);

        rl_cockstatusoneoftime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_cockstatusoneoftime_revu.getText().toString().trim().length() == 0) {
                    showRegDateLevel(1);
                }
            }
        });
        rl_cockstatustwooftime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_cockstatustwooftime_revu.getText().toString().trim().length() == 0) {
                    showRegDateLevel(2);
                }
            }
        });
        rl_cockstatusthreeoftime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_cockstatusthreeoftime_revu.getText().toString().trim().length() == 0) {
                    showRegDateLevel(3);
                }
            }
        });
        //=======================================================================================
        //++++++++++++++++++++++++++++++++++++++++
        TextView tv_isforeigncock = findViewById(R.id.tv_isforeigncock);
        tv_isforeigncock.setText(GetAttrString.getCock_isimport());
        //++++++++++++++++++++++++++++++++++++++++++++
        tv_isforeigncock_revu = findViewById(R.id.tv_isforeigncock_revu);
//        RelativeLayout rl_isforeigncock = findViewById(R.id.rl_isforeigncock);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
        TextView tv_importerid = findViewById(R.id.tv_importerid);
        tv_importerid.setText(GetAttrString.getimporter_importerName());
        tv_importerid_revu = findViewById(R.id.tv_importerid_revu);
        rl_importerid = findViewById(R.id.rl_importerid);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        TextView tv_farmname = findViewById(R.id.tv_farmname);
        tv_farmname.setText(GetAttrString.getCock_farmid());
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        tv_farmname_revu = findViewById(R.id.tv_farmname_revu);
//        RelativeLayout rl_farmname = findViewById(R.id.rl_farmname);
//        TextView tv_orgname = findViewById(R.id.tv_orgname);
        tv_orgname_revu = findViewById(R.id.tv_orgname_revu);
        rl_orgname = findViewById(R.id.rl_orgname);
        rl_orgname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(context).inflate(R.layout.easydialog_layout, null);
                TextView tv_federation = view.findViewById(R.id.tv_federation);
                tv_federation.setText(mainfederation);
                new EasyDialog(context).setLayout(view).setBackgroundColor(context.getResources().getColor(R.color
                        .background_color_blue)).setLocationByAttachedView(rl_orgname).setGravity(EasyDialog
                        .GRAVITY_TOP).setAnimationAlphaShow(600, 0.0f, 1.0f).setAnimationAlphaDismiss(600, 1.0f,
                        0.0f).setTouchOutsideDismiss(true).setMatchParent(true).setMarginLeftAndRight(24, 24).show();
            }
        });
        //++++++++++++++++++++++++++++
        //++++++++++++++++++++++++++++++
        TextView tv_cockowner_record = findViewById(R.id.tv_cockowner_record);
        tv_cockowner_record.setText(GetAttrString.getOwners_ownername());
        //+++++++++++++++++++++++++++++++++++++++
        tv_cockowner_revu = findViewById(R.id.tv_cockowner_revu);
        rl_cockowner_record = findViewById(R.id.rl_cockowner_record);
        rl_cockowner_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueBean.getOwnerName()!=null&&valueBean.getOwnerName().trim().length()>0){
                    View view = LayoutInflater.from(context).inflate(R.layout.easydialog_layout, null);
                    TextView tv = view.findViewById(R.id.tv_federation);
                    tv.setText(valueBean.getOwnerName());
                    new EasyDialog(context).setLayout(view).setBackgroundColor(context.getResources().getColor(R.color
                            .background_color_blue)).setLocationByAttachedView(rl_cockowner_record).setGravity(EasyDialog
                            .GRAVITY_TOP).setAnimationAlphaShow(600, 0.0f, 1.0f).setAnimationAlphaDismiss(600, 1.0f,
                            0.0f).setTouchOutsideDismiss(true).setMatchParent(true).setMarginLeftAndRight(24, 24).show();
                }
            }
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++
        TextView tv_breedName = findViewById(R.id.tv_breedName);
        tv_breedName.setText(GetAttrString.getCock_breedid());
        //+++++++++++++++++++++++++++++++++++++++++++++++++++
        tv_breedName_revu = findViewById(R.id.tv_breedName_revu);
        rl_breedName = findViewById(R.id.rl_breedName);
        rl_breedName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(breedname!=null&&breedname.length()>0){
                    View view = LayoutInflater.from(context).inflate(R.layout.easydialog_layout, null);
                    TextView tv_breedname = view.findViewById(R.id.tv_federation);
                    tv_breedname.setText(breedname);
                    new EasyDialog(context).setLayout(view).setBackgroundColor(context.getResources().getColor(R.color
                            .background_color_blue)).setLocationByAttachedView(rl_breedName).setGravity(EasyDialog
                            .GRAVITY_TOP).setAnimationAlphaShow(600, 0.0f, 1.0f).setAnimationAlphaDismiss(600, 1.0f,
                            0.0f).setTouchOutsideDismiss(true).setMatchParent(true).setMarginLeftAndRight(24, 24).show();
                }
            }
        });
        TextView tv_dictName = findViewById(R.id.tv_dictName);
        tv_dictName.setText(GetAttrString.getdiction_dictName());
        tv_dictName_revu = findViewById(R.id.tv_dictName_revu);
//        RelativeLayout rl_dictName = findViewById(R.id.rl_dictName);
        basicInfo = findViewById(R.id.basicInfo);
        tv_weight_revu = findViewById(R.id.tv_weight_revu);
        rl_weight = findViewById(R.id.rl_weight);
        rl_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RxDialogEditSureCancel rxDialogEditSureCancel = new RxDialogEditSureCancel(context);
                rxDialogEditSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogEditSureCancel.dismiss();
                        //======
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        if(imm.isActive()){
                            imm.hideSoftInputFromInputMethod(v.getWindowToken(),0);
                        }
                        final String strweight = rxDialogEditSureCancel.getEditText().getText().toString();
                        final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(context);
                        rxDialogSureCancel.getContentView().setText(GetAttrString.getSetCockWeight()+strweight+" kg ?");
                        rxDialogSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                rxDialogSureCancel.dismiss();
                            }
                        });
                        rxDialogSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                rxDialogSureCancel.dismiss();
                                float s = Float.parseFloat(strweight)*100;
                                int realWeight = (int) s;
                                JSONObject object = new JSONObject();
                                try {
                                    object.put(Constants.ID,id);
                                    object.put("weight",realWeight);
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                                final String contentjson = object.toString();
                                ThreadManager.getInstance().execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        fixCockWeightResultBean = OkhttpPlusUtil.getInstance().post(Constants.FIX_COCK_WEIGHT_URL,contentjson,FixCockRegDateResultBean.class);
                                        boolean isSuccessful = fixCockWeightResultBean.isIsSuccess();
                                        if(isSuccessful){
                                            Message msg = Message.obtain();
                                            msg.what = Constants.SUCCESS_FIX_COCK_WEIGHT;
                                            Bundle bundle = new Bundle();
                                            bundle.putString("cockweight",strweight);
                                            msg.setData(bundle);
                                            handler.sendMessage(msg);
                                        }else {
                                            handler.sendEmptyMessage(Constants.NEED_DOWNLOAD_APK);
                                        }
                                    }
                                });
                            }
                        });
                        rxDialogSureCancel.show();
                    }
                });
                rxDialogEditSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogEditSureCancel.dismiss();
                    }
                });
                rxDialogEditSureCancel.show();
            }
        });
    }

    private void showRegDateLevel(int i) {
        final List<String> lvList = new ArrayList<>();
        //================================================lv 选择
        if (i == 1) {
            lvList.add("1st");
        } else if (i == 2) {
            lvList.add("2nd");
        } else if (i == 3) {
            lvList.add("3rd");
        }
        final OptionsPickerView lvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView
                .OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                selectRegDate = lvList.get(options1);
                //
                final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(context);
                rxDialogSureCancel.getContentView().setText(GetAttrString.getSetcockdate() + selectRegDate + " ?");
                rxDialogSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSureCancel.dismiss();
                        JSONObject object = new JSONObject();
                        try {
                            object.put(Constants.ID, id);
                            switch (selectRegDate) {
                                case "1st":
                                    object.put("level", String.valueOf(1));
                                    break;
                                case "2nd":
                                    object.put("level", String.valueOf(2));
                                    break;
                                default:
                                    object.put("level", String.valueOf(3));
                                    break;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        final String contentjson = object.toString();
                        Log.i(Constants.TAG, contentjson);
                        ThreadManager.getInstance().execute(new Runnable() {
                            @Override
                            public void run() {
                                fixCockRegDateResultBean = OkhttpPlusUtil.getInstance().post(Constants
                                        .FIX_COCK_REGDATE_URL, contentjson, FixCockRegDateResultBean.class);
                                if (fixCockRegDateResultBean != null) {
                                    boolean isSuccessful = fixCockRegDateResultBean.isIsSuccess();
                                    if (isSuccessful) {
                                        Message msg = Message.obtain();
                                        msg.what = Constants.SUCCESS_FIX_COCK_REGDATE_ONE;
                                        Bundle bundle = new Bundle();
                                        bundle.putString("lvSelect", selectRegDate);
                                        msg.setData(bundle);
                                        handler.sendMessage(msg);
                                    } else {
                                        handler.sendEmptyMessage(Constants.FAIL_FIX_COCK_REGDATE_ONE);
                                    }
                                }
                            }
                        });
                    }
                });
                rxDialogSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSureCancel.dismiss();
                    }
                });
                rxDialogSureCancel.show();
                //============================
                //                final SweetAlertDialog sd = new SweetAlertDialog(context);
                ////                sd.setTitleText(GetAttrString.getSetcockdate() + selectRegDate + " ?");
                //                sd.setContentText(GetAttrString.getSetcockdate() + selectRegDate + " ?");
                //                sd.setCancelable(false);
                //                sd.setCanceledOnTouchOutside(false);
                //                sd.setConfirmText("Ok");
                //                sd.setCancelText("Cancel");
                //                sd.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                //                    @Override
                //                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                //                        sd.dismiss();
                //                    }
                //                });
                //                sd.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                //                    @Override
                //                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                //                        try {
                //                            sd.dismiss();
                //                            JSONObject object = new JSONObject();
                //                            object.put(Constants.ID, id);
                //                            if (selectRegDate.equals("1st")) {
                //                                object.put("level", String.valueOf(1));
                //                            } else if (selectRegDate.equals("2nd")) {
                //                                object.put("level", String.valueOf(2));
                //                            } else {
                //                                object.put("level", String.valueOf(3));
                //                            }
                //                            final String contentjson = object.toString();
                //                            Log.i(Constants.TAG, contentjson);
                //                            ThreadManager.getInstance().execute(new Runnable() {
                //                                @Override
                //                                public void run() {
                //                                    fixCockRegDateResultBean = OkhttpPlusUtil.getInstance().post
                // (Constants
                //                                            .FIX_COCK_REGDATE_URL, contentjson,
                // FixCockRegDateResultBean.class);
                //                                    if (fixCockRegDateResultBean != null) {
                //                                        boolean isSuccessful = fixCockRegDateResultBean.isIsSuccess();
                //                                        if (isSuccessful) {
                //                                            Message msg = Message.obtain();
                //                                            msg.what = Constants.SUCCESS_FIX_COCK_REGDATE_ONE;
                //                                            Bundle bundle = new Bundle();
                //                                            bundle.putString("lvSelect", selectRegDate);
                //                                            msg.setData(bundle);
                //                                            handler.sendMessage(msg);
                //                                        } else {
                //                                            handler.sendEmptyMessage(Constants
                // .FAIL_FIX_COCK_REGDATE_ONE);
                //                                        }
                //                                    }
                //                                }
                //                            });
                //                        } catch (JSONException e) {
                //                            e.printStackTrace();
                //                        }
                //                    }
                //                });
                //                sd.show();
                //============================
                //                AlertDialog ab = null;
                //                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                //                builder.setTitle("");
                //                builder.setMessage(GetAttrString.getSetcockdate() + selectRegDate + " ?");
                //                builder.setPositiveButton(GetAttrString.getBasic_confirm(), new DialogInterface
                // .OnClickListener() {
                //                    @Override
                //                    public void onClick(DialogInterface dialog, int which) {
                //                        try {
                //                            JSONObject object = new JSONObject();
                //                            object.put(Constants.ID, id);
                //                            if (selectRegDate.equals("1st")) {
                //                                object.put("level", String.valueOf(1));
                //                            } else if (selectRegDate.equals("2nd")) {
                //                                object.put("level", String.valueOf(2));
                //                            } else {
                //                                object.put("level", String.valueOf(3));
                //                            }
                //                            final String contentjson = object.toString();
                //                            Log.i(Constants.TAG, contentjson);
                //                            ThreadManager.getInstance().execute(new Runnable() {
                //                                @Override
                //                                public void run() {
                //                                    fixCockRegDateResultBean = OkhttpPlusUtil.getInstance().post
                // (Constants
                //                                            .FIX_COCK_REGDATE_URL, contentjson,
                // FixCockRegDateResultBean.class);
                //                                    if (fixCockRegDateResultBean != null) {
                //                                        boolean isSuccessful = fixCockRegDateResultBean.isIsSuccess();
                //                                        if (isSuccessful) {
                //                                            Message msg = Message.obtain();
                //                                            msg.what = Constants.SUCCESS_FIX_COCK_REGDATE_ONE;
                //                                            Bundle bundle = new Bundle();
                //                                            bundle.putString("lvSelect", selectRegDate);
                //                                            msg.setData(bundle);
                //                                            handler.sendMessage(msg);
                //                                        } else {
                //                                            handler.sendEmptyMessage(Constants
                // .FAIL_FIX_COCK_REGDATE_ONE);
                //                                        }
                //                                    }
                //                                }
                //                            });
                //                        } catch (JSONException e) {
                //                            e.printStackTrace();
                //                        }
                //                    }
                //                });
                //                builder.setNegativeButton(GetAttrString.getBasic_cancel(), new DialogInterface
                // .OnClickListener() {
                //                    @Override
                //                    public void onClick(DialogInterface dialog, int which) {
                //
                //                    }
                //                });
                //                ab = builder.create();
                //                ab.show();


            }
        }).setDividerColor(Color.BLACK).setTextColorCenter(Color.BLACK).setContentTextSize(20).setSelectOptions(0, 1)
                .isDialog(false).setOutSideCancelable(true).setSubmitText(GetAttrString.getBasic_confirm())
                .setCancelText(GetAttrString.getBasic_cancel()).build();
        lvOptions.setPicker(lvList);
        lvOptions.show();

    }

    private void showCockStatusDialog() {
        final List<String> statusList = new ArrayList<>();
        statusList.add(GetAttrString.getStatusData_cocks_cStatus_normal());
        statusList.add(GetAttrString.getStatusData_cocks_cStatus_lost());
        statusList.add(GetAttrString.getStatusData_cocks_cStatus_abort());
        final OptionsPickerView statusOptions = new OptionsPickerView.Builder(context, new OptionsPickerView
                .OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                selectStatus = statusList.get(options1);
                //====================================
                final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(context);
                rxDialogSureCancel.getContentView().setText(GetAttrString.getSetCockStatus() + selectStatus+" ?");
                rxDialogSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSureCancel.dismiss();
                        try {
                            JSONObject object = new JSONObject();
                            object.put(Constants.ID, valueBean.getID());
                            switch (selectStatus) {
                                case "Normal":
                                case "正常":
                                    object.put(Constants.CSTATUS, 1);
                                    break;
                                case "Unregister":
                                case "未注册":
                                    object.put(Constants.CSTATUS, 2);
                                    break;
                                case "Lost":
                                case "丢失":
                                    object.put(Constants.CSTATUS, 3);
                                    break;
                            }
                            final String content = object.toString();
                            Log.i(Constants.TAG, "content is " + content);
                            ThreadManager.getInstance().execute(new Runnable() {
                                @Override
                                public void run() {
                                    fixCockStatusResultBean = OkhttpPlusUtil.getInstance().post(Constants
                                            .FIX_COCK_STATUS_URL, content, FixCockStatusResultBean.class);
                                    boolean isSuccessful = fixCockStatusResultBean.isIsSuccess();
                                    if (isSuccessful) {
                                        handler.sendEmptyMessage(Constants.SUCCESS_FIX_COCK_STATUS);
                                    } else {
                                        handler.sendEmptyMessage(Constants.FAIL_FIX_COCK_STATUS);
                                    }
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                rxDialogSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSureCancel.dismiss();
                    }
                });
                rxDialogSureCancel.show();
                //====================================
                //                final SweetAlertDialog sd = new SweetAlertDialog(context);
                ////                sd.setTitleText(GetAttrString.getSetCockStatus() + selectStatus);
                //                sd.setContentText(GetAttrString.getSetCockStatus() + selectStatus);
                //                sd.setCancelable(false);
                //                sd.setCanceledOnTouchOutside(false);
                //                sd.setConfirmText("Ok");
                //                sd.setCancelText("Cancel");
                //                sd.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                //                    @Override
                //                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                //                        sd.dismiss();
                //                    }
                //                });
                //                sd.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                //                    @Override
                //                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                //                        sd.dismiss();
                //                        try {
                //                            JSONObject object = new JSONObject();
                //                            object.put(Constants.ID, valueBean.getID());
                //                            if (selectStatus.equals("Normal") || selectStatus.equals("正常")) {
                //                                object.put(Constants.CSTATUS, 1);
                //                            } else if (selectStatus.equals("Unregister") || selectStatus.equals
                // ("未注册")) {
                //                                object.put(Constants.CSTATUS, 2);
                //                            } else if(selectStatus.equals("Lost")||selectStatus.equals("丢失")){
                //                                object.put(Constants.CSTATUS, 3);
                //                            }
                //                            final String content = object.toString();
                //                            Log.i(Constants.TAG,"content is "+ content);
                //                            ThreadManager.getInstance().execute(new Runnable() {
                //                                @Override
                //                                public void run() {
                //                                    fixCockStatusResultBean = OkhttpPlusUtil.getInstance().post
                // (Constants
                //                                            .FIX_COCK_STATUS_URL, content, FixCockStatusResultBean
                // .class);
                //                                    boolean isSuccessful = fixCockStatusResultBean.isIsSuccess();
                //                                    if (isSuccessful) {
                //                                        handler.sendEmptyMessage(Constants.SUCCESS_FIX_COCK_STATUS);
                //                                    } else {
                //                                        handler.sendEmptyMessage(Constants.FAIL_FIX_COCK_STATUS);
                //                                    }
                //                                }
                //                            });
                //                        } catch (JSONException e) {
                //                            e.printStackTrace();
                //                        }
                //                    }
                //                });
                //                sd.show();
                //====================弹出dialog 让用户确认执行此操作
                //                AlertDialog ab = null;
                //                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                //                builder.setTitle("");
                //                builder.setMessage(GetAttrString.getSetCockStatus() + selectStatus);
                //                builder.setPositiveButton(GetAttrString.getBasic_confirm(), new DialogInterface
                // .OnClickListener() {
                //                    @Override
                //                    public void onClick(DialogInterface dialog, int which) {
                //                        try {
                //                            JSONObject object = new JSONObject();
                //                            object.put(Constants.ID, valueBean.getID());
                //                            if (selectStatus.equals("Normal") || selectStatus.equals("正常")) {
                //                                object.put(Constants.CSTATUS, 1);
                //                            } else if (selectStatus.equals("Unregister") || selectStatus.equals
                // ("未注册")) {
                //                                object.put(Constants.CSTATUS, 2);
                //                            } else if(selectStatus.equals("Lost")||selectStatus.equals("丢失")){
                //                                object.put(Constants.CSTATUS, 3);
                //                            }
                //                            final String content = object.toString();
                //                            Log.i(Constants.TAG,"content is "+ content);
                //                            ThreadManager.getInstance().execute(new Runnable() {
                //                                @Override
                //                                public void run() {
                //                                    fixCockStatusResultBean = OkhttpPlusUtil.getInstance().post
                // (Constants
                //                                            .FIX_COCK_STATUS_URL, content, FixCockStatusResultBean
                // .class);
                //                                    boolean isSuccessful = fixCockStatusResultBean.isIsSuccess();
                //                                    if (isSuccessful) {
                //                                        handler.sendEmptyMessage(Constants.SUCCESS_FIX_COCK_STATUS);
                //                                    } else {
                //                                        handler.sendEmptyMessage(Constants.FAIL_FIX_COCK_STATUS);
                //                                    }
                //                                }
                //                            });
                //                        } catch (JSONException e) {
                //                            e.printStackTrace();
                //                        }
                //                    }
                //                });
                //                builder.setNegativeButton(GetAttrString.getBasic_cancel(), new DialogInterface
                // .OnClickListener() {
                //                    @Override
                //                    public void onClick(DialogInterface dialog, int which) {
                //                    }
                //                });
                //                ab = builder.create();
                //                ab.show();


            }
        }).setDividerColor(Color.BLACK).setTextColorCenter(Color.BLACK).setContentTextSize(20).setSelectOptions(0,
                1/*, 2*/).isDialog(false).setOutSideCancelable(true).setSubmitText(GetAttrString.getBasic_confirm())
                .setCancelText(GetAttrString.getBasic_cancel()).build();
        statusOptions.setPicker(statusList);
        statusOptions.show();
    }

    private void showLoading(boolean flag) {
        if (flag) {
            sweetAlertDialog.setContentText("Loading...");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.show();
            //            mProgressbar.setVisibility(View.VISIBLE);
            rl_wrapviewpager.setVisibility(View.INVISIBLE);
            basicInfo.setVisibility(View.GONE);
        } else {
            if (sweetAlertDialog != null) {
                sweetAlertDialog.dismiss();
            }
            mProgressbar.setVisibility(View.GONE);
            rl_wrapviewpager.setVisibility(View.VISIBLE);
            basicInfo.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
