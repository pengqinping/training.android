/*
 * ��  ��  ��:  DemoService.java
 * ��������:  2013-8-17/����9:02:04
 * ��       Ȩ:  pengqinping@mail.com, All rights reserved
 * ��       ��:  pengqinping
 * �� ��  ��:  ��Ҫ�����貵��ǿգ���Ҫ����ƽ�˵Ĵ��
 */
package org.pqp.android_service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
/**
 * 
 * @author <font color='#0f767334' size='4' bold=true>org.pengqinping</font> [Never give up, adhere to in the end.]<br>
 * @time [2013-9-29:����9:31:11.]<br>
 * @description Service��ʹ��<br>
 */
public class DemoService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		Log.i("---","onBind.");
		return null;
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}
	
	
	
}
