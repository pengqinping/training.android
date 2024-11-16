package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.push.constants.BaiduPushConstants;

import net.sf.json.JSONArray;

public class QueryMsgStatusRequest extends PushRequest{
    // 当查询单个消息的状态时，传入消息的String 类型的id；
	// 当查询批量消息的状态时，需要传入String类型的消息Id的数组。
	@HttpParamKeyName(name=BaiduPushConstants.MSG_ID, param=R.REQUIRE)
	private String msgId = null;
	
//	@HttpParamKeyName(name=BaiduPushConstants.STATISTIC_TYPE, param=R.OPTIONAL)
//	private String statisticType = null;
	
	// get
	public String getMsgIdInString () {
		return msgId;
	}
    public String[] getMsgIdInArray () {
    	JSONArray jsonMsgIds = JSONArray.fromObject(msgId);
    	return (String[])jsonMsgIds.toArray();
    }
//    public String getStatType() {
//    	return statisticType;
//    }
    // set
    public void setMsgId (String msgId) {
		this.msgId = msgId;
	}
    public void setMsgIds (String[] msgIds) {
    	JSONArray tmpMsgIds = new JSONArray();
    	for (int i = 0; i < msgIds.length; i++){
    		tmpMsgIds.add(i, msgIds[i]);
    	}
    	this.msgId = tmpMsgIds.toString();
    }
//    public void setStatType(String statisticType) {
//    	this.statisticType = statisticType;
//    }
    // add
    public QueryMsgStatusRequest addMsgId (String msgId) {
    	this.msgId = msgId;
    	return this;
    }
	public QueryMsgStatusRequest addMsgIds (String[] msgIds) {
    	JSONArray tmpMsgIds = new JSONArray();
    	for (int i = 0; i < msgIds.length; i++){
    		tmpMsgIds.add(i, msgIds[i]);
    	}
    	this.msgId = tmpMsgIds.toString();
    	return this;
    }
//    public QueryMsgStatusRequest addStatType (String statisticType) {
//    	this.statisticType = statisticType;
//    	return this;
//    }
    public QueryMsgStatusRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public QueryMsgStatusRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
}
