package com.example.labjson;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<JSONObject> {
    int listLayout;
    ArrayList<JSONObject> usersList;
    Context context;

    public ListViewAdapter(Context context, int listLayout, int field, ArrayList<JSONObject> usersList) {
        super(context, listLayout, field, usersList);
        this.context = context;
        this.listLayout = listLayout;
        this.usersList = usersList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView name = listViewItem.findViewById(R.id.textViewName);
        TextView email = listViewItem.findViewById(R.id.textViewEmail);
        TextView id = listViewItem.findViewById(R.id.textView_Id);

        // Получите информацию о пользователе
        final JSONObject user = usersList.get(position);

        try {
            name.setText(user.getString("name"));
            email.setText(user.getString("email"));
            id.setText(user.getString("_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Установите обработчик кликов на элемент списка
        listViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создайте Intent для перехода на UserDetailActivity и передачи информации о пользователе
                Intent intent = new Intent(context, UserDetailActivity.class);
                intent.putExtra("user", user.toString());
                context.startActivity(intent);
            }
        });

        return listViewItem;
    }
}
