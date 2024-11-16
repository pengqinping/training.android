package com.baidu.yun.push.model;

import com.baidu.yun.core.annotation.JSonPath;

import java.util.LinkedList;
import java.util.List;

public class DeleteDevicesFromTagResponse extends PushResponse{

	@JSonPath(path="response_params\\result")
	private List<DeviceInfo> devicesInfoAfterDel = new LinkedList<DeviceInfo> ();
	
	// get
	public List<DeviceInfo> getDevicesInfoAfterDel () {
		return devicesInfoAfterDel;
	}
}
