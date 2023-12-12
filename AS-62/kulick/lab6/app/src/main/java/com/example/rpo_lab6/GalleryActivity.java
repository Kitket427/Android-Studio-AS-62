package com.example.rpo_lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {
    private int curIndex = 0;
    ImageView image_view;

    Button backBut;

    private Integer[] pictures = {
            R.drawable.picture1,
            R.drawable.picture2,
            R.drawable.picture3,
            R.drawable.picture4,
            R.drawable.picture5,
            R.drawable.picture6,
            R.drawable.picture7,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        image_view = (ImageView) findViewById(R.id.gallery_image_view);
        image_view.setImageResource(pictures[curIndex]);

        backBut = (Button) findViewById(R.id.back);

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }

    public void previous(View view) {
        if (curIndex == 0) {
            curIndex = pictures.length - 1;
            image_view.setImageResource(pictures[curIndex]);
        } else {
            curIndex--;
            image_view.setImageResource(pictures[curIndex]);
        }
    }

    public void next(View view) {
        if (curIndex == pictures.length - 1) {
            curIndex = 0;
            image_view.setImageResource(pictures[curIndex]);
        } else {
            curIndex++;
            image_view.setImageResource(pictures[curIndex]);
        }
    }
}