package com.baidu.yun.push.sample;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.QueryTagsRequest;
import com.baidu.yun.push.model.QueryTagsResponse;
import com.baidu.yun.push.model.TagInfo;

import java.util.List;

public class QueryTags {
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
			QueryTagsRequest request = new QueryTagsRequest()
					.addTagName("xxxxx").addStart(0).addLimit(10)
					.addDeviceType(3);
			// 5. http request
			QueryTagsResponse response = pushClient.queryTags(request);
			// Http请求结果解析打印
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("totalNum: " + response.getTotalNum() + "\n");
			if (null != response) {
				List<?> list = response.getTagsInfo();
				for (int i = 0; i < list.size(); i++) {
					Object object = list.get(i);
					if (object instanceof TagInfo) {
						TagInfo tagInfo = (TagInfo) object;
						strBuilder.append("List[" + i + "]: " + "tagId="
								+ tagInfo.getTagId() + ",tag="
								+ tagInfo.getTagName() + ",info="
								+ tagInfo.getInfo() + ",type="
								+ tagInfo.getType() + ",creatTime="
								+ tagInfo.getCreateTime() + "\n");
					}
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
