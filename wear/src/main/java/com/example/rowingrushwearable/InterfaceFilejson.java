package com.example.rowingrushwearable;

import java.util.ArrayList;

public interface InterfaceFilejson {
    interface save{
        void successSimpan(String message);
    }
    interface list{
        void listRegisteration( ArrayList<com.example.rowingrushwearable.RegisterModel> registerModels);
    }
    interface list3{
        void listRegisteration3( ArrayList<com.example.rowingrushwearable.RegisterModel> registerModels);
    }
    interface  list5{
        void listRegisteration5( ArrayList<com.example.rowingrushwearable.RegisterModel> registerModels);
    }


    interface game {
        void game();
    }
}
