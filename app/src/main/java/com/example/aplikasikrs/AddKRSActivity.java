package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aplikasikrs.Model.KRS;
import com.example.aplikasikrs.Model.KRS;

public class AddKRSActivity extends AppCompatActivity {

    KRS KRS;
    EditText txtkode, txtnama, txtsks, txtjumlah;
    Button btnsubmit;
    Spinner spinhari, spinsesi, spindosen;
    String hari, sesi, dosen;
    int pos;
    private String[] hariarray = {
            "Senin",
            "Selasa", "Rabu",
            "Kamis",
            "Jumat",
            "Sabtu",
            "Minggu"
    };
    private String[] sesiarray = {
            "1",
            "2", "3",
            "4"
    };
    private String[] dosenarray = {
            "Katon Wijana",
            "Eric Kurniawan", "Argo Wibomo",
            "Umi Proboyekti",
            "Yetli Oslan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_krs);
        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        setTitle("SI KRS - Hai " + name);


        txtkode = findViewById(R.id.TxtKodeKRS);
        txtnama = findViewById(R.id.TxtNamaKRSAdd);
        txtsks = findViewById(R.id.TxtSKSadd);
        txtjumlah = findViewById(R.id.TxtPesertaKRSAdd);
        spinhari = findViewById(R.id.SpinHariKRS);
        spinsesi = findViewById(R.id.SpinSesiKRS);
        spindosen = findViewById(R.id.SpinDosenKRS);
        btnsubmit = findViewById(R.id.btnsubmitKRS);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, hariarray);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, sesiarray);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, dosenarray);
        spinsesi.setAdapter(adapter2);
        spinhari.setAdapter(adapter);
        spindosen.setAdapter(adapter3);

        spinhari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hari = adapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinsesi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sesi = adapter2.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spindosen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dosen = adapter3.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Intent inten = getIntent();
        KRS dsn = inten.getParcelableExtra("KRS");
        pos = inten.getIntExtra("position",-1);
        if(dsn != null){
            txtkode.setText(dsn.getKode_krs());
            txtnama.setText(dsn.getNama());
            txtsks.setText(dsn.getSks());
            txtjumlah.setText(dsn.getJumlah());

        }



        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KRS = new KRS(txtkode.getText().toString(),txtnama.getText().toString(),hari,txtsks.getText().toString(),sesi,dosen,txtjumlah.getText().toString());
                Intent returnIntent = new Intent();
                returnIntent.putExtra("KRS",KRS);
                if(pos != -1){
                    returnIntent.putExtra("position", pos);
                }
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
