package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class QueryTopicListRequest extends PushRequest{

	@HttpParamKeyName(name=BaiduPushConstants.START, param=R.OPTIONAL)
	private Integer start = new Integer(0);
	
	@HttpParamKeyName(name=BaiduPushConstants.LIMIT, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=20)
	private Integer limit = new Integer(20);
	
	// get
	public Integer getStart () {
		return start;
	}
	public Integer getLimit () {
		return limit;
	}
	// set
	public void setStart (Integer start) {
		this.start = start;
	}
	public void setLimit (Integer limit) {
		this.limit = limit;
	}
    // add
    public QueryTopicListRequest addStart (Integer start) {
    	this.start = start;
    	return this;
    }
    public QueryTopicListRequest addLimit (Integer limite) {
    	this.limit = limite;
    	return this;
    }
    public QueryTopicListRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public QueryTopicListRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
}
