package com.example.pizzeria;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivBigPizza;
    private ImageView ivMiddlePizza;
    private ImageView ivSmallPizza;
    private Pizza pizza;
    public static final String KEY_PIZZA = "com.example.pizzeria.MainActivity.PIZZA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        ivBigPizza.setOnClickListener((v) -> {
            pizza = new Pizza(Pizza.BIG);
            startFillActivity(pizza);
        });
        ivMiddlePizza.setOnClickListener((v) -> {
            pizza = new Pizza(Pizza.MIDDLE);
            startFillActivity(pizza);
        });
        ivSmallPizza.setOnClickListener((v) -> {
            pizza = new Pizza(Pizza.SMALL);
            startFillActivity(pizza);
        });
    }

    private void startFillActivity(Pizza pizza) {
        Intent intent = new Intent(this, FillActivity.class);
        intent.putExtra(KEY_PIZZA, pizza);
        startActivity(intent);
    }

    private void initView() {
        ivBigPizza = findViewById(R.id.ivBigPizza);
        ivMiddlePizza = findViewById(R.id.ivMiddlePizza);
        ivSmallPizza = findViewById(R.id.ivSmallPizza);
    }
}