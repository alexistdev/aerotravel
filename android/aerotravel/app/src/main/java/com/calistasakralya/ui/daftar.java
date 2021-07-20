package com.calistasakralya.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.calistasakralya.API.APIService;
import com.calistasakralya.MainActivity;
import com.calistasakralya.R;
import com.calistasakralya.model.APIError;
import com.calistasakralya.model.ClientModel;
import com.calistasakralya.utils.ErrorUtils;
import com.calistasakralya.utils.SessionHandle;
import java.util.regex.Pattern;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class daftar extends AppCompatActivity {
    private EditText mNama,mEmail,mPassword,mPhone;
    private ImageView mBtnDaftar;
    private TextView mBtnLogin;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        init();
        if(SessionHandle.isLoggedIn(this)){
            Intent intent = new Intent(daftar.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        mBtnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(daftar.this, login.class);
            startActivity(intent);
        });
        mBtnDaftar.setOnClickListener(v -> prosesSimpan());
    }
    private void prosesSimpan(){
        tampilLoading();
        String namaLengkap = mNama.getText().toString();
        String alamatEmail = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String phone = mPhone.getText().toString();
        if(namaLengkap.length() == 0 || alamatEmail.length() == 0 || password.length() == 0 || phone.length() == 0){
            SembunyiLoading();
            pesan("Semua kolom harus diisi!");
        } else {
            if(cekEmail(alamatEmail)){
                try{
                    Call<ClientModel> call= APIService.Factory.create(getApplicationContext()).tambahUser(namaLengkap,alamatEmail,password,phone);
                    call.enqueue(new Callback<ClientModel>() {
                        @EverythingIsNonNull
                        @Override
                        public void onResponse(Call<ClientModel> call, Response<ClientModel> response) {
                            if(response.isSuccessful()) {
                                SembunyiLoading();
                                Intent intent = new Intent(daftar.this, login.class);
                                startActivity(intent);
                                finish();
                                pesan("Akun Berhasil dibuat!");
                            }else{
                                SembunyiLoading();
                                APIError error = ErrorUtils.parseError(response);
                                pesan(error.message());
                            }
                        }
                        @EverythingIsNonNull
                        @Override
                        public void onFailure(Call<ClientModel> call, Throwable t) {
                            SembunyiLoading();
                            pesan(t.getMessage());
                        }
                    });
                }catch (Exception e){
                    SembunyiLoading();
                    e.printStackTrace();
                    pesan(e.getMessage());
                }
            }else{
                SembunyiLoading();
                pesan("Masukkan email yang valid!");
            }
        }
    }

    private boolean cekEmail(String email){
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

    public void init() {
        mBtnDaftar = findViewById(R.id.tombol_daftar);
        mBtnLogin = findViewById(R.id.txt_login);
        mNama = findViewById(R.id.txt_nama);
        mEmail = findViewById(R.id.txt_email);
        mPassword = findViewById(R.id.txt_password);
        mPhone = findViewById(R.id.txt_phone);
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

    public void pesan(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}