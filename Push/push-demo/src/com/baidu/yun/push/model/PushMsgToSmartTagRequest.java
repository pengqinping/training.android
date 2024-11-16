package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class PushMsgToSmartTagRequest extends PushRequest{
	
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
	private Integer deployStatus = null;		//不支持IOS
    
	// 组播消息推送的类型，6:组合运算标签。目前，仅支持组合运算。
    @HttpParamKeyName(name=BaiduPushConstants.PUSH_TAG_TYPE, param=R.REQUIRE)
    @RangeRestrict(minLength=2, maxLength=6)
    private Integer pushTagType = 6;
    
    @HttpParamKeyName(name=BaiduPushConstants.SELECTOR, param=R.REQUIRE)
    private String selector = null;
    
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
    public Integer getDeviceType () {
    	return deviceType;
    }
    public Integer getPushTagType () {
    	return pushTagType;
    }
    public String getSelector () {
    	return selector;
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
	public void setDeployStatus (Integer deployStatus) {
		this.deployStatus = deployStatus;
	}
    public void setDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    }
    public void setPushTagType (Integer pushTagType) {
    	this.pushTagType = pushTagType;
    }
    public void setSelector (String selector) {
    	this.selector = selector;
    }
    public void setSendTime (long sendTime) {
    	this.sendTime = sendTime;
    }
	// add
	public PushMsgToSmartTagRequest addMessageType (Integer msgType) {
		this.msgType = msgType;
		return this;
	}
	public PushMsgToSmartTagRequest addMessage (String message) {
		this.message = message;
		return this;
	}
	public PushMsgToSmartTagRequest addMsgExpires (Integer msgExpires) {
		this.msgExpires = msgExpires;
		return this;
	}
	public PushMsgToSmartTagRequest addDeployStatus (Integer deployStatus) {
		this.deployStatus = deployStatus;
		return this;
	}
    public PushMsgToSmartTagRequest addPushTagType (Integer pushTagType) {
    	this.pushTagType = pushTagType;
    	return this;
    }
    public PushMsgToSmartTagRequest addSelector (String selector) {
    	this.selector = selector;
    	return this;
    }
    public PushMsgToSmartTagRequest addSendTime (long sendTime) {
    	this.sendTime = sendTime;
    	return this;
    }
    public PushMsgToSmartTagRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public PushMsgToSmartTagRequest addExpires(Long requestTimeOut) {
	    this.expires = requestTimeOut;
		return this;
	}
}

