package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products = new ArrayList<Product>();
BoxAdapter boxAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        boxAdapter = new BoxAdapter(this, products);
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }
    void fillData(){
        for (int i = 1;i<=10;i++){
            products.add(new Product("Product " + i,"ID:" + i,"Price:" + i * 1000,R.drawable.ic_launcher_foreground,false));
        }
    }
    public void showResult(View v){
        String result = "Товары в корзине:";
        for (Product p:boxAdapter.getBox()){
            if(p.box) {
             result+="\n"+p.name;
            }
        }
        String Data = result;
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("abc",Data);
        startActivity(intent);finish();
        Toast toast = Toast.makeText(MainActivity.this,"Нажимает Кулешов",Toast.LENGTH_LONG);
        toast.show();
    }
}