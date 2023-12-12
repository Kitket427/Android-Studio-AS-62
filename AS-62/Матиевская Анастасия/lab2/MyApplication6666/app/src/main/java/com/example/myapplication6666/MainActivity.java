package com.example.myapplication6666;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private VideoView videoView;
    private ImageView photoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playAudioButton = findViewById(R.id.play_audio_button);
        Button pauseAudioButton = findViewById(R.id.pause_audio_button);
        Button playVideoButton = findViewById(R.id.play_video_button);
        Button pauseVideoButton = findViewById(R.id.pause_video_button);
        Button takePhotoButton = findViewById(R.id.take_photo_button);
        videoView = findViewById(R.id.video_view);
        photoImageView = findViewById(R.id.photo_image_view);

        playAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        pauseAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseAudio();
            }
        });

        playVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo();
            }
        });

        pauseVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseVideo();
            }
        });

        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPhoto();
            }
        });
    }

    private void playAudio() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.audio_file);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    releaseMediaPlayer();
                }
            });
        }
        mediaPlayer.start();
    }

    private void pauseAudio() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private void playVideo() {
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video_file);
        videoView.start();
    }

    private void pauseVideo() {
        if (videoView != null && videoView.isPlaying()) {
            videoView.pause();
        }
    }

    private void displayPhoto() {
        photoImageView.setImageResource(R.drawable.photo_image);
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}