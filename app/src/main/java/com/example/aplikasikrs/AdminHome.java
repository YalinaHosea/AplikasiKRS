package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminHome extends AppCompatActivity {

    ImageView datadiri, daftardosen, daftarmakul, daftarmahasiswa, kelolakrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        datadiri = findViewById(R.id.BtnDataDiri);
        daftardosen = findViewById(R.id.BtnDaftarDosen);
        daftarmakul = findViewById(R.id.BtnDaftarMatkul);
        daftarmahasiswa = findViewById(R.id.BtnDaftarMahasiswa);
        kelolakrs = findViewById(R.id.BtnKelolaKRS);


        daftardosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(AdminHome.this, DosenActivity.class);
                startActivity(inten);
            }
        });




    }
}
