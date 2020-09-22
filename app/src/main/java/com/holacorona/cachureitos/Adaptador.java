package com.holacorona.cachureitos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<moldee> listaObjetos;
    private Context context;

    public Adaptador (Context context, ArrayList<moldee> listaObjetos){
        this.context = context;
        this.listaObjetos = listaObjetos;
    }

    @Override
    public int getCount() {
        return listaObjetos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaObjetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        moldee Item = (moldee) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.molde, null);
        TextView txt_nombre =convertView.findViewById(R.id.txt_nombre);
        TextView txt_categoria =convertView.findViewById(R.id.txt_categoria);
        TextView txt_region =convertView.findViewById(R.id.txt_region);
        TextView txt_ciudad =convertView.findViewById(R.id.txt_ciudad);

        txt_nombre.setText(Item.getNombre());
        txt_categoria.setText(Item.getCategoria());
        txt_region.setText(Item.getRegion());
        txt_ciudad.setText(Item.getCiudad());

        return convertView;
    }
}
