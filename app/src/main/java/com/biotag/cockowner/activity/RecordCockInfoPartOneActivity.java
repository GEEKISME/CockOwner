package com.biotag.cockowner.activity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.biotag.cockowner.JavaBean.AddCockInfoResultBean;
import com.biotag.cockowner.JavaBean.AllOrgBean;
import com.biotag.cockowner.JavaBean.AppConfigResultBean;
import com.biotag.cockowner.JavaBean.ChipCodeVerificationResultBean;
import com.biotag.cockowner.JavaBean.CockNoVerificationResultBean;
import com.biotag.cockowner.JavaBean.GetAreaInfoResultBean;
import com.biotag.cockowner.JavaBean.GetBreedInfoResultBean;
import com.biotag.cockowner.JavaBean.GetDictionInfoResultBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.common.NewCommmonMethod;
import com.biotag.cockowner.customdialog.CircleImageView;
import com.biotag.cockowner.customdialog.ClipHeadDialog;
import com.biotag.cockowner.customdialog.RxDialogEditSureCancel;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.DateUtil;
import com.biotag.cockowner.utils.FileUtils;
import com.biotag.cockowner.utils.GetJson;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.github.chengang.library.TickView;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.biotag.cockowner.common.NewCommmonMethod.HEAD_CAMERA_REQUEST_CODE;
import static com.biotag.cockowner.common.NewCommmonMethod.HEAD_IMAGE_REQUEST_CODE;

public class RecordCockInfoPartOneActivity extends UserBaseActivity {
    private TickView hookView;
    private TextView tv_weight_revu,tv_sonorg_revu, tv_motherorg_revu,tv_birthday_revu,tv_memo_revu,tv_contest_revu,tv_species_revu,tv_serialnumber_revu,tv_chipnumber_revu;
    private Context context = RecordCockInfoPartOneActivity.this;
    private String result;
    private AddCockInfoResultBean addCockInfoResultBean = null;
    private GetAreaInfoResultBean getAreaInfoResultBean = null;
    private GetBreedInfoResultBean getBreedInfoResultBean = null;
    private GetDictionInfoResultBean getDictionInfoResultBean = null;
    private AppConfigResultBean getBreedDictionValueBean = null;
    private ChipCodeVerificationResultBean chipCodeVerificationResultBean = null;
    private CockNoVerificationResultBean cockNoVerificationResultBean = null;
    private AllOrgBean allOrgBean = null;
    public static final int REQUESTCODE_TIMEPICKED = 31,GALLERY_PHOTO_CROP_LEG = 30,CAMERA_PHOTO_CROP_LEG = 28,REQUESTCODE_MEMO = 22,REQUEST_BARCODE = 21,REQUEST_PERMISSION_CAMERA = 20,GALLERY_PHOTO_CROP = 19,CAMERA_PHOTO_CROP_SKIN = 18,REQUESTCODE_IMPORTERID = 17,REQUESTCODE_FARMUSERID = 16,REQUESTCODE_CHIPNUM = 11,REQUESTCODE_SERIALNUM = 12,REQUESTCODE_BREEDID = 13;


    private ArrayList<String> contestList = new ArrayList<>();
    private ArrayList<Integer>contestListId = new ArrayList<>();
    private ArrayList<String> motherOrg = new ArrayList<>();
    private ArrayList<Integer>motherid  = new ArrayList<>();
    private ArrayList<String> sonOrg    = new ArrayList<>();
    private ArrayList<Integer>sonOrgid  = new ArrayList<>();
    private ArrayList<String> sonOrgs   = new ArrayList<>();
    private ArrayList<Integer>sonOrgsid = new ArrayList<>();
    private int orgId = 0;//记录最终选择的子机构的orgid，该id值最终要传上去
    private int luzon_dict_num = 0,visayas_dict_num = 0,mindanao_dict_num = 0,breedChosenID,orgidweight,orgidweights;
    private int appconfigversion; //用来记录diction及breed的版本号，本地的值与从server请求得到的值对比，不一致的话就去重新请求diction与breed接口
    private CircleImageView cockImg,cocklegimg;
    private static final int SUCCESSFUL_POST_COCKINFO = 0,FAILURE_POST_COCKINFO = 1,NOW_CAN_CLOSE_AC = 3;
    private String unit,decimal;
    private Button btn_post;

    public RecordCockInfoPartOneActivity() {
    }

    //======================================================================

    static class RecordCockInfoPartOneHandler extends Handler{

        WeakReference<RecordCockInfoPartOneActivity> recordCockInfoPartOneActivityWeakReference ;
        public RecordCockInfoPartOneHandler(RecordCockInfoPartOneActivity recordCockInfoPartOneActivity){
            recordCockInfoPartOneActivityWeakReference = new WeakReference<RecordCockInfoPartOneActivity>(recordCockInfoPartOneActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final RecordCockInfoPartOneActivity recordCockInfoPartOneActivity = recordCockInfoPartOneActivityWeakReference.get();
            if(recordCockInfoPartOneActivity!=null){
                switch (msg.what){
                    case NOW_CAN_CLOSE_AC:
                        recordCockInfoPartOneActivity.hookView.setVisibility(View.VISIBLE);
                        recordCockInfoPartOneActivity.hookView.toggle();
                        recordCockInfoPartOneActivity.finish();
                        break;
                    case SUCCESSFUL_POST_COCKINFO:
//                        Toast.makeText(recordCockInfoPartOneActivity, GetAttrString.getDB_PROC_cock_add_msg_0(), Toast.LENGTH_SHORT).show();
                        RxToast.success(recordCockInfoPartOneActivity, GetAttrString.getDB_PROC_cock_add_msg_0(), Toast.LENGTH_SHORT, true).show();

                        break;
                    case FAILURE_POST_COCKINFO:
//                        Toast.makeText(recordCockInfoPartOneActivity, GetAttrString.getDB_PROC_cock_add_msg_3(), Toast.LENGTH_SHORT).show();
                        RxToast.error(recordCockInfoPartOneActivity, GetAttrString.getDB_PROC_cock_add_msg_3(), Toast.LENGTH_SHORT, true).show();

                        break;
                    case Constants.UNAVAILABLE_CHIPCODE:
                        Bundle bundle = msg.getData();
                        final String result = bundle.getString("result");
                        //
                        new SweetAlertDialog(recordCockInfoPartOneActivity.context,SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("")
                                .setContentText(result+" ,"+GetAttrString.getDB_PROC_cocks_add_msg_2())
                                .setConfirmText("ok")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        sweetAlertDialog.dismiss();
                                        recordCockInfoPartOneActivity.tv_chipnumber_revu.setText("");
                                    }
                                }).show();
                        //
//                        AlertDialog ab = null;
//                        AlertDialog.Builder builder = new AlertDialog.Builder(recordCockInfoPartOneActivity);
//                        builder.setTitle("");
//                        builder.setMessage(result+" "+GetAttrString.getDB_PROC_cocks_add_msg_2());
//                        builder.setPositiveButton(GetAttrString.getBasic_confirm(), new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                recordCockInfoPartOneActivity.tv_chipnumber_revu.setText("");
//                            }
//                        });
//                        ab = builder.create();
//                        ab.show();
                        break;
                    case Constants.AVAILABLE_CHIPCODE:
                        Log.i(Constants.TAG,"keyong");
                        Bundle bundle1 = msg.getData();
                        String results = (String) bundle1.get("result");
                        recordCockInfoPartOneActivity.tv_chipnumber_revu.setText(results);
                        break;
                    case Constants.UNAVAILABLE_COCKNO:
                        Bundle bundle2 = msg.getData();
                        final String serialnum  = bundle2.getString("serialnum");
                        AlertDialog ab1 = null;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(recordCockInfoPartOneActivity);
                        builder1.setTitle("");
                        builder1.setMessage(serialnum+" "+GetAttrString.getDB_PROC_cocks_add_msg_2());
                        builder1.setPositiveButton(GetAttrString.getBasic_confirm(), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                recordCockInfoPartOneActivity.tv_serialnumber_revu.setText("");
                            }
                        });
                        ab1 = builder1.create();
                        ab1.show();

