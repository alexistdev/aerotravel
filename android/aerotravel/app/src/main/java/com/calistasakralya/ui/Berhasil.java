package com.calistasakralya.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.calistasakralya.MainActivity;
import com.calistasakralya.R;

public class Berhasil extends AppCompatActivity {
    private ImageView mBtnLanjutkan;
    private TextView txtJumlah,txtTanggal,txtTotal,txtNamaPaket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil);
        initData();
        Intent iin= getIntent();
        Bundle extra = iin.getExtras();
        if(extra != null) {
            final String namaProduk = extra.getString("namaProduk", "0");
            final String jumlahPeserta = extra.getString("jumlahPeserta", "0");
            final String tanggalWisata = extra.getString("tanggalWisata", "0");
            final String totalHarga = extra.getString("totalHarga", "0");
            txtJumlah.setText(jumlahPeserta);
            txtTanggal.setText(tanggalWisata);
            txtTotal.setText(totalHarga);
            txtNamaPaket.setText(namaProduk);
        }
        mBtnLanjutkan.setOnClickListener(v -> {
            Intent intent = new Intent(Berhasil.this, MainActivity.class);
            intent.putExtra("bukaOrder",true);
            startActivity(intent);
            finish();
        });
    }

    private void initData() {
        mBtnLanjutkan = findViewById(R.id.btnLanjutkan);
        txtJumlah = findViewById(R.id.txtJumlahPeserta);
        txtTanggal = findViewById(R.id.txtTanggal);
        txtTotal = findViewById(R.id.txtTotalBayar);
        txtNamaPaket = findViewById(R.id.txtNamaPaket);
    }
}