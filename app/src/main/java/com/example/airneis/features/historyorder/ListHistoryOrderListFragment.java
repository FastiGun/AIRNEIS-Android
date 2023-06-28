package com.example.airneis.features.historyorder;

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
import com.example.airneis.modeles.Commande;

public class ListHistoryOrderListFragment extends Fragment {

    Commande[] dataSource;
    RecyclerView recyclerView;
    RecyclerView.Adapter listHistoryOrderListAdapteur;
    RecyclerView.LayoutManager layoutManager;
    ListHistoryOrderListListener listHistoryOrderListListener;

    public ListHistoryOrderListFragment(Commande[] dataSource, ListHistoryOrderListListener listener){
        this.dataSource = dataSource;
        this.listHistoryOrderListListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history_order_list_account, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.orderHistory_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        AuthentificationClass authentification = new AuthentificationClass(this.getContext());
        String token = authentification.getAuthToken();
        String _id = authentification.getAuthId();
        listHistoryOrderListAdapteur = new ListHistoryOrderListAdapteur(dataSource, listHistoryOrderListListener, token, _id);
        recyclerView.setAdapter(listHistoryOrderListAdapteur);
    }
}
