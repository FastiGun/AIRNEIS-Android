package com.example.airneis;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class InscriptionFragment extends Fragment {

    TextView text_registrationRedirection2;
    Button button_registration;
    TextView editText_registrationLastName;
    TextView editText_registrationName;
    TextView editText_registrationEmail;
    TextView editText_registrationPassword;
    RedirectionInterface redirectionInterface;

    public InscriptionFragment(RedirectionInterface listener){
        this.redirectionInterface = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inscription, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text_registrationRedirection2 = view.findViewById(R.id.text_registrationRedirection2);
        button_registration = view.findViewById(R.id.button_registration);
        editText_registrationLastName = view.findViewById(R.id.editText_registrationLastName);
        editText_registrationName = view.findViewById(R.id.editText_registrationName);
        editText_registrationEmail = view.findViewById(R.id.editText_registrationEmail);
        editText_registrationPassword = view.findViewById(R.id.editText_registrationPassword);

        editText_registrationPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                validatePassword(editable.toString());
            }
        });
        text_registrationRedirection2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.redirectToFragment("login");
            }
        });

        button_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.registration(editText_registrationLastName.getText().toString(), editText_registrationName.getText().toString(), editText_registrationEmail.getText().toString(), editText_registrationPassword.getText().toString());

            }
        });
    }

    private void validatePassword(String password) {
        if (password.length() < 8) {
            editText_registrationPassword.setError(getResources().getString(R.string.registration_errorLength));
            return;
        }
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
            editText_registrationPassword.setError(getResources().getString(R.string.registration_errorSpecialCharacter));
            return;
        }
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            editText_registrationPassword.setError(getResources().getString(R.string.registration_errorSpecialUpperCase));
            return;
        }
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            editText_registrationPassword.setError(getResources().getString(R.string.registration_errorSpecialNumber));
            return;
        }
        editText_registrationPassword.setError(null);
    }
}
