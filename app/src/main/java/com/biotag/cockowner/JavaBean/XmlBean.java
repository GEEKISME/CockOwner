package com.biotag.cockowner.JavaBean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lxh on 2017/8/29.
 */

public class XmlBean {


    /**
     * Dictionary : {"cocks":{"chipCode":{"CN":"芯片编号","EN":"Chip Code"},"cockNo":{"CN":"赛事名称","EN":"Derby Entry"},"breedID":{"CN":"品种","EN":"Bloodline"},"memo":{"CN":"备注信息","EN":"Remark"},"birth":{"CN":"出生日期","EN":"Hatch Date"},"org":{"CN":"比赛机构","EN":"Federation"},"orgID":{"CN":"协会名称","EN":"Organization"},"cStatus":{"CN":"斗鸡状态","EN":"Status"},"farmID":{"CN":"养殖场名称","EN":"Game Farm"},"photo_len":{"CN":"斗鸡照片 len","EN":"Leg Photo"},"photo_skin":{"CN":"斗鸡照片 skin","EN":"Skin Photo"},"creatorid":{"CN":"创建人","EN":"Creater"},"createAt":{"CN":"创建时间","EN":"Created On"},"lastOwnerID":{"CN":"当前鸡主","EN":"Owner Info"},"regDate1":{"CN":"第一阶段","EN":"Register 1st"},"regDate2":{"CN":"第二阶段","EN":"Register 2nd"},"regDate3":{"CN":"第三阶段","EN":"Register 3rd"},"isImport":{"CN":"是否进口","EN":"Is Importable"},"importerID":{"CN":"引进人","EN":"Importer"}},"owners":{"ownerName":{"CN":"鸡主姓名","EN":"Owner"},"oTitle":{"CN":"称谓","EN":"Title"},"oAddress":{"CN":"鸡主地址","EN":"Address"},"oTel":{"CN":"鸡主电话","EN":"Tel."},"oIDNo":{"CN":"证件号码","EN":"License/Passport ID"},"ownDate":{"CN":"创建日期","EN":"Created On"},"oDictionID":{"CN":"行政区域名称","EN":"Province"},"isPersonal":{"CN":"是否是个人","EN":"Individual"},"farmid":{"CN":"养殖场名称","EN":"Game Farm"},"username":{"CN":"登录账号","EN":"Account"},"password":{"CN":"登录密码","EN":"Password"}},"organization":{"orgName":{"CN":"协会名称","EN":"Federation"},"email":{"CN":"电子邮件","EN":"Email"},"gAddress":{"CN":"地址","EN":"Address"},"gTel":{"CN":"电话","EN":"Tel."},"gContactor":{"CN":"联系人","EN":"Contact"},"gTitle":{"CN":"称谓","EN":"Title"},"gCode":{"CN":"机构代码","EN":"Code"},"parentID":{"CN":"母机构编号","EN":"Main Federation"}},"farm":{"mFarmName":{"CN":"养殖场名称","EN":"Game Farm"},"mContactor":{"CN":"联系人","EN":"Contact"},"mTitle":{"CN":"称谓","EN":"Title"},"mAddress":{"CN":"地址","EN":"Address"},"mDictionID":{"CN":"行政区域名称","EN":"Province"},"mTel":{"CN":"电话","EN":"Tel."},"overseaFarm":{"CN":"海外养殖场","EN":"Oversea Farm"},"isOversea":{"CN":"是否是海外养殖场","EN":"Is Oversea Farm"}},"importer":{"importerName":{"CN":"引进人姓名","EN":"Importer"},"iAddress":{"CN":"地址","EN":"Address"},"iTel":{"CN":"电话","EN":"Mobile"},"iTitle":{"CN":"称谓","EN":"Title"}},"breed":{"breedName":{"CN":"品种名称","EN":"Bloodline"}},"user":{"uRealname":{"CN":"真实姓名","EN":"Name"},"username":{"CN":"登录账号","EN":"Account"},"password":{"CN":"登录密码","EN":"Password"},"utype":{"CN":"用户类型","EN":"User Type"},"uStatus":{"CN":"用户状态","EN":"Status"},"orgID":{"CN":"机构编号","EN":"Organization Code"}},"games":{"cock_chip":{"CN":"斗鸡芯片号","EN":"Chip Code"},"breedName":{"CN":"品种","EN":"Bloodline"},"owner":{"CN":"鸡主","EN":"Owner"},"org_id":{"CN":"机构编号","EN":"Organization Code"},"status":{"CN":"斗鸡状态","EN":"Status"},"createUser":{"CN":"记录人","EN":"Recorder"},"createAt":{"CN":"记录生成日期","EN":"Created On"},"win_cock":{"CN":"获胜斗鸡芯片号","EN":"Chip Code"},"result_time":{"CN":"比赛结果生成时间","EN":"Game Date"}},"diction":{"dictName":{"CN":"行政区域名称","EN":"Province"},"areaName":{"CN":"岛屿名称","EN":"Area"},"prompt":{"CN":"请选择行政区域","EN":"Please choose Province"}},"area":{"areaName":{"CN":"岛屿名称","EN":"Area"},"prompt":{"CN":"请选择岛屿","EN":"Please choose Area"}},"chip":{"chipCode":{"CN":"芯片编号","EN":"Chip Code"},"create_userid":{"CN":"录入用户","EN":"Creator"},"createdate":{"CN":"录入时间","EN":"Created On"},"isused":{"CN":"是否使用","EN":"Is Used"},"usedate":{"CN":"使用日期","EN":"Used Date"},"sub_orgid":{"CN":"所属机构","EN":"Organization"},"chip_start":{"CN":"芯片起始号","EN":"Starting ChipCode"},"chip_end":{"CN":"芯片结束号","EN":"End ChipCode"}},"StatusData":{"cocks":{"cStatus":[{"CN":"正常","EN":"Normal","#text":"1"},{"CN":"淘汰","EN":"Abort","#text":"2"},{"CN":"走失","EN":"Lost","#text":"3"}]},"userStatus":{"uStatus":[{"CN":"正常","EN":"Normal","#text":"1"},{"CN":"注销","EN":"Unregister","#text":"2"}]},"userType":{"utype":[{"CN":"机构用户","EN":"System User","#text":"1"},{"CN":"鸡主用户","EN":"Owner","#text":"2"}]}},"TitleData":{"title":[{"CN":"先生","EN":"Mr","#text":"1"},{"CN":"女士","EN":"Mrs","#text":"2"}]},"DB_PROC":{"cocks":{"add":{"msg":[{"CN":"斗鸡信息添加成功！","EN":"Information added","#text":"1"},{"CN":"此芯片未授权，请更换！","EN":"The chip code is unauthorized, please try another","#text":"-1"},{"CN":"此芯片已被使用，请更换！","EN":"The chip code has been used, please try another","#text":"-2"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]},"get":{"msg":[{"CN":"检索成功！","EN":"Data retrieved","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"未检索到符合条件的记录！","EN":"No match found!","#text":"-2"}]},"update_regdate":{"msg":[{"CN":"登记评定成功！","EN":"Registration successed","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]},"update_status":{"msg":[{"CN":"斗鸡状态更新成功！","EN":"Status has been updated","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]}},"owners":{"login":{"msg":[{"CN":"登录成功，欢迎使用！","EN":"Login successfully","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"登录失败，用户名或密码错误！","EN":"user name or password do not match","#text":"-2"}]}}},"Upload_Image":{"msg":[{"CN":"图片上传成功","EN":"Image has been uploaded","#text":"1"},{"CN":"请选择上传图片","EN":"Please choose image","#text":"-1"},{"CN":"图片大小超过限制","EN":"The image is over size","#text":"-2"},{"CN":"不支持上传图片的类型","EN":"Image format does not supported","#text":"-3"},{"CN":"系统错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]},"basic":{"operation":{"CN":"操作","EN":"Operation"},"edit":{"CN":"编辑","EN":"Edit"},"del":{"CN":"编辑","EN":"Remove"},"keyword":{"CN":"请输入你要查询的关键字","EN":""},"cardno":{"CN":"请输入查询人的证件号码","EN":""},"tel":{"CN":"请输入查询人的电话号码","EN":""},"image":{"CN":"还没有斗鸡照片，请上传","EN":""},"search":{"CN":"搜索","EN":"Search"},"New":{"CN":"增加","EN":"New"},"upload":{"CN":"上传","EN":"Upload"},"clear":{"CN":"清除关键字搜索","EN":""},"confirm":{"CN":"确定","EN":"Confirm"},"cancel":{"CN":"取消","EN":"Cancel"}},"keyword":{"keyword_1":{"CN":"请输入芯片编号","EN":""},"keyword_2":{"CN":"请输入斗鸡编号","EN":""},"keyword_3":{"CN":"请选择斗鸡品种","EN":""},"keyword_4":{"CN":"请选择出生日期","EN":"Hatch Date"},"keyword_5":{"CN":"请输入芯片号，斗鸡编号鸡主名称或养殖场名称关键字进行搜索","EN":""},"keyword_6":{"CN":"请输入机构名称名称关键字进行搜索","EN":""},"keyword_7":{"CN":"请输入鸡主证件号码关键字进行搜索","EN":""},"keyword_8":{"CN":"请输入养殖场关键字进行搜索","EN":""},"keyword_9":{"CN":"请输入引进人电话关键字进行搜索","EN":""},"keyword_10":{"CN":"请上传斗鸡照片","EN":""},"keyword_11":{"CN":"请输入养殖场，联系人，养殖场电话关键字进行搜索","EN":""},"keyword_12":{"CN":"请输入鸡主名称，证件号码，联系电话关键字进行搜索","EN":""},"keyword_13":{"CN":"请输入养殖场名称","EN":""},"keyword_14":{"CN":"请输入养殖场地址","EN":""},"keyword_15":{"CN":"请输入养殖场联系人","EN":""},"keyword_16":{"CN":"请输入联系人电话","EN":""},"keyword_17":{"CN":"请选择联系人称谓","EN":""},"keyword_18":{"CN":"请输入引进人名称","EN":""},"keyword_19":{"CN":"请输入引进人地址","EN":""},"keyword_20":{"CN":"请输入引进人电话","EN":""},"keyword_21":{"CN":"请输入鸡主名称","EN":""},"keyword_22":{"CN":"请输入鸡主称谓","EN":""},"keyword_23":{"CN":"请输入鸡主地址","EN":""},"keyword_24":{"CN":"请输入鸡主电话","EN":""},"keyword_25":{"CN":"请输入鸡主证件号码","EN":""},"keyword_26":{"CN":"请输入登录账号","EN":""},"keyword_27":{"CN":"请输入登录密码","EN":""},"keyword_28":{"CN":"请输选择地区范围","EN":""},"keyword_29":{"CN":"请输选择行政区域","EN":""}},"confirm":{"submit":{"CN":"信息数据已提交，是否回到列表页","EN":""},"remove":{"CN":"请您确认是否需要删除该条记录？","EN":""},"logout":{"CN":"请您确认是否需要淘汰该斗鸡？","EN":""}},"menu":{"dashboard":{"CN":"首页","EN":"Dashboard"},"cock_manage":{"CN":"斗鸡管理","EN":"Game Fowl Management"},"cock_edit":{"CN":"斗鸡编辑","EN":"Game Fowl Edit"},"cock_detail":{"CN":"斗鸡详情","EN":"Game Fowl Detail"},"account_manage":{"CN":"账号管理","EN":"Account Management"},"chip_manage":{"CN":"芯片管理","EN":"Chip Management"},"setting":{"CN":"系统设置","EN":"Setting"},"breed_manage":{"CN":"斗鸡种类管理","EN":"Bloodline Management"},"area_manage":{"CN":"岛屿管理","EN":"Area Management"},"province_manage":{"CN":"行政区划管理","EN":"Province Management"},"org_manage":{"CN":"比赛机构管理","EN":"Federation Management"},"farm_manage":{"CN":"养殖场管理","EN":"Game Farm Management"},"oversear_farm":{"CN":"海外养殖场","EN":"Oversear Farm"},"local_farm":{"CN":"本地养殖场","EN":"Local Farm"},"owner_manage":{"CN":"鸡主场管理","EN":"Owner Management"},"user_manage":{"CN":"用户管理","EN":"User Management"}},"subtitle":{"new_cock":{"CN":"新增斗鸡","EN":"New Game Fowl"},"edit_cock":{"CN":"编辑斗鸡","EN":"Edit Game Fowl"},"new_farm":{"CN":"新增养殖场","EN":"New Game Farm"},"edit_farm":{"CN":"编辑养殖场","EN":"Edit Game Farm"},"new_org":{"CN":"新增机构","EN":"New Federation"},"edit_org":{"CN":"编辑机构","EN":"Edit Federation"},"pnew_owner":{"CN":"新增鸡主","EN":"New Owner"},"edit_owner":{"CN":"编辑鸡主","EN":"Edit Owner"},"new_user":{"CN":"新增用户","EN":"New User"},"edit_user":{"CN":"编辑用户","EN":"Edit User"},"edit_area":{"CN":"新增地区","EN":"New Area"},"edit_province":{"CN":"新增行政区域","EN":"New Province"}},"version":{"no":"1.3"}}
     */

    private DictionaryBean Dictionary;

    public static XmlBean objectFromData(String str) {

        return new Gson().fromJson(str, XmlBean.class);
    }

    public DictionaryBean getDictionary() {
        return Dictionary;
    }

    public void setDictionary(DictionaryBean Dictionary) {
        this.Dictionary = Dictionary;
    }

