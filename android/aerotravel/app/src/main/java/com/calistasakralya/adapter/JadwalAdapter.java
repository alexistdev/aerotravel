package com.calistasakralya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calistasakralya.R;
import com.calistasakralya.model.JadwalModel;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {
    List<JadwalModel> mJadwalList;

    public JadwalAdapter(List<JadwalModel> mJadwalList) {
        this.mJadwalList = mJadwalList;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_jadwal, parent, false);
        JadwalAdapter.JadwalViewHolder holder;
        holder = new JadwalViewHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder (@NonNull JadwalViewHolder holder,final int position){
        holder.mJam.setText(mJadwalList.get(position).getWaktu());
        holder.mKeterangan.setText(mJadwalList.get(position).getKeterangan());
    }

    public static class JadwalViewHolder extends RecyclerView.ViewHolder {
        private final TextView mJam, mKeterangan;

        JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            mJam  = itemView.findViewById(R.id.txtWaktu);
            mKeterangan  = itemView.findViewById(R.id.txtKeterangan);
        }
    }

    @Override
    public int getItemCount () {
        return mJadwalList.size();
    }

    public void replaceData(List<JadwalModel> jadwalModels) {
        this.mJadwalList = jadwalModels;
        notifyDataSetChanged();
    }



}
