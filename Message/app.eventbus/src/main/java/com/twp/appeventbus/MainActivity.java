package com.twp.appeventbus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void OnButtonClick(View v){
        EventBus.getDefault().post(new MessageEvent("click"));
    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event){
        Toast.makeText(getApplicationContext(),"received message "+event.message,Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void handlerMessageEvent(SomeOtherEvent event){
        Toast.makeText(getApplicationContext(),"received message "+event,Toast.LENGTH_LONG).show();
    }
}
