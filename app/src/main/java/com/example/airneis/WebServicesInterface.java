package com.example.airneis;

import com.example.airneis.modeles.Adresse;
import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Client;
import com.example.airneis.modeles.Paiement;
import com.example.airneis.modeles.Panier;
import com.example.airneis.modeles.Produit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServicesInterface {

    @GET("categories/{categorie}/produits")
    Call<Produit[]> getListProduct(@Path("categorie") String categorie);

    @GET("categories")
    Call<Categorie[]> getListCategory();

    @GET("connexion")
    Call<Client> getConnexion();

    @POST("inscription")
    Call<Client>getInscription();

    @GET("produits")
    Call<Produit[]>getProductList();

    @GET("produits/{id}")
    Call<Produit>getProduct(@Path("id") String _id);

    @GET("client")
    Call<Client[]>getClientList();

    @GET("client/:clientId")
    Call<Client>getClient();

    @GET("client/:clientId/adresses")
    Call<Adresse>getAddressClient();

    @GET("client/:clientId/paiements")
    Call<Paiement>getPaiementClient();

    @GET("clients/:clientId/paniers")
    Call<Panier>getPanierClient();

}
