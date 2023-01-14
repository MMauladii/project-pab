package com.example.universitasplg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivLogo;
    private TextView tvNama, tvAlamat, tvDeskripsi;
    private String yNama, yAlamat, yDeskripsi, yLogo, yMaps;
    private Button btnLokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivLogo = findViewById(R.id.iv_logo);

        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);

        btnLokasi = findViewById(R.id.btn_lokasi);

        Intent ambil = getIntent();
        yLogo = ambil.getStringExtra("xLogo");
        yNama = ambil.getStringExtra("xNama");
        yAlamat = ambil.getStringExtra("xAlamat");
        yDeskripsi = ambil.getStringExtra("xDeskripsi");
        yMaps = ambil.getStringExtra("xMaps");

        tvNama.setText(yNama);
        tvAlamat.setText(yAlamat);
        tvDeskripsi.setText(yDeskripsi);

        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse(yMaps);

                Intent bukaMaps = new Intent(Intent.ACTION_VIEW, webpage);

                try {
                    startActivity(bukaMaps);
                    // Debug
                    // Toast.makeText(DetailActivity.this, "Link : " + yMaps, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(DetailActivity.this, "There's something wrong with this action. Please try again later", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Glide
                .with(DetailActivity.this)
                .load(yLogo)
                .into(ivLogo);

    }
}
