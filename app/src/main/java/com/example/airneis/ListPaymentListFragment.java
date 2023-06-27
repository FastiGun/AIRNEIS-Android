package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.modeles.Paiement;

public class ListPaymentListFragment extends Fragment {

    Paiement[] dataSource;
    RecyclerView recyclerView;
    RecyclerView.Adapter listPaymentListAdapteur;
    RecyclerView.LayoutManager layoutManager;
    ListPaymentListListener listPaymentListListener;

    public ListPaymentListFragment(Paiement[] dataSource, ListPaymentListListener listener){
        this.dataSource = dataSource;
        this.listPaymentListListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payment_list_account, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.paymentAccount_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        AuthentificationClass authentification = new AuthentificationClass(this.getContext());
        String token = authentification.getAuthToken();
        listPaymentListAdapteur = new ListPaymentListAdapteur(dataSource, listPaymentListListener, token);
        recyclerView.setAdapter(listPaymentListAdapteur);
    }
}


