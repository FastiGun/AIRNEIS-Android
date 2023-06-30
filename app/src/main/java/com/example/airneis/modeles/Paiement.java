package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Paiement {

    @SerializedName("_id")
    String _id;
    @SerializedName("client")
    String idClient;
    @SerializedName("libelle_carte")
    String libelle;
    @SerializedName("nom_carte")
    String nom;
    @SerializedName("date_expiration")
    String date;
    @SerializedName("num_carte")
    String num;
    @SerializedName("cvv")
    String cvv;
    @SerializedName("__v")
    String __v;

    public Paiement(String id, String idClient, String libelle, String nom, String num, String date, String cvv, String __v) {
        this._id = id;
        this.idClient = idClient;
        this.libelle = libelle;
        this.nom = nom;
        this.num = num;
        this.date = date;
        this.cvv = cvv;
        this.__v = __v;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String get__v() {
        return __v;
    }
    public void set__v(String __v) {
        this.__v = __v;
    }
}
