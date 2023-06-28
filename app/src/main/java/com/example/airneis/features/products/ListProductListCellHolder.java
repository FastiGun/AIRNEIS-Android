package com.example.airneis.features.products;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;

public class ListProductListCellHolder extends RecyclerView.ViewHolder {

    ImageView productPhotoImageView;
    TextView productNameTextView;
    TextView priceTagTextView;

    public ListProductListCellHolder(@NonNull View itemView) {
        super(itemView);
        productPhotoImageView = itemView.findViewById(R.id.productPhotoImageView);
        productNameTextView = itemView.findViewById(R.id.productNameTextView);
        priceTagTextView = itemView.findViewById(R.id.priceTagTextView);
    }
}
