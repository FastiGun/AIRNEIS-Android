package com.example.airneis;

import com.example.airneis.modeles.Adresse;
import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Client;
import com.example.airneis.modeles.Commande;
import com.example.airneis.modeles.Favoris;
import com.example.airneis.modeles.Message;
import com.example.airneis.modeles.Paiement;
import com.example.airneis.modeles.Panier;
import com.example.airneis.modeles.Produit;

import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface WebServicesInterface {

    @GET("categories/{categorie}/produits")
    Call<Produit[]> getListProduct(@Path("categorie") String categorie);

    @GET("categories")
    Call<Categorie[]> getListCategory();

    @GET("categorie/{idCategory}")
    Call<Categorie> getCategory(@Path("idCategory") String _id);

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

    @GET("adresses/{idAddress}")
    Call<Adresse>getAddress(@Path("idAddress") String _id, @Header("Authorization") String token);

    @GET("client")
    Call<Client[]>getClientList();

    @GET("client/{id}")
    Call<Client>getClient(@Path("id") String _id, @Header("Authorization") String token );

     @POST("client/{id}")
     @FormUrlEncoded
     Call<Client>postClient(@Path("id") String _id, @Header("Authorization") String token, @Field("prenom") String lastName, @Field("nom") String name, @Field("telephone") String numberPhone);

    @GET("client/{clientId}/adresses")
    Call<Adresse[]>getAddressClient(@Path("clientId") String _id, @Header("Authorization") String token);

    @PUT("adresses/{idAddress}")
    @FormUrlEncoded
    Call<Adresse>postAddressClient(@Path("idAddress") String _id, @Header("Authorization") String token, @Field("nom") String nameAddress, @Field("rue")String street, @Field("ville")String city,
                                   @Field("cp") String zipCode,@Field("pays")String country, @Field("region")String region, @Field("complement") String complement);

    @GET("client/{clientId}/paiements")
    Call<Paiement[]>getPaymentClient(@Path("clientId") String _id, @Header("Authorization") String token);

    @GET("clients/{clientId}/paniers")
    Call<Panier[]>getPanierClient(@Path("clientId") String _id, @Header("Authorization") String token);

    @DELETE("/api/panier/{idPanier}")
    Call<Panier>deleteCart(@Path("idPanier") String _id, @Header("Authorization") String token);

    @POST("api/add-produit-panier/{client}/{article}")
    Call<Produit>addProductToCart(@Path("client") String _id, @Path("article") String article, @Header("Authorization") String token);

    @DELETE("paiements/{idPaiement}")
    Call<Paiement>deletePaiement(@Path("idPaiement") String _id, @Header("Authorization") String token);

    @DELETE("adresses/{idAdresses}")
    Call<Adresse>deleteAddress(@Path("idAdresses") String _id, @Header("Authorization") String token);

    @GET("orders/{idClient}")
    Call<Commande[]>getOrdersList(@Path("idClient") String _id, @Header("Authorization") String token);

    @GET("orders/details/{idCommande}")
    Call<Commande>getOrder(@Path("idCommande") String _id, @Header("Authorization") String token);

    @POST("contact")
    @FormUrlEncoded
    Call<Message>postMessage(@Header("Authorization") String token, @Field("email") String email, @Field("sujet") String object, @Field("contenu") String content);

    @GET("favoris")
    Call<Favoris>getTop();

}
