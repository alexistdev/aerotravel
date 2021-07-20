package com.calistasakralya.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.calistasakralya.R;
import com.calistasakralya.adapter.GambarAdapter;
import com.calistasakralya.adapter.ViewFasilitasPagerAdapter;
import com.calistasakralya.adapter.ViewPagerAdapter;
import com.calistasakralya.model.DestinasiModel;
import com.calistasakralya.model.GambarWisata;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Objects;


public class Detaildestinasi extends AppCompatActivity {
    private final ArrayList<GambarWisata> images = new ArrayList<>();
    private RecyclerView gambarView;
    private ImageView mBooking;
    private ViewPager2 viewpager,viewpagerfasilitas;
    private TabLayout tabLayout,tabFasilitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildestinasi);
        Toolbar toolbar = findViewById(R.id.tbtoolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
        /* inisiasi dari program ini */
        initData();
        /* Mendapatkan data dari halaman sebelumnya */
        Intent iin= getIntent();
        Bundle extra = iin.getExtras();
        DestinasiModel destinasi = (DestinasiModel) extra.getSerializable("destinasi") ;
        /* Aktifkan ViewPager Jadwal */
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, destinasi.getId_destinasi());
        viewpager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewpager,
                (tab, position) -> {
                    tab.setText(((ViewPagerAdapter)(Objects.requireNonNull(viewpager.getAdapter()))).mFragmentNames[position]);//Sets tabs names as mentioned in ViewPagerAdapter fragmentNames array, this can be implemented in many different ways.
                }
        ).attach();

        /* Aktifkan ViewPager Fasilitas */
        viewpagerfasilitas.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        ViewFasilitasPagerAdapter viewFasilitasPagerAdapter = new ViewFasilitasPagerAdapter(this, destinasi.getId_destinasi());
        viewpagerfasilitas.setAdapter(viewFasilitasPagerAdapter);
        new TabLayoutMediator(tabFasilitas, viewpagerfasilitas,
                (tab, position) -> {
                    tab.setText(((ViewFasilitasPagerAdapter)(Objects.requireNonNull(viewpagerfasilitas.getAdapter()))).mFragmentNames[position]);//Sets tabs names as mentioned in ViewPagerAdapter fragmentNames array, this can be implemented in many different ways.
                }
        ).attach();
        /* Pengaturan Paralax Image display */
        setTitle(destinasi.getJudul_destinasi());
//        if(destinasi.getGambar1().length()>0){
//            images.add(new GambarWisata(destinasi.getGambar1()));
//        }
//        if(destinasi.getGambar2().length()>0){
//            images.add(new GambarWisata(destinasi.getGambar2()));
//        }
//        if(destinasi.getGambar3().length()>0){
//            images.add(new GambarWisata(destinasi.getGambar3()));
//        }
//        if(destinasi.getGambar4().length()>0){
//            images.add(new GambarWisata(destinasi.getGambar4()));
//        }
//        if(destinasi.getGambar5().length()>0){
//            images.add(new GambarWisata(destinasi.getGambar5()));
//        }
        if(destinasi.getGambar1() != null){
            images.add(new GambarWisata(destinasi.getGambar1()));
        }
        if(destinasi.getGambar2() != null){
            images.add(new GambarWisata(destinasi.getGambar2()));
        }
        if(destinasi.getGambar3() != null){
            images.add(new GambarWisata(destinasi.getGambar3()));
        }
        if(destinasi.getGambar4() != null){
            images.add(new GambarWisata(destinasi.getGambar4()));
        }
        if(destinasi.getGambar5() != null){
            images.add(new GambarWisata(destinasi.getGambar5()));
        }
        setupRecyclerView();
        mBooking.setOnClickListener(v -> {
            Intent intent = new Intent(Detaildestinasi.this, booking.class);
            startActivity(intent);
            finish();
        });
    }

    /* Mempersiapkan data */
    private void initData()
    {
        viewpager = findViewById(R.id.myPager);
        viewpagerfasilitas = findViewById(R.id.myPagerFasilitas);
        tabLayout = findViewById(R.id.tabs);
        tabFasilitas = findViewById(R.id.tabsFasilitas);
        mBooking = findViewById(R.id.tombolBooking);
        gambarView = findViewById(R.id.rcGambar);
    }

    private void setupRecyclerView() {
        GambarAdapter gambarAdapter = new GambarAdapter(this, images);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        gambarView.setLayoutManager(linearLayoutManager);
        gambarView.setAdapter(gambarAdapter);
        gambarView.setHasFixedSize(true);
    }

}