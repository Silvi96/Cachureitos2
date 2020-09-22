package com.holacorona.cachureitos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class articuloCero extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo_cero);



    }
    //@Override
    /*public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opcion, menu);
        return true;
    }*/
    //@Override
    /*public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.modificarArticulo:
                Intent I = new Intent(getApplicationContext(), modificarArticulos.class);
                startActivity(I);
            case R.id.eliminarArticulo:
                AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
                dialogo.setTitle("Eliminar articulo");
                dialogo.setMessage("¿Está seguro de eliminar el artículo?");
                dialogo.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //return dialogo.create();
        }
        return super.onOptionsItemSelected(item);
    }*/
}
