package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class PushMsgToTagRequest extends PushRequest{

	@HttpParamKeyName(name=BaiduPushConstants.TAG_NAME, param=R.REQUIRE)
	@RangeRestrict(minLength=1, maxLength=128)
	private String tagName = null;
	
	@HttpParamKeyName(name=BaiduPushConstants.MESSAGE_TYPE, param=R.OPTIONAL)
	@RangeRestrict(minLength=0, maxLength=1)
	private Integer msgType = new Integer(0);
	
	@HttpParamKeyName(name=BaiduPushConstants.MESSAGE, param=R.REQUIRE)
	private String message = null;
	
	@HttpParamKeyName(name=BaiduPushConstants.MSG_EXPIRES, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=86400 * 7)
	private Integer msgExpires = new Integer(3600);
	
	@HttpParamKeyName(name=BaiduPushConstants.DEPLOY_STATUS, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=2)
	private Integer deployStatus = null;
    
    @HttpParamKeyName(name=BaiduPushConstants.SEND_TIME, param=R.OPTIONAL)
    private Long sendTime = null;
    
	// 组播消息推送类型，类PushMsgToTagRequest是向用户定义的组推送请求，pushType设置为1.
    // 不要修改该值
    @HttpParamKeyName(name=BaiduPushConstants.PUSH_TAG_TYPE, param=R.REQUIRE)
    private static final Integer pushTagType = new Integer(1);
    
	// get
	public String getTagName () {
		return tagName;
	}
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
    public Integer getPushTagType () {
    	return pushTagType;
    }
    public Long getSendTime () {
    	return sendTime;
    }
	// set
	public void setTagName (String tagName) {
		this.tagName = tagName;
	}
	public void setMessageType (Integer msgType) {
		this.msgType = msgType;
	}
	public void setMessage (String message) {
		this.message = message;
	}
	public void setMsgExpires (Integer msgExpires) {
		this.msgExpires = msgExpires;
	}
	public void setDeployStatus (Integer deployStatus) {
		this.deployStatus = deployStatus;
	}
	public void setSendTime (long sendTime) {
		this.sendTime = sendTime;
	}
	// add
	public PushMsgToTagRequest addTagName (String tagName) {
		this.tagName = tagName;
		return this;
	}
	public PushMsgToTagRequest addMessageType (Integer msgType) {
		this.msgType = msgType;
		return this;
	}
	public PushMsgToTagRequest addMessage (String message) {
		this.message = message;
		return this;
	}
	public PushMsgToTagRequest addMsgExpires (Integer msgExpires) {
		this.msgExpires = msgExpires;
		return this;
	}
	public PushMsgToTagRequest addDeployStatus (Integer deployStatus) {
		this.deployStatus = deployStatus;
		return this;
	}
	public PushMsgToTagRequest addSendTime (long sendTime) {
		this.sendTime = sendTime;
		return this;
	}
    public PushMsgToTagRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public PushMsgToTagRequest addExpires(Long requestTimeOut) {
	    this.expires = requestTimeOut;
		return this;
	}
}
