package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class DeleteTagRequest extends PushRequest {

	@HttpParamKeyName(name=BaiduPushConstants.TAG_NAME, param=R.REQUIRE)
	@RangeRestrict(minLength=1, maxLength=128)
	private String tagName;

	// get
	public String getTagName() {
		return tagName;
	}
    // set
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
    // add
    public DeleteTagRequest addTagName (String tagName) {
    	this.tagName = tagName;
    	return this;
    }
    public DeleteTagRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public DeleteTagRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
}
