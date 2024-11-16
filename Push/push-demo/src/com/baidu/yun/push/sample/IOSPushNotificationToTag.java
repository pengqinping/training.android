package com.baidu.yun.push.sample;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToTagRequest;
import com.baidu.yun.push.model.PushMsgToTagResponse;

import net.sf.json.JSONObject;

public class IOSPushNotificationToTag {

	public static void main(String[] args) throws PushClientException,
			PushServerException {
		// 1. get apiKey and secretKey from developer console
		String apiKey = "xxxxxxxxxxxxxxxxxxxxx";
		String secretKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
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
			// make IOS Notification
			JSONObject notification = new JSONObject();
			JSONObject jsonAPS = new JSONObject();
			jsonAPS.put("alert", "Hello Baidu Push");
			jsonAPS.put("sound", "ttt"); // 设置通知铃声样式，例如"ttt"，用户自定义。
			notification.put("aps", jsonAPS);
			notification.put("key1", "value1");
			notification.put("key2", "value2");
			// pushTagTpye = 1 for common tag pushing
			PushMsgToTagRequest request = new PushMsgToTagRequest()
					.addTagName("xxxxx") //设置tag组
					.addMsgExpires(new Integer(3600))
					.addMessageType(1) // 1：通知,0:透传消息.默认为0  注：IOS只有通知.
					//.addSendTime(System.currentTimeMillis() / 1000 + 86400) //设置定时推送时间
					.addMessage(notification.toString())
					.addDeployStatus(2)// IOS,DeployStatus => 1: Developer, 2: Production.
					.addDeviceType(4); // deviceType => 3:android, 4:ios
			// 5. http request
			PushMsgToTagResponse response = pushClient.pushMsgToTag(request);
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
