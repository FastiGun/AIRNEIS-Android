package com.example.airneis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Produit;
import com.squareup.picasso.Picasso;

public class CategoryListAdapteur extends RecyclerView.Adapter<CategoryListCellHolder> {

    Produit[] dataSource;

    RedirectionInterface redirectionListListener;

    public CategoryListAdapteur(Produit[] dataSource, RedirectionInterface listener){
        this.dataSource = dataSource;
        this.redirectionListListener = listener;
    }

    @NonNull
    @Override
    public CategoryListCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_cell, parent, false);
        return new CategoryListCellHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListCellHolder holder, int position) {
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
