package com.calistasakralya.ui;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.calistasakralya.API.APIService;
import com.calistasakralya.API.NoConnectivityException;
import com.calistasakralya.R;
import com.calistasakralya.adapter.HargaAdapter;
import com.calistasakralya.config.Constants;
import com.calistasakralya.model.BookingModel;
import com.calistasakralya.model.HargaModel;
import com.calistasakralya.model.PaketModel;
import com.calistasakralya.model.StringWithTag;
import com.calistasakralya.response.GetHarga;
import com.calistasakralya.response.GetPaket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class opentrip extends AppCompatActivity {
    private EditText edTanggal,edPaket,edJumlah;
    private Spinner mSpinPaket;
    private ProgressDialog pDialog;
    private RecyclerView gridView;
    private List<HargaModel> hargaModels;
    private HargaAdapter hargaAdapter;
    private ImageView mBtnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opentrip);
        Toolbar toolbar = findViewById(R.id.tbtoolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            setTitle("Open Trip");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
        initData();
        setupRecyclerView();



        /* Menampilkan calendar picker */
        final Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = (view, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String myFormat = "dd-MM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ITALY);
            edTanggal.setText(sdf.format(myCalendar.getTime()));
        };
        edTanggal.setOnClickListener(v -> new DatePickerDialog(opentrip.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show());



        /* Menampilkan spinner paket */
        populateSpinner(getApplicationContext());
        mSpinPaket.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StringWithTag s = (StringWithTag) parent.getItemAtPosition(position) ;
                String tag = s.tag;
                edPaket.setText(tag);
                dapatHarga(tag);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                edPaket.setText("");
            }
        });
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                Constants.KEY_USER_SESSION, Context.MODE_PRIVATE);
        String idUser = sharedPreferences.getString("idUser", "");
        /* tombol checkout */
        mBtnCheckout.setOnClickListener(v -> {
            String tanggal = edTanggal.getText().toString();
            String idPaket = edPaket.getText().toString();
            String jumlah = edJumlah.getText().toString();
            if(tanggal.length() == 0 || idPaket.length() == 0 || jumlah.length() == 0){
                pesan("Semua kolom harus diisi!");
            } else {
                simpanBooking(idPaket,idUser,tanggal,jumlah);
            }
        });
    }

    /* simpan booking */
    public void simpanBooking(String idPaket,String idUser, String tanggal, String jumlah){
        tampilLoading();
        try {
            Call<BookingModel> callBooking = APIService.Factory.create(getApplicationContext()).simpanBooking(idUser, idPaket, tanggal, jumlah);
            callBooking.enqueue(new Callback<BookingModel>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<BookingModel> call, Response<BookingModel> response) {
                    SembunyiLoading();
                    if(response.isSuccessful()) {
                        if(response.body() != null){
                            String namaProduk = mSpinPaket.getSelectedItem().toString();
                            String totalHarga = response.body().getTotal_harga();
                            Intent intent = new Intent(opentrip.this, Berhasil.class);
                            intent.putExtra("namaProduk", namaProduk);
                            intent.putExtra("jumlahPeserta", jumlah);
                            intent.putExtra("tanggalWisata", tanggal);
                            intent.putExtra("totalHarga", totalHarga);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<BookingModel> call, Throwable t) {
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

    /* Mendapatkan Harga */
    public void dapatHarga(String idPaket) {
        tampilLoading();
        try{
            Call<GetHarga> callHarga = APIService.Factory.create(getApplicationContext()).dapatkanHarga(idPaket);
            callHarga.enqueue(new Callback<GetHarga>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GetHarga> call, Response<GetHarga> response) {
                    SembunyiLoading();
                    if(response.isSuccessful()) {
                        if (response.body() != null) {
                            hargaModels = response.body().getListHarga();
                            hargaAdapter.replaceData(hargaModels);
                        }
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GetHarga> call, Throwable t) {
                    SembunyiLoading();
                    if(t instanceof NoConnectivityException) {
                        pesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        } catch (Exception e){
            SembunyiLoading();
            e.printStackTrace();
            pesan(e.getMessage());
        }
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
        hargaAdapter = new HargaAdapter(new ArrayList<>());
        gridView.setLayoutManager(linearLayoutManager);
        gridView.setAdapter(hargaAdapter);
    }


    private void initData(){
        mBtnCheckout = findViewById(R.id.btnCheckout);
        gridView = findViewById(R.id.rcHarga);
        edTanggal = findViewById(R.id.mycalender);
        edPaket = findViewById(R.id.idPaket);
        edJumlah = findViewById(R.id.edJumlahPeserta);
        mSpinPaket = findViewById(R.id.spinnerPaket);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Loading.....");
    }

    /* ini untuk mengisi spinner melalui database */
    private void populateSpinner(final Context mContext) {
        tampilLoading();
        try{
            Call<GetPaket> callPaket  = APIService.Factory.create(mContext).spinnerPaket("1");
            callPaket.enqueue(new Callback<GetPaket>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GetPaket> call, Response<GetPaket> response) {
                    SembunyiLoading();
                    if(response.isSuccessful()) {
                        if (response.body() != null) {
                            List<PaketModel> dataPaket = response.body().getListPaketModel();
                            List<StringWithTag> listSpinner = new ArrayList<>();
                            for(int i = 0; i < dataPaket.size(); i++){
                                listSpinner.add(new StringWithTag(dataPaket.get(i).getJudul_paket(),dataPaket.get(i).getId_paket()));
                            }
                            /* Memasukkan data ke dalam spinner */
                            ArrayAdapter<StringWithTag> adapter = new ArrayAdapter<>(mContext,
                                    android.R.layout.simple_spinner_item, listSpinner);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            mSpinPaket.setAdapter(adapter);
                        }
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GetPaket> call, Throwable t) {
                    SembunyiLoading();
                    if(t instanceof NoConnectivityException) {
                        pesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        }catch(Exception e){
            SembunyiLoading();
            e.printStackTrace();
            pesan(e.getMessage());
        }
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