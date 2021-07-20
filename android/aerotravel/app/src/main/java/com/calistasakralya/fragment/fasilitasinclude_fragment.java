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
import com.calistasakralya.adapter.FasilitasAdapter;
import com.calistasakralya.model.FasilitasModel;
import com.calistasakralya.response.GetFasilitas;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class fasilitasinclude_fragment extends Fragment {
    private RecyclerView gridView;
    private List<FasilitasModel> fasilitasModels;
    private FasilitasAdapter fasilitasAdapter;

    public static fasilitasinclude_fragment newInstance(String id, int type) {
        fasilitasinclude_fragment myFragment = new fasilitasinclude_fragment();

        Bundle args = new Bundle();
        args.putString("idDestinasi", id);
        args.putInt("type", type);
        myFragment.setArguments(args);

        return myFragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fasilitasinclude, container, false);
        gridView = view.findViewById(R.id.rcFasilitas);
        setupRecyclerView();
        dapatinFasilitas(getContext(),getArguments().getString("idDestinasi"), getArguments().getInt("type"));
        return view;
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };

        fasilitasAdapter = new FasilitasAdapter(new ArrayList<>());
        gridView.setLayoutManager(linearLayoutManager);
        gridView.setAdapter(fasilitasAdapter);
    }

    public void dapatinFasilitas(Context mContext, String idDes, int type) {
        Call<GetFasilitas> callFasilitas = APIService.Factory.create(mContext).fasilitasInclude(idDes,type);
        callFasilitas.enqueue(new Callback<GetFasilitas>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<GetFasilitas> call, Response<GetFasilitas> response) {
                if(response.isSuccessful()) {
                    if (response.body() != null) {
                        fasilitasModels = response.body().getFasilitasModelList();
                        fasilitasAdapter.replaceData(fasilitasModels);
                    }
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<GetFasilitas> call, Throwable t) {
                if(t instanceof NoConnectivityException) {
                    pesan();
                }
            }
        });

    }

    private void pesan()
    {
        Toast.makeText(getContext(), "Offline, cek koneksi internet anda!", Toast.LENGTH_LONG).show();
    }

}