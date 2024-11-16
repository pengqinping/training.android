package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.JSonPath;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.push.constants.BaiduPushConstants;

import java.util.LinkedList;
import java.util.List;

public class QueryTopicRecordsResponse extends PushResponse{

	@JSonPath(path="response_params\\topic_id")
	@HttpParamKeyName(name=BaiduPushConstants.TOPIC_ID, param=R.REQUIRE)
	@RangeRestrict(minLength=1, maxLength=128)
	private String topicId = null;
	
	@JSonPath(path="response_params\\result")
	@HttpParamKeyName(name=BaiduPushConstants.TOPIC_RECORDS, param=R.REQUIRE)
	private List<Record> topicRecords = new LinkedList<Record>();
	
	// get
	public String getTopicId () {
		return topicId;
	}
	public List<Record> getTopicRecords () {
		return topicRecords;
	}
}

