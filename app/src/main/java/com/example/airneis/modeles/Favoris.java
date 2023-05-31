package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Favoris {

    @SerializedName("categorie1")
    Categorie categorie1;
    @SerializedName("categorie2")
    Categorie categorie2;
    @SerializedName("categorie3")
    Categorie categorie3;
    @SerializedName("produit1")
    Produit produit1;
    @SerializedName("produit2")
    Produit produit2;
    @SerializedName("produit3")
    Produit produit3;
    @SerializedName("caroussel1")
    String caroussel1;
    @SerializedName("caroussel2")
    String caroussel2;
    @SerializedName("caroussel3")
    String caroussel3;

    public Favoris(Categorie categorie1, Categorie categorie2, Categorie categorie3, Produit produit1, Produit produit2, Produit produit3, String caroussel1, String caroussel2, String caroussel3) {
        this.categorie1 = categorie1;
        this.categorie2 = categorie2;
        this.categorie3 = categorie3;
        this.produit1 = produit1;
        this.produit2 = produit2;
        this.produit3 = produit3;
        this.caroussel1 = caroussel1;
        this.caroussel2 = caroussel2;
        this.caroussel3 = caroussel3;
    }

    public Categorie getCategorie1() {
        return categorie1;
    }

    public Categorie getCategorie2() {
        return categorie2;
    }

    public Categorie getCategorie3() {
        return categorie3;
    }

    public Produit getProduit1() {
        return produit1;
    }

    public Produit getProduit2() {
        return produit2;
    }

    public Produit getProduit3() {
        return produit3;
    }

    public String getCaroussel1() {
        return caroussel1;
    }

    public String getCaroussel2() {
        return caroussel2;
    }

    public String getCaroussel3() {
        return caroussel3;
    }

    public void setCaroussel1(String caroussel1) {
        this.caroussel1 = caroussel1;
    }

    public void setCaroussel2(String caroussel2) {
        this.caroussel2 = caroussel2;
    }

    public void setCaroussel3(String caroussel3) {
        this.caroussel3 = caroussel3;
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
