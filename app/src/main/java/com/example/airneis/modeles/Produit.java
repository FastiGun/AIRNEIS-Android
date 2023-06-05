package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Produit {

    @SerializedName("_id")
    String _id;
    @SerializedName("nom")
    String nom;
    @SerializedName("prix")
    float prix;
    @SerializedName("stock")
    int stock;
    @SerializedName("description")
    String description;
    @SerializedName("categorie")
    String categorie;
    @SerializedName("image1")
    String image1;
    @SerializedName("image2")
    String image2;
    @SerializedName("image3")
    String image3;
    @SerializedName("image4")
    String image4;

    public Produit(String _id, String nom, float prix, int stock, String description, String categorie,
                   String image1, String image2, String image3, String image4) {
        this._id = _id;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.description = description;
        this.categorie = categorie;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
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

    public String getCategorie() {

        return categorie;
    }

    public void setCategorie(String categorie) {

        this.categorie = categorie;
    }


    public String getImage1() {

        return image1;
    }

    public void setImage1(String image1) {

        this.image1 = image1;
    }

    public String getImage2() {

        return image2;
    }

    public void setImage2(String image2) {

        this.image2 = image2;
    }

    public String getImage3() {

        return image3;
    }

    public void setImage3(String image3) {

        this.image3 = image3;
    }

    public String getImage4() {

        return image4;
    }

    public void setImage4(String image4) {

        this.image4 = image4;
    }
}
