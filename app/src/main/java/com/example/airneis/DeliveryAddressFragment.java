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

public class DeliveryAddressFragment extends Fragment {

    EditText addressName_editTextText;
    EditText lastNameDeliveryPage_editTextText;
    EditText nameDeliveryPage_editTextText;
    EditText address1DeliveryPage_editTextText;
    EditText address2DeliveryPage_editTextText;
    EditText cityDeliveryPage_editTextText;
    EditText zipCodeDeliveryPage_editTextText;
    EditText paysDeliveryAddressEditText;
    EditText regionDeliveryAddressEditText;
    Button GoToFacturation;

    ArrayList<String> deliveryAddress = new ArrayList<String>();

    RedirectionInterface redirectionInterface;

    public DeliveryAddressFragment(RedirectionInterface redirectionInterface) {
        this.redirectionInterface = redirectionInterface;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_delivery, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addressName_editTextText = view.findViewById(R.id.addressName_editTextText);
        lastNameDeliveryPage_editTextText = view.findViewById(R.id.lastNameDeliveryPage_editTextText);
        nameDeliveryPage_editTextText = view.findViewById(R.id.nameDeliveryPage_editTextText);
        address1DeliveryPage_editTextText = view.findViewById(R.id.address1DeliveryPage_editTextText);
        address2DeliveryPage_editTextText = view.findViewById(R.id.address2DeliveryPage_editTextText);
        cityDeliveryPage_editTextText = view.findViewById(R.id.cityDeliveryPage_editTextText);
        zipCodeDeliveryPage_editTextText = view.findViewById(R.id.zipCodeDeliveryPage_editTextText);
        paysDeliveryAddressEditText = view.findViewById(R.id.paysDeliveryAddressEditText);
        regionDeliveryAddressEditText = view.findViewById(R.id.regionDeliveryAddressEditText);
        GoToFacturation = view.findViewById(R.id.GoToFacturation);

        GoToFacturation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deliveryAddress.add(String.valueOf(addressName_editTextText.getText()));
                deliveryAddress.add(String.valueOf(lastNameDeliveryPage_editTextText.getText()));
                deliveryAddress.add(String.valueOf(nameDeliveryPage_editTextText.getText()));
                deliveryAddress.add(String.valueOf(address1DeliveryPage_editTextText.getText()));
                deliveryAddress.add(String.valueOf(address2DeliveryPage_editTextText.getText()));
                deliveryAddress.add(String.valueOf(cityDeliveryPage_editTextText.getText()));
                deliveryAddress.add(String.valueOf(zipCodeDeliveryPage_editTextText.getText()));
                deliveryAddress.add(String.valueOf(paysDeliveryAddressEditText.getText()));
                deliveryAddress.add(String.valueOf(regionDeliveryAddressEditText.getText()));

                redirectionInterface.switchToFacturation(deliveryAddress);
            }
        });
    }
}
