package com.uibsoft.covid_info.Fragment;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uibsoft.covid_info.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrag extends Fragment {




    private TextView totalCase,totalDeath,totalRec;
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);


        viewInit();
        getDataAPI();

        return  view;
    }

    private void getDataAPI() {

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());


        String url="https://akashraj.tech/corona/api";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {

                    JSONObject jsonObject = new JSONObject(response).getJSONObject("world_total");

                    totalCase.setText(jsonObject.getString("total_cases"));
                    totalDeath.setText(jsonObject.getString("total_deaths"));
                    totalRec.setText(jsonObject.getString("total_recovered"));


                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(getActivity(),""+e,Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Log.i("tag", String.valueOf(error));


                Toast.makeText(getActivity(),""+error,Toast.LENGTH_LONG).show();


            }
        });

        requestQueue.add(stringRequest);


    }

    private void viewInit() {

        totalCase=view.findViewById(R.id.totalCaseN);
        totalDeath=view.findViewById(R.id.totalCaseD);
        totalRec=view.findViewById(R.id.totalCaseR);
    }
}
