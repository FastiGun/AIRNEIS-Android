package com.example.airneis.features.historyorder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airneis.R;

import org.w3c.dom.Text;

public class ListHistoryOrderListCellHolder extends RecyclerView.ViewHolder {

    TextView dateOrder;
    TextView priceOrder;
    TextView statusOrder;

    public ListHistoryOrderListCellHolder(@NonNull View itemView) {
        super(itemView);

        dateOrder = itemView.findViewById(R.id.textView_dateOrder);
        priceOrder = itemView.findViewById(R.id.textView_priceOrder);
        statusOrder = itemView.findViewById(R.id.textView_statusOrder);

    }
}
