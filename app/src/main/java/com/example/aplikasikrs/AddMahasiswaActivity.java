package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aplikasikrs.Model.Dosen;
import com.example.aplikasikrs.Model.Mahasiswa;

public class AddMahasiswaActivity extends AppCompatActivity {

    Mahasiswa mahasiswa;
    EditText txtnim, txtnama, txtalamat, txtemail;
    Button btnfoto, btnsubmit;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mahasiswa);
        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        setTitle("SI KRS - Hai " + name);


        txtnim = findViewById(R.id.TxtNIMAdd);
        txtnama = findViewById(R.id.TxtNamaMahasiswaAdd);
        txtalamat = findViewById(R.id.TxtAlamatMahasiswaAdd);
        txtemail = findViewById(R.id.TxtEmailMahasiswaAdd);
        btnfoto = findViewById(R.id.BtnAddFoto);
        btnsubmit = findViewById(R.id.btnsubmitmahasiswa);

        Intent inten = getIntent();
        Mahasiswa dsn = inten.getParcelableExtra("Mahasiswa");
        pos = inten.getIntExtra("position",-1);
        if(dsn != null){
            txtnim.setText(dsn.getNim());
            txtnama.setText(dsn.getNama());
            txtemail.setText(dsn.getEmail());
            txtalamat.setText(dsn.getAlamat());
        }



        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa = new Mahasiswa(txtnim.getText().toString(),txtnama.getText().toString(),txtemail.getText().toString(), txtalamat.getText().toString(), R.drawable.mudkip);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("Mahasiswa",mahasiswa);
                if(pos != -1){
                    returnIntent.putExtra("position", pos);
                }
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}
