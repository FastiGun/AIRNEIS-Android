package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Panier;
import com.example.airneis.modeles.Produit;

import org.w3c.dom.Text;

public class ProductFragment extends Fragment {

    TextView productName;
    TextView productPrice;
    TextView productStock;
    TextView productDescription;

    Button addToCart;

    private final Produit dataSource;

    RedirectionInterface redirectionInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, null);
    }

    public ProductFragment(Produit dataSource, RedirectionInterface redirectionInterface){
        this.dataSource = dataSource;
        this.redirectionInterface = redirectionInterface;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productName = view.findViewById(R.id.textView_productName);
        productPrice = view.findViewById(R.id.textView_productPrice);
        productStock = view.findViewById(R.id.textView_productStock);
        productDescription = view.findViewById(R.id.textView_productDescription);
        addToCart = view.findViewById(R.id.button_addToCart);
        productName.setText(dataSource.getNom());
        productPrice.setText(Float.toString(dataSource.getPrix()));
        productStock.setText(Integer.toString(dataSource.getStock()));
        productDescription.setText(dataSource.getDescription());

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.addProductToCart(dataSource.getId());
            }
        });

    }
}
