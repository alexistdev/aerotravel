package com.calistasakralya.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calistasakralya.R;
import com.calistasakralya.model.BookingModel;
import com.calistasakralya.ui.Detailorder;
import com.calistasakralya.ui.Detailpesan;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyBookingHolder>{
    //private final Context context;
    List<BookingModel> mBookingList;


    public BookingAdapter(List<BookingModel> mBookingList) {
        //this.context = c;
        this.mBookingList = mBookingList;
    }

    @NonNull
    @Override
    public MyBookingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_booking, parent, false);
        BookingAdapter.MyBookingHolder holder;
        holder = new MyBookingHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder (@NonNull MyBookingHolder holder,final int position){
        String kodeBooking = holder.itemView.getContext().getString(R.string.adapter5, mBookingList.get(position).getKode_booking());
        String totalHarga = holder.itemView.getContext().getString(R.string.adapter4, mBookingList.get(position).getTotal_harga());
        String tanggal = holder.itemView.getContext().getString(R.string.adapter3, mBookingList.get(position).getTanggal_wisata());
        holder.mBookingNomor.setText(kodeBooking);
        holder.mPaket.setText(mBookingList.get(position).getJudul_paket());
        holder.mTotalHarga.setText(totalHarga);
        holder.mTanggalBooking.setText(tanggal);

        String status = mBookingList.get(position).getStatus();
        if(status.equals("1")){
            holder.mStatus.setText(R.string.adapter2);
        } else {
            holder.mStatus.setText(R.string.adapter1);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(v.getContext(), Detailorder.class);
                v.getContext().startActivity(mIntent);
            }
        });
    }

    public static class MyBookingHolder extends RecyclerView.ViewHolder {
        private final TextView mBookingNomor,mPaket,mTotalHarga,mTanggalBooking,mStatus;
        MyBookingHolder(@NonNull View itemView) {
            super(itemView);
            mBookingNomor = itemView.findViewById(R.id.txtBooking);
            mPaket = itemView.findViewById(R.id.txtPaket);
            mTotalHarga = itemView.findViewById(R.id.txtTotalHarga);
            mTanggalBooking = itemView.findViewById(R.id.txtTanggal);
            mStatus = itemView.findViewById(R.id.txtStatus);
        }
    }

    @Override
    public int getItemCount () {
        return mBookingList.size();
    }

    public void replaceData(List<BookingModel> bookingModels) {
        this.mBookingList = bookingModels;
        notifyDataSetChanged();
    }
}
