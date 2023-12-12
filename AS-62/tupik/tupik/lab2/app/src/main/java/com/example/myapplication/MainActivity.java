package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.myapplication.databinding.ActivityMainBinding;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String JSON_URL="http://m1.maxfad.ru/api/users.json";
    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageList = {R.drawable.picture0, R.drawable.picture1,R.drawable.picture2,R.drawable.picture3,R.drawable.picture4};
        int[] ingredientList = {R.string.pancakeIngredients,R.string.burgerIngredients,R.string.maggiIngredients,R.string.cakeIngredients,R.string.pastaIngredients};
        int[] descList = {R.string.pancakeDesc,R.string.burgerDesc,R.string.maggiIngredients,R.string.cakeDesc,R.string.pastaIngredients};
        String[] nameList = {"Phasmo Разработал Тупик","Русы против ящеров","Rimworld","Epic games","Blender"};
        String[] timeList = {"30 mins","2 mins","45 mins", "10 mins", "60 mins"};
        for(int i=0; i<imageList.length; i++){
listData = new ListData(nameList[i],timeList[i],ingredientList[i],descList[i],imageList[i]);
dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this,dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("name",nameList[i]);
                intent.putExtra("time",timeList[i]);
                intent.putExtra("ingredients",ingredientList[i]);
                Toast toast = Toast.makeText(MainActivity.this,"Нажимает Тупик",Toast.LENGTH_LONG);
                toast.show();
                //intent.putExtra("desc",descList[i]);
                intent.putExtra("image",imageList[i]);
                startActivity(intent);
            }
        });
    }
    public static String EncodingToUTF8(String response){
        byte[] code = response.getBytes(StandardCharsets.ISO_8859_1);
        response = new String(code, StandardCharsets.UTF_8);
        return response;
    }
}