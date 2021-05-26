package com.example.a1hw1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton photo, telephone, google;
    Button enter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text3);

        photo = findViewById(R.id.button1);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPhoto = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intentPhoto);
            }
        });


        telephone = findViewById(R.id.button2);
        telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTelephone=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(996)708 767 408"));
                startActivity(intentTelephone);
            }
        });

        google =findViewById(R.id.button3);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Geek";
                Intent intentGoogle=new Intent(Intent.ACTION_WEB_SEARCH);
                intentGoogle.putExtra(SearchManager.QUERY, text);
                startActivity(intentGoogle);
            }
        });

        enter = findViewById(R.id.button4);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEnter= new Intent(MainActivity.this, MainActivity2.class);
               MainActivity.this.startActivityForResult(intentEnter,20);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != RESULT_CANCELED){
            if (requestCode == 20){
                String btn = data.getStringExtra("key");
                textView.setText(btn);
            }
        }
    }
}