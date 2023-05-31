package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.airneis.modeles.Categorie;

public class ListCategoryFragment extends Fragment{

    Categorie[] dataSource;
    RecyclerView recyclerView;
    RecyclerView.Adapter listCategoryListAdapteur;
    RecyclerView.LayoutManager layoutManager;
    ListCategoryListListener listCategoryListListener;


    public ListCategoryFragment(Categorie[] dataSource, ListCategoryListListener listener){
        this.dataSource = dataSource;
        this.listCategoryListListener= listener;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_category, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.listCategory_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        listCategoryListAdapteur = new ListCategoryListAdapteur(dataSource, listCategoryListListener);
        recyclerView.setAdapter(listCategoryListAdapteur);
    }
}
