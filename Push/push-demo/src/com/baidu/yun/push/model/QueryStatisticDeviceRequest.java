package com.baidu.yun.push.model;

public class QueryStatisticDeviceRequest extends PushRequest{

    public QueryStatisticDeviceRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public QueryStatisticDeviceRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
}
