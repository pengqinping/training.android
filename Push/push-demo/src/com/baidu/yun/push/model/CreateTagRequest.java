package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class CreateTagRequest extends PushRequest{

	@HttpParamKeyName(name=BaiduPushConstants.TAG_NAME, param=R.REQUIRE)
	@RangeRestrict(minLength=1, maxLength=128)
	private String tagName = null;
	
	// get
	public String getTagName () {
		return tagName;
	}
	// set
	public void setTagName (String tagName) {
		this.tagName = tagName;
	}
	// add
	public CreateTagRequest addTagName (String tagName) {
		this.tagName = tagName;
		return this;
	}
    public CreateTagRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public CreateTagRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
}
