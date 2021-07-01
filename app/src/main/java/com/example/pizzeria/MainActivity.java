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
    public static boolean firstEntry = true;
    public static final String KEY_PIZZA = "com.example.pizzeria.MainActivity.PIZZA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent != null) {
            pizza = (Pizza) intent.getSerializableExtra(MainActivity.KEY_PIZZA);
        }

        initView();

        ivBigPizza.setOnClickListener((v) -> {
            if (firstEntry) {
                firstEntry = false;
                pizza = new Pizza(Pizza.BIG);
                startFillActivity(pizza);
            } else {
                pizza.setCost(pizza.getCost() - pizza.getSize());
                pizza.setSize(Pizza.BIG);
                pizza.setCost(pizza.getCost() + pizza.getSize());
                returnPizza();
            }
        });
        ivMiddlePizza.setOnClickListener((v) -> {
            if (firstEntry) {
                firstEntry = false;
                pizza = new Pizza(Pizza.MIDDLE);
                startFillActivity(pizza);
            } else {
                pizza.setCost(pizza.getCost() - pizza.getSize());
                pizza.setSize(Pizza.MIDDLE);
                pizza.setCost(pizza.getCost() + pizza.getSize());
                returnPizza();
            }
        });
        ivSmallPizza.setOnClickListener((v) -> {
            if (firstEntry) {
                firstEntry = false;
                pizza = new Pizza(Pizza.SMALL);
                startFillActivity(pizza);
            } else {
                pizza.setCost(pizza.getCost() - pizza.getSize());
                pizza.setSize(Pizza.SMALL);
                pizza.setCost(pizza.getCost() + pizza.getSize());
                returnPizza();
            }
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

    private void returnPizza(){
        Intent intent = new Intent();
        intent.putExtra(MainActivity.KEY_PIZZA, pizza);
        setResult(RESULT_OK, intent);
        finish();
    }
}