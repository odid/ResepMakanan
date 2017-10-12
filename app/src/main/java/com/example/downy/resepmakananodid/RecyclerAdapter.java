package com.example.downy.resepmakananodid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Downy on 10/5/2017.
 */

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    //deklarasi variable context

    private final Context context;

    String [] name={"Ketoprak","Ikan Patin"};
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    String [] deskripsi={"Ketoprak asoyyy","Ikan Patin manis asin"};
    Integer [] gambar={R.drawable.ketoprak,R.drawable.patin};

    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context=context;
        inflater= LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.tampilanrecycle, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {


        int gamb=gambar[position];
        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.tv2.setText(deskripsi[position]);
        holder.tv2.setOnClickListener(clickListener);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.tv2.setTag(holder);
        holder.imageView.setTag(holder);
        holder.imageView.setImageResource(gamb);



    }





    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();
            Bundle b = new Bundle();

            /// mengeset gambar ke bundle
            b.putInt("gambar",gambar[position]);
            b.putString("label","Resep "+name[position]);


            Intent intent=new Intent(context,TampilanDetil.class);
            intent.putExtras(b);
            context.startActivity(intent);
        }
    };



    @Override
    public int getItemCount() {
        return name.length;
    }
}
