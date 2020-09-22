package com.holacorona.cachureitos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listaModificarArticulos extends AppCompatActivity {

    ListView listaa;
    ArrayList<String> Articulos = new ArrayList<String>();
    ArrayList<String> ID = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_modificar_articulos);

        listaa= (ListView)findViewById(R.id.lista_Articulos);
        CargarLista();

        listaa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String iD = ID.get(position);
                final String Art = Articulos.get(position);
                Intent I = new Intent(getApplicationContext(),mArticulos.class);
                I.putExtra("PK", iD);
                I.putExtra("Descripcion", Art);
                I.putExtra("Titulo", Art);
                startActivity(I);
                CargarLista();
            }
        });

    }
    public void CargarLista(){
        Articulos.clear();
        ID.clear();

        SQLiteDatabase Db;
        SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
        Db = Conn.getWritableDatabase();

        Cursor C = Db.query("ingreso", null, null, null, null,null, null);
        if ((C!=null)&&(C.getCount()>0)){
            if (C.moveToFirst()){  //cursor en posicion 0
                do {
                    String desccripcion = C.getString(3);
                    Articulos.add(desccripcion);
                    ID.add(C.getInt(0)+"");
                }
                while (C.moveToNext());
            }
        }
        ArrayAdapter<String> Adaptador = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, Articulos);
        listaa.setAdapter(Adaptador);
    }
}
