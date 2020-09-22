package com.holacorona.cachureitos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class perfil extends AppCompatActivity {

    TextView rut, nombre, apellidos, telefono, correo, region, ciudad;
    String  rutt, nombree, apellidoss, correoo, telefonoo, regionn, ciudadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        rut = (TextView)findViewById(R.id.tRut);
        nombre = (TextView)findViewById(R.id.txt_nombre);
        apellidos = (TextView)findViewById(R.id.txt_apellidos);
        telefono = (TextView)findViewById(R.id.txt_telefono);
        correo = (TextView)findViewById(R.id.txt_correo);
        region = (TextView)findViewById(R.id.txt_region);
        ciudad = (TextView)findViewById(R.id.txt_ciudad);

        Bundle B = getIntent().getExtras();
        String RUT = B.getString("rut");
        rut.setText((RUT) + "");


        SQLiteDatabase Db;
        SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
        Db = Conn.getWritableDatabase();

        //Cursor cursor = Db.query("crearcuenta",null, null, null, null, null, null);
        Cursor cursor = Db.rawQuery("SELECT * FROM crearcuenta", null);
        if ((cursor!=null)&&(cursor.getCount()>0)){
            if (cursor.moveToFirst()){  //cursor en posicion 0
                do {
                    do {
                        String RUTT = rut.getText().toString();
                        String PK = cursor.getString(0);
                        if (RUTT.equals(PK)) {
                            nombre.setText(cursor.getString(1));
                            apellidos.setText(cursor.getString(2));
                            correo.setText(cursor.getString(3));
                            telefono.setText(cursor.getString(4));
                            region.setText(cursor.getString(5));
                            ciudad.setText(cursor.getString(6));
                        }
                    } while (cursor.moveToNext());
                }
                while (cursor.moveToNext());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.modificardatos:
                String RUTT = rut.getText().toString();
                Intent l = new Intent(getApplicationContext(), modificarDatos.class);
                l.putExtra("rut", RUTT);
                final String NOMBRE = nombre.getText().toString();
                l.putExtra("nombre", NOMBRE);
                final String APELLIDOS = apellidos.getText().toString();
                l.putExtra("apellidos", APELLIDOS);
                final String CORREO = correo.getText().toString();
                l.putExtra("correo", CORREO);
                final int TELEFONO = Integer.parseInt(telefono.getText().toString());
                l.putExtra("telefono", TELEFONO);

                final String REGION = region.getText().toString();
                l.putExtra("region", REGION);

                /*final String CIUDAD = ciudad.getText().toString();
                l.putExtra("ciudad", CIUDAD);*/
                startActivity(l);
                return true;
            case R.id.eliminarCuenta:
                AlertDialog.Builder dialogo = new AlertDialog.Builder(perfil.this);
                dialogo.setTitle("Eliminar cuenta");
                dialogo.setMessage("¿Está seguro de eliminar la cuenta?");
                dialogo.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase Db;
                        SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
                        Db = Conn.getWritableDatabase();

                        Conn.EliminarCuenta(rut.getText().toString());

                        Toast.makeText(getApplicationContext(), "Cuenta eliminada", Toast.LENGTH_SHORT).show();
                        Intent T = new Intent (getApplicationContext(), InicioSesion.class);
                        startActivity(T);
                    }
                });
                dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //return dialogo.create();
                AlertDialog dialog = dialogo.create();
                dialogo.show();
                return true;
            case R.id.cambiarClave:
                Intent r = new Intent(getApplicationContext(), cambioClave.class);
                String RUT = rut.getText().toString();
                r.putExtra("rut", RUT);
                startActivity(r);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
