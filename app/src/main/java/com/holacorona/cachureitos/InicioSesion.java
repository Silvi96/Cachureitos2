package com.holacorona.cachureitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {

    Button ingresar, crear;
    EditText rut, clave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        rut = (EditText)findViewById(R.id.tRut);
        clave = (EditText)findViewById(R.id.txt_clave);
        ingresar = (Button)findViewById(R.id.btn_ingresar);
        crear = (Button)findViewById(R.id.btn_crear);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), crearCuenta.class);
                startActivity(I);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase Db;
                SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
                Db = Conn.getWritableDatabase();

                try{
                    Cursor cursor = Conn.Consulta(rut.getText().toString(), clave.getText().toString());
                    if (cursor.getCount()>0){
                        Intent I = new Intent(getApplicationContext(), Menu.class);
                        final String RUT = rut.getText().toString();
                        I.putExtra("rut", RUT);
                        startActivity(I);
                    }else{
                        Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });
    }
    public void Credenciales (){

    }
}
