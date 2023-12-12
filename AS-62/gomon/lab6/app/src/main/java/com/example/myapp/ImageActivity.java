package com.example.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_OPEN_DIRECTORY = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        // Запрос разрешения на доступ к файлам
        openImageDirectory();
    }

    private void openImageDirectory() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CODE_OPEN_DIRECTORY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_OPEN_DIRECTORY && resultCode == RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                // Передайте этот URI во ViewPager для отображения изображений из выбранной папки
                // Например, можно получить список изображений в выбранной папке и передать его в адаптер
                // После этого отобразите выбранные изображения в ViewPager
            }
        }
    }
}
