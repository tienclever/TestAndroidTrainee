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
    Button btnluu;
    CheckBox cbLuumatkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding =  DataBindingUtil.setContentView(this, R.layout.activity_main);
        Model model = new Model();
        activityMainBinding.setLoginViewmodel(model);

        AnhXa();
        initPreferences();
        data();
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnluu && etPass.getText().toString().matches("^(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,}$")) {
                    if (cbLuumatkhau.isChecked()) {
                        String data = etEmail.getText().toString();
                        editor.putString("DATA", data);
                        String data1 = etPass.getText().toString();
                        editor.putString("DATA1", data1);
                        editor.commit();
                    }else {
                        etEmail.setText("");
                        etPass.setText("");
                        editor.clear();
                        editor.commit();
                    }
                    Intent intent = new Intent(getApplicationContext(), ManHinhLogout.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công! abccm", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "eeeessssss", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void data() {
            String savedData = sharedPreferences.getString("DATA", "");
            etEmail.setText(savedData);
            String savedData1 = sharedPreferences.getString("DATA1", "");
            etPass.setText(savedData1);
    }

    private void AnhXa() {
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        cbLuumatkhau = findViewById(R.id.checkbox);
        btnluu = findViewById(R.id.btnluu);
    }

    private void initPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

}