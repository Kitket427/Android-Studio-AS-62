package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton imgButton1;
    ImageButton imgButton2;
    ImageButton imgButton3;
    ImageButton imgButton4;
    ImageButton imgButton5;
    ImageButton imgButton6;
    ImageButton imgButton7;
    ImageButton imgButton8;
    ImageButton imgButton9;
    ImageButton imgButton10;
    ImageButton imgButton11;
    ImageButton imgButton12;
    ImageButton imgButton13;
    ImageButton imgButton14;
    ImageButton imgButton15;
    ImageButton imgButton16;
    boolean flag1;
    boolean flag2;
    boolean flag3;
    boolean flag4;
    boolean flag5;
    boolean flag6;
    boolean flag7;
    boolean flag8;
    boolean flag9;
    boolean flag10;
    boolean flag11;
    boolean flag12;
    boolean flag13;
    boolean flag14;
    boolean flag15;
    boolean flag16;
    int f1=0;
    int f2=0;
    int f3=0;
    int f4=0;
    int f5=0;
    int f6=0;
    int f7=0;
    int f8=0;
    int f9=0;
    int f10=0;
    int f11=0;
    int f12=0;
    int f13=0;
    int f14=0;
    int f15=0;
    int f16=0;
    int stop = 0;
    int delete1 = 0;
    int delete2 = 0;
    int delete3 = 0;
    int delete4 = 0;
    int delete5 = 0;
    int delete6 = 0;
    int delete7 = 0;
    int delete8 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgButton1=(ImageButton)findViewById(R.id.imageButton);
        imgButton2=(ImageButton)findViewById(R.id.imageButton2);
        imgButton3=(ImageButton)findViewById(R.id.imageButton3);
        imgButton4=(ImageButton)findViewById(R.id.imageButton4);
        imgButton5=(ImageButton)findViewById(R.id.imageButton5);
        imgButton6=(ImageButton)findViewById(R.id.imageButton6);
        imgButton7=(ImageButton)findViewById(R.id.imageButton7);
        imgButton8=(ImageButton)findViewById(R.id.imageButton8);
        imgButton9=(ImageButton)findViewById(R.id.imageButton9);
        imgButton10=(ImageButton)findViewById(R.id.imageButton10);
        imgButton11=(ImageButton)findViewById(R.id.imageButton11);
        imgButton12=(ImageButton)findViewById(R.id.imageButton12);
        imgButton13=(ImageButton)findViewById(R.id.imageButton13);
        imgButton14=(ImageButton)findViewById(R.id.imageButton14);
        imgButton15=(ImageButton)findViewById(R.id.imageButton15);
        imgButton16=(ImageButton)findViewById(R.id.imageButton16);
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
Intent intent = new Intent(MainActivity.this, MainActivity.class);
Toast toast = Toast.makeText(MainActivity.this,"Нажимает Кулешов",Toast.LENGTH_LONG);
toast.show();
startActivity(intent);finish();
                }catch(Exception e){

                }
            }
        });
        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag1 && delete1==0) {
                    f1 = 0;
                    flag1 = !flag1;
                    imgButton1.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f1 = 1;
                    if (f16 == f1 || delete1==1) {
                        delete1 = 1;
                        imgButton16.setImageResource(R.drawable.not_picture);
                        imgButton1.setImageResource(R.drawable.not_picture);
                    }
                    else {
                            imgButton1.setImageResource(R.drawable.picture0);
                    }
                    flag1 = !flag1;
                }
            }
        });
        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag2 && delete2==0) {
                    f2 = 0;
                    flag2 = !flag2;
                    imgButton2.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f2 = 2;
                    if (f2 == f12 || delete2==1) {
                        delete2=1;
                        imgButton12.setImageResource(R.drawable.not_picture);
                        imgButton2.setImageResource(R.drawable.not_picture);
                    }
                    else {
                            imgButton2.setImageResource(R.drawable.picture1);
                    }
                    flag2 = !flag2;
                }
            }
        });
        imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag3 && delete3==0) {
                    f3 = 0;
                    flag3 = !flag3;
                    imgButton3.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f3 = 3;
                    if (f3 == f7 || delete3==1) {
                        delete3 = 1;
                        imgButton3.setImageResource(R.drawable.not_picture);
                        imgButton7.setImageResource(R.drawable.not_picture);
                    }
                    else {
                            imgButton3.setImageResource(R.drawable.picture2);
                    }
                    flag3 = !flag3;
                }
            }
        });
        imgButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag4 && delete4==0) {
                    f4 = 0;
                    flag4 = !flag4;
                    imgButton4.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f4 = 4;
                    if (f4 == f6 || delete4==1) {
                        delete4=1;
                        imgButton4.setImageResource(R.drawable.not_picture);
                        imgButton6.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton4.setImageResource(R.drawable.picture3);
                    }
                    flag4 = !flag4;
                }
            }
        });
        imgButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag5 && delete5==0) {
                    f5 = 0;
                    flag5 = !flag5;
                    imgButton5.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f5 = 5;
                    if (f5 == f9 || delete5==1) {
                        delete5=1;
                        imgButton5.setImageResource(R.drawable.not_picture);
                        imgButton9.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton5.setImageResource(R.drawable.picture4);
                    }
                    flag5 = !flag5;
                }
            }
        });
        imgButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag6 && delete4==0) {
                    f6 = 0;
                    flag6 = !flag6;
                    imgButton6.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f6 = 4;
                    if (f6 == f4 || delete4==1) {
                        delete4=1;
                        imgButton6.setImageResource(R.drawable.not_picture);
                        imgButton4.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton6.setImageResource(R.drawable.picture3);
                    }
                    flag6 = !flag6;
                }
            }
        });
        imgButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag7 && delete3==0) {
                    f7 = 0;
                    flag7 = !flag7;
                    imgButton7.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f7 = 3;
                    if (f7 == f3 || delete3==1) {
                        delete3=1;
                        imgButton7.setImageResource(R.drawable.not_picture);
                        imgButton3.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton7.setImageResource(R.drawable.picture2);
                    }
                    flag7 = !flag7;
                }
            }
        });
        imgButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag8 && delete6==0) {
                    f8 = 0;
                    flag8 = !flag8;
                    imgButton8.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f8 = 8;
                    if (f8 == f14 || delete6==1) {
                        delete6=1;
                        imgButton8.setImageResource(R.drawable.not_picture);
                        imgButton14.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton8.setImageResource(R.drawable.picture5);

                    }
                    flag8 = !flag8;
                }
            }
        });
        imgButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag9 && delete5==0) {
                    f9 = 0;
                    flag9 = !flag9;
                    imgButton9.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f9 = 5;
                    if (f5 == f9 || delete5==1) {
                        delete5=1;
                        imgButton5.setImageResource(R.drawable.not_picture);
                        imgButton9.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton9.setImageResource(R.drawable.picture4);
                    }
                    flag9 = !flag9;
                }
            }
        });
        imgButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag10 && delete7==0) {
                    f10 = 0;
                    flag10 = !flag10;
                    imgButton10.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f10 = 10;
                    if (f10 == f13 || delete7==1) {
                        delete7=1;
                        imgButton10.setImageResource(R.drawable.not_picture);
                        imgButton13.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton10.setImageResource(R.drawable.picture6);

                    }
                    flag10 = !flag10;
                }
            }
        });
        imgButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag11 && delete8==0) {
                    f11 = 0;
                    flag11 = !flag11;
                    imgButton11.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f11 = 11;
                    if (f11 == f15 || delete8==1) {
                        delete8=1;
                        imgButton11.setImageResource(R.drawable.not_picture);
                        imgButton15.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton11.setImageResource(R.drawable.picture7);
                    }
                    flag11 = !flag11;
                }
            }
        });
        imgButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag12 && delete2==0) {
                    f12 = 0;
                    flag12 = !flag12;
                    imgButton12.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f12 = 2;
                    if (f2 == f12 || delete2==1) {
                        delete2=1;
                        imgButton2.setImageResource(R.drawable.not_picture);
                        imgButton12.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton12.setImageResource(R.drawable.picture1);
                    }
                    flag12 = !flag12;
                }
            }
        });
        imgButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag13 && delete7==0) {
                    f13 = 0;
                    flag13 = !flag13;
                    imgButton13.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f13 = 10;
                    if (f13 == f10 || delete7==1) {
                        delete7=1;
                        imgButton13.setImageResource(R.drawable.not_picture);
                        imgButton10.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton13.setImageResource(R.drawable.picture6);

                    }
                    flag13 = !flag13;
                }
            }
        });
        imgButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag14 && delete6==0) {
                    f14 = 0;
                    flag14 = !flag14;
                    imgButton14.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f14 = 8;
                    if (f14 == f8 || delete6==1) {
                        delete6=1;
                        imgButton14.setImageResource(R.drawable.not_picture);
                        imgButton8.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton14.setImageResource(R.drawable.picture5);

                    }
                    flag14 = !flag14;
                }
            }
        });
        imgButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag15 && delete8==0) {
                    f15 = 0;
                    flag15 = !flag15;
                    imgButton15.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f15 = 11;
                    if (f15 == f11 || delete8==1) {
                        delete8=1;
                        imgButton15.setImageResource(R.drawable.not_picture);
                        imgButton11.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton15.setImageResource(R.drawable.picture7);

                    }
                    flag15 = !flag15;
                }
            }
        });
        imgButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag16 && delete1==0) {
                    f16 = 0;
                    flag16 = !flag16;
                    imgButton16.setImageResource(R.drawable.ic_launcher_background);
                }
                else {
                    f16 = 1;
                    if (f16 == f1 || delete1 == 1) {
                        delete1=1;
                        imgButton16.setImageResource(R.drawable.not_picture);
                        imgButton1.setImageResource(R.drawable.not_picture);
                    }
                    else {
                        imgButton16.setImageResource(R.drawable.picture0);
                    }
                    flag16 = !flag16;
                }
            }
        });
    }
}