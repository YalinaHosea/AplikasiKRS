package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aplikasikrs.Model.Dosen;

public class AddDosenActivity extends AppCompatActivity {

    Dosen dosen;
    EditText txtnidn, txtnama, txtgelar, txtalamat, txtemail;
    Button btnfoto, btnsubmit;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dosen);
        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        setTitle("SI KRS - Hai " + name);


        txtnidn = findViewById(R.id.TxtNIDN);
        txtnama = findViewById(R.id.TxtNama);
        txtgelar = findViewById(R.id.TxtGelar);
        txtalamat = findViewById(R.id.TxtAlamat);
        txtemail = findViewById(R.id.TxtEmail);
        btnfoto = findViewById(R.id.BtnAddFoto);
        btnsubmit = findViewById(R.id.btnsubmit);

        Intent inten = getIntent();
        Dosen dsn = inten.getParcelableExtra("dosen");
        pos = inten.getIntExtra("position",-1);
        if(dsn != null){
            txtnidn.setText(dsn.getNidn());
            txtnama.setText(dsn.getNama());
            txtemail.setText(dsn.getEmail());
            txtalamat.setText(dsn.getAlamat());
            txtgelar.setText(dsn.getGelar());

        }



        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dosen = new Dosen(txtnidn.getText().toString(),txtnama.getText().toString(),txtgelar.getText().toString(),txtemail.getText().toString(), txtalamat.getText().toString(), R.drawable.mudkip);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("dosen",dosen);
                if(pos != -1){
                    returnIntent.putExtra("position", pos);
                }
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}
