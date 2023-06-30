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

public class LoginFragment extends Fragment {

    TextView text_loginRedirection2;
    TextView editText_loginEmail;
    TextView editText_loginPassword;
    Button button_login;
    RedirectionInterface redirectionInterface;
    TextView password_forgotten;

    public LoginFragment(RedirectionInterface listener){
        this.redirectionInterface = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text_loginRedirection2 = view.findViewById(R.id.text_loginRedirection2);
        button_login = view.findViewById(R.id.button_login);
        editText_loginPassword = view.findViewById(R.id.editText_loginPassword);
        editText_loginEmail = view.findViewById(R.id.editText_loginEmail);
        password_forgotten = view.findViewById(R.id.textView_passwordForgotten);

        text_loginRedirection2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                redirectionInterface.redirectToFragment("inscription");
            }
        });

        if (password_forgotten != null) {
            password_forgotten.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    redirectionInterface.passwordForgotten(editText_loginEmail.getText().toString());
                }
            });
        }

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.connexion(editText_loginEmail.getText().toString(), editText_loginPassword.getText().toString());

            }
        });
    }
}
