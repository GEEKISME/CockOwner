package com.biotag.cockowner.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.biotag.cockowner.JavaBean.ContestBean;
import com.biotag.cockowner.JavaBean.GetBreedDictionValueBean;
import com.biotag.cockowner.JavaBean.GetXmlResultBean;
import com.biotag.cockowner.JavaBean.LogininfoBean;
import com.biotag.cockowner.JavaBean.XmlBean;
import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.manager.ThreadManager;
import com.biotag.cockowner.utils.GetJson;
import com.biotag.cockowner.utils.MobclickAgentWrapper;
import com.biotag.cockowner.utils.NetCheckUtil;
import com.biotag.cockowner.utils.OkhttpPlusUtil;
import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends UserBaseActivity implements View.OnClickListener {

    private int[] datas = new int[1024*1024*5];


    //
    private String dictionaryvalue;
    private GetBreedDictionValueBean appconfigresultbean = null;
    private GetXmlResultBean getXmlResultBean = null;
    //
    private LogininfoBean logininfoBean = null;
    private Button btn_login;
    private EditText et_username,et_password;
    private Map<String,String> loginInfoMap = new HashMap();
    private Context context = this;
    private int i = -1;
    //
    private ContestBean contestBean = null;
    private SweetAlertDialog sweetAlertDialog;
    private ArrayList<String> contestList = new ArrayList<>();
    private ImageView iv_clean_phone,clean_password,iv_show_pwd;

    static class LoginHandler extends Handler{
        private WeakReference<LoginActivity> loginActivityWeakReference ;
        public LoginHandler(LoginActivity loginActivity){
            loginActivityWeakReference = new WeakReference<LoginActivity>(loginActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LoginActivity loginActivity = loginActivityWeakReference.get();
            if(loginActivity!=null){
                switch (msg.what){
                    case Constants.MANI_USELESS:
                        loginActivity.showLoading(false);
//                        Toast.makeText(loginActivity,GetAttrString.getDB_PROC_owners_login_msg_0(), Toast.LENGTH_SHORT).show();
                        RxToast.success(loginActivity, GetAttrString.getDB_PROC_owners_login_msg_0(), Toast.LENGTH_SHORT, true).show();
                        loginActivity.openScanningActvity();
                        loginActivity.finish();
                        break;
                    case Constants.MANI_SUC:
                        loginActivity.showLoading(false);
                        //                        Toast.makeText(loginActivity,GetAttrString.getDB_PROC_owners_login_msg_0(), Toast.LENGTH_SHORT).show();
                        RxToast.success(loginActivity, GetAttrString.getDB_PROC_owners_login_msg_0(), Toast.LENGTH_SHORT, true).show();

                        loginActivity.openScanningActvity();
                        loginActivity.finish();
                        break;
                    case Constants.LOGIN_SUCCESS:

                        loginActivity.saveLoginInfo();
                        //用户名密码验证成功后，开始下载配置文件
                        loginActivity.getDictionaryVersion();//加载页面之后立即获取appconfig 文件，若果需要那么就获取xml的中英对照表，
                        break;
                    case Constants.LOGIN_FAIL:
                        loginActivity.showLoading(false);
//                        Toast.makeText(loginActivity, GetAttrString.getDB_PROC_owners_login_msg_2(), Toast.LENGTH_SHORT).show();
                        RxToast.error(loginActivity, GetAttrString.getDB_PROC_owners_login_msg_2(), Toast.LENGTH_SHORT, true).show();
                        break;
                    case Constants.LOGIN_FAIL_NONET:
                        loginActivity.showLoading(false);
                        //                        Toast.makeText(loginActivity, "Poor network condition,login failuer !", Toast.LENGTH_SHORT).show();
                        RxToast.error(loginActivity, "Poor network,login failed !", Toast.LENGTH_SHORT, true).show();


                }
            }
        }
    }

    private LoginHandler handler = new LoginHandler(this);

//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case Constants.MANI_USELESS:
//                    showLoading(false);
//                    Toast.makeText(context,GetAttrString.getDB_PROC_owners_login_msg_0(), Toast.LENGTH_SHORT).show();
//                    openScanningActvity();
//                    finish();
//                    break;
//                case Constants.MANI_SUC:
//                    showLoading(false);
//                    Toast.makeText(context,GetAttrString.getDB_PROC_owners_login_msg_0(), Toast.LENGTH_SHORT).show();
//                    openScanningActvity();
//                    finish();
//                    break;
//                case Constants.LOGIN_SUCCESS:
//
//                    saveLoginInfo();
//                    //用户名密码验证成功后，开始下载配置文件
//                    getDictionaryVersion();//加载页面之后立即获取appconfig 文件，若果需要那么久获取xml的中英对照表，
//                    break;
//                case Constants.LOGIN_FAIL:
//                    showLoading(false);
//                    Toast.makeText(LoginActivity.this, GetAttrString.getDB_PROC_owners_login_msg_2(), Toast.LENGTH_SHORT).show();
//                    break;
//                case Constants.LOGIN_FAIL_NONET:
//                    showLoading(false);
//                    Toast.makeText(context, "Poor network condition,login failuer !", Toast.LENGTH_SHORT).show();
//
//            }
//            super.handleMessage(msg);
//
//        }
//    };

    private void getDictionaryVersion() {
        dictionaryvalue = SharedPreferencesUtils.getString(LoginActivity.this,Constants.DICTIONARYVERSION,"");
        Log.i(Constants.TAG,"the  code from local is "+dictionaryvalue);
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                appconfigresultbean=OkhttpPlusUtil.getInstance().get(Constants.DICTIONARY_VERSION_URL, GetBreedDictionValueBean.class);
                if(appconfigresultbean!=null&&appconfigresultbean.isIsSuccess()){
                    String value = appconfigresultbean.getValues();
                    Log.i(Constants.TAG,"the version code from server is"+value);
                    if(!value.equals(dictionaryvalue)){//如果版本号不一致，则1、将本地版本号更新；2、下载新的xml中英对比文件
                        SharedPreferencesUtils.saveString(LoginActivity.this,Constants.DICTIONARYVERSION,value);//1. 将新的版本号存入本地
                        //去下载新的xml 文件
                        String requl = Constants.DICTIONARYXML_URL;
                        getXmlResultBean=OkhttpPlusUtil.getInstance().get(requl, GetXmlResultBean.class);
                        if(getXmlResultBean!=null&&getXmlResultBean.getValues()!=null){
                            String values = getXmlResultBean.getValues();
                            XmlBean xmlBean = new Gson().fromJson(values,XmlBean.class);
                            if(xmlBean!=null){
                                Log.i(Constants.TAG,xmlBean.getDictionary().getCocks().getChipCode().getCN());
                                saveXmlContentIntoSharePreference(xmlBean);
                                handler.sendEmptyMessage(Constants.MANI_SUC);
                            }
                        }else {
                            handler.sendEmptyMessage(Constants.LOGIN_FAIL_NONET);
                        }
                    }else {
                        Log.i(Constants.TAG,"we needn't to acquire XML");
                        handler.sendEmptyMessage(Constants.MANI_USELESS);
                    }
                }
            }
        });
    }

    private void saveXmlContentIntoSharePreference(XmlBean xmlbean) {
        //存储APP的版本号
        SharedPreferencesUtils.saveString(context,"appversioncode",xmlbean.getDictionary().getVersion().getNo());
        //存储cock
        SharedPreferencesUtils.saveString(context,"cock_chipcode_CN",xmlbean.getDictionary().getCocks().getChipCode().getCN());
        SharedPreferencesUtils.saveString(context,"cock_chipcode_EN",xmlbean.getDictionary().getCocks().getChipCode().getEN());
        SharedPreferencesUtils.saveString(context,"cock_cockno_CN",xmlbean.getDictionary().getCocks().getCockNo().getCN());
        SharedPreferencesUtils.saveString(context,"cock_cockno_EN",xmlbean.getDictionary().getCocks().getCockNo().getEN());
        SharedPreferencesUtils.saveString(context,"cock_breedID_CN",xmlbean.getDictionary().getCocks().getBreedID().getCN());
        SharedPreferencesUtils.saveString(context,"cock_breedID_EN",xmlbean.getDictionary().getCocks().getBreedID().getEN());
        SharedPreferencesUtils.saveString(context,"cock_memo_CN",xmlbean.getDictionary().getCocks().getMemo().getCN());
        SharedPreferencesUtils.saveString(context,"cock_memo_EN",xmlbean.getDictionary().getCocks().getMemo().getEN());
        SharedPreferencesUtils.saveString(context,"cock_birth_CN",xmlbean.getDictionary().getCocks().getBirth().getCN());
        SharedPreferencesUtils.saveString(context,"cock_birth_EN",xmlbean.getDictionary().getCocks().getBirth().getEN());
        SharedPreferencesUtils.saveString(context,"cock_org_CN",xmlbean.getDictionary().getCocks().getOrg().getCN());
        SharedPreferencesUtils.saveString(context,"cock_org_EN",xmlbean.getDictionary().getCocks().getOrg().getEN());

        SharedPreferencesUtils.saveString(context,"cock_orgid_CN",xmlbean.getDictionary().getCocks().getOrgID().getCN());
        SharedPreferencesUtils.saveString(context,"cock_orgid_EN",xmlbean.getDictionary().getCocks().getOrgID().getEN());
        SharedPreferencesUtils.saveString(context,"cock_cstatus_CN",xmlbean.getDictionary().getCocks().getCStatus().getCN());
        SharedPreferencesUtils.saveString(context,"cock_cstatus_EN",xmlbean.getDictionary().getCocks().getCStatus().getEN());
        SharedPreferencesUtils.saveString(context,"cock_farmid_CN",xmlbean.getDictionary().getCocks().getFarmID().getCN());
        SharedPreferencesUtils.saveString(context,"cock_farmid_EN",xmlbean.getDictionary().getCocks().getFarmID().getEN());
        SharedPreferencesUtils.saveString(context,"cock_photo_len_CN",xmlbean.getDictionary().getCocks().getPhoto_len().getCN());
        SharedPreferencesUtils.saveString(context,"cock_photo_len_EN",xmlbean.getDictionary().getCocks().getPhoto_len().getEN());
        SharedPreferencesUtils.saveString(context,"cock_photo_skin_CN",xmlbean.getDictionary().getCocks().getPhoto_skin().getCN());
        SharedPreferencesUtils.saveString(context,"cock_photo_skin_EN",xmlbean.getDictionary().getCocks().getPhoto_skin().getEN());
        SharedPreferencesUtils.saveString(context,"cock_creatorid_CN",xmlbean.getDictionary().getCocks().getCreatorid().getCN());
        SharedPreferencesUtils.saveString(context,"cock_creatorid_EN",xmlbean.getDictionary().getCocks().getCreatorid().getEN());
        SharedPreferencesUtils.saveString(context,"cock_creatorat_CN",xmlbean.getDictionary().getCocks().getCreateAt().getCN());
        SharedPreferencesUtils.saveString(context,"cock_creatorat_EN",xmlbean.getDictionary().getCocks().getCreateAt().getEN());
        SharedPreferencesUtils.saveString(context,"cock_lastownerid_CN",xmlbean.getDictionary().getCocks().getLastOwnerID().getCN());
        SharedPreferencesUtils.saveString(context,"cock_lastownerid_EN",xmlbean.getDictionary().getCocks().getLastOwnerID().getEN());
        SharedPreferencesUtils.saveString(context,"cock_regdate1_CN",xmlbean.getDictionary().getCocks().getRegDate1().getCN());
        SharedPreferencesUtils.saveString(context,"cock_regdate1_EN",xmlbean.getDictionary().getCocks().getRegDate1().getEN());
        SharedPreferencesUtils.saveString(context,"cock_regdate2_CN",xmlbean.getDictionary().getCocks().getRegDate2().getCN());
        SharedPreferencesUtils.saveString(context,"cock_regdate2_EN",xmlbean.getDictionary().getCocks().getRegDate2().getEN());
        SharedPreferencesUtils.saveString(context,"cock_regdate3_CN",xmlbean.getDictionary().getCocks().getRegDate3().getCN());
        SharedPreferencesUtils.saveString(context,"cock_regdate3_EN",xmlbean.getDictionary().getCocks().getRegDate3().getEN());
        SharedPreferencesUtils.saveString(context,"cock_isimport_CN",xmlbean.getDictionary().getCocks().getIsImport().getCN());
        SharedPreferencesUtils.saveString(context,"cock_isimport_EN",xmlbean.getDictionary().getCocks().getIsImport().getEN());
        SharedPreferencesUtils.saveString(context,"cock_importerid_CN",xmlbean.getDictionary().getCocks().getImporterID().getEN());
        SharedPreferencesUtils.saveString(context,"cock_importerid_EN",xmlbean.getDictionary().getCocks().getImporterID().getEN());
        //存储owners
        SharedPreferencesUtils.saveString(context,"owners_ownername_CN",xmlbean.getDictionary().getOwners().getOwnerName().getCN());
        SharedPreferencesUtils.saveString(context,"owners_ownername_EN",xmlbean.getDictionary().getOwners().getOwnerName().getEN());
        SharedPreferencesUtils.saveString(context,"owners_otitle_CN",xmlbean.getDictionary().getOwners().getOTitle().getCN());
        SharedPreferencesUtils.saveString(context,"owners_otitle_EN",xmlbean.getDictionary().getOwners().getOTitle().getEN());
        SharedPreferencesUtils.saveString(context,"owners_oaddress_CN",xmlbean.getDictionary().getOwners().getOTitle().getCN());
        SharedPreferencesUtils.saveString(context,"owners_oaddress_EN",xmlbean.getDictionary().getOwners().getOTitle().getEN());
        SharedPreferencesUtils.saveString(context,"owners_otel_CN",xmlbean.getDictionary().getOwners().getOTel().getCN());
        SharedPreferencesUtils.saveString(context,"owners_otel_EN",xmlbean.getDictionary().getOwners().getOTel().getEN());
        SharedPreferencesUtils.saveString(context,"owners_oidno_EN",xmlbean.getDictionary().getOwners().getOIDNo().getCN());
        SharedPreferencesUtils.saveString(context,"owners_oidno_CN",xmlbean.getDictionary().getOwners().getOIDNo().getEN());
        SharedPreferencesUtils.saveString(context,"owners_owndate_CN",xmlbean.getDictionary().getOwners().getOwnDate().getCN());
        SharedPreferencesUtils.saveString(context,"owners_owndate_EN",xmlbean.getDictionary().getOwners().getOwnDate().getEN());
        SharedPreferencesUtils.saveString(context,"owners_odictionid_CN",xmlbean.getDictionary().getOwners().getODictionID().getCN());
        SharedPreferencesUtils.saveString(context,"owners_odictionid_EN",xmlbean.getDictionary().getOwners().getODictionID().getEN());
        SharedPreferencesUtils.saveString(context,"owners_ispersonal_CN",xmlbean.getDictionary().getOwners().getIsPersonal().getCN());
        SharedPreferencesUtils.saveString(context,"owners_ispersonal_EN",xmlbean.getDictionary().getOwners().getIsPersonal().getEN());
        SharedPreferencesUtils.saveString(context,"owners_farmid_CN",xmlbean.getDictionary().getOwners().getFarmid().getCN());
        SharedPreferencesUtils.saveString(context,"owners_farmid_EN",xmlbean.getDictionary().getOwners().getFarmid().getEN());
        SharedPreferencesUtils.saveString(context,"owners_username_CN",xmlbean.getDictionary().getOwners().getUsername().getCN());
        SharedPreferencesUtils.saveString(context,"owners_username_EN",xmlbean.getDictionary().getOwners().getUsername().getEN());
        SharedPreferencesUtils.saveString(context,"owners_password_CN",xmlbean.getDictionary().getOwners().getUsername().getCN());
        SharedPreferencesUtils.saveString(context,"owners_password_EN",xmlbean.getDictionary().getOwners().getUsername().getEN());
        //===存储organization
        SharedPreferencesUtils.saveString(context,"organizatin_orgname_CN",xmlbean.getDictionary().getOrganization().getOrgName().getCN());
        SharedPreferencesUtils.saveString(context,"organizatin_orgname_EN",xmlbean.getDictionary().getOrganization().getOrgName().getEN());
        SharedPreferencesUtils.saveString(context,"organizatin_gaddress_CN",xmlbean.getDictionary().getOrganization().getGAddress().getCN());
        SharedPreferencesUtils.saveString(context,"organizatin_gaddress_EN",xmlbean.getDictionary().getOrganization().getGAddress().getEN());
        SharedPreferencesUtils.saveString(context,"organizatin_gtel_CN",xmlbean.getDictionary().getOrganization().getGTel().getCN());
        SharedPreferencesUtils.saveString(context,"organizatin_gtel_EN",xmlbean.getDictionary().getOrganization().getGTel().getEN());
        SharedPreferencesUtils.saveString(context,"organizatin_gcontactor_CN",xmlbean.getDictionary().getOrganization().getGContactor().getCN());
        SharedPreferencesUtils.saveString(context,"organizatin_gcontactor_EN",xmlbean.getDictionary().getOrganization().getGContactor().getEN());
        SharedPreferencesUtils.saveString(context,"organizatin_gtitle_CN",xmlbean.getDictionary().getOrganization().getGTitle().getCN());
        SharedPreferencesUtils.saveString(context,"organizatin_gtitle_EN",xmlbean.getDictionary().getOrganization().getGTitle().getEN());
        SharedPreferencesUtils.saveString(context,"organizatin_gcode_CN",xmlbean.getDictionary().getOrganization().getGCode().getCN());
        SharedPreferencesUtils.saveString(context,"organizatin_gcode_EN",xmlbean.getDictionary().getOrganization().getGCode().getEN());
        SharedPreferencesUtils.saveString(context,"organizatin_parentid_CN",xmlbean.getDictionary().getOrganization().getParentID().getCN());
        SharedPreferencesUtils.saveString(context,"organizatin_parentid_EN",xmlbean.getDictionary().getOrganization().getParentID().getEN());
        //存储farm
        SharedPreferencesUtils.saveString(context,"farm_mfarmname_CN",xmlbean.getDictionary().getFarm().getMFarmName().getCN());
        SharedPreferencesUtils.saveString(context,"farm_mfarmname_EN",xmlbean.getDictionary().getFarm().getMFarmName().getEN());
        SharedPreferencesUtils.saveString(context,"farm_mcontactor_CN",xmlbean.getDictionary().getFarm().getMContactor().getCN());
        SharedPreferencesUtils.saveString(context,"farm_mcontactor_EN",xmlbean.getDictionary().getFarm().getMContactor().getEN());
        SharedPreferencesUtils.saveString(context,"farm_mtitle_CN",xmlbean.getDictionary().getFarm().getMTitle().getCN());
        SharedPreferencesUtils.saveString(context,"farm_mtitle_EN",xmlbean.getDictionary().getFarm().getMTitle().getEN());
        SharedPreferencesUtils.saveString(context,"farm_maddress_CN",xmlbean.getDictionary().getFarm().getMAddress().getCN());
        SharedPreferencesUtils.saveString(context,"farm_maddress_EN",xmlbean.getDictionary().getFarm().getMAddress().getEN());
        SharedPreferencesUtils.saveString(context,"farm_mDictionID_CN",xmlbean.getDictionary().getFarm().getMDictionID().getCN());
        SharedPreferencesUtils.saveString(context,"farm_mDictionID_EN",xmlbean.getDictionary().getFarm().getMDictionID().getEN());
        SharedPreferencesUtils.saveString(context,"farm_mTel_CN",xmlbean.getDictionary().getFarm().getMTel().getCN());
        SharedPreferencesUtils.saveString(context,"farm_mTel_EN",xmlbean.getDictionary().getFarm().getMTel().getEN());
        SharedPreferencesUtils.saveString(context,"farm_isOversea_CN",xmlbean.getDictionary().getFarm().getIsOversea().getCN());
        SharedPreferencesUtils.saveString(context,"farm_isOversea_EN",xmlbean.getDictionary().getFarm().getIsOversea().getEN());
        //存储importer
        SharedPreferencesUtils.saveString(context,"importer_importerName_CN",xmlbean.getDictionary().getImporter().getImporterName().getCN());
        SharedPreferencesUtils.saveString(context,"importer_importerName_EN",xmlbean.getDictionary().getImporter().getImporterName().getEN());
        SharedPreferencesUtils.saveString(context,"importer_iAddress_CN",xmlbean.getDictionary().getImporter().getIAddress().getCN());
        SharedPreferencesUtils.saveString(context,"importer_iAddress_EN",xmlbean.getDictionary().getImporter().getIAddress().getEN());
        SharedPreferencesUtils.saveString(context,"importer_iTel_CN",xmlbean.getDictionary().getImporter().getITel().getCN());
        SharedPreferencesUtils.saveString(context,"importer_iTel_EN",xmlbean.getDictionary().getImporter().getITel().getEN());
        SharedPreferencesUtils.saveString(context,"importer_iTitle_CN",xmlbean.getDictionary().getImporter().getITitle().getCN());
        SharedPreferencesUtils.saveString(context,"importer_iTitle_EN",xmlbean.getDictionary().getImporter().getITitle().getEN());
        // 存储breed
        SharedPreferencesUtils.saveString(context,"breed_breedName_CN",xmlbean.getDictionary().getBreed().getBreedName().getCN());
        SharedPreferencesUtils.saveString(context,"breed_breedName_EN",xmlbean.getDictionary().getBreed().getBreedName().getEN());
        //存储user
        SharedPreferencesUtils.saveString(context,"user_uRealname_CN",xmlbean.getDictionary().getUser().getURealname().getCN());
        SharedPreferencesUtils.saveString(context,"user_uRealname_EN",xmlbean.getDictionary().getUser().getURealname().getEN());
        SharedPreferencesUtils.saveString(context,"user_username_CN",xmlbean.getDictionary().getUser().getUsername().getCN());
        SharedPreferencesUtils.saveString(context,"user_username_EN",xmlbean.getDictionary().getUser().getUsername().getEN());
        SharedPreferencesUtils.saveString(context,"user_password_CN",xmlbean.getDictionary().getUser().getPassword().getCN());
        SharedPreferencesUtils.saveString(context,"user_password_EN",xmlbean.getDictionary().getUser().getPassword().getEN());
        SharedPreferencesUtils.saveString(context,"user_utype_CN",xmlbean.getDictionary().getUser().getUtype().getCN());
        SharedPreferencesUtils.saveString(context,"user_utype_EN",xmlbean.getDictionary().getUser().getUtype().getEN());
        SharedPreferencesUtils.saveString(context,"user_uStatus_CN",xmlbean.getDictionary().getUser().getUStatus().getCN());
        SharedPreferencesUtils.saveString(context,"user_uStatus_EN",xmlbean.getDictionary().getUser().getUStatus().getEN());
        SharedPreferencesUtils.saveString(context,"user_orgID_CN",xmlbean.getDictionary().getUser().getOrgID().getCN());
        SharedPreferencesUtils.saveString(context,"user_orgID_EN",xmlbean.getDictionary().getUser().getOrgID().getEN());
        //===存储game
        SharedPreferencesUtils.saveString(context,"games_cock_chip_CN",xmlbean.getDictionary().getGames().getCock_chip().getCN());
        SharedPreferencesUtils.saveString(context,"games_cock_chip_EN",xmlbean.getDictionary().getGames().getCock_chip().getEN());
        SharedPreferencesUtils.saveString(context,"games_breedName_CN",xmlbean.getDictionary().getGames().getBreedName().getCN());
        SharedPreferencesUtils.saveString(context,"games_breedName_EN",xmlbean.getDictionary().getGames().getBreedName().getEN());
        SharedPreferencesUtils.saveString(context,"games_owner_CN",xmlbean.getDictionary().getGames().getOwner().getCN());
        SharedPreferencesUtils.saveString(context,"games_owner_EN",xmlbean.getDictionary().getGames().getOwner().getEN());
        SharedPreferencesUtils.saveString(context,"games_org_id_CN",xmlbean.getDictionary().getGames().getOrg_id().getCN());
        SharedPreferencesUtils.saveString(context,"games_org_id_EN",xmlbean.getDictionary().getGames().getOrg_id().getEN());
        SharedPreferencesUtils.saveString(context,"games_status_CN",xmlbean.getDictionary().getGames().getStatus().getCN());
        SharedPreferencesUtils.saveString(context,"games_status_EN",xmlbean.getDictionary().getGames().getStatus().getEN());
        SharedPreferencesUtils.saveString(context,"games_createUser_CN",xmlbean.getDictionary().getGames().getCreateUser().getCN());
        SharedPreferencesUtils.saveString(context,"games_createUser_EN",xmlbean.getDictionary().getGames().getCreateUser().getEN());
        SharedPreferencesUtils.saveString(context,"games_createAt_CN",xmlbean.getDictionary().getGames().getCreateAt().getCN());
        SharedPreferencesUtils.saveString(context,"games_createAt_EN",xmlbean.getDictionary().getGames().getCreateAt().getEN());
        SharedPreferencesUtils.saveString(context,"games_win_cock_CN",xmlbean.getDictionary().getGames().getWin_cock().getCN());
        SharedPreferencesUtils.saveString(context,"games_win_cock_EN",xmlbean.getDictionary().getGames().getWin_cock().getEN());
        SharedPreferencesUtils.saveString(context,"games_result_time_CN",xmlbean.getDictionary().getGames().getResult_time().getCN());
        SharedPreferencesUtils.saveString(context,"games_result_time_EN",xmlbean.getDictionary().getGames().getResult_time().getEN());
        //存储diction
        SharedPreferencesUtils.saveString(context,"diction_dictName_CN",xmlbean.getDictionary().getDiction().getDictName().getCN());
        SharedPreferencesUtils.saveString(context,"diction_dictName_EN",xmlbean.getDictionary().getDiction().getDictName().getEN());
        SharedPreferencesUtils.saveString(context,"diction_areaId_CN",xmlbean.getDictionary().getDiction().getAreaName().getCN());
        SharedPreferencesUtils.saveString(context,"diction_areaId_EN",xmlbean.getDictionary().getDiction().getAreaName().getCN());
        SharedPreferencesUtils.saveString(context,"diction_prompt_CN",xmlbean.getDictionary().getDiction().getPrompt().getCN());
        SharedPreferencesUtils.saveString(context,"diction_prompt_EN",xmlbean.getDictionary().getDiction().getPrompt().getCN());
        //存储area
        SharedPreferencesUtils.saveString(context,"area_areaName_CN",xmlbean.getDictionary().getArea().getAreaName().getCN());
        SharedPreferencesUtils.saveString(context,"area_areaName_EN",xmlbean.getDictionary().getArea().getAreaName().getEN());
        SharedPreferencesUtils.saveString(context,"area_prompt_CN",xmlbean.getDictionary().getArea().getPrompt().getCN());
        SharedPreferencesUtils.saveString(context,"area_prompt_EN",xmlbean.getDictionary().getArea().getPrompt().getEN());
        //存储chip
        SharedPreferencesUtils.saveString(context,"chip_chipCode_CN",xmlbean.getDictionary().getChip().getChipCode().getCN());
        SharedPreferencesUtils.saveString(context,"chip_chipCode_EN",xmlbean.getDictionary().getChip().getChipCode().getEN());


        SharedPreferencesUtils.saveString(context,"chip_chipCode_CN",xmlbean.getDictionary().getChip().getChipCode().getCN());
        SharedPreferencesUtils.saveString(context,"chip_chipCode_EN",xmlbean.getDictionary().getChip().getChipCode().getEN());
        SharedPreferencesUtils.saveString(context,"chip_create_userid_CN",xmlbean.getDictionary().getChip().getCreate_userid().getCN());
        SharedPreferencesUtils.saveString(context,"chip_create_userid_EN",xmlbean.getDictionary().getChip().getCreate_userid().getEN());
        SharedPreferencesUtils.saveString(context,"chip_createdate_CN",xmlbean.getDictionary().getChip().getCreatedate().getCN());
        SharedPreferencesUtils.saveString(context,"chip_createdate_EN",xmlbean.getDictionary().getChip().getCreatedate().getEN());
        SharedPreferencesUtils.saveString(context,"chip_isused_CN",xmlbean.getDictionary().getChip().getIsused().getCN());
        SharedPreferencesUtils.saveString(context,"chip_isused_EN",xmlbean.getDictionary().getChip().getIsused().getEN());
        SharedPreferencesUtils.saveString(context,"chip_usedate_CN",xmlbean.getDictionary().getChip().getUsedate().getCN());
        SharedPreferencesUtils.saveString(context,"chip_usedate_EN",xmlbean.getDictionary().getChip().getUsedate().getEN());
        SharedPreferencesUtils.saveString(context,"chip_sub_orgid_CN",xmlbean.getDictionary().getChip().getSub_orgid().getCN());
        SharedPreferencesUtils.saveString(context,"chip_sub_orgid_EN",xmlbean.getDictionary().getChip().getSub_orgid().getEN());
        //存储statusdata
        SharedPreferencesUtils.saveString(context,"StatusData_cocks_cStatus_0_CN",xmlbean.getDictionary().getStatusData().getCocks().getCStatus().get(0).getCN());
        SharedPreferencesUtils.saveString(context,"StatusData_cocks_cStatus_0_EN",xmlbean.getDictionary().getStatusData().getCocks().getCStatus().get(0).getEN());
        SharedPreferencesUtils.saveString(context,"StatusData_cocks_cStatus_1_CN",xmlbean.getDictionary().getStatusData().getCocks().getCStatus().get(1).getCN());
        SharedPreferencesUtils.saveString(context,"StatusData_cocks_cStatus_1_EN",xmlbean.getDictionary().getStatusData().getCocks().getCStatus().get(1).getEN());
        SharedPreferencesUtils.saveString(context,"StatusData_cocks_cStatus_2_CN",xmlbean.getDictionary().getStatusData().getCocks().getCStatus().get(2).getCN());
        SharedPreferencesUtils.saveString(context,"StatusData_cocks_cStatus_2_EN",xmlbean.getDictionary().getStatusData().getCocks().getCStatus().get(2).getEN());

        SharedPreferencesUtils.saveString(context,"StatusData_userStatus_uStatus_0_CN",xmlbean.getDictionary().getStatusData().getUserStatus().getUStatus().get(0).getCN());
        SharedPreferencesUtils.saveString(context,"StatusData_userStatus_uStatus_0_EN",xmlbean.getDictionary().getStatusData().getUserStatus().getUStatus().get(0).getEN());
        SharedPreferencesUtils.saveString(context,"StatusData_userStatus_uStatus_1_CN",xmlbean.getDictionary().getStatusData().getUserStatus().getUStatus().get(1).getCN());
        SharedPreferencesUtils.saveString(context,"StatusData_userStatus_uStatus_1_EN",xmlbean.getDictionary().getStatusData().getUserStatus().getUStatus().get(1).getEN());

        SharedPreferencesUtils.saveString(context,"StatusData_userType_utype_0_CN",xmlbean.getDictionary().getStatusData().getUserType().getUtype().get(0).getCN());
        SharedPreferencesUtils.saveString(context,"StatusData_userType_utype_0_EN",xmlbean.getDictionary().getStatusData().getUserType().getUtype().get(0).getEN());
        SharedPreferencesUtils.saveString(context,"StatusData_userType_utype_1_CN",xmlbean.getDictionary().getStatusData().getUserType().getUtype().get(1).getCN());
        SharedPreferencesUtils.saveString(context,"StatusData_userType_utype_1_EN",xmlbean.getDictionary().getStatusData().getUserType().getUtype().get(1).getEN());
        //==存储titledata
        SharedPreferencesUtils.saveString(context,"TitleData_title_0_CN",xmlbean.getDictionary().getTitleData().getTitle().get(0).getCN());
        SharedPreferencesUtils.saveString(context,"TitleData_title_0_EN",xmlbean.getDictionary().getTitleData().getTitle().get(0).getEN());
        SharedPreferencesUtils.saveString(context,"TitleData_title_1_CN",xmlbean.getDictionary().getTitleData().getTitle().get(1).getCN());
        SharedPreferencesUtils.saveString(context,"TitleData_title_1_EN",xmlbean.getDictionary().getTitleData().getTitle().get(1).getEN());
        //==存储DB_PROC
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_add_msg_0_CN",xmlbean.getDictionary().getDB_PROC().getCocks().getAdd().getMsg().get(0).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_add_msg_0_EN",xmlbean.getDictionary().getDB_PROC().getCocks().getAdd().getMsg().get(0).getEN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_add_msg_1_CN",xmlbean.getDictionary().getDB_PROC().getCocks().getAdd().getMsg().get(1).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_add_msg_1_EN",xmlbean.getDictionary().getDB_PROC().getCocks().getAdd().getMsg().get(1).getEN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_add_msg_2_CN",xmlbean.getDictionary().getDB_PROC().getCocks().getAdd().getMsg().get(2).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_add_msg_2_EN",xmlbean.getDictionary().getDB_PROC().getCocks().getAdd().getMsg().get(2).getEN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_add_msg_3_CN",xmlbean.getDictionary().getDB_PROC().getCocks().getAdd().getMsg().get(3).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_add_msg_3_EN",xmlbean.getDictionary().getDB_PROC().getCocks().getAdd().getMsg().get(3).getEN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_update_status_msg_0_CN",xmlbean.getDictionary().getDB_PROC().getCocks().getUpdate_status().getMsg().get(0).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_update_status_msg_0_EN",xmlbean.getDictionary().getDB_PROC().getCocks().getUpdate_status().getMsg().get(0).getEN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_update_status_msg_1_CN",xmlbean.getDictionary().getDB_PROC().getCocks().getUpdate_status().getMsg().get(1).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_update_status_msg_1_EN",xmlbean.getDictionary().getDB_PROC().getCocks().getUpdate_status().getMsg().get(1).getEN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_update_status_msg_2_CN",xmlbean.getDictionary().getDB_PROC().getCocks().getUpdate_status().getMsg().get(2).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_cocks_update_status_msg_2_EN",xmlbean.getDictionary().getDB_PROC().getCocks().getUpdate_status().getMsg().get(2).getEN());

        SharedPreferencesUtils.saveString(context,"DB_PROC_owners_login_msg_0_CN",xmlbean.getDictionary().getDB_PROC().getOwners().getLogin().getMsg().get(0).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_owners_login_msg_0_EN",xmlbean.getDictionary().getDB_PROC().getOwners().getLogin().getMsg().get(0).getEN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_owners_login_msg_1_CN",xmlbean.getDictionary().getDB_PROC().getOwners().getLogin().getMsg().get(1).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_owners_login_msg_1_EN",xmlbean.getDictionary().getDB_PROC().getOwners().getLogin().getMsg().get(1).getEN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_owners_login_msg_2_CN",xmlbean.getDictionary().getDB_PROC().getOwners().getLogin().getMsg().get(2).getCN());
        SharedPreferencesUtils.saveString(context,"DB_PROC_owners_login_msg_2_EN",xmlbean.getDictionary().getDB_PROC().getOwners().getLogin().getMsg().get(2).getEN());

        //==存储Upload_Image
        SharedPreferencesUtils.saveString(context,"Upload_Image_msg_0_CN",xmlbean.getDictionary().getUpload_Image().getMsg().get(0).getCN());
        SharedPreferencesUtils.saveString(context,"Upload_Image_msg_0_EN",xmlbean.getDictionary().getUpload_Image().getMsg().get(0).getEN());
        SharedPreferencesUtils.saveString(context,"Upload_Image_msg_1_CN",xmlbean.getDictionary().getUpload_Image().getMsg().get(1).getCN());
        SharedPreferencesUtils.saveString(context,"Upload_Image_msg_1_EN",xmlbean.getDictionary().getUpload_Image().getMsg().get(1).getEN());
        SharedPreferencesUtils.saveString(context,"Upload_Image_msg_2_CN",xmlbean.getDictionary().getUpload_Image().getMsg().get(2).getCN());
        SharedPreferencesUtils.saveString(context,"Upload_Image_msg_2_EN",xmlbean.getDictionary().getUpload_Image().getMsg().get(2).getEN());
        SharedPreferencesUtils.saveString(context,"Upload_Image_msg_3_CN",xmlbean.getDictionary().getUpload_Image().getMsg().get(3).getCN());
        SharedPreferencesUtils.saveString(context,"Upload_Image_msg_3_EN",xmlbean.getDictionary().getUpload_Image().getMsg().get(3).getEN());
        //===存储basic
        SharedPreferencesUtils.saveString(context,"basic_operation_CN",xmlbean.getDictionary().getBasic().getOperation().getCN());
        SharedPreferencesUtils.saveString(context,"basic_operation_EN",xmlbean.getDictionary().getBasic().getOperation().getEN());

        SharedPreferencesUtils.saveString(context,"basic_keyword_CN",xmlbean.getDictionary().getBasic().getKeyword().getCN());
        SharedPreferencesUtils.saveString(context,"basic_keyword_EN",xmlbean.getDictionary().getBasic().getKeyword().getEN());

        SharedPreferencesUtils.saveString(context,"basic_cardno_CN",xmlbean.getDictionary().getBasic().getCardno().getCN());
        SharedPreferencesUtils.saveString(context,"basic_cardno_EN",xmlbean.getDictionary().getBasic().getCardno().getEN());

        SharedPreferencesUtils.saveString(context,"basic_operation_CN",xmlbean.getDictionary().getBasic().getOperation().getCN());
        SharedPreferencesUtils.saveString(context,"basic_operation_EN",xmlbean.getDictionary().getBasic().getOperation().getEN());

        SharedPreferencesUtils.saveString(context,"basic_tel_CN",xmlbean.getDictionary().getBasic().getTel().getCN());
        SharedPreferencesUtils.saveString(context,"basic_tel_EN",xmlbean.getDictionary().getBasic().getTel().getEN());

        SharedPreferencesUtils.saveString(context,"basic_search_CN",xmlbean.getDictionary().getBasic().getSearch().getCN());
        SharedPreferencesUtils.saveString(context,"basic_search_EN",xmlbean.getDictionary().getBasic().getSearch().getEN());

        SharedPreferencesUtils.saveString(context,"basic_New_CN",xmlbean.getDictionary().getBasic().getNew().getCN());
        SharedPreferencesUtils.saveString(context,"basic_New_EN",xmlbean.getDictionary().getBasic().getNew().getEN());

        SharedPreferencesUtils.saveString(context,"basic_clear_CN",xmlbean.getDictionary().getBasic().getClear().getCN());
        SharedPreferencesUtils.saveString(context,"basic_clear_EN",xmlbean.getDictionary().getBasic().getClear().getEN());

        SharedPreferencesUtils.saveString(context,"basic_confirm_CN",xmlbean.getDictionary().getBasic().getConfirm().getCN());
        SharedPreferencesUtils.saveString(context,"basic_confirm_EN",xmlbean.getDictionary().getBasic().getConfirm().getEN());

        SharedPreferencesUtils.saveString(context,"basic_cancel_CN",xmlbean.getDictionary().getBasic().getCancel().getCN());
        SharedPreferencesUtils.saveString(context,"basic_cancel_EN",xmlbean.getDictionary().getBasic().getCancel().getEN());

        Log.i(Constants.TAG,"FINISH");
    }

    private void saveLoginInfo() {
        LogininfoBean.ValuesBean  vb = logininfoBean.getValues();

        SharedPreferencesUtils.saveInt(context,Constants.ID,vb.getId());
        if(!isBlankString(vb.getOwnerName())){
            SharedPreferencesUtils.saveString(context,Constants.OWNERNAME,vb.getOwnerName());
        }
        SharedPreferencesUtils.saveInt(context,Constants.OTITLE,vb.getOTitle());
        if(!isBlankString(vb.getOAddress())){

            SharedPreferencesUtils.saveString(context,Constants.OADDRESS,vb.getOAddress());
        }
        if(!isBlankString(vb.getOTel())){

            SharedPreferencesUtils.saveString(context,Constants.OTEL,vb.getOTel());
        }

        if(!isBlankString(vb.getMFarmName())){
            SharedPreferencesUtils.saveString(context,Constants.FARMNAME,vb.getMFarmName());
        }
        if(!isBlankString(vb.getOIDNo())){

            SharedPreferencesUtils.saveString(context,Constants.OIDNO,vb.getOIDNo());
        }
        if(!isBlankString(vb.getOwnDate())){

            SharedPreferencesUtils.saveString(context,Constants.OWNDATE,vb.getOwnDate());
        }
        SharedPreferencesUtils.saveBoolean(context,Constants.ISPERSONAL,vb.isIsPersonal());
        SharedPreferencesUtils.saveInt(context,Constants.FARMIDLOGIN,vb.getFarmid());

        SharedPreferencesUtils.saveString(context,Constants.USERNAME,vb.getUsername());
        SharedPreferencesUtils.saveString(context,Constants.PASSWORD,vb.getPassword());
    }

    public boolean isBlankString(String s ){
        return s.trim().length() == 0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //首先获取本地存储的APP版本号，方便之后与xml中的对比，以决定是否需要下载新的
//        appversioncode = SharedPreferencesUtils.getString(context,"appversioncode","1.0.9");
        //获取Derby 列表,如果从sharepreference 中拿不到键contest0对应的值，则说明本地没有存储derby列表，那么去下载
//        String str = SharedPreferencesUtils.getString(context,"contest1","");
//        Log.i("nkk","contest1 is "+str);
//        //能获取到contest1 的值 就说明已经存有Derby的列表
//        if(str.equals("")){
//            getContestList();
//        }
        getContestList();
        initView();
    }

    private void getContestList() {
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String requl = Constants.THREE_CONTEST_URL;
                contestBean = OkhttpPlusUtil.getInstance().get(requl,ContestBean.class);
                int tempnum = 0;
                if(contestBean!=null&&contestBean.isIsSuccess()&&contestBean.getValues().size()>0){
                    for (int i = 0; i < contestBean.getValues().size(); i++) {
                        if(!contestBean.getValues().get(i).isIsdeleted()){
                            contestList.add(contestBean.getValues().get(i).getDerby());
                            Log.i("nkk","derby is "+contestBean.getValues().get(i).getDerby());
                            tempnum++;
                            SharedPreferencesUtils.saveInt(context,"contestid"+tempnum,contestBean.getValues().get(i).getID());
                            SharedPreferencesUtils.saveString(context,"contest"+tempnum,contestBean.getValues().get(i).getDerby());
                        }
                    }
                    SharedPreferencesUtils.saveInt(context,"contestsize",tempnum);
                    Log.i("nkk","contestsize is "+ tempnum);
                    Log.d(Constants.TAG,contestList);
                }
            }
        });
    }

    private void initView() {
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        iv_clean_phone = findViewById(R.id.iv_clean_phone);
        iv_clean_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_username.setText("");
            }
        });
        clean_password = findViewById(R.id.clean_password);
        clean_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_password.setText("");
            }
        });
        iv_show_pwd = findViewById(R.id.iv_show_pwd);
        iv_show_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_password.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    iv_show_pwd.setImageResource(R.drawable.pass_visuable);
                } else {
                    et_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    iv_show_pwd.setImageResource(R.drawable.pass_gone);
                }
                String pwd = et_password.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    et_password.setSelection(pwd.length());
            }
        });
        et_username = findViewById(R.id.et_username);
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && iv_clean_phone.getVisibility() == View.GONE) {
                    iv_clean_phone.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    iv_clean_phone.setVisibility(View.GONE);
                }
            }
        });
        et_password = findViewById(R.id.et_password);
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && clean_password.getVisibility() == View.GONE) {
                    clean_password.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    clean_password.setVisibility(View.GONE);
                }
            }
        });
        sweetAlertDialog = new SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE);
        detectSharePreferenceExist();
    }

    private void detectSharePreferenceExist() {
        String username  = SharedPreferencesUtils.getString(LoginActivity.this,"username","");
        String password = SharedPreferencesUtils.getString(LoginActivity.this,"password","");
        if (username!=null&&username.trim().length()!=0&&password!=null&&password.trim().length()!=0){
            et_username.setText(username);
            et_password.setText(password);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                showLoading(true);
                MobclickAgentWrapper.onEvent(this,"loginbtn click");
                loginbypassword(et_username.getText().toString(),et_password.getText().toString());
                break;
        }
    }

    private void showLoading(boolean flag) {
        if(flag){
            sweetAlertDialog.setContentText("Loading");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.show();
            new CountDownTimer(800 * 7, 800) {
                @Override
                public void onTick(long millisUntilFinished) {
                    i++;
                    switch (i){
                        case 0:
                            sweetAlertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.blue_btn_bg_color));
                            break;
                        case 1:
                            sweetAlertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_50));

                            break;
                        case 2:
                            sweetAlertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));

                            break;
                        case 3:
                            sweetAlertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_20));

                            break;
                        case 4:
                            sweetAlertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_blue_grey_80));

                            break;
                        case 5:
                            sweetAlertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.warning_stroke_color));

                            break;
                        case 6:
                            sweetAlertDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));

                            break;
                    }
                }

                @Override
                public void onFinish() {

                }
            }.start();
            btn_login.setVisibility(View.INVISIBLE);
            et_username.setEnabled(false);
            et_password.setEnabled(false);
        }else {
            if(sweetAlertDialog!=null){
                sweetAlertDialog.dismiss();
            }
            btn_login.setVisibility(View.VISIBLE);
            et_username.setEnabled(true);
            et_password.setEnabled(true);
        }
    }


    private void loginbypassword(String username,String password) {
        if(username ==null || username.trim().length()==0||password ==null||password.trim().length()==0){
//            Toast.makeText(this, GetAttrString.getDB_PROC_owners_login_msg_1(), Toast.LENGTH_SHORT).show();
            RxToast.info(this, GetAttrString.getDB_PROC_owners_login_msg_1(), Toast.LENGTH_SHORT, true).show();

            showLoading(false);
            return;
        }
        loginInfoMap.put("username",username);
        loginInfoMap.put("password",password);
        if (NetCheckUtil.isNetworkConnected(this)) {
            showLoading(true);
            loginOperation(loginInfoMap);
        }else {
//            Toast.makeText(this, GetAttrString.getnetWork_error(), Toast.LENGTH_SHORT).show();
            RxToast.error(this, GetAttrString.getnetWork_error(), Toast.LENGTH_SHORT, true).show();

            showLoading(false);
        }
    }

    private void loginOperation(final Map<String,String> map) {
        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String login_url = Constants.USR_LOGIN_URL;
                login_url = GetJson.replace(login_url,"{username}",map.get("username"));
                login_url = GetJson.replace(login_url,"{password}",map.get("password"));
                logininfoBean = OkhttpPlusUtil.getInstance().get(login_url,LogininfoBean.class);
                if(logininfoBean!=null){
                    boolean isSuccessful = logininfoBean.isIsSuccess();
                    int status = logininfoBean.getStatus();
//                    boolean isPersonl = logininfoBean.getValues().isIsPersonal();
//                    boolean isDeleted = logininfoBean.getValues().isIsDeleted();
//                    if(isSuccessful && status == 1&&isPersonl){
//                        if(!isDeleted){
//                            handler.sendEmptyMessage(Constants.LOGIN_SUCCESS);
//                        }else {
//                            handler.sendEmptyMessage(Constants.LOGIN_FAIL);
//                        }
//                    }else if(isSuccessful && status==1 && !isPersonl){
//                        boolean farm_isDeleted = logininfoBean.getValues().isFarm_isDeleted();
//                        if(!isDeleted &&!farm_isDeleted){
//                            handler.sendEmptyMessage(Constants.LOGIN_SUCCESS);
//                        }else {
//                            handler.sendEmptyMessage(Constants.LOGIN_FAIL);
//                        }
//                    }
                    if(isSuccessful&&status==1){
                        boolean isPersonl = logininfoBean.getValues().isIsPersonal();
                        boolean isDeleted = logininfoBean.getValues().isIsDeleted();
                        if(isPersonl){
                            if(!isDeleted){
                                handler.sendEmptyMessage(Constants.LOGIN_SUCCESS);
                            }else {
                                handler.sendEmptyMessage(Constants.LOGIN_FAIL);
                            }
                        }else{
                            boolean farm_isDeleted = logininfoBean.getValues().isFarm_isDeleted();
                            if(!isDeleted && !farm_isDeleted){
                                handler.sendEmptyMessage(Constants.LOGIN_SUCCESS);
                            }else {
                                handler.sendEmptyMessage(Constants.LOGIN_FAIL);
                            }
                        }

                    }else {
                        handler.sendEmptyMessage(Constants.LOGIN_FAIL);
                    }
                }else {
                    handler.sendEmptyMessage(Constants.LOGIN_FAIL_NONET);
                }

            }
        });

//        openScanningActvity();
    }

    private void openScanningActvity() {
        Intent intent = new Intent(this,MyCockActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
