package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

import net.sf.json.JSONArray;

public class PushBatchUniMsgRequest extends PushRequest{

	@HttpParamKeyName(name=BaiduPushConstants.MESSAGE_TYPE, param=R.OPTIONAL)
    @RangeRestrict(minLength=0, maxLength=1)
    private Integer msgType = new Integer(0);
    
    @HttpParamKeyName(name=BaiduPushConstants.MESSAGE, param=R.REQUIRE)
    private String message = null;
    
    @HttpParamKeyName(name=BaiduPushConstants.MSG_EXPIRES, param=R.OPTIONAL)
    @RangeRestrict(minLength=1, maxLength=86400 * 7)
    private Integer msgExpires = 3600 * 5;
    
/*    @HttpParamKeyName(name=BaiduPushConstants.DEPLOY_STATUS, param=R.OPTIONAL)
    @RangeRestrict(minLength=0, maxLength=1)
    private Integer deployStatus = null;*/		//不支持IOS
    
    @HttpParamKeyName(name=BaiduPushConstants.CHANNEL_IDS, param=R.REQUIRE)
    private String channelIds = null;
    
	@HttpParamKeyName(name=BaiduPushConstants.TOPIC_ID, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=128)
	private String topicId = null;
    
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
/*    public Integer getDeployStatus () {
    	return deployStatus;
    }*/
    public String getChannelIdsInString () {
    	return channelIds;
    }
    public String[] getChannelIdsInArray () {
    	JSONArray jsonChannelIds = JSONArray.fromObject(channelIds);
    	return (String[])jsonChannelIds.toArray();
    }
    public String getTopicId () {
        return topicId;
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
/*    public void setDeployStatus (Integer depolyStatus) {
    	this.deployStatus = depolyStatus;
    }*/
    public void setChannelIds (String[] channelIds) {
    	JSONArray tmpChannelIds = new JSONArray();
    	for (int i = 0; i < channelIds.length; i++){
    		tmpChannelIds.add(i, channelIds[i]);
    	}
    	this.channelIds = tmpChannelIds.toString();
    }
    public void setTopicId (String topicId) {
        this.topicId = topicId;
    }
    // add
    public PushBatchUniMsgRequest addMessageType (Integer msgType) {
    	this.msgType = msgType;
    	return this;
    }
    public PushBatchUniMsgRequest addMessage (String message) {
    	this.message = message;
    	return this;
    }
    public PushBatchUniMsgRequest addMsgExpires (Integer msgExpires) {
    	this.msgExpires = msgExpires;
    	return this;
    }
/*    public PushBatchUniMsgRequest addDepolyStatus (Integer deployStatus) {
    	this.deployStatus = deployStatus;
    	return this;
    }*/
    public PushBatchUniMsgRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public PushBatchUniMsgRequest addExpires(Long requestTimeOut) {
    	this.expires = requestTimeOut;
		return this;
	}
	public PushBatchUniMsgRequest addChannelIds (String[] channelIds) {
    	JSONArray tmpChannelIds = new JSONArray();
    	for (int i = 0; i < channelIds.length; i++){
    		tmpChannelIds.add(i, channelIds[i]);
    	}
    	this.channelIds = tmpChannelIds.toString();
    	return this;
    }
    public PushBatchUniMsgRequest addTopicId (String topicId) {
    	this.topicId = topicId;
    	return this;
    }
}
