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

import com.example.aplikasikrs.Adapter.KelasAdapter;
import com.example.aplikasikrs.Model.Kelas;

import java.util.ArrayList;

public class KelasActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private KelasAdapter KelasAdapter;
    private ArrayList<Kelas> KelasArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas);
        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        setTitle("SI KRS - Hai " + name);


        addData();
        recycler = findViewById(R.id.Recycler_Kelas);
        KelasAdapter = new KelasAdapter(KelasArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(KelasActivity.this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(KelasAdapter);



    }



    private void addData() {
        KelasArrayList = new ArrayList<>();
        KelasArrayList.add(new Kelas("ALP-033","Alpro", "Senin","1", "Katon Wijana", "1"));
        KelasArrayList.add(new Kelas("PRO-043","Progmob", "Senin","2","Eric Kurniawan", "50"));
        KelasArrayList.add(new Kelas("STR-062","Strukdat", "Senin","3","Argo Wibowo", "35"));
        KelasArrayList.add(new Kelas("RPL-012","RPL", "Senin","4","Yetli Oslan", "60"));
        KelasArrayList.add(new Kelas("AGM-099","Agama", "Jumat","4","Katon Wijana", "1"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Kelas Kelas = data.getParcelableExtra("Kelas");
            KelasArrayList.add(Kelas);
            KelasAdapter.notifyDataSetChanged();
        }
        else if(requestCode == 2 && resultCode == RESULT_OK) {
            Kelas Kelas = data.getParcelableExtra("Kelas");
            int pos = data.getIntExtra("position", -1);
            KelasArrayList.set(pos,Kelas);
            KelasAdapter.notifyDataSetChanged();
        }
    }
}
