package com.example.lab_04;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> peopleList = new ArrayList();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView mList = (ListView) findViewById(R.id.listView);

        setInitialData();
        ItemListAdapter adapter = new ItemListAdapter(this, R.layout.item_list,
                peopleList);
        mList.setAdapter(adapter);

    }

    private void setInitialData() {

        peopleList.add(new Person("Чехов A. П.", "Писатель",
                BitmapFactory.decodeResource(getResources(),
                        R.drawable.chekhov)));
        peopleList.add(new Person("Филатов Л. А", "Актер и писатель",
                BitmapFactory.decodeResource(getResources(),
                        R.drawable.filatov)));
        peopleList.add(new Person("Матроскин", "Кот из Простоквашино",
                BitmapFactory.decodeResource(getResources(),
                        R.drawable.matroskin_2)));
        peopleList.add(new Person("Пес","Из польского юмора",
                BitmapFactory.decodeResource(getResources(),
                        R.drawable.pes)));
        peopleList.add(new Person("Ржевский","Герой анекдотов",
                BitmapFactory.decodeResource(getResources(),
                        R.drawable.poruchik)));
    }
}