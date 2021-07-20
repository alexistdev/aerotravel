package com.calistasakralya.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.calistasakralya.API.APIService;
import com.calistasakralya.API.NoConnectivityException;
import com.calistasakralya.MainActivity;
import com.calistasakralya.R;
import com.calistasakralya.config.Constants;
import com.calistasakralya.model.InboxModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class Tambahpesan extends AppCompatActivity {
    private EditText mJudul,mIsiPesan;
    private Toolbar toolbar;
    private Button mKirim;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahpesan);
        initData();
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            setTitle("Kirim Pesan");
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
                intent.putExtra("bukaInbox",true);
                finish();
                startActivity(intent);
            }
        });

        mKirim.setOnClickListener(v -> {
            String judulPesan = mJudul.getText().toString();
            String isiPesan = mIsiPesan.getText().toString();
            if(judulPesan.length() == 0 || isiPesan.length() == 0 ){
                pesan("Semua kolom harus diisi!");
            } else {
                kirimPesan(judulPesan,isiPesan);
            }
        });
    }

    public void kirimPesan(String judul,String pesan)
    {
        tampilLoading();
        try{
            SharedPreferences sharedPreferences = this.getSharedPreferences(
                    Constants.KEY_USER_SESSION, Context.MODE_PRIVATE);
            String idUser = sharedPreferences.getString("idUser", "");
            Call<InboxModel> call = APIService.Factory.create(getApplicationContext()).simpanPesan(idUser,judul,pesan);
            call.enqueue(new Callback<InboxModel>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<InboxModel> call, Response<InboxModel> response) {
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
                public void onFailure(Call<InboxModel> call, Throwable t) {
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

    /* Mempersiapkan data */
    private void initData()
    {
        mJudul = findViewById(R.id.txt_judul);
        mIsiPesan = findViewById(R.id.txt_pesan);
        toolbar = findViewById(R.id.tbtoolbar);
        mKirim = findViewById(R.id.tbl_kirim);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Loading.....");
    }

    private void tampilLoading(){
        if(!pDialog.isShowing()){
            pDialog.show();
        }
    }

    private void SembunyiLoading(){
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }
    }

    private void pesan(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
