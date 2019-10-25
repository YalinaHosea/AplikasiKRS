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

import com.example.aplikasikrs.AddMatkulActivity;
import com.example.aplikasikrs.MatkulActivity;
import com.example.aplikasikrs.Model.Matkul;
import com.example.aplikasikrs.R;

import java.util.ArrayList;

public class MatkulAdapter extends RecyclerView.Adapter<MatkulAdapter.ViewHolder> {

    private ArrayList<Matkul> datalist;
    Context mContext;
    public MatkulAdapter(ArrayList<Matkul> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.matkul_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtNama.setText(datalist.get(position).getNama());
        holder.txtkode.setText(datalist.get(position).getKode_matkul());
        holder.txthari.setText(datalist.get(position).getHari());
        holder.txtsks.setText(datalist.get(position).getSks());
        holder.txtsesi.setText(datalist.get(position).getSesi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(holder.itemView.getContext(), AddMatkulActivity.class);
                inten.putExtra("Matkul",datalist.get(position));
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
        private TextView txtNama, txtkode, txthari, txtsesi, txtsks;
        public ViewHolder(View view){
            super(view);
            txtkode = view.findViewById(R.id.TxtKode);
            txtNama = view.findViewById(R.id.TxtNamaMakul);
            txthari = view.findViewById(R.id.TxtHari);
            txtsesi = view.findViewById(R.id.TxtSesi);
            txtsks = view.findViewById(R.id.TxtSKS);


        }
    }
}
