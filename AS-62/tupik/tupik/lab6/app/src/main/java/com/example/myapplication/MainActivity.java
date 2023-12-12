package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, cat;
    private MediaPlayer catSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_file2);
        imageView.setImageResource(R.drawable.image_file);
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.houka);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        cat = (ImageView) findViewById(R.id.cat);
        cat.setImageResource(R.drawable.image_file1);
        catSound = MediaPlayer.create(this, R.raw.meow);
        imageClick();
    }
    public void imageClick(){
cat.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        soundPlay(catSound);
    }
});
    }
    public void soundPlay(MediaPlayer sound){
        sound.start();
    }
}