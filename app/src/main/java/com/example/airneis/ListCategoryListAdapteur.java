package com.example.airneis;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.modeles.Categorie;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ListCategoryListAdapteur extends RecyclerView.Adapter<ListCategoryListCellHolder>{

    Categorie[] dataSource;

    ListCategoryListListener listCategoryListListener;

    public ListCategoryListAdapteur(Categorie[] dataSource, ListCategoryListListener listener){
        this.dataSource = dataSource;
        this.listCategoryListListener = listener;
    }

    @NonNull
    @Override
    public ListCategoryListCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_category_list_cell, parent, false);
        return new ListCategoryListCellHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ListCategoryListCellHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView_categoryName.setText(dataSource[position].getNom());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listCategoryListListener.onCategoryClick(dataSource[position].getId());
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
