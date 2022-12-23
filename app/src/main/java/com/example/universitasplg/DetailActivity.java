package com.example.universitasplg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivLogo;
    private TextView tvNama, tvAlamat, tvDeskripsi;
    private String yNama, yAlamat, yDeskripsi, yLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivLogo = findViewById(R.id.iv_logo);
        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);


        Intent ambil = getIntent();
        yLogo = ambil.getStringExtra("xLogo");
        yNama = ambil.getStringExtra("xNama");
        yAlamat = ambil.getStringExtra("xAlamat");
        yDeskripsi = ambil.getStringExtra("xDeskripsi");

        tvNama.setText(yNama);
        tvAlamat.setText(yAlamat);
        tvDeskripsi.setText(yDeskripsi);


        Glide
                .with(DetailActivity.this)
                .load(yLogo)
                .into(ivLogo);

    }
}
