package com.calistasakralya.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calistasakralya.API.APIService;
import com.calistasakralya.API.NoConnectivityException;
import com.calistasakralya.MainActivity;
import com.calistasakralya.R;
import com.calistasakralya.adapter.BalasAdapter;
import com.calistasakralya.model.InboxbalasModel;
import com.calistasakralya.response.GetBalas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class Detailpesan extends AppCompatActivity {
    private ProgressDialog pDialog;
    private Toolbar toolbar;
    private RecyclerView gridView;
    private List<InboxbalasModel> balasModels;
    private BalasAdapter balasAdapter;
    private Button tombolBalas;
    private EditText mPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpesan);
        initData();
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            setTitle("Lihat Pesan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
        /* Saat tombol di back maka akan diarahkan ke fragment inbox*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                this.onBackPressed();
            }

            private void onBackPressed() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("bukaInbox",true);
                finish();
                startActivity(intent);
            }
        });

        /* Mendapatkan data dari halaman sebelumnya */
        Intent iin= getIntent();
        Bundle extra = iin.getExtras();
        if(extra != null) {
            final String tokenPesan = extra.getString("key_token","0");
            dapatPesan(tokenPesan);
            setupRecyclerView();
            tombolBalas.setOnClickListener(v -> {
                String pesan = mPesan.getText().toString();
                if(pesan.length() == 0 ){
                    pesan("Semua kolom harus diisi!");
                } else {
                    simpanPesan(tokenPesan,pesan);
                }
            });
        }
    }

    /* Menyimpan pesan balasan ke dalam database */
    public void simpanPesan(String token, String pesan)
    {
        tampilLoading();
        try{
            Call<InboxbalasModel> call = APIService.Factory.create(this).simpanBalasan(token,pesan);
            call.enqueue(new Callback<InboxbalasModel>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<InboxbalasModel> call, Response<InboxbalasModel> response) {
                    SembunyiLoading();
                    if(response.isSuccessful()) {
                        if (response.body() != null) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("bukaInbox",true);
                            finish();
                            startActivity(intent);
                            pesan("Pesan berhasil dikirimkan!");
                        }
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<InboxbalasModel> call, Throwable t) {
                    SembunyiLoading();
                    if(t instanceof NoConnectivityException) {
                        pesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        }catch (Exception e){
            SembunyiLoading();
            e.printStackTrace();
            pesan(e.getMessage());
        }
    }



    /* Untuk mendapatkan data pesan yang ada di detail pesan */
    public void dapatPesan(String token)
    {
        tampilLoading();
        try {
            Call<GetBalas> call = APIService.Factory.create(this).dataDetail(token);
            call.enqueue(new Callback<GetBalas>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GetBalas> call, Response<GetBalas> response) {
                    SembunyiLoading();
                    if(response.isSuccessful()){
                        if(response.body() != null){
                            balasModels = response.body().getListInbox();
                            balasAdapter.replaceData(balasModels);
                        }
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GetBalas> call, Throwable t) {
                    SembunyiLoading();
                    if(t instanceof NoConnectivityException) {
                        pesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        }catch (Exception e){
            SembunyiLoading();
            e.printStackTrace();
            pesan(e.getMessage());
        }
    }

    /* Setup awal untuk Recyclerview*/
    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        balasAdapter = new BalasAdapter(new ArrayList<>());
        gridView.setLayoutManager(linearLayoutManager);
        gridView.setAdapter(balasAdapter);
    }

    /* Mempersiapkan data */
    private void initData()
    {
        mPesan = findViewById(R.id.txt_pesan);
        tombolBalas = findViewById(R.id.tbl_kirim);
        gridView = findViewById(R.id.rcPesan);
        toolbar = findViewById(R.id.tbtoolbar);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Loading.....");
    }

    /* menampilkan loading */
    private void tampilLoading(){
        if(!pDialog.isShowing()){
            pDialog.show();
        }
    }

    /* menghilangkan loading */
    private void SembunyiLoading(){
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }
    }

    public void pesan(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}