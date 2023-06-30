package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Panier {

    @SerializedName("_id")
    String _id;
    @SerializedName("article")
    Produit article;
    @SerializedName("quantite")
    int quantite;
    @SerializedName("client")
    String client;


    public Panier(String id, Produit article, int quantite, String client) {
        this._id = id;
        this.article = article;
        this.quantite = quantite;
        this.client = client;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public Produit getProduit() {
        return article;
    }

    public void setProduit(Produit article) {
        this.article = article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getClient() {
        return client;
    }

    public void setPrixTTC(String client) {
        this.client = client;
    }
}
