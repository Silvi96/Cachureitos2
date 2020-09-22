package com.holacorona.cachureitos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    ListView lista;
    ImageButton perfil, articulos, buscar, ingresar, cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //lista =(ListView)findViewById(R.id.listaMenu);
        perfil = (ImageButton)findViewById(R.id.btn_perfil);
        articulos = (ImageButton)findViewById(R.id.btn_articulos);
        buscar = (ImageButton)findViewById(R.id.btn_buscar);
        ingresar = (ImageButton)findViewById(R.id.btn_ingresar);
        cerrar = (ImageButton)findViewById(R.id.btn_cerrar);




        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), perfil.class);

                Bundle B = getIntent().getExtras();
                String RUT = B.getString("rut");

                I.putExtra("rut", RUT);
                startActivity(I);
            }
        });
        articulos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), MisArticulos.class);

                Bundle B = getIntent().getExtras();
                String RUT = B.getString("rut");
                //rut.setText((RUT) + "");

                //final String RUT = rut.getText().toString();
                I.putExtra("rut", RUT);


                startActivity(I);
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), buscar.class);
                startActivity(I);
            }
        });
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), ingresoArticulos.class);
                Bundle B = getIntent().getExtras();
                String RUT = B.getString("rut");

                I.putExtra("rut", RUT);
                startActivity(I);
            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
                builder.setTitle("Atencion").setMessage("¿Desea cerrar sesión?")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Hasta pronto", Toast.LENGTH_SHORT).show();
                                Intent I = new Intent(getApplicationContext(), InicioSesion.class);
                                startActivity(I);
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

        /*lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String)lista.getAdapter().getItem(position);
                if (position==0){
                    Intent I = new Intent(getApplicationContext(), perfil.class);
                    startActivity(I);
                }
                else if (position==1){
                    Intent E = new Intent(getApplicationContext(), MisArticulos.class);
                    startActivity(E);
                }
                else if (position==2){
                    Intent E = new Intent(getApplicationContext(), buscar.class);
                    startActivity(E);
                }
                else if (position==3){
                    Intent E = new Intent(getApplicationContext(), ingresoArticulos.class);
                    startActivity(E);
                }
                else if (position==4){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
                    builder.setTitle("Atencion").setMessage("¿Desea cerrar sesión?")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Hasta pronto", Toast.LENGTH_SHORT).show();
                                    Intent I = new Intent(getApplicationContext(), InicioSesion.class);
                                    startActivity(I);
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
            }
        });*/


    }
}
