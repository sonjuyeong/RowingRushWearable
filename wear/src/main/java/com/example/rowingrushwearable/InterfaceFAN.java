package com.example.rowingrushwearable;

import org.json.JSONException;

public interface InterfaceFAN {
    void successFAN(String json) throws JSONException;
    void errorFAN(String error);

}
