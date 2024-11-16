package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class QueryTopicRecordsRequest extends PushRequest {

	@HttpParamKeyName(name=BaiduPushConstants.TOPIC_ID, param=R.REQUIRE)
	@RangeRestrict(minLength=1, maxLength=128)
	private String topicId = null;
	
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
	public String getTopicId () {
		return topicId;
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
    public void setTopicId (String topicId) {
		this.topicId = topicId;
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
    public QueryTopicRecordsRequest addTopicId (String topicId) {
    	this.topicId = topicId;
    	return this;
    }
    public QueryTopicRecordsRequest addStart (Integer start) {
    	this.start = start;
    	return this;
    }
    public QueryTopicRecordsRequest addLimit (Integer limite) {
    	this.limit = limite;
    	return this;
    }
    public QueryTopicRecordsRequest addRangeStart (Long rangeStart) {
    	this.rangeStart = rangeStart;
    	return this;
    }
    public QueryTopicRecordsRequest addRangeEnd (Long rangeEnd) {
    	this.rangeEnd = rangeEnd;
    	return this;
    }
    public QueryTopicRecordsRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public QueryTopicRecordsRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
	
}
