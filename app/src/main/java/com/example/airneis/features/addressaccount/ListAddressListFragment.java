package com.example.airneis.features.addressaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.AuthentificationClass;
import com.example.airneis.R;
import com.example.airneis.modeles.Adresse;

public class ListAddressListFragment extends Fragment {

    Adresse[] dataSource;
    RecyclerView recyclerView;
    RecyclerView.Adapter listAddressListAdapteur;
    RecyclerView.LayoutManager layoutManager;
    ListAddressListListener listAddressListListener;

    public ListAddressListFragment(Adresse[] dataSource, ListAddressListListener listener){
        this.dataSource = dataSource;
        this.listAddressListListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_address_list_account, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.addressAccount_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        AuthentificationClass authentification = new AuthentificationClass(this.getContext());
        String token = authentification.getAuthToken();
        listAddressListAdapteur = new ListAddressListAdapteur(dataSource, listAddressListListener, token);
        recyclerView.setAdapter(listAddressListAdapteur);
    }
}
