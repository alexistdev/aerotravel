package com.calistasakralya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.calistasakralya.R;
import com.calistasakralya.model.HargaModel;
import java.util.List;

public class HargaAdapter extends RecyclerView.Adapter<HargaAdapter.HargaViewModel> {
    List<HargaModel> mHargalist;

    public HargaAdapter(List<HargaModel> mHargalist) {
        this.mHargalist = mHargalist;
    }
    @NonNull
    @Override
    public HargaViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_harga, parent, false);
        HargaAdapter.HargaViewModel holder;
        holder = new HargaViewModel(mView);
        return holder;
    }


    @Override
    public void onBindViewHolder (@NonNull HargaViewModel holder,final int position){
        holder.mHarga.setText(mHargalist.get(position).getHarga_standar());
        holder.mPeserta.setText(mHargalist.get(position).getKeterangan());
    }

    public static class HargaViewModel extends RecyclerView.ViewHolder {
        private final TextView mHarga,mPeserta;

        HargaViewModel(@NonNull View itemView) {
            super(itemView);
            mHarga  = itemView.findViewById(R.id.txtHarga);
            mPeserta  = itemView.findViewById(R.id.txtJumlahOrang);
        }
    }
    @Override
    public int getItemCount () {
        return mHargalist.size();
    }

    public void replaceData(List<HargaModel> hargaModelList) {
        this.mHargalist = hargaModelList;
        notifyDataSetChanged();
    }
}
