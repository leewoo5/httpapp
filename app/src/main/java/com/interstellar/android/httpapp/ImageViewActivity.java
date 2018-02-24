package com.interstellar.android.httpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class ImageViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJson();
    }

    private void parseJson() {
        //카카오 rest api : cdc380c5c6faa8ec3b8bdb95e124be15
        //String url  = "https://pixabay.com/api/?key=8156024-57700de2524ae54f9c61d01ae&q=yellow+flowers&image_type=photo";
        //String url  = "https://dapi.kakao.com/v2/search/book?target=title";
        String url  = "http://apis.daum.net/search/book?q=미움받을 용기&apikey=a231fc69856c8b7d296330e8b9092201a297f5cb&output=json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("channel");
                    JSONArray jsonArray = object.getJSONArray("item");
                    //JSONArray jsonArray = response.getJSONArray("hits");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);

                        String title = obj.getString("title");//user
                        Log.i("Title", title);
                        String imageUrl = obj.getString("cover_l_url");//webformatURL
                        int price = obj.getInt("list_price");//likes


                        mExampleList.add(new ExampleItem(imageUrl, title, price));

                    }

                    mExampleAdapter = new ExampleAdapter(ImageViewActivity.this, mExampleList);
                    mRecyclerView.setAdapter(mExampleAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("Error", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.i("Error", error.getMessage());
            }

        })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                //headers.put("GET", "/v2/search/book/");
                //headers.put("HOST", "dapi.kakao.com");
                //headers.put("Authorization", "KakaoAK cdc380c5c6faa8ec3b8bdb95e124be15");
                return headers;
            }

            //Pass Your Parameters here
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("query", "person");
                return params;
            }
        };
        mRequestQueue.add(request);
    }
}
