package com.example.rowingrushwearable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Filejson {

    public void game(String json, InterfaceFilejson.game view) throws JSONException{
        JSONObject object = new JSONObject(json);
        JSONArray jsonArray=object.getJSONArray("records");
        for(int i=0; i<jsonArray.length(); i++)
        {

            String name=jsonArray.getJSONObject(i).getString("userid") ;
            String date=jsonArray.getJSONObject(i).getString("date");
            Event newEvent= new Event(name, "오늘의 운동","오늘의 운동",date, date);
            Event.eventsList.add(newEvent);

        }
        view.game();
    }

    public void simpan(String json, InterfaceFilejson.save view ) throws JSONException {
        JSONObject object=new JSONObject(json);
        view.successSimpan(object.getString("status"));

    }

    public void listRegisteration(String json, InterfaceFilejson.list view) throws JSONException{

        JSONObject object = new JSONObject(json);
        JSONArray jsonArray=object.getJSONArray("records");
        ArrayList<com.example.rowingrushwearable.RegisterModel> registerModels = new ArrayList<>();
        for(int i=0; i<jsonArray.length(); i++)
        {
            if(jsonArray.getJSONObject(i).getString("userdistance").equals("1"))
            {
                com.example.rowingrushwearable.RegisterModel model = new com.example.rowingrushwearable.RegisterModel();
                model.setUser(i+1);
                model.setUserdate(jsonArray.getJSONObject(i).getString("date"));
                model.setUserid(jsonArray.getJSONObject(i).getString("userid"));
                model.setUserdistance(jsonArray.getJSONObject(i).getString("userdistance"));
                int value = Integer.parseInt(jsonArray.getJSONObject(i).getString("usertime"));
                model.setUsertime(value);
                registerModels.add(model);
            }
        }

        view.listRegisteration(registerModels);
    }
    public void listRegisteration3(String json, InterfaceFilejson.list3 view) throws JSONException{

        JSONObject object = new JSONObject(json);
        JSONArray jsonArray=object.getJSONArray("records");
        ArrayList<com.example.rowingrushwearable.RegisterModel> registerModels = new ArrayList<>();

        for(int i=0; i<jsonArray.length(); i++)
        {
            if(jsonArray.getJSONObject(i).getString("userdistance").equals("3"))
            {
                com.example.rowingrushwearable.RegisterModel model = new com.example.rowingrushwearable.RegisterModel();

                model.setUserdate(jsonArray.getJSONObject(i).getString("date"));
                model.setUserid(jsonArray.getJSONObject(i).getString("userid"));
                model.setUserdistance(jsonArray.getJSONObject(i).getString("userdistance"));
                int value = Integer.parseInt(jsonArray.getJSONObject(i).getString("usertime"));
                model.setUsertime(value);
                registerModels.add(model);

            }
        }

        view.listRegisteration3(registerModels);
    }
    public void listRegisteration5(String json, InterfaceFilejson.list5 view) throws JSONException{

        JSONObject object = new JSONObject(json);
        JSONArray jsonArray=object.getJSONArray("records");
        ArrayList<com.example.rowingrushwearable.RegisterModel> registerModels = new ArrayList<>();
        for(int i=0; i<jsonArray.length(); i++)
        {
            if(jsonArray.getJSONObject(i).getString("userdistance").equals("5"))
            {
                com.example.rowingrushwearable.RegisterModel model = new com.example.rowingrushwearable.RegisterModel();
                model.setUser(i+1);
                model.setUserdate(jsonArray.getJSONObject(i).getString("date"));
                model.setUserid(jsonArray.getJSONObject(i).getString("userid"));
                model.setUserdistance(jsonArray.getJSONObject(i).getString("userdistance"));
                int value = Integer.parseInt(jsonArray.getJSONObject(i).getString("usertime"));
                model.setUsertime(value);
                registerModels.add(model);
            }
        }

        view.listRegisteration5(registerModels);
    }


}
