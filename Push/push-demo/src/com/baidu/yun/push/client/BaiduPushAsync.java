package com.baidu.yun.push.client;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;

import java.util.concurrent.Future;

public interface BaiduPushAsync {

	Future<PushMsgToSingleDeviceResponse> pushMsgToSingleDeviceAsync(
			PushMsgToSingleDeviceRequest request)
			throws PushClientException, PushServerException;

}
