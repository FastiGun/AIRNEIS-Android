package com.example.airneis.features.categories;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;

public class ListCategoryListCellHolder extends RecyclerView.ViewHolder {
    TextView textView_categoryName;

    public ListCategoryListCellHolder(@NonNull View itemView) {
        super(itemView);

        textView_categoryName = itemView.findViewById(R.id.textView_categoryName);

    }
}
