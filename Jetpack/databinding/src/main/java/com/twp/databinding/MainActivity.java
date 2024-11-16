package com.twp.databinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import com.twp.databinding.databinding.ActivityMainBinding;
import com.twp.databinding.lisenter.ClickHandler;
import com.twp.databinding.mv.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding dataBinding = ActivityMainBinding.bind(LayoutInflater.from(this).inflate(R.layout.activity_main,null));
        User user = new User("刘备","刘玄德");
        ClickHandler handler = new ClickHandler();

        dataBinding.setUser(user);
        dataBinding.setClickHelp(handler);

    }


}
