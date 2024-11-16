package com.baidu.yun.push.sample;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.KeyValueForDevice;
import com.baidu.yun.push.model.QueryStatisticDeviceRequest;
import com.baidu.yun.push.model.QueryStatisticDeviceResponse;

import java.util.List;

public class QueryStatisticDevice {
	public static void main(String[] args)
			throws PushClientException,PushServerException{
    	// 1. get apiKey and secretKey from developer console
        String apiKey = "xxxxxxxxxxxxxxxxxxxx";
        String secretKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
        
        // 2. build a BaidupushClient object to access released interfaces
        BaiduPushClient pushClient = new BaiduPushClient(pair,
        		BaiduPushConstants.CHANNEL_REST_URL);

        // 3. register a YunLogHandler to get detail interacting information
        // in this request.
        pushClient.setChannelLogHandler (new YunLogHandler () {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
        });

        try {
            // 4. specify request arguments
        	QueryStatisticDeviceRequest request = new QueryStatisticDeviceRequest().
            	addDeviceType(3);
            // 5. http request
        	QueryStatisticDeviceResponse response = pushClient.
        			queryStatisticDevice(request);
        	// Http请求结果解析打印
        	if (null != response) {
            	StringBuilder strBuilder = new StringBuilder();
            	strBuilder.append("totalNum: " + response.getTotalNum()
            			+ "\n");
                List<KeyValueForDevice> deviceStats = response.getResult();
                strBuilder.append("result:{\n");
                for (int i = 0; i < deviceStats.size(); i++) {
					KeyValueForDevice keyValue = deviceStats.get(i);
					if (i != 0) {
						strBuilder.append(",");
					}
					strBuilder.append("" + keyValue.getKey() + ":{"
							+ "newDeviceNum=" + keyValue.getValue().getNewDevNum()
							+ ",delDeviceNum=" + keyValue.getValue().getDelDevNum()
							+ ",onlineDeviceNum=" + keyValue.getValue().getOnlineDevNum()
							+ ",addUpDeviceNum=" + keyValue.getValue().getAddUpDevNum()
							+ ",totalDeviceNum=" + keyValue.getValue().getTotalDevNum()
							+ "}");
                }
            	strBuilder.append("}");
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
