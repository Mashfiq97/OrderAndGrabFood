package com.example.foody_v6_11dec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foody_v6_11dec.Model.Cart;
import com.example.foody_v6_11dec.Prevalent.Prevalent;
import com.example.foody_v6_11dec.ViewHolder.CartViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button NextProcessBtn;
    private TextView txtTotalAmount, txtMsg1_cart;

    private int overTotalPrice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView =findViewById(R.id.cart_list_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        NextProcessBtn =(Button)findViewById(R.id.next_process_button_cart);
        txtTotalAmount = (TextView)findViewById(R.id.total_price_cart_list);
        txtMsg1_cart = (TextView)findViewById(R.id.msg1_cart);



        NextProcessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(CartActivity.this, ConfirmFinalOrderActivity.class);
                intent.putExtra("Total Price" , String.valueOf(overTotalPrice));
                startActivity(intent);
                finish();
            }
        });


        txtTotalAmount.setText("Total Price = Tk: " + String.valueOf(overTotalPrice));

    }

    @Override
    protected void onStart()
    {

        super.onStart();
        CheckOrderState();


        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");

        FirebaseRecyclerOptions<Cart> options =
                new FirebaseRecyclerOptions.Builder<Cart>()
                .setQuery(cartListRef.child("User View").
                        child(Prevalent.currentOnlineUser.getPhone()).
                        child("Products"), Cart.class)
                        .build();

        FirebaseRecyclerAdapter<Cart, CartViewHolder> adapter =
                new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int i, @NonNull Cart cart)
                    {
                        cartViewHolder.txtProductQuantity.setText("Quantity = " + cart.getQuantity());
                        cartViewHolder.txtProductPrice.setText("Price = " +cart.getPrice() + "Tk");
                        cartViewHolder.txtProductName.setText("Name = " +cart.getName());

                        int oneTypeProductPrice = ((Integer.valueOf(cart.getPrice())))*Integer.valueOf(cart.getQuantity());
                        overTotalPrice = overTotalPrice + oneTypeProductPrice;

                        txtTotalAmount.setText("Total Price = Tk: " + String.valueOf(overTotalPrice));

                    }

                    @NonNull
                    @Override
                    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                    {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent, false);
                        CartViewHolder holder = new CartViewHolder(view);
                        return holder;

                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }

    private void CheckOrderState()
    {
        DatabaseReference ordersRef;
        ordersRef = FirebaseDatabase.getInstance().getReference()
                .child("Orders")
                .child(Prevalent.currentOnlineUser.getPhone());

        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(dataSnapshot.exists())
                {
                    String shippingState = dataSnapshot.child("state")
                            .getValue().toString();

                    String userName = dataSnapshot.child("name")
                            .getValue().toString();

                    if(shippingState.equals("Shipped"))
                    {
                        txtTotalAmount.setText("Dear "+ userName + "\n order has been shipped successfully");
                        recyclerView.setVisibility(View.GONE);
                        txtMsg1_cart.setVisibility(View.VISIBLE);
                        txtMsg1_cart.setText("Congratulations, your order has been shipped successfully");
                        NextProcessBtn.setVisibility(View.GONE);

                        Toast.makeText(CartActivity.this, "You can purchase more once you have received your first orders", Toast.LENGTH_SHORT).show();
                    }
                    else if(shippingState.equals("Not Shipped"))
                    {
                        txtTotalAmount.setText("Shipping State = Not Shipped");
                        recyclerView.setVisibility(View.GONE);
                        txtMsg1_cart.setVisibility(View.VISIBLE);
                        NextProcessBtn.setVisibility(View.GONE);

                        Toast.makeText(CartActivity.this, "You can purchase more once you have received your first orders", Toast.LENGTH_SHORT).show();

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}