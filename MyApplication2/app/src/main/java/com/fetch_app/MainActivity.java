package com.fetch_app;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fetch_app.adapter.DataDetailsAdapter;
import com.fetch_app.model.DataDetails;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<DataDetails> dataDetailsList = new ArrayList<>();
    private DataDetailsAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        init();
        requestData();
    }

    public void init() {
        recyclerView = findViewById(R.id.recyclerView);
        context = MainActivity.this;
        adapter = new DataDetailsAdapter(dataDetailsList, context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

    public void requestData() {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://fetch-hiring.s3.amazonaws.com/hiring.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<DataDetails> tempList = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                int listId = jsonObject.getInt("listId");
                                String name = jsonObject.optString("name", null);


                                if (name != null && !name.trim().isEmpty() && !name.equals("null")) {
                                    tempList.add(new DataDetails(id, listId, name));
                                }
                            }

                            Collections.sort(tempList, new Comparator<DataDetails>() {
                                @Override
                                public int compare(DataDetails o1, DataDetails o2) {
                                    if (o1.getListId() != o2.getListId()) {
                                        return Integer.compare(o1.getListId(), o2.getListId());
                                    }
                                    return o1.getName().compareTo(o2.getName());
                                }
                            });

                            for (DataDetails item : tempList) {
                                Log.d(TAG, "Sorted item: " + item);
                            }

                            dataDetailsList.clear();
                            dataDetailsList.addAll(tempList);
                            Log.d(TAG, "Data list size: " + dataDetailsList.size());  // Add this log
                            adapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            Log.e(TAG, "JSON parsing error: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        showToast("API call error");
                    }
                });

        queue.add(stringRequest);
    }


    public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}