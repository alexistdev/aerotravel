package com.calistasakralya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.calistasakralya.fragment.akun_fragment;
import com.calistasakralya.fragment.home_fragment;
import com.calistasakralya.fragment.inbox_fragment;
import com.calistasakralya.fragment.order_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new home_fragment());
        /* Mengatur Menu bottom bar */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.home_menu:
                        fragment = new home_fragment();
                        break;
                    case R.id.order_menu:
                        fragment = new order_fragment();
                        break;
                    case R.id.inbox_menu:
                        fragment = new inbox_fragment();
                        break;
                    default:
                        fragment = new akun_fragment();
                }
                return loadFragment(fragment);
            }
        });
        //mengarahkan ke ke fragmen inbox
        Bundle extras = getIntent().getExtras();
        if(extras!=null && extras.containsKey("bukaInbox")) {
            boolean bukaKeranjang = extras.getBoolean("bukaInbox");
            if(bukaKeranjang){
                Fragment fragment = null;
                fragment = new inbox_fragment();
                loadFragment(fragment);
            }
        }
        if(extras!=null && extras.containsKey("bukaOrder")) {
            boolean bukaKeranjang = extras.getBoolean("bukaOrder");
            if(bukaKeranjang){
                Fragment fragment = null;
                fragment = new order_fragment();
                loadFragment(fragment);
            }
        }
    }



    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}