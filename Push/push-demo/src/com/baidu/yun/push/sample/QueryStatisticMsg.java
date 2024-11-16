package com.baidu.yun.push.sample;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.KeyValueForMsg;
import com.baidu.yun.push.model.MsgStatInfo;
import com.baidu.yun.push.model.QueryStatisticMsgRequest;
import com.baidu.yun.push.model.QueryStatisticMsgResponse;

import java.util.List;

public class QueryStatisticMsg {
	public static void main(String[] args) throws PushClientException,
			PushServerException {
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
			QueryStatisticMsgRequest request = new QueryStatisticMsgRequest()
					.addQueryType(0).addDeviceType(3);
			// 5. http request
			QueryStatisticMsgResponse response = pushClient
					.queryStatisticMsg(request);
			// Http请求结果解析打印
			if (null != response) {
				StringBuilder strBuilder = new StringBuilder();
				List<MsgStatInfo> msgStats = response.getMsgStats();
				for (int i = 0; i < msgStats.size(); i++) {
					MsgStatInfo msgStatInfo = msgStats.get(i);
					strBuilder.append("totalNum:" + msgStatInfo.getTotalNum()
							+ "\n" + "rangetype:" + msgStatInfo.getRangeType()
							+ "\n" + "result:{");
					List<KeyValueForMsg> result = msgStatInfo.getResult();
					for (int j = 0; j < result.size(); j++) {
						KeyValueForMsg keyValue = result.get(j);
						if (j != 0) {
							strBuilder.append(",");
						}
						strBuilder.append("" + keyValue.getKey() + ":{ "
								+ "pushNum=" + keyValue.getValue().getPushNum()
								+ ",ackNum=" + keyValue.getValue().getAckNum()
								+ ",delNum=" + keyValue.getValue().getDelNum()
								+ ",clickNum=" + keyValue.getValue().getClickNum() + "}");
					}
					strBuilder.append("}");
				}
				System.out.println(strBuilder.toString());
			}
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
