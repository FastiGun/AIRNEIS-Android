package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Favoris {
    @SerializedName("categorie1")
    String categorie1;
    @SerializedName("categorie2")
    String categorie2;
    @SerializedName("categorie3")
    String categorie3;
    @SerializedName("produit1")
    String produit1;
    @SerializedName("produit2")
    String produit2;
    @SerializedName("produit3")
    String produit3;
    @SerializedName("photo1")
    String picture1;
    @SerializedName("photo2")
    String picture2;
    @SerializedName("photo3")
    String picture3;

    public Favoris(String categorie1, String categorie2, String categorie3, String produit1, String produit2, String produit3, String picture1, String picture2, String picture3) {
        this.categorie1 = categorie1;
        this.categorie2 = categorie2;
        this.categorie3 = categorie3;
        this.produit1 = produit1;
        this.produit2 = produit2;
        this.produit3 = produit3;
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.picture3 = picture3;
    }

    public String[] getCategories() {
        return new String[]{categorie1, categorie2, categorie3};
    }

    public String[] getProducts() {
        return new String[]{produit1, produit2, produit3};
    }
    public String getCategorie1() {
        return categorie1;
    }

    public String getCategorie2() {
        return categorie2;
    }

    public String getCategorie3() {
        return categorie3;
    }

    public String getProduit1() {
        return produit1;
    }

    public String getProduit2() {
        return produit2;
    }

    public String getProduit3() {
        return produit3;
    }

    public String getPicture1() {
        return picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public void setPicture2(String picture2) {this.picture2 = picture2;}

    public void setPicture3(String picture3) {this.picture3 = picture3;
    }

    public void setCategorie1(String categorie1) {
        this.categorie1 = categorie1;
    }

    public void setCategorie2(String categorie2) {
        this.categorie2 = categorie2;
    }

    public void setCategorie3(String categorie3) {
        this.categorie3 = categorie3;
    }

    public void setProduit1(String produit1) {
        this.produit1 = produit1;
    }

    public void setProduit2(String produit2) {
        this.produit2 = produit2;
    }

    public void setProduit3(String produit3) {
        this.produit3 = produit3;
    }
}
