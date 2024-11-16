/*
 * ��  ��  ��:  MainActivity.java
 * ��������:  2013-8-1/����9:14:22
 * ��       Ȩ:  pengqinping@mail.com, All rights reserved
 * ��       ��:  pengqinping
 * �� ��  ��:  ��Ҫ�����貵��ǿգ���Ҫ����ƽ�˵Ĵ��
 */
package org.pqp.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.TaskStackBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * 
 * @author <font color='#0f767334' size='4' bold=true>org.pengqinping</font> [Never give up, adhere to in the end.]<br>
 * @time [2013-9-29:����9:29:31.]<br>
 * @description android notification (֪ͨ)<br>
 */
public class MainActivity extends Activity {

	private static final int NOTIFIFIXID = 1;

	private static final String ACTION_PALY_MUSIC = "org.pqp.notification.playMusic";

	private static final String ACTION_NEXT_MUSIC = "org.pqp.notification.playNext";

	private Button btnShowNotification;

	private Button btnShowNotifactionWithId;

	private Button btnShowNotifactionRemoteView;

	private Button btnNotificationNewBig;

	private Button btnNotificationNew;

	private Button btnNotificationUpdateMsg;

	private Button btnNotificationActivity;

	private int notifiId = NOTIFIFIXID + 1;

	private int numId = 0;

	private RemoteClickRecevice remoteClickRecevice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnShowNotification = (Button) findViewById(R.id.btnShowNotifaction);
		btnShowNotifactionWithId = (Button) findViewById(R.id.btnShowNotifactionWithId);
		btnShowNotifactionRemoteView = (Button) findViewById(R.id.btnShowNotifactionRemoteView);
		btnNotificationNew = (Button) findViewById(R.id.btnNotificationNew);
		btnNotificationNewBig = (Button) findViewById(R.id.btnNotificationNewBig);
		btnNotificationUpdateMsg = (Button) findViewById(R.id.btnNotificationUpdateMsg);
		btnNotificationActivity = (Button) findViewById(R.id.btnNotificationActivity);

