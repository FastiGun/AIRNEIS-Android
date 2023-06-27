package com.example.airneis;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.modeles.Paiement;

public class ListPaymentListAdapteur extends RecyclerView.Adapter<ListPaymentListCellHolder> {

    Paiement[] dataSource;
    ListPaymentListListener listPaymentListListener;
    String token;

    public ListPaymentListAdapteur(Paiement[] dataSource, ListPaymentListListener listener, String token) {
        this.dataSource = dataSource;
        this.listPaymentListListener = listener;
        this.token = token;
    }

    @NonNull
    @Override
    public ListPaymentListCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_list_cell, parent, false);
        return new ListPaymentListCellHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPaymentListCellHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.namePayment.setText(dataSource[position].getLibelle());
        holder.nameUserPayment.setText(dataSource[position].getNom());
        holder.dateExpirationPayment.setText(dataSource[position].getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPaymentListListener.onPaymentClick(dataSource[position].getId(), token);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (dataSource != null) {
            return dataSource.length;
        }
        return 0;
    }

    {
    }
}
