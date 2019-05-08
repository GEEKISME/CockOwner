package com.biotag.cockowner.common;

import com.biotag.cockowner.utils.SharedPreferencesUtils;
import com.biotag.cockowner.utils.UIUtils;

/**
 * Created by Lxh on 2017/8/29.
 */

public class GetAttrString {

    private static boolean isChinese = false;
    public static String getCock_ChipCode(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_chipcode_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_chipcode_EN","");
        }
    }
    public static String getCock_no(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_cockno_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_cockno_EN","");
        }
    }
    public static String getCock_breedid(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_breedID_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_breedID_EN","");
        }
    }
    public static String getCock_memo(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_memo_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_memo_EN","");
        }
    }
    public static String getCock_birth(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_birth_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_birth_EN","");

        }
    }
    public static String getCock_org(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_org_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_org_EN","");
        }
    }
//    public static String getCock_orgid(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_orgid_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_orgid_EN","");
//        }
//    }
    public static String getCock_cstatus(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_cstatus_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_cstatus_EN","");
        }
    }
    public static String getCock_farmid(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_farmid_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_farmid_EN","");
        }
    }
    public static String getCock_Photo_len(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_photo_len_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_photo_len_EN","");
        }
    }
    public static String getCock_photo_skin(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_photo_skin_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_photo_skin_EN","");

        }
    }
//    public static String getCock_creatorid(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_creatorid_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_creatorid_CN","");
//        }
//    }
//    public static String getCock_creatorat(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_creatorat_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_creatorat_EN","");
//        }
//    }
//    public static String getCock_lastownerid(){
//        if(isChinese){
//           return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_lastownerid_CN","");
//        }else {
//           return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_lastownerid_EN","");
//        }
//    }
    public static String getCock_regdate1(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_regdate1_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_regdate1_EN","");
        }
    }

    public static String getCock_regdate2(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_regdate2_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_regdate2_EN","");
        }
    }
    public static String getCock_regdate3(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_regdate3_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_regdate3_EN","");
        }
    }
    public static String getCock_isimport(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_isimport_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_isimport_EN","");
        }
    }
//    public static String getCock_importerid(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_importerid_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"cock_importerid_EN","");
//        }
//    }
    //=======================================================================================================
    public static String getimporter_importerName(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"importer_importerName_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"importer_importerName_EN","");

        }
    }
    //=====================================================================================================
    public static String getOwners_ownername(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"owners_ownername_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"owners_ownername_EN","");
        }
    }
    //========================================
    //========================================
    public static String getdiction_dictName(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"diction_dictName_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"diction_dictName_EN","");
        }
    }

    //===============================================
    public static String getStatusData_cocks_cStatus_normal(){
        if (isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"StatusData_cocks_cStatus_0_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"StatusData_cocks_cStatus_0_EN","");
        }
    }
    public static String getStatusData_cocks_cStatus_abort(){
        if (isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"StatusData_cocks_cStatus_1_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"StatusData_cocks_cStatus_1_EN","");
        }
    }
    public static String getStatusData_cocks_cStatus_lost(){
        if (isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"StatusData_cocks_cStatus_2_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"StatusData_cocks_cStatus_2_EN","");
        }
    }



    //===============================================

    public static String getDB_PROC_cocks_update_status_msg_0(){
        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_update_status_msg_0_CN","");
            return "斗鸡状态更新成功";
        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_update_status_msg_0_EN","");
            return "Status Changing Succeeded";
        }
    }
//    public static String getDB_PROC_cocks_update_status_msg_1(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_update_status_msg_1_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_update_status_msg_1_EN","");
//        }
//    }
    public static String getDB_PROC_cocks_update_status_msg_2(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_update_status_msg_2_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_update_status_msg_2_EN","");
        }
    }

    public static String getDB_PROC_owners_login_msg_0(){
        String c = SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_owners_login_msg_0_CN","");
        String e = SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_owners_login_msg_0_EN","");
        if(isChinese){
            if(c.equals("")){
                return "登录成功，欢迎使用!";
            }else {
                return c;
            }
        }else {
            if(e.equals("")){
                return "Login successfully!";
            }else {

                return e;
            }
        }
    }
    public static String getDB_PROC_owners_login_msg_1(){
        String c  = SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_owners_login_msg_1_CN","");
        String e  = SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_owners_login_msg_1_EN","");
        if(isChinese){
            if(c.equals("")){
                return "数据参数无效，请重试";
            }else {
                return c;
            }
        }else {
            if(e.equals("")){
                return "Arguments are invalid,try again please !";
            }else {
                return e;
            }
        }
    }
    public static String getDB_PROC_owners_login_msg_2(){
        String c = SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_owners_login_msg_2_CN","");
        String e = SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_owners_login_msg_2_EN","");
        if(isChinese){
            if(c.equals("")){
                return "登录失败，用户名或密码错误！";
            }else {
                return c;
            }
        }else {
            if(e.equals("")){
                return "user name or password is wrong ";
            }else {
                return e;
            }
        }
    }
    public static String getnetWork_error(){
        if(isChinese){
            return "当前无网络连接";
        }else {
            return "Network is unavailable!";
        }
    }
    public static String getBasic_confirm(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"basic_confirm_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"basic_confirm_EN","");

        }
    }
    public static String getBasic_cancel(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"basic_cancel_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"basic_cancel_EN","");

        }
    }
    public static String getDB_PROC_cock_add_msg_0(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_0_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_0_EN","");
        }
    }
