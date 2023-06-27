package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Commande {
    @SerializedName("_id")
    String _id;
    @SerializedName("nom")
    String nom;
    @SerializedName("prenom")
    String prenom;
    @SerializedName("telephone")
    String telephone;
    @SerializedName("date")
    String date;
    @SerializedName("prixHT")
    float prixHT;
    @SerializedName("prixTTC")
    float prixTTC;
    @SerializedName("statut")
    String statut;
    @SerializedName("produits")
    Produit[] produits;
    @SerializedName("adresseFacturation")
    Adresse adresseFacturation;
    @SerializedName("adresseLivraison")
    Adresse adresseLivraison;
    @SerializedName("client")
    Client client;

    public Commande(String id, String nom, String prenom, String telephone, String date, float prixHT, float prixTTC, String statut, Produit[] produits, Adresse adresseFacturation, Adresse adresseLivraison, Client client) {
        this._id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.date = date;
        this.prixHT = prixHT;
        this.prixTTC = prixTTC;
        this.statut = statut;
        this.produits = produits;
        this.adresseFacturation = adresseFacturation;
        this.adresseLivraison = adresseLivraison;
        this.client = client;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Produit[] getProduits() {
        return produits;
    }

    public void setProduits(Produit[] produits) {
        this.produits = produits;
    }

    public Adresse getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(Adresse adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(Adresse adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
