package com.baidu.yun.push.client;

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

public interface BaiduPush {

	public PushMsgToSingleDeviceResponse pushMsgToSingleDevice (
			PushMsgToSingleDeviceRequest request) throws PushClientException,
		    PushServerException;
	
	public PushMsgToAllResponse pushMsgToAll (
			PushMsgToAllRequest request) throws PushClientException,
		    PushServerException;
	
	public PushMsgToTagResponse pushMsgToTag (
			PushMsgToTagRequest request) throws PushClientException, 
	PushServerException;
	
	public PushMsgToSmartTagResponse pushMsgToSmartTag (
			PushMsgToSmartTagRequest request) throws PushClientException, 
	PushServerException;
	
	public PushBatchUniMsgResponse pushBatchUniMsg (
			PushBatchUniMsgRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryMsgStatusResponse queryMsgStatus (
			QueryMsgStatusRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTimerRecordsResponse queryTimerRecords (
			QueryTimerRecordsRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTopicRecordsResponse queryTopicRecords (
			QueryTopicRecordsRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTimerListResponse queryTimerList (
			QueryTimerListRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTopicListResponse queryTopicList (
			QueryTopicListRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryTagsResponse queryTags (
			QueryTagsRequest request) throws PushClientException, 
	PushServerException;
	
	public CreateTagResponse createTag (
			CreateTagRequest request) throws PushClientException, 
	PushServerException;
	
	public DeleteTagResponse deleteTag (
			DeleteTagRequest request) throws PushClientException, 
	PushServerException;
	
	public AddDevicesToTagResponse addDevicesToTag (
			AddDevicesToTagRequest request) throws PushClientException, 
	PushServerException;
	
	public DeleteDevicesFromTagResponse deleteDevicesFromTag (
			DeleteDevicesFromTagRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryDeviceNumInTagResponse queryDeviceNumInTag (
			QueryDeviceNumInTagRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryStatisticMsgResponse queryStatisticMsg (
			QueryStatisticMsgRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryStatisticTopicResponse queryStatisticTopic (
			QueryStatisticTopicRequest request) throws PushClientException, 
	PushServerException;
	
	public QueryStatisticDeviceResponse queryStatisticDevice (
			QueryStatisticDeviceRequest request) throws 
	PushClientException, PushServerException;
	
}
