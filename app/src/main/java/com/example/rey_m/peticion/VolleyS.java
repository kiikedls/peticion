package com.example.rey_m.peticion;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {
    private static VolleyS mVolleyS=null;
//    este objeto es la cola que usara la aplicacion
    private RequestQueue mRequestQueue;

    private VolleyS(Context context){
        mRequestQueue= Volley.newRequestQueue(context);
    }

    public static VolleyS getInstance(Context context){
        if (mVolleyS==null){
            mVolleyS=new VolleyS(context);
        }
        return mVolleyS;
    }

    /*public static RequestQueue getInstRequestQueue(Context context){
        if (mRequestQueue==null){
            mRequestQueue=VolleyS.newRequestQueue(context);
        }
        return mRequestQueue;
    }*/

    public RequestQueue getmRequestQueue() {
        return mRequestQueue;
    }
}
