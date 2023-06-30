package com.example.airneis.features.panier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;
import com.example.airneis.modeles.Panier;

import java.text.DecimalFormat;

public class PanierFragment extends Fragment {


    private static final DecimalFormat df = new DecimalFormat("0.00");
    RecyclerView recyclerView;

    RecyclerView.Adapter panierListAdapteur;

    RecyclerView.LayoutManager layoutManager;

    Panier[] dataSource;

    TextView priceTotalBasketPage_textView;

    TextView priceTvaBasketPage;

    PanierListListener panierListListener;


    public PanierFragment(Panier[] dataSource, PanierListListener panierListListener){
        this.dataSource = dataSource;
        this.panierListListener = panierListListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_panier, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.basketRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        panierListAdapteur = new PanierListAdapteur(dataSource, panierListListener);
        recyclerView.setAdapter(panierListAdapteur);
        priceTvaBasketPage = view.findViewById(R.id.priceTvaBasketPage);
        priceTotalBasketPage_textView = view.findViewById(R.id.priceTotalBasketPage_textView);

        float price = 0;
        for(Panier product: dataSource){
            price += product.getProduit().getPrix() * product.getQuantite();
        }

        priceTotalBasketPage_textView.setText(String.valueOf(price)+'€');
        priceTvaBasketPage.setText(String.valueOf(df.format(price*0.2))+"€");
    }
}
