package com.baidu.yun.push.sample;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSmartTagRequest;
import com.baidu.yun.push.model.PushMsgToSmartTagResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AndroidPushMsgToSmartTag {
	public static void main(String[] args)
			throws PushClientException,PushServerException {
		// 1. get apiKey and secretKey from developer console
		String apiKey = "xxxxxxxxxxxxxxxxxxxxxxxxxx";
		String secretKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
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

		try { //开放tag组合运算功能
			// example.1 {"OR":{"tag":["xxxx","xxxx"]}}
			JSONObject selector = new JSONObject();
			JSONObject tmpJson = new JSONObject();
			JSONArray tagArray = new JSONArray();
			tagArray.add(0, "pushdemo");
			tagArray.add(1, "pushdemo1");
			tmpJson.put("tag", tagArray);
			selector.put("OR", tmpJson); // "AND":交,"OR":并,"DIFF":差

			// example.2 {"OR":[{"tag":"xxxx"},{"tag":"xxxx"}]}
			// JSONObject firstTag = new JSONObject();
			// firstTag.put("tag", "xxxx");
			// JSONObject secondTag = new JSONObject();
			// secondTag.put("tag", "xxxx");
			// JSONArray tagArray = new JSONArray();
			// tagArray.add(0, firstTag);
			// tagArray.add(1, secondTag);
			// selector.put("OR", tagArray);

			PushMsgToSmartTagRequest request = new PushMsgToSmartTagRequest()
					.addSelector(selector.toString())
					.addMsgExpires(new Integer(3600))
					.addMessageType(0)
					.addMessage("Hello Baidu push")
					.addDeviceType(3);
			// 5. http request
			PushMsgToSmartTagResponse response = pushClient
					.pushMsgToSmartTag(request);
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
