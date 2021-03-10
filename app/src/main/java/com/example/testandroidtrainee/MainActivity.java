package com.example.testandroidtrainee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testandroidtrainee.databinding.ActivityMainBinding;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity{

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText etEmail;
    EditText etPass;
    CheckBox cbLuumatkhau;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        initPreferences();
        ActivityMainBinding activityMainBinding =  DataBindingUtil.setContentView(this, R.layout.activity_main);
        Model model = new Model();
        activityMainBinding.setLoginViewmodel(model);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbLuumatkhau.isChecked()) {
                    String data1 = etEmail.getText().toString();
                    // "DATA" là key, data tham số thứ 2 là value.
                    editor.putString("DATA", data1);
                    editor.commit();
                } else {
                    // Nếu click vào nút Clear, ta sẽ xoá dữ liệu đi.
                    etEmail.setText("");
                    editor.clear();
                    editor.commit();
                }
            }
        });
    }

    private void AnhXa() {
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        cbLuumatkhau = findViewById(R.id.checkbox);
        btnLogin =findViewById(R.id.btnLogin);
    }

    private void initPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
        editor.putString("email", "string value");
        editor.putString("pass","string value");
        editor.apply();
        String savedData1 = sharedPreferences.getString("DATA", "");
        etEmail.setText(savedData1);
        String savedData2 = sharedPreferences.getString("DATA2", "");
        etPass.setText(savedData2);
    }
}