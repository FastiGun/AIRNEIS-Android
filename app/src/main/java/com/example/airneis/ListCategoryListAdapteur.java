package com.example.airneis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.modeles.Categorie;
import com.squareup.picasso.Picasso;


public class ListCategoryListAdapteur extends RecyclerView.Adapter<ListCategoryListCellHolder>{

    Categorie[] dataSource;

    CategoryListListener categoryListListener;

    public ListCategoryListAdapteur(Categorie[] dataSource, CategoryListListener listener){
        this.dataSource = dataSource;
        this.categoryListListener = listener;
    }

    @NonNull
    @Override
    public ListCategoryListCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_category_list_cell, parent, false);
        return new ListCategoryListCellHolder(v);
    }

    public void onBindViewHolder(@NonNull ListCategoryListCellHolder holder, int position) {
        holder.textView_categoryName.setText(dataSource[position].getTitle());
    }

    @Override
    public int getItemCount() {
        if (dataSource != null) {
            return dataSource.length;
        }
        return 0;
    }
}
