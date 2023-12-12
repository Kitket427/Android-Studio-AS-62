package com.example.labjson;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_FILE_NAME = "item.json";
    ListView listView;

    EditText editTextUserCount;
    Button buttonLoadUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        editTextUserCount = findViewById(R.id.editTextUserCount);
        buttonLoadUsers = findViewById(R.id.buttonLoadUsers);
        buttonLoadUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получите введенное пользователем число
                String countText = editTextUserCount.getText().toString();
                if (!countText.isEmpty()) {
                    int userCount = Integer.parseInt(countText);
                    loadJSONFromFile(JSON_FILE_NAME, userCount);
                } else {
                    Toast.makeText(getApplicationContext(), "Введите число пользователей", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadJSONFromFile(String fileName, int userCount) {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ListView.VISIBLE);
        String jsonString = null;

        try {
            InputStream inputStream = getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonString = new String(buffer, "UTF-8");
            // Обработка JSON-данных и ограничение количества пользователей
            JSONArray jsonArray = new JSONArray(jsonString);
            ArrayList<JSONObject> listItems = getArrayListFromJSONArray(jsonArray);

            if (userCount < listItems.size()) {
                listItems.subList(userCount, listItems.size()).clear();
            }

            ListAdapter adapter = new ListViewAdapter(getApplicationContext(), R.layout.raw, R.id.textViewName, listItems);
            listView.setAdapter(adapter);

            progressBar.setVisibility(View.INVISIBLE);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "Ошибка чтения файла JSON", Toast.LENGTH_SHORT).show();
        }
    }



    private ArrayList< JSONObject> getArrayListFromJSONArray(JSONArray jsonArray){
        ArrayList< JSONObject> aList = new ArrayList< JSONObject>();
        try {
            if(jsonArray!= null){
                for(int i = 0; i< jsonArray.length();i++){
                    aList.add(jsonArray.getJSONObject(i));
                }
            }
        }catch (JSONException js){
            js.printStackTrace();
        }
        return aList;
    }



}