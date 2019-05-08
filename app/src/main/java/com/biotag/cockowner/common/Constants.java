package com.biotag.cockowner.common;

/**
 * Created by Lxh on 2017/8/3.
 */

public class Constants {
//    public static final String  HEADIMG_FILEDIRECTORY = "headImg";
    public static final String  BOUNDARY              ="*****asdfagdfjhhg*******";
    public static final String   TAG          = "tms";
//    public static final boolean SHOW_TITLEBAR = true;

//    public static final String LOGIN_URL = "";

//    public static final String COCK_INFO_URL = "";

//    public static final String POSTCOCKIMG_URL="";

    public static final String AREA_NUM = "areanum";

    public static final String BREED_NUM = "breednum";

//    public static final String DICTION_NUM = "dictionnum";

//    public static final String IMG_TYPE = "imgtype";
    //==================================存储用户登录信息的公共key
//    public static final String APPCONFIG_VALUES = "appconfig_values";
    public static final String ID = "id";
    public static final String DERBY = "derby";
    public static final String OWNERNAME = "ownerName";
    public static final String OTITLE = "oTitle";
    public static final String OADDRESS = "oAddress";
    public static final String OTEL = "oTel";
    public static final String OIDNO = "oIDNo";
    public static final String OWNDATE = "ownDate";
    public static final String ISPERSONAL = "isPersonal";
    public static final String FARMIDLOGIN = "farmid";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String FARMNAME = "farmname";

    //==================存储斗鸡信息key
//    public static final String COCKID = "ID";
    public static final String CHIPCODE = "chipCode";
    public static final String COCKNO = "cockNo";
    public static final String BREEDID = "breedID";
    public static final String MEMO = "memo";
    public static final String BIRTH = "birth";
    public static final String ORGID = "orgID";
    public static final String CSTATUS = "cStatus";
    public static final String FARMID = "farmID";
    public static final String CREATORID = "creatorid";
//    public static final String MFARMNAME = "mFarmName";
//    public static final String ORGNAME = "OrgName";
//    public static final String COCKOWNERNAME = "ownerName";
    public static final String APPCONFIG = "appconfig";
    public static final String LASTOWNERID = "lastOwnerID";
    public static final String DICTIONARYVERSION = "dictionaryversion";




    //===============  handler 发送消息 用到的 常量值
    public static final int GETDATA_FAIL                 = 0;
    public static final int GETDATA_SUCCESS              = 1;
    public static final int SUCCESS_FIX_COCK_STATUS      = 2;
    public static final int FAIL_FIX_COCK_STATUS         = 3;
    public static final int SUCCESS_FIX_COCK_REGDATE_ONE = 4;
    public static final int FAIL_FIX_COCK_REGDATE_ONE    = 5;
    public static final int LOGIN_SUCCESS                = 6;
    public static final int LOGIN_FAIL                   = 7;
//    public static final int SUCCESS_GETGAME_RECORD       = 8;
//    public static final int FAIL_GETGAME_RECORD          = 9;
    public static final int AVAILABLE_CHIPCODE           = 10;
    public static final int UNAVAILABLE_CHIPCODE         = 11;
    public static final int AVAILABLE_COCKNO             = 12;
    public static final int UNAVAILABLE_COCKNO           = 13;
    public static final int SKIN_COCK_IMG                = 14;
    public static final int LEG_COCK_IMG                 = 15;
    public static final int LOGIN_FAIL_NONET             = 16;
    public static final int MANI_SUC                     = 17;
//    public static final int MANI_FAIL                    = 18;
    public static final int MANI_USELESS                 = 19;
    public static final int GET_ALLORG                   = 20;
    //++++++++++++++++++++++用来标记是斗鸡的skin 图片还是leg图片

    public static final int SUCCESS_FIX_COCK_DERBY       = 21;
    public static final int FAIL_FIX_COCK_DERBY          = 22;
    public static final int SETWICOCK_SUC                = 23;
    public static final int SETWICOCK_FAI                = 24;
    public static final int SUCCESS_FIX_COCK_WEIGHT      = 25;
    public static final int FAIL_FIX_COCK_WEIGHT         = 26;
    //=============================================================
    public static final int NEED_DOWNLOAD_APK            = 27;
    public static final int UNNECESSARY_DOWNLOAD_APK     = 28;
    public static final int POOR_NET_WORK                = 29;




//    public static final String COCKINFOBEAN = "cockinfo";
    //====================================  URL

//    private static final String HOST = "http://211.152.45.196:8123/";
    public static final String HOST = "https://sys.birdentity.com/webapi/";

