package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Produit;

public class CategoryFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter categoryListAdapteur;
    RecyclerView.LayoutManager layoutManager;

    RedirectionInterface redirectionListListener;
    Produit[] dataSource;

    public CategoryFragment(Produit[] dataSource, RedirectionInterface listener){
        this.dataSource = dataSource;
        this.redirectionListListener = listener;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.categoryListRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        categoryListAdapteur = new CategoryListAdapteur(dataSource, redirectionListListener);
        recyclerView.setAdapter(categoryListAdapteur);
    }
}
