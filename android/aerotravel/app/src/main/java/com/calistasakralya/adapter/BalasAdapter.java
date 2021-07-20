package com.calistasakralya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calistasakralya.R;
import com.calistasakralya.model.InboxModel;
import com.calistasakralya.model.InboxbalasModel;

import java.util.List;

public class BalasAdapter extends RecyclerView.Adapter<BalasAdapter.MyBalasHolder>{
    List<InboxbalasModel> mInboxList;

    public BalasAdapter(List<InboxbalasModel> mInboxList) {
        this.mInboxList = mInboxList;
    }

    @NonNull
    @Override
    public MyBalasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_detailpesan, parent, false);
        BalasAdapter.MyBalasHolder holder;
        holder = new MyBalasHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder (@NonNull MyBalasHolder holder,final int position){
        String waktu = holder.itemView.getContext().getString(R.string.adapter6, mInboxList.get(position).getTime());
        String isAdmin = mInboxList.get(position).getIs_admin();
        holder.mWaktu.setText(waktu);
        holder.mPesan.setText(mInboxList.get(position).getPesan());
        if(isAdmin.equals("2")){
            holder.mGambar.setImageResource(R.drawable.admin);
            //holder.mNamaRiwayat.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.reject, 0);
        } else {
            holder.mGambar.setImageResource(R.drawable.pesananda);
        }
    }

    public static class MyBalasHolder extends RecyclerView.ViewHolder {
        private final TextView mWaktu,mPesan;
        private final ImageView mGambar;
        MyBalasHolder(@NonNull View itemView) {
            super(itemView);
            mWaktu = itemView.findViewById(R.id.txtTanggal);
            mPesan = itemView.findViewById(R.id.txtPesan);
            mGambar = itemView.findViewById(R.id.gambarDetail);
        }
    }
    @Override
    public int getItemCount () {
        return mInboxList.size();
    }

    public void replaceData(List<InboxbalasModel> inboxModels) {
        this.mInboxList = inboxModels;
        notifyDataSetChanged();
    }
}
