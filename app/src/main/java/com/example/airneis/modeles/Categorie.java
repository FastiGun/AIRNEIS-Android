package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Categorie {

    @SerializedName("_id")
    String _id;
    @SerializedName("nom")
    String nom;
    @SerializedName("image")
    String image;

    public Categorie(String id, String nom, String image) {
        this._id = id;
        this.nom = nom;
        this.image = image;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getNom() {return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {return image;
    }

    public void setImage(String image) { this.image =image;
    }
}
