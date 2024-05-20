package com.example.rock_paper_sizer_lab06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Глобальные объявления
    Button st, sc, pap, reset;// Кнопки
    ImageView imgPlayer;// Изображение для Usera
    ImageView imgComp;// Изображение для Computera
    // Массив изображений для Computera
    int[] compImg={R.drawable.stor, R.drawable.scissr,R.drawable.paper,R.drawable.empty};
    Integer scoreComp,scorePlay, res;// Выборы игроков и результат




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

        setContentView(R.layout.activity_main);
        // Закрепление имен за элементами управления
        imgPlayer = findViewById(R.id.imgPlayer);
        imgComp = findViewById(R.id.imgComp);
        st = findViewById(R.id.st);
        sc = findViewById(R.id.sc);
        pap = findViewById(R.id.pap);
        reset = findViewById(R.id.reset);

        scorePlay=3; // Начальный счет ! ничья



    }

    public void st(View view) {
    }

    public void sc(View view) {
    }

    public void pap(View view) {
    }

    public void reset(View view) {
    }
}