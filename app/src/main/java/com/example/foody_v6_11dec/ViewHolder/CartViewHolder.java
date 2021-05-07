package com.example.foody_v6_11dec.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foody_v6_11dec.Interface.ItemClickListner;
import com.example.foody_v6_11dec.R;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtProductName, txtProductPrice, txtProductQuantity;
    private ItemClickListner itemClickListner;

    public CartViewHolder(@NonNull View itemView)
    {
        super(itemView);

        txtProductName = itemView.findViewById(R.id.food_name_cart_items_layout);
        txtProductPrice = itemView.findViewById(R.id.food_price_cart_items_layout);
        txtProductQuantity = itemView.findViewById(R.id.food_quantity_cart_items_layout);

    }

    @Override
    public void onClick(View v)
    {
        itemClickListner.onClick(v, getAdapterPosition(), false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }
}