                        break;
                    case Constants.AVAILABLE_COCKNO:
                        Bundle bundle3 = msg.getData();
                        recordCockInfoPartOneActivity.tv_serialnumber_revu.setText(bundle3.getString("serialnum"));
                        break;
                }
            }
        }
    }

    private RecordCockInfoPartOneHandler handler = new RecordCockInfoPartOneHandler(this);

    private String legfilepath;
    private File skinfile = new File(Environment.getExternalStorageDirectory() + "/cockowner/",ClipHeadDialog.SKIN_IMG);
    private File legfile  = new File(Environment.getExternalStorageDirectory() + "/cockowner/",ClipHeadDialog.LEG_IMG);
    //=======================================================
    private MyLegimguploadinfoReceiver receiver;

    //=======================================================
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_cock_info_part_one);
        //=====================================================================
        //=====================================================================
        receiver = new MyLegimguploadinfoReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.biatag.cockowner");
        registerReceiver(receiver, filter);
        //========================area 只有三个：LUZON  VISAYAS  MINDANAO， 每个area 下有许多diction
        appconfigversion = SharedPreferencesUtils.getInt(context,Constants.APPCONFIG,0);
        getNewValue();
//        getAreaInfo();
        getContestList();
        getAllOrg();
        //========================
        hookView = findViewById(R.id.hookview);
        inittitlebarview();
        initcockinfoview();
    }


    private void getAllOrg() {
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String requl = Constants.ALLORG_URL;
                allOrgBean = OkhttpPlusUtil.getInstance().get(requl,AllOrgBean.class);
                if(allOrgBean!=null&&allOrgBean.isIsSuccess()&&allOrgBean.getValues().size()>0){
                    for (int i = 0; i < allOrgBean.getValues().size(); i++) {
                        AllOrgBean.ValuesBean vb = allOrgBean.getValues().get(i);
                        if(vb.getParentID()==0){
                            motherOrg.add(vb.getOrgName());
                            motherid.add(vb.getId());
                        }else {
                            if(vb.getParentID()==2){
                                sonOrg.add(vb.getOrgName());
                                sonOrgid.add(vb.getId());
                            }else {
                                sonOrgs.add(vb.getOrgName());
                                sonOrgsid.add(vb.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    private void getContestList() {
//        ThreadManager.getInstance().execute(new Runnable() {
//            @Override
//            public void run() {
//                String requl = Constants.THREE_CONTEST_URL;
//                contestBean = OkhttpPlusUtil.getInstance().get(requl,ContestBean.class);
//                if(contestBean!=null&&contestBean.isIsSuccess()&&contestBean.getValues().size()>0){
//                    for (int i = 0; i < contestBean.getValues().size(); i++) {
//                        if(!contestBean.getValues().get(i).isIsdeleted()){
//                            contestList.add(contestBean.getValues().get(i).getDerby());
//                            contestListId.add(contestBean.getValues().get(i).getID());
//                        }
//                    }
//                }
//            }
//        });
        int contestnum = SharedPreferencesUtils.getInt(context,"contestsize",0);
        Log.i(Constants.TAG,"contestnum is "+contestnum);
        if(contestnum>0){
            for (int i = 0; i <contestnum; i++) {
                String tempcontest = SharedPreferencesUtils.getString(context,"contest"+(i+1),"");
                int tempcontestid = SharedPreferencesUtils.getInt(context,"contestid"+(i+1),0);
                contestList.add(tempcontest);
                Log.i(Constants.TAG,"temcontest is"+tempcontest);

                contestListId.add(tempcontestid);
                Log.i(Constants.TAG,"temcontestid is"+tempcontest);
            }

        }
    }

    private void getNewValue() {
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                getBreedDictionValueBean = OkhttpPlusUtil.getInstance().get(Constants.APP_CONFIG_URL,AppConfigResultBean.class);
                if(getBreedDictionValueBean!=null){  //如果与服务器上的value值不一致，则请求新的breedinfo 与dictioninfo
                    if(appconfigversion!=(getBreedDictionValueBean.getValues())){
                        getBreedInfo();
                        getDictionInfo();
                        getAreaInfo();
                    }
                }
            }
        });
    }

    private void getDictionInfo() {
        final JSONObject object = new JSONObject();
        try {
            object.put("areaId",0);
            object.put("areaName","");
            object.put("id",0);
            object.put("dictName","");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String content = object.toString();
                String requl = Constants.QUERY_DISTRIT_URL;
                requl = GetJson.replace(requl,"{strQuery}",content);
                getDictionInfoResultBean=OkhttpPlusUtil.getInstance().get(requl,GetDictionInfoResultBean.class);
                if(getDictionInfoResultBean!=null&&getDictionInfoResultBean.isIsSuccess()
                        &&getDictionInfoResultBean.getTotalCount()>0){
//                    SharedPreferencesUtils.saveInt(context,Constants.DICTION_NUM,getDictionInfoResultBean.getTotalCount());
                    for (int i = 0; i <getDictionInfoResultBean.getValues().size() ; i++) {
                        GetDictionInfoResultBean.ValuesBean vb = getDictionInfoResultBean.getValues().get(i);
                        String areaname = vb.getAreaName();
                        if(areaname.equals("LUZON")){
                            SharedPreferencesUtils.saveString(context,"luzon"+luzon_dict_num,vb.getDictName());
                            luzon_dict_num++;
                        }else if (areaname.equals("VISAYAS")){
                            SharedPreferencesUtils.saveString(context,"visayas"+visayas_dict_num, vb.getDictName());
                            visayas_dict_num++;
                        }else {
                            SharedPreferencesUtils.saveString(context,"mindanao"+mindanao_dict_num,vb.getDictName());
                            mindanao_dict_num++;
                        }
//                        SharedPreferencesUtils.saveString(context,"dictName"+i,vb.getDictName());
//                        SharedPreferencesUtils.saveInt(context,"dictid"+i,vb.getId());
//                        SharedPreferencesUtils.saveInt(context,"areaId",vb.getAreaName());
//                        SharedPreferencesUtils.saveString(context,"areaName",vb.getAreaName());
                    }
                    SharedPreferencesUtils.saveInt(context,"luzondictotal",luzon_dict_num);
                    SharedPreferencesUtils.saveInt(context,"visayasdictotal",luzon_dict_num);
                    SharedPreferencesUtils.saveInt(context,"mindanaodictotal",luzon_dict_num);
                    Log.i(Constants.TAG,"dict info 写入完毕");
                }
            }
        });
    }

    private void getBreedInfo() {
        final JSONObject object = new JSONObject();
        try {
            object.put("id",0);
            object.put("breedName","");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String content = object.toString();
                String requl = Constants.BREEDID_URL;
                requl = GetJson.replace(requl,"{strQuery}",content);
                Log.i("nkk","breedinfo");
                getBreedInfoResultBean=OkhttpPlusUtil.getInstance().get(requl, GetBreedInfoResultBean.class);
                if(getBreedInfoResultBean!=null&&getBreedInfoResultBean.isIsSuccess()
                        &&getBreedInfoResultBean.getValues().size()!=0){
                    //=============================================================首先记录集合有多大

                    //
                    int j = 0;
                    for (int i = 0; i <getBreedInfoResultBean.getTotalCount() ; i++) {
                        Log.i("nkk","count is "+ getBreedInfoResultBean.getTotalCount());
                        GetBreedInfoResultBean.ValuesBean vb = getBreedInfoResultBean.getValues().get(i);
                        if(!vb.isIsDeleted()){
                            j++;
                            SharedPreferencesUtils.saveInt(context,"breedid"+j,vb.getId());
                            SharedPreferencesUtils.saveString(context,"breedName"+j,vb.getBreedName());

                        }
                    }
                    SharedPreferencesUtils.saveInt(context,Constants.BREED_NUM,j);
                    Log.i("nkk","j is"+j);
                    Log.i(Constants.TAG,"breed info 写入完毕");
                }
            }
        });
    }

    private void getAreaInfo() {
        final JSONObject object = new JSONObject();
        try {
            object.put("areaName","");
            object.put("id",0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String content = object.toString();
                String requl = Constants.GET_AREAINFO_URL;
                requl = GetJson.replace(requl,"{strQuery}",content);
                getAreaInfoResultBean=OkhttpPlusUtil.getInstance().get(requl,GetAreaInfoResultBean.class);
                if(getAreaInfoResultBean!=null&&getAreaInfoResultBean.isIsSuccess()
                        &&getAreaInfoResultBean.getValues().size()!=0){
                    //=======================================================
                    SharedPreferencesUtils.saveInt(context,Constants.AREA_NUM,getAreaInfoResultBean.getTotalCount());
                    for (int i = 0; i < getAreaInfoResultBean.getTotalCount(); i++) {
                        GetAreaInfoResultBean.ValuesBean vb = getAreaInfoResultBean.getValues().get(i);
                        SharedPreferencesUtils.saveInt(context,"areaid"+i,vb.getId());
                        SharedPreferencesUtils.saveString(context,"areaName"+i,vb.getAreaName());
                    }
                    Log.i(Constants.TAG,"AreaInfo 写入完成");
                }
            }
        });

    }

    private void initcockinfoview() {

        btn_post = findViewById(R.id.btn_post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //==============================================
//                Intent intent = new Intent();
//                intent.setAction("com.biatag.cockowner");
//                intent.putExtra("legimgupload","success");
//                UIUtils.getContext().sendBroadcast(intent);
//                hookView.setVisibility(View.VISIBLE);
//                hookView.toggle();
//                Log.i(Constants.TAG,"新增一只斗鸡的广播已经发出去");
                //==============================================

                if (testInfoCorrect()&&testcockskinimgchange()&&testcocklegimgchange()) { //如果信息正确，提交
                    try {
                        upLoadCockBasicInfo();
                        Log.i(Constants.TAG,"basic suc, start img");
                        upLoadCockSkinImage();
                        Log.i(Constants.TAG,"skin  suc, start leg");
                        upLoadCockLegImage();
                        Log.i(Constants.TAG,"leg   suc, finish");

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i("tms","lai dao try catch le ");
                    }
                }
            }
        });
        //skin图像
        RelativeLayout rl_cockimg = findViewById(R.id.rl_cockimg);
        rl_cockimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipHeadDialog clipHeadDialog = new ClipHeadDialog(context,Constants.SKIN_COCK_IMG);
                clipHeadDialog.setOnWheelViewItemClick(new ClipHeadDialog.OnWheelViewItemClick() {
                    @Override   // 通过这个接口 实现了clipHeadDialog 与  本activity之间的数据传递，传递的就是得到照片的方式：在dialog中
                    //选取的到底是拍照获取照片还是从本地选取照片，接口中的intent中就装有这个信息
                    public void onItemClick(Intent intent, int requestCode) {
                        startActivityForResult(intent, requestCode);  //从这之后直接跳看650行代码
                    }
                });
                clipHeadDialog.show();
            }
        });
        TextView tv_skintext = findViewById(R.id.tv_skintext);
        if(GetAttrString.getCock_photo_skin().equals("Leg Photo")){
            tv_skintext.setText("Skin Photo");
        }else {
            tv_skintext.setText(GetAttrString.getCock_photo_skin());
        }

        Log.i(Constants.TAG,"skin is "+GetAttrString.getCock_photo_skin());
        //===leg图像
        RelativeLayout rl_cocklegimg = findViewById(R.id.rl_cocklegimg);
        rl_cocklegimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipHeadDialog clipHeadDialog1 = new ClipHeadDialog(context,Constants.LEG_COCK_IMG);
                clipHeadDialog1.setOnWheelViewItemClick(new ClipHeadDialog.OnWheelViewItemClick() {
                    @Override
                    public void onItemClick(Intent intent, int requestCode) {
                        startActivityForResult(intent,requestCode);
                    }
                });
                clipHeadDialog1.show();
            }
        });
        TextView tv_legtext = findViewById(R.id.tv_legtext);
        tv_legtext.setText(GetAttrString.getCock_Photo_len());
        Log.i(Constants.TAG,"leg is"+ GetAttrString.getCock_Photo_len());
        //=====================================================================================
        RelativeLayout rl_chipnumber_record = findViewById(R.id.rl_chipnumber_record);
        TextView tv_chipnumber_record = rl_chipnumber_record.findViewById(R.id.tv_chipnumber_record);
        tv_chipnumber_revu = rl_chipnumber_record.findViewById(R.id.tv_chipnumber_revu);
        tv_chipnumber_record.setText(GetAttrString.getCock_ChipCode());
        rl_chipnumber_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(RecordCockInfoPartOneActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CAMERA);
                    return;
                }
                Intent intent = new Intent(context, SecondActivity.class);
                startActivityForResult(intent, REQUEST_BARCODE);

