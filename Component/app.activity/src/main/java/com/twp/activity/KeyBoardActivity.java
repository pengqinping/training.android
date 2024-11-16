package com.twp.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class KeyBoardActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_board);
        listView = (ListView)findViewById(R.id.listview);
        String[] strings = new String[10];
        for(int i=0;i<10;i++){
            strings[i] = "item"+i;
        }
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings));

    }
}
