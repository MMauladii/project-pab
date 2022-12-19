package com.example.universitasplg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivFoto, ivLogo;
    private TextView tvNama, tvAlamat, tvTentang;
    private String yNama, yAlamat, yTentang, yFoto, yLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivFoto = findViewById(R.id.iv_foto);
        ivLogo = findViewById(R.id.iv_logo);
        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTentang = findViewById(R.id.tv_deskripsi);


        Intent ambil = getIntent();
        yFoto = ambil.getStringExtra("xFoto");
        yLogo = ambil.getStringExtra("xLogo");
        yNama = ambil.getStringExtra("xNama");
        yAlamat = ambil.getStringExtra("xAlamat");
        yTentang = ambil.getStringExtra("xTentang");

        tvNama.setText(yNama);
        tvAlamat.setText(yAlamat);
        tvTentang.setText(yTentang);

        Glide
                .with(DetailActivity.this)
                .load(yFoto)
                .into(ivFoto);

        Glide
                .with(DetailActivity.this)
                .load(yLogo)
                .into(ivLogo);

    }
}
