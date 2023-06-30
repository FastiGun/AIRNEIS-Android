package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FacturationAddressFragment extends Fragment {

    EditText addressName_editTextText;
    EditText lastNameFacturationPage_editTextText;
    EditText nameFacturationPage_editTextText;
    EditText address1FacturationPage_editTextText;
    EditText address2FacturationPage_editTextText;
    EditText cityFacturationPage_editTextText;
    EditText zipCodeFacturationPage_editTextText;
    EditText paysFacturationAddressEditText;
    EditText regionFacturationAddressEditText;
    Button GoToPayment;

    ArrayList<String> facturationAddress = new ArrayList<String>();

    RedirectionInterface redirectionInterface;

    ArrayList<String> deliveryAddress;

    public FacturationAddressFragment(RedirectionInterface redirectionInterface, ArrayList<String> deliveryAddress) {
        this.redirectionInterface = redirectionInterface;
        this.deliveryAddress = deliveryAddress;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_facturation, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addressName_editTextText = view.findViewById(R.id.addressFacturationName_editTextText);
        lastNameFacturationPage_editTextText = view.findViewById(R.id.lastNameFacturationPage_editTextText);
        nameFacturationPage_editTextText = view.findViewById(R.id.nameFacturationPage_editTextText);
        address1FacturationPage_editTextText = view.findViewById(R.id.address1FacturationPage_editTextText);
        address2FacturationPage_editTextText = view.findViewById(R.id.address2FacturationPage_editTextText);
        cityFacturationPage_editTextText = view.findViewById(R.id.cityFacturationPage_editTextText);
        zipCodeFacturationPage_editTextText = view.findViewById(R.id.zipCodeFacturationPage_editTextText);
        paysFacturationAddressEditText = view.findViewById(R.id.paysFacturationAddressEditText);
        regionFacturationAddressEditText = view.findViewById(R.id.regionFacturationAddressEditText);
        GoToPayment = view.findViewById(R.id.GoToPayment);

        GoToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facturationAddress.add(String.valueOf(addressName_editTextText.getText()));
                facturationAddress.add(String.valueOf(lastNameFacturationPage_editTextText.getText()));
                facturationAddress.add(String.valueOf(nameFacturationPage_editTextText.getText()));
                facturationAddress.add(String.valueOf(address1FacturationPage_editTextText.getText()));
                facturationAddress.add(String.valueOf(address2FacturationPage_editTextText.getText()));
                facturationAddress.add(String.valueOf(cityFacturationPage_editTextText.getText()));
                facturationAddress.add(String.valueOf(zipCodeFacturationPage_editTextText.getText()));
                facturationAddress.add(String.valueOf(paysFacturationAddressEditText.getText()));
                facturationAddress.add(String.valueOf(regionFacturationAddressEditText.getText()));

                redirectionInterface.switchToPayment(deliveryAddress, facturationAddress);
            }
        });
    }
}
