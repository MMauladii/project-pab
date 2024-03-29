package com.example.universitasplg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.ClassViewHolder> {
    private ArrayList<ModelUniversitas> dataUniversitas;
    private Context ctx;

    public AdapterGrid(ArrayList<ModelUniversitas> dataPahlawan, Context ctx) {
        this.dataUniversitas = dataPahlawan;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_grid, parent, false);
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelUniversitas universitas = dataUniversitas.get(position);
        Glide
                .with(ctx)
                .load(universitas.getFoto_univ())
                .centerCrop()
                .into(holder.ivGrid);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xNama, xDeskripsi, xFoto, xLogo, xAlamat, xMaps;

                xNama = universitas.getNama_univ();
                xDeskripsi = universitas.getDeskripsi_univ();
                xFoto = universitas.getFoto_univ();
                xLogo = universitas.getLogo_univ();
                xAlamat = universitas.getAlamat_univ();
                xMaps = universitas.getMaps_univ();

//                Log.d("CEKNRICEK", xNama+ " | " + xTentang + " | " + xFoto);

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xDeskripsi", xDeskripsi);
                kirim.putExtra("xFoto", xFoto);
                kirim.putExtra("xLogo", xLogo);
                kirim.putExtra("xAlamat", xAlamat);
                kirim.putExtra("xMaps", xMaps);

                ctx.startActivity(kirim);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataUniversitas.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGrid;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);
        }
    }
}
