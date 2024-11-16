/***************************************************************************
 * 
 * Copyright (c) 2015 Baidu.com, Inc. All Rights Reserved
 * 
 **************************************************************************/
 
 
 
/**
 * @file PushMsgToSingleDeviceResponse.java
 * @author liulin06(com@baidu.com)
 * @date 2015/01/14 23:26:19
 * @brief 
 *  
 **/

package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.JSonPath;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class PushMsgToSingleDeviceResponse extends PushResponse {
    
    @JSonPath(path="response_params\\msg_id")
    @HttpParamKeyName(name=BaiduPushConstants.MSG_ID, param=R.REQUIRE)
    private String msgId = null;

//    @JSonPath(path="response_params\\timer_id")
//    @HttpParamKeyName(name=BaiduPushConstants.TIMER_ID, param=R.OPTIONAL)
//    private String timerId;
    
    @JSonPath(path="response_params\\send_time")
    @HttpParamKeyName(name=BaiduPushConstants.SEND_TIME, param=R.REQUIRE)
    private long sendTime;
    
    public String getMsgId () {
        return msgId;
    }
//    public String getTimerId () {
//        return timerId;
//    }
    public long getSendTime () {
        return sendTime;
    }

}




















/* vim: set expandtab ts=4 sw=4 sts=4 tw=100: */
