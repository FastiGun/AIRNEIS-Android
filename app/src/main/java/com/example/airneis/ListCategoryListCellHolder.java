package com.example.airneis;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListCategoryListCellHolder extends RecyclerView.ViewHolder {
    TextView textView_categoryName;

    public ListCategoryListCellHolder(@NonNull View itemView) {
        super(itemView);

        textView_categoryName = itemView.findViewById(R.id.textView_categoryName);

    }
}
