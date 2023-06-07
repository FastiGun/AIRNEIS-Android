package com.example.airneis;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthentificationClass {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public AuthentificationClass(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("SessionPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public void saveAuthToken(String token) {
        editor.putString("AuthToken", token);
        editor.apply();
    }
    public void saveAuthId(String _id) {
        editor.putString("AuthId", _id);
        editor.apply();
    }

    public String getAuthToken() {
        return sharedPreferences.getString("AuthToken", null);
    }

    public String getAuthId() {
        return sharedPreferences.getString("AuthId", null);
    }

    public void clearAuthToken() {
        editor.remove("AuthToken");
        editor.apply();
    }

    public void clearAuthId() {
        editor.remove("AuthId");
        editor.apply();
    }
}
