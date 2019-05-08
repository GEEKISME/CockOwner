package com.biotag.cockowner.utils;

import android.content.Context;

/**
 * Created by Lxh on 2017/11/29.
 */

public class MobclickAgentWrapper {
    public static void onResume(Context context){
        com.baidu.mobstat.StatService.onResume(context);
    }
    public static void onPause(Context context){
        com.baidu.mobstat.StatService.onPause(context);
    }
    public static void onPageStart(Context context,String mPagename){
        com.baidu.mobstat.StatService.onPageStart(context,mPagename);
    }
    public static void onPageEnd(Context context,String mPagename){
        com.baidu.mobstat.StatService.onPageEnd(context,mPagename);
    }
    public static void onEvent(Context context,String event_id){
        com.baidu.mobstat.StatService.onEvent(context,event_id,"");
    }
    public static void onEvent(Context context, String event_id, String flag) {
        com.baidu.mobstat.StatService.onEvent(context, event_id,flag);
    }
}
