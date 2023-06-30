package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AccountPageFragment extends Fragment {
    RedirectionInterface redirectionInterface;
    Button account;
    Button address;
    Button payment;
    Button order;

    public AccountPageFragment(RedirectionInterface listener){
        this.redirectionInterface = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_page, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        account = view.findViewById(R.id.button_access1);
        address = view.findViewById(R.id.button_access2);
        payment = view.findViewById(R.id.button_access3);
        order = view.findViewById(R.id.button_access4);
        AuthentificationClass authentification = new AuthentificationClass(this.getContext());
        String token = authentification.getAuthToken();
        String _id = authentification.getAuthId();

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                redirectionInterface.redirectToFragment("account");
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                redirectionInterface.onAddressClickButton(_id, token);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                redirectionInterface.onPaymentClickButton(_id, token);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                redirectionInterface.onHistoryOrderClickButton(_id, token);
            }
        });
    }
}
