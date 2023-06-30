package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Adresse {

    @SerializedName("_id")
    String _id;
    @SerializedName("client")
    String idClient;
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
    @SerializedName("pays")
    String pays;
    @SerializedName("region")
    String region;
    @SerializedName("__v")
    String __v;

    public Adresse(String _id, String idClient, String nom, String rue, String ville, String cp, String complement, String pays, String region, String __v) {
        this._id = _id;
        this.idClient = idClient;
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.complement = complement;
        this.pays = pays;
        this.region = region;
        this.__v = __v;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
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

    public String getPays() { return pays; }
    public void setPays(String pays) {this.pays = pays; }

    public String getRegion() { return region; }
    public void setRegion(String region) {this.region = region; }

    public String get__v() {
        return __v;
    }
    public void set__v(String __v) {
        this.__v = __v;
    }
}
