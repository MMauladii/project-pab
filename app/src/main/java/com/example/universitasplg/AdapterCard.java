package com.example.universitasplg;

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

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ClassViewHolder> {
    private ArrayList<ModelUniversitas> dataUniversitas;
    private Context ctx;

    public AdapterCard(ArrayList<ModelUniversitas> dataUniversitas, Context ctx) {
        this.dataUniversitas = dataUniversitas;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_card, parent, false);
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelUniversitas universitas = dataUniversitas.get(position);
        holder.tvNama.setText(universitas.getNama_univ());
        holder.tvDeskripsi.setText(universitas.getDeskripsi_univ());
        Glide
                .with(ctx)
                .load(universitas.getFoto_univ())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xNama, xDeskripsi, xFoto;

                xNama = universitas.getNama_univ();
                xDeskripsi = universitas.getDeskripsi_univ();
                xFoto = universitas.getFoto_univ();

//                Log.d("CEKNRICEK", xNama+ " | " + xTentang + " | " + xFoto);

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xDeskripsi", xDeskripsi);
                kirim.putExtra("xFoto", xFoto);
                ctx.startActivity(kirim);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataUniversitas.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama, tvDeskripsi;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
        }
    }
}
