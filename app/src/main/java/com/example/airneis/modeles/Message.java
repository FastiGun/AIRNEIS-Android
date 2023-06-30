package com.example.airneis.modeles;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("email")
    String mail;

    @SerializedName("sujet")
    String object;

    @SerializedName("contenu")
    String content;

    public Message(String mail, String object, String content) {
        this.mail = mail;
        this.object = object;
        this.content = content;
    }

    public String get_mail() {

        return mail;
    }
    public void setMail(String mail) {

        this.mail = mail;
    }

    public String get_object() {

        return object;
    }
    public void setObject(String object) {

        this.object = object;
    }

    public String get_content() {

        return content;
    }
    public void setContent(String content) {

        this.content = content;
    }
}
