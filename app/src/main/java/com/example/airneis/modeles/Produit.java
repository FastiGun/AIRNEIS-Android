package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Produit {

    @SerializedName("id")
    int id;
    @SerializedName("nom")
    String nom;
    @SerializedName("prix")
    float prix;
    @SerializedName("stock")
    int stock;
    @SerializedName("description")
    String description;
    @SerializedName("categorie")
    Categorie categorie;
    @SerializedName("quantite")
    int quantite;

    String photo;

    public Produit(int _id, String nom, float prix, int stock, String description, Categorie categorie, String photo) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.description = description;
        this.categorie = categorie;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