//                Intent intent = new Intent(RecordCockInfoPartOneActivity.this,InputCockInfo.class);
//                intent.putExtra("cockinfo",REQUESTCODE_CHIPNUM);
//                startActivityForResult(intent, REQUESTCODE_CHIPNUM);
            }
        });
        //==========================================================================================
        RelativeLayout rl_serialnumber_record = findViewById(R.id.rl_serialnumber_record);
        TextView tv_serialnumber_record = findViewById(R.id.tv_serialnumber_record);
        tv_serialnumber_revu = findViewById(R.id.tv_serialnumber_revu);
        tv_serialnumber_record.setText(GetAttrString.getCock_no());
        rl_serialnumber_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordCockInfoPartOneActivity.this, InputCockInfo.class);
                String oriinfo = tv_serialnumber_revu.getText().toString();
                intent.putExtra("oriinfo", oriinfo);
                intent.putExtra("cockinfo", REQUESTCODE_SERIALNUM);
                startActivityForResult(intent, REQUESTCODE_SERIALNUM);
            }
        });
        //==============================================================================================
        RelativeLayout rl_species = findViewById(R.id.rl_species);
        TextView tv_species = findViewById(R.id.tv_species);
        tv_species_revu = findViewById(R.id.tv_species_revu);
        tv_species.setText(GetAttrString.getCock_breedid());
        rl_species.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(RecordCockInfoPartOneActivity.this, BreedDictAreaActivity.class);
