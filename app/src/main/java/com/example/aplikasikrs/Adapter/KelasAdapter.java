package com.example.aplikasikrs.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.aplikasikrs.Model.Kelas;
import com.example.aplikasikrs.R;

import java.util.ArrayList;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.ViewHolder> {

    private ArrayList<Kelas> datalist;
    Context mContext;
    public KelasAdapter(ArrayList<Kelas> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.kelas_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtNama.setText(datalist.get(position).getNama());
        holder.txtkode.setText(datalist.get(position).getKode_krs());
        holder.txthari.setText(datalist.get(position).getHari());
        holder.txtsesi.setText(datalist.get(position).getSesi());
        holder.txtdosen.setText(datalist.get(position).getDosen());
        holder.txtjumlah.setText(datalist.get(position).getJumlah());



    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtkode, txthari, txtsesi, txtdosen, txtjumlah;
        public ViewHolder(View view){
            super(view);
            txtkode = view.findViewById(R.id.TxtKodeKelas);
            txtNama = view.findViewById(R.id.TxtNamaKelas);
            txthari = view.findViewById(R.id.TxtHariKelas);
            txtsesi = view.findViewById(R.id.TxtSesiKelas);
            txtdosen = view.findViewById(R.id.TxtDosenKelas);
            txtjumlah = view.findViewById(R.id.TxtPersertaKelas);



        }
    }
}
