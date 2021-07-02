package com.example.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class FinalActivity extends AppCompatActivity {

    private static final int CODE_FILLACTIVITY = 2;
    private static final int CODE_PACKAGINGACTIVITY = 3;
    private static final int CODE_MAINACTIVITY = 1;
    private Pizza pizza;
    private TextView tvFillList;
    private TextView tvPortions;
    private TextView tvPackaging;
    private TextView tvTotal;
    private TextView tvSize;
    private Button bOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent = getIntent();
        if (intent != null) {
            pizza = (Pizza) intent.getSerializableExtra(MainActivity.KEY_PIZZA);
        }
        if (savedInstanceState != null){
            pizza = (Pizza) savedInstanceState.getSerializable(MainActivity.KEY_PIZZA);
        }
        initElements();

        String[] strings = createFillList();

        tvFillList.setText(strings[0]);
        tvFillList.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, FillActivity.class);
            intent1.putExtra(MainActivity.KEY_PIZZA, pizza);
            startActivityForResult(intent1, CODE_FILLACTIVITY);
        });
        tvPortions.setText(strings[1]);
        if (pizza.isTakeOut()) {
            tvPackaging.setText("Takeout");
        } else {
            tvPackaging.setText("Eat in pizzeria");
        }
        tvPackaging.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, PackagingActivity.class);
            intent1.putExtra(MainActivity.KEY_PIZZA, pizza);
            startActivityForResult(intent1, CODE_PACKAGINGACTIVITY);
        });
        tvSize.setText("Size: " + getSize());
        tvSize.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            intent1.putExtra(MainActivity.KEY_PIZZA, pizza);
            startActivityForResult(intent1, CODE_MAINACTIVITY);
        });
        bOrder.setOnClickListener(v -> {
            FillActivity.firstEntry = true;
            PackagingActivity.firstEntry = true;
            MainActivity.firstEntry = true;
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        });

        tvTotal.setText("Total cost:        " + pizza.getCost());
    }

    private String getSize() {
        switch (pizza.getSize()) {
            case Pizza.BIG:
                return "Big";
            case Pizza.MIDDLE:
                return "Middle";
            case Pizza.SMALL:
                return "Small";
        }
        return "empty";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CODE_FILLACTIVITY: {
                if (resultCode == RESULT_OK) {
                    pizza = (Pizza) data.getSerializableExtra(MainActivity.KEY_PIZZA);
                    String[] strings = createFillList();
                    tvFillList.setText(strings[0]);
                    tvPortions.setText(strings[1]);
                    tvTotal.setText("Total cost:        " + pizza.getCost());
                    break;
                }
            }
            case CODE_PACKAGINGACTIVITY: {
                pizza = (Pizza) data.getSerializableExtra(MainActivity.KEY_PIZZA);
                if (pizza.isTakeOut()) {
                    tvPackaging.setText("Takeout");
                } else {
                    tvPackaging.setText("Eat in pizzeria");
                }
                break;
            }
            case CODE_MAINACTIVITY:{
                pizza = (Pizza) data.getSerializableExtra(MainActivity.KEY_PIZZA);
                tvSize.setText("Size: " + getSize());
                tvTotal.setText("Total cost:        " + pizza.getCost());
                break;
            }
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(MainActivity.KEY_PIZZA, pizza);
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pizza = (Pizza) savedInstanceState.getSerializable(MainActivity.KEY_PIZZA);
    }

    private String[] createFillList() {
        String[] strings = new String[2];
        StringBuilder filling = new StringBuilder();
        StringBuilder portions = new StringBuilder();
        for (Map.Entry<String, Integer> pair : pizza.getFillingResult().entrySet()) {
            if (pair.getValue() != 0) {
                filling.append("\n" + pair.getKey());
                portions.append("\n      " + pair.getValue());
            }
        }
        strings[0] = filling.toString();
        strings[1] = portions.toString();
        return strings;
    }

    private void initElements() {
        tvFillList = findViewById(R.id.tvFillList);
        tvPortions = findViewById(R.id.tvPortions);
        tvPackaging = findViewById(R.id.tvPackaging);
        tvTotal = findViewById(R.id.tvTotal);
        tvSize = findViewById(R.id.tvSize);
        bOrder = findViewById(R.id.bOrder);
    }
}