package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Produit {

    @SerializedName("_id")
    private String _id;
    @SerializedName("nom")
    private String nom;
    @SerializedName("prix")
    private float prix;
    @SerializedName("stock")
    private int stock;
    @SerializedName("description")
    private String description;
    private @SerializedName("categorie")
    Categorie categorie;
    @SerializedName("quantite")
    private int quantite;

    String photo;

    public Produit(String _id, String nom, float prix, int stock, String description, Categorie categorie, String photo) {
        this._id = _id;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.description = description;
        this.categorie = categorie;
        this.photo = photo;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
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
