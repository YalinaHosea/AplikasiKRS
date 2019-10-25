package com.example.aplikasikrs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasikrs.Adapter.MatkulAdapter;
import com.example.aplikasikrs.Model.Matkul;

import java.util.ArrayList;

public class MatkulActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private MatkulAdapter MatkulAdapter;
    private ArrayList<Matkul> MatkulArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul);

        Button btnadd = findViewById(R.id.BtnAddMatkul);
        addData();
        recycler = findViewById(R.id.Recycler_Matkul);
        MatkulAdapter = new MatkulAdapter(MatkulArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatkulActivity.this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(MatkulAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MatkulActivity.this, AddMatkulActivity.class);
                startActivityForResult(inten,1);
            }
        });

    }



    private void addData() {
        MatkulArrayList = new ArrayList<>();
        MatkulArrayList.add(new Matkul("ALP-033","Alpro", "Senin","6","1"));
        MatkulArrayList.add(new Matkul("PRO-043","Progmob", "Senin","6","2"));
        MatkulArrayList.add(new Matkul("STR-062","Strukdat", "Senin","6","3"));
        MatkulArrayList.add(new Matkul("RPL-012","RPL", "Senin","3","4"));
        MatkulArrayList.add(new Matkul("AGM-099","Agama", "Jumat","3","4"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Matkul Matkul = data.getParcelableExtra("Matkul");
            MatkulArrayList.add(Matkul);
            MatkulAdapter.notifyDataSetChanged();
        }
        else if(requestCode == 2 && resultCode == RESULT_OK) {
            Matkul Matkul = data.getParcelableExtra("Matkul");
            int pos = data.getIntExtra("position", -1);
            MatkulArrayList.set(pos,Matkul);
            MatkulAdapter.notifyDataSetChanged();
        }
    }
}