//    public static String getDB_PROC_cock_add_msg_1(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_1_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_1_EN","");
//        }
//    }
//    public static String getDB_PROC_cock_add_msg_2(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_2_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_2_EN","");
//        }
//    }
    public static String getDB_PROC_cock_add_msg_3(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_3_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_3_EN","");
        }
    }
    public static String getUpload_Image_msg_0(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"Upload_Image_msg_0_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"Upload_Image_msg_0_EN","");
        }
    }
//    public static String getUpload_Image_msg_1(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"Upload_Image_msg_1_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"Upload_Image_msg_1_EN","");
//        }
//    }
//    public static String getUpload_Image_msg_2(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"Upload_Image_msg_2_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"Upload_Image_msg_2_EN","");
//        }
//    }
    public static String getUpload_Image_msg_3(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"Upload_Image_msg_3_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"Upload_Image_msg_3_EN","");
        }
    }

    public static String getMy_cock(){
        if(isChinese){
            return "我的斗鸡";
        }else {
            return "My Gamefowls";
        }
    }

    public static String getCock_gamerecord(){
        if(isChinese){
            return "斗鸡比赛记录";
        }else {
            return "Game Record";
        }
    }
    //=====================================================================
//    public static String getOrganization_orgname(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"organizatin_orgname_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"organizatin_orgname_EN","");
//
//        }
//    }
    public static String getOrganizatin_parentid(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"organizatin_parentid_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"organizatin_parentid_EN","");
        }
    }
    public static String getGames_resulttime(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"games_result_time_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"games_result_time_EN","");

        }
    }
//    public static String getGames_wincock(){
//        if(isChinese){
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"games_win_cock_CN","");
//        }else {
//            return SharedPreferencesUtils.getString(UIUtils.getContext(),"games_win_cock_EN","");
//        }
//    }
    public static String getCockA(){
        if(isChinese){
            return "斗鸡一";
        }else {
            return " A";
        }
    }
    public static String getCockB(){
        if(isChinese){
            return "斗鸡二";
        }else {
            return " B";
        }
    }
    public static String getGames_createat(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"games_createAt_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"games_createAt_EN","");

        }
    }
    public static String getGames_creatoruser(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"games_createUser_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"games_createUser_EN","");
        }
    }
    public static String getDB_PROC_cocks_add_msg_2(){
        if(isChinese){
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_2_CN","");
        }else {
            return SharedPreferencesUtils.getString(UIUtils.getContext(),"DB_PROC_cocks_add_msg_2_EN","");
        }
    }
    public static String getSetWinCock(){
        if(isChinese){
            return "确定将此斗鸡设为胜利者？";
        }else {
            return "Will you set the gamefowl winner?";
        }
    }
    public static String getGameResultUploadSucc(){
        if(isChinese){
            return "比赛结果上传成功!";
        }else {
            return "Uploading Game Result succeeded!";
        }
    }
    public static String getGameResultUploadFail(){
        if(isChinese){
            return "比赛结果上传失败!";
        }else {
            return "Uploading Game Result failed!";
        }
    }
    public static String getInputCockInfo(){
        if(isChinese){
            return "录入斗鸡信息";
        }else {
            return "Add New Gamefowl ";
        }
    }
    public static String getCockQuery(){
        if(isChinese){
            return "斗鸡查询";
        }else {
            return  "Gamefowl Search";
        }
    }
    public static String getSearchResult(){
        if(isChinese){
            return "查询结果";
        }else {
            return "Query Result";
        }
    }
    //=======================================================
    public static String getLevel1(){
        if(isChinese){
            return "阶段一";
        }else {
            return "1st";
        }
    }
    public static String getLevel2(){
        if(isChinese){
            return "阶段二";
        }else {
            return "2nd";
        }
    }
    public static String getLevel3(){
        if(isChinese){
            return "阶段三";
        }else {
            return "3rd";
        }
    }

    public static String getAlllv(){
        if(isChinese){
            return "所有";
        }else {
            return "All";
        }
    }
    public static String getnormal(){
        if(isChinese){
            return "正常";
        }else {
            return "Normal";
        }
    }
    public static String getabort(){
        if(isChinese){
            return "淘汰";
        }else {
            return "Abort";
        }
    }
    public static String getlost(){
        if(isChinese){
            return "走失";
        }else {
            return "Lost";
        }
    }
    //=================================================
