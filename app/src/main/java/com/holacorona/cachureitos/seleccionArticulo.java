package com.holacorona.cachureitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class seleccionArticulo extends AppCompatActivity {

    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_articulo);

        volver = (Button)findViewById(R.id.btn_volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), vistaObjetos.class);
                startActivity(I);
            }
        });
    }
}
