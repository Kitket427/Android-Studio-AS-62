package com.example.labjson;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raw);

        TextView textViewUserName = findViewById(R.id.textViewName);
        TextView textViewUserEmail = findViewById(R.id.textViewEmail);
        TextView textViewUserId = findViewById(R.id.textView_Id);

        // Получите информацию о пользователе из Intent
        String userData = getIntent().getStringExtra("user");

        try {
            JSONObject user = new JSONObject(userData);
            String name = user.getString("name");
            String email = user.getString("email");
            String id = user.getString("_id");

            // Отобразите информацию о пользователе
            textViewUserName.setText("Name: " + name);
            textViewUserEmail.setText("Email: " + email);
            textViewUserId.setText("ID: " + id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
