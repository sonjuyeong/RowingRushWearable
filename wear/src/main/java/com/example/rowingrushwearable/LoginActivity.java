package com.example.rowingrushwearable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, com.example.rowingrushwearable.InterfaceFAN, InterfaceFilejson.save {


    private EditText idText, passwordText;
    public static Context context_main;
    public String MYID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idText = findViewById(R.id.idText);
        passwordText =findViewById(R.id.passwordText);

        context_main=this;



        final Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        String userid  = idText.getText().toString();
        String userpass = passwordText.getText().toString();

        if(TextUtils.isEmpty(userid))
        {
            idText.setError("isi data");
            return;
        }
        if(TextUtils.isEmpty(userpass))
        {
            passwordText.setError("isi data");
            return;
        }

        Map<String, String> maps = new HashMap<>();
        maps.put("userid", userid);
        maps.put("userpass", userpass);
        maps.put("login", "0");

        String url = "https://script.google.com/macros/s/AKfycbwoQEYegaKSD8dFsl1Oes9lUMpWoMSe9vxvAeTLT-FNQv1di5xQA-RyyzBeOZfHnuYT/exec";
        Request request=new Request();
        request.postItems(url, "simpan",maps, this);


    }
    @Override
    public void successFAN(String json) throws JSONException {

        com.example.rowingrushwearable.Filejson filejson = new com.example.rowingrushwearable.Filejson();
        filejson.simpan(json, this);

    }
    @Override
    public void errorFAN(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successSimpan(String message) {
        if(message.equals("로그인 성공")) {
        MYID=idText.getText().toString();
        finish();
        startActivity(new Intent(this, com.example.rowingrushwearable.Rank_Calender.class));
        }
        else{
            Toast.makeText(this, "계정을 다시 확인하세요", Toast.LENGTH_SHORT).show();

        }

    }


}




