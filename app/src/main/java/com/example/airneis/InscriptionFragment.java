package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class InscriptionFragment extends Fragment {

    TextView text_registrationRedirection2;
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

        text_registrationRedirection2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.redirectToLogin();
            }
        });
    }
}
