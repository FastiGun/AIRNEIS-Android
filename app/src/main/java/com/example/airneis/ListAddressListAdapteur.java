package com.example.airneis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.modeles.Adresse;

public class ListAddressListAdapteur extends RecyclerView.Adapter<ListAddressListCellHolder>{

    Adresse[] dataSource;
    ListAddressListListener listAddressListListener;
    String token;

    public ListAddressListAdapteur(Adresse[] dataSource, ListAddressListListener listener, String token){
        this.dataSource = dataSource;
        this.listAddressListListener = listener;
        this.token = token;
    }

    @NonNull
    @Override
    public ListAddressListCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_list_cell, parent, false);
        return new ListAddressListCellHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAddressListCellHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nameAddress.setText(dataSource[position].getNom());
        holder.streetAddress.setText(dataSource[position].getRue());
        holder.cityAddress.setText(dataSource[position].getVille());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listAddressListListener.onAddressClick(dataSource[position].getId(), token);
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
