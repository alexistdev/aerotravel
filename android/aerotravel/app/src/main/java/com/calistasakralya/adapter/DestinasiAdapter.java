package com.calistasakralya.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.calistasakralya.R;
import com.calistasakralya.config.Constants;
import com.calistasakralya.model.DestinasiModel;
import com.calistasakralya.ui.Detaildestinasi;
import java.util.List;

public class DestinasiAdapter extends RecyclerView.Adapter<DestinasiAdapter.MyViewHolder> {
    List<DestinasiModel> mDestinasiList;
    private final Context context;

    public DestinasiAdapter(List<DestinasiModel> mDestinasiList, Context context) {
        this.mDestinasiList = mDestinasiList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_destinasi, parent, false);
        DestinasiAdapter.MyViewHolder holder;
        holder = new MyViewHolder(mView);
        return holder;
    }
    @Override
    public void onBindViewHolder (@NonNull MyViewHolder holder,final int position){
        Glide.with(context)
                .load(Constants.IMAGES_URL+mDestinasiList.get(position).getGambar1())
                .apply(new RequestOptions().error(R.drawable.destinasi))
                .into(MyViewHolder.mGambarDestinasi);
        holder.mJudul.setText(mDestinasiList.get(position).getJudul_destinasi());
        holder.mDeskripsi.setText(mDestinasiList.get(position).getDeskripsi());
        holder.mLike.setText(mDestinasiList.get(position).getLike_destinasi());
        holder.itemView.setOnClickListener(v -> {
            Intent mIntent = new Intent(v.getContext(), Detaildestinasi.class);
            mIntent.putExtra("destinasi", mDestinasiList.get(position));
            v.getContext().startActivity(mIntent);
        });
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @SuppressLint("StaticFieldLeak")
        private static ImageView mGambarDestinasi;
        private final TextView mJudul, mDeskripsi,mLike;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mGambarDestinasi = itemView.findViewById(R.id.gbr_destinasi);
            mJudul  = itemView.findViewById(R.id.txt_judul);
            mDeskripsi  = itemView.findViewById(R.id.txt_destinasi);
            mLike  = itemView.findViewById(R.id.txt_like);
        }
    }

    @Override
    public int getItemCount () {
        return mDestinasiList.size();
    }

    public void replaceData(List<DestinasiModel> destinasiModels) {
        this.mDestinasiList = destinasiModels;
        notifyDataSetChanged();
    }
}
