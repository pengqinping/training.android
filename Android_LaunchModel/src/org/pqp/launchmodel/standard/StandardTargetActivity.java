package org.pqp.launchmodel.standard;

import org.pqp.launchmodel.BaseActivity;
import org.pqp.launchmodel.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * 
 * @author pengqinping
 * ������������back��������һ��ҳ��,��������:(����back���д���Ĭ����finish���activity)
 * this.onPause-->other.onRestart--->other.onStart-->other.onResume-->this.onStop-->this.onDestroy
 */
public class StandardTargetActivity extends BaseActivity {

	private static final String TAG = StandardTargetActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG," onCreate ");
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onDestroy() {
		
		Log.i(TAG," onDestroy ");
		
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		
		Log.i(TAG," onPause ");
		
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG," onRestart ");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG," onResume ");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.i(TAG," onStart ");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.i(TAG," onStop ");
		super.onStop();
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		Log.i(TAG," onNewIntent ");
		super.onNewIntent(intent);
	}
	
}
