package com.holacorona.cachureitos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class vistaObjetos extends AppCompatActivity {

    ListView lista;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_objetos);

        lista = (ListView)findViewById(R.id.listaObjetos);
        adaptador = new Adaptador(this, listaaa() );
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String elemento = (String)lista.getAdapter().getItem(position);
                if (position==0){
                    Intent I = new Intent(getApplicationContext(), seleccionArticulo.class);
                    startActivity(I);
                }
            }
        });


    }
    private ArrayList <moldee> listaaa() {
        ArrayList<moldee> listaObjetos = new ArrayList<>();
        listaObjetos.add(new moldee("Libros", "Libros y Revistas", "Maule", "Talca"));
        listaObjetos.add(new moldee("Camisetas", "Vestuario", "Maule", "Talca"));
        listaObjetos.add(new moldee("juguetes para bebés", "Juguetes", "Maule", "Talca"));
        listaObjetos.add(new moldee("Jeans", "Vestuario", "Maule", "Talca"));

        return listaObjetos;
    }

}
