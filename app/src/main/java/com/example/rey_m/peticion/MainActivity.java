package com.example.rey_m.peticion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String URL;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1_recibir).setOnClickListener(this);
        txt1=findViewById(R.id.lbl_nombre);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1_recibir:
                JsonObjectRequest jor=new JsonObjectRequest(
                        Request.Method.GET,
                        "http://nuevo.rnrsiilge-org.mx/principal",
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try{
                                    txt1.setText(response.getString("nombre"));
                                }
                                catch(JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                VolleyS.getInstance(this).getmRequestQueue().add(jor);
                break;
        }
    }
}
