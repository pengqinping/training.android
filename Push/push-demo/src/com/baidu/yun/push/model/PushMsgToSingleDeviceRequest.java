/***************************************************************************
 * 
 * Copyright (c) 2015 Baidu.com, Inc. All Rights Reserved
 * 
 **************************************************************************/
 
 
 
/**
 * @file PushMsgToSingleDeviceRequest.java
 * @author liulin06(com@baidu.com)
 * @date 2015/01/14 22:24:52
 * @brief 
 *  
 **/
package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class PushMsgToSingleDeviceRequest extends PushRequest {
    
    @HttpParamKeyName(name=BaiduPushConstants.CHANNEL_ID, param=R.REQUIRE)
    private String channelId = null;

    @HttpParamKeyName(name=BaiduPushConstants.MESSAGE_TYPE, param=R.OPTIONAL)
    @RangeRestrict(minLength=0, maxLength=1)
    private Integer msgType = new Integer(0);

    @HttpParamKeyName(name=BaiduPushConstants.MESSAGE, param=R.REQUIRE)
    private String message = null;

    @HttpParamKeyName(name=BaiduPushConstants.MSG_EXPIRES, param=R.OPTIONAL)
    @RangeRestrict(minLength=1, maxLength=86400 * 7)
    private Integer msgExpires = 3600 * 5; //5 hours for expires
    
    // only for IOS PUSH
    @HttpParamKeyName(name=BaiduPushConstants.DEPLOY_STATUS, param=R.OPTIONAL)
    @RangeRestrict(minLength=1, maxLength=2)
    private Integer deployStatus = null;
    
	@HttpParamKeyName(name=BaiduPushConstants.TOPIC_ID, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=128)
	private String topicId = null;
    
    // get 
    public String getChannelId() {
        return channelId;
    }
    public Integer getMessageType() {
        return msgType;
    }
    public String getMessage() {
        return message;
    }
    public Integer getMsgExpires() {
        return msgExpires;
    }
    public String getTopicId () {
        return topicId;
    }
    public Integer getDeployStatus () {
        return deployStatus;
    }

    // set
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    public void setMessageType(Integer messageType) {
        this.msgType = messageType;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setMsgExpires(Integer msgExpires) {
        this.msgExpires = msgExpires;
    }
    public void setDeployStatus (Integer deployStatus) {
        this.deployStatus = deployStatus;
    }
    public void setTopicId (String topicId) {
        this.topicId = topicId;
    }

    // add
    public PushMsgToSingleDeviceRequest addChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }
    public PushMsgToSingleDeviceRequest addMessageType(Integer messageType) {
        this.msgType = messageType;
        return this;
    }
    public PushMsgToSingleDeviceRequest addMessage(String message) {
        this.message = message;
        return this;
    }
    public PushMsgToSingleDeviceRequest addMsgExpires(Integer msgExpires) {
        this.msgExpires = msgExpires;
        return this;
    }
    public PushMsgToSingleDeviceRequest addDeployStatus (Integer deployStatus) {
        this.deployStatus = deployStatus;
        return this;
    }
    public PushMsgToSingleDeviceRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
    public PushMsgToSingleDeviceRequest addExpires (Long requestTimeOut) {
    	this.expires = requestTimeOut;
    	return this;
    }
    public PushMsgToSingleDeviceRequest addTopicId (String topicId) {
    	this.topicId = topicId;
    	return this;
    }

}



















/* vim: set expandtab ts=4 sw=4 sts=4 tw=100: */
