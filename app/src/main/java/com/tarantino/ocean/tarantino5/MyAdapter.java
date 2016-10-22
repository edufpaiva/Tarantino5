package com.tarantino.ocean.tarantino5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.glide.GlideRequest;

import java.util.ArrayList;

/**
 * Created by rafael trindade on 22/10/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private final Context context;
    private ArrayList<Filme> filmes;

    public MyAdapter(Context context, ArrayList<Filme> filmes) {
        this.context = context;
        this.filmes = filmes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filme,null);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Filme filme =  filmes.get(position);

        holder
                .setTitulo(filme.getTitulo())
                .setAno(filme.getAno())
                .setAtores(filme.getAtores())
                .setDuraco(filme.getDuracao())
                .setImage(filme.getCapa());
    }

    @Override
    public int getItemCount()
    {
        return filmes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txtTitulo;
        private TextView txtatores;
        private TextView txtano;
        private TextView txtduraco;
        private ImageView imgcapa;

        public ViewHolder(View itemView)
        {
            super(itemView);
            imgcapa = (ImageView) itemView.findViewById(R.id.capafilmeid);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulofilmeid);
            txtatores = (TextView) itemView.findViewById(R.id.atoresid);
            txtano = (TextView) itemView.findViewById(R.id.anoid);
            txtduraco = (TextView) itemView.findViewById(R.id.horaid);
        }

        public  ViewHolder setTitulo(String titulo)
        {
         if(txtTitulo == null) return this;
            txtTitulo.setText(titulo);
            return this;
        }
        public  ViewHolder setAtores(String atores)
        {
            if(txtatores == null) return this;
            txtatores.setText(atores);
            return this;
        }
        public  ViewHolder setAno(int ano)
        {
            if(txtano == null) return this;
            txtano.setText(ano);
            return this;
        }
        public  ViewHolder setDuraco(int duraco)
        {
            if(txtduraco == null) return this;
            txtduraco.setText(duraco);
            return this;
        }
        public  ViewHolder setImage(String image)
        {
            if (imgcapa == null) return this;
            Ocean.glide(context)
                    .load(image)
                    .build(GlideRequest.BITMAP)
                    .into(imgcapa);

            return this;
        }
    }
}
