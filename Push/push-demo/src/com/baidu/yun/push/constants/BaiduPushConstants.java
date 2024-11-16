package com.baidu.yun.push.constants;

public class BaiduPushConstants {
	
    // host name for test 
	//public static final String CHANNEL_REST_URL_TEST = "logiclayernew.baidu.com:8080";

	// ---------------- channel_id ----------------------------------
	public static final String CHANNEL_ID = "channel_id";
    // ---------------- batch channels for 'pushBatchUnMsg' 
	// and 'addDevicesToTag' interfaces -----------------------------
	public static final String CHANNEL_IDS = "channel_ids";

	public static final String DEVICE_TYPE = "device_type";
    // ---------------- only for IOS --------------------------------
	public static final String DEPLOY_STATUS = "deploy_status";
	//----------------- tag info ------------------------------------
	public static final String TAG_NAME = "tag";
	public static final String TAG_INFO = "info";
	public static final String HAS_BROADCAST_TAG = "has_broadcast_tag";
	// ---------------- tag message pushing type --------------------
	public static final String PUSH_TAG_TYPE = "type";
    // ---------------- tag pushing argument ------------------------
	public static final String SELECTOR = "selector";
    //----------------- timer task ----------------------------------
	public static final String TIMER_ID = "timer_id";
	public static final String TIMER_RECORDS = "result";
    //----------------- topic for get the number of reached msg -----
	public static final String TOPIC_ID = "topic_id";
	public static final String STATISTIC_TYPE = "statistic_type";
	public static final String TOPIC_RECORDS = "result";
    //------ search range -------------------------------------------
    //----- for index in [START, START+LIMIT] -----------------------
	public static final String START = "start";
	public static final String LIMIT = "limit";
    //----- for time in [RANGE_START, RANGE_END] --------------------
	public static final String RANGE_START = "range_start";
	public static final String RANGE_END = "range_end";
    //-----------------  msg info -----------------------------------
	public static final String MESSAGE = "msg";
	
    public static final String MSG_ID = "msg_id";
    
	public static final String MSG_IDS = "msg_id";

	public static final String MESSAGE_TYPE = "msg_type";
	
	public static final String MSG_KEY = "msg_key";
	
	public static final String SEND_TIME = "send_time";
	
	public static final String MSG_EXPIRES = "msg_expires";
	
	public static final String MESSAGES = "messages";
	
	public static final String TOTAL_NUM = "total_num";
	// 0 -- 组播，1 -- 广播，2 -- 批量单播，3 -- 组合运算，4 -- 精准推送，5 -- LBS推送
	// 6 -- 强订阅组播推送， 7 -- 单播
	public static final String QUERY_TYPE = "query_type";
	// ---- 消息发送状态  0：已发送   1：待发送   2：正在发送   3：失败 ----------------
	public static final String MSG_STATUS = "status";
	// ---- 消息推送的成功到达数 ------------------------------------------
	public static final String SUCCESS_COUNT = "success";
	//------------------- msg_type=0 (MSG) --------------------------
	public static final String DESCRIPTION = "description";
	//------------------- REST API common arguments -----------------
	public static final String RELEASE_CERT = "release_cert";
	
	public static final String DEV_CERT = "dev_cert";
	
	public static final String TIMESTAMP = "timestamp";
	
	public static final String EXPIRES = "expires";
	
	public static final String VERSION = "v";
	//------------------ http method and class -----------------------
	public static final String HTTPMETHOD = "POST";
	
	public static final String HTTPCLASSPUSH = "push"; // http class type
	
	public static final String HTTPCLASSREPORT = "report";
	
	public static final String HTTPCLASSAPP = "app";
	
	public static final String HTTPCLASSTAG = "tag";
	
	public static final String HTTPCLASSTIMER = "timer"; 
	
	public static final String HTTPCLASSTOPIC = "topic"; 
	//------------------ host name -----------------------------------
    //域名：api.push.baidu.com、api.tuisong.baidu.com、channel.api.duapp.com(老域名，建议使用前两个域名)
	public static final String CHANNEL_REST_URL = "api.tuisong.baidu.com";
	//------------------ http request error, operation type ----------
	public static final boolean ERROROPTTYPE = false;
	                                          // true -- throw exception, developer handle it according to 'errorCode' and 'errorMsg';
											  // false -- no exception will be thrown, SDK will handle it by itself,
											  // printing 'errorCode' and 'errorMsg' for developer.
}
