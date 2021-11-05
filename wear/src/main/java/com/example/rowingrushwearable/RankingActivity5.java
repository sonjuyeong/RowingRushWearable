package com.example.rowingrushwearable;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;

public class RankingActivity5 extends AppCompatActivity implements com.example.rowingrushwearable.InterfaceFAN, com.example.rowingrushwearable.InterfaceFilejson.list5{

    private RecyclerView rvList5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking5);
        rvList5=(RecyclerView) findViewById(R.id.rvList5);
        String url = "https://script.google.com/macros/s/AKfycbylvetNHghg319R-1_Nid9Ei_JV4ef-89ZJnyeHTo6JyOi4ofSmdSFH6MbbMq8l5nz2/exec?action=read";
        Request request=new Request();
        request.getItems(url, "list", this);

    }



    @Override
    public void successFAN(String json) throws JSONException {
        com.example.rowingrushwearable.Filejson filejson = new com.example.rowingrushwearable.Filejson();
        filejson.listRegisteration5(json, this);
    }

    @Override
    public void errorFAN(String error) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void listRegisteration5(ArrayList<com.example.rowingrushwearable.RegisterModel> registerModels) {
        com.example.rowingrushwearable.ListViewAdapter listViewAdapter = new com.example.rowingrushwearable.ListViewAdapter(this,registerModels);
        rvList5.setAdapter(listViewAdapter);
        rvList5.setLayoutManager(new LinearLayoutManager(this));
    }


}