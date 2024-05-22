package com.example.myapp_10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements ClipAdapter.ItemClickListener{
    private final ArrayList<Picture> mylst = new ArrayList<>();
    ClipAdapter adapter;
    String [] clp = new String[8];//Название клипа
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.rV);// Связь разметки с кодом
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        clp = getResources().getStringArray(R.array.kind);//
        setInitialData();
        // Создание адаптера
        adapter = new ClipAdapter(this, mylst);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    public void setInitialData(){
        mylst.add(new Picture(R.drawable.leopold, clp[0]));
        //mylst.add(new Picture(R.drawable.sharick,  clp[1]));
        mylst.add(new Picture(R.drawable.udav,  clp[1]));
        mylst.add(new Picture(R.drawable.wolf2,  clp[2]));
        mylst.add(new Picture(R.drawable.wolf4, clp[3]));
        //mylst.add(new Picture(R.drawable.wolf5,  clp[5]));
//        mylst.add(new Pictures(R.drawable.,  brd[6]));
//        mylst.add(new Pictures(R.drawable., brd[7]));
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "Вы щелкнули по строке " + position,
//                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        int pos = position;
// pos – выбранная позиция, ее надо передать на вторую страницу
        intent.putExtra("pos", pos); // “pos” имя для передачи
        this.startActivity(intent);

    }
}
