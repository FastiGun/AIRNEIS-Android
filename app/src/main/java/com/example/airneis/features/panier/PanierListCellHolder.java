package com.example.airneis.features.panier;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;

public class PanierListCellHolder extends RecyclerView.ViewHolder{

    ImageView productBasketCell_imageView;

    TextView productNameBasketCell_textView;

    TextView productDescriptionBasketCell_textView;

    TextView productPriceBasketCell_textView;

    EditText productQuantityBasketCell_editTextNumber;

    ImageView deleteProduct_imageView;

    public PanierListCellHolder(@NonNull View itemView) {
        super(itemView);
        productBasketCell_imageView = itemView.findViewById(R.id.productBasketCell_imageView);
        productDescriptionBasketCell_textView = itemView.findViewById(R.id.productDescriptionBasketCell_textView);
        productNameBasketCell_textView = itemView.findViewById(R.id.productNameBasketCell_textView);
        productPriceBasketCell_textView = itemView.findViewById(R.id.productPriceBasketCell_textView);
        productQuantityBasketCell_editTextNumber = itemView.findViewById(R.id.productQuantityBasketCell_editTextNumber);
        deleteProduct_imageView = itemView.findViewById(R.id.deleteProduct_imageView);
    }
}
