package com.uibsoft.covid_info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uibsoft.covid_info.Adapter.StateAdapter;
import com.uibsoft.covid_info.Model.StateModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class IndiaActivity extends AppCompatActivity {



    private ArrayList<StateModel> arrayList;
    RecyclerView recyclerView;
    View view;

    private TextView totalCaseaInd,totalCaseFor,TotalConfCaseInd,totalRecInd,totalDeathInd,lastUpdate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);


        viewInit();
        getDataAPI();


        adapterSetup();

        getStateDataAPI();


    }

    private void adapterSetup() {


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StateAdapter stateAdapter = new StateAdapter(arrayList);

        recyclerView.setAdapter(stateAdapter);


    }

    private void getStateDataAPI() {


        String url = "https://api.rootnet.in/covid19-in/stats/latest";


        arrayList = new ArrayList<>();


        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("regional");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject data = jsonArray.getJSONObject(i);


                        arrayList.add(new StateModel(data.getString("loc"), data.getString("totalConfirmed")));

                    }
                    adapterSetup();


                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_LONG).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Log.i("tag", String.valueOf(error));


                Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_LONG).show();


            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);


    }

    private void getDataAPI() {


        RequestQueue requestQueue = Volley.newRequestQueue(this);


        String url = "https://api.rootnet.in/covid19-in/stats/latest";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {

                    JSONObject jsonObject = new JSONObject(response).getJSONObject("data").getJSONObject("summary");

                    totalCaseaInd.setText(jsonObject.getString("total"));
                    totalDeathInd.setText(jsonObject.getString("deaths"));
                    totalRecInd.setText(jsonObject.getString("discharged"));
                    totalCaseFor.setText(jsonObject.getString("confirmedCasesForeign"));

                    TotalConfCaseInd.setText(jsonObject.getString("confirmedCasesIndian"));


                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Log.i("tag", String.valueOf(error));


                Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_LONG).show();


            }
        });

        requestQueue.add(stringRequest);


    }

    private void viewInit() {

        totalCaseaInd = findViewById(R.id.totalCaseInd);
        totalCaseFor = findViewById(R.id.totalConfCaseFor);
        TotalConfCaseInd = findViewById(R.id.totalConfCaseInd);
        totalRecInd = findViewById(R.id.totalCaseRec);
        totalDeathInd = findViewById(R.id.totalDeathInd);
        recyclerView = findViewById(R.id.recyclerView);


    }
}