package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class QueryTimerRecordsRequest extends PushRequest {

	@HttpParamKeyName(name=BaiduPushConstants.TIMER_ID, param=R.OPTIONAL)
	private String timerId = null;
	
	@HttpParamKeyName(name=BaiduPushConstants.START, param=R.OPTIONAL)
	private Integer start = new Integer(0);
	
	@HttpParamKeyName(name=BaiduPushConstants.LIMIT, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=100)
	private Integer limit = new Integer(100);

	@HttpParamKeyName(name=BaiduPushConstants.RANGE_START, param=R.OPTIONAL)
	private Long rangeStart = null;
	
	@HttpParamKeyName(name=BaiduPushConstants.RANGE_END, param=R.OPTIONAL)
	private Long rangeEnd = null;
	
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
	public Long getRangeStart () {
		return rangeStart;
	}
	public Long getRangeEnd () {
		return rangeEnd;
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
	public void setRangeStart (Long rangeStart) {
		this.rangeStart = rangeStart;
	}
	public void setRangeEnd (Long rangeEnd) {
		this.rangeEnd = rangeEnd;
	}
    // add
    public QueryTimerRecordsRequest addTimerId (String timerId) {
    	this.timerId = timerId;
    	return this;
    }
    public QueryTimerRecordsRequest addStart (Integer start) {
    	this.start = start;
    	return this;
    }
    public QueryTimerRecordsRequest addLimit (Integer limite) {
    	this.limit = limite;
    	return this;
    }
    public QueryTimerRecordsRequest addRangeStart (Long rangeStart) {
    	this.rangeStart = rangeStart;
    	return this;
    }
    public QueryTimerRecordsRequest addRangeEnd (Long rangeEnd) {
    	this.rangeEnd = rangeEnd;
    	return this;
    }
    public QueryTimerRecordsRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public QueryTimerRecordsRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
	
}
