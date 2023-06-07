package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Client {
    @SerializedName("_id")
    String _id;
    @SerializedName("nom")
    String nom;
    @SerializedName("prenom")
    String prenom;
    @SerializedName("mail")
    String mail;
    @SerializedName("motDePasse")
    String mdp;
    @SerializedName("adresses")
    Adresse[] adresses;
    @SerializedName("paiements")
    Paiement[] paiements;
    @SerializedName("panier")
    Panier panier;
    @SerializedName("telephone")
    String telephone;
    @SerializedName("token")
    String token;

    public Client(String _id, String nom, String prenom, String mail, String mdp, Adresse[] adresses,
                  Paiement[] paiements, Panier panier, String telephone, String token) {
        this._id = _id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
        this.adresses = adresses;
        this.paiements = paiements;
        this.panier = panier;
        this.telephone = telephone;
        this.token = token;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Adresse[] getAdresses() {
        return adresses;
    }

    public void setAdresses(Adresse[] adresses) {
        this.adresses = adresses;
    }

    public Paiement[] getPaiements() {
        return paiements;
    }

    public void setPaiements(Paiement[] paiements) {
        this.paiements = paiements;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
