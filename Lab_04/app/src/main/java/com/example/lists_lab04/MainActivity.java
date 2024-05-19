package com.example.lists_lab04;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] arr_of_str;

    ArrayList<String> animals = new ArrayList();// Массив строк
    ArrayList<String> selectedAnimal = new ArrayList();// Выбранные строки
    ArrayAdapter<String> adapter;// Адаптер для связи массива с ListView
    ListView animList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        animals.add("Кошки");
        animals.add("Собаки");
        animals.add("Хомяки");
        animals.add("Еноты");
        animals.add("Черепахи");

        // Закрепление имени за элементом
        animList = (ListView) findViewById(R.id.animList);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, animals);
        animList.setAdapter(adapter);

    }

    public void OnClickAdd(View view) {
    }

    public void OnClickDel(View view) {
    }
}