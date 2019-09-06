package com.example.hfe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView im1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im1 = findViewById(R.id.imageView);
        im1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == im1){
            startActivity(new Intent(MainActivity.this,Login.class));
        }
    }
}
