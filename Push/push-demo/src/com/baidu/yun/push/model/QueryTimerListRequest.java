package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class QueryTimerListRequest extends PushRequest{

	@HttpParamKeyName(name=BaiduPushConstants.TIMER_ID, param=R.OPTIONAL)
	private String timerId = null;
	
	@HttpParamKeyName(name=BaiduPushConstants.START, param=R.OPTIONAL)
	private Integer start = new Integer(0);
	
	@HttpParamKeyName(name=BaiduPushConstants.LIMIT, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=100)
	private Integer limit = new Integer(100);

	// get
	public String getTimerId () {
		return timerId;
	}
	public Integer getStart () {
		return start;
	}
	public Integer getLimit () {
		return limit;
	}
	// set
    public void setTimerId (String timerId) {
		this.timerId = timerId;
	}
	public void setStart (Integer start) {
		this.start = start;
	}
	public void setLimit (Integer limit) {
		this.limit = limit;
	}
    // add
    public QueryTimerListRequest addTimerId (String timerId) {
    	this.timerId = timerId;
    	return this;
    }
    public QueryTimerListRequest addStart (Integer start) {
    	this.start = start;
    	return this;
    }
    public QueryTimerListRequest addLimit (Integer limite) {
    	this.limit = limite;
    	return this;
    }
    public QueryTimerListRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public QueryTimerListRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
}