//                String oriinfo = tv_species_revu.getText().toString();//oriinfo 为初始信息的意思
//                intent.putExtra("oriinfo", oriinfo);
//                intent.putExtra("cockinfo", REQUESTCODE_BREEDID);
//                startActivityForResult(intent, REQUESTCODE_BREEDID);
                final List<String> breedList = new ArrayList<String>();
                final List<Integer> breedIdList = new ArrayList<Integer>();
                final int  breedNum = SharedPreferencesUtils.getInt(context, Constants.BREED_NUM,0);
                Log.i("nkk","spic 的breednum is"+ breedNum);
                if(breedNum!=0){
                    for (int i = 0; i < breedNum; i++) {
                        breedList.add(SharedPreferencesUtils.getString(context,"breedName"+(i+1),""));
                        breedIdList.add(SharedPreferencesUtils.getInt(context,"breedid"+(i+1),0));
                    }
                }
                final OptionsPickerView breedNamesOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        String s = breedList.get(options1);
                        tv_species_revu.setText(s);
                        for (int i = 0; i < breedNum; i++) {
                            if(breedList.get(i).equals(s)){
                                breedChosenID = breedIdList.get(i);
                            }
                        }
                    }
                })
                        .setDividerColor(Color.BLACK)
                        .setTextColorCenter(Color.BLACK)
                        .setContentTextSize(20)
                        .setSelectOptions(0)
                        .isDialog(false)
                        .setOutSideCancelable(true)
                        .setSubmitText(GetAttrString.getBasic_confirm())
                        .setCancelText(GetAttrString.getBasic_cancel())
                        .build();
                breedNamesOptions.setPicker(breedList);
                breedNamesOptions.show();

            }
        });
        //===========================================================
        RelativeLayout rl_memo = findViewById(R.id.rl_memo);
        TextView tv_memo = findViewById(R.id.tv_memo);
        tv_memo.setText(GetAttrString.getCock_memo());
        tv_memo_revu = findViewById(R.id.tv_memo_revu);
        rl_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordCockInfoPartOneActivity.this, MemoActivity.class);
                String oriinfo = tv_memo_revu.getText().toString();//
                intent.putExtra("oriinfo", oriinfo);
                intent.putExtra("cockinfo", REQUESTCODE_MEMO);
                startActivityForResult(intent, REQUESTCODE_MEMO);
                overridePendingTransition(R.anim.activity_in_form_right,R.anim.activity_out_to_left);
            }
        });
        //===============================================================================================
        tv_weight_revu = findViewById(R.id.tv_weight_revu);
        RelativeLayout rl_weight = findViewById(R.id.rl_weight);
        rl_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(RecordCockInfoPartOneActivity.this,TimePickerActivity.class);
                // startActivityForResult(intent,REQUESTCODE_TIMEPICKED);
                final RxDialogEditSureCancel rxDialogEditSureCancel = new RxDialogEditSureCancel(context);
                rxDialogEditSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogEditSureCancel.dismiss();

                        //===
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        if(imm.isActive()){
                            imm.hideSoftInputFromInputMethod(v.getWindowToken(),0);
                        }
                        //===

                        String strweight = rxDialogEditSureCancel.getEditText().getText().toString();
                        if(strweight!=null&&strweight.trim().length()>0){
                            tv_weight_revu.setText(strweight+" kg");
                            float s = Float.parseFloat(strweight)*100;
                            orgidweights = (int)s ;
                        }
//                        if(strweight.contains(".")){
//                            String deci = strweight.substring(0,strweight.indexOf("."));
//                            String uni = strweight.substring(strweight.indexOf(".")+1);
//                            int deci_value = Integer.parseInt(deci);
//                            int uni_value = Integer.parseInt(uni);
//                            orgidweight = deci_value*100+uni_value;
//                            Log.d(Constants.TAG,"ordid is "+orgidweight);
//                        }else {
//                             orgidweight = Integer.parseInt(strweight)*100;
//                            Log.d(Constants.TAG,"ordid is "+orgidweight);
//                        }
//                        Log.d(Constants.TAG,"ordid is "+orgidweight);
//                        Toast.makeText(RecordCockInfoPartOneActivity.this, "orgid is "+orgidweight, Toast.LENGTH_SHORT).show();
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
        //===============================================================================================
        RelativeLayout rl_birthday = findViewById(R.id.rl_birthday);
        TextView tv_birthday = findViewById(R.id.tv_birthday);
        tv_birthday_revu = findViewById(R.id.tv_birthday_revu);
        tv_birthday.setText(GetAttrString.getCock_birth());
        rl_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCockBirthdayDialog();
            }
        });

        //============================================================================================================
        cockImg = findViewById(R.id.cockImg);
        cocklegimg = findViewById(R.id.cocklegimg);
        // ============================
        RelativeLayout rl_contest = findViewById(R.id.rl_contest);
        TextView tv_contest = findViewById(R.id.tv_contest);
        tv_contest_revu = findViewById(R.id.tv_contest_revu);
        tv_contest.setText(GetAttrString.getCock_no());
        rl_contest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final OptionsPickerView contestOption = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tv_contest_revu.setText(contestList.get(options1));
                    }
                })
                        .setDividerColor(Color.BLACK)
                        .setTextColorCenter(Color.BLACK)
                        .setContentTextSize(20)
                        .setSelectOptions(0)
                        .isDialog(false)
                        .setOutSideCancelable(true)
                        .setSubmitText(GetAttrString.getBasic_confirm())
                        .setCancelText(GetAttrString.getBasic_cancel())
                        .build();
                contestOption.setPicker(contestList);
                contestOption.show();
            }
        });

