package com.holacorona.cachureitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class cambioClave extends AppCompatActivity {

    EditText clave, confirmacion;
    Button guardar;
    TextView rut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_clave);

        clave = (EditText)findViewById(R.id.txt_clave);
        confirmacion = (EditText)findViewById(R.id.txt_clavedos);
        rut= (TextView)findViewById(R.id.txtRUT);
        guardar = (Button)findViewById(R.id.btnGuardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String claveUno = clave.getText().toString();
                String claveRepetir = confirmacion.getText().toString();
                //String rutt = rut.getText().toString();
                if ((claveUno.equals("")) || (claveRepetir.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Ingrese todos los datos por favor", Toast.LENGTH_SHORT).show();
                }
                else if (!claveUno.equals(claveRepetir)){
                    Toast.makeText(getApplicationContext(), "Conraseñas distintas", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase Db;
                    SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
                    Db = Conn.getWritableDatabase();

                    Bundle B = getIntent().getExtras();
                    String RUT = B.getString("rut");
                    rut.setText((RUT) + "");

                    Cursor cursor = Db.rawQuery("SELECT * FROM crearcuenta", null);
                    if ((cursor!=null)&&(cursor.getCount()>0)){
                        if (cursor.moveToFirst()){  //cursor en posicion 0
                            do {
                                do {
                                    String RUTT = rut.getText().toString();
                                    String PK = cursor.getString(0);
                                    String Clave = clave.getText().toString();
                                    String Confirmacion = confirmacion.getText().toString();

                                    if (RUTT.equals(PK)) {
                                        String Where = "rut=?";
                                        String[] ArgWhere = {PK};

                                        ContentValues CV = new ContentValues();
                                        CV.put("contrasena", Clave);
                                        CV.put ("confirmacion", Confirmacion);
                                        Db.update("crearcuenta", CV, Where, ArgWhere);
                                        Db.close();
                                        Toast.makeText(getApplicationContext(), "CONTRASEÑA MODIFICADA", Toast.LENGTH_SHORT).show();
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
