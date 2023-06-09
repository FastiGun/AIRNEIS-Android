package com.example.airneis;

import java.util.ArrayList;

public interface RedirectionInterface {
    void redirectToFragment(String fragmentName) throws RuntimeException;
    void connexion(String mail, String mdp);
    void passwordForgotten(String mail);
    void registration(String lastName, String name, String email, String mdp );
    void onCategoryClickButton();
    void onAddressClickButton(String token, String id);
    void onPaymentClickButton(String token, String id);
    void onHistoryOrderClickButton(String _id, String token);
    void saveAccount(String token, String id, String lastName, String name, String numberPhone);
    void saveAddress(String token, String id, String name, String street, String city, String zipCode, String country, String region, String complement);
    void deleteAddress(String token, String id);
    void saveMessage(String token, String email, String object, String content);
    void onCategoryClick(String categorie);
    void onProductClick(String id);
    void addProductToCart(String _id);

    void switchToFacturation(ArrayList<String> deliveryAddress);
    void switchToPayment(ArrayList<String> deliveryAddress, ArrayList<String> facturationAddress);
}
