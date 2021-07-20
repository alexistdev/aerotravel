package com.calistasakralya.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.calistasakralya.API.APIService;
import com.calistasakralya.API.NoConnectivityException;
import com.calistasakralya.R;
import com.calistasakralya.adapter.DestinasiAdapter;
import com.calistasakralya.model.APIError;
import com.calistasakralya.model.DestinasiModel;
import com.calistasakralya.response.GetDestinasi;
import com.calistasakralya.utils.ErrorUtils;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class home_fragment extends Fragment {
    private RecyclerView gridDestinasi;
    private DestinasiAdapter destinasiAdapter;
    private List<DestinasiModel> destinasiModels;
    private ProgressDialog progressDialog;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = getContext();
        if(getActivity() != null){
            getActivity().setTitle("AeroTravel");
        }
        dataInit(mview);
        setupRecyclerView();
        refresh(mContext);
        return mview;
    }
    @Override
    public void onResume() {
        super.onResume();
        setupRecyclerView();
        refresh(mContext);
        destinasiAdapter.notifyDataSetChanged();
    }

    public void refresh(Context mContext) {
        try {
            Call<GetDestinasi> call = APIService.Factory.create(mContext).listDestinasi();
            call.enqueue(new Callback<GetDestinasi>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GetDestinasi> call, Response<GetDestinasi> response) {
                    if(response.isSuccessful()){
                        progressDialog.dismiss();
                        if(response.body() != null){
                            destinasiModels = response.body().getListDestinasi();
                            destinasiAdapter.replaceData(destinasiModels);
                        }
                    }else{
                        progressDialog.dismiss();
                        APIError error = ErrorUtils.parseError(response);
                        pesan(error.message());
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GetDestinasi> call, Throwable t) {
                    progressDialog.dismiss();
                    if(t instanceof NoConnectivityException) {
                        pesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        } catch (Exception e){
            progressDialog.dismiss();
            e.printStackTrace();
            pesan(e.getMessage());
        }
    }


    private void dataInit(View mview){
        progressDialog = ProgressDialog.show(getActivity(), "", "Loading.....", true, false);
        gridDestinasi = mview.findViewById(R.id.rcdestinase);

       //mSwipeRefreshLayout = mview.findViewById(R.id.refresh);
    }


    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        destinasiAdapter = new DestinasiAdapter(new ArrayList<>(),getContext());
        gridDestinasi.setLayoutManager(linearLayoutManager);
        gridDestinasi.setAdapter(destinasiAdapter);
    }

    private void pesan(String msg)
    {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }
}