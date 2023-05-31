package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Paiement {

    @SerializedName("_id")
    int _id;
    @SerializedName("libelle")
    String libelle;
    @SerializedName("nom")
    String nom;
    @SerializedName("num")
    String num;
    @SerializedName("date")
    String date;
    @SerializedName("cvv")
    String cvv;

    public Paiement(int id, String libelle, String nom, String num, String date, String cvv) {
        this._id = id;
        this.libelle = libelle;
        this.nom = nom;
        this.num = num;
        this.date = date;
        this.cvv = cvv;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
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
}
