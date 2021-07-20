package com.calistasakralya.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.calistasakralya.MainActivity;
import com.calistasakralya.R;

public class Detailorder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailorder);
        Toolbar toolbar = findViewById(R.id.tbtoolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            setTitle("Informasi Transfer");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                this.onBackPressed();
            }

            private void onBackPressed() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("bukaOrder",true);
                finish();
                startActivity(intent);
            }
        });
    }
}