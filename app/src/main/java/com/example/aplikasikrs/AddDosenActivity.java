package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dosen);

        txtnidn = findViewById(R.id.TxtNIDN);
        txtnama = findViewById(R.id.TxtNama);
        txtgelar = findViewById(R.id.TxtGelar);
        txtalamat = findViewById(R.id.TxtAlamat);
        txtemail = findViewById(R.id.TxtEmail);
        btnfoto = findViewById(R.id.BtnAddFoto);
        btnsubmit = findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dosen = new Dosen(txtnidn.getText().toString(),txtnama.getText().toString(),txtgelar.getText().toString(),txtemail.getText().toString(), txtalamat.getText().toString(), R.drawable.mudkip);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("dosen",dosen);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });


    }
//    @Override
//    public void finish() {
//        Intent returnIntent = new Intent();
//        returnIntent.putExtra("passed_item",(Parcelable)dosen);
//        setResult(0, returnIntent); //By not passing the intent in the result, the calling activity will get null data.
//        super.finish();
//    }
}
