/*
 * ��  ��  ��:  ResultActivity.java
 * ��������:  2013-8-3/����9:14:22
 * ��       Ȩ:  pengqinping@mail.com, All rights reserved
 * ��       ��:  pengqinping
 * �� ��  ��:  ��Ҫ�����貵��ǿգ���Ҫ����ƽ�˵Ĵ��
 */
package org.pqp.notification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 
 * @author org.pengqinping / Never give up, adhere to in the end.
 * email: pengqinping@gmail.com
 */
public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("ResultActivity");
		setContentView(tv);
	}
	
}
