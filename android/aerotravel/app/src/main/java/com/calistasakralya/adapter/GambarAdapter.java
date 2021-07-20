package com.calistasakralya.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.calistasakralya.R;
import com.calistasakralya.config.Constants;
import com.calistasakralya.model.GambarWisata;

import java.util.ArrayList;

public class GambarAdapter extends RecyclerView.Adapter<GambarAdapter.ImageViewHolder> {
        Context c;
        ArrayList<GambarWisata> images;

        public GambarAdapter(Context c, ArrayList<GambarWisata> images) {
            this.c = c.getApplicationContext();
            this.images = images;
        }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(c).inflate(R.layout.single_row_gambar, parent, false);
        GambarAdapter.ImageViewHolder holder;
        holder = new ImageViewHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder (@NonNull ImageViewHolder holder, final int position){
        Glide.with(c)
                .load(Constants.IMAGES_URL+images.get(position).getGambar())
                .apply(new RequestOptions().error(R.drawable.wisata))
                .into(holder.mGambar);
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView mGambar;
        public ImageViewHolder(View itemView) {
            super(itemView);
            mGambar = itemView.findViewById(R.id.gambarku);
        }
    }


    @Override
    public int getItemCount() {
        return images.size();
    }
    public void replaceData(ArrayList<GambarWisata> gambarModel) {
        this.images = gambarModel;
        notifyDataSetChanged();
    }
}
