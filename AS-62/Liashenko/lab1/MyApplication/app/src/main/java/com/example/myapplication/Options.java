package com.example.myapplication;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends Activity {

    Button x3x4;
    Button x4x4;
    Button x5x4;
    Button x6x4;
    Button back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        x3x4 = (Button)findViewById(R.id.x3x3);
        x4x4 = (Button)findViewById(R.id.x4x4);
        x5x4 = (Button)findViewById(R.id.x5x5);
        x6x4 = (Button)findViewById(R.id.x6x6);
        back = (Button)findViewById(R.id.options_back);

        x3x4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("options", 3);
                StartMenu.FieldSize = 3;
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        x4x4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("options", 4);
                StartMenu.FieldSize = 4;
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        x5x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("options", 5);
                StartMenu.FieldSize = 5;
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        x6x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("options", 6);
                StartMenu.FieldSize = 6;
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
