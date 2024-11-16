package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.JSonPath;

public class TopicResultInfo {

	@JSonPath(path="topic_id")
	private String topicId = null;
	
	@JSonPath(path="ctime")
	private long firstPushTime;
	
	@JSonPath(path="mtime")
	private long lastPushTime;
	
	@JSonPath(path="push_cnt")
	private int totalPushDevsNum;
	
	@JSonPath(path="ack_cnt")
	private int totalAckDevsNum;
	
	public String getTopicId () {
		return topicId;
	}

	public long getFirstPushTime () {
		return firstPushTime;
	}
	
	public long getLastPushTime() {
		return lastPushTime;
	}
	
	public long getTotalPushDevsNum() {
		return totalPushDevsNum;
	}
	
	public long getTotalAckDevsNum() {
		return totalAckDevsNum;
	}
}
