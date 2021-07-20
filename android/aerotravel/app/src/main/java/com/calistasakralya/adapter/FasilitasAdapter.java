package com.calistasakralya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.calistasakralya.R;
import com.calistasakralya.model.FasilitasModel;
import java.util.List;

public class FasilitasAdapter extends RecyclerView.Adapter<FasilitasAdapter.FasilitasViewHolder> {
    List<FasilitasModel> mFasilitasList;

    public FasilitasAdapter(List<FasilitasModel> mFasilitasList) {
        this.mFasilitasList = mFasilitasList;
    }

    @NonNull
    @Override
    public FasilitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_feature, parent, false);
        FasilitasAdapter.FasilitasViewHolder holder;
        holder = new FasilitasViewHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder (@NonNull FasilitasViewHolder holder,final int position){
        holder.mFasilitas.setText(mFasilitasList.get(position).getNama_fasilitas());
    }

    public static class FasilitasViewHolder extends RecyclerView.ViewHolder {
        private final TextView mFasilitas;

        FasilitasViewHolder(@NonNull View itemView) {
            super(itemView);
            mFasilitas  = itemView.findViewById(R.id.txtNamaFasilitas);
        }
    }

    @Override
    public int getItemCount () {
        return mFasilitasList.size();
    }

    public void replaceData(List<FasilitasModel> fasilitasModels) {
        this.mFasilitasList = fasilitasModels;
        notifyDataSetChanged();
    }
}
