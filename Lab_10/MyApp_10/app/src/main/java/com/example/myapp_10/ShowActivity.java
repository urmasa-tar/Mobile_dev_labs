package com.example.myapp_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {

    VideoView vid;
    MediaController mediaControls;
    Button bts, btp, bte;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        vid = (VideoView) findViewById(R.id.vid);
        bts = findViewById(R.id.bts);
        btp = findViewById(R.id.btp);
        bte = findViewById(R.id.bte);
        bts.setOnClickListener(this);
        btp.setOnClickListener(this);
        bte.setOnClickListener(this);

        // Прием выбранной позиции с предыдущей страницы
        Bundle arguments = getIntent().getExtras();
        int ind = arguments.getInt("pos");
        clipchoose(ind);// Вывод на экран выбранного клипа

    }

    public void clipchoose(int ind){
        switch (ind) {
            case 0:
                vid.setVideoURI(Uri.parse("android.resource://"
                        + getPackageName() + "/" + R.raw.leopold));
                break;
            case 1:
                vid.setVideoURI(Uri.parse("android.resource://"
                        + getPackageName() + "/" + R.raw.udav));
                break;
            case 2:
                vid.setVideoURI(Uri.parse("android.resource://"
                        + getPackageName() + "/" + R.raw.wait));
                break;
            case 3:
                vid.setVideoURI(Uri.parse("android.resource://"
                        + getPackageName() + "/" + R.raw.weightlifting));
                break;
        }
    }

    @Override
    public void onClick(View v) {

        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = new MediaController(ShowActivity.this);
            mediaControls.setAnchorView(vid);
        }
// set the media controller for video view
        vid.setMediaController(mediaControls);

        int n = 0;
        if(v.getId() == R.id.bts) n = 1;
        if(v.getId() == R.id.btp) n = 2;
        if(v.getId() == R.id.bte) n = 3;
        switch (n) {
            case 1:
                vid.start();
                break;
            case 2:
                vid.pause();
            case 3:
                if (vid!=null) {
                    vid.stopPlayback();
                    vid.resume();
                    Intent intent = new Intent(ShowActivity.this, MainActivity.class);
                    this.startActivity(intent);
                }
                break;
        }

    }
}