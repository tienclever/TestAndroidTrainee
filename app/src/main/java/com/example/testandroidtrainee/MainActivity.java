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
    Button btnLogin;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding =  DataBindingUtil.setContentView(this, R.layout.activity_main);
        Model model = new Model();
        activityMainBinding.setLoginViewmodel(model);

        AnhXa();
        initPreferences();
        String savedDataemail = sharedPreferences.getString("EMAIL", "");
        etEmail.setText(savedDataemail);
        String savedDatapass = sharedPreferences.getString("PASS", "");
        etEmail.setText(savedDatapass);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnluu){
                    String dataEmail = etEmail.getText().toString();
                    editor.putString("EMAIL", dataEmail);
                    String dataPass = etEmail.getText().toString();
                    editor.putString("PASS", dataPass);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), ManHinhLogout.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(),"Bạn nhập không hợp lệ",Toast.LENGTH_LONG).show();
                    etEmail.setText("");
                    etPass.setText("");
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
       // btnLogin =findViewById(R.id.btnLogin);
        btnluu = findViewById(R.id.btnluu);
    }

    private void initPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }
}