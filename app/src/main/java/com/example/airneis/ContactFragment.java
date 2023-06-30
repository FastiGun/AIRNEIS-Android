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

import org.w3c.dom.Text;

public class ContactFragment extends Fragment {

    TextView email;
    TextView object;
    TextView content;
    Button saveMessage;
    RedirectionInterface redirectionInterface;

    public ContactFragment(RedirectionInterface listener){
        this.redirectionInterface = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = view.findViewById(R.id.emailContactPage_editTextText);
        object = view.findViewById(R.id.objectContactPage_editTextText);
        content = view.findViewById(R.id.contentContactPage_editText);
        saveMessage = view.findViewById(R.id.sendContactPage_button);
        AuthentificationClass authentification = new AuthentificationClass(this.getContext());
        String token = authentification.getAuthToken();

        saveMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.saveMessage(token, email.getText().toString(), object.getText().toString(), content.getText().toString());
            }
        });

    }
}
