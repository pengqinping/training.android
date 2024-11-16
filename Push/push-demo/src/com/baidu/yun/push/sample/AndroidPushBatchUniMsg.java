package com.baidu.yun.push.sample;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushBatchUniMsgRequest;
import com.baidu.yun.push.model.PushBatchUniMsgResponse;

import net.sf.json.JSONObject;

public class AndroidPushBatchUniMsg {
	public static void main(String[] args)
			throws PushClientException,PushServerException {
		// 1. get apiKey and secretKey from developer console
		String apiKey = "xxxxxxxxxxxxxxxxxxxx";
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
			//创建Android通知
			JSONObject notification = new JSONObject();
			notification.put("title", "TEST");
			notification.put("description","Hello Baidu Push");
			notification.put("notification_builder_id", 0);
			notification.put("notification_basic_style", 4);
			notification.put("open_type", 1);
			notification.put("url", "http://push.baidu.com");
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("key", "value"); //自定义内容，key-value
			notification.put("custom_content", jsonCustormCont);
			
			String[] channelIds = { "xxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxx" };
			PushBatchUniMsgRequest request = new PushBatchUniMsgRequest()
					.addChannelIds(channelIds)
					.addMsgExpires(new Integer(3600))
					.addMessageType(1)
					.addMessage(notification.toString())
					.addDeviceType(3)
					.addTopicId("BaiduPush");// 设置类别主题
			// 5. http request
			PushBatchUniMsgResponse response = pushClient
					.pushBatchUniMsg(request);
			// Http请求结果解析打印
			System.out.println(String.format("msgId: %s, sendTime: %d",
					response.getMsgId(), response.getSendTime()));
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
