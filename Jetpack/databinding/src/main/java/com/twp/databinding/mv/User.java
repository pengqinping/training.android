package com.twp.databinding.mv;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Created by pengqinping on 2019/2/26.
 *
 * @email pengqinping@gmail.com
 * @description
 */
public class User extends BaseObservable {
    private  String firstName;
    private  String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Bindable
    public String getFirstName() {
        return this.firstName;

    }
    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
