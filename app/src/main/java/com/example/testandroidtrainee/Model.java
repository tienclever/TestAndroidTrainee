package com.example.testandroidtrainee;

import android.content.Intent;
import android.icu.text.DisplayContext;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class Model extends BaseObservable {
    private String email;
    private String password;
    public ObservableField<String> message = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickmodel(){
        User user = new User(getEmail(),getPassword());
        if(user.isValidEmail() && user.isValidPassWord()){
            message.set("Đăng nhập thành công!");
        }else {
            message.set("Đăng nhập thất bại!");
        }
    }
}
