package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    TextView text_loginRedirection2;

    RedirectionInterface redirectionInterface;

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
        text_loginRedirection2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.redirectToInscription();
            }
        });
    }
}
