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

import com.example.aplikasikrs.Adapter.DosenAdapter;
import com.example.aplikasikrs.Model.Dosen;

import java.util.ArrayList;

public class DosenActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen> dosenArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);
        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        setTitle("SI KRS - Hai " + name);


        Button btnadd = findViewById(R.id.BtnAddDosen);
        addData();
        recycler = findViewById(R.id.Recycler_Dosen);
        dosenAdapter = new DosenAdapter(dosenArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DosenActivity.this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(dosenAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(DosenActivity.this, AddDosenActivity.class);
                startActivityForResult(inten,1);
            }
        });

    }



    private void addData() {
        dosenArrayList = new ArrayList<>();
        dosenArrayList.add(new Dosen("201689098","Vincent", "S.Kom","vin@gmail.com","Jl. Kedawung",R.drawable.treecko));
        dosenArrayList.add(new Dosen("201689966","Yalina", "S.Kom","yal@gmail.com","Jl. Weling",R.drawable.mudkip));
        dosenArrayList.add(new Dosen("201689776","Roy", "S.Si","roy@gmail.com","Jl. Beo",R.drawable.togepi));
        dosenArrayList.add(new Dosen("201689331","Tara", "S.Psi","tar@gmail.com","Jl. Melati",R.drawable.larvitar));
        dosenArrayList.add(new Dosen("201684221","Isayama", "S.Man","isa@gmail.com","Jl. Gambar",R.drawable.marowak));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Dosen dosen = data.getParcelableExtra("dosen");
            dosenArrayList.add(dosen);
            dosenAdapter.notifyDataSetChanged();
        }
        else if(requestCode == 2 && resultCode == RESULT_OK) {
            Dosen dosen = data.getParcelableExtra("dosen");
            int pos = data.getIntExtra("position", -1);
            dosenArrayList.set(pos,dosen);
            dosenAdapter.notifyDataSetChanged();
        }
    }
}

