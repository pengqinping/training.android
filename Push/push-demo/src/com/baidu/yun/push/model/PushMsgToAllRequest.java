package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class PushMsgToAllRequest extends PushRequest {

    @HttpParamKeyName(name=BaiduPushConstants.MESSAGE_TYPE, param=R.OPTIONAL)
    @RangeRestrict(minLength=0, maxLength=1)
    private Integer msgType = new Integer(0);
    
    @HttpParamKeyName(name=BaiduPushConstants.MESSAGE, param=R.REQUIRE)
    private String message = null;
    
    @HttpParamKeyName(name=BaiduPushConstants.MSG_EXPIRES, param=R.OPTIONAL)
    @RangeRestrict(minLength=1, maxLength=86400 * 7)
    private Integer msgExpires = 3600 * 5;
    
    @HttpParamKeyName(name=BaiduPushConstants.DEPLOY_STATUS, param=R.OPTIONAL)
    @RangeRestrict(minLength=1, maxLength=2)
    private Integer deployStatus = null;
    
    @HttpParamKeyName(name=BaiduPushConstants.SEND_TIME, param=R.OPTIONAL)
    private Long sendTime = null;

    // get
    public Integer getMessageType () {
    	return msgType;
    }
    public String getMessage () {
    	return message;
    }
    public Integer getMsgExpires () {
    	return msgExpires;
    }
    public Integer getDeployStatus () {
    	return deployStatus;
    }
    public Long getSendTime () {
    	return sendTime;
    }
    // set
    public void setMessageType (Integer msgType) {
    	this.msgType = msgType;
    }
    public void setMessage (String message) {
    	this.message = message;
    }
    public void setMsgExpires (Integer msgExpires) {
    	this.msgExpires = msgExpires;
    }
    public void setDeployStatus (Integer depolyStatus) {
    	this.deployStatus = depolyStatus;
    }
    public void setSendTime (Long sendTime) {
    	this.sendTime = sendTime;
    }
    // add
    public PushMsgToAllRequest addMessageType (Integer msgType) {
    	this.msgType = msgType;
    	return this;
    }
    public PushMsgToAllRequest addMessage (String message) {
    	this.message = message;
    	return this;
    }
    public PushMsgToAllRequest addMsgExpires (Integer msgExpires) {
    	this.msgExpires = msgExpires;
    	return this;
    }
    public PushMsgToAllRequest addDepolyStatus (Integer deployStatus) {
    	this.deployStatus = deployStatus;
    	return this;
    }
    public PushMsgToAllRequest addSendTime (long sendTime) {
    	this.sendTime = sendTime;
    	return this;
    }
    public PushMsgToAllRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public PushMsgToAllRequest addExpires(Long requestTimeOut) {
    	this.expires = requestTimeOut;
		return this;
	}
}
