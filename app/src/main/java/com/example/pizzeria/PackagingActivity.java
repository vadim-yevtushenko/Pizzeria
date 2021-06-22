package com.example.pizzeria;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class PackagingActivity extends AppCompatActivity {
    private Pizza pizza;
    private ImageView ivOut;
    private ImageView ivIn;
    private Button bCont;
    private boolean isSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packaging);

        Intent intent = getIntent();
        if (intent != null) {
            pizza = (Pizza) intent.getSerializableExtra(MainActivity.KEY_PIZZA);
        }

        init();

        ivOut.setOnClickListener(v -> {
            isSelect = true;
            pizza.setTakeOut(true);
            ivOut.setBackgroundColor(Color.parseColor("#FF0000"));
            ivIn.setBackgroundColor(Color.parseColor("#C6B6B6"));
        });
        ivIn.setOnClickListener(v -> {
            isSelect = true;
            pizza.setTakeOut(false);
            ivOut.setBackgroundColor(Color.parseColor("#C6B6B6"));
            ivIn.setBackgroundColor(Color.parseColor("#FF0000"));
        });
        bCont.setOnClickListener(v -> {
            if (isSelect){
                Intent intent2 = new Intent(this, FinalActivity.class);
                intent2.putExtra(MainActivity.KEY_PIZZA, pizza);
                startActivity(intent2);
            }
        });
    }

    private void init() {
        ivOut = findViewById(R.id.ivOut);
        ivIn = findViewById(R.id.ivIn);
        bCont = findViewById(R.id.bCont);
    }
}