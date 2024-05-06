package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt;
    Button button2;
    Button button3;
    TextView txt;
    String num;
    int num_calc;


    boolean fl = true;

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
        // Buttins and elements
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(this);

        num_calc = 0;
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        txt = (TextView) findViewById(R.id.textView);
        num = Integer.toString(num_calc);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        txt.setText(Integer.toString(num_calc));

        if (view.getId() == R.id.bt) {
            // button1 action
            bt.setText("Нажато");

        } else if (view.getId() == R.id.button2) {
            num_calc += 1;
            txt.setText(Integer.toString(num_calc));
            //button2 action
        } else if (view.getId() == R.id.button3) {
            //button3 action
            num_calc = 0;
            txt.setText(Integer.toString(num_calc));
        }

    }
}