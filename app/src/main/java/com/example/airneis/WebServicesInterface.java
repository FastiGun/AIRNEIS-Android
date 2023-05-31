package com.example.airneis;

import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Produit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServicesInterface {

    @GET("categories/categorie/produits")
    Call<Produit[]> getListProduct(@Query("categorie") String _id);

    @GET("categories")
    Call<Categorie[]> getListCategory();
}
