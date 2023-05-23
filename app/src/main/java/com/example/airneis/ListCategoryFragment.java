package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.airneis.modeles.Categorie;

public class ListCategoryFragment extends Fragment {

    Categorie[] dataSource;
    CategoryListListener categoryListListener;

    public ListCategoryFragment(Categorie[] dataSource, CategoryListListener listener){
        this.dataSource = dataSource;
        this.categoryListListener = listener;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_category, null);
    }

}
