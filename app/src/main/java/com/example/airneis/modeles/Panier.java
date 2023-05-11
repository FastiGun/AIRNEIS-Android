package com.example.airneis.modeles;

import java.util.List;

public class Panier {

    int id;
    List<Produit> produits;
    float prixHT;
    float prixTTC;

    public Panier(int id, List<Produit> produits, float prixHT, float prixTTC) {
        this.id = id;
        this.produits = produits;
        this.prixHT = prixHT;
        this.prixTTC = prixTTC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
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
