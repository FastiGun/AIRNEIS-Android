package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Panier {

    @SerializedName("_id")
    String _id;
    @SerializedName("produits")
    Produit[] produits;
    @SerializedName("prixHT")
    float prixHT;
    @SerializedName("prixTTC")
    float prixTTC;

    public Panier(String id, Produit[] produits, float prixHT, float prixTTC) {
        this._id = id;
        this.produits = produits;
        this.prixHT = prixHT;
        this.prixTTC = prixTTC;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public Produit[] getProduits() {
        return produits;
    }

    public void setProduits(Produit[] produits) {
        this.produits = produits;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public float getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(float prixTTC) {
        this.prixTTC = prixTTC;
    }
}
