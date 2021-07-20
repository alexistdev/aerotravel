package com.calistasakralya.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.calistasakralya.R;
import com.calistasakralya.model.InboxModel;
import com.calistasakralya.ui.Detailpesan;

import java.util.List;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.MyInboxHolder>{
    List<InboxModel> mInboxList;

    public InboxAdapter(List<InboxModel> mInboxList) {
        this.mInboxList = mInboxList;
    }

    @NonNull
    @Override
    public MyInboxHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_inbox, parent, false);
        InboxAdapter.MyInboxHolder holder;
        holder = new MyInboxHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder (@NonNull MyInboxHolder holder,final int position){
        String waktu = holder.itemView.getContext().getString(R.string.adapter6, mInboxList.get(position).getTime());
        holder.mWaktu.setText(waktu);
        holder.mJudul.setText(mInboxList.get(position).getJudul());
        String status = mInboxList.get(position).getStatus();
        if(status.equals("1")){
            holder.mStatus.setText(R.string.adapter7);
        } else if(status.equals("2")){
            holder.mStatus.setText(R.string.adapter8);
        } else {
            holder.mStatus.setText(R.string.adapter9);
        }
        holder.itemView.setOnClickListener(v -> {
            Intent mIntent = new Intent(v.getContext(), Detailpesan.class);
            mIntent.putExtra("key_token",mInboxList.get(position).getKey_token());
            v.getContext().startActivity(mIntent);
        });
    }

    public static class MyInboxHolder extends RecyclerView.ViewHolder {
        private final TextView mWaktu,mJudul,mStatus;
        MyInboxHolder(@NonNull View itemView) {
            super(itemView);
            mWaktu = itemView.findViewById(R.id.txtTanggal);
            mJudul = itemView.findViewById(R.id.txtJudul);
            mStatus = itemView.findViewById(R.id.txtStatus);
        }
    }
    @Override
    public int getItemCount () {
        return mInboxList.size();
    }

    public void replaceData(List<InboxModel> inboxModels) {
        this.mInboxList = inboxModels;
        notifyDataSetChanged();
    }


}
