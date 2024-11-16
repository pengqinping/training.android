package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.JSonPath;

public class DeviceStatUnit {

	@JSonPath(path="new_term")
	private int newTerm;
	
	@JSonPath(path="del_term")
	private int delTerm;
	
	@JSonPath(path="online_term")
	private int onlineTerm;
	
	@JSonPath(path="addup_term")
	private int addUpTerm;
	
	@JSonPath(path="total_term")
	private int totalTerm;
	
	public int getNewDevNum () {
		return newTerm;
	}
	public int getDelDevNum () {
		return delTerm;
	}
	public int getOnlineDevNum () {
		return onlineTerm;
	}
	public int getAddUpDevNum () {
		return addUpTerm;
	}
	public int getTotalDevNum () {
		return totalTerm;
	}
	
}
