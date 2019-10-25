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

import com.example.aplikasikrs.Adapter.KRSAdapter;
import com.example.aplikasikrs.Model.KRS;

import java.util.ArrayList;

public class KRSActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private KRSAdapter KRSAdapter;
    private ArrayList<KRS> KRSArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krs);

        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        setTitle("SI KRS - Hai " + name);


        Button btnadd = findViewById(R.id.BtnAddKRS);
        addData();
        recycler = findViewById(R.id.Recycler_KRS);
        KRSAdapter = new KRSAdapter(KRSArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(KRSActivity.this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(KRSAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(KRSActivity.this, AddKRSActivity.class);
                startActivityForResult(inten,1);
            }
        });

    }



    private void addData() {
        KRSArrayList = new ArrayList<>();
        KRSArrayList.add(new KRS("ALP-033","Alpro", "Senin","6","1", "Katon Wijana", "1"));
        KRSArrayList.add(new KRS("PRO-043","Progmob", "Senin","6","2","Eric Kurniawan", "50"));
        KRSArrayList.add(new KRS("STR-062","Strukdat", "Senin","6","3","Argo Wibowo", "35"));
        KRSArrayList.add(new KRS("RPL-012","RPL", "Senin","3","4","Yetli Oslan", "60"));
        KRSArrayList.add(new KRS("AGM-099","Agama", "Jumat","3","4","Katon Wijana", "1"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            KRS KRS = data.getParcelableExtra("KRS");
            KRSArrayList.add(KRS);
            KRSAdapter.notifyDataSetChanged();
        }
        else if(requestCode == 2 && resultCode == RESULT_OK) {
            KRS KRS = data.getParcelableExtra("KRS");
            int pos = data.getIntExtra("position", -1);
            KRSArrayList.set(pos,KRS);
            KRSAdapter.notifyDataSetChanged();
        }
    }
}
