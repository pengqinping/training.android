package com.twp.databinding.lisenter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;

/**
 * Created by pengqinping on 2019/2/27.
 *
 * @email pengqinping@hotmail.com
 * @description
 */
public class ClickHandler extends BaseObservable {
    public  void onClickFrind(View view){
        Log.i("what","click ");
        Toast.makeText(view.getContext(),"Good",Toast.LENGTH_LONG).show();
    }

}
