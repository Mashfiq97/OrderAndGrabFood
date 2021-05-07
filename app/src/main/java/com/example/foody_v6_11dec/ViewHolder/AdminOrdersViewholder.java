package com.example.foody_v6_11dec.ViewHolder;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foody_v6_11dec.R;

public class AdminOrdersViewholder extends RecyclerView.ViewHolder {
    public TextView userName, userPhoneNumber, userTotalPrice, userDateTime, userShippingAddress;
    public Button showOrdersBtn;

    public AdminOrdersViewholder(@NonNull View itemView) {
        super(itemView);

        userName = itemView.findViewById(R.id.user_name_orders_layout);
        userPhoneNumber = itemView.findViewById(R.id.phone_number_orders_layout);
        userTotalPrice = itemView.findViewById(R.id.total_price_orders_layout);
        userDateTime = itemView.findViewById(R.id.date_time_orders_layout);
        userShippingAddress = itemView.findViewById(R.id.address_city_orders_layout);

        showOrdersBtn = itemView.findViewById(R.id.show_all_products_orders_layout_btn);
    }
}
