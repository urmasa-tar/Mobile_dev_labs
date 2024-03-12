package com.example.myapp_01;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt:
                if (fl) {                   // Если fl==true
                    bt.setText("Нажато");
                    fl = false;          // Переключить флаг
                } else {
                    bt.setText("Нажмите");
                    fl = true;
                }
                break;
            case R.id.plusbt:
                n++;
                num= Integer.toString(n);
                txt.setText(num);
                break;
            case R.id.clearbt:
                n=0;// Сброс счетчика
                num= Integer.toString(0);
                txt.setText(num);   // Стирание на экране
                break;
        }
}