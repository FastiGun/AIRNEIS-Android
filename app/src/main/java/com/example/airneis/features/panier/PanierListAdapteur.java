package com.example.airneis.features.panier;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;
import com.example.airneis.modeles.Panier;

public class PanierListAdapteur extends RecyclerView.Adapter<PanierListCellHolder> {

    Panier[] dataSource;

    PanierListListener panierListListener;

    public PanierListAdapteur(Panier[] dataSource, PanierListListener panierListListener){
        this.dataSource = dataSource;
        this.panierListListener = panierListListener;
    }

    @NonNull
    @Override
    public PanierListCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.panier_list_cell, parent, false);
        return new PanierListCellHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PanierListCellHolder holder, int position) {
        holder.productNameBasketCell_textView.setText(dataSource[holder.getAdapterPosition()].getProduit().getNom());
        holder.productDescriptionBasketCell_textView.setText(String.valueOf(dataSource[holder.getAdapterPosition()].getProduit().getDescription()));
        holder.productPriceBasketCell_textView.setText(String.valueOf(dataSource[holder.getAdapterPosition()].getProduit().getPrix()));
        holder.productQuantityBasketCell_editTextNumber.setText(String.valueOf(dataSource[holder.getAdapterPosition()].getQuantite()));

        holder.deleteProduct_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panierListListener.deleteCart(dataSource[holder.getAdapterPosition()].getId());
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
