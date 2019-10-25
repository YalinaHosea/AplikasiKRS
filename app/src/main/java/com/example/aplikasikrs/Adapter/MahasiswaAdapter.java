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

import com.example.aplikasikrs.AddMahasiswaActivity;
import com.example.aplikasikrs.MahasiswaActivity;
import com.example.aplikasikrs.Model.Mahasiswa;
import com.example.aplikasikrs.R;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    private ArrayList<Mahasiswa> datalist;
    Context mContext;
    public MahasiswaAdapter(ArrayList<Mahasiswa> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mahasiswa_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtNama.setText(datalist.get(position).getNama());
        holder.txtnim.setText(datalist.get(position).getNim());
        holder.txtalamat.setText(datalist.get(position).getAlamat());
        holder.txtemail.setText(datalist.get(position).getEmail());
        holder.foto.setImageResource(datalist.get(position).getFoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(holder.itemView.getContext(), AddMahasiswaActivity.class);
                inten.putExtra("Mahasiswa",datalist.get(position));
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
        private TextView txtNama, txtnim, txtalamat, txtemail;
        private ImageView foto;
        public ViewHolder(View view){
            super(view);
            txtnim = view.findViewById(R.id.TxtNIM);
            txtNama = view.findViewById(R.id.TxtNamaMahasiswa);
            txtalamat = view.findViewById(R.id.TxtAlamatMahasiswa);
            txtemail = view.findViewById(R.id.TxtEmailMahasiswa);
            foto = view.findViewById(R.id.ImgMahasiswa);




        }
    }
}
