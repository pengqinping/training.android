package com.baidu.yun.push.client;

import com.baidu.yun.core.callback.YunLogHttpCallBack;
import com.baidu.yun.core.exception.YunHttpClientException;
import com.baidu.yun.core.httpclient.YunHttpClient;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.core.model.HttpRestResponse;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.auth.signature.PushSignatureDigest;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.AddDevicesToTagRequest;
import com.baidu.yun.push.model.AddDevicesToTagResponse;
import com.baidu.yun.push.model.CreateTagRequest;
import com.baidu.yun.push.model.CreateTagResponse;
import com.baidu.yun.push.model.DeleteDevicesFromTagRequest;
import com.baidu.yun.push.model.DeleteDevicesFromTagResponse;
import com.baidu.yun.push.model.DeleteTagRequest;
import com.baidu.yun.push.model.DeleteTagResponse;
import com.baidu.yun.push.model.PushBatchUniMsgRequest;
import com.baidu.yun.push.model.PushBatchUniMsgResponse;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.baidu.yun.push.model.PushMsgToSmartTagRequest;
import com.baidu.yun.push.model.PushMsgToSmartTagResponse;
import com.baidu.yun.push.model.PushMsgToTagRequest;
import com.baidu.yun.push.model.PushMsgToTagResponse;
import com.baidu.yun.push.model.PushRequest;
import com.baidu.yun.push.model.QueryDeviceNumInTagRequest;
import com.baidu.yun.push.model.QueryDeviceNumInTagResponse;
import com.baidu.yun.push.model.QueryMsgStatusRequest;
import com.baidu.yun.push.model.QueryMsgStatusResponse;
import com.baidu.yun.push.model.QueryStatisticDeviceRequest;
import com.baidu.yun.push.model.QueryStatisticDeviceResponse;
import com.baidu.yun.push.model.QueryStatisticMsgRequest;
import com.baidu.yun.push.model.QueryStatisticMsgResponse;
import com.baidu.yun.push.model.QueryStatisticTopicRequest;
import com.baidu.yun.push.model.QueryStatisticTopicResponse;
import com.baidu.yun.push.model.QueryTagsRequest;
import com.baidu.yun.push.model.QueryTagsResponse;
import com.baidu.yun.push.model.QueryTimerListRequest;
import com.baidu.yun.push.model.QueryTimerListResponse;
import com.baidu.yun.push.model.QueryTimerRecordsRequest;
import com.baidu.yun.push.model.QueryTimerRecordsResponse;
import com.baidu.yun.push.model.QueryTopicListRequest;
import com.baidu.yun.push.model.QueryTopicListResponse;
import com.baidu.yun.push.model.QueryTopicRecordsRequest;
import com.baidu.yun.push.model.QueryTopicRecordsResponse;
import com.baidu.yun.push.transform.PushRestRequestChecker;
import com.baidu.yun.push.transform.PushRestRequestMapper;
import com.baidu.yun.push.transform.PushRestResponseJsonUnmapper;

import java.util.Map;

public class BaiduPushClient implements BaiduPush {

	private String apiKey = null;

	private String secretKey = null;

	private String host = null;

	private YunLogHttpCallBack logHttpCallback = new YunLogHttpCallBack();

	private PushRestResponseJsonUnmapper responseJsonUnmapper = new PushRestResponseJsonUnmapper();

	public BaiduPushClient(PushKeyPair pair) {
		this(pair, BaiduPushConstants.CHANNEL_REST_URL);
	}

	public BaiduPushClient(PushKeyPair pair, String host) {
		this.apiKey = pair.getApiKey();
		this.secretKey = pair.getSecretKey();
		this.host = host;
	}

