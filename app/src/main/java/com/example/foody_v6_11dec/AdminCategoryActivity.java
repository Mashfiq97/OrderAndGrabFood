package com.example.foody_v6_11dec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView burger_01, nugget01, hotdog01, nugget02;
    private ImageView coffee_01, nugget03, nugget04, pizza_01;
    private ImageView pizza_02, kabab_01, ice_cream01, frnfry01;

    private Button logoutButton, checkOrdersBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);
        setTitle("Admin Panel View");

        logoutButton = (Button)findViewById(R.id.admin_logout_button);
        checkOrdersBtn = (Button)findViewById(R.id.check_orders_btn);



        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        checkOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminNewOrdersActivity.class);

                startActivity(intent);


            }
        });


        burger_01 = (ImageView) findViewById(R.id.burger_01);
        nugget01 = (ImageView) findViewById(R.id.nugget01);
        hotdog01 = (ImageView) findViewById(R.id.hotdog01);
        nugget02 = (ImageView) findViewById(R.id.nugget02);

        coffee_01 = (ImageView) findViewById(R.id.coffee_01);
        nugget03 = (ImageView) findViewById(R.id.nugget03);
        nugget04 = (ImageView) findViewById(R.id.nugget04);
        pizza_01 = (ImageView) findViewById(R.id.pizza_01);

        pizza_02 = (ImageView) findViewById(R.id.pizza_02);
        kabab_01 = (ImageView) findViewById(R.id.kabab_01);
        ice_cream01 = (ImageView) findViewById(R.id.ice_cream01);
        frnfry01 = (ImageView) findViewById(R.id.frnfry01);


        burger_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Burgers");
                startActivity(intent);
            }
        });


        nugget01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Nuggets");
                startActivity(intent);
            }
        });


        hotdog01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Hot Dogs");
                startActivity(intent);
            }
        });


        nugget02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Chicken Nuggets");
                startActivity(intent);
            }
        });


        coffee_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Black Coffee");
                startActivity(intent);
            }
        });


        nugget03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Beef Nuggets");
                startActivity(intent);
            }
        });



        nugget04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Veg Nuggets");
                startActivity(intent);
            }
        });


        pizza_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Chicken Pizza");
                startActivity(intent);
            }
        });



        pizza_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Beef Pizza");
                startActivity(intent);
            }
        });


        kabab_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Chicken Kabab");
                startActivity(intent);
            }
        });


        ice_cream01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Ice Cream");
                startActivity(intent);
            }
        });


        frnfry01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "French Fries");
                startActivity(intent);
            }
        });
    }
}