//        rl_contest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RecordCockInfoPartOneActivity.this,DerbyListOptionsActivity.class);
//                intent.putStringArrayListExtra("contestlist",contestList);
//                startActivityForResult(intent,REQUESTCODE_DERBYCHOSED);
//            }
//        });
        //===============================
        RelativeLayout rl_motherorg = findViewById(R.id.rl_motherorg);
        RelativeLayout rl_sonorg = findViewById(R.id.rl_sonorg);
        TextView tv_motherorg = findViewById(R.id.tv_motherorg);
        tv_motherorg.setText(GetAttrString.getOrganizatin_parentid());
        tv_motherorg_revu = findViewById(R.id.tv_motherorg_revu);
        TextView tv_sonorg = findViewById(R.id.tv_sonorg);
        tv_sonorg.setText("Federation");
        tv_sonorg_revu = (TextView)findViewById(R.id.tv_sonorg_revu);
        rl_motherorg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final OptionsPickerView motherOrgOption = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        tv_motherorg_revu.setText(motherOrg.get(options1));
                    }
                })
                        .setDividerColor(Color.BLACK)
                        .setTextColorCenter(Color.BLACK)
                        .setContentTextSize(15)
                        .setSelectOptions(0)
                        .isDialog(false)
                        .setOutSideCancelable(true)
                        .setSubmitText(GetAttrString.getBasic_confirm())
                        .setCancelText(GetAttrString.getBasic_cancel())
                        .build();
                motherOrgOption.setPicker(motherOrg);
                motherOrgOption.show();
            }
        });



        rl_sonorg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_motherorg_revu.getText().toString().trim().length()>0){
                    final OptionsPickerView sonorgoption = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            if(tv_motherorg_revu.getText().toString().equals(motherOrg.get(0))){
                                tv_sonorg_revu.setText(sonOrg.get(options1));
                            }else {
                                tv_sonorg_revu.setText(sonOrgs.get(options1));
                            }
//                            //同样的，子机构的显示也要考虑母机构是什么，若为母机构一，则从sonOrg这个list中取
//                            if(tv_motherorg_revu.getText().toString().equals(motherOrg.get(1))){
//
//                            }//  若为母机构二，则从sonOrgs这个list中取

                            //下面的两个for循环用来检测子机构选的是什么，并从sonOrgid或sonOrgsid取对应的id赋值给orgId
                            for (int i = 0; i < sonOrg.size(); i++) {
                                if(tv_sonorg_revu.getText().toString().equals(sonOrg.get(i))){
                                    orgId = sonOrgid.get(i);
                                }
                            }
                            //如果经过上述的循环后orgid 仍为0，则表明没有在第一轮循环中找到子机构，那么继续从第二个list集合中找
                            if(orgId==0){
                                for (int i = 0; i < sonOrgs.size(); i++) {
                                    if(tv_sonorg_revu.getText().toString().equals(sonOrgs.get(i))){
                                        orgId = sonOrgsid.get(i);
                                    }
                                }
                            }
                        }
                    })
                            .setDividerColor(Color.BLACK)
                            .setTextColorCenter(Color.BLACK)
                            .setContentTextSize(15)
                            .isDialog(false)
                            .setOutSideCancelable(true)
                            .setSubmitText(GetAttrString.getBasic_confirm())
                            .setCancelText(GetAttrString.getBasic_cancel())
                            .build();
                    //要依据 motherOrg 的不同，子机构要呈现不同的选择项给用户选择
                    if(tv_motherorg_revu.getText().toString().equals(motherOrg.get(0))){
                        sonorgoption.setPicker(sonOrg);
                    }else if (tv_motherorg_revu.getText().toString().equals(motherOrg.get(1))){
                        sonorgoption.setPicker(sonOrgs);
                    }
                    sonorgoption.show();
                }else {
                    AlertDialog ab;
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("");
                    builder.setMessage(GetAttrString.getFirstmothOrg());
                    builder.setPositiveButton(GetAttrString.getBasic_confirm(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ab = builder.create();
                    ab.show();
                }
            }
        });
    }


    private void showCockBirthdayDialog() {
        Calendar cockBirthday = Calendar.getInstance();
        final TimePickerView timeSelector = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                final String selectDate = DateUtil.shortDate(date);
                String[] s = selectDate.split("-");
                tv_birthday_revu.setText(new StringBuilder().append(s[1]).append("-").append(s[2]).append("-").append(s[0]));
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .isDialog(false)
                .setOutSideCancelable(true)// default is true
                .setDividerColor(Color.BLACK)
                .setContentSize(20)
                .setDate(cockBirthday)
                .setLabel("","","","","","")
                .setSubmitText(GetAttrString.getBasic_confirm())
                .setCancelText(GetAttrString.getBasic_cancel())
                .build();
        timeSelector.show();
    }



    private void inittitlebarview() {
        RelativeLayout titlebar_recordcockinfopartone = findViewById(R.id.titlebar_recordcockinfopartone);

        RelativeLayout rl_back = titlebar_recordcockinfopartone.findViewById(R.id.rl_back);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView activity_title = titlebar_recordcockinfopartone.findViewById(R.id.activity_title);
        RelativeLayout share = titlebar_recordcockinfopartone.findViewById(R.id.share);
        activity_title.setText(GetAttrString.getInputCockInfo());
        share.setVisibility(View.GONE);
        //share 代表的是 Completion 按钮 ，点击completion 按钮后开始上上传信息
        TextView complete = titlebar_recordcockinfopartone.findViewById(R.id.nextstep);
        complete.setText(GetAttrString.getBasic_confirm());
    }

    private void upLoadCockLegImage(){
        final File  file = legfile;
        Log.i(Constants.TAG,"由byte 转来的file 的大小"+ file.length()/1024);
        final Map<String , String> map = new HashMap<>();
        if(result!=null){
            map.put("chipcode",result);
            map.put("type","leg");
            Log.i(Constants.TAG,"chipnum is "+result);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        NewCommmonMethod.getInstance().uploadForm(RecordCockInfoPartOneActivity.this,map,result,file,null,Constants.UPLOAD_PHOTO_URL);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }else {
            Toast.makeText(context, "chipnum is null", Toast.LENGTH_SHORT).show();
        }
    }
    private void upLoadCockSkinImage() {
        final File  file = skinfile;
        Log.i(Constants.TAG,"由byte 转来的file 的大小"+ file.length()/1024);
        final Map<String , String> map = new HashMap<>();
        if(result!=null){
            map.put("chipcode",result);
            map.put("type","skin");
            Log.i(Constants.TAG,"chipnum is "+result);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        NewCommmonMethod.getInstance().uploadForm(RecordCockInfoPartOneActivity.this,map,result,file,null,Constants.UPLOAD_PHOTO_URL);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }else {
            Toast.makeText(context, "chipnum is empty ! ", Toast.LENGTH_SHORT).show();
        }
    }

    private void upLoadCockBasicInfo() throws JSONException {
        JSONObject object = new JSONObject();
//        object.put(Constants.ORGID,orgId);
//        int units = Integer.parseInt(unit);
//        int decimals = Integer.parseInt(decimal);
        object.put(Constants.ORGID,orgidweights);
        object.put(Constants.LASTOWNERID,SharedPreferencesUtils.getInt(context,Constants.ID,1));
        object.put(Constants.CHIPCODE, tv_chipnumber_revu.getText().toString());
        String derbyselected = tv_contest_revu.getText().toString();
        Log.i(Constants.TAG,"得到的derbysele is"+derbyselected);
        String[] derarr = derbyselected.split(",");
        for (int i = 0; i < derarr.length; i++) {
            for (int j = 0; j < contestList.size(); j++) {
                if(derarr[i].equals(contestList.get(j))){
                    derarr[i] = String.valueOf(contestListId.get(j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <derarr.length ; i++) {
            if(i==derarr.length-1){
                sb.append(derarr[i]);
            }else {
                sb.append(derarr[i]);
                sb.append(",");
            }
        }
        String s  = sb.toString();
        Log.i(Constants.TAG,"将要上传的是"+s);
        object.put(Constants.COCKNO, null);
//        object.put(Constants.COCKNO, s);
        object.put(Constants.BREEDID, String.valueOf(breedChosenID));  //给用户显示的斗鸡的品种名字，但是上传时需要的是与此品种对应的id
        object.put(Constants.MEMO, tv_memo_revu.getText().toString());
        object.put(Constants.BIRTH, tv_birthday_revu.getText().toString());
        object.put(Constants.FARMID, SharedPreferencesUtils.getInt(context,Constants.FARMIDLOGIN,0));
        object.put(Constants.CREATORID, SharedPreferencesUtils.getInt(context, Constants.ID, 1));
        final String content = String.valueOf(object);
        Log.i(Constants.TAG, content);
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                addCockInfoResultBean = OkhttpPlusUtil.getInstance().post(Constants. ADD_COCKINFO_URL, content, AddCockInfoResultBean.class);
                if(addCockInfoResultBean!=null&&addCockInfoResultBean.isIsSuccess()){
                    handler.sendEmptyMessage(SUCCESSFUL_POST_COCKINFO);
                }else {
                    handler.sendEmptyMessage(FAILURE_POST_COCKINFO);
                }
            }
        });
    }
    private boolean testInfoCorrect() {
        if(tv_chipnumber_revu.getText().toString().trim().length() > 0 && tv_species_revu.getText().toString().trim()
                .length() > 0 && tv_birthday_revu.getText().toString().trim().length() > 0 && tv_species_revu.getText
                ().toString().trim().length() > 0 && tv_weight_revu.getText().toString().trim().length() > 0 &&
                tv_memo_revu.getText().toString().trim().length() > 0){
            return true;
        }else {
//            Toast.makeText(context, GetAttrString.getCockInfoIncomplete(), Toast.LENGTH_SHORT).show();
            RxToast.warning(context, GetAttrString.getCockInfoIncomplete(), Toast.LENGTH_SHORT, true).show();

            return false;
        }
        
    }
    private boolean testcockskinimgchange(){
        if(!cockImg.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.mipmap.chickenlife).getConstantState())){
            return true;
        }else {
//            Toast.makeText(context, "The Gamefowl's skin picture is empty !", Toast.LENGTH_SHORT).show();
            RxToast.warning(context, "The Gamefowl's skin picture is empty !", Toast.LENGTH_SHORT, true).show();

            return false;
        }

    }
    private boolean testcocklegimgchange(){
        if(!cocklegimg.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.mipmap.chickenlife).getConstantState())){
            return true;
        }else {
//            Toast.makeText(context, "The Gamefowl's leg picture is empty !", Toast.LENGTH_SHORT).show();
            RxToast.warning(context, "The Gamefowl's leg picture is empty !", Toast.LENGTH_SHORT, true).show();

            return false;
        }

    }
    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            return;
        }

        //针对android 7.0 的 拍照
        if(requestCode==HEAD_CAMERA_REQUEST_CODE){
            Bitmap bitmap = null;
            if(data==null||data.getData()==null) return;
            if(data.getStringExtra("imageType").equals(ClipHeadDialog.SKIN_IMG)){
                try {
                    //这里的skinfile 与ClipHeadActivity 中的SDPATH 是同一个文件
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(FileUtils.getUriForFile(context,skinfile)));
                    cockImg.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else if(data.getStringExtra("imageType").equals(ClipHeadDialog.LEG_IMG)) {
                try {
                    //这里的legfile 与 ClipHeadActivity 中的SDPATHLEG 是同一个文件
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(FileUtils.getUriForFile(context,legfile)));
                    cocklegimg.setImageBitmap(bitmap );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        //针对android 7.0 的 从图库选择
        if(requestCode == HEAD_IMAGE_REQUEST_CODE){
            Bitmap bitmap = null;
            if(data==null||data.getData()==null) return;
            if(data.getStringExtra("imageType").equals(ClipHeadDialog.SKIN_IMG)){
                try {
                    //这里的skinfile 与ClipHeadActivity 中的SDPATH 是同一个文件
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(FileUtils.getUriForFile(context,skinfile)));
                    cockImg.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else if(data.getStringExtra("imageType").equals(ClipHeadDialog.LEG_IMG)){
                try {
                    //这里的legfile 与 ClipHeadActivity 中的SDPATHLEG 是同一个文件
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(FileUtils.getUriForFile(context,legfile)));
                    cocklegimg.setImageBitmap(bitmap );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        //==============================================================================================================
        //指定Uri ，这个uri类型的cameraImgUri 当然与ClipHeadDialog.java 的91 行代码指定的那个Uri类型的outputImage 相同啦，代表的是同一个文件
        //总体过程是：从相册选取图片后返回后由startPhotoZoom()进入切图页面
        Uri cameraImgUri;
        if (requestCode == ClipHeadDialog.IMAGE_REQUEST_CODE || requestCode == ClipHeadDialog.SELECT_PIC_KITKAT) {
            if (data == null || data.getData() == null) {
                return;
            } else {

                if(Build.VERSION.SDK_INT>=24){
                    //如果是7.0 的系统走NewCommonmethod中的方法
                    NewCommmonMethod.getInstance().startPhotoZoom(this,data.getData(),"modify",1,2);
                }else {
                    //7.0 以下的手机走以下代码
                    Uri uri = data.getData();//相册选取图片后返回的 intent类型的data里 装有刚才在本地所选取的那张图片的Uri
                    Log.i(Constants.TAG,"uri of the pic choosed from album is"+ uri.toString());
                    cameraImgUri = FileUtils.getUriForFile(context,skinfile);
                    Log.i(Constants.TAG,"the target file's uri is  "+ cameraImgUri.toString());
                    Intent intent = new Intent("com.android.camera.action.CROP");//指定剪切的动作
                    if(Build.VERSION.SDK_INT>=24){
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    }
                    intent.setDataAndType(uri, "image/*"); //指定要操作的数据（通过Uri来告诉系统改图片的位置）以及该数据的数据类型
                    intent.putExtra("crop", true);

                    // 裁剪框的比例，1：1，如果是华为手机的话，设置特定参数方可是切图为正方形
                    if(Build.MANUFACTURER.contains("HUAWEI")){
                        intent.putExtra("aspectX",9998);
                        intent.putExtra("aspectY",9999);
                        Log.i(Constants.TAG,"this is huawei phone");
                    }else {
                        intent.putExtra("aspectX", 1);
                        intent.putExtra("aspectY", 1);
                        Log.i(Constants.TAG,"this is not huawei phone");
                    }
                    // 裁剪后输出图片的尺寸大小
                    intent.putExtra("outputX", 300);
                    intent.putExtra("outputY", 300);
                    //输出的图片格式
                    intent.putExtra("outputFormat","JPEG");
                    intent.putExtra("noFaceDetection",true);
                    intent.putExtra("scale", false);
                    intent.putExtra("return-data", false); // true:不反回uri; false : 返回uri
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraImgUri);  //将uri 指向的文件进行裁剪后放入cameraimguri 指向的文件
//                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);  //将uri 指向的文件进行裁剪后放入cameraimguri 指向的文件
                    Log.i(Constants.TAG,"skin===cameraimguri is "+ cameraImgUri.toString());

                    startActivityForResult(intent, GALLERY_PHOTO_CROP);
                }

            }
        }
        //==
        if(requestCode==ClipHeadDialog.IMAGE_REQUEST_CODE_LEG||requestCode==ClipHeadDialog.SELECT_PIC_KITKAT_LEG){
            if(data==null||data.getData()==null){
                return;
            }else {
                if(Build.VERSION.SDK_INT>=24){
                    NewCommmonMethod.getInstance().startPhotoZoom(this,data.getData(),"modify",2,2);
                }else {
                    Uri urileg = data.getData();
                    cameraImgUri = FileUtils.getUriForFile(context,legfile);
                    Log.i(Constants.TAG,"album leg cameraImgUri is "+ cameraImgUri);
                    Intent intent = new Intent("com.android.camera.action.CROP");//指定剪切的动作
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    intent.setDataAndType(urileg, "image/*"); //指定要操作的数据（通过Uri来告诉系统改图片的位置）以及该数据的数据类型
                    intent.putExtra("crop", true);
                    // 裁剪框的比例，1：1
                    if(Build.MANUFACTURER.contains("HUAWEI")){
                        intent.putExtra("aspectX",9998);
                        intent.putExtra("aspectY",9999);
                    }else {

                        intent.putExtra("aspectX", 1);
                        intent.putExtra("aspectY", 1);
                    }
                    // 裁剪后输出图片的尺寸大小
                    intent.putExtra("outputX", 300);
                    intent.putExtra("outputY", 300);
                    //输出的图片格式
                    intent.putExtra("outputFormat","JPEG");
                    intent.putExtra("noFaceDetection",true);
                    intent.putExtra("scale", false);
                    intent.putExtra("return-data", false); // true:不反回uri; false : 返回uri
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraImgUri);
                    Log.i(Constants.TAG,"daozhele=============");
                    startActivityForResult(intent,GALLERY_PHOTO_CROP_LEG);
                }

            }
        }
        //==
        if(requestCode==ClipHeadDialog.LEG_CAMERA_REQUEST_CODE){
            if(Build.VERSION.SDK_INT>=24){
                cameraImgUri = Uri.fromFile(legfile);
                NewCommmonMethod.getInstance().startPhotoZoom(this, cameraImgUri,"modify",2,1);
            }else {
                cameraImgUri = FileUtils.getUriForFile(context,legfile);
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(cameraImgUri, "image/*"); // cameraImgUri所代表的文件中现在已经写入了拍照时所得到的数据
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                intent.putExtra("crop",true);

                if(Build.MANUFACTURER.contains("HUAWEI")){
                    intent.putExtra("aspectX",9998);
                    intent.putExtra("aspectY",9999);
                    Log.i(Constants.TAG,"this is huawei phone");
                }else {
                    intent.putExtra("aspectX", 1);
                    intent.putExtra("aspectY", 1);
                    Log.i(Constants.TAG,"this isn't huawei phone");
                }
                intent.putExtra("outputX", 300);
                intent.putExtra("outputY", 300);
                //输出的图片格式
                intent.putExtra("outputFormat","JPEG");
                intent.putExtra("noFaceDetection",true);
                intent.putExtra("scale", false);
                intent.putExtra("return-data", false); // true:不返回uri; false : 返回uri
                intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraImgUri); // 指定裁剪后得到的照片数据依然放回cameraImgUri中
                startActivityForResult(intent,CAMERA_PHOTO_CROP_LEG);
            }

        }
        //从拍照的界面得到图片后返回，，这时候cameraImgUri代表的的文件中已经有数据了,然后又startPhotoZoom()方法进入切图界面
        if (requestCode == ClipHeadDialog.SKIN_CAMERA_REQUEST_CODE) {
            if(Build.VERSION.SDK_INT>=24&&Build.MANUFACTURER.contains("HUAWEI")){
                cameraImgUri = Uri.fromFile(skinfile);
                NewCommmonMethod.getInstance().startPhotoZoom(this, cameraImgUri,"modify",1,1);
            }else {
                cameraImgUri = FileUtils.getUriForFile(context,skinfile);
                Log.i(Constants.TAG,"cameraImgUri's path is  "+ cameraImgUri.toString());
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(cameraImgUri, "image/*"); // cameraImgUri所代表的文件中现在已经写入了拍照时所得到的数据
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                intent.putExtra("crop",true);
                if(Build.MANUFACTURER.contains("HUAWEI")){
                    intent.putExtra("aspectX",9998);
                    intent.putExtra("aspectY",9999);
                    Log.i(Constants.TAG,"this is huawei phone");
                }else {
                    intent.putExtra("aspectX", 1);
                    intent.putExtra("aspectY", 1);
                    Log.i(Constants.TAG,"this isn't huawei phone");
                }
                intent.putExtra("outputX", 300);
                intent.putExtra("outputY", 300);
                //输出的图片格式
                intent.putExtra("outputFormat","JPEG");
                intent.putExtra("noFaceDetection",true);
                intent.putExtra("scale", false);
                intent.putExtra("return-data", false); // true:不返回uri; false : 返回uri
                intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraImgUri); // 指定裁剪后得到的照片数据依然放回cameraImgUri中
                startActivityForResult(intent, CAMERA_PHOTO_CROP_SKIN);
            }


        }
        if(requestCode == CAMERA_PHOTO_CROP_LEG&&resultCode == RESULT_OK){
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(FileUtils.getUriForFile(context,legfile)));
//                try {
//                    File skinimg = FileUtils.from(context,cameraImgUri);
//                    Toast.makeText(context, String.format("Size : %s",getReadableFileSize(skinimg.length())), Toast.LENGTH_SHORT).show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            cocklegimg.setImageBitmap(bitmap);
//            legfilepath  = NewCommmonMethod.getInstance().cutPictureQuality(bitmap,Constants.HEADIMG_FILEDIRECTORY);
//            Log.i(Constants.TAG,"legfilepath is "+legfilepath );
        }
        //从切图界面返回后运行此方法：从对照相机拍摄的skin图片进行剪裁后返回
        if (requestCode == CAMERA_PHOTO_CROP_SKIN) {
            if (resultCode == RESULT_OK) {
                Bitmap bitmap = null;
                try {
                    // 剪裁后的照片数据就在cameraImgUri所代表的文件中，从该文件中得到输入流，BitmapFactory 解析这个输入流得到bitmap
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(FileUtils.getUriForFile(context,skinfile)));
//                    bitmap = BitmapFactory.decodeFile(skinfile);//   这句代码貌似也可以获取到bitmap
//                    long bitmapSize = bitmap.getRowBytes()*bitmap.getHeight();
//                    long s = bitmapSize/1024;
////                    Toast.makeText(context, "bitmap 的大小是"+s+"KB", Toast.LENGTH_SHORT).show();
//                    try {
//                        File acturalImg = FileUtils.from(context, cameraImgUri);
//                        Toast.makeText(context, String.format("Size : %s", getReadableFileSize(acturalImg.length())), Toast.LENGTH_SHORT).show();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                cockImg.setImageBitmap(bitmap); //将得到的照片显示出来
                //=================================================================
//                Log.i(Constants.TAG,"daozhele");
//                filePath = NewCommmonMethod.getInstance().cutPictureQuality(bitmap,Constants.HEADIMG_FILEDIRECTORY);
//                Log.i(Constants.TAG,"filepath is "+filePath );
//                final File  file = new File(filePath);
//                Log.i(Constants.TAG,"由byte 转来的file 的大小"+ file.length()/1024);
//                final Map<String , String> map = new HashMap<>();
//                if(result!=null){
//                    map.put("chipcode",result);
//                    Log.i(Constants.TAG,"chipnum is "+result);
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                NewCommmonMethod.getInstance().uploadForm(map,result,file,null,Constants.UPLOAD_PHOTO_URL);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();
//                }else {
//                    Toast.makeText(context, "chipnum is null", Toast.LENGTH_SHORT).show();
//                }

                //

            }
        }
        //从切图界面返回后运行此方法:从对本地所选取的图片进行剪裁后返回
        if (requestCode == GALLERY_PHOTO_CROP) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Bitmap bitmap = null;
                    try {
                        //同样的intent 类型的data里 装有裁剪后所得到照片的Uri，从这个Uri所代表的文件得到输入流，经BitmapFactory解析得到bitmap
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(FileUtils.getUriForFile(context,skinfile)));
//                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(data.getData()));
//                        try {
//                            File acturalImg = FileUtils.from(context, data.getData());
//                            Toast.makeText(context, String.format("Size : %s", getReadableFileSize(acturalImg.length())), Toast.LENGTH_SHORT).show();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    cockImg.setImageBitmap(bitmap);
                    //cutPictureQuality()方法对图像进行压缩，并返回压缩后的图片的uri
//                    filePath = NewCommmonMethod.getInstance().cutPictureQuality(bitmap,Constants.HEADIMG_FILEDIRECTORY);
                    //===============================================================
//
                }
            }
        }
        //========
        if(requestCode==GALLERY_PHOTO_CROP_LEG&&resultCode==RESULT_OK){
            if(data!=null&&data.getData()!=null){
                Log.i(Constants.TAG,"daozhele ====");
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(FileUtils.getUriForFile(context,legfile)));
//                    try {
//                        File acturalImg = FileUtils.from(context,data.getData());
//                        Toast.makeText(context, String.format("Size : %s",getReadableFileSize(acturalImg.length())), Toast.LENGTH_SHORT).show();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                cocklegimg.setImageBitmap(bitmap);
//                legfilepath =  NewCommmonMethod.getInstance().cutPictureQuality(bitmap,Constants.HEADIMG_FILEDIRECTORY);
            }
        }
        //==========================================================================================
        if (requestCode == REQUESTCODE_CHIPNUM) {
            if (resultCode == RESULT_OK) {
                String chipnum = data.getStringExtra("cockinforeturn");
                if (chipnum != null && chipnum.trim().length() > 0) {
                    tv_chipnumber_revu.setText(chipnum);
                    Log.i(Constants.TAG,"chipnum is "+ chipnum);
                }
            }
        }
        if (requestCode == REQUESTCODE_SERIALNUM) {
            if (resultCode == RESULT_OK) {
                final String serialnum = data.getStringExtra("cockinforeturn");
                if (serialnum != null && serialnum.trim().length() > 0) {
                    Log.i(Constants.TAG,"prepare to check the cockno.");
                    ThreadManager.getInstance().execute(new Runnable() {
                        @Override
                        public void run() {
                            String requl = Constants.COCKNO_ISAVAILABLE_URL;
                            requl = GetJson.replace(requl,"{strQuery}",serialnum);
                            cockNoVerificationResultBean=OkhttpPlusUtil.getInstance().get(requl,CockNoVerificationResultBean.class);
                            if(cockNoVerificationResultBean.isIsSuccess()){
                                Message message = Message.obtain();
                                message.what = Constants.AVAILABLE_COCKNO;
                                Bundle bundle = new Bundle();
                                bundle.putString("serialnum",serialnum);
                                message.setData(bundle);
                                handler.sendMessage(message);
                            }else {
                                Message message = new Message();
                                message.what = Constants.UNAVAILABLE_COCKNO;
                                Bundle bundle = new Bundle();
                                bundle.putString("serialnum",serialnum);
                                handler.sendMessage(message);
                            }
                        }
                    });

                }
            }
        }
        if (requestCode == REQUESTCODE_BREEDID) {
            if (resultCode == RESULT_OK) {
                String breedname = data.getStringExtra("cockinforeturn_breedname");
                if (breedname != null && breedname.trim().length() > 0) {
                    tv_species_revu.setText(breedname);
                }
            }
        }
        if (requestCode == REQUESTCODE_MEMO && resultCode == RESULT_OK) {
            String memoinfo = data.getStringExtra("cockinforeturn");
            if (memoinfo != null && memoinfo.trim().length() > 0) {
                tv_memo_revu.setText(memoinfo);
            }
        }

        if(requestCode==REQUESTCODE_TIMEPICKED && resultCode == RESULT_OK){
            unit = data.getStringExtra("unit");
            decimal = data.getStringExtra("decimal");
            orgidweight = data.getIntExtra("orgid",0);
            tv_weight_revu.setText(unit+"."+decimal+" kg");


        }

