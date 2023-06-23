package com.example.airneis;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAddressListCellHolder extends  RecyclerView.ViewHolder{

    TextView nameAddress;
    TextView streetAddress;
    TextView cityAddress;

    public ListAddressListCellHolder(@NonNull View itemView) {
        super(itemView);
        nameAddress = itemView.findViewById(R.id.textView_addressNameList);
        streetAddress = itemView.findViewById(R.id.textView_addressStreet);
        cityAddress = itemView.findViewById(R.id.textView_addressCity);
    }
}
