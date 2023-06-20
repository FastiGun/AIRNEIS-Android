package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Adresse {

    @SerializedName("_id")
    String _id;
    @SerializedName("nom")
    String nom;
    @SerializedName("rue")
    String rue;
    @SerializedName("ville")
    String ville;
    @SerializedName("cp")
    String cp;
    @SerializedName("complement")
    String complement;

    public Adresse(String id, String nom, String rue, String ville, String cp, String complement) {
        this._id = id;
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.complement = complement;
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

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