		btnShowNotification.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNotifi(MainActivity.this);
			}
		});

		btnShowNotifactionWithId.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNotifi(MainActivity.this, notifiId++);
			}
		});

		btnShowNotifactionRemoteView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNotifiMyself(MainActivity.this);
			}
		});

		btnNotificationNew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNotifiNews(MainActivity.this);
			}
		});

		btnNotificationNewBig.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNotifiBigViewStyle(MainActivity.this);
			}
		});

		btnNotificationUpdateMsg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNotifiRule(MainActivity.this);
			}
		});

		btnNotificationActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNotifiGood(MainActivity.this);
			}
		});

		//ʵ�����㲥
		remoteClickRecevice = new RemoteClickRecevice();
		IntentFilter intentFileter = new IntentFilter();
		intentFileter.addAction(ACTION_PALY_MUSIC);
		intentFileter.addAction(ACTION_NEXT_MUSIC);
		registerReceiver(remoteClickRecevice, intentFileter);
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(remoteClickRecevice);
		super.onDestroy();
	}

	/**
	 * 
	 * @param context ����context�����������Service,BroadcaseRecevice,Activity.
	 */
	private void showNotifi(Context context, int id) {

		//��ȡNotificationManager����������֪ͨ��Ϣ�ķ�����ȡ��
		NotificationManager notifiManger = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		//����֪ͨ����
		Notification notification = new Notification();

		//ͷ�ϵ�ͼ��
		notification.icon = R.drawable.ic_launcher;

		//�����ʽҪ���Ȩ�ޣ�android.permission.VIBRATE�����������Զ����ʽ�����û��ʹ��ϵͳ��Ĭ��֪ͨ������
		notification.defaults = Notification.DEFAULT_ALL;

		//�Զ�������
		//Ҫʹ��Ӧ�ó���ָ�����������򴫵�һ��Uri���ø�sound���ԡ���������ʹ���ѱ������豸SD���ϵ���Ƶ�ļ���Ϊ��ʾ����
		//notification.sound = Uri.parse("file:///sdcard/notification/ringer.mp3");
		//��������������Ƶ�ļ����ڲ�MediaStore���ContentProvider�л�ȡ��
		//ע�⣺���defaults���԰����ˡ�DEFAULT_SOUND������ȱʡ��ʾ��������sound ������ָ����������
		//����������û���Ӧ֪ͨ��ȡ��֪ͨǰ������һֱ����ѭ�����ţ����԰� ��FLAG_INSISTENT�� ����flags�����С�
		//notification.sound = Uri.withAppendedPath(Audio.Media.INTERNAL_CONTENT_URI, "6");

		//�Զ�������
		/*notification.ledARGB = 0xff00ff00; 

		notification.ledOnMS = 500; 

		notification.ledOffMS = 3000; 

		notification.flags |= Notification.FLAG_SHOW_LIGHTS;*/

		//�Զ�����
		long[] vibrate = { 0, 100, 200, 300, 400, 500, 600, 700 };

		notification.vibrate = vibrate;

		//��flags���������Ӵ˱�־����֪ͨ����֪ͨ���ڵġ��������С���Ongoing�����С���ʾӦ�ó����������С����������ں�̨���У���ʹӦ�ó��򲻿ɼ������粥�����ֻ�����绰����
		//notification.flags |= Notification.FLAG_ONGOING_EVENT; 

		//��FLAG_NO_CLEAR����־��flags���������Ӵ˱�־����ʾ֪ͨ�����������֪ͨ����ť�������������֪ͨ��������ʱ�ر����á�
		//notification.flags |= Notification.FLAG_NO_CLEAR;

		notification.tickerText = "������Ϣ���������Ƚ���";

		//�����ת��Intent
		PendingIntent pendingItent = PendingIntent.getActivity(context, 0,
				new Intent(this, MainActivity.class), 0);

		notification.setLatestEventInfo(context, "����֪ͨ,֪ͨ��id:" + id,
				java.lang.System.nanoTime() + ":���ݹ�������ַ���������������н���",
				pendingItent);

		//id,��֪ͨ�ı�ʾ�����id,��ͬ�ͻᷢ��
		notifiManger.notify(id, notification);
	}

	//�̶���id,��������֪ͨ��֮����һ����
	private void showNotifi(Context context) {
		showNotifi(context, NOTIFIFIXID);
	}

	private void showNotifiMyself(Context context) {
		//��ȡNotificationManager����������֪ͨ��Ϣ�ķ�����ȡ��
		NotificationManager notifiManger = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		//����֪ͨ����
		Notification notification = new Notification();

		RemoteViews remoteView = new RemoteViews(context.getPackageName(),
				R.layout.noti_myself);

		//RemoteView�ĵ���¼�,��3.0֮ǰ֧�ֵ���ͼ���٣�listview���϶���֧�֡�
		PendingIntent palyPendingIntent = PendingIntent.getBroadcast(context,
				0, new Intent(ACTION_PALY_MUSIC), 0);
		remoteView.setOnClickPendingIntent(R.id.palyMusic, palyPendingIntent);

		PendingIntent nextPendingIntent = PendingIntent.getBroadcast(context,
				0, new Intent(ACTION_NEXT_MUSIC), 0);
		remoteView.setOnClickPendingIntent(R.id.nextMusic, nextPendingIntent);

		notification.contentView = remoteView;

		//�����ת��Intent
		PendingIntent pendingItent = PendingIntent.getActivity(context, 0,
				new Intent(this, ResultActivity.class), 0);

		notification.contentIntent = pendingItent;

		//�Զ�����ͼ�������õ�����,Ҫ��Ȼ�������Notification
		//ͷ�ϵ�ͼ��
		notification.icon = R.drawable.ic_launcher;

		notification.tickerText = "������Ϣ���������Ƚ���";

		notifiManger.notify(NOTIFIFIXID, notification);

	}

	/**
	 * �ο���ַ
	 * http://developer.android.com/guide/topics/ui/notifiers/notifications.html#NotificationUI
	 * http://www.cnblogs.com/tianjian/archive/2012/12/31/2840862.html
	 * @author Administrator / Never give up, adhere to in the end.
	 * email: pengqinping@gmail.com
	 * @param context
	 */
	private void showNotifiNews(Context context) {
		//��ȡNotificationManager����������֪ͨ��Ϣ�ķ�����ȡ��
		NotificationManager notifiManger = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		//����֪ͨ����,��3.0֮��ֱ��ȥnew Notificationd���� NotificationCompat.Builder
		Builder notifiBuilder = new NotificationCompat.Builder(this);

		//�������õ�3������
		notifiBuilder.setSmallIcon(R.drawable.app_window);
		notifiBuilder.setContentTitle("��Ϣ����");
		notifiBuilder.setContentText("���ĵ��Գ�������");

		//���û�����ô�ͼ�꣬ϵͳ��Ĭ��ȡӦ�õ�ͼ�ꡣ
		notifiBuilder.setContentInfo("123:" + numId);
		notifiBuilder.setNumber(++numId);
		notifiBuilder.setLargeIcon(BitmapFactory.decodeResource(
				context.getResources(), R.drawable.app_window));
		notifiBuilder.setLights(0xff00ff00, 300, 1000);
		notifiBuilder.setVibrate(new long[] { 0, 100, 200, 300, 400 });

		//new һ����ջ����
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(ResultActivity.class);
		Intent intent = new Intent(context, ResultActivity.class);

		//�����intent�ŵ�ջ������������֮������ͨ��Notification��ת��Activity�󣬵��back����ʱ��ֱ�ӻص�Home Screen.
		stackBuilder.addNextIntent(intent);

		PendingIntent resultPending = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		notifiBuilder.setContentIntent(resultPending);

		Notification notification = notifiBuilder.build();
		notification.defaults = Notification.DEFAULT_SOUND;

		notifiManger.notify(NOTIFIFIXID, notification);
	}

	public void showNotifiBigViewStyle(Context context) {
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this).setSmallIcon(R.drawable.app_window)
				.setContentTitle("�н���������")
				.setContentText("��ϲ���ڱ��ڵĲ�Ʊ�л��50000����Ĵ󽱡�");

		mBuilder.setLargeIcon(BitmapFactory.decodeResource(
				context.getResources(), R.drawable.app_window));
		mBuilder.setTicker("��ôû�г����У�");

		//����sytle
		NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
		String[] events = new String[6];

		// Sets a title for the Inbox style big view
		inboxStyle.setBigContentTitle("����Ǵ��Ŷ");

		// Moves events into the big view
		for (int i = 0; i < events.length; i++) {
			events[i] = "message : " + i;
			inboxStyle.addLine(events[i]);
		}

		// Moves the big view style object into the notification object.
		mBuilder.setStyle(inboxStyle);

		NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		manager.notify(NOTIFIFIXID, mBuilder.build());

	}

	private void showNotifiRule(Context context) {
		Intent resultIntent = new Intent(context, ResultActivity1.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		// ��Ӻ�̨��ջ
		stackBuilder.addParentStack(ResultActivity1.class);
		// ���Intent��ջ��
		stackBuilder.addNextIntent(resultIntent);
		// ���һ��PendingIntent����������̨��ջ containing the entire back stack
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(
				context);
		//�������õ�3������
		builder.setSmallIcon(R.drawable.app_window);
		builder.setContentTitle("��Ϣ����");
		builder.setContentText("���ĵ��Գ�������");

		builder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(NOTIFIFIXID, builder.build());
	}

	private void showNotifiGood(Context context) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(
				context);
		Intent notifyIntent = new Intent(context, ResultActivity2.class);
		notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TASK);
		PendingIntent notifyIntentPending = PendingIntent.getActivity(context,
				0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		//�������õ�3������
		builder.setSmallIcon(R.drawable.app_window);
		builder.setContentTitle("��Ϣ����");
		builder.setContentText("���ĵ��Գ�������");
		builder.setContentIntent(notifyIntentPending);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(NOTIFIFIXID, builder.build());
	}

	/**
	 * ����Զ����ͼ�ĵ���㲥��
	 * @author Administrator / Never give up, adhere to in the end.
	 * email: pengqinping@gmail.com
	 */
	public class RemoteClickRecevice extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (ACTION_PALY_MUSIC.equals(action)) {
				alert("ok we are play Music!");
			} else if (ACTION_NEXT_MUSIC.equals(action)) {
				alert("ok let's go to next music !");
			}

		}

	}

	public void alert(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

}
