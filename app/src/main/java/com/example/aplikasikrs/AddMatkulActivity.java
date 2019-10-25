package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aplikasikrs.Model.Matkul;
import com.example.aplikasikrs.Model.Matkul;

public class AddMatkulActivity extends AppCompatActivity {

    Matkul matkul;
    EditText txtkode, txtnama, txtsks;
    Button btnsubmit;
    Spinner spinhari, spinsesi;
    String hari, sesi;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_matkul);

        txtkode = findViewById(R.id.TxtKodeMatkul);
        txtnama = findViewById(R.id.TxtNamaMatkulAdd);
        txtsks = findViewById(R.id.TxtSKSadd);
        spinhari = findViewById(R.id.SpinHari);
        spinsesi = findViewById(R.id.SpinSesi);
        btnsubmit = findViewById(R.id.btnsubmit);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, hariarray);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, sesiarray);
        spinsesi.setAdapter(adapter2);
        spinhari.setAdapter(adapter);

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

        Intent inten = getIntent();
        Matkul dsn = inten.getParcelableExtra("Matkul");
        pos = inten.getIntExtra("position",-1);
        if(dsn != null){
            txtkode.setText(dsn.getKode_matkul());
            txtnama.setText(dsn.getNama());
            txtsks.setText(dsn.getSks());

        }



        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matkul = new Matkul(txtkode.getText().toString(),txtnama.getText().toString(),hari,txtsks.getText().toString(),sesi);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("Matkul",matkul);
                if(pos != -1){
                    returnIntent.putExtra("position", pos);
                }
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
