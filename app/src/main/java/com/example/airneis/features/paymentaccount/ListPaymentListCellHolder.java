package com.example.airneis.features.paymentaccount;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;

public class ListPaymentListCellHolder extends RecyclerView.ViewHolder{

    TextView namePayment;
    TextView nameUserPayment;
    TextView dateExpirationPayment;

    public ListPaymentListCellHolder(@NonNull View itemView) {
        super(itemView);
        namePayment = itemView.findViewById(R.id.textView_paymentName);
        nameUserPayment = itemView.findViewById(R.id.textView_paymentUserName);
        dateExpirationPayment = itemView.findViewById(R.id.textView_dateCard);
    }
}
