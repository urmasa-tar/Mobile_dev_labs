package com.example.second_lab_wotk;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer Dog_Sound;
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

    public void onClick_1(View view) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.miau);

        mediaPlayer.start();

        Toast toast = Toast.makeText(getApplicationContext(),
                "Покорми кота", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    public void onClick_2(View view) {

        Dog_Sound = MediaPlayer.create(getApplicationContext(), R.raw.lay);

        Dog_Sound.start();

        Toast toast = Toast.makeText(getApplicationContext(),
                "Pokormi psa", Toast.LENGTH_SHORT);

        toast.show();
    }
}