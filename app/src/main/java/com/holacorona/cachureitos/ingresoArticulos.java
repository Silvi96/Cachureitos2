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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ingresoArticulos extends AppCompatActivity {

    Button ingresar;
    Spinner sp;
    EditText titulo, descripcion;
    TextView rut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_articulos);

        sp = (Spinner)findViewById(R.id.s_categoria);
        titulo = (EditText)findViewById(R.id.txt_titulo);
        descripcion = (EditText)findViewById(R.id.txt_descripcion);
        ingresar = (Button)findViewById(R.id.btn_ingresar);
        rut = (TextView)findViewById(R.id.txtrut);

        ArrayList<String> categoria = new ArrayList<>();
        categoria.add("---");
        categoria.add("Muebles");
        categoria.add("Electrodomésticos");
        categoria.add("Herramientas");
        categoria.add("Vestuario");
        categoria.add("Bolsos y Accesorios");
        categoria.add("Calzado");
        categoria.add("Juguetes");
        categoria.add("Libros y Revistas");
        categoria.add("Arte");
        categoria.add("Otros");
        ArrayAdapter adpr = new ArrayAdapter(ingresoArticulos.this, android.R.layout.simple_spinner_dropdown_item, categoria);
        sp.setAdapter(adpr);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tituloo = titulo.getText().toString();
                String categ = sp.getSelectedItem().toString();
                String descrip = descripcion.getText().toString();

                if ((tituloo.equals("")) || (descrip.equals(""))||(sp.getSelectedItem()=="---")){
                    Toast.makeText(getApplicationContext(), "Ingrese todos los datos por favor", Toast.LENGTH_SHORT).show();
                }
                else {
                    Bundle B = getIntent().getExtras();
                    String RUTT = B.getString("rut");
                    rut.setText((RUTT) + "");

                    SQLiteDatabase Db;
                    SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
                    Db = Conn.getWritableDatabase();

                    Cursor cursor = Db.rawQuery("SELECT * FROM crearcuenta", null);
                    if ((cursor!=null)&&(cursor.getCount()>0)){
                        if (cursor.moveToFirst()){  //cursor en posicion 0
                            do {
                                do {
                                    //String RUT = rut.getText().toString();
                                    String PK = cursor.getString(0);

                                    if (RUTT.equals(PK)) {
                                        String titulooo = titulo.getText().toString();
                                        String categg = sp.getSelectedItem().toString();
                                        String descripp = descripcion.getText().toString();

                                        ContentValues CV = new ContentValues(); //es como si fuera un vector
                                        CV.put("titulo", titulooo);
                                        CV.put("categoría", categg);
                                        CV.put("descripcion", descripp);
                                        Db.insert("ingreso", null, CV);
                                        Db.close();
                                        Toast.makeText(getApplicationContext(), "ARTÍCULO INSERTADO", Toast.LENGTH_SHORT).show();
                                    }
                                } while (cursor.moveToNext());
                            }
                            while (cursor.moveToNext());
                        }
                    }
                }
            }
        });
    }
}
