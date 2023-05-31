package com.example.airneis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.modeles.Produit;

public class ListProductListAdapteur extends RecyclerView.Adapter<ListProductListCellHolder> {

    Produit[] dataSource;

    ListProductListListener listProductListListener;

    public ListProductListAdapteur(Produit[] dataSource, ListProductListListener listener){
        this.dataSource = dataSource;
        this.listProductListListener = listener;
    }

    @NonNull
    @Override
    public ListProductListCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_cell, parent, false);
        return new ListProductListCellHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductListCellHolder holder, int position) {
        //Picasso.get().load(dataSource[position].getPhoto()).into(holder.productPhotoImageView);
        holder.productNameTextView.setText(dataSource[position].getNom());
        holder.priceTagTextView.setText(String.valueOf(dataSource[position].getPrix()));
    }

    @Override
    public int getItemCount() {
        if (dataSource != null) {
            return dataSource.length;
        }
        return 0;
    }
}
