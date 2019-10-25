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

import com.example.aplikasikrs.AddKRSActivity;
import com.example.aplikasikrs.KRSActivity;
import com.example.aplikasikrs.Model.KRS;
import com.example.aplikasikrs.R;

import java.util.ArrayList;

public class KRSAdapter extends RecyclerView.Adapter<KRSAdapter.ViewHolder> {

    private ArrayList<KRS> datalist;
    Context mContext;
    public KRSAdapter(ArrayList<KRS> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.krs_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtNama.setText(datalist.get(position).getNama());
        holder.txtkode.setText(datalist.get(position).getKode_krs());
        holder.txthari.setText(datalist.get(position).getHari());
        holder.txtsks.setText(datalist.get(position).getSks());
        holder.txtsesi.setText(datalist.get(position).getSesi());
        holder.txtdosen.setText(datalist.get(position).getDosen());
        holder.txtjumlah.setText(datalist.get(position).getJumlah());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(holder.itemView.getContext(), AddKRSActivity.class);
                inten.putExtra("KRS",datalist.get(position));
                inten.putExtra("position", position);
                ((Activity) mContext).startActivityForResult(inten,2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtkode, txthari, txtsesi, txtsks, txtdosen, txtjumlah;
        public ViewHolder(View view){
            super(view);
            txtkode = view.findViewById(R.id.TxtKodeKRS);
            txtNama = view.findViewById(R.id.TxtNamaKRS);
            txthari = view.findViewById(R.id.TxtHariKRS);
            txtsesi = view.findViewById(R.id.TxtSesiKRS);
            txtsks = view.findViewById(R.id.TxtSKSKRS);
            txtdosen = view.findViewById(R.id.TxtDosenKRS);
            txtjumlah = view.findViewById(R.id.TxtPersertaKRS);



        }
    }
}
