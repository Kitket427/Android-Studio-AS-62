package com.example.myapplication;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnBack;
    private GridView mGrid;
    private GridAdapter mAdapter;
    private TextView mStepScreen;
    private Chronometer mTimeScreen;
    private Integer StepCount;
    private Integer FieldSize;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Bundle arguments = getIntent().getExtras();
        FieldSize = (Integer) arguments.getInt("options", 3);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeScreen = (Chronometer) findViewById(R.id.timeview);
        mStepScreen = (TextView)findViewById(R.id.stepview);

        StepCount = 0;
        mStepScreen.setText (StepCount.toString());

        mTimeScreen.start();

        mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(FieldSize);
        mGrid.setEnabled(true);

        btnBack = (Button) findViewById(R.id.game_back);

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,int position, long id) {

                mAdapter.checkOpenCells ();
                if (mAdapter.openCell (position)) {
                    StepCount ++;
                    mStepScreen.setText (StepCount.toString());
                }

                mStepScreen.setText (StepCount.toString());
                if (mAdapter.checkGameOver())
                {
                    mTimeScreen.stop();
                    String time = mTimeScreen.getText().toString();
                    String TextToast = "Игра закончена " + StepCount.toString() + " Ходов; " + "Время: " + time;
                    Toast.makeText (getApplicationContext(), TextToast, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mAdapter = new GridAdapter(this, 4, FieldSize);
        mGrid.setAdapter(mAdapter);
    }
}