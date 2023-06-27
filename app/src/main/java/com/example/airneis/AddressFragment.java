package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.airneis.modeles.Adresse;

public class AddressFragment extends Fragment {
    RedirectionInterface redirectionInterface;
    TextView nameAddress;
    TextView streetAddress;
    TextView cityAddress;
    TextView zipCodeAddress;
    TextView complementAddress;
    TextView countryAddress;
    TextView regionAddress;
    Button buttonSave;
    Adresse dataSource;


    public AddressFragment(Adresse dataSource, RedirectionInterface listener) {
        this.dataSource = dataSource;
        this.redirectionInterface = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_address_account, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameAddress = view.findViewById(R.id.editText_nameAddress);
        streetAddress = view.findViewById(R.id.editText_streetAddress);
        cityAddress = view.findViewById(R.id.editText_cityAddress);
        zipCodeAddress = view.findViewById(R.id.editText_zipCodeAddress);
        complementAddress = view.findViewById(R.id.editText_complementAddress);
        countryAddress = view.findViewById(R.id.editText_countryAddress);
        regionAddress = view.findViewById(R.id.editText_regionAddress);
        buttonSave = view.findViewById(R.id.button_saveAddress);
        nameAddress.setText(dataSource.getNom());
        streetAddress.setText(dataSource.getRue());
        cityAddress.setText(dataSource.getVille());
        zipCodeAddress.setText(dataSource.getCp());
        complementAddress.setText(dataSource.getComplement());
        countryAddress.setText(dataSource.getVille());
        regionAddress.setText(dataSource.getRegion());
        AuthentificationClass authentification = new AuthentificationClass(this.getContext());
        String token = authentification.getAuthToken();
        String _id = dataSource.getId();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.saveAddress(_id, token, nameAddress.getText().toString(), streetAddress.getText().toString(), cityAddress.getText().toString(),
                        zipCodeAddress.getText().toString(),countryAddress.getText().toString(), regionAddress.getText().toString(), complementAddress.getText().toString());
            }
        });
    }
}
