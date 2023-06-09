package com.example.airneis.modeles;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class Categorie {

    @SerializedName("_id")
    private String _id;
    @SerializedName("nom")
    private String nom;
    @SerializedName("image")
    private String image;

    public Categorie(String id, String nom, String image) {
        this._id = id;
        this.nom = nom;
        this.image = image;
    }

    public String get_id() {

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image =image;
    }
}
