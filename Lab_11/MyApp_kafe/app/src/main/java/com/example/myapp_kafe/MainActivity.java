package com.example.myapp_kafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Meal> food = new ArrayList<Meal>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        recyclerView = findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
// создаем адаптер
        CafeAdapter adapter = new CafeAdapter(this, food);
// устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

    }

    public void setInitialData() {
        food.add(new Meal(R.drawable.beefsteak_1,"Бифштекс",175, 2));
        food.add(new Meal(R.drawable.chachlyk,"Шашлык",  273,6));
        food.add(new Meal(R.drawable.duck, "Утка",122, 1));
        food.add(new Meal(R.drawable.fruit, "Фрукты",56,1));
        food.add(new Meal(R.drawable.icecream, "Мороженое",71,6));
        food.add(new Meal(R.drawable.pizza, "Пицца",122, 1));
        food.add(new Meal(R.drawable.shaurma, "Шаурма",56,1));
        food.add(new Meal(R.drawable.steak, "Стейк",71,3));
    }

}