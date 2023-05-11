package com.example.airneis.modeles;

public class Adresse {

    int id;
    String nom;
    String rue;
    String ville;
    String cp;
    int num;
    String complement;

    public Adresse(int id, String nom, String rue, String ville, String cp, int num, String complement) {
        this.id = id;
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.num = num;
        this.complement = complement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
