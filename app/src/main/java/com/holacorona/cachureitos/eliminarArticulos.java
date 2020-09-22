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

public class eliminarArticulos extends AppCompatActivity {

    ListView listaa;
    ArrayList<String> MisArticulos = new ArrayList<String>();
    ArrayList<String> ClavesPK = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_articulos);

        listaa= (ListView)findViewById(R.id.lista_Articulos);
        CargarInformacion();

        //ArrayList<String> opciones = new ArrayList<>();


        //ArrayAdapter adp = new ArrayAdapter(eliminarArticulos.this, android.R.layout.simple_spinner_dropdown_item, opciones);
        //listaa.setAdapter(adp);

        listaa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String m_pk = ClavesPK.get(position); //Si es que fuera un texto la clave primaria

                AlertDialog.Builder builder = new AlertDialog.Builder(eliminarArticulos.this);
                builder.setTitle("Atencion").setMessage("¿Desea eliminar el artículo?")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                boolean R = EliminarRegistro(m_pk);
                                if (R){
                                    Toast.makeText(getApplicationContext(), "Registro eliminado", Toast.LENGTH_SHORT).show();
                                    CargarInformacion();
                                }
                            }
                        });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
    public boolean EliminarRegistro (String PK){
        boolean retornar = false;
        //Conexion a la bd
        SQLiteDatabase Db;
        SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
        Db = Conn.getWritableDatabase();

        String  where = "id_articulo=?";
        //Convertirlo, arriba esta en int y aqui en string
        String[] ArgWhere = {PK};
        if (Db.delete("ingreso", where, ArgWhere)>0){
            retornar= true;
        }
        return retornar;
    }

    public void CargarInformacion (){
        MisArticulos.clear();
        ClavesPK.clear();

        SQLiteDatabase Db;
        SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
        Db = Conn.getWritableDatabase();

        Cursor C = Db.query("ingreso", null, null, null, null,null, null);

        if ((C!=null)&&(C.getCount()>0)){
            if (C.moveToFirst()){  //cursor en posicion 0
                do {
                    //int PK = C.getInt(0);  //para sacar la informacion del id
                    String Descripcion = C.getString(3); //saco la posicion 1 del cursor
                    MisArticulos.add(Descripcion); //se agrega al cursor creado
                    ClavesPK.add(C.getInt(0)+""); //Concatenar comillas por String
                }
                while (C.moveToNext()); //pregunto si hay informacion o no
            }
        }
        ArrayAdapter<String> Adaptador = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, MisArticulos);
        listaa.setAdapter(Adaptador);
    }
}