//    public static String getLevel4(){
//        if(isChinese){
//            return "全部阶段";
//        }else {
//            return "All Level";
//        }
//    }
    public static String getQuery(){
        if(isChinese){
            return "查询";
        }else {
            return "Query";
        }
    }
//    public static String getQueryConditionNull(){
//        if(isChinese){
//            return "查询条件不能为空";
//        }else {
//            return "Query condition cannot be empty !";
//        }
//    }
    public static String getCockDetailInfo(){
        if(isChinese){
            return "斗鸡详情";
        }else {
            return "Gamefowl info.";
        }
    }
    public static String getCockGameRecord(){
        if(isChinese){
            return "斗鸡比赛记录";
        }else {
            return "Game Record";
        }
    }
    public static String getCockInfoIncomplete(){
        if(isChinese){
            return "斗鸡信息不完整 !";
        }else {
            return "Gamefowl Information is incomplete !";
        }
    }
    public static String getPicture(){
        if(isChinese){
            return "拍照";
        }else {
            return "camera";
        }
    }
    public static String getPictureByLib(){
        if(isChinese){
            return "从图库选择";
        }else {
            return "photo album";
        }
    }
    public static String getSetCockStatus(){
        if(isChinese){
            return "确定将这只斗鸡的状态设为：";
        }else {
            return "Will you set the gamefowl status: ";
        }
    }
    public static String getSetCockDerby(){
        if(isChinese){
            return "确定将这只斗鸡的Derby设为： ";
        }else {
            return "Will you set the gamefowl derby: ";
        }
    }
    public static String getSetCockWeight(){
        if(isChinese){
            return "确定将这只斗鸡的状态设为：";
        }else {
            return "Will you set the gamefowl weight: ";
        }
    }
    public static String getSetcockdate(){
        if(isChinese){
            return "确定这只斗鸡达到了:";
        }else {
            return "Will you set the Gamefowl stage: ";
        }
    }
    public static String getCurrentStageOptions(){
        if(isChinese){
            return "等级选择";
        }else {
            return "Level Options";
        }
    }

    public static String getCurrentStatusOption(){
        if(isChinese){
            return "状态选择";
        }else {
            return "Status Options";
        }
    }

//    public static String getDerbyOptions(){
//        if(isChinese){
//            return "赛事选择";
//        }else{
//            return "Derby Options";
//        }
//    }

    public static String getCurrentStage(){
        if(isChinese){
            return "当前等级 :";
        }else {
            return "Current Level :";
        }
    }
    public static String getCurrentStatus(){
        if(isChinese){
            return "当前状态 :";
        }else {
            return "Current Status :";
        }
    }

//    public static String getDerbySelected(){
//        if(isChinese){
//            return "赛事 ：";
//        }else {
//            return "Derby selected:";
//        }
//    }

//    public static String getIsimport(){
//        if(isChinese){
//            return "是否进口 :";
//        }else {
//            return "Import or not :";
//        }
//    }

//    public static String getSetCockRegdate1(){
//        if(isChinese){
//            return "设置斗鸡为等级一成功"  ;
//        }else {
//            return "Setting gamefowl level 1 succeeded";
//        }
//    }
//    public static String getSetCockRegdate2(){
//        if(isChinese){
//            return "设置斗鸡为等级二成功";
//        }else {
//            return "Set gamefowl level 2 succeeded";
//        }
//    }
//    public static String getSetCockRegdate3(){
//        if(isChinese){
//            return "设置斗鸡为等级三成功";
//        }else {
//            return "Set gamefowl level 3 succeeded";
//        }
//    }

    public static String getYes(){
        if(isChinese){
            return "是";
        }else {
            return "Yes";
        }
    }
    public static String getNo(){
        if(isChinese){
            return "否";
        }else {
            return "No";
        }
    }

//    public static String getGetdataSu(){
//        if(isChinese){
//            return "获取数据成功";
//        }else {
//            return "Acquiring data succeeded !";
//        }
//    }
//    public static String getGetdataFailed(){
//        if(isChinese){
//            return "获取数据失败";
//        }else {
//            return "Acquiring data failed !";
//        }
//    }
//    public static String getStage(){
//        if(isChinese){
//            return "阶段";
//        }else {
//            return "Level";
//        }
//    }

    public static String getFirstmothOrg(){
        if(isChinese){
            return "请先选择母机构";
        }else {
            return "Please choose the Mother Orgnization first !";
        }
    }



    public static String getNocockInYourname(){
        if(isChinese){
            return "你的名下还没有斗鸡！";
        }else {
            return "There is no gamefowl in your name !";
        }
    }

    public static String getRestartAppnow() {
        if(isChinese){
            return "安装包已在WiFi状态下下载好，要重启APP吗？";
        }else {
            return "The new version has been downloaded in wifi state,restart the app now ?";
        }
    }
}
