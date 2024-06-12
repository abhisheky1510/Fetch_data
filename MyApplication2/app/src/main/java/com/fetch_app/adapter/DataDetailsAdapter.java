package com.fetch_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fetch_app.R;
import com.fetch_app.model.DataDetails;

import java.util.List;

public class DataDetailsAdapter extends RecyclerView.Adapter<DataDetailsAdapter.DataDetailsHolder>{

    private List<DataDetails> dataDetailsList;
    private Context context;


    public DataDetailsAdapter(List<DataDetails> dataDetailsList, Context context) {
        this.dataDetailsList = dataDetailsList;
        this.context = context;
    }

    @NonNull
    @Override
    public DataDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new DataDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataDetailsHolder holder, int position) {
        holder.data_id.setText(String.valueOf(dataDetailsList.get(position).getId()));
        holder.data_listId.setText(String.valueOf(dataDetailsList.get(position).getListId()));
        holder.data_name.setText(dataDetailsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataDetailsList.size();
    }

    public class DataDetailsHolder extends RecyclerView.ViewHolder{
        private TextView data_id;
        private TextView data_listId;
        private TextView data_name;
        public DataDetailsHolder(@NonNull View itemView) {
            super(itemView);

            data_id = itemView.findViewById(R.id.id);
            data_listId = itemView.findViewById(R.id.listid);
            data_name = itemView.findViewById(R.id.name);
        }
    }
}
