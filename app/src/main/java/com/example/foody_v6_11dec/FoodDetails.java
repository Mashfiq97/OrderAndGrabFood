package com.example.foody_v6_11dec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.foody_v6_11dec.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class FoodDetails extends AppCompatActivity {



    ImageView productImage;
    TextView itemName, itemPrice, itemRating,product_description;
    RatingBar ratingBar;
    private Button button_add_to_cart;
    private ElegantNumberButton number_btn_add_to_cart;
    private String userFoodItemRandomKey;
    private String state = "Normal";


    String name, price, rating, imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        button_add_to_cart = (Button)findViewById(R.id.button_add_to_cart);
        number_btn_add_to_cart =(ElegantNumberButton)findViewById(R.id.number_btn_add_to_cart);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        imageUrl = intent.getStringExtra("image");
        itemRating = findViewById(R.id.rating_add_to_cart);
        ratingBar = findViewById(R.id.ratingBar_add_to_cart);

        productImage = (ImageView )findViewById(R.id.product_image_add_to_cart);
        itemName = (TextView)findViewById(R.id.product_name_add_to_cart);
        itemPrice = (TextView)findViewById(R.id.product_price_add_to_cart);
        product_description = (TextView)findViewById(R.id.product_description_add_to_cart);




        Glide.with(getApplicationContext()).load(imageUrl).into(productImage);
        itemName.setText(name);
        itemPrice.setText("Tk "+price);
        itemRating.setText(rating);
        ratingBar.setRating(Float.parseFloat(rating));


        button_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(state.equals("Orders have been Placed") || state.equals("Orders have been Shipped") )
                {
                    Toast.makeText(FoodDetails.this, "You can purchase more, once your orders have been shipped or confirmed", Toast.LENGTH_LONG).show();

                }
                else
                    {
                        addingToCart();

                }
                
            }

            private void addingToCart() {



                String saveCurrentTime, saveCurrentDate;

                Calendar calForDate = Calendar.getInstance();

                SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                saveCurrentDate = currentDate.format(calForDate.getTime());

                SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
                saveCurrentTime = currentTime .format(calForDate.getTime());



                userFoodItemRandomKey = saveCurrentDate + " : " + saveCurrentTime;

                final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");

                final HashMap<String, Object> cartMap = new HashMap<>();

                cartMap.put("Number",userFoodItemRandomKey);
                cartMap.put("name",name);
                cartMap.put("quantity",number_btn_add_to_cart.getNumber());
                cartMap.put("price",price);
                cartMap.put("discount", "");

                cartListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone()).child("Products").child(userFoodItemRandomKey).updateChildren(cartMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            cartListRef.child("Admin View").child(Prevalent.currentOnlineUser.getPhone()).child("Products").child(userFoodItemRandomKey).updateChildren(cartMap)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(FoodDetails.this, "Food Items Added to Your Cart List Successfully", Toast.LENGTH_SHORT).show();

                                            }

                                        }
                                    });

                        }

                    }

                });
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        CheckOrderState();
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

                    if(shippingState.equals("Shipped"))
                    {
                        state = "Orders have been Shipped";
                    }
                    else if(shippingState.equals("Not Shipped"))
                    {
                        state = "Orders have been Placed";
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
