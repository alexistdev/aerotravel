package com.calistasakralya.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.calistasakralya.API.APIService;
import com.calistasakralya.API.NoConnectivityException;
import com.calistasakralya.R;
import com.calistasakralya.config.Constants;
import com.calistasakralya.model.ClientModel;
import com.calistasakralya.ui.login;
import com.calistasakralya.utils.SessionHandle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class akun_fragment extends Fragment {
    private ProgressDialog progressDialog;
    private EditText mEmail,mNama,mTelepon,mKtp,mAlamat,mPassword;
    private Button mTmbUbah,mLogout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_akun, container, false);
        if(getActivity() != null){
            getActivity().setTitle("Setting Akun");
        }
        dataInit(mview);
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(
                Constants.KEY_USER_SESSION, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");
        String idUser = sharedPreferences.getString("idUser", "");
        setData(token,idUser);
        mTmbUbah.setOnClickListener(v -> {
            progressDialog = ProgressDialog.show(getActivity(), "", "Loading.....", true, false);
            updateData(token,idUser);
        });
        mLogout.setOnClickListener(v -> {
            SessionHandle.logout(requireContext());
            Intent intent = new Intent(getActivity(), login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            if(getActivity()!= null){
                getActivity().finish();
            }
        });
        return mview;
    }

    private void dataInit(View mview){
        progressDialog = ProgressDialog.show(getActivity(), "", "Loading.....", true, false);
        mEmail = mview.findViewById(R.id.txt_email);
        mNama = mview.findViewById(R.id.txt_nama);
        mTelepon = mview.findViewById(R.id.txt_telepon);
        mLogout = mview.findViewById(R.id.tblLogout);
        mKtp = mview.findViewById(R.id.txt_nomorktp);
        mAlamat = mview.findViewById(R.id.txt_alamat);
        mPassword = mview.findViewById(R.id.txt_password);
        mTmbUbah = mview.findViewById(R.id.tblUbah);
        mEmail.setEnabled(false);
    }

    private void setData(String token,String idUser){

        try{
            Call<ClientModel> call = APIService.Factory.create(getContext()).dataAkun(idUser,token);
            call.enqueue(new Callback<ClientModel>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<ClientModel> call, Response<ClientModel> response) {
                    progressDialog.dismiss();
                    if(response.body() != null) {
                        mEmail.setText(response.body().getEmail());
                        mNama.setText(response.body().getNama_lengkap());
                        mTelepon.setText(response.body().getNo_telp());
                        mKtp.setText(response.body().getNo_ktp());
                        mAlamat.setText(response.body().getAlamat());
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<ClientModel> call, Throwable t) {
                    if(t instanceof NoConnectivityException) {
                        progressDialog.dismiss();
                        pesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        }catch(Exception e){
            progressDialog.dismiss();
            e.printStackTrace();
            pesan(e.getMessage());
        }
    }

    private void updateData(String token,String idUser){
        String email = mEmail.getText().toString();
        String namaLengkap = mNama.getText().toString();
        String noKTP = mKtp.getText().toString();
        String alamat = mAlamat.getText().toString();
        String noTelp = mTelepon.getText().toString();
        String password = mPassword.getText().toString();
      if(email.length() == 0 || namaLengkap.length() == 0 || noKTP.length() == 0 || alamat.length() == 0 || noTelp.length() == 0 ){
          pesan("Silahkan lengkapi form terlebih dahulu!");
      } else {
          try{
              Call<ClientModel> callUpdate = APIService.Factory.create(getContext()).updateAkun(idUser,namaLengkap,noTelp,noKTP,alamat,password,token);
              callUpdate.enqueue(new Callback<ClientModel>() {
                  @EverythingIsNonNull
                  @Override
                  public void onResponse(Call<ClientModel> call, Response<ClientModel> response) {
                      progressDialog.dismiss();
                      if(response.body() != null) {
                          setData(token,idUser);
                          pesan("Data Akun berhasil diperbaharui!");
                      }
                  }

                  @EverythingIsNonNull
                  @Override
                  public void onFailure(Call<ClientModel> call, Throwable t) {
                      if(t instanceof NoConnectivityException) {
                          progressDialog.dismiss();
                          pesan("Offline, cek koneksi internet anda!");
                      }
                  }
              });
          }catch (Exception e){
              progressDialog.dismiss();
              e.printStackTrace();
              pesan(e.getMessage());
          }
      }
    }

    private void pesan(String msg)
    {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }
}