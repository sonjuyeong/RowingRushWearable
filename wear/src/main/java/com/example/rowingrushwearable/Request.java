package com.example.rowingrushwearable;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONException;

import java.util.Map;

public class Request {

    public void getItems(String url,String tag,  final InterfaceFAN view) {

        AndroidNetworking.get(url)
                .setTag(tag)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            view.successFAN(response);
                        }catch (JSONException e){
                            view.errorFAN(e.getMessage());
                            // e.printStackTrace();

                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        view.errorFAN(String.valueOf(anError));

                    }
                });



    }

    public void postItems(String url, String tag, Map<String,String> maps, final InterfaceFAN view) {

        AndroidNetworking.post(url)
                .addBodyParameter(maps)
                .setTag(tag)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            view.successFAN(response);
                        } catch (JSONException e) {
                            view.errorFAN(e.getMessage());
                            // e.printStackTrace();

                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        view.errorFAN(String.valueOf(anError));

                    }
                });


    }


}
