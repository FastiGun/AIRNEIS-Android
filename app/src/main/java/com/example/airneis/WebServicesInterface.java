package com.example.airneis;

import com.example.airneis.modeles.Adresse;
import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Client;
import com.example.airneis.modeles.Paiement;
import com.example.airneis.modeles.Panier;
import com.example.airneis.modeles.Produit;

import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServicesInterface {

    @GET("categories/{categorie}/produits")
    Call<Produit[]> getListProduct(@Path("categorie") String categorie);

    @GET("categories")
    Call<Categorie[]> getListCategory();

    @POST("connexion")
    @FormUrlEncoded
    Call<Client> postConnexion(@Field("mail") String mail, @Field("motDePasse") String motDePasse);

    @POST("inscription")
    @FormUrlEncoded
    Call<Client>postInscription(@Field("prenom") String lastName, @Field("nom") String name, @Field("mail") String mail, @Field("motDePasse") String motDePasse);

    @GET("produits")
    Call<Produit[]>getProductList();

    @GET("produits/{id}")
    Call<Produit>getProduct(@Path("id") String _id);

    @GET("client")
    Call<Client[]>getClientList();

    @GET("client/{id}")
    Call<Client>getClient(@Path("id") String _id, @Header("Authorization") String token );

     @POST("client/{id}")
     @FormUrlEncoded
     Call<Client>postClient(@Path("id") String _id, @Header("Authorization") String token, @Field("prenom") String lastName, @Field("nom") String name, @Field("telephone") String numberPhone);

    @GET("client/{clientId}/adresses")
    Call<Adresse>getAddressClient();

    @GET("client/{clientId}/paiements")
    Call<Paiement>getPaiementClient();

    @GET("clients/{clientId}/paniers")
    Call<Panier>getPanierClient();

}
