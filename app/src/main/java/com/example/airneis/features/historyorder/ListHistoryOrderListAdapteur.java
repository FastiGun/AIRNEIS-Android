package com.example.airneis.features.historyorder;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;
import com.example.airneis.modeles.Commande;

public class ListHistoryOrderListAdapteur extends RecyclerView.Adapter<ListHistoryOrderListCellHolder>{
    Commande[] dataSource;
    ListHistoryOrderListListener listHistoryOrderListListener;
    String token;
    String _id;

    public ListHistoryOrderListAdapteur(Commande[] dataSource, ListHistoryOrderListListener listener, String token, String _id){
        this.dataSource = dataSource;
        this.listHistoryOrderListListener = listener;
        this.token = token;
        this._id = _id;
    }

    @NonNull
    @Override
    public ListHistoryOrderListCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_order_list_cell, parent, false);
        return new ListHistoryOrderListCellHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHistoryOrderListCellHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //listAddressListListener.onAddressClick(dataSource[position].getId(), token);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (dataSource != null) {
            return dataSource.length;
        }
        return 0;
    }

}