    /**get
     * 用户登录
     **/
    public static final String USR_LOGIN_URL             = HOST + "api/Owners/Login?username={username}&password={password}";

    /**post
     * 添加斗鸡信息给当下的鸡主
     */
    public static final String ADD_COCKINFO_URL           = HOST + "api/Cocks/Add";
    /**get
     *斗鸡信息查询
     */
    public static final String QUERY_COCK_URL             = HOST +"api/Cocks/Search?strQuery={strQuery}";
    /** post
     * 修改斗鸡状态
     *
     */
    public static final String FIX_COCK_STATUS_URL        = HOST+"api/Cocks/UpdateStatus";
    /**
     * 设置斗鸡的derby
     */
    public static final String FIX_COCK_DERBY_URL         = HOST+"api/Cocks/UpdateDerby";
    /**post
     * 斗鸡等级评定
     */
    public static final String FIX_COCK_REGDATE_URL       = HOST+"api/Cocks/UpdateRegdate";
    /**
     * post
     * 设置斗鸡的体重
     */
    public static final String FIX_COCK_WEIGHT_URL        = HOST+"api/Cocks/UpdateWeight";
    /**get
     * 由斗鸡的ID查询斗鸡的详细信息
     */
    public static final String QUERY_COCK_BY_ID_URL       = HOST+"api/Cocks/Get/{id}";
    /**get
     *查询地区
     */
//    public static final String QUERY_AREA_URL             = HOST +"api/Area/Get?strQuery={strQuery}";
    /**get
     * 查询diction    获取地区信息
     */
    public static final String QUERY_DISTRIT_URL          = HOST + "api/Diction/Get?strQuery={strQuery}";
    /**get
     *版本号
     */
//    public static final String VERSION_URL                = HOST+"api/Version/Get?type={type}";
    /**get
     *breedid
     */
    public static final String BREEDID_URL                = HOST + "api/Breed/Get?strQuery={strQuery}";
    /**post
     *上传图片
     */
    public static final String UPLOAD_PHOTO_URL           = HOST + "api/Photos/UploadPhoto";
    /**get
     * 比赛记录 搜索比赛记录
     */
    public static final String GAME_RECORD_URL            = HOST + "api/Games/Get?strQuery={strQuery}";
    /**post
     * 设置获胜斗鸡信息
     */
    public static final String SET_WINCOCK_URL            = HOST + "api/Games/SetWinCock";
    /**
     * 图片的加载路径url
     */
//    public static final String COCKIMG_URL                = HOST + "upload/{chipcode}.jpg";
    /**
     * 图片的加载路径
     */
    public static final String COCKIMG_URL                = HOST + "upload/{20170907}/{chipcode}_{skin}.jpg";
    /**
     * 决定是否要重新请求breed与diction的接口的 判断值得接口
     */
    public static final String DICTIONARY_VERSION_URL     = HOST + "api/Version/Get?type=dictionary";
    /**
     * 获取配置表版本号
     */
    public static final String APP_CONFIG_URL             = HOST + "api/Version/Get?type=app_config";
    /**
     * 获取app的版本号，以决定是否下载新的版本
     */
    public static final String APP_VERSION                = HOST + "api/Version/Get?type=owner_version";
    /**
     * 获取中英对照xml文件的接口，以json 的形式返回xml
     */
    public static final String DICTIONARYXML_URL          = HOST + "api/Version/GetDictionary";
    /**
     * 获取地区信息    获取岛信息
     */
    public static final String GET_AREAINFO_URL           = HOST + "api/Area/Get?strQuery={strQuery}";
    /**
     * xml 的下载地址
     */
//    public static final String XML_DOWNLOAD_URL           = HOST + "dictionary.xml";
    /**
     * 判断斗鸡芯片号时候否可用
     */
    public static final String CHIPCODE_ISAVAILABLE_URL   = HOST + "api/Cocks/ValidateChipCode?strQuery={strQuery}";
    /**
     * 判断斗鸡编号是否可用
     */
    public static final String COCKNO_ISAVAILABLE_URL     = HOST + "api/Cocks/ValidateCockNo?strQuery={strQuery}";
    /**
     * 赛事机构的url ,得到三个赛事机构：
     */
    public static final String THREE_CONTEST_URL          = HOST + "api/Derby/GetList";
    /**
     * 得到所有子机构或母机构
     */
    public static final String ALLORG_URL                 = HOST + "api/Organizations/GetList";
}
