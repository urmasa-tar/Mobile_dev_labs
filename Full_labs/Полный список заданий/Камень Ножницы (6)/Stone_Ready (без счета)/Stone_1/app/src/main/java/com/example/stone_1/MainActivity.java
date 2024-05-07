package com.example.stone_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button st, sc, pap, reset;
    ImageView imgPlayer;
    ImageView imgComp;
    int[] compImg={R.drawable.stor, R.drawable.scissr,R.drawable.paper,R.drawable.empty};
    Integer scoreComp,scorePlay, res;
//    Bitmap newimg, scimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPlayer = findViewById(R.id.imgPlayer);
        imgComp = findViewById(R.id.imgComp);
        //scoreComp=0;
        scorePlay=3;
        st = findViewById(R.id.st);
        sc = findViewById(R.id.sc);
        pap = findViewById(R.id.pap);
        reset = findViewById(R.id.reset);
        sc.setOnClickListener(this);
        st.setOnClickListener(this);
        pap.setOnClickListener(this);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int num = 0;
        switch (view.getId()){
            case R.id.st:// Камень
                imgPlayer.setImageResource(R.drawable.stol);
                num = playing(1);
                if(num == 1) res = 3;// Ничья
                if(num == 2) res = 2;// Comp выбрал ножницы
                else  num = 1;
                break;
            case R.id.sc:// Ножницы
                 imgPlayer.setImageResource(R.drawable.scissl);
                 num = playing(2);
                if(num == 2) res = 3;// Ничья
                if(num == 1) res = 2;// Comp выбрал камень
                else  num = 1;
                break;
            case R.id.pap: // Бумага
                imgPlayer.setImageResource(R.drawable.papel);
                num = playing(3);
                if(num == 3) res = 3; // Ничья
                if(num == 2) res = 2;// Comp выбрал ножницы
                else  num = 1;
                break;
            case R.id.reset:
                imgPlayer.setImageResource(R.drawable.empty);
                scorePlay=3;
                imgComp.setImageResource(compImg[3]);
                break;

        }
        showVisual(num);
    }
    public int playing(Integer scorePlay) {
        Random ran=new Random();
        scoreComp=ran.nextInt(3)+1;
        if(scorePlay == scoreComp) { //Toast.makeText(this, "Ничья", Toast.LENGTH_SHORT).show();
        }
            else
        switch (scoreComp){
            case 1:
                imgComp.setImageResource(R.drawable.stor);
//                if(scoreComp == 2) Toast.makeText(this, "Выгрыш", Toast.LENGTH_SHORT).show();
//                else Toast.makeText(this, "Проигрыш", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                imgComp.setImageResource(R.drawable.scissr);
//                if(scoreComp == 3) Toast.makeText(this, "Выгрыш", Toast.LENGTH_SHORT).show();
//                else Toast.makeText(this, "Проигрыш", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                imgComp.setImageResource(R.drawable.paper);
//                if(scoreComp == 2) Toast.makeText(this, "Выгрыш", Toast.LENGTH_SHORT).show();
//                else Toast.makeText(this, "Проигрыш", Toast.LENGTH_SHORT).show();
                break;
        }
        return scoreComp;
    }
    public void showVisual(Integer num){
        new CountDownTimer(3000, 1000) {
        public void onFinish() {
            // When timer is finished
           switch (num){
               case 1:
                   imgPlayer.setImageResource(R.drawable.win);
                   imgComp.setImageResource(R.drawable.loss);
                   break;
               case 2:
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

        public void onTick(long millisUntilFinished) {
            // millisUntilFinished    The amount of time until finished.
        }
    }.start();
    }

//    new CountDownTimer(30000, 1000) {
//        public void onFinish() {
//            // When timer is finished
//            // Execute your code here
//        }
//
//        public void onTick(long millisUntilFinished) {
//            // millisUntilFinished    The amount of time until finished.
//        }
//    }.start();




//    Handler h = new Handler();
//    Action myAction = () =>
//    {
//        // your code that you want to delay here
//    };
//
//h.PostDelayed(myAction, 1000);
//

//    }
//    public void Randomc(){
//        Random ran=new Random();
//        scoreComp=ran.nextInt(3)+1;
//        Log.d("fast",String.valueOf(scoreComp));
//    }
//    public void play(Integer scoreComp,Integer scorePlay){
//        if (scoreComp==0&&scorePlay==0){
//            Toast.makeText(this,"Ничья",Toast.LENGTH_SHORT).show();
//        }else if (scoreComp==0&&scorePlay==2){
//            Toast.makeText(this,"Игрок выиграл",Toast.LENGTH_SHORT).show();
//        }else if (scoreComp==0&&scorePlay==1){
//            Toast.makeText(this,"Компьютер выиграл",Toast.LENGTH_SHORT).show();
//        }
//
//
//        if (scoreComp==1&&scorePlay==1){
//            Toast.makeText(this,"Ничья",Toast.LENGTH_SHORT).show();
//        }else if (scoreComp==1&&scorePlay==0){
//            Toast.makeText(this,"Игрок выиграл",Toast.LENGTH_SHORT).show();
//        }else if (scoreComp==1&&scorePlay==2){
//            Toast.makeText(this,"Компьютер выиграл",Toast.LENGTH_SHORT).show();
//    }
//
//        if (scoreComp==2&&scorePlay==2){
//            Toast.makeText(this,"Ничья",Toast.LENGTH_SHORT).show();
//        }else if (scoreComp==2&&scorePlay==1){
//            Toast.makeText(this,"Игрок выиграл",Toast.LENGTH_SHORT).show();
//        }else if(scoreComp==2&&scorePlay==0){
//            Toast.makeText(this,"Компьютер выиграл",Toast.LENGTH_SHORT).show();
//}}
//
//    public void start(View view) {
//        Randomc();
//        if (scorePlay!=3){
//            imgComp.setImageResource(compImg[scoreComp]);
//        play(scoreComp,scorePlay);}
//        else {
//            Toast.makeText(this,"Выберите позицию",Toast.LENGTH_SHORT).show();
//            imgComp.setImageResource(compImg[3]);
//        }
//    }
}

//            new CountDownTimer(30000, 1000) {
//        public void onFinish() {
//            imgComp.setImageResource(R.drawable.loss);
//            // When timer is finished
//            // Execute your code here
//        }
//
//        public void onTick(long millisUntilFinished) {
//            // millisUntilFinished    The amount of time until finished.
//        }
//    }.start();
