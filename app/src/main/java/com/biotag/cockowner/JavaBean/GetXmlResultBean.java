package com.biotag.cockowner.JavaBean;

/**
 * Created by Lxh on 2017/8/29.
 */

public class GetXmlResultBean {

    /**
     * IsSuccess : false
     * Values : {"?xml":{"version":"1.0","encoding":"utf-8"},"Dictionary":{"cocks":{"chipCode":{"CN":"芯片编号","EN":""},"cockNo":{"CN":"斗鸡编号","EN":""},"breedID":{"CN":"品种","EN":""},"memo":{"CN":"备注信息","EN":""},"birth":{"CN":"出生日期","EN":""},"orgID":{"CN":"协会名称","EN":""},"cStatus":{"CN":"斗鸡状态","EN":""},"farmID":{"CN":"养殖场名称","EN":""},"creatorid":{"CN":"创建人","EN":""},"createAt":{"CN":"创建时间","EN":""},"lastOwnerID":{"CN":"当前鸡主信息","EN":""},"regDate1":{"CN":"达成第一阶段日期","EN":""},"regDate2":{"CN":"达成第二阶段日期","EN":""},"regDate3":{"CN":"达成第三阶段日期","EN":""},"isImport":{"CN":"是否进口","EN":""},"importerID":{"CN":"引进人姓名","EN":""}},"owners":{"ownerName":{"CN":"鸡主姓名","EN":""},"oTitle":{"CN":"称谓","EN":""},"oAddress":{"CN":"鸡主地址","EN":""},"oTel":{"CN":"鸡主电话","EN":""},"oIDNo":{"CN":"证件号码","EN":""},"ownDate":{"CN":"创建日期","EN":""},"oDictionID":{"CN":"行政区域名称","EN":""},"isPersonal":{"CN":"是否是个人","EN":""},"farmid":{"CN":"养殖场名称","EN":""},"username":{"CN":"登录账号","EN":""},"password":{"CN":"登录密码","EN":""}},"organization":{"orgName":{"CN":"协会名称","EN":""},"gAddress":{"CN":"地址","EN":""},"gTel":{"CN":"电话","EN":""},"gContactor":{"CN":"联系人","EN":""},"gTitle":{"CN":"称谓","EN":""},"gCode":{"CN":"机构代码","EN":""},"parentID":{"CN":"母机构编号","EN":""}},"farm":{"mFarmName":{"CN":"养殖场名称","EN":""},"mContactor":{"CN":"联系人","EN":""},"mTitle":{"CN":"称谓","EN":""},"mAddress":{"CN":"地址","EN":""},"mDictionID":{"CN":"行政区域名称","EN":""},"mTel":{"CN":"电话","EN":""},"isOversea":{"CN":"是否是海外养殖场","EN":""}},"importer":{"importerName":{"CN":"引进人姓名","EN":""},"iAddress":{"CN":"地址","EN":""},"iTel":{"CN":"电话","EN":""},"iTitle":{"CN":"称谓","EN":""}},"breed":{"breedName":{"CN":"品种名称","EN":""}},"user":{"uRealname":{"CN":"真实姓名","EN":""},"username":{"CN":"登录账号","EN":""},"password":{"CN":"登录密码","EN":""},"utype":{"CN":"用户类型","EN":""},"uStatus":{"CN":"用户状态","EN":""},"orgID":{"CN":"机构编号","EN":""}},"games":{"cock_chip1":{"CN":"一号斗鸡芯片号","EN":""},"cock_chip2":{"CN":"二号斗鸡芯片号","EN":""},"org_id":{"CN":"机构编号","EN":""},"createUser":{"CN":"记录人","EN":""},"createAt":{"CN":"记录生成日期","EN":""},"win_cock":{"CN":"获胜斗鸡芯片号","EN":""},"result_time":{"CN":"比赛结果生成时间","EN":""}},"diction":{"dictName":{"CN":"行政区域名称","EN":""},"areaId":{"CN":"岛屿编号","EN":""}},"area":{"areaName":{"CN":"岛屿名称","EN":""}},"StatusData":{"cocks":{"cStatus":[{"CN":"正常","EN":"","#text":"1"},{"CN":"淘汰","EN":"","#text":"2"},{"CN":"走失","EN":"","#text":"3"}]},"users":{"uStatus":[{"CN":"正常","EN":"","#text":"1"},{"CN":"注销","EN":"","#text":"2"}],"utype":[{"CN":"机构用户","EN":"","#text":"1"},{"CN":"鸡主用户","EN":"","#text":"2"}]}},"TitleData":{"title":[{"CN":"先生","EN":"","#text":"1"},{"CN":"女士","EN":"","#text":"2"}]},"DB_PROC":{"cocks":{"add":{"msg":[{"CN":"斗鸡信息添加成功！","EN":"","#text":"1"},{"CN":"此芯片未授权，请更换！","EN":"","#text":"-1"},{"CN":"此芯片已被使用，请更换！","EN":"","#text":"-2"},{"CN":"数据库错误，请稍后重试！","EN":"","#text":"-99"}]},"get":{"msg":[{"CN":"检索成功！","EN":"","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"","#text":"-1"},{"CN":"未检索到符合条件的记录！","EN":"","#text":"-2"}]},"update_regdate":{"msg":[{"CN":"登记评定成功！","EN":"","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"","#text":"-99"}]},"update_status":{"msg":[{"CN":"斗鸡状态更新成功！","EN":"","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"","#text":"-1"},{"CN":"数据库错误，请稍后重试！","EN":"","#text":"-99"}]}},"owners":{"login":{"msg":[{"CN":"登录成功，欢迎使用！","EN":"","#text":"1"},{"CN":"数据参数无效，请重试！","EN":"","#text":"-1"},{"CN":"登录失败，用户名或密码错误！","EN":"","#text":"-2"}]}}},"Upload_Image":{"msg":[{"CN":"图片上传成功","EN":"","#text":"1"},{"CN":"请选择上传图片","EN":"","#text":"-1"},{"CN":"图片大小超过限制","EN":"","#text":"-2"},{"CN":"不支持上传图片的类型","EN":"","#text":"-3"},{"CN":"系统错误，请稍后重试！","EN":"","#text":"-99"}]},"basic":{"operation":{"CN":"操作","EN":""},"submit":[{"CN":"确定","EN":""},{"CN":"取消","EN":""}]},"version":{"no":"1"}}}
     * Status : 0
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private String Values;
    private int Status;
    private int TotalCount;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public String getValues() {
        return Values;
    }

    public void setValues(String Values) {
        this.Values = Values;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }
}
