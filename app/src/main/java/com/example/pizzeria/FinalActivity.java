package com.example.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class FinalActivity extends AppCompatActivity {

    private Pizza pizza;
    private TextView tvFillList;
    private TextView tvPortions;
    private Button bOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent = getIntent();
        if (intent != null){
            pizza = (Pizza) intent.getSerializableExtra(MainActivity.KEY_PIZZA);
        }
        initElements();

        String[] strings = createFillList();

        tvFillList.setText(strings[0]);
        tvPortions.setText(strings[1]);
        bOrder.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        });
    }

    private String[] createFillList() {
        String[] strings = new String[2];
        StringBuilder filling = new StringBuilder();
        StringBuilder portions = new StringBuilder();
        filling.append("Filling:\n");
        portions.append("portions\n");
        for(Map.Entry<String, Integer> pair : pizza.getFillingResult().entrySet()){
            if (pair.getValue() != 0){
                filling.append("\n" + pair.getKey());
                portions.append("\n      " + pair.getValue());
            }
        }
        if (pizza.isTakeOut()){
            filling.append("\nTakeout");
        }else {
            filling.append("\nEat in pizzeria");
        }
        filling.append("\n");
        filling.append("\nTotal cost:        ").append(pizza.getCost());
        strings[0] = filling.toString();
        strings[1] = portions.toString();
        return strings;
    }

    private void initElements() {
        tvFillList = findViewById(R.id.tvFillList);
        tvPortions = findViewById(R.id.tvPortions);
        bOrder = findViewById(R.id.bOrder);
    }
}