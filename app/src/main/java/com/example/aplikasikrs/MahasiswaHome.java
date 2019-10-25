package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MahasiswaHome extends AppCompatActivity {

    ImageView datadiri, kelolakrs, lihatkelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_home);

        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        setTitle("SI KRS - Hai " + name);


        datadiri = findViewById(R.id.BtnDataDiriMahasiswa);
        lihatkelas = findViewById(R.id.BtnLihatKelas);
        kelolakrs = findViewById(R.id.BtnDaftarKRSDosen);



        kelolakrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MahasiswaHome.this, KRSActivity.class);
                startActivity(inten);
            }
        });
        lihatkelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MahasiswaHome.this, KelasActivity.class);
                startActivity(inten);
            }
        });
        datadiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MahasiswaHome.this, DataDiriMahasiswaActivity.class);
                startActivity(inten);
            }
        });
    }
}
