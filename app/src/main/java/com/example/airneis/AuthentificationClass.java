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

    public String getAuthToken() {
        return sharedPreferences.getString("AuthToken", null);
    }

    public void clearAuthToken() {
        editor.remove("AuthToken");
        editor.apply();
    }
}
