package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class QueryTagsRequest extends PushRequest{

	@HttpParamKeyName(name=BaiduPushConstants.TAG_NAME, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=128)
	private String tagName = null;
	
	@HttpParamKeyName(name=BaiduPushConstants.START, param=R.OPTIONAL)
	private Integer start = new Integer(0);
	
	@HttpParamKeyName(name=BaiduPushConstants.LIMIT, param=R.OPTIONAL)
	@RangeRestrict(minLength=1, maxLength=100)
	private Integer limit = new Integer(100);
	
	// get
	public String getTagName () {
		return tagName;
	}
	public Integer getStart () {
		return start;
	}
	public Integer getLimit () {
		return limit;
	}
	// set
	public void setTagName (String tagName) {
		this.tagName = tagName;
	}
	public void setStart (Integer start) {
		this.start = start;
	}
	public void setLimit (Integer limit) {
		this.limit = limit;
	}
	// add
	public QueryTagsRequest addTagName (String tagName) {
		this.tagName = tagName;
		return this;
	}
	public QueryTagsRequest addStart (Integer start) {
		this.start = start;
		return this;
	}
	public QueryTagsRequest addLimit (Integer limit) {
		this.limit = limit;
		return this;
	}
    public QueryTagsRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public QueryTagsRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
}
