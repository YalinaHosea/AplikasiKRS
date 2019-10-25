package com.example.aplikasikrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String useradmin = "admin";
    String passadmin = "admin";
    String userdosen = "dosen";
    String passdosen = "dosen";
    String usermahasiswa = "yalina";
    String passmahasiswa = "yalina";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText txtuser = findViewById(R.id.TxtEmail);
        final EditText txtpass = findViewById(R.id.TxtPassword);
        Button btnlogin = findViewById(R.id.BtnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtuser.getText().toString().equals(useradmin)) {
                    if(txtpass.getText().toString().equals(passadmin)) {

                        SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();
                        editor.putString("name", txtuser.getText().toString());
                        editor.apply();

                        Intent inten = new Intent(MainActivity.this, AdminHome.class);
                        startActivity(inten);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Username atau password salah",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(txtuser.getText().toString().equals(userdosen)){
                    if(txtpass.getText().toString().equals(passdosen)) {

                        SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();
                        editor.putString("name", txtuser.getText().toString());
                        editor.apply();
                        Intent inten = new Intent(MainActivity.this, DosenHome.class);
                        startActivity(inten);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Username atau password salah",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(txtuser.getText().toString().equals(usermahasiswa)){
                    if(txtpass.getText().toString().equals(passmahasiswa)) {

                        SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();
                        editor.putString("name", txtuser.getText().toString());
                        editor.apply();
                        Intent inten = new Intent(MainActivity.this, MahasiswaHome.class);
                        startActivity(inten);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Username atau password salah",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Username atau password salah",Toast.LENGTH_SHORT).show();

                }
            }
        });
        
    }
}
