package com.example.sqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.MainActivity;
import com.example.sqlite.R;
import com.example.sqlite.database.Teman;


import java.util.ArrayList;
import java.util.HashMap;


public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder>  {

    private ArrayList<Teman> ListData;


    public TemanAdapter(ArrayList<Teman> listData) {
        this.ListData = listData;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinf = LayoutInflater.from(parent.getContext());
        View v = layoutinf.inflate(R.layout.row_data_teman,parent,false);
        return new TemanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TemanAdapter.TemanViewHolder holder, int position) {
        String nm,tlp;

        nm = ListData.get(position).getNama();
        tlp = ListData.get(position).getTelpon();

        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setTextSize(20);
        holder.namaTxt.setText(nm);
        holder.telponTxt.setText(tlp);

        holder.cardku.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {

        return (ListData != null)?ListData.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {

        private CardView cardku;
        private TextView namaTxt,telponTxt;
        public TemanViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
            namaTxt = (TextView) view.findViewById(R.id.textNama);
            telponTxt = (TextView) view.findViewById(R.id.textTelpon);


        }

    }

}