    public static class DictionaryBean {
        /**
         * cocks : {"chipCode":{"CN":"芯片编号","EN":"Chip Code"},"cockNo":{"CN":"赛事名称","EN":"Derby Entry"},"breedID":{"CN":"品种","EN":"Bloodline"},"memo":{"CN":"备注信息","EN":"Remark"},"birth":{"CN":"出生日期","EN":"Hatch Date"},"org":{"CN":"比赛机构","EN":"Federation"},"orgID":{"CN":"协会名称","EN":"Organization"},"cStatus":{"CN":"斗鸡状态","EN":"Status"},"farmID":{"CN":"养殖场名称","EN":"Game Farm"},"photo_len":{"CN":"斗鸡照片 len","EN":"Leg Photo"},"photo_skin":{"CN":"斗鸡照片 skin","EN":"Skin Photo"},"creatorid":{"CN":"创建人","EN":"Creater"},"createAt":{"CN":"创建时间","EN":"Created On"},"lastOwnerID":{"CN":"当前鸡主","EN":"Owner Info"},"regDate1":{"CN":"第一阶段","EN":"Register 1st"},"regDate2":{"CN":"第二阶段","EN":"Register 2nd"},"regDate3":{"CN":"第三阶段","EN":"Register 3rd"},"isImport":{"CN":"是否进口","EN":"Is Importable"},"importerID":{"CN":"引进人","EN":"Importer"}}
         * owners : {"ownerName":{"CN":"鸡主姓名","EN":"Owner"},"oTitle":{"CN":"称谓","EN":"Title"},"oAddress":{"CN":"鸡主地址","EN":"Address"},"oTel":{"CN":"鸡主电话","EN":"Tel."},"oIDNo":{"CN":"证件号码","EN":"License/Passport ID"},"ownDate":{"CN":"创建日期","EN":"Created On"},"oDictionID":{"CN":"行政区域名称","EN":"Province"},"isPersonal":{"CN":"是否是个人","EN":"Individual"},"farmid":{"CN":"养殖场名称","EN":"Game Farm"},"username":{"CN":"登录账号","EN":"Account"},"password":{"CN":"登录密码","EN":"Password"}}
         * organization : {"orgName":{"CN":"协会名称","EN":"Federation"},"email":{"CN":"电子邮件","EN":"Email"},"gAddress":{"CN":"地址","EN":"Address"},"gTel":{"CN":"电话","EN":"Tel."},"gContactor":{"CN":"联系人","EN":"Contact"},"gTitle":{"CN":"称谓","EN":"Title"},"gCode":{"CN":"机构代码","EN":"Code"},"parentID":{"CN":"母机构编号","EN":"Main Federation"}}
         * farm : {"mFarmName":{"CN":"养殖场名称","EN":"Game Farm"},"mContactor":{"CN":"联系人","EN":"Contact"},"mTitle":{"CN":"称谓","EN":"Title"},"mAddress":{"CN":"地址","EN":"Address"},"mDictionID":{"CN":"行政区域名称","EN":"Province"},"mTel":{"CN":"电话","EN":"Tel."},"overseaFarm":{"CN":"海外养殖场","EN":"Oversea Farm"},"isOversea":{"CN":"是否是海外养殖场","EN":"Is Oversea Farm"}}
         * importer : {"importerName":{"CN":"引进人姓名","EN":"Importer"},"iAddress":{"CN":"地址","EN":"Address"},"iTel":{"CN":"电话","EN":"Mobile"},"iTitle":{"CN":"称谓","EN":"Title"}}
         * breed : {"breedName":{"CN":"品种名称","EN":"Bloodline"}}
         * user : {"uRealname":{"CN":"真实姓名","EN":"Name"},"username":{"CN":"登录账号","EN":"Account"},"password":{"CN":"登录密码","EN":"Password"},"utype":{"CN":"用户类型","EN":"User Type"},"uStatus":{"CN":"用户状态","EN":"Status"},"orgID":{"CN":"机构编号","EN":"Organization Code"}}
         * games : {"cock_chip":{"CN":"斗鸡芯片号","EN":"Chip Code"},"breedName":{"CN":"品种","EN":"Bloodline"},"owner":{"CN":"鸡主","EN":"Owner"},"org_id":{"CN":"机构编号","EN":"Organization Code"},"status":{"CN":"斗鸡状态","EN":"Status"},"createUser":{"CN":"记录人","EN":"Recorder"},"createAt":{"CN":"记录生成日期","EN":"Created On"},"win_cock":{"CN":"获胜斗鸡芯片号","EN":"Chip Code"},"result_time":{"CN":"比赛结果生成时间","EN":"Game Date"}}
         * diction : {"dictName":{"CN":"行政区域名称","EN":"Province"},"areaName":{"CN":"岛屿名称","EN":"Area"},"prompt":{"CN":"请选择行政区域","EN":"Please choose Province"}}
         * area : {"areaName":{"CN":"岛屿名称","EN":"Area"},"prompt":{"CN":"请选择岛屿","EN":"Please choose Area"}}
         * chip : {"chipCode":{"CN":"芯片编号","EN":"Chip Code"},"create_userid":{"CN":"录入用户","EN":"Creator"},"createdate":{"CN":"录入时间","EN":"Created On"},"isused":{"CN":"是否使用","EN":"Is Used"},"usedate":{"CN":"使用日期","EN":"Used Date"},"sub_orgid":{"CN":"所属机构","EN":"Organization"},"chip_start":{"CN":"芯片起始号","EN":"Starting ChipCode"},"chip_end":{"CN":"芯片结束号","EN":"End ChipCode"}}
         * StatusData : {"cocks":{"cStatus":[{"CN":"正常","EN":"Normal","#text":"1"},{"CN":"淘汰","EN":"Abort","#text":"2"},{"CN":"走失","EN":"Lost","#text":"3"}]},"userStatus":{"uStatus":[{"CN":"正常","EN":"Normal","#text":"1"},{"CN":"注销","EN":"Unregister","#text":"2"}]},"userType":{"utype":[{"CN":"机构用户","EN":"System User","#text":"1"},{"CN":"鸡主用户","EN":"Owner","#text":"2"}]}}
         * TitleData : {"title":[{"CN":"先生","EN":"Mr","#text":"1"},{"CN":"女士","EN":"Mrs","#text":"2"}]}
         * DB_PROC : {"cocks":{"add":{"msg":[{"CN":"斗鸡信息添加成功！","EN":"Information added","#text":"1"},{"CN":"此芯片未授权，请更换！","EN":"The chip code is unauthorized, please try another","#text":"-1"},{"CN":"此芯片已被使用，请更换！","EN":"The chip code has been used, please try another","#text":"-2"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]},"get":{"msg":[{"CN":"检索成功！","EN":"Data retrieved","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"未检索到符合条件的记录！","EN":"No match found!","#text":"-2"}]},"update_regdate":{"msg":[{"CN":"登记评定成功！","EN":"Registration successed","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]},"update_status":{"msg":[{"CN":"斗鸡状态更新成功！","EN":"Status has been updated","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]}},"owners":{"login":{"msg":[{"CN":"登录成功，欢迎使用！","EN":"Login successfully","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"登录失败，用户名或密码错误！","EN":"user name or password do not match","#text":"-2"}]}}}
         * Upload_Image : {"msg":[{"CN":"图片上传成功","EN":"Image has been uploaded","#text":"1"},{"CN":"请选择上传图片","EN":"Please choose image","#text":"-1"},{"CN":"图片大小超过限制","EN":"The image is over size","#text":"-2"},{"CN":"不支持上传图片的类型","EN":"Image format does not supported","#text":"-3"},{"CN":"系统错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]}
         * basic : {"operation":{"CN":"操作","EN":"Operation"},"edit":{"CN":"编辑","EN":"Edit"},"del":{"CN":"编辑","EN":"Remove"},"keyword":{"CN":"请输入你要查询的关键字","EN":""},"cardno":{"CN":"请输入查询人的证件号码","EN":""},"tel":{"CN":"请输入查询人的电话号码","EN":""},"image":{"CN":"还没有斗鸡照片，请上传","EN":""},"search":{"CN":"搜索","EN":"Search"},"New":{"CN":"增加","EN":"New"},"upload":{"CN":"上传","EN":"Upload"},"clear":{"CN":"清除关键字搜索","EN":""},"confirm":{"CN":"确定","EN":"Confirm"},"cancel":{"CN":"取消","EN":"Cancel"}}
         * keyword : {"keyword_1":{"CN":"请输入芯片编号","EN":""},"keyword_2":{"CN":"请输入斗鸡编号","EN":""},"keyword_3":{"CN":"请选择斗鸡品种","EN":""},"keyword_4":{"CN":"请选择出生日期","EN":"Hatch Date"},"keyword_5":{"CN":"请输入芯片号，斗鸡编号鸡主名称或养殖场名称关键字进行搜索","EN":""},"keyword_6":{"CN":"请输入机构名称名称关键字进行搜索","EN":""},"keyword_7":{"CN":"请输入鸡主证件号码关键字进行搜索","EN":""},"keyword_8":{"CN":"请输入养殖场关键字进行搜索","EN":""},"keyword_9":{"CN":"请输入引进人电话关键字进行搜索","EN":""},"keyword_10":{"CN":"请上传斗鸡照片","EN":""},"keyword_11":{"CN":"请输入养殖场，联系人，养殖场电话关键字进行搜索","EN":""},"keyword_12":{"CN":"请输入鸡主名称，证件号码，联系电话关键字进行搜索","EN":""},"keyword_13":{"CN":"请输入养殖场名称","EN":""},"keyword_14":{"CN":"请输入养殖场地址","EN":""},"keyword_15":{"CN":"请输入养殖场联系人","EN":""},"keyword_16":{"CN":"请输入联系人电话","EN":""},"keyword_17":{"CN":"请选择联系人称谓","EN":""},"keyword_18":{"CN":"请输入引进人名称","EN":""},"keyword_19":{"CN":"请输入引进人地址","EN":""},"keyword_20":{"CN":"请输入引进人电话","EN":""},"keyword_21":{"CN":"请输入鸡主名称","EN":""},"keyword_22":{"CN":"请输入鸡主称谓","EN":""},"keyword_23":{"CN":"请输入鸡主地址","EN":""},"keyword_24":{"CN":"请输入鸡主电话","EN":""},"keyword_25":{"CN":"请输入鸡主证件号码","EN":""},"keyword_26":{"CN":"请输入登录账号","EN":""},"keyword_27":{"CN":"请输入登录密码","EN":""},"keyword_28":{"CN":"请输选择地区范围","EN":""},"keyword_29":{"CN":"请输选择行政区域","EN":""}}
         * confirm : {"submit":{"CN":"信息数据已提交，是否回到列表页","EN":""},"remove":{"CN":"请您确认是否需要删除该条记录？","EN":""},"logout":{"CN":"请您确认是否需要淘汰该斗鸡？","EN":""}}
         * menu : {"dashboard":{"CN":"首页","EN":"Dashboard"},"cock_manage":{"CN":"斗鸡管理","EN":"Game Fowl Management"},"cock_edit":{"CN":"斗鸡编辑","EN":"Game Fowl Edit"},"cock_detail":{"CN":"斗鸡详情","EN":"Game Fowl Detail"},"account_manage":{"CN":"账号管理","EN":"Account Management"},"chip_manage":{"CN":"芯片管理","EN":"Chip Management"},"setting":{"CN":"系统设置","EN":"Setting"},"breed_manage":{"CN":"斗鸡种类管理","EN":"Bloodline Management"},"area_manage":{"CN":"岛屿管理","EN":"Area Management"},"province_manage":{"CN":"行政区划管理","EN":"Province Management"},"org_manage":{"CN":"比赛机构管理","EN":"Federation Management"},"farm_manage":{"CN":"养殖场管理","EN":"Game Farm Management"},"oversear_farm":{"CN":"海外养殖场","EN":"Oversear Farm"},"local_farm":{"CN":"本地养殖场","EN":"Local Farm"},"owner_manage":{"CN":"鸡主场管理","EN":"Owner Management"},"user_manage":{"CN":"用户管理","EN":"User Management"}}
         * subtitle : {"new_cock":{"CN":"新增斗鸡","EN":"New Game Fowl"},"edit_cock":{"CN":"编辑斗鸡","EN":"Edit Game Fowl"},"new_farm":{"CN":"新增养殖场","EN":"New Game Farm"},"edit_farm":{"CN":"编辑养殖场","EN":"Edit Game Farm"},"new_org":{"CN":"新增机构","EN":"New Federation"},"edit_org":{"CN":"编辑机构","EN":"Edit Federation"},"pnew_owner":{"CN":"新增鸡主","EN":"New Owner"},"edit_owner":{"CN":"编辑鸡主","EN":"Edit Owner"},"new_user":{"CN":"新增用户","EN":"New User"},"edit_user":{"CN":"编辑用户","EN":"Edit User"},"edit_area":{"CN":"新增地区","EN":"New Area"},"edit_province":{"CN":"新增行政区域","EN":"New Province"}}
         * version : {"no":"1.3"}
         */

        private CocksBean cocks;
        private OwnersBean owners;
        private OrganizationBean organization;
        private FarmBean farm;
        private ImporterBean importer;
        private BreedBean breed;
        private UserBean user;
        private GamesBean games;
        private DictionBean diction;
        private AreaBean area;
        private ChipBean chip;
        private StatusDataBean StatusData;
        private TitleDataBean TitleData;
        private DBPROCBean DB_PROC;
        private UploadImageBean Upload_Image;
        private BasicBean basic;
        private KeywordBeanX keyword;
        private ConfirmBeanX confirm;
        private MenuBean menu;
        private SubtitleBean subtitle;
        private VersionBean version;

        public static DictionaryBean objectFromData(String str) {

            return new Gson().fromJson(str, DictionaryBean.class);
        }

        public CocksBean getCocks() {
            return cocks;
        }

        public void setCocks(CocksBean cocks) {
            this.cocks = cocks;
        }

        public OwnersBean getOwners() {
            return owners;
        }

        public void setOwners(OwnersBean owners) {
            this.owners = owners;
        }

        public OrganizationBean getOrganization() {
            return organization;
        }

        public void setOrganization(OrganizationBean organization) {
            this.organization = organization;
        }

        public FarmBean getFarm() {
            return farm;
        }

        public void setFarm(FarmBean farm) {
            this.farm = farm;
        }

        public ImporterBean getImporter() {
            return importer;
        }

        public void setImporter(ImporterBean importer) {
            this.importer = importer;
        }

        public BreedBean getBreed() {
            return breed;
        }

