package com.example.airneis.modeles;

public class Produit {

    int id;
    String nom;
    float prix;
    int stock;
    String description;
    Categorie categorie;
    int quantite;

    String photo;

    public Produit(int id, String nom, float prix, int stock, String description, Categorie categorie, int quantite, String photo) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.description = description;
        this.categorie = categorie;
        this.quantite = quantite;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
