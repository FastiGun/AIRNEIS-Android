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

import com.example.airneis.modeles.Client;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountFragment extends Fragment {

    RedirectionInterface redirectionInterface;
    TextView editText_lastName;
    TextView editText_name;
    TextView textView_mail2;
    TextView editText_password;
    TextView editText_numberPhone;
    Button button_save;

    public AccountFragment(RedirectionInterface listener){
        this.redirectionInterface = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText_lastName = view.findViewById(R.id.editText_lastName);
        editText_name = view.findViewById(R.id.editText_name);
        textView_mail2 = view.findViewById(R.id.textView_mail2);
        editText_password = view.findViewById(R.id.editText_password);
        button_save = view.findViewById(R.id.button_save);
        editText_numberPhone = view.findViewById(R.id.editText_numberPhone);
        AuthentificationClass authentification = new AuthentificationClass(this.getContext());
        String token = authentification.getAuthToken();
        String _id = authentification.getAuthId();

        getAccount(_id, token);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.saveAccount(_id, token, editText_lastName.getText().toString(), editText_name.getText().toString(), editText_numberPhone.getText().toString());
            }
        });
    }

    public void getAccount(String _id, String token) {
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Client> callClient = webServicesInterface.getClient(_id, token);

        callClient.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                editText_lastName.setText(response.body().getPrenom());
                editText_name.setText(response.body().getNom());
                textView_mail2.setText(response.body().getMail());
                editText_numberPhone.setText(response.body().getTelephone());
            }


            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("404", "Error when get information");
                Log.e("404", t.getMessage());
            }
        });

    }
}
