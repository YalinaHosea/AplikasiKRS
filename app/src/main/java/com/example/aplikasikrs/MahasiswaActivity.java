package com.example.aplikasikrs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasikrs.Adapter.MahasiswaAdapter;
import com.example.aplikasikrs.Model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private MahasiswaAdapter MahasiswaAdapter;
    private ArrayList<Mahasiswa> MahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        setTitle("SI KRS - Hai " + name);


        Button btnadd = findViewById(R.id.BtnAddMahasiswa);
        addData();
        recycler = findViewById(R.id.Recycler_Mahasiswa);
        MahasiswaAdapter = new MahasiswaAdapter(MahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MahasiswaActivity.this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(MahasiswaAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MahasiswaActivity.this, AddMahasiswaActivity.class);
                startActivityForResult(inten,1);
            }
        });

    }



    private void addData() {
        MahasiswaArrayList = new ArrayList<>();
        MahasiswaArrayList.add(new Mahasiswa("72170112","Hosea","hos@gmail.com","Jl. Klitren",R.drawable.mudkip));
        MahasiswaArrayList.add(new Mahasiswa("72170003","Nando","nan@gmail.com","Jl. Klitren",R.drawable.treecko));
        MahasiswaArrayList.add(new Mahasiswa("72170190","Vin","vin@gmail.com","Jl. Nologaten",R.drawable.marowak));



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Mahasiswa Mahasiswa = data.getParcelableExtra("Mahasiswa");
            MahasiswaArrayList.add(Mahasiswa);
            MahasiswaAdapter.notifyDataSetChanged();
        }
        else if(requestCode == 2 && resultCode == RESULT_OK) {
            Mahasiswa Mahasiswa = data.getParcelableExtra("Mahasiswa");
            int pos = data.getIntExtra("position", -1);
            MahasiswaArrayList.set(pos,Mahasiswa);
            MahasiswaAdapter.notifyDataSetChanged();
        }
    }
}

