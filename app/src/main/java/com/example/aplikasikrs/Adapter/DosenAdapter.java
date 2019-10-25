package com.example.aplikasikrs.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasikrs.Model.Dosen;
import com.example.aplikasikrs.R;

import java.util.ArrayList;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.ViewHolder> {

    private ArrayList<Dosen> datalist;
    public DosenAdapter(ArrayList<Dosen> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dosen_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNama.setText(datalist.get(position).getNama());
        holder.txtnidn.setText(datalist.get(position).getNidn());
        holder.txtgelar.setText(datalist.get(position).getGelar());
        holder.txtalamat.setText(datalist.get(position).getAlamat());
        holder.txtemail.setText(datalist.get(position).getEmail());
        holder.foto.setImageResource(datalist.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtnidn, txtgelar, txtalamat, txtemail;
        private ImageView foto;
        public ViewHolder(View view){
            super(view);
            txtnidn = view.findViewById(R.id.TxtNIDN);
            txtNama = view.findViewById(R.id.TxtNama);
            txtgelar = view.findViewById(R.id.TxtGelar);
            txtalamat = view.findViewById(R.id.TxtAlamat);
            txtemail = view.findViewById(R.id.TxtEmail);
            foto = view.findViewById(R.id.ImgDosen);



        }
    }
}
