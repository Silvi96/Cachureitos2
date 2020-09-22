package com.holacorona.cachureitos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MisArticulos extends AppCompatActivity {

    ListView listaa;
    TextView Rut;
    final ArrayList<String> opciones = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_articulos);

        listaa= (ListView)findViewById(R.id.lista_Articulos);
        Rut = (TextView)findViewById(R.id.txtRut);

        Bundle B = getIntent().getExtras();
        String RUT = B.getString("rut");
        Rut.setText((RUT) + "");

        SQLiteDatabase Db;
        SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
        Db = Conn.getWritableDatabase();


        Cursor C = Db.query("ingreso", null, null, null, null,null, null);
        if ((C!=null)&&(C.getCount()>0)){
            if (C.moveToFirst()){
                do {
                    String descrip = C.getString(3);
                    opciones.add(descrip);
                }
                while (C.moveToNext());
            }
        }
        ArrayAdapter <String> adp = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, opciones);
        listaa.setAdapter(adp);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menux, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.marticulo:
                Intent I = new Intent(getApplicationContext(), listaModificarArticulos.class);
                startActivity(I);
                return true;
            case R.id.earticulo:
                Intent P = new Intent(getApplicationContext(), eliminarArticulos.class);
                startActivity(P);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
