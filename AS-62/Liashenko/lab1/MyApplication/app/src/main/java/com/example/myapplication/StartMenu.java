package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartMenu extends Activity {
    int game_options = 6;
    Button mStart;
    Button mExit;
    Button mOptions;
    static Integer FieldSize = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu);

        mStart = (Button)findViewById(R.id.start_btn);
        mExit = (Button)findViewById(R.id.exit_btn);
        mOptions = (Button)findViewById(R.id.options_btn);

        mStart.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        mExit.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOptions();
            }
        });
    }

    private void startGame () {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("options", FieldSize);
        setResult(RESULT_OK, i);
        startActivity (i);
    }
    private void openOptions () {
        Intent i = new Intent(this, Options.class);
        startActivityForResult (i, RESULT_OK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null){
            return;
        }
        game_options = data.getIntExtra("options", 3);
    }

}
