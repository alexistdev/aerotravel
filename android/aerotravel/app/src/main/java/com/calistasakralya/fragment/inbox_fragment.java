package com.calistasakralya.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.calistasakralya.API.APIService;
import com.calistasakralya.API.NoConnectivityException;
import com.calistasakralya.R;
import com.calistasakralya.adapter.InboxAdapter;
import com.calistasakralya.config.Constants;
import com.calistasakralya.model.InboxModel;
import com.calistasakralya.response.GetInbox;
import com.calistasakralya.ui.Tambahpesan;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

import static android.view.View.GONE;


public class inbox_fragment extends Fragment {
    private RecyclerView gridView;
    private InboxAdapter inboxAdapter;
    private List<InboxModel> daftarInbox;
    private ProgressDialog progressDialog;
    private CardView mPesanKosong;
    private ImageView mPesan;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        datainit(view);

        setupRecyclerView();
        refresh(getContext());
        mPesan.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Tambahpesan.class);
            startActivity(intent);
        });
        return view;
    }

    public void datainit(View view){
        gridView =  view.findViewById(R.id.rcInbox);
        progressDialog = ProgressDialog.show(getActivity(), "", "Loading.....", true, false);
        mPesanKosong = view.findViewById(R.id.cdKosong);
        mPesanKosong.setVisibility(View.VISIBLE);
        mPesan = view.findViewById(R.id.add_icon);
    }
    public void refresh(Context mContext) {
        try {
            SharedPreferences sharedPreferences = requireContext().getSharedPreferences(
                    Constants.KEY_USER_SESSION, Context.MODE_PRIVATE);
            String idUser = sharedPreferences.getString("idUser", "");
            Call<GetInbox> callInbox = APIService.Factory.create(mContext).daftarInbox(idUser);
            callInbox.enqueue(new Callback<GetInbox>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GetInbox> call, Response<GetInbox> response) {
                    progressDialog.dismiss();
                    if(response.isSuccessful()){
                        if(response.body() != null){
                            daftarInbox = response.body().getListInbox();
                            inboxAdapter.replaceData(daftarInbox);
                            mPesanKosong.setVisibility(GONE);
                        }
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GetInbox> call, Throwable t) {
                    progressDialog.dismiss();
                    if(t instanceof NoConnectivityException) {
                        pesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        }catch (Exception e) {
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

        inboxAdapter = new InboxAdapter(new ArrayList<>());
        gridView.setLayoutManager(linearLayoutManager);
        gridView.setAdapter(inboxAdapter);
    }

    private void pesan(String msg)
    {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }

}