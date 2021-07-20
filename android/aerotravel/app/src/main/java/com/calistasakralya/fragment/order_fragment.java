package com.calistasakralya.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.calistasakralya.adapter.BookingAdapter;
import com.calistasakralya.config.Constants;
import com.calistasakralya.model.BookingModel;
import com.calistasakralya.response.GetBooking;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;


public class order_fragment extends Fragment {
    private RecyclerView gridView;
    private BookingAdapter bookingAdapter;
    private List<BookingModel> daftarBooking;
    private ProgressDialog progressDialog;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        gridView = view.findViewById(R.id.rcBooking);
        progressDialog = ProgressDialog.show(getActivity(), "", "Loading.....", true, false);
        setupRecyclerView();
        refresh(getContext());
        return view;
    }
    public void refresh(Context mContext) {
        try {
            SharedPreferences sharedPreferences = requireContext().getSharedPreferences(
                    Constants.KEY_USER_SESSION, Context.MODE_PRIVATE);
            String idUser = sharedPreferences.getString("idUser", "");
            Call<GetBooking> callBooking = APIService.Factory.create(mContext).daftarBooking(idUser);
            callBooking.enqueue(new Callback<GetBooking>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GetBooking> call, Response<GetBooking> response) {
                    progressDialog.dismiss();
                    if(response.isSuccessful()){
                        if(response.body() != null){
                            daftarBooking = response.body().getListBooking();
                            bookingAdapter.replaceData(daftarBooking);
                        }
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GetBooking> call, Throwable t) {
                    progressDialog.dismiss();
                    if(t instanceof NoConnectivityException) {
                        pesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        } catch (Exception e) {
            progressDialog.dismiss();
            e.printStackTrace();
            pesan(e.getMessage());
        }
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };

        bookingAdapter = new BookingAdapter(new ArrayList<>());
        gridView.setLayoutManager(linearLayoutManager);
        gridView.setAdapter(bookingAdapter);
    }

    private void pesan(String msg)
    {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }
}