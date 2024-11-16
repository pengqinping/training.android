package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.JSonPath;

import java.util.LinkedList;
import java.util.List;

public class QueryMsgStatusResponse extends PushResponse {
	
	@JSonPath(path="response_params\\total_num")
	private int totalNum;
	
	@JSonPath(path="response_params\\result")
	private List<MsgSendInfo> msgSendInfos = new LinkedList<MsgSendInfo> ();
	
	// get
	public int getTotalNum () {
		return totalNum;
	}
	public List<MsgSendInfo> getMsgSendInfos () {
		return msgSendInfos;
	}
}
