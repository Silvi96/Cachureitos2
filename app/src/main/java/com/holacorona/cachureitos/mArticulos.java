package com.holacorona.cachureitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class mArticulos extends AppCompatActivity {

    Button guardar;
    EditText descripcion, titulo;
    TextView ID, categoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_articulos);


        guardar = (Button)findViewById(R.id.btn_cambios);
        categoria = (TextView)findViewById(R.id.txtCategoria);
        descripcion = (EditText)findViewById(R.id.txt_descripcion);
        titulo = (EditText)findViewById(R.id.txt_titulo);
        ID = (TextView)findViewById(R.id.txtID);
        categoria.setEnabled(false);

        Bundle B = getIntent().getExtras();
        descripcion.setText(B.getString("Descripcion"));
        ID.setText(B.getString("PK"));

        SQLiteDatabase Db;
        SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
        Db = Conn.getWritableDatabase();
        Cursor cursor = Db.rawQuery("SELECT * FROM ingreso", null);
        if ((cursor!=null)&&(cursor.getCount()>0)){
            if (cursor.moveToFirst()){  //cursor en posicion 0
                do {
                    do {
                        String id = ID.getText().toString();
                        String PK = cursor.getString(0);
                        if (id.equals(PK)) {
                            titulo.setText(cursor.getString(1));
                            categoria.setText(cursor.getString(2));
                            descripcion.setText(cursor.getString(3));
                        }
                    } while (cursor.moveToNext());
                }
                while (cursor.moveToNext()); //pregunto si hay informacion o no
            }
        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Descripcion = descripcion.getText().toString();
                String id = ID.getText().toString();
                String Titulo = titulo.getText().toString();

                SQLiteDatabase Db;
                SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
                Db = Conn.getWritableDatabase();

                String Where = "id_articulo=?";
                String[] ArgWhere = {id};

                ContentValues CV = new ContentValues(); //es como si fuera un vector
                CV.put("titulo", Titulo);
                CV.put("descripcion", Descripcion);
                Db.update("ingreso", CV, Where, ArgWhere);
                Db.close();
                Toast.makeText(getApplicationContext(), "REGISTRO MODIFICADO", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