        public void setBreed(BreedBean breed) {
            this.breed = breed;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public GamesBean getGames() {
            return games;
        }

        public void setGames(GamesBean games) {
            this.games = games;
        }

        public DictionBean getDiction() {
            return diction;
        }

        public void setDiction(DictionBean diction) {
            this.diction = diction;
        }

        public AreaBean getArea() {
            return area;
        }

        public void setArea(AreaBean area) {
            this.area = area;
        }

        public ChipBean getChip() {
            return chip;
        }

        public void setChip(ChipBean chip) {
            this.chip = chip;
        }

        public StatusDataBean getStatusData() {
            return StatusData;
        }

        public void setStatusData(StatusDataBean StatusData) {
            this.StatusData = StatusData;
        }

        public TitleDataBean getTitleData() {
            return TitleData;
        }

        public void setTitleData(TitleDataBean TitleData) {
            this.TitleData = TitleData;
        }

        public DBPROCBean getDB_PROC() {
            return DB_PROC;
        }

        public void setDB_PROC(DBPROCBean DB_PROC) {
            this.DB_PROC = DB_PROC;
        }

        public UploadImageBean getUpload_Image() {
            return Upload_Image;
        }

        public void setUpload_Image(UploadImageBean Upload_Image) {
            this.Upload_Image = Upload_Image;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public KeywordBeanX getKeyword() {
            return keyword;
        }

        public void setKeyword(KeywordBeanX keyword) {
            this.keyword = keyword;
        }

        public ConfirmBeanX getConfirm() {
            return confirm;
        }

        public void setConfirm(ConfirmBeanX confirm) {
            this.confirm = confirm;
        }

        public MenuBean getMenu() {
            return menu;
        }

        public void setMenu(MenuBean menu) {
            this.menu = menu;
        }

        public SubtitleBean getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(SubtitleBean subtitle) {
            this.subtitle = subtitle;
        }

        public VersionBean getVersion() {
            return version;
        }

        public void setVersion(VersionBean version) {
            this.version = version;
        }

        public static class CocksBean {
            /**
             * chipCode : {"CN":"芯片编号","EN":"Chip Code"}
             * cockNo : {"CN":"赛事名称","EN":"Derby Entry"}
             * breedID : {"CN":"品种","EN":"Bloodline"}
             * memo : {"CN":"备注信息","EN":"Remark"}
             * birth : {"CN":"出生日期","EN":"Hatch Date"}
             * org : {"CN":"比赛机构","EN":"Federation"}
             * orgID : {"CN":"协会名称","EN":"Organization"}
             * cStatus : {"CN":"斗鸡状态","EN":"Status"}
             * farmID : {"CN":"养殖场名称","EN":"Game Farm"}
             * photo_len : {"CN":"斗鸡照片 len","EN":"Leg Photo"}
             * photo_skin : {"CN":"斗鸡照片 skin","EN":"Skin Photo"}
             * creatorid : {"CN":"创建人","EN":"Creater"}
             * createAt : {"CN":"创建时间","EN":"Created On"}
             * lastOwnerID : {"CN":"当前鸡主","EN":"Owner Info"}
             * regDate1 : {"CN":"第一阶段","EN":"Register 1st"}
             * regDate2 : {"CN":"第二阶段","EN":"Register 2nd"}
             * regDate3 : {"CN":"第三阶段","EN":"Register 3rd"}
             * isImport : {"CN":"是否进口","EN":"Is Importable"}
             * importerID : {"CN":"引进人","EN":"Importer"}
             */

            private ChipCodeBean chipCode;
            private CockNoBean cockNo;
            private BreedIDBean breedID;
            private MemoBean memo;
            private BirthBean birth;
            private OrgBean org;
            private OrgIDBean orgID;
            private CStatusBean cStatus;
            private FarmIDBean farmID;
            private PhotoLenBean photo_len;
            private PhotoSkinBean photo_skin;
            private CreatoridBean creatorid;
            private CreateAtBean createAt;
            private LastOwnerIDBean lastOwnerID;
            private RegDate1Bean regDate1;
            private RegDate2Bean regDate2;
            private RegDate3Bean regDate3;
            private IsImportBean isImport;
            private ImporterIDBean importerID;

            public static CocksBean objectFromData(String str) {

                return new Gson().fromJson(str, CocksBean.class);
            }

            public ChipCodeBean getChipCode() {
                return chipCode;
            }

            public void setChipCode(ChipCodeBean chipCode) {
                this.chipCode = chipCode;
            }

            public CockNoBean getCockNo() {
                return cockNo;
            }

            public void setCockNo(CockNoBean cockNo) {
                this.cockNo = cockNo;
            }

            public BreedIDBean getBreedID() {
                return breedID;
            }

            public void setBreedID(BreedIDBean breedID) {
                this.breedID = breedID;
            }

            public MemoBean getMemo() {
                return memo;
            }

            public void setMemo(MemoBean memo) {
                this.memo = memo;
            }

            public BirthBean getBirth() {
                return birth;
            }

            public void setBirth(BirthBean birth) {
                this.birth = birth;
            }

            public OrgBean getOrg() {
                return org;
            }

            public void setOrg(OrgBean org) {
                this.org = org;
            }

            public OrgIDBean getOrgID() {
                return orgID;
            }

            public void setOrgID(OrgIDBean orgID) {
                this.orgID = orgID;
            }

            public CStatusBean getCStatus() {
                return cStatus;
            }

            public void setCStatus(CStatusBean cStatus) {
                this.cStatus = cStatus;
            }

            public FarmIDBean getFarmID() {
                return farmID;
            }

            public void setFarmID(FarmIDBean farmID) {
                this.farmID = farmID;
            }

            public PhotoLenBean getPhoto_len() {
                return photo_len;
            }

            public void setPhoto_len(PhotoLenBean photo_len) {
                this.photo_len = photo_len;
            }

            public PhotoSkinBean getPhoto_skin() {
                return photo_skin;
            }

            public void setPhoto_skin(PhotoSkinBean photo_skin) {
                this.photo_skin = photo_skin;
            }

            public CreatoridBean getCreatorid() {
                return creatorid;
            }

            public void setCreatorid(CreatoridBean creatorid) {
                this.creatorid = creatorid;
            }

            public CreateAtBean getCreateAt() {
                return createAt;
            }

            public void setCreateAt(CreateAtBean createAt) {
                this.createAt = createAt;
            }

            public LastOwnerIDBean getLastOwnerID() {
                return lastOwnerID;
            }

            public void setLastOwnerID(LastOwnerIDBean lastOwnerID) {
                this.lastOwnerID = lastOwnerID;
            }

            public RegDate1Bean getRegDate1() {
                return regDate1;
            }

            public void setRegDate1(RegDate1Bean regDate1) {
                this.regDate1 = regDate1;
            }

            public RegDate2Bean getRegDate2() {
                return regDate2;
            }

            public void setRegDate2(RegDate2Bean regDate2) {
                this.regDate2 = regDate2;
            }

            public RegDate3Bean getRegDate3() {
                return regDate3;
            }

            public void setRegDate3(RegDate3Bean regDate3) {
                this.regDate3 = regDate3;
            }

            public IsImportBean getIsImport() {
                return isImport;
            }

            public void setIsImport(IsImportBean isImport) {
                this.isImport = isImport;
            }

            public ImporterIDBean getImporterID() {
                return importerID;
            }

            public void setImporterID(ImporterIDBean importerID) {
                this.importerID = importerID;
            }

            public static class ChipCodeBean {
                /**
                 * CN : 芯片编号
                 * EN : Chip Code
                 */

                private String CN;
                private String EN;

                public static ChipCodeBean objectFromData(String str) {

                    return new Gson().fromJson(str, ChipCodeBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CockNoBean {
                /**
                 * CN : 赛事名称
                 * EN : Derby Entry
                 */

                private String CN;
                private String EN;

                public static CockNoBean objectFromData(String str) {

                    return new Gson().fromJson(str, CockNoBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class BreedIDBean {
                /**
                 * CN : 品种
                 * EN : Bloodline
                 */

                private String CN;
                private String EN;

                public static BreedIDBean objectFromData(String str) {

                    return new Gson().fromJson(str, BreedIDBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class MemoBean {
                /**
                 * CN : 备注信息
                 * EN : Remark
                 */

                private String CN;
                private String EN;

                public static MemoBean objectFromData(String str) {

                    return new Gson().fromJson(str, MemoBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class BirthBean {
                /**
                 * CN : 出生日期
                 * EN : Hatch Date
                 */

                private String CN;
                private String EN;

                public static BirthBean objectFromData(String str) {

                    return new Gson().fromJson(str, BirthBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OrgBean {
                /**
                 * CN : 比赛机构
                 * EN : Federation
                 */

                private String CN;
                private String EN;

                public static OrgBean objectFromData(String str) {

                    return new Gson().fromJson(str, OrgBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OrgIDBean {
                /**
                 * CN : 协会名称
                 * EN : Organization
                 */

                private String CN;
                private String EN;

                public static OrgIDBean objectFromData(String str) {

                    return new Gson().fromJson(str, OrgIDBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CStatusBean {
                /**
                 * CN : 斗鸡状态
                 * EN : Status
                 */

                private String CN;
                private String EN;

                public static CStatusBean objectFromData(String str) {

                    return new Gson().fromJson(str, CStatusBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class FarmIDBean {
                /**
                 * CN : 养殖场名称
                 * EN : Game Farm
                 */

                private String CN;
                private String EN;

                public static FarmIDBean objectFromData(String str) {

                    return new Gson().fromJson(str, FarmIDBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class PhotoLenBean {
                /**
                 * CN : 斗鸡照片 len
                 * EN : Leg Photo
                 */

                private String CN;
                private String EN;

                public static PhotoLenBean objectFromData(String str) {

                    return new Gson().fromJson(str, PhotoLenBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class PhotoSkinBean {
                /**
                 * CN : 斗鸡照片 skin
                 * EN : Skin Photo
                 */

                private String CN;
                private String EN;

                public static PhotoSkinBean objectFromData(String str) {

                    return new Gson().fromJson(str, PhotoSkinBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CreatoridBean {
                /**
                 * CN : 创建人
                 * EN : Creater
                 */

                private String CN;
                private String EN;

                public static CreatoridBean objectFromData(String str) {

                    return new Gson().fromJson(str, CreatoridBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CreateAtBean {
                /**
                 * CN : 创建时间
                 * EN : Created On
                 */

                private String CN;
                private String EN;

                public static CreateAtBean objectFromData(String str) {

                    return new Gson().fromJson(str, CreateAtBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class LastOwnerIDBean {
                /**
                 * CN : 当前鸡主
                 * EN : Owner Info
                 */

                private String CN;
                private String EN;

                public static LastOwnerIDBean objectFromData(String str) {

                    return new Gson().fromJson(str, LastOwnerIDBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class RegDate1Bean {
                /**
                 * CN : 第一阶段
                 * EN : Register 1st
                 */

                private String CN;
                private String EN;

                public static RegDate1Bean objectFromData(String str) {

                    return new Gson().fromJson(str, RegDate1Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class RegDate2Bean {
                /**
                 * CN : 第二阶段
                 * EN : Register 2nd
                 */

                private String CN;
                private String EN;

                public static RegDate2Bean objectFromData(String str) {

                    return new Gson().fromJson(str, RegDate2Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class RegDate3Bean {
                /**
                 * CN : 第三阶段
                 * EN : Register 3rd
                 */

                private String CN;
                private String EN;

                public static RegDate3Bean objectFromData(String str) {

                    return new Gson().fromJson(str, RegDate3Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class IsImportBean {
                /**
                 * CN : 是否进口
                 * EN : Is Importable
                 */

                private String CN;
                private String EN;

                public static IsImportBean objectFromData(String str) {

                    return new Gson().fromJson(str, IsImportBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ImporterIDBean {
                /**
                 * CN : 引进人
                 * EN : Importer
                 */

                private String CN;
                private String EN;

                public static ImporterIDBean objectFromData(String str) {

                    return new Gson().fromJson(str, ImporterIDBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class OwnersBean {
            /**
             * ownerName : {"CN":"鸡主姓名","EN":"Owner"}
             * oTitle : {"CN":"称谓","EN":"Title"}
             * oAddress : {"CN":"鸡主地址","EN":"Address"}
             * oTel : {"CN":"鸡主电话","EN":"Tel."}
             * oIDNo : {"CN":"证件号码","EN":"License/Passport ID"}
             * ownDate : {"CN":"创建日期","EN":"Created On"}
             * oDictionID : {"CN":"行政区域名称","EN":"Province"}
             * isPersonal : {"CN":"是否是个人","EN":"Individual"}
             * farmid : {"CN":"养殖场名称","EN":"Game Farm"}
             * username : {"CN":"登录账号","EN":"Account"}
             * password : {"CN":"登录密码","EN":"Password"}
             */

            private OwnerNameBean ownerName;
            private OTitleBean oTitle;
            private OAddressBean oAddress;
            private OTelBean oTel;
            private OIDNoBean oIDNo;
            private OwnDateBean ownDate;
            private ODictionIDBean oDictionID;
            private IsPersonalBean isPersonal;
            private FarmidBean farmid;
            private UsernameBean username;
            private PasswordBean password;

            public static OwnersBean objectFromData(String str) {

                return new Gson().fromJson(str, OwnersBean.class);
            }

            public OwnerNameBean getOwnerName() {
                return ownerName;
            }

            public void setOwnerName(OwnerNameBean ownerName) {
                this.ownerName = ownerName;
            }

            public OTitleBean getOTitle() {
                return oTitle;
            }

            public void setOTitle(OTitleBean oTitle) {
                this.oTitle = oTitle;
            }

            public OAddressBean getOAddress() {
                return oAddress;
            }

            public void setOAddress(OAddressBean oAddress) {
                this.oAddress = oAddress;
            }

            public OTelBean getOTel() {
                return oTel;
            }

            public void setOTel(OTelBean oTel) {
                this.oTel = oTel;
            }

            public OIDNoBean getOIDNo() {
                return oIDNo;
            }

            public void setOIDNo(OIDNoBean oIDNo) {
                this.oIDNo = oIDNo;
            }

            public OwnDateBean getOwnDate() {
                return ownDate;
            }

            public void setOwnDate(OwnDateBean ownDate) {
                this.ownDate = ownDate;
            }

            public ODictionIDBean getODictionID() {
                return oDictionID;
            }

            public void setODictionID(ODictionIDBean oDictionID) {
                this.oDictionID = oDictionID;
            }

            public IsPersonalBean getIsPersonal() {
                return isPersonal;
            }

            public void setIsPersonal(IsPersonalBean isPersonal) {
                this.isPersonal = isPersonal;
            }

            public FarmidBean getFarmid() {
                return farmid;
            }

            public void setFarmid(FarmidBean farmid) {
                this.farmid = farmid;
            }

            public UsernameBean getUsername() {
                return username;
            }

            public void setUsername(UsernameBean username) {
                this.username = username;
            }

            public PasswordBean getPassword() {
                return password;
            }

            public void setPassword(PasswordBean password) {
                this.password = password;
            }

            public static class OwnerNameBean {
                /**
                 * CN : 鸡主姓名
                 * EN : Owner
                 */

                private String CN;
                private String EN;

                public static OwnerNameBean objectFromData(String str) {

                    return new Gson().fromJson(str, OwnerNameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OTitleBean {
                /**
                 * CN : 称谓
                 * EN : Title
                 */

                private String CN;
                private String EN;

                public static OTitleBean objectFromData(String str) {

                    return new Gson().fromJson(str, OTitleBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OAddressBean {
                /**
                 * CN : 鸡主地址
                 * EN : Address
                 */

                private String CN;
                private String EN;

                public static OAddressBean objectFromData(String str) {

                    return new Gson().fromJson(str, OAddressBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OTelBean {
                /**
                 * CN : 鸡主电话
                 * EN : Tel.
                 */

                private String CN;
                private String EN;

                public static OTelBean objectFromData(String str) {

                    return new Gson().fromJson(str, OTelBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OIDNoBean {
                /**
                 * CN : 证件号码
                 * EN : License/Passport ID
                 */

                private String CN;
                private String EN;

                public static OIDNoBean objectFromData(String str) {

                    return new Gson().fromJson(str, OIDNoBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OwnDateBean {
                /**
                 * CN : 创建日期
                 * EN : Created On
                 */

                private String CN;
                private String EN;

                public static OwnDateBean objectFromData(String str) {

                    return new Gson().fromJson(str, OwnDateBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ODictionIDBean {
                /**
                 * CN : 行政区域名称
                 * EN : Province
                 */

                private String CN;
                private String EN;

                public static ODictionIDBean objectFromData(String str) {

                    return new Gson().fromJson(str, ODictionIDBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class IsPersonalBean {
                /**
                 * CN : 是否是个人
                 * EN : Individual
                 */

                private String CN;
                private String EN;

                public static IsPersonalBean objectFromData(String str) {

                    return new Gson().fromJson(str, IsPersonalBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class FarmidBean {
                /**
                 * CN : 养殖场名称
                 * EN : Game Farm
                 */

                private String CN;
                private String EN;

                public static FarmidBean objectFromData(String str) {

                    return new Gson().fromJson(str, FarmidBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class UsernameBean {
                /**
                 * CN : 登录账号
                 * EN : Account
                 */

                private String CN;
                private String EN;

                public static UsernameBean objectFromData(String str) {

                    return new Gson().fromJson(str, UsernameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class PasswordBean {
                /**
                 * CN : 登录密码
                 * EN : Password
                 */

                private String CN;
                private String EN;

                public static PasswordBean objectFromData(String str) {

                    return new Gson().fromJson(str, PasswordBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class OrganizationBean {
            /**
             * orgName : {"CN":"协会名称","EN":"Federation"}
             * email : {"CN":"电子邮件","EN":"Email"}
             * gAddress : {"CN":"地址","EN":"Address"}
             * gTel : {"CN":"电话","EN":"Tel."}
             * gContactor : {"CN":"联系人","EN":"Contact"}
             * gTitle : {"CN":"称谓","EN":"Title"}
             * gCode : {"CN":"机构代码","EN":"Code"}
             * parentID : {"CN":"母机构编号","EN":"Main Federation"}
             */

            private OrgNameBean orgName;
            private EmailBean email;
            private GAddressBean gAddress;
            private GTelBean gTel;
            private GContactorBean gContactor;
            private GTitleBean gTitle;
            private GCodeBean gCode;
            private ParentIDBean parentID;

            public static OrganizationBean objectFromData(String str) {

                return new Gson().fromJson(str, OrganizationBean.class);
            }

            public OrgNameBean getOrgName() {
                return orgName;
            }

            public void setOrgName(OrgNameBean orgName) {
                this.orgName = orgName;
            }

            public EmailBean getEmail() {
                return email;
            }

            public void setEmail(EmailBean email) {
                this.email = email;
            }

            public GAddressBean getGAddress() {
                return gAddress;
            }

            public void setGAddress(GAddressBean gAddress) {
                this.gAddress = gAddress;
            }

            public GTelBean getGTel() {
                return gTel;
            }

            public void setGTel(GTelBean gTel) {
                this.gTel = gTel;
            }

            public GContactorBean getGContactor() {
                return gContactor;
            }

            public void setGContactor(GContactorBean gContactor) {
                this.gContactor = gContactor;
            }

            public GTitleBean getGTitle() {
                return gTitle;
            }

            public void setGTitle(GTitleBean gTitle) {
                this.gTitle = gTitle;
            }

            public GCodeBean getGCode() {
                return gCode;
            }

            public void setGCode(GCodeBean gCode) {
                this.gCode = gCode;
            }

            public ParentIDBean getParentID() {
                return parentID;
            }

            public void setParentID(ParentIDBean parentID) {
                this.parentID = parentID;
            }

            public static class OrgNameBean {
                /**
                 * CN : 协会名称
                 * EN : Federation
                 */

                private String CN;
                private String EN;

                public static OrgNameBean objectFromData(String str) {

                    return new Gson().fromJson(str, OrgNameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EmailBean {
                /**
                 * CN : 电子邮件
                 * EN : Email
                 */

                private String CN;
                private String EN;

                public static EmailBean objectFromData(String str) {

                    return new Gson().fromJson(str, EmailBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class GAddressBean {
                /**
                 * CN : 地址
                 * EN : Address
                 */

                private String CN;
                private String EN;

                public static GAddressBean objectFromData(String str) {

                    return new Gson().fromJson(str, GAddressBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class GTelBean {
                /**
                 * CN : 电话
                 * EN : Tel.
                 */

                private String CN;
                private String EN;

                public static GTelBean objectFromData(String str) {

                    return new Gson().fromJson(str, GTelBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class GContactorBean {
                /**
                 * CN : 联系人
                 * EN : Contact
                 */

                private String CN;
                private String EN;

                public static GContactorBean objectFromData(String str) {

                    return new Gson().fromJson(str, GContactorBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class GTitleBean {
                /**
                 * CN : 称谓
                 * EN : Title
                 */

                private String CN;
                private String EN;

                public static GTitleBean objectFromData(String str) {

                    return new Gson().fromJson(str, GTitleBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class GCodeBean {
                /**
                 * CN : 机构代码
                 * EN : Code
                 */

                private String CN;
                private String EN;

                public static GCodeBean objectFromData(String str) {

                    return new Gson().fromJson(str, GCodeBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ParentIDBean {
                /**
                 * CN : 母机构编号
                 * EN : Main Federation
                 */

                private String CN;
                private String EN;

                public static ParentIDBean objectFromData(String str) {

                    return new Gson().fromJson(str, ParentIDBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class FarmBean {
            /**
             * mFarmName : {"CN":"养殖场名称","EN":"Game Farm"}
             * mContactor : {"CN":"联系人","EN":"Contact"}
             * mTitle : {"CN":"称谓","EN":"Title"}
             * mAddress : {"CN":"地址","EN":"Address"}
             * mDictionID : {"CN":"行政区域名称","EN":"Province"}
             * mTel : {"CN":"电话","EN":"Tel."}
             * overseaFarm : {"CN":"海外养殖场","EN":"Oversea Farm"}
             * isOversea : {"CN":"是否是海外养殖场","EN":"Is Oversea Farm"}
             */

            private MFarmNameBean mFarmName;
            private MContactorBean mContactor;
            private MTitleBean mTitle;
            private MAddressBean mAddress;
            private MDictionIDBean mDictionID;
            private MTelBean mTel;
            private OverseaFarmBean overseaFarm;
            private IsOverseaBean isOversea;

            public static FarmBean objectFromData(String str) {

                return new Gson().fromJson(str, FarmBean.class);
            }

            public MFarmNameBean getMFarmName() {
                return mFarmName;
            }

            public void setMFarmName(MFarmNameBean mFarmName) {
                this.mFarmName = mFarmName;
            }

            public MContactorBean getMContactor() {
                return mContactor;
            }

            public void setMContactor(MContactorBean mContactor) {
                this.mContactor = mContactor;
            }

            public MTitleBean getMTitle() {
                return mTitle;
            }

            public void setMTitle(MTitleBean mTitle) {
                this.mTitle = mTitle;
            }

            public MAddressBean getMAddress() {
                return mAddress;
            }

            public void setMAddress(MAddressBean mAddress) {
                this.mAddress = mAddress;
            }

            public MDictionIDBean getMDictionID() {
                return mDictionID;
            }

            public void setMDictionID(MDictionIDBean mDictionID) {
                this.mDictionID = mDictionID;
            }

            public MTelBean getMTel() {
                return mTel;
            }

            public void setMTel(MTelBean mTel) {
                this.mTel = mTel;
            }

            public OverseaFarmBean getOverseaFarm() {
                return overseaFarm;
            }

            public void setOverseaFarm(OverseaFarmBean overseaFarm) {
                this.overseaFarm = overseaFarm;
            }

            public IsOverseaBean getIsOversea() {
                return isOversea;
            }

            public void setIsOversea(IsOverseaBean isOversea) {
                this.isOversea = isOversea;
            }

            public static class MFarmNameBean {
                /**
                 * CN : 养殖场名称
                 * EN : Game Farm
                 */

                private String CN;
                private String EN;

                public static MFarmNameBean objectFromData(String str) {

                    return new Gson().fromJson(str, MFarmNameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class MContactorBean {
                /**
                 * CN : 联系人
                 * EN : Contact
                 */

                private String CN;
                private String EN;

                public static MContactorBean objectFromData(String str) {

                    return new Gson().fromJson(str, MContactorBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class MTitleBean {
                /**
                 * CN : 称谓
                 * EN : Title
                 */

                private String CN;
                private String EN;

                public static MTitleBean objectFromData(String str) {

                    return new Gson().fromJson(str, MTitleBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class MAddressBean {
                /**
                 * CN : 地址
                 * EN : Address
                 */

                private String CN;
                private String EN;

                public static MAddressBean objectFromData(String str) {

                    return new Gson().fromJson(str, MAddressBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class MDictionIDBean {
                /**
                 * CN : 行政区域名称
                 * EN : Province
                 */

                private String CN;
                private String EN;

                public static MDictionIDBean objectFromData(String str) {

                    return new Gson().fromJson(str, MDictionIDBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class MTelBean {
                /**
                 * CN : 电话
                 * EN : Tel.
                 */

                private String CN;
                private String EN;

                public static MTelBean objectFromData(String str) {

                    return new Gson().fromJson(str, MTelBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OverseaFarmBean {
                /**
                 * CN : 海外养殖场
                 * EN : Oversea Farm
                 */

                private String CN;
                private String EN;

                public static OverseaFarmBean objectFromData(String str) {

                    return new Gson().fromJson(str, OverseaFarmBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class IsOverseaBean {
                /**
                 * CN : 是否是海外养殖场
                 * EN : Is Oversea Farm
                 */

                private String CN;
                private String EN;

                public static IsOverseaBean objectFromData(String str) {

                    return new Gson().fromJson(str, IsOverseaBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class ImporterBean {
            /**
             * importerName : {"CN":"引进人姓名","EN":"Importer"}
             * iAddress : {"CN":"地址","EN":"Address"}
             * iTel : {"CN":"电话","EN":"Mobile"}
             * iTitle : {"CN":"称谓","EN":"Title"}
             */

            private ImporterNameBean importerName;
            private IAddressBean iAddress;
            private ITelBean iTel;
            private ITitleBean iTitle;

            public static ImporterBean objectFromData(String str) {

                return new Gson().fromJson(str, ImporterBean.class);
            }

            public ImporterNameBean getImporterName() {
                return importerName;
            }

            public void setImporterName(ImporterNameBean importerName) {
                this.importerName = importerName;
            }

            public IAddressBean getIAddress() {
                return iAddress;
            }

            public void setIAddress(IAddressBean iAddress) {
                this.iAddress = iAddress;
            }

            public ITelBean getITel() {
                return iTel;
            }

            public void setITel(ITelBean iTel) {
                this.iTel = iTel;
            }

            public ITitleBean getITitle() {
                return iTitle;
            }

            public void setITitle(ITitleBean iTitle) {
                this.iTitle = iTitle;
            }

            public static class ImporterNameBean {
                /**
                 * CN : 引进人姓名
                 * EN : Importer
                 */

                private String CN;
                private String EN;

                public static ImporterNameBean objectFromData(String str) {

                    return new Gson().fromJson(str, ImporterNameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class IAddressBean {
                /**
                 * CN : 地址
                 * EN : Address
                 */

                private String CN;
                private String EN;

                public static IAddressBean objectFromData(String str) {

                    return new Gson().fromJson(str, IAddressBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ITelBean {
                /**
                 * CN : 电话
                 * EN : Mobile
                 */

                private String CN;
                private String EN;

                public static ITelBean objectFromData(String str) {

                    return new Gson().fromJson(str, ITelBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ITitleBean {
                /**
                 * CN : 称谓
                 * EN : Title
                 */

                private String CN;
                private String EN;

                public static ITitleBean objectFromData(String str) {

                    return new Gson().fromJson(str, ITitleBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class BreedBean {
            /**
             * breedName : {"CN":"品种名称","EN":"Bloodline"}
             */

            private BreedNameBean breedName;

            public static BreedBean objectFromData(String str) {

                return new Gson().fromJson(str, BreedBean.class);
            }

            public BreedNameBean getBreedName() {
                return breedName;
            }

            public void setBreedName(BreedNameBean breedName) {
                this.breedName = breedName;
            }

            public static class BreedNameBean {
                /**
                 * CN : 品种名称
                 * EN : Bloodline
                 */

                private String CN;
                private String EN;

                public static BreedNameBean objectFromData(String str) {

                    return new Gson().fromJson(str, BreedNameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class UserBean {
            /**
             * uRealname : {"CN":"真实姓名","EN":"Name"}
             * username : {"CN":"登录账号","EN":"Account"}
             * password : {"CN":"登录密码","EN":"Password"}
             * utype : {"CN":"用户类型","EN":"User Type"}
             * uStatus : {"CN":"用户状态","EN":"Status"}
             * orgID : {"CN":"机构编号","EN":"Organization Code"}
             */

            private URealnameBean uRealname;
            private UsernameBeanX username;
            private PasswordBeanX password;
            private UtypeBean utype;
            private UStatusBean uStatus;
            private OrgIDBeanX orgID;

            public static UserBean objectFromData(String str) {

                return new Gson().fromJson(str, UserBean.class);
            }

            public URealnameBean getURealname() {
                return uRealname;
            }

            public void setURealname(URealnameBean uRealname) {
                this.uRealname = uRealname;
            }

            public UsernameBeanX getUsername() {
                return username;
            }

            public void setUsername(UsernameBeanX username) {
                this.username = username;
            }

            public PasswordBeanX getPassword() {
                return password;
            }

            public void setPassword(PasswordBeanX password) {
                this.password = password;
            }

            public UtypeBean getUtype() {
                return utype;
            }

            public void setUtype(UtypeBean utype) {
                this.utype = utype;
            }

            public UStatusBean getUStatus() {
                return uStatus;
            }

            public void setUStatus(UStatusBean uStatus) {
                this.uStatus = uStatus;
            }

            public OrgIDBeanX getOrgID() {
                return orgID;
            }

            public void setOrgID(OrgIDBeanX orgID) {
                this.orgID = orgID;
            }

            public static class URealnameBean {
                /**
                 * CN : 真实姓名
                 * EN : Name
                 */

                private String CN;
                private String EN;

                public static URealnameBean objectFromData(String str) {

                    return new Gson().fromJson(str, URealnameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class UsernameBeanX {
                /**
                 * CN : 登录账号
                 * EN : Account
                 */

                private String CN;
                private String EN;

                public static UsernameBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, UsernameBeanX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class PasswordBeanX {
                /**
                 * CN : 登录密码
                 * EN : Password
                 */

                private String CN;
                private String EN;

                public static PasswordBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, PasswordBeanX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class UtypeBean {
                /**
                 * CN : 用户类型
                 * EN : User Type
                 */

                private String CN;
                private String EN;

                public static UtypeBean objectFromData(String str) {

                    return new Gson().fromJson(str, UtypeBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class UStatusBean {
                /**
                 * CN : 用户状态
                 * EN : Status
                 */

                private String CN;
                private String EN;

                public static UStatusBean objectFromData(String str) {

                    return new Gson().fromJson(str, UStatusBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OrgIDBeanX {
                /**
                 * CN : 机构编号
                 * EN : Organization Code
                 */

                private String CN;
                private String EN;

                public static OrgIDBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, OrgIDBeanX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class GamesBean {
            /**
             * cock_chip : {"CN":"斗鸡芯片号","EN":"Chip Code"}
             * breedName : {"CN":"品种","EN":"Bloodline"}
             * owner : {"CN":"鸡主","EN":"Owner"}
             * org_id : {"CN":"机构编号","EN":"Organization Code"}
             * status : {"CN":"斗鸡状态","EN":"Status"}
             * createUser : {"CN":"记录人","EN":"Recorder"}
             * createAt : {"CN":"记录生成日期","EN":"Created On"}
             * win_cock : {"CN":"获胜斗鸡芯片号","EN":"Chip Code"}
             * result_time : {"CN":"比赛结果生成时间","EN":"Game Date"}
             */

            private CockChipBean cock_chip;
            private BreedNameBeanX breedName;
            private OwnerBean owner;
            private OrgIdBean org_id;
            private StatusBean status;
            private CreateUserBean createUser;
            private CreateAtBeanX createAt;
            private WinCockBean win_cock;
            private ResultTimeBean result_time;

            public static GamesBean objectFromData(String str) {

                return new Gson().fromJson(str, GamesBean.class);
            }

            public CockChipBean getCock_chip() {
                return cock_chip;
            }

            public void setCock_chip(CockChipBean cock_chip) {
                this.cock_chip = cock_chip;
            }

            public BreedNameBeanX getBreedName() {
                return breedName;
            }

            public void setBreedName(BreedNameBeanX breedName) {
                this.breedName = breedName;
            }

            public OwnerBean getOwner() {
                return owner;
            }

            public void setOwner(OwnerBean owner) {
                this.owner = owner;
            }

            public OrgIdBean getOrg_id() {
                return org_id;
            }

            public void setOrg_id(OrgIdBean org_id) {
                this.org_id = org_id;
            }

            public StatusBean getStatus() {
                return status;
            }

            public void setStatus(StatusBean status) {
                this.status = status;
            }

            public CreateUserBean getCreateUser() {
                return createUser;
            }

            public void setCreateUser(CreateUserBean createUser) {
                this.createUser = createUser;
            }

            public CreateAtBeanX getCreateAt() {
                return createAt;
            }

            public void setCreateAt(CreateAtBeanX createAt) {
                this.createAt = createAt;
            }

            public WinCockBean getWin_cock() {
                return win_cock;
            }

            public void setWin_cock(WinCockBean win_cock) {
                this.win_cock = win_cock;
            }

            public ResultTimeBean getResult_time() {
                return result_time;
            }

            public void setResult_time(ResultTimeBean result_time) {
                this.result_time = result_time;
            }

            public static class CockChipBean {
                /**
                 * CN : 斗鸡芯片号
                 * EN : Chip Code
                 */

                private String CN;
                private String EN;

                public static CockChipBean objectFromData(String str) {

                    return new Gson().fromJson(str, CockChipBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class BreedNameBeanX {
                /**
                 * CN : 品种
                 * EN : Bloodline
                 */

                private String CN;
                private String EN;

                public static BreedNameBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, BreedNameBeanX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OwnerBean {
                /**
                 * CN : 鸡主
                 * EN : Owner
                 */

                private String CN;
                private String EN;

                public static OwnerBean objectFromData(String str) {

                    return new Gson().fromJson(str, OwnerBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OrgIdBean {
                /**
                 * CN : 机构编号
                 * EN : Organization Code
                 */

                private String CN;
                private String EN;

                public static OrgIdBean objectFromData(String str) {

                    return new Gson().fromJson(str, OrgIdBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class StatusBean {
                /**
                 * CN : 斗鸡状态
                 * EN : Status
                 */

                private String CN;
                private String EN;

                public static StatusBean objectFromData(String str) {

                    return new Gson().fromJson(str, StatusBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CreateUserBean {
                /**
                 * CN : 记录人
                 * EN : Recorder
                 */

                private String CN;
                private String EN;

                public static CreateUserBean objectFromData(String str) {

                    return new Gson().fromJson(str, CreateUserBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CreateAtBeanX {
                /**
                 * CN : 记录生成日期
                 * EN : Created On
                 */

                private String CN;
                private String EN;

                public static CreateAtBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, CreateAtBeanX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class WinCockBean {
                /**
                 * CN : 获胜斗鸡芯片号
                 * EN : Chip Code
                 */

                private String CN;
                private String EN;

                public static WinCockBean objectFromData(String str) {

                    return new Gson().fromJson(str, WinCockBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ResultTimeBean {
                /**
                 * CN : 比赛结果生成时间
                 * EN : Game Date
                 */

                private String CN;
                private String EN;

                public static ResultTimeBean objectFromData(String str) {

                    return new Gson().fromJson(str, ResultTimeBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class DictionBean {
            /**
             * dictName : {"CN":"行政区域名称","EN":"Province"}
             * areaName : {"CN":"岛屿名称","EN":"Area"}
             * prompt : {"CN":"请选择行政区域","EN":"Please choose Province"}
             */

            private DictNameBean dictName;
            private AreaNameBean areaName;
            private PromptBean prompt;

            public static DictionBean objectFromData(String str) {

                return new Gson().fromJson(str, DictionBean.class);
            }

            public DictNameBean getDictName() {
                return dictName;
            }

            public void setDictName(DictNameBean dictName) {
                this.dictName = dictName;
            }

            public AreaNameBean getAreaName() {
                return areaName;
            }

            public void setAreaName(AreaNameBean areaName) {
                this.areaName = areaName;
            }

            public PromptBean getPrompt() {
                return prompt;
            }

            public void setPrompt(PromptBean prompt) {
                this.prompt = prompt;
            }

            public static class DictNameBean {
                /**
                 * CN : 行政区域名称
                 * EN : Province
                 */

                private String CN;
                private String EN;

                public static DictNameBean objectFromData(String str) {

                    return new Gson().fromJson(str, DictNameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class AreaNameBean {
                /**
                 * CN : 岛屿名称
                 * EN : Area
                 */

                private String CN;
                private String EN;

                public static AreaNameBean objectFromData(String str) {

                    return new Gson().fromJson(str, AreaNameBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class PromptBean {
                /**
                 * CN : 请选择行政区域
                 * EN : Please choose Province
                 */

                private String CN;
                private String EN;

                public static PromptBean objectFromData(String str) {

                    return new Gson().fromJson(str, PromptBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class AreaBean {
            /**
             * areaName : {"CN":"岛屿名称","EN":"Area"}
             * prompt : {"CN":"请选择岛屿","EN":"Please choose Area"}
             */

            private AreaNameBeanX areaName;
            private PromptBeanX prompt;

            public static AreaBean objectFromData(String str) {

                return new Gson().fromJson(str, AreaBean.class);
            }

            public AreaNameBeanX getAreaName() {
                return areaName;
            }

            public void setAreaName(AreaNameBeanX areaName) {
                this.areaName = areaName;
            }

            public PromptBeanX getPrompt() {
                return prompt;
            }

            public void setPrompt(PromptBeanX prompt) {
                this.prompt = prompt;
            }

            public static class AreaNameBeanX {
                /**
                 * CN : 岛屿名称
                 * EN : Area
                 */

                private String CN;
                private String EN;

                public static AreaNameBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, AreaNameBeanX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class PromptBeanX {
                /**
                 * CN : 请选择岛屿
                 * EN : Please choose Area
                 */

                private String CN;
                private String EN;

                public static PromptBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, PromptBeanX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class ChipBean {
            /**
             * chipCode : {"CN":"芯片编号","EN":"Chip Code"}
             * create_userid : {"CN":"录入用户","EN":"Creator"}
             * createdate : {"CN":"录入时间","EN":"Created On"}
             * isused : {"CN":"是否使用","EN":"Is Used"}
             * usedate : {"CN":"使用日期","EN":"Used Date"}
             * sub_orgid : {"CN":"所属机构","EN":"Organization"}
             * chip_start : {"CN":"芯片起始号","EN":"Starting ChipCode"}
             * chip_end : {"CN":"芯片结束号","EN":"End ChipCode"}
             */

            private ChipCodeBeanX chipCode;
            private CreateUseridBean create_userid;
            private CreatedateBean createdate;
            private IsusedBean isused;
            private UsedateBean usedate;
            private SubOrgidBean sub_orgid;
            private ChipStartBean chip_start;
            private ChipEndBean chip_end;

            public static ChipBean objectFromData(String str) {

                return new Gson().fromJson(str, ChipBean.class);
            }

            public ChipCodeBeanX getChipCode() {
                return chipCode;
            }

            public void setChipCode(ChipCodeBeanX chipCode) {
                this.chipCode = chipCode;
            }

            public CreateUseridBean getCreate_userid() {
                return create_userid;
            }

            public void setCreate_userid(CreateUseridBean create_userid) {
                this.create_userid = create_userid;
            }

            public CreatedateBean getCreatedate() {
                return createdate;
            }

            public void setCreatedate(CreatedateBean createdate) {
                this.createdate = createdate;
            }

            public IsusedBean getIsused() {
                return isused;
            }

            public void setIsused(IsusedBean isused) {
                this.isused = isused;
            }

            public UsedateBean getUsedate() {
                return usedate;
            }

            public void setUsedate(UsedateBean usedate) {
                this.usedate = usedate;
            }

            public SubOrgidBean getSub_orgid() {
                return sub_orgid;
            }

            public void setSub_orgid(SubOrgidBean sub_orgid) {
                this.sub_orgid = sub_orgid;
            }

            public ChipStartBean getChip_start() {
                return chip_start;
            }

            public void setChip_start(ChipStartBean chip_start) {
                this.chip_start = chip_start;
            }

            public ChipEndBean getChip_end() {
                return chip_end;
            }

            public void setChip_end(ChipEndBean chip_end) {
                this.chip_end = chip_end;
            }

            public static class ChipCodeBeanX {
                /**
                 * CN : 芯片编号
                 * EN : Chip Code
                 */

                private String CN;
                private String EN;

                public static ChipCodeBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, ChipCodeBeanX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CreateUseridBean {
                /**
                 * CN : 录入用户
                 * EN : Creator
                 */

                private String CN;
                private String EN;

                public static CreateUseridBean objectFromData(String str) {

                    return new Gson().fromJson(str, CreateUseridBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CreatedateBean {
                /**
                 * CN : 录入时间
                 * EN : Created On
                 */

                private String CN;
                private String EN;

                public static CreatedateBean objectFromData(String str) {

                    return new Gson().fromJson(str, CreatedateBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class IsusedBean {
                /**
                 * CN : 是否使用
                 * EN : Is Used
                 */

                private String CN;
                private String EN;

                public static IsusedBean objectFromData(String str) {

                    return new Gson().fromJson(str, IsusedBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class UsedateBean {
                /**
                 * CN : 使用日期
                 * EN : Used Date
                 */

                private String CN;
                private String EN;

                public static UsedateBean objectFromData(String str) {

                    return new Gson().fromJson(str, UsedateBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class SubOrgidBean {
                /**
                 * CN : 所属机构
                 * EN : Organization
                 */

                private String CN;
                private String EN;

                public static SubOrgidBean objectFromData(String str) {

                    return new Gson().fromJson(str, SubOrgidBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ChipStartBean {
                /**
                 * CN : 芯片起始号
                 * EN : Starting ChipCode
                 */

                private String CN;
                private String EN;

                public static ChipStartBean objectFromData(String str) {

                    return new Gson().fromJson(str, ChipStartBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ChipEndBean {
                /**
                 * CN : 芯片结束号
                 * EN : End ChipCode
                 */

                private String CN;
                private String EN;

                public static ChipEndBean objectFromData(String str) {

                    return new Gson().fromJson(str, ChipEndBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class StatusDataBean {
            /**
             * cocks : {"cStatus":[{"CN":"正常","EN":"Normal","#text":"1"},{"CN":"淘汰","EN":"Abort","#text":"2"},{"CN":"走失","EN":"Lost","#text":"3"}]}
             * userStatus : {"uStatus":[{"CN":"正常","EN":"Normal","#text":"1"},{"CN":"注销","EN":"Unregister","#text":"2"}]}
             * userType : {"utype":[{"CN":"机构用户","EN":"System User","#text":"1"},{"CN":"鸡主用户","EN":"Owner","#text":"2"}]}
             */

            private CocksBeanX cocks;
            private UserStatusBean userStatus;
            private UserTypeBean userType;

            public static StatusDataBean objectFromData(String str) {

                return new Gson().fromJson(str, StatusDataBean.class);
            }

            public CocksBeanX getCocks() {
                return cocks;
            }

            public void setCocks(CocksBeanX cocks) {
                this.cocks = cocks;
            }

            public UserStatusBean getUserStatus() {
                return userStatus;
            }

            public void setUserStatus(UserStatusBean userStatus) {
                this.userStatus = userStatus;
            }

            public UserTypeBean getUserType() {
                return userType;
            }

            public void setUserType(UserTypeBean userType) {
                this.userType = userType;
            }

            public static class CocksBeanX {
                private List<CStatusBeanX> cStatus;

                public static CocksBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, CocksBeanX.class);
                }

                public List<CStatusBeanX> getCStatus() {
                    return cStatus;
                }

                public void setCStatus(List<CStatusBeanX> cStatus) {
                    this.cStatus = cStatus;
                }

                public static class CStatusBeanX {
                    /**
                     * CN : 正常
                     * EN : Normal
                     * #text : 1
                     */

                    private String CN;
                    private String EN;
                    @SerializedName("#text")
                    private String _$Text271; // FIXME check this code

                    public static CStatusBeanX objectFromData(String str) {

                        return new Gson().fromJson(str, CStatusBeanX.class);
                    }

                    public String getCN() {
                        return CN;
                    }

                    public void setCN(String CN) {
                        this.CN = CN;
                    }

                    public String getEN() {
                        return EN;
                    }

                    public void setEN(String EN) {
                        this.EN = EN;
                    }

                    public String get_$Text271() {
                        return _$Text271;
                    }

                    public void set_$Text271(String _$Text271) {
                        this._$Text271 = _$Text271;
                    }
                }
            }

            public static class UserStatusBean {
                private List<UStatusBeanX> uStatus;

                public static UserStatusBean objectFromData(String str) {

                    return new Gson().fromJson(str, UserStatusBean.class);
                }

                public List<UStatusBeanX> getUStatus() {
                    return uStatus;
                }

                public void setUStatus(List<UStatusBeanX> uStatus) {
                    this.uStatus = uStatus;
                }

                public static class UStatusBeanX {
                    /**
                     * CN : 正常
                     * EN : Normal
                     * #text : 1
                     */

                    private String CN;
                    private String EN;
                    @SerializedName("#text")
                    private String _$Text109; // FIXME check this code

                    public static UStatusBeanX objectFromData(String str) {

                        return new Gson().fromJson(str, UStatusBeanX.class);
                    }

                    public String getCN() {
                        return CN;
                    }

                    public void setCN(String CN) {
                        this.CN = CN;
                    }

                    public String getEN() {
                        return EN;
                    }

                    public void setEN(String EN) {
                        this.EN = EN;
                    }

                    public String get_$Text109() {
                        return _$Text109;
                    }

                    public void set_$Text109(String _$Text109) {
                        this._$Text109 = _$Text109;
                    }
                }
            }

            public static class UserTypeBean {
                private List<UtypeBeanX> utype;

                public static UserTypeBean objectFromData(String str) {

                    return new Gson().fromJson(str, UserTypeBean.class);
                }

                public List<UtypeBeanX> getUtype() {
                    return utype;
                }

                public void setUtype(List<UtypeBeanX> utype) {
                    this.utype = utype;
                }

                public static class UtypeBeanX {
                    /**
                     * CN : 机构用户
                     * EN : System User
                     * #text : 1
                     */

                    private String CN;
                    private String EN;
                    @SerializedName("#text")
                    private String _$Text249; // FIXME check this code

                    public static UtypeBeanX objectFromData(String str) {

                        return new Gson().fromJson(str, UtypeBeanX.class);
                    }

                    public String getCN() {
                        return CN;
                    }

                    public void setCN(String CN) {
                        this.CN = CN;
                    }

                    public String getEN() {
                        return EN;
                    }

                    public void setEN(String EN) {
                        this.EN = EN;
                    }

                    public String get_$Text249() {
                        return _$Text249;
                    }

                    public void set_$Text249(String _$Text249) {
                        this._$Text249 = _$Text249;
                    }
                }
            }
        }

        public static class TitleDataBean {
            private List<TitleBean> title;

            public static TitleDataBean objectFromData(String str) {

                return new Gson().fromJson(str, TitleDataBean.class);
            }

            public List<TitleBean> getTitle() {
                return title;
            }

            public void setTitle(List<TitleBean> title) {
                this.title = title;
            }

            public static class TitleBean {
                /**
                 * CN : 先生
                 * EN : Mr
                 * #text : 1
                 */

                private String CN;
                private String EN;
                @SerializedName("#text")
                private String _$Text76; // FIXME check this code

                public static TitleBean objectFromData(String str) {

                    return new Gson().fromJson(str, TitleBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }

                public String get_$Text76() {
                    return _$Text76;
                }

                public void set_$Text76(String _$Text76) {
                    this._$Text76 = _$Text76;
                }
            }
        }

        public static class DBPROCBean {
            /**
             * cocks : {"add":{"msg":[{"CN":"斗鸡信息添加成功！","EN":"Information added","#text":"1"},{"CN":"此芯片未授权，请更换！","EN":"The chip code is unauthorized, please try another","#text":"-1"},{"CN":"此芯片已被使用，请更换！","EN":"The chip code has been used, please try another","#text":"-2"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]},"get":{"msg":[{"CN":"检索成功！","EN":"Data retrieved","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"未检索到符合条件的记录！","EN":"No match found!","#text":"-2"}]},"update_regdate":{"msg":[{"CN":"登记评定成功！","EN":"Registration successed","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]},"update_status":{"msg":[{"CN":"斗鸡状态更新成功！","EN":"Status has been updated","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]}}
             * owners : {"login":{"msg":[{"CN":"登录成功，欢迎使用！","EN":"Login successfully","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"登录失败，用户名或密码错误！","EN":"user name or password do not match","#text":"-2"}]}}
             */

            private CocksBeanXX cocks;
            private OwnersBeanX owners;

            public static DBPROCBean objectFromData(String str) {

                return new Gson().fromJson(str, DBPROCBean.class);
            }

            public CocksBeanXX getCocks() {
                return cocks;
            }

            public void setCocks(CocksBeanXX cocks) {
                this.cocks = cocks;
            }

            public OwnersBeanX getOwners() {
                return owners;
            }

            public void setOwners(OwnersBeanX owners) {
                this.owners = owners;
            }

            public static class CocksBeanXX {
                /**
                 * add : {"msg":[{"CN":"斗鸡信息添加成功！","EN":"Information added","#text":"1"},{"CN":"此芯片未授权，请更换！","EN":"The chip code is unauthorized, please try another","#text":"-1"},{"CN":"此芯片已被使用，请更换！","EN":"The chip code has been used, please try another","#text":"-2"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]}
                 * get : {"msg":[{"CN":"检索成功！","EN":"Data retrieved","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"未检索到符合条件的记录！","EN":"No match found!","#text":"-2"}]}
                 * update_regdate : {"msg":[{"CN":"登记评定成功！","EN":"Registration successed","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]}
                 * update_status : {"msg":[{"CN":"斗鸡状态更新成功！","EN":"Status has been updated","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"System error, try it later","#text":"-99"}]}
                 */

                private AddBean add;
                private GetBean get;
                private UpdateRegdateBean update_regdate;
                private UpdateStatusBean update_status;

                public static CocksBeanXX objectFromData(String str) {

                    return new Gson().fromJson(str, CocksBeanXX.class);
                }

                public AddBean getAdd() {
                    return add;
                }

                public void setAdd(AddBean add) {
                    this.add = add;
                }

                public GetBean getGet() {
                    return get;
                }

                public void setGet(GetBean get) {
                    this.get = get;
                }

                public UpdateRegdateBean getUpdate_regdate() {
                    return update_regdate;
                }

                public void setUpdate_regdate(UpdateRegdateBean update_regdate) {
                    this.update_regdate = update_regdate;
                }

                public UpdateStatusBean getUpdate_status() {
                    return update_status;
                }

                public void setUpdate_status(UpdateStatusBean update_status) {
                    this.update_status = update_status;
                }

                public static class AddBean {
                    private List<MsgBean> msg;

                    public static AddBean objectFromData(String str) {

                        return new Gson().fromJson(str, AddBean.class);
                    }

                    public List<MsgBean> getMsg() {
                        return msg;
                    }

                    public void setMsg(List<MsgBean> msg) {
                        this.msg = msg;
                    }

                    public static class MsgBean {
                        /**
                         * CN : 斗鸡信息添加成功！
                         * EN : Information added
                         * #text : 1
                         */

                        private String CN;
                        private String EN;
                        @SerializedName("#text")
                        private String _$Text223; // FIXME check this code

                        public static MsgBean objectFromData(String str) {

                            return new Gson().fromJson(str, MsgBean.class);
                        }

                        public String getCN() {
                            return CN;
                        }

                        public void setCN(String CN) {
                            this.CN = CN;
                        }

                        public String getEN() {
                            return EN;
                        }

                        public void setEN(String EN) {
                            this.EN = EN;
                        }

                        public String get_$Text223() {
                            return _$Text223;
                        }

                        public void set_$Text223(String _$Text223) {
                            this._$Text223 = _$Text223;
                        }
                    }
                }

                public static class GetBean {
                    private List<MsgBeanX> msg;

                    public static GetBean objectFromData(String str) {

                        return new Gson().fromJson(str, GetBean.class);
                    }

                    public List<MsgBeanX> getMsg() {
                        return msg;
                    }

                    public void setMsg(List<MsgBeanX> msg) {
                        this.msg = msg;
                    }

                    public static class MsgBeanX {
                        /**
                         * CN : 检索成功！
                         * EN : Data retrieved
                         * #text : 1
                         */

                        private String CN;
                        private String EN;
                        @SerializedName("#text")
                        private String _$Text186; // FIXME check this code

                        public static MsgBeanX objectFromData(String str) {

                            return new Gson().fromJson(str, MsgBeanX.class);
                        }

                        public String getCN() {
                            return CN;
                        }

                        public void setCN(String CN) {
                            this.CN = CN;
                        }

                        public String getEN() {
                            return EN;
                        }

                        public void setEN(String EN) {
                            this.EN = EN;
                        }

                        public String get_$Text186() {
                            return _$Text186;
                        }

                        public void set_$Text186(String _$Text186) {
                            this._$Text186 = _$Text186;
                        }
                    }
                }

                public static class UpdateRegdateBean {
                    private List<MsgBeanXX> msg;

                    public static UpdateRegdateBean objectFromData(String str) {

                        return new Gson().fromJson(str, UpdateRegdateBean.class);
                    }

                    public List<MsgBeanXX> getMsg() {
                        return msg;
                    }

                    public void setMsg(List<MsgBeanXX> msg) {
                        this.msg = msg;
                    }

                    public static class MsgBeanXX {
                        /**
                         * CN : 登记评定成功！
                         * EN : Registration successed
                         * #text : 1
                         */

                        private String CN;
                        private String EN;
                        @SerializedName("#text")
                        private String _$Text130; // FIXME check this code

                        public static MsgBeanXX objectFromData(String str) {

                            return new Gson().fromJson(str, MsgBeanXX.class);
                        }

                        public String getCN() {
                            return CN;
                        }

                        public void setCN(String CN) {
                            this.CN = CN;
                        }

                        public String getEN() {
                            return EN;
                        }

                        public void setEN(String EN) {
                            this.EN = EN;
                        }

                        public String get_$Text130() {
                            return _$Text130;
                        }

                        public void set_$Text130(String _$Text130) {
                            this._$Text130 = _$Text130;
                        }
                    }
                }

                public static class UpdateStatusBean {
                    private List<MsgBeanXXX> msg;

                    public static UpdateStatusBean objectFromData(String str) {

                        return new Gson().fromJson(str, UpdateStatusBean.class);
                    }

                    public List<MsgBeanXXX> getMsg() {
                        return msg;
                    }

                    public void setMsg(List<MsgBeanXXX> msg) {
                        this.msg = msg;
                    }

                    public static class MsgBeanXXX {
                        /**
                         * CN : 斗鸡状态更新成功！
                         * EN : Status has been updated
                         * #text : 1
                         */

                        private String CN;
                        private String EN;
                        @SerializedName("#text")
                        private String _$Text118; // FIXME check this code

                        public static MsgBeanXXX objectFromData(String str) {

                            return new Gson().fromJson(str, MsgBeanXXX.class);
                        }

                        public String getCN() {
                            return CN;
                        }

                        public void setCN(String CN) {
                            this.CN = CN;
                        }

                        public String getEN() {
                            return EN;
                        }

                        public void setEN(String EN) {
                            this.EN = EN;
                        }

                        public String get_$Text118() {
                            return _$Text118;
                        }

                        public void set_$Text118(String _$Text118) {
                            this._$Text118 = _$Text118;
                        }
                    }
                }
            }

            public static class OwnersBeanX {
                /**
                 * login : {"msg":[{"CN":"登录成功，欢迎使用！","EN":"Login successfully","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"Arguments is invalid, please try again!","#text":"-1"},{"CN":"登录失败，用户名或密码错误！","EN":"user name or password do not match","#text":"-2"}]}
                 */

                private LoginBean login;

                public static OwnersBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, OwnersBeanX.class);
                }

                public LoginBean getLogin() {
                    return login;
                }

                public void setLogin(LoginBean login) {
                    this.login = login;
                }

                public static class LoginBean {
                    private List<MsgBeanXXXX> msg;

                    public static LoginBean objectFromData(String str) {

                        return new Gson().fromJson(str, LoginBean.class);
                    }

                    public List<MsgBeanXXXX> getMsg() {
                        return msg;
                    }

                    public void setMsg(List<MsgBeanXXXX> msg) {
                        this.msg = msg;
                    }

                    public static class MsgBeanXXXX {
                        /**
                         * CN : 登录成功，欢迎使用！
                         * EN : Login successfully
                         * #text : 1
                         */

                        private String CN;
                        private String EN;
                        @SerializedName("#text")
                        private String _$Text288; // FIXME check this code

                        public static MsgBeanXXXX objectFromData(String str) {

                            return new Gson().fromJson(str, MsgBeanXXXX.class);
                        }

                        public String getCN() {
                            return CN;
                        }

                        public void setCN(String CN) {
                            this.CN = CN;
                        }

                        public String getEN() {
                            return EN;
                        }

                        public void setEN(String EN) {
                            this.EN = EN;
                        }

                        public String get_$Text288() {
                            return _$Text288;
                        }

                        public void set_$Text288(String _$Text288) {
                            this._$Text288 = _$Text288;
                        }
                    }
                }
            }
        }

        public static class UploadImageBean {
            private List<MsgBeanXXXXX> msg;

            public static UploadImageBean objectFromData(String str) {

                return new Gson().fromJson(str, UploadImageBean.class);
            }

            public List<MsgBeanXXXXX> getMsg() {
                return msg;
            }

            public void setMsg(List<MsgBeanXXXXX> msg) {
                this.msg = msg;
            }

            public static class MsgBeanXXXXX {
                /**
                 * CN : 图片上传成功
                 * EN : Image has been uploaded
                 * #text : 1
                 */

                private String CN;
                private String EN;
                @SerializedName("#text")
                private String _$Text290; // FIXME check this code

                public static MsgBeanXXXXX objectFromData(String str) {

                    return new Gson().fromJson(str, MsgBeanXXXXX.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }

                public String get_$Text290() {
                    return _$Text290;
                }

                public void set_$Text290(String _$Text290) {
                    this._$Text290 = _$Text290;
                }
            }
        }

        public static class BasicBean {
            /**
             * operation : {"CN":"操作","EN":"Operation"}
             * edit : {"CN":"编辑","EN":"Edit"}
             * del : {"CN":"编辑","EN":"Remove"}
             * keyword : {"CN":"请输入你要查询的关键字","EN":""}
             * cardno : {"CN":"请输入查询人的证件号码","EN":""}
             * tel : {"CN":"请输入查询人的电话号码","EN":""}
             * image : {"CN":"还没有斗鸡照片，请上传","EN":""}
             * search : {"CN":"搜索","EN":"Search"}
             * New : {"CN":"增加","EN":"New"}
             * upload : {"CN":"上传","EN":"Upload"}
             * clear : {"CN":"清除关键字搜索","EN":""}
             * confirm : {"CN":"确定","EN":"Confirm"}
             * cancel : {"CN":"取消","EN":"Cancel"}
             */

            private OperationBean operation;
            private EditBean edit;
            private DelBean del;
            private KeywordBean keyword;
            private CardnoBean cardno;
            private TelBean tel;
            private ImageBean image;
            private SearchBean search;
            private NewBean New;
            private UploadBean upload;
            private ClearBean clear;
            private ConfirmBean confirm;
            private CancelBean cancel;

            public static BasicBean objectFromData(String str) {

                return new Gson().fromJson(str, BasicBean.class);
            }

            public OperationBean getOperation() {
                return operation;
            }

            public void setOperation(OperationBean operation) {
                this.operation = operation;
            }

            public EditBean getEdit() {
                return edit;
            }

            public void setEdit(EditBean edit) {
                this.edit = edit;
            }

            public DelBean getDel() {
                return del;
            }

            public void setDel(DelBean del) {
                this.del = del;
            }

            public KeywordBean getKeyword() {
                return keyword;
            }

            public void setKeyword(KeywordBean keyword) {
                this.keyword = keyword;
            }

            public CardnoBean getCardno() {
                return cardno;
            }

            public void setCardno(CardnoBean cardno) {
                this.cardno = cardno;
            }

            public TelBean getTel() {
                return tel;
            }

            public void setTel(TelBean tel) {
                this.tel = tel;
            }

            public ImageBean getImage() {
                return image;
            }

            public void setImage(ImageBean image) {
                this.image = image;
            }

            public SearchBean getSearch() {
                return search;
            }

            public void setSearch(SearchBean search) {
                this.search = search;
            }

            public NewBean getNew() {
                return New;
            }

            public void setNew(NewBean New) {
                this.New = New;
            }

            public UploadBean getUpload() {
                return upload;
            }

            public void setUpload(UploadBean upload) {
                this.upload = upload;
            }

            public ClearBean getClear() {
                return clear;
            }

            public void setClear(ClearBean clear) {
                this.clear = clear;
            }

            public ConfirmBean getConfirm() {
                return confirm;
            }

            public void setConfirm(ConfirmBean confirm) {
                this.confirm = confirm;
            }

            public CancelBean getCancel() {
                return cancel;
            }

            public void setCancel(CancelBean cancel) {
                this.cancel = cancel;
            }

            public static class OperationBean {
                /**
                 * CN : 操作
                 * EN : Operation
                 */

                private String CN;
                private String EN;

                public static OperationBean objectFromData(String str) {

                    return new Gson().fromJson(str, OperationBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EditBean {
                /**
                 * CN : 编辑
                 * EN : Edit
                 */

                private String CN;
                private String EN;

                public static EditBean objectFromData(String str) {

                    return new Gson().fromJson(str, EditBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class DelBean {
                /**
                 * CN : 编辑
                 * EN : Remove
                 */

                private String CN;
                private String EN;

                public static DelBean objectFromData(String str) {

                    return new Gson().fromJson(str, DelBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class KeywordBean {
                /**
                 * CN : 请输入你要查询的关键字
                 * EN :
                 */

                private String CN;
                private String EN;

                public static KeywordBean objectFromData(String str) {

                    return new Gson().fromJson(str, KeywordBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CardnoBean {
                /**
                 * CN : 请输入查询人的证件号码
                 * EN :
                 */

                private String CN;
                private String EN;

                public static CardnoBean objectFromData(String str) {

                    return new Gson().fromJson(str, CardnoBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class TelBean {
                /**
                 * CN : 请输入查询人的电话号码
                 * EN :
                 */

                private String CN;
                private String EN;

                public static TelBean objectFromData(String str) {

                    return new Gson().fromJson(str, TelBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ImageBean {
                /**
                 * CN : 还没有斗鸡照片，请上传
                 * EN :
                 */

                private String CN;
                private String EN;

                public static ImageBean objectFromData(String str) {

                    return new Gson().fromJson(str, ImageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class SearchBean {
                /**
                 * CN : 搜索
                 * EN : Search
                 */

                private String CN;
                private String EN;

                public static SearchBean objectFromData(String str) {

                    return new Gson().fromJson(str, SearchBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class NewBean {
                /**
                 * CN : 增加
                 * EN : New
                 */

                private String CN;
                private String EN;

                public static NewBean objectFromData(String str) {

                    return new Gson().fromJson(str, NewBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class UploadBean {
                /**
                 * CN : 上传
                 * EN : Upload
                 */

                private String CN;
                private String EN;

                public static UploadBean objectFromData(String str) {

                    return new Gson().fromJson(str, UploadBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ClearBean {
                /**
                 * CN : 清除关键字搜索
                 * EN :
                 */

                private String CN;
                private String EN;

                public static ClearBean objectFromData(String str) {

                    return new Gson().fromJson(str, ClearBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ConfirmBean {
                /**
                 * CN : 确定
                 * EN : Confirm
                 */

                private String CN;
                private String EN;

                public static ConfirmBean objectFromData(String str) {

                    return new Gson().fromJson(str, ConfirmBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CancelBean {
                /**
                 * CN : 取消
                 * EN : Cancel
                 */

                private String CN;
                private String EN;

                public static CancelBean objectFromData(String str) {

                    return new Gson().fromJson(str, CancelBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class KeywordBeanX {
            /**
             * keyword_1 : {"CN":"请输入芯片编号","EN":""}
             * keyword_2 : {"CN":"请输入斗鸡编号","EN":""}
             * keyword_3 : {"CN":"请选择斗鸡品种","EN":""}
             * keyword_4 : {"CN":"请选择出生日期","EN":"Hatch Date"}
             * keyword_5 : {"CN":"请输入芯片号，斗鸡编号鸡主名称或养殖场名称关键字进行搜索","EN":""}
             * keyword_6 : {"CN":"请输入机构名称名称关键字进行搜索","EN":""}
             * keyword_7 : {"CN":"请输入鸡主证件号码关键字进行搜索","EN":""}
             * keyword_8 : {"CN":"请输入养殖场关键字进行搜索","EN":""}
             * keyword_9 : {"CN":"请输入引进人电话关键字进行搜索","EN":""}
             * keyword_10 : {"CN":"请上传斗鸡照片","EN":""}
             * keyword_11 : {"CN":"请输入养殖场，联系人，养殖场电话关键字进行搜索","EN":""}
             * keyword_12 : {"CN":"请输入鸡主名称，证件号码，联系电话关键字进行搜索","EN":""}
             * keyword_13 : {"CN":"请输入养殖场名称","EN":""}
             * keyword_14 : {"CN":"请输入养殖场地址","EN":""}
             * keyword_15 : {"CN":"请输入养殖场联系人","EN":""}
             * keyword_16 : {"CN":"请输入联系人电话","EN":""}
             * keyword_17 : {"CN":"请选择联系人称谓","EN":""}
             * keyword_18 : {"CN":"请输入引进人名称","EN":""}
             * keyword_19 : {"CN":"请输入引进人地址","EN":""}
             * keyword_20 : {"CN":"请输入引进人电话","EN":""}
             * keyword_21 : {"CN":"请输入鸡主名称","EN":""}
             * keyword_22 : {"CN":"请输入鸡主称谓","EN":""}
             * keyword_23 : {"CN":"请输入鸡主地址","EN":""}
             * keyword_24 : {"CN":"请输入鸡主电话","EN":""}
             * keyword_25 : {"CN":"请输入鸡主证件号码","EN":""}
             * keyword_26 : {"CN":"请输入登录账号","EN":""}
             * keyword_27 : {"CN":"请输入登录密码","EN":""}
             * keyword_28 : {"CN":"请输选择地区范围","EN":""}
             * keyword_29 : {"CN":"请输选择行政区域","EN":""}
             */

            private Keyword1Bean keyword_1;
            private Keyword2Bean keyword_2;
            private Keyword3Bean keyword_3;
            private Keyword4Bean keyword_4;
            private Keyword5Bean keyword_5;
            private Keyword6Bean keyword_6;
            private Keyword7Bean keyword_7;
            private Keyword8Bean keyword_8;
            private Keyword9Bean keyword_9;
            private Keyword10Bean keyword_10;
            private Keyword11Bean keyword_11;
            private Keyword12Bean keyword_12;
            private Keyword13Bean keyword_13;
            private Keyword14Bean keyword_14;
            private Keyword15Bean keyword_15;
            private Keyword16Bean keyword_16;
            private Keyword17Bean keyword_17;
            private Keyword18Bean keyword_18;
            private Keyword19Bean keyword_19;
            private Keyword20Bean keyword_20;
            private Keyword21Bean keyword_21;
            private Keyword22Bean keyword_22;
            private Keyword23Bean keyword_23;
            private Keyword24Bean keyword_24;
            private Keyword25Bean keyword_25;
            private Keyword26Bean keyword_26;
            private Keyword27Bean keyword_27;
            private Keyword28Bean keyword_28;
            private Keyword29Bean keyword_29;

            public static KeywordBeanX objectFromData(String str) {

                return new Gson().fromJson(str, KeywordBeanX.class);
            }

            public Keyword1Bean getKeyword_1() {
                return keyword_1;
            }

            public void setKeyword_1(Keyword1Bean keyword_1) {
                this.keyword_1 = keyword_1;
            }

            public Keyword2Bean getKeyword_2() {
                return keyword_2;
            }

            public void setKeyword_2(Keyword2Bean keyword_2) {
                this.keyword_2 = keyword_2;
            }

            public Keyword3Bean getKeyword_3() {
                return keyword_3;
            }

            public void setKeyword_3(Keyword3Bean keyword_3) {
                this.keyword_3 = keyword_3;
            }

            public Keyword4Bean getKeyword_4() {
                return keyword_4;
            }

            public void setKeyword_4(Keyword4Bean keyword_4) {
                this.keyword_4 = keyword_4;
            }

            public Keyword5Bean getKeyword_5() {
                return keyword_5;
            }

            public void setKeyword_5(Keyword5Bean keyword_5) {
                this.keyword_5 = keyword_5;
            }

            public Keyword6Bean getKeyword_6() {
                return keyword_6;
            }

            public void setKeyword_6(Keyword6Bean keyword_6) {
                this.keyword_6 = keyword_6;
            }

            public Keyword7Bean getKeyword_7() {
                return keyword_7;
            }

            public void setKeyword_7(Keyword7Bean keyword_7) {
                this.keyword_7 = keyword_7;
            }

            public Keyword8Bean getKeyword_8() {
                return keyword_8;
            }

            public void setKeyword_8(Keyword8Bean keyword_8) {
                this.keyword_8 = keyword_8;
            }

            public Keyword9Bean getKeyword_9() {
                return keyword_9;
            }

            public void setKeyword_9(Keyword9Bean keyword_9) {
                this.keyword_9 = keyword_9;
            }

            public Keyword10Bean getKeyword_10() {
                return keyword_10;
            }

            public void setKeyword_10(Keyword10Bean keyword_10) {
                this.keyword_10 = keyword_10;
            }

            public Keyword11Bean getKeyword_11() {
                return keyword_11;
            }

            public void setKeyword_11(Keyword11Bean keyword_11) {
                this.keyword_11 = keyword_11;
            }

            public Keyword12Bean getKeyword_12() {
                return keyword_12;
            }

            public void setKeyword_12(Keyword12Bean keyword_12) {
                this.keyword_12 = keyword_12;
            }

            public Keyword13Bean getKeyword_13() {
                return keyword_13;
            }

            public void setKeyword_13(Keyword13Bean keyword_13) {
                this.keyword_13 = keyword_13;
            }

            public Keyword14Bean getKeyword_14() {
                return keyword_14;
            }

            public void setKeyword_14(Keyword14Bean keyword_14) {
                this.keyword_14 = keyword_14;
            }

            public Keyword15Bean getKeyword_15() {
                return keyword_15;
            }

            public void setKeyword_15(Keyword15Bean keyword_15) {
                this.keyword_15 = keyword_15;
            }

            public Keyword16Bean getKeyword_16() {
                return keyword_16;
            }

            public void setKeyword_16(Keyword16Bean keyword_16) {
                this.keyword_16 = keyword_16;
            }

            public Keyword17Bean getKeyword_17() {
                return keyword_17;
            }

            public void setKeyword_17(Keyword17Bean keyword_17) {
                this.keyword_17 = keyword_17;
            }

            public Keyword18Bean getKeyword_18() {
                return keyword_18;
            }

            public void setKeyword_18(Keyword18Bean keyword_18) {
                this.keyword_18 = keyword_18;
            }

            public Keyword19Bean getKeyword_19() {
                return keyword_19;
            }

            public void setKeyword_19(Keyword19Bean keyword_19) {
                this.keyword_19 = keyword_19;
            }

            public Keyword20Bean getKeyword_20() {
                return keyword_20;
            }

            public void setKeyword_20(Keyword20Bean keyword_20) {
                this.keyword_20 = keyword_20;
            }

            public Keyword21Bean getKeyword_21() {
                return keyword_21;
            }

            public void setKeyword_21(Keyword21Bean keyword_21) {
                this.keyword_21 = keyword_21;
            }

            public Keyword22Bean getKeyword_22() {
                return keyword_22;
            }

            public void setKeyword_22(Keyword22Bean keyword_22) {
                this.keyword_22 = keyword_22;
            }

            public Keyword23Bean getKeyword_23() {
                return keyword_23;
            }

            public void setKeyword_23(Keyword23Bean keyword_23) {
                this.keyword_23 = keyword_23;
            }

            public Keyword24Bean getKeyword_24() {
                return keyword_24;
            }

            public void setKeyword_24(Keyword24Bean keyword_24) {
                this.keyword_24 = keyword_24;
            }

            public Keyword25Bean getKeyword_25() {
                return keyword_25;
            }

            public void setKeyword_25(Keyword25Bean keyword_25) {
                this.keyword_25 = keyword_25;
            }

            public Keyword26Bean getKeyword_26() {
                return keyword_26;
            }

            public void setKeyword_26(Keyword26Bean keyword_26) {
                this.keyword_26 = keyword_26;
            }

            public Keyword27Bean getKeyword_27() {
                return keyword_27;
            }

            public void setKeyword_27(Keyword27Bean keyword_27) {
                this.keyword_27 = keyword_27;
            }

            public Keyword28Bean getKeyword_28() {
                return keyword_28;
            }

            public void setKeyword_28(Keyword28Bean keyword_28) {
                this.keyword_28 = keyword_28;
            }

            public Keyword29Bean getKeyword_29() {
                return keyword_29;
            }

            public void setKeyword_29(Keyword29Bean keyword_29) {
                this.keyword_29 = keyword_29;
            }

            public static class Keyword1Bean {
                /**
                 * CN : 请输入芯片编号
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword1Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword1Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword2Bean {
                /**
                 * CN : 请输入斗鸡编号
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword2Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword2Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword3Bean {
                /**
                 * CN : 请选择斗鸡品种
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword3Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword3Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword4Bean {
                /**
                 * CN : 请选择出生日期
                 * EN : Hatch Date
                 */

                private String CN;
                private String EN;

                public static Keyword4Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword4Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword5Bean {
                /**
                 * CN : 请输入芯片号，斗鸡编号鸡主名称或养殖场名称关键字进行搜索
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword5Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword5Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword6Bean {
                /**
                 * CN : 请输入机构名称名称关键字进行搜索
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword6Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword6Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword7Bean {
                /**
                 * CN : 请输入鸡主证件号码关键字进行搜索
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword7Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword7Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword8Bean {
                /**
                 * CN : 请输入养殖场关键字进行搜索
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword8Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword8Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword9Bean {
                /**
                 * CN : 请输入引进人电话关键字进行搜索
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword9Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword9Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword10Bean {
                /**
                 * CN : 请上传斗鸡照片
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword10Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword10Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword11Bean {
                /**
                 * CN : 请输入养殖场，联系人，养殖场电话关键字进行搜索
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword11Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword11Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword12Bean {
                /**
                 * CN : 请输入鸡主名称，证件号码，联系电话关键字进行搜索
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword12Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword12Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword13Bean {
                /**
                 * CN : 请输入养殖场名称
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword13Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword13Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword14Bean {
                /**
                 * CN : 请输入养殖场地址
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword14Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword14Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword15Bean {
                /**
                 * CN : 请输入养殖场联系人
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword15Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword15Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword16Bean {
                /**
                 * CN : 请输入联系人电话
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword16Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword16Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword17Bean {
                /**
                 * CN : 请选择联系人称谓
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword17Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword17Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword18Bean {
                /**
                 * CN : 请输入引进人名称
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword18Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword18Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword19Bean {
                /**
                 * CN : 请输入引进人地址
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword19Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword19Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword20Bean {
                /**
                 * CN : 请输入引进人电话
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword20Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword20Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword21Bean {
                /**
                 * CN : 请输入鸡主名称
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword21Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword21Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword22Bean {
                /**
                 * CN : 请输入鸡主称谓
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword22Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword22Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword23Bean {
                /**
                 * CN : 请输入鸡主地址
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword23Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword23Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword24Bean {
                /**
                 * CN : 请输入鸡主电话
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword24Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword24Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword25Bean {
                /**
                 * CN : 请输入鸡主证件号码
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword25Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword25Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword26Bean {
                /**
                 * CN : 请输入登录账号
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword26Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword26Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword27Bean {
                /**
                 * CN : 请输入登录密码
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword27Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword27Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword28Bean {
                /**
                 * CN : 请输选择地区范围
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword28Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword28Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class Keyword29Bean {
                /**
                 * CN : 请输选择行政区域
                 * EN :
                 */

                private String CN;
                private String EN;

                public static Keyword29Bean objectFromData(String str) {

                    return new Gson().fromJson(str, Keyword29Bean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class ConfirmBeanX {
            /**
             * submit : {"CN":"信息数据已提交，是否回到列表页","EN":""}
             * remove : {"CN":"请您确认是否需要删除该条记录？","EN":""}
             * logout : {"CN":"请您确认是否需要淘汰该斗鸡？","EN":""}
             */

            private SubmitBean submit;
            private RemoveBean remove;
            private LogoutBean logout;

            public static ConfirmBeanX objectFromData(String str) {

                return new Gson().fromJson(str, ConfirmBeanX.class);
            }

            public SubmitBean getSubmit() {
                return submit;
            }

            public void setSubmit(SubmitBean submit) {
                this.submit = submit;
            }

            public RemoveBean getRemove() {
                return remove;
            }

            public void setRemove(RemoveBean remove) {
                this.remove = remove;
            }

            public LogoutBean getLogout() {
                return logout;
            }

            public void setLogout(LogoutBean logout) {
                this.logout = logout;
            }

            public static class SubmitBean {
                /**
                 * CN : 信息数据已提交，是否回到列表页
                 * EN :
                 */

                private String CN;
                private String EN;

                public static SubmitBean objectFromData(String str) {

                    return new Gson().fromJson(str, SubmitBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class RemoveBean {
                /**
                 * CN : 请您确认是否需要删除该条记录？
                 * EN :
                 */

                private String CN;
                private String EN;

                public static RemoveBean objectFromData(String str) {

                    return new Gson().fromJson(str, RemoveBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class LogoutBean {
                /**
                 * CN : 请您确认是否需要淘汰该斗鸡？
                 * EN :
                 */

                private String CN;
                private String EN;

                public static LogoutBean objectFromData(String str) {

                    return new Gson().fromJson(str, LogoutBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class MenuBean {
            /**
             * dashboard : {"CN":"首页","EN":"Dashboard"}
             * cock_manage : {"CN":"斗鸡管理","EN":"Game Fowl Management"}
             * cock_edit : {"CN":"斗鸡编辑","EN":"Game Fowl Edit"}
             * cock_detail : {"CN":"斗鸡详情","EN":"Game Fowl Detail"}
             * account_manage : {"CN":"账号管理","EN":"Account Management"}
             * chip_manage : {"CN":"芯片管理","EN":"Chip Management"}
             * setting : {"CN":"系统设置","EN":"Setting"}
             * breed_manage : {"CN":"斗鸡种类管理","EN":"Bloodline Management"}
             * area_manage : {"CN":"岛屿管理","EN":"Area Management"}
             * province_manage : {"CN":"行政区划管理","EN":"Province Management"}
             * org_manage : {"CN":"比赛机构管理","EN":"Federation Management"}
             * farm_manage : {"CN":"养殖场管理","EN":"Game Farm Management"}
             * oversear_farm : {"CN":"海外养殖场","EN":"Oversear Farm"}
             * local_farm : {"CN":"本地养殖场","EN":"Local Farm"}
             * owner_manage : {"CN":"鸡主场管理","EN":"Owner Management"}
             * user_manage : {"CN":"用户管理","EN":"User Management"}
             */

            private DashboardBean dashboard;
            private CockManageBean cock_manage;
            private CockEditBean cock_edit;
            private CockDetailBean cock_detail;
            private AccountManageBean account_manage;
            private ChipManageBean chip_manage;
            private SettingBean setting;
            private BreedManageBean breed_manage;
            private AreaManageBean area_manage;
            private ProvinceManageBean province_manage;
            private OrgManageBean org_manage;
            private FarmManageBean farm_manage;
            private OversearFarmBean oversear_farm;
            private LocalFarmBean local_farm;
            private OwnerManageBean owner_manage;
            private UserManageBean user_manage;

            public static MenuBean objectFromData(String str) {

                return new Gson().fromJson(str, MenuBean.class);
            }

            public DashboardBean getDashboard() {
                return dashboard;
            }

            public void setDashboard(DashboardBean dashboard) {
                this.dashboard = dashboard;
            }

            public CockManageBean getCock_manage() {
                return cock_manage;
            }

            public void setCock_manage(CockManageBean cock_manage) {
                this.cock_manage = cock_manage;
            }

            public CockEditBean getCock_edit() {
                return cock_edit;
            }

            public void setCock_edit(CockEditBean cock_edit) {
                this.cock_edit = cock_edit;
            }

            public CockDetailBean getCock_detail() {
                return cock_detail;
            }

            public void setCock_detail(CockDetailBean cock_detail) {
                this.cock_detail = cock_detail;
            }

            public AccountManageBean getAccount_manage() {
                return account_manage;
            }

            public void setAccount_manage(AccountManageBean account_manage) {
                this.account_manage = account_manage;
            }

            public ChipManageBean getChip_manage() {
                return chip_manage;
            }

            public void setChip_manage(ChipManageBean chip_manage) {
                this.chip_manage = chip_manage;
            }

            public SettingBean getSetting() {
                return setting;
            }

            public void setSetting(SettingBean setting) {
                this.setting = setting;
            }

            public BreedManageBean getBreed_manage() {
                return breed_manage;
            }

            public void setBreed_manage(BreedManageBean breed_manage) {
                this.breed_manage = breed_manage;
            }

            public AreaManageBean getArea_manage() {
                return area_manage;
            }

            public void setArea_manage(AreaManageBean area_manage) {
                this.area_manage = area_manage;
            }

            public ProvinceManageBean getProvince_manage() {
                return province_manage;
            }

            public void setProvince_manage(ProvinceManageBean province_manage) {
                this.province_manage = province_manage;
            }

            public OrgManageBean getOrg_manage() {
                return org_manage;
            }

            public void setOrg_manage(OrgManageBean org_manage) {
                this.org_manage = org_manage;
            }

            public FarmManageBean getFarm_manage() {
                return farm_manage;
            }

            public void setFarm_manage(FarmManageBean farm_manage) {
                this.farm_manage = farm_manage;
            }

            public OversearFarmBean getOversear_farm() {
                return oversear_farm;
            }

            public void setOversear_farm(OversearFarmBean oversear_farm) {
                this.oversear_farm = oversear_farm;
            }

            public LocalFarmBean getLocal_farm() {
                return local_farm;
            }

            public void setLocal_farm(LocalFarmBean local_farm) {
                this.local_farm = local_farm;
            }

            public OwnerManageBean getOwner_manage() {
                return owner_manage;
            }

            public void setOwner_manage(OwnerManageBean owner_manage) {
                this.owner_manage = owner_manage;
            }

            public UserManageBean getUser_manage() {
                return user_manage;
            }

            public void setUser_manage(UserManageBean user_manage) {
                this.user_manage = user_manage;
            }

            public static class DashboardBean {
                /**
                 * CN : 首页
                 * EN : Dashboard
                 */

                private String CN;
                private String EN;

                public static DashboardBean objectFromData(String str) {

                    return new Gson().fromJson(str, DashboardBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CockManageBean {
                /**
                 * CN : 斗鸡管理
                 * EN : Game Fowl Management
                 */

                private String CN;
                private String EN;

                public static CockManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, CockManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CockEditBean {
                /**
                 * CN : 斗鸡编辑
                 * EN : Game Fowl Edit
                 */

                private String CN;
                private String EN;

                public static CockEditBean objectFromData(String str) {

                    return new Gson().fromJson(str, CockEditBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class CockDetailBean {
                /**
                 * CN : 斗鸡详情
                 * EN : Game Fowl Detail
                 */

                private String CN;
                private String EN;

                public static CockDetailBean objectFromData(String str) {

                    return new Gson().fromJson(str, CockDetailBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class AccountManageBean {
                /**
                 * CN : 账号管理
                 * EN : Account Management
                 */

                private String CN;
                private String EN;

                public static AccountManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, AccountManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ChipManageBean {
                /**
                 * CN : 芯片管理
                 * EN : Chip Management
                 */

                private String CN;
                private String EN;

                public static ChipManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, ChipManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class SettingBean {
                /**
                 * CN : 系统设置
                 * EN : Setting
                 */

                private String CN;
                private String EN;

                public static SettingBean objectFromData(String str) {

                    return new Gson().fromJson(str, SettingBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class BreedManageBean {
                /**
                 * CN : 斗鸡种类管理
                 * EN : Bloodline Management
                 */

                private String CN;
                private String EN;

                public static BreedManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, BreedManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class AreaManageBean {
                /**
                 * CN : 岛屿管理
                 * EN : Area Management
                 */

                private String CN;
                private String EN;

                public static AreaManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, AreaManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class ProvinceManageBean {
                /**
                 * CN : 行政区划管理
                 * EN : Province Management
                 */

                private String CN;
                private String EN;

                public static ProvinceManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, ProvinceManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OrgManageBean {
                /**
                 * CN : 比赛机构管理
                 * EN : Federation Management
                 */

                private String CN;
                private String EN;

                public static OrgManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, OrgManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class FarmManageBean {
                /**
                 * CN : 养殖场管理
                 * EN : Game Farm Management
                 */

                private String CN;
                private String EN;

                public static FarmManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, FarmManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OversearFarmBean {
                /**
                 * CN : 海外养殖场
                 * EN : Oversear Farm
                 */

                private String CN;
                private String EN;

                public static OversearFarmBean objectFromData(String str) {

                    return new Gson().fromJson(str, OversearFarmBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class LocalFarmBean {
                /**
                 * CN : 本地养殖场
                 * EN : Local Farm
                 */

                private String CN;
                private String EN;

                public static LocalFarmBean objectFromData(String str) {

                    return new Gson().fromJson(str, LocalFarmBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class OwnerManageBean {
                /**
                 * CN : 鸡主场管理
                 * EN : Owner Management
                 */

                private String CN;
                private String EN;

                public static OwnerManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, OwnerManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class UserManageBean {
                /**
                 * CN : 用户管理
                 * EN : User Management
                 */

                private String CN;
                private String EN;

                public static UserManageBean objectFromData(String str) {

                    return new Gson().fromJson(str, UserManageBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class SubtitleBean {
            /**
             * new_cock : {"CN":"新增斗鸡","EN":"New Game Fowl"}
             * edit_cock : {"CN":"编辑斗鸡","EN":"Edit Game Fowl"}
             * new_farm : {"CN":"新增养殖场","EN":"New Game Farm"}
             * edit_farm : {"CN":"编辑养殖场","EN":"Edit Game Farm"}
             * new_org : {"CN":"新增机构","EN":"New Federation"}
             * edit_org : {"CN":"编辑机构","EN":"Edit Federation"}
             * pnew_owner : {"CN":"新增鸡主","EN":"New Owner"}
             * edit_owner : {"CN":"编辑鸡主","EN":"Edit Owner"}
             * new_user : {"CN":"新增用户","EN":"New User"}
             * edit_user : {"CN":"编辑用户","EN":"Edit User"}
             * edit_area : {"CN":"新增地区","EN":"New Area"}
             * edit_province : {"CN":"新增行政区域","EN":"New Province"}
             */

            private NewCockBean new_cock;
            private EditCockBean edit_cock;
            private NewFarmBean new_farm;
            private EditFarmBean edit_farm;
            private NewOrgBean new_org;
            private EditOrgBean edit_org;
            private PnewOwnerBean pnew_owner;
            private EditOwnerBean edit_owner;
            private NewUserBean new_user;
            private EditUserBean edit_user;
            private EditAreaBean edit_area;
            private EditProvinceBean edit_province;

            public static SubtitleBean objectFromData(String str) {

                return new Gson().fromJson(str, SubtitleBean.class);
            }

            public NewCockBean getNew_cock() {
                return new_cock;
            }

            public void setNew_cock(NewCockBean new_cock) {
                this.new_cock = new_cock;
            }

            public EditCockBean getEdit_cock() {
                return edit_cock;
            }

            public void setEdit_cock(EditCockBean edit_cock) {
                this.edit_cock = edit_cock;
            }

            public NewFarmBean getNew_farm() {
                return new_farm;
            }

            public void setNew_farm(NewFarmBean new_farm) {
                this.new_farm = new_farm;
            }

            public EditFarmBean getEdit_farm() {
                return edit_farm;
            }

            public void setEdit_farm(EditFarmBean edit_farm) {
                this.edit_farm = edit_farm;
            }

            public NewOrgBean getNew_org() {
                return new_org;
            }

            public void setNew_org(NewOrgBean new_org) {
                this.new_org = new_org;
            }

            public EditOrgBean getEdit_org() {
                return edit_org;
            }

            public void setEdit_org(EditOrgBean edit_org) {
                this.edit_org = edit_org;
            }

            public PnewOwnerBean getPnew_owner() {
                return pnew_owner;
            }

            public void setPnew_owner(PnewOwnerBean pnew_owner) {
                this.pnew_owner = pnew_owner;
            }

            public EditOwnerBean getEdit_owner() {
                return edit_owner;
            }

            public void setEdit_owner(EditOwnerBean edit_owner) {
                this.edit_owner = edit_owner;
            }

            public NewUserBean getNew_user() {
                return new_user;
            }

            public void setNew_user(NewUserBean new_user) {
                this.new_user = new_user;
            }

            public EditUserBean getEdit_user() {
                return edit_user;
            }

            public void setEdit_user(EditUserBean edit_user) {
                this.edit_user = edit_user;
            }

            public EditAreaBean getEdit_area() {
                return edit_area;
            }

            public void setEdit_area(EditAreaBean edit_area) {
                this.edit_area = edit_area;
            }

            public EditProvinceBean getEdit_province() {
                return edit_province;
            }

            public void setEdit_province(EditProvinceBean edit_province) {
                this.edit_province = edit_province;
            }

            public static class NewCockBean {
                /**
                 * CN : 新增斗鸡
                 * EN : New Game Fowl
                 */

                private String CN;
                private String EN;

                public static NewCockBean objectFromData(String str) {

                    return new Gson().fromJson(str, NewCockBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EditCockBean {
                /**
                 * CN : 编辑斗鸡
                 * EN : Edit Game Fowl
                 */

                private String CN;
                private String EN;

                public static EditCockBean objectFromData(String str) {

                    return new Gson().fromJson(str, EditCockBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class NewFarmBean {
                /**
                 * CN : 新增养殖场
                 * EN : New Game Farm
                 */

                private String CN;
                private String EN;

                public static NewFarmBean objectFromData(String str) {

                    return new Gson().fromJson(str, NewFarmBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EditFarmBean {
                /**
                 * CN : 编辑养殖场
                 * EN : Edit Game Farm
                 */

                private String CN;
                private String EN;

                public static EditFarmBean objectFromData(String str) {

                    return new Gson().fromJson(str, EditFarmBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class NewOrgBean {
                /**
                 * CN : 新增机构
                 * EN : New Federation
                 */

                private String CN;
                private String EN;

                public static NewOrgBean objectFromData(String str) {

                    return new Gson().fromJson(str, NewOrgBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EditOrgBean {
                /**
                 * CN : 编辑机构
                 * EN : Edit Federation
                 */

                private String CN;
                private String EN;

                public static EditOrgBean objectFromData(String str) {

                    return new Gson().fromJson(str, EditOrgBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class PnewOwnerBean {
                /**
                 * CN : 新增鸡主
                 * EN : New Owner
                 */

                private String CN;
                private String EN;

                public static PnewOwnerBean objectFromData(String str) {

                    return new Gson().fromJson(str, PnewOwnerBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EditOwnerBean {
                /**
                 * CN : 编辑鸡主
                 * EN : Edit Owner
                 */

                private String CN;
                private String EN;

                public static EditOwnerBean objectFromData(String str) {

                    return new Gson().fromJson(str, EditOwnerBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class NewUserBean {
                /**
                 * CN : 新增用户
                 * EN : New User
                 */

                private String CN;
                private String EN;

                public static NewUserBean objectFromData(String str) {

                    return new Gson().fromJson(str, NewUserBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EditUserBean {
                /**
                 * CN : 编辑用户
                 * EN : Edit User
                 */

                private String CN;
                private String EN;

                public static EditUserBean objectFromData(String str) {

                    return new Gson().fromJson(str, EditUserBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EditAreaBean {
                /**
                 * CN : 新增地区
                 * EN : New Area
                 */

                private String CN;
                private String EN;

                public static EditAreaBean objectFromData(String str) {

                    return new Gson().fromJson(str, EditAreaBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }

            public static class EditProvinceBean {
                /**
                 * CN : 新增行政区域
                 * EN : New Province
                 */

                private String CN;
                private String EN;

                public static EditProvinceBean objectFromData(String str) {

                    return new Gson().fromJson(str, EditProvinceBean.class);
                }

                public String getCN() {
                    return CN;
                }

                public void setCN(String CN) {
                    this.CN = CN;
                }

                public String getEN() {
                    return EN;
                }

                public void setEN(String EN) {
                    this.EN = EN;
                }
            }
        }

        public static class VersionBean {
            /**
             * no : 1.3
             */

            private String no;

            public static VersionBean objectFromData(String str) {

                return new Gson().fromJson(str, VersionBean.class);
            }

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }
        }
    }
}


