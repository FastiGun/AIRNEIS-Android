package com.example.airneis.modeles;

import java.util.List;

public class Commande {
    int id;
    String date;
    float prixHT;
    float prixTTC;
    String statut;
    List<Produit> produits;
    Adresse adresseFacturation;
    Adresse adresseLivraison;
    Client client;

    public Commande(int id, String date, float prixHT, float prixTTC, String statut, List<Produit> produits, Adresse adresseFacturation, Adresse adresseLivraison, Client client) {
        this.id = id;
        this.date = date;
        this.prixHT = prixHT;
        this.prixTTC = prixTTC;
        this.statut = statut;
        this.produits = produits;
        this.adresseFacturation = adresseFacturation;
        this.adresseLivraison = adresseLivraison;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
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
