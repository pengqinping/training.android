package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.JSonPath;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class PushMsgToTagResponse extends PushResponse {

	@JSonPath(path="response_params\\msg_id")
    @HttpParamKeyName(name=BaiduPushConstants.MSG_ID, param=R.REQUIRE)
    protected String msgId = null;
    
    @JSonPath(path="response_params\\timer_id")
    @HttpParamKeyName(name=BaiduPushConstants.TIMER_ID, param=R.OPTIONAL)
    protected String timerId = null;
    
    @JSonPath(path="response_params\\send_time")
    @HttpParamKeyName(name=BaiduPushConstants.SEND_TIME, param=R.REQUIRE)
    protected long sendTime;
    
    public String getMsgId () {
    	return msgId;
    }
    public String getTimerId () {
    	return timerId;
    }
    public long getSendTime () {
    	return sendTime;
    }
}