//        if(requestCode == REQUESTCODE_DERBYCHOSED && resultCode == RESULT_OK){
//            String derbyselected = data.getStringExtra("derbyselected");
//            if(derbyselected!=null&&derbyselected.trim().length()>0){
//                tv_contest_revu.setText(derbyselected);
//            }
//        }

        //=================================================================
        if (requestCode == REQUEST_BARCODE && resultCode == RESULT_OK) {
            if (data != null) {
                final Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    result = bundle.getString(CodeUtils.RESULT_STRING);
                    Log.i(Constants.TAG,"chipcode is"+result);
                    //===========================================================================

                    //===========================================================================
                    ThreadManager.getInstance().execute(new Runnable() {
                        @Override
                        public void run() {
                            String requl = Constants.CHIPCODE_ISAVAILABLE_URL;
                            requl = GetJson.replace(requl,"{strQuery}",result);
                            chipCodeVerificationResultBean=OkhttpPlusUtil.getInstance().get(requl, ChipCodeVerificationResultBean.class);
                            if(chipCodeVerificationResultBean!=null){
                                Message message = Message.obtain();
                                if(chipCodeVerificationResultBean.isIsSuccess()){
                                    message.what = Constants.AVAILABLE_CHIPCODE;
                                    Bundle bundle1 = new Bundle();
                                    bundle1.putString("result",result);
                                    message.setData(bundle1);
                                    handler.sendMessage(message);
                                }else {
                                    message.what = Constants.UNAVAILABLE_CHIPCODE;
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("result",result);
                                    message.setData(bundle2);
                                    handler.sendMessage(message);
                                }
                            }
                        }
                    });

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(context, getResources().getString(R.string.decodefailure), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public String getReadableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        handler.removeCallbacksAndMessages(null);
    }

    class MyLegimguploadinfoReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction()!=null&&intent.getAction().equals("com.biatag.cockowner")){
                Log.i(Constants.TAG,"the broadcast that a new cock addition has been received");
                String result = intent.getStringExtra("legimgupload");
                if(result.equals("success")){
                    EventBus.getDefault().post("refreshcocklist");
                    Log.i(Constants.TAG,"eventbus has send the message that a new cock addition");
                    handler.sendEmptyMessage(NOW_CAN_CLOSE_AC);
                }
            }
        }
    }
}
