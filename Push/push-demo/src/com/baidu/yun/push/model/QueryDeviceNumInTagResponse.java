package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.JSonPath;

public class QueryDeviceNumInTagResponse extends PushResponse{

	@JSonPath(path="response_params\\device_num")
	private int deviceNum;
	
	// get
	public int getDeviceNum () {
		return deviceNum;
	}
}
