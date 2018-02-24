package com.interstellar.android.httpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    private TextView mTxtDisplay;
    private Button mButtonParse;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTxtDisplay = (TextView) findViewById(R.id.txtDisplay);
        mButtonParse = (Button) findViewById(R.id.button_Parse);

        mRequestQueue = Volley.newRequestQueue(this);

        mButtonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }
        });


    }

    private void jsonParse() {
        String url = "";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("employ");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employ = jsonArray.getJSONObject(i);

                                String firstName = (String) employ.get("firstName");
                                int age = employ.getInt("age");

                                mTxtDisplay.append(firstName + ", " + String.valueOf(age) + "\n\n");

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
}
