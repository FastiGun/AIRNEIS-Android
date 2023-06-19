package com.example.airneis;

public interface RedirectionInterface {
    void redirectToFragment(String fragmentName) throws RuntimeException;
    void connexion(String mail, String mdp);
    void registration(String lastName, String name, String email, String mdp );
    void onCategoryClickButton();
    void saveAccount(String token, String id, String lastName, String name, String numberPhone);
}
