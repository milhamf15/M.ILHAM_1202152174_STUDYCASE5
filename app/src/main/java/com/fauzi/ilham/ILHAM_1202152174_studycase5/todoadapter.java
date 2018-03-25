package com.fauzi.ilham.ILHAM_1202152174_studycase5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dwima on 25/03/2018.
 */

public class todoadapter extends RecyclerView.Adapter<todoadapter.holder> {
    private Context cont;
    private List<itemtodo> items;
    int id;

    public todoadapter(Context cont, List<itemtodo> items, int id){
        this.cont = cont;
        this.items = items;
        this.id = id;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(cont).inflate(R.layout.daftar_item, parent, false);
        holder hold = new holder(v);
        return hold;
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
        itemtodo i = items.get(position);
        holder.nama.setText(i.getNama());
        holder.deskripsi.setText(i.getDeskripsi());
        holder.prioritas.setText(i.getPrioritas());
        holder.cd.setCardBackgroundColor(cont.getResources().getColor(this.id));
    }
    public itemtodo getItem(int position){
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void removeditem(int i){
        items.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, items.size());
    }

    class holder extends RecyclerView.ViewHolder{
        public TextView nama, deskripsi, prioritas;
        public CardView cd;
        public holder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.namatodo);
            deskripsi = itemView.findViewById(R.id.deskripsitodo);
            prioritas = itemView.findViewById(R.id.prioritastodo);
            cd = itemView.findViewById(R.id.cardisitodo);
        }
    }
}
