package com.example.airneis.features.products;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;
import com.example.airneis.modeles.Produit;
import com.squareup.picasso.Picasso;

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
    public void onBindViewHolder(@NonNull ListProductListCellHolder holder, @SuppressLint("RecyclerView") int position) {
        String url = dataSource[position].getImage1();
        Picasso.get().load(url).into(holder.productPhotoImageView);
        holder.productNameTextView.setText(dataSource[position].getNom());
        holder.priceTagTextView.setText(String.valueOf(dataSource[position].getPrix()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listProductListListener.onProductClick(dataSource[position].getId());

            }
        });
    }

    private void runOnUiThread(Runnable runnable) {
    }

    @Override
    public int getItemCount() {
        if (dataSource != null) {
            return dataSource.length;
        }
        return 0;
    }
}
