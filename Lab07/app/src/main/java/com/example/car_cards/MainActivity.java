package com.example.car_cards;

import android.media.tv.TvContract;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<TvContract.Channels.Logo> logos;

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
    }

    public  void SetLogoInitial(){
        logos.add(new TvContract.Channels.Logo(R.drawable.a_bmwlogo, "Германия"));
        logos.add(new TvContract.Channels.Logo(R.drawable.a_chevroletlogo, "США"));
        logos.add(new Logo(R.drawable.a_fordlogo, "США"));
        logos.add(new Logo(R.drawable.a_hundailogo, "Южная Корея"));
        logos.add(new Logo(R.drawable.a_ladalogo, "Россия"));
    }

}

