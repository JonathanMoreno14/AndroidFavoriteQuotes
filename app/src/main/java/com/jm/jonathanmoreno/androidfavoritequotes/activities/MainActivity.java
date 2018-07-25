package com.jm.jonathanmoreno.androidfavoritequotes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.jm.jonathanmoreno.androidfavoritequotes.R;
import com.jm.jonathanmoreno.androidfavoritequotes.adapter.FavoriteQuotesAdapter;
import com.jm.jonathanmoreno.androidfavoritequotes.model.FavoriteQuotes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindString(R.string.json_url)
    String JSON_URL;
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private List<FavoriteQuotes> favoriteQuotesArray = new ArrayList<>();
    private RecyclerView recyclerView;
    private FavoriteQuotesAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.recyclerview);

        adapter = new FavoriteQuotesAdapter(this, favoriteQuotesArray);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL));



        jsonRequest();
    }


    public void  jsonRequest(){
        jsonArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {

                    try {

                        jsonObject = response.getJSONObject(i);
                        FavoriteQuotes quotes = new FavoriteQuotes();

                        quotes.setQuote(jsonObject.getString("quote"));
                        quotes.setAuthor(jsonObject.getString("author"));
                        quotes.setImg(jsonObject.getString("img"));
                        quotes.setBio(jsonObject.getString("bio"));

                        favoriteQuotesArray.add(quotes);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplication(),
                                "JSONException",
                                Toast.LENGTH_LONG).show();
                    }
                }

                adapter.notifyDataSetChanged();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("onErrorResponse", error.toString());
                error.printStackTrace();
                Toast.makeText(getApplication(),
                        "Oops. Timeout error!",
                        Toast.LENGTH_LONG).show();

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);
    }



}
