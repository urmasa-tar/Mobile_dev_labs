package com.example.dogandcat;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean permiss = true;
    ImageView catView, dogView;
    Button bt;
    MediaPlayer mp;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catView = findViewById(R.id.catView);
        dogView = findViewById(R.id.dogView);
        bt = findViewById(R.id.bt);
        catView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                permiss = false;// Запрет выбора другой картинки
                if (permiss) {
                    beginPlay(1);
                }
            }
        });
        dogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                permiss = false;// Запрет выбора другой картинки
                if (permiss) beginPlay(2);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlay();
            }
        });
    }

    public void beginPlay(int pos) {
        boolean perm;
        switch (pos) {
            case 1:
                permiss = false;
                catView.setImageResource(R.drawable.catimg);
                mp = MediaPlayer.create(context, R.raw.catsound);
                mp.start();
                break;
            case 2:
                permiss = false;
                dogView.setImageResource(R.drawable.dog4);
//                mp = MediaPlayer.create(context, R.raw.dogsound);
//                mp.start();
                break;
        }

    }

    public void stopPlay() {
        permiss = true;
        catView.setImageResource(R.drawable.catimage3);
        dogView.setImageResource(R.drawable.dogimage);
//        if (mp.isPlaying()) {
//            mp.stop();
//            mp.release();
//            mp = null;
//        }
    }
}