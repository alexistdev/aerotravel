package com.calistasakralya.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.calistasakralya.API.APIService;
import com.calistasakralya.API.NoConnectivityException;
import com.calistasakralya.R;
import com.calistasakralya.adapter.JadwalAdapter;
import com.calistasakralya.model.JadwalModel;
import com.calistasakralya.response.GetJadwal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class PageFragment extends Fragment {
    private RecyclerView gridView;
    private List<JadwalModel> jadwalModels;
    private JadwalAdapter jadwalAdapter;


    public static PageFragment newInstance(String id, int type) {
        PageFragment myFragment = new PageFragment();

        Bundle args = new Bundle();
        args.putString("idDestinasi", id);
        args.putInt("type", type);
        myFragment.setArguments(args);

        return myFragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        gridView = view.findViewById(R.id.rcJadwal);
        setupRecyclerView();
        dapatinJadwal(getContext(),getArguments().getString("idDestinasi"), getArguments().getInt("type"));
        return view;
    }

    public void dapatinJadwal(Context mContext, String idDes, int type) {
        Call<GetJadwal> callJadwal = APIService.Factory.create(mContext).jadwalWisata(idDes,type);
        callJadwal.enqueue(new Callback<GetJadwal>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<GetJadwal> call, Response<GetJadwal> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        jadwalModels = response.body().getListJadwal();
                        jadwalAdapter.replaceData(jadwalModels);
                    }
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<GetJadwal> call, Throwable t) {
                if(t instanceof NoConnectivityException) {
                    pesan();
                }
            }
        });

    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };

        jadwalAdapter = new JadwalAdapter(new ArrayList<>());
        gridView.setLayoutManager(linearLayoutManager);
        gridView.setAdapter(jadwalAdapter);
    }

    private void pesan()
    {
        Toast.makeText(getContext(), "Offline, cek koneksi internet anda!", Toast.LENGTH_LONG).show();
    }

}