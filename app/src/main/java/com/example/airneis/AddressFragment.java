package com.example.airneis;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.airneis.modeles.Adresse;
import com.example.airneis.modeles.Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    public AddressFragment(RedirectionInterface listener){
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
        AuthentificationClass authentification = new AuthentificationClass(this.getContext());
        String token = authentification.getAuthToken();
        String _id = authentification.getAuthId();

        getAddress(_id, token);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.saveAddress(_id, token, nameAddress.getText().toString(), streetAddress.getText().toString(), cityAddress.getText().toString(),
                        zipCodeAddress.getText().toString(),countryAddress.getText().toString(), regionAddress.getText().toString(), complementAddress.getText().toString());
            }
        });
    }


    public void getAddress(String _id, String token) {
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Adresse> callAddress = webServicesInterface.getAddressClient(_id, token);

        callAddress.enqueue(new Callback<Adresse>() {
            @Override
            public void onResponse(Call<Adresse> call, Response<Adresse> response) {
                nameAddress.setText(response.body().getNom());
                streetAddress.setText(response.body().getRue());
                cityAddress.setText(response.body().getVille());
                zipCodeAddress.setText(response.body().getCp());
                complementAddress.setText(response.body().getComplement());

            }


            @Override
            public void onFailure(Call<Adresse> call, Throwable t) {
                Log.e("404", "Error when get information");
                Log.e("404", t.getMessage());
            }
        });
    }
}
