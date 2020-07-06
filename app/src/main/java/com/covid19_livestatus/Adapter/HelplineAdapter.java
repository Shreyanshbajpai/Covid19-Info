package com.uibsoft.covid_info.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uibsoft.covid_info.Model.HelpModel;
import com.uibsoft.covid_info.Model.StateModel;
import com.uibsoft.covid_info.R;

import java.util.ArrayList;

public class HelplineAdapter extends RecyclerView.Adapter<HelplineAdapter.ViewHolder> {


    public HelplineAdapter(ArrayList<HelpModel> arrayList) {
        this.arrayList = arrayList;
    }

    private ArrayList<HelpModel> arrayList;


    @NonNull
    @Override
    public HelplineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.state_helpline,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelplineAdapter.ViewHolder holder, int position) {


        HelpModel stateModel=arrayList.get(position);

        holder.stateName.setText(stateModel.getStateName());

        holder.helpNo.setText(stateModel.getHelpNo());

    }

    @Override
    public int getItemCount() {
        return arrayList!=null?arrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        TextView stateName,helpNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);




            helpNo=itemView.findViewById(R.id.helpNo);
            stateName=itemView.findViewById(R.id.stateHelpName);

        }
    }
}
