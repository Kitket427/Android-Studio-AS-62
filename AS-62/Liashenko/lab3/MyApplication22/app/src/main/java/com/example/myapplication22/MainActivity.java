package com.example.myapplication22;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
class Product implements Serializable {

    String name;
    int price;
    int image;
    boolean box;


    Product(String _describe, int _price, int _image, boolean _box) {
        name = _describe;
        price = _price;
        image = _image;
        box = _box;
    }
}

public class MainActivity extends Activity {

    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Product> favProducts = new ArrayList<>();
    BoxAdapter boxAdapter;
    int count;
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView2);
        tv.setText(Integer.toString(count));
        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvSecond);
        lvMain.setAdapter(boxAdapter);
    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 3; i++) {
            products.add(new Product("Litol-24", i * 54,
                    R.drawable.litol24, false));
            products.add(new Product("TAD-17", i * 45,
                    R.drawable.tad17, false));
            products.add(new Product("Mita-2T ", i * 32,
                    R.drawable.mita2t, false));
            products.add(new Product("WD-40", i * 17,
                    R.drawable.wd40, false));
            products.add(new Product("LDS", i * 48,
                    R.drawable.lds, false));
        }
    }

    public void clickOpenFav(View view) {
        favProducts.clear();
        Intent intent = new Intent(this, SecondActivity.class);
        for (Product p : boxAdapter.getBox()) {
            if (p.box)
            {
                favProducts.add(p);
            }
        }
        intent.putExtra("list", favProducts);
        startActivity(intent);
    }
    public TextView tv;
    public void onCheckboxClicked(View view)
    {
        tv=(TextView)findViewById(R.id.textView2);
        CheckBox cb = (CheckBox)view;
        if (cb.isChecked())
            count++;
        else
            count--;
        tv.setText(Integer.toString(count));
    }
}

