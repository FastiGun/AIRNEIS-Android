package com.example.airneis.features.products;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;
import com.example.airneis.WebServicesInterface;
import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Produit;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListProductFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter categoryListAdapteur;
    RecyclerView.LayoutManager layoutManager;


    ListProductListListener listProductListListener;
    Produit[] dataSource;

    public ListProductFragment(Produit[] dataSource, ListProductListListener listener){
        this.dataSource = dataSource;
        this.listProductListListener = listener;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, null);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.categoryListRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        categoryListAdapteur = new ListProductListAdapteur(dataSource, listProductListListener);
        recyclerView.setAdapter(categoryListAdapteur);
    }
}
