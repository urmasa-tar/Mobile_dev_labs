package com.example.stone_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Глобальные объявления
    Button st, sc, pap, reset;// Кнопки
    ImageView imgPlayer;// Изображение для Usera
    ImageView imgComp;// Изображение для Computera
    // Массив изображений для Computera
    int[] compImg={R.drawable.stor, R.drawable.scissr,R.drawable.paper,R.drawable.empty};
    Integer scoreComp,scorePlay, res, scorep=0, scorec=0;// Выборы игроков и результат
    ImageView clear;
    TextView scp, scc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Закрепление имен за элементами управления
        imgPlayer = findViewById(R.id.imgPlayer);
        imgComp = findViewById(R.id.imgComp);
        st = findViewById(R.id.st);
        sc = findViewById(R.id.sc);
        pap = findViewById(R.id.pap);
        reset = findViewById(R.id.reset);
        scorePlay=3; // Начальный счет ! ничья

        clear = findViewById(R.id.clear);
        scp = findViewById(R.id.scp);
        scc = findViewById(R.id.scc);
        scp.setText("0");
        scc.setText("0");
        // Закрепление обработчика щелчка за кнопками
        sc.setOnClickListener(this);
        st.setOnClickListener(this);
        pap.setOnClickListener(this);
        reset.setOnClickListener(this);
        clear.setOnClickListener(this);
    }
// Обработка кнопок
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int num = 0;// Значение num - выигрыш для Usera
        switch (view.getId()) {// Выбранная кнопка
            case R.id.st:      // Камень
                imgPlayer.setImageResource(R.drawable.stol);
                num = playing(1);// Вызов хода компьютера
                if (num == 1) res = 3;   // Ничья
                if (num == 2) res = 1;   // Comp выбрал ножницы
                else num = 2;            // Comp выбрал бумагу
                break;
            case R.id.sc:// Ножницы
                imgPlayer.setImageResource(R.drawable.scissl);
                num = playing(2);
                if (num == 2) res = 3;// Ничья
                if (num == 1) res = 2;// Comp выбрал камень
                else num = 1;         // Comp выбрал бумагу
                break;
            case R.id.pap: // Бумага
                imgPlayer.setImageResource(R.drawable.papel);
                num = playing(3);
                if (num == 3) res = 3; // Ничья
                if (num == 2) res = 2; // Comp выбрал ножницы
                else num = 1;          // Comp выбрал камень
                break;
            case R.id.reset:// Возврат в исходное положение
                imgPlayer.setImageResource(R.drawable.empty);
                scorePlay = 3;
                imgComp.setImageResource(compImg[3]);
                break;
            case R.id.clear:// Обнуление счета
                scorep=0; scorec=0; // Обнулить в памяти
                scp.setText("0");   // Стереть на экране
                scc.setText("0");
                break;
        }
        showVisual(num);// Показать итог кона
    }
    // Вызов иконок, соответствующих результату текущего кона
    private void showVisual(int num) {
        // Задержка времени 1-я цифра время задержки (ms), 2-я такт
        new CountDownTimer(3000, 1000) {
            public void onFinish() {
                switch (num) {
                    case 1:
                        scorep++;
                        scp.setText(String.valueOf(scorep));
                        imgPlayer.setImageResource(R.drawable.win);
                        imgComp.setImageResource(R.drawable.loss);
                        break;
                    case 2:
                        scorec++;
                        scc.setText(String.valueOf(scorec));
                        imgPlayer.setImageResource(R.drawable.loss);
                        imgComp.setImageResource(R.drawable.win);
                        break;
                    case 3:
                        imgPlayer.setImageResource(R.drawable.confusion);
                        imgComp.setImageResource(R.drawable.confusion);
                        break;
                }
                // Execute your code here
            }
    // Метод для отсчета тактов (не используется)
            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }
    // Игра компьютера
    public int playing(Integer scorePlay) {// scorePlay выбор игрока
        Random ran = new Random();// Числа отсчитываются от нуля
        scoreComp = ran.nextInt(3) + 1;// Чтобы счет от 1
        if (!scorePlay.equals(scoreComp)) {
            switch (scoreComp) {
                case 1: // Вернуть камень
                    imgComp.setImageResource(R.drawable.stor);
                    break;
                case 2: // Вернуть ножницы
                    imgComp.setImageResource(R.drawable.scissr);
                    break;
                case 3: // Вернуть бумагу
                    imgComp.setImageResource(R.drawable.paper);
                    break;
            }
        }
        else scoreComp =scorePlay;// Ничья
        return scoreComp;
    }

}
