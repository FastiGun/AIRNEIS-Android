package com.example.airneis.modeles;

public class Favoris {

    Categorie categorie1;
    Categorie categorie2;
    Categorie categorie3;
    Produit produit1;
    Produit produit2;
    Produit produit3;

    public Favoris(Categorie categorie1, Categorie categorie2, Categorie categorie3, Produit produit1, Produit produit2, Produit produit3) {
        this.categorie1 = categorie1;
        this.categorie2 = categorie2;
        this.categorie3 = categorie3;
        this.produit1 = produit1;
        this.produit2 = produit2;
        this.produit3 = produit3;
    }

    public void setCategorie1(Categorie categorie1) {
        this.categorie1 = categorie1;
    }

    public void setCategorie2(Categorie categorie2) {
        this.categorie2 = categorie2;
    }

    public void setCategorie3(Categorie categorie3) {
        this.categorie3 = categorie3;
    }

    public void setProduit1(Produit produit1) {
        this.produit1 = produit1;
    }

    public void setProduit2(Produit produit2) {
        this.produit2 = produit2;
    }

    public void setProduit3(Produit produit3) {
        this.produit3 = produit3;
    }
}
