package com.baidu.yun.push.sample;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;

import net.sf.json.JSONObject;

public class IOSPushNotificationToAll {

	public static void main(String[] args)
			throws PushClientException,PushServerException {
		// 1. get apiKey and secretKey from developer console
		String apiKey = "xxxxxxxxxxxxxxxxxxxx";
		String secretKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			// 创建IOS通知
			JSONObject notification = new JSONObject();
			JSONObject jsonAPS = new JSONObject();
			jsonAPS.put("alert", "Hello Baidu Push");
			jsonAPS.put("sound", "ttt"); // 设置通知铃声样式,例如"ttt"，用户自定义。
			notification.put("aps", jsonAPS);
			notification.put("key1", "value1");
			notification.put("key2", "value2");
			
			PushMsgToAllRequest request = new PushMsgToAllRequest()
					.addMsgExpires(new Integer(3600)).addMessageType(1)
					.addMessage(notification.toString())
					.addSendTime(System.currentTimeMillis() / 1000 + 120) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
					.addDepolyStatus(2).addDeviceType(4);
			// 5. http request
			PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
	}
}