    @Override
	public PushMsgToSingleDeviceResponse pushMsgToSingleDevice (
			PushMsgToSingleDeviceRequest request) 
	        throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH, 
				"single_device", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(),
				resp.getJsonResponse(), new PushMsgToSingleDeviceResponse());
	}

    @Override
	public PushMsgToAllResponse pushMsgToAll (
			PushMsgToAllRequest request) 
	        throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH, 
				"all", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(),
				resp.getJsonResponse(), new PushMsgToAllResponse());
	}
    
    @Override
    public PushMsgToTagResponse pushMsgToTag (PushMsgToTagRequest request) 
    		throws PushClientException, PushServerException {
    	HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH,
    			"tags", request);
    	return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(),
    			resp.getJsonResponse(), new PushMsgToTagResponse());
    }
    
    @Override
    public PushMsgToSmartTagResponse pushMsgToSmartTag (PushMsgToSmartTagRequest request) 
    		throws PushClientException, PushServerException {
    	HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH,
    			"tags", request);
    	return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(),
    			resp.getJsonResponse(), new PushMsgToSmartTagResponse());
    }
    
	@Override
	public PushBatchUniMsgResponse pushBatchUniMsg (PushBatchUniMsgRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSPUSH,
				"batch_device", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new PushBatchUniMsgResponse());
	}
	
	@Override
	public QueryMsgStatusResponse queryMsgStatus (QueryMsgStatusRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"query_msg_status", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryMsgStatusResponse());
	}
	
	@Override
	public QueryTimerRecordsResponse queryTimerRecords (QueryTimerRecordsRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"query_timer_records", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTimerRecordsResponse());
	}
	
	@Override
	public QueryTopicRecordsResponse queryTopicRecords (QueryTopicRecordsRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"query_topic_records", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTopicRecordsResponse());
	}
	
	@Override
	public QueryTimerListResponse queryTimerList (QueryTimerListRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTIMER,
				"query_list", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTimerListResponse());
	}
	
	@Override
	public QueryTopicListResponse queryTopicList (QueryTopicListRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTOPIC,
				"query_list", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTopicListResponse());
	}
	
	@Override
	public QueryTagsResponse queryTags (QueryTagsRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSAPP,
				"query_tags", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryTagsResponse());
	}
	
	@Override
	public CreateTagResponse createTag (CreateTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSAPP,
				"create_tag", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new CreateTagResponse());
	}
	
	@Override
	public DeleteTagResponse deleteTag (DeleteTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSAPP,
				"del_tag", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new DeleteTagResponse());
	}
	
	@Override
	public AddDevicesToTagResponse addDevicesToTag (AddDevicesToTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTAG,
				"add_devices", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new AddDevicesToTagResponse());
	}
	
	@Override
	public DeleteDevicesFromTagResponse deleteDevicesFromTag (DeleteDevicesFromTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTAG,
				"del_devices", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new DeleteDevicesFromTagResponse());
	}
	
	@Override
	public QueryDeviceNumInTagResponse queryDeviceNumInTag (QueryDeviceNumInTagRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSTAG,
				"device_num", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryDeviceNumInTagResponse());
	}
	

	@Override
	public QueryStatisticMsgResponse queryStatisticMsg (
			QueryStatisticMsgRequest request) throws PushClientException,
			PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"statistic_msg", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryStatisticMsgResponse());
	}

	@Override
	public QueryStatisticTopicResponse queryStatisticTopic (
			QueryStatisticTopicRequest request) throws PushClientException,
			PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"statistic_topic", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryStatisticTopicResponse());
	}

	@Override
	public QueryStatisticDeviceResponse queryStatisticDevice (
			QueryStatisticDeviceRequest request)
			throws PushClientException, PushServerException {
		HttpRestResponse resp = process(BaiduPushConstants.HTTPCLASSREPORT,
				"statistic_device", request);
		return responseJsonUnmapper.unmarshall(resp.getHttpStatusCode(), 
				resp.getJsonResponse(), new QueryStatisticDeviceResponse());
	}

	public void setChannelLogHandler(YunLogHandler logHandler) {
		logHttpCallback.setHandler(logHandler);
	}

	// -----------------------------------------------------------

	private HttpRestResponse process(String classType, String method, PushRequest request)
			throws PushClientException, PushServerException {

		PushRestRequestChecker checker = new PushRestRequestChecker();
		checker.validate(request);

		PushRestRequestMapper mapper = new PushRestRequestMapper();
		Map<String, String> params = mapper.marshall(request);
		params.put("apikey", apiKey);

		String surl = obtainIntegrityUrl(classType, method);

		PushSignatureDigest digest = new PushSignatureDigest();
		String sign = digest.digest(BaiduPushConstants.HTTPMETHOD, surl, secretKey, params);
		params.put("sign", sign);
		
		YunHttpClient client = new YunHttpClient();
		client.addHttpCallback(logHttpCallback);
		
		try {
			return client.doExecutePostRequestResponse(surl, params);
		} catch(YunHttpClientException e) {
			throw new PushClientException(e.getMessage());
		}
	}

	private String obtainIntegrityUrl(String classType, String method) {
		String resurl = host;
		if (host.startsWith("http://") || host.startsWith("https://")) {
		} else {
			resurl = "http://" + host;
		}
		if (resurl.endsWith("/")) {
			resurl = resurl + "rest/3.0/";
		} else {
			resurl = resurl + "/rest/3.0/";
		}
		resurl = resurl + classType + "/" + method;
		return resurl;
	}

}
