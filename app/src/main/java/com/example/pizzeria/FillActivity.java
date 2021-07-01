package com.example.pizzeria;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FillActivity extends AppCompatActivity {

    private Pizza pizza;
    private Button bPlus;
    private Button bMinus;
    private Button bContinue;
    private ImageView ivPork;
    private TextView tvPork;
    private ImageView ivChicken;
    private TextView tvChicken;
    private ImageView ivSausage;
    private TextView tvSausage;
    private ImageView ivCheese;
    private TextView tvCheese;
    private ImageView ivMushroom;
    private TextView tvMushroom;
    private ImageView ivPineapple;
    private TextView tvPineapple;
    private ImageView ivOlives;
    private TextView tvOlives;
    private ImageView ivTomato;
    private TextView tvTomato;
    private ImageView ivBasil;
    private TextView tvBasil;
    private TextView tvCoastView;
    private boolean isAdd = true;
    public static boolean firstEntry = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        Intent intent = getIntent();
        if (intent != null) {
            pizza = (Pizza) intent.getSerializableExtra(MainActivity.KEY_PIZZA);
        }

        initView();
        initButton();
        initStartStageView();
        String startCoast = String.format("%.2f", pizza.getCost());
        tvCoastView.setText(startCoast);

        bContinue.setOnClickListener(v -> {
            if (firstEntry) {
                Intent intent2 = new Intent(this, PackagingActivity.class);
                intent2.putExtra(MainActivity.KEY_PIZZA, pizza);
                firstEntry = false;
                startActivity(intent2);
            } else {
                returnPizza();
            }
        });

        bPlus.setOnClickListener((v) -> {
            isAdd = true;
            bPlus.setBackgroundColor(Color.parseColor("#FFEB3B"));
            bMinus.setBackgroundColor(Color.parseColor("#DCCECE"));
        });
        bMinus.setOnClickListener((v) -> {
            isAdd = false;
            bPlus.setBackgroundColor(Color.parseColor("#DCCECE"));
            bMinus.setBackgroundColor(Color.parseColor("#FFEB3B"));
        });
        ivPork.setOnClickListener(v -> {
            String key = Pizza.PORK;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvPork.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
        ivChicken.setOnClickListener(v -> {
            String key = Pizza.CHICKEN;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvChicken.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
        ivSausage.setOnClickListener(v -> {
            String key = Pizza.SAUSAGE;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvSausage.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
        ivCheese.setOnClickListener(v -> {
            String key = Pizza.CHEESE;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvCheese.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
        ivMushroom.setOnClickListener(v -> {
            String key = Pizza.MUSHROOM;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvMushroom.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
        ivPineapple.setOnClickListener(v -> {
            String key = Pizza.PINEAPPLE;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvPineapple.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
        ivOlives.setOnClickListener(v -> {
            String key = Pizza.OLIVES;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvOlives.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
        ivTomato.setOnClickListener(v -> {
            String key = Pizza.TOMATO;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvTomato.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
        ivBasil.setOnClickListener(v -> {
            String key = Pizza.BASIL;
            int number = pizza.getFillingResult().get(key);
            setCostAndFilling(number, key);
            tvBasil.setText(String.format("Price %.2f x %d", pizza.getFilling().get(key), pizza.getFillingResult().get(key)));
        });
    }

    private void initStartStageView() {
        tvPork.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.PORK), pizza.getFillingResult().get(Pizza.PORK)));
        tvChicken.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.CHICKEN), pizza.getFillingResult().get(Pizza.CHICKEN)));
        tvSausage.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.SAUSAGE), pizza.getFillingResult().get(Pizza.SAUSAGE)));
        tvCheese.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.CHEESE), pizza.getFillingResult().get(Pizza.CHEESE)));
        tvMushroom.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.MUSHROOM), pizza.getFillingResult().get(Pizza.MUSHROOM)));
        tvPineapple.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.PINEAPPLE), pizza.getFillingResult().get(Pizza.PINEAPPLE)));
        tvOlives.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.OLIVES), pizza.getFillingResult().get(Pizza.OLIVES)));
        tvTomato.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.TOMATO), pizza.getFillingResult().get(Pizza.TOMATO)));
        tvBasil.setText(String.format("Price %.2f x %d", pizza.getFilling().get(Pizza.BASIL), pizza.getFillingResult().get(Pizza.BASIL)));
    }

    private void setCostAndFilling(int number, String key) {
        if (isAdd) {
            number++;
            pizza.addToCost(key);
            pizza.getFillingResult().put(key, number);
        } else {
            if (number > 0) {
                number--;
                pizza.subtractFromCost(key);
                pizza.getFillingResult().put(key, number);
            }
        }
        tvCoastView.setText(String.format("%.2f", pizza.getCost()));
    }


    private void initButton() {
        bPlus = findViewById(R.id.bPlus);
        bMinus = findViewById(R.id.bMinus);
        bContinue = findViewById(R.id.bContinue);
    }

    private void initView() {
        ivPork = findViewById(R.id.ivPork);
        tvPork = findViewById(R.id.tvPork);
        ivChicken = findViewById(R.id.ivChicken);
        tvChicken = findViewById(R.id.tvChicken);
        ivSausage = findViewById(R.id.ivSausage);
        tvSausage = findViewById(R.id.tvSausage);
        ivCheese = findViewById(R.id.ivCheese);
        tvCheese = findViewById(R.id.tvCheese);
        ivMushroom = findViewById(R.id.ivMushroom);
        tvMushroom = findViewById(R.id.tvMushroom);
        ivPineapple = findViewById(R.id.ivPineapple);
        tvPineapple = findViewById(R.id.tvPineapple);
        ivOlives = findViewById(R.id.ivOlives);
        tvOlives = findViewById(R.id.tvOlives);
        ivTomato = findViewById(R.id.ivTomato);
        tvTomato = findViewById(R.id.tvTomato);
        ivBasil = findViewById(R.id.ivBasil);
        tvBasil = findViewById(R.id.tvBasil);
        tvCoastView = findViewById(R.id.tvCostView);
    }

    private void returnPizza(){
        Intent intent = new Intent();
        intent.putExtra(MainActivity.KEY_PIZZA, pizza);
        setResult(RESULT_OK, intent);
        finish();
    }
}