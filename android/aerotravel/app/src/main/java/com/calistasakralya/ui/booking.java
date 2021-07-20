package com.calistasakralya.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.calistasakralya.R;

public class booking extends AppCompatActivity {
    private ImageView btnMPrivat,btnMOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Toolbar toolbar = findViewById(R.id.tbtoolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            setTitle("Booking");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
        initData();
        btnMPrivat.setOnClickListener(v -> {
            Intent intent = new Intent(booking.this, privattrip.class);
            startActivity(intent);
        });
        btnMOpen.setOnClickListener(v -> {
            Intent intent = new Intent(booking.this, opentrip.class);
            startActivity(intent);
        });
    }
    /* Mempersiapkan data */
    private void initData()
    {
        btnMPrivat = findViewById(R.id.btnPrivat);
        btnMOpen = findViewById(R.id.btnOpen);
    }

}