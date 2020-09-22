package com.holacorona.cachureitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class modificarDatos extends AppCompatActivity {

    Button guardar;
    Spinner region, ciudad;
    TextView rut;
    EditText nombre, apellidos, correo, telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_datos);

        region = (Spinner)findViewById(R.id.spinner_categoria);
        ciudad = (Spinner)findViewById(R.id.spinner4);
        rut = (TextView)findViewById(R.id.tRut);
        nombre = (EditText)findViewById(R.id.tNombre);
        apellidos = (EditText)findViewById(R.id.tApellidos);
        correo = (EditText)findViewById(R.id.tCorreo);
        telefono = (EditText)findViewById(R.id.tTelefono);

        Bundle B = getIntent().getExtras();
        String RUTT = B.getString("rut");
        rut.setText((RUTT) + "");
        String NOMBRE = B.getString("nombre");
        nombre.setText((NOMBRE) + "");
        String APELLIDOS = B.getString("apellidos");
        apellidos.setText((APELLIDOS) + "");
        String CORREO = B.getString("correo");
        correo.setText((CORREO) + "");
        int TELEFONO = B.getInt("telefono");
        telefono.setText((TELEFONO) + "");
        String REGION = B.getString("region");




        final ArrayList<String> regiones = new ArrayList<>();
        regiones.add("---");
        regiones.add("Arica y Parinacota");
        regiones.add("Tarapacá");
        regiones.add("Antofagasta");
        regiones.add("Atacama");
        regiones.add("Coquimbo");
        regiones.add("Valparaíso");
        regiones.add("Metropolitana de Santiago");
        regiones.add("Libertador General Bernardo O'Higgins");
        regiones.add("Maule");
        regiones.add("Ñuble");
        regiones.add("Biobío");
        regiones.add("La Araucanía");
        regiones.add("Los Ríos");
        regiones.add("Los Lagos");
        regiones.add("Aysen");
        regiones.add("Magallanes y la Antártica Chilena");
        ArrayAdapter adp = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, regiones);
        region.setAdapter(adp);


        final ArrayList<String> ciudadArica = new ArrayList<>();
        ciudadArica.add("---");
        ciudadArica.add("Arica");
        ciudadArica.add("Camarones");
        ciudadArica.add("Putre");
        ciudadArica.add("General Lagos");
        final ArrayAdapter adaptador = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadArica);
        ciudad.setAdapter(adaptador);

        ArrayList<String> ciudadTarapaca = new ArrayList<>();
        ciudadTarapaca.add("---");
        ciudadTarapaca.add("Iquique");
        ciudadTarapaca.add("Alto Hospicio");
        ciudadTarapaca.add("Pozo Almonte");
        ciudadTarapaca.add("Camiña");
        ciudadTarapaca.add("Colchane");
        ciudadTarapaca.add("Huara");
        ciudadTarapaca.add("Pica");
        final ArrayAdapter ad = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadTarapaca);
        ciudad.setAdapter(ad);

        final ArrayList<String> ciudadAntofagasta = new ArrayList<>();
        ciudadAntofagasta.add("---");
        ciudadAntofagasta.add("Antofagasta");
        ciudadAntofagasta.add("Mejillones");
        ciudadAntofagasta.add("Sierra Gorda");
        ciudadAntofagasta.add("Taltal");
        ciudadAntofagasta.add("Calama");
        ciudadAntofagasta.add("Ollagüe");
        ciudadAntofagasta.add("San Pedro de Atacama");
        ciudadAntofagasta.add("Tocopilla");
        ciudadAntofagasta.add("María Elena");
        final ArrayAdapter adap = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadAntofagasta);
        ciudad.setAdapter(adap);

        ArrayList<String> ciudadAtacama = new ArrayList<>();
        ciudadAtacama.add("---");
        ciudadAtacama.add("Chañaral");
        ciudadAtacama.add("Diego de Almagro");
        ciudadAtacama.add("Copiapó");
        ciudadAtacama.add("Caldera");
        ciudadAtacama.add("Tierra Amarilla");
        ciudadAtacama.add("Vallenar");
        ciudadAtacama.add("Alto del Carmen");
        ciudadAtacama.add("Freirina");
        ciudadAtacama.add("Huasco");
        final ArrayAdapter adapt = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadAtacama);
        ciudad.setAdapter(adapt);

        ArrayList<String> ciudadCoquimbo = new ArrayList<>();
        ciudadCoquimbo.add("---");
        ciudadCoquimbo.add("Illapel");
        ciudadCoquimbo.add("Canela");
        ciudadCoquimbo.add("Los Vilos");
        ciudadCoquimbo.add("Salamanca");
        ciudadCoquimbo.add("Coquimbo");
        ciudadCoquimbo.add("Andacollo");
        ciudadCoquimbo.add("La Higuera");
        ciudadCoquimbo.add("La Serena");
        ciudadCoquimbo.add("Paihuano");
        ciudadCoquimbo.add("Vicuña");
        ciudadCoquimbo.add("Ovalle");
        ciudadCoquimbo.add("Combarbalá");
        ciudadCoquimbo.add("Monte Patria");
        ciudadCoquimbo.add("Punitaqui");
        ciudadCoquimbo.add("Río Hurtado");
        final ArrayAdapter adapta = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadCoquimbo);
        ciudad.setAdapter(adapta);

        ArrayList<String> ciudadValparaiso = new ArrayList<>();
        ciudadValparaiso.add("---");
        ciudadValparaiso.add("Isla de Pascua");
        ciudadValparaiso.add("Los Andes");
        ciudadValparaiso.add("Calle Larga");
        ciudadValparaiso.add("Rinconada");
        ciudadValparaiso.add("San Esteban");
        ciudadValparaiso.add("Quilpué");
        ciudadValparaiso.add("Limache");
        ciudadValparaiso.add("Olmué");
        ciudadValparaiso.add("Villa Alemana");
        ciudadValparaiso.add("La Ligua");
        ciudadValparaiso.add("Cabildo");
        ciudadValparaiso.add("Papudo");
        ciudadValparaiso.add("Petorca");
        ciudadValparaiso.add("Zapallar");
        ciudadValparaiso.add("Quillota");
        ciudadValparaiso.add("Hijuelas");
        ciudadValparaiso.add("La Calera");
        ciudadValparaiso.add("La Cruz");
        ciudadValparaiso.add("Nogales");
        ciudadValparaiso.add("San Antonio");
        ciudadValparaiso.add("Algarrobo");
        ciudadValparaiso.add("Cartagena");
        ciudadValparaiso.add("El Quisco");
        ciudadValparaiso.add("El Tabo");
        ciudadValparaiso.add("Santo Domingo");
        ciudadValparaiso.add("San Felipe");
        ciudadValparaiso.add("Catemu");
        ciudadValparaiso.add("Llay Llay");
        ciudadValparaiso.add("Panquehue");
        ciudadValparaiso.add("Putaendo");
        ciudadValparaiso.add("Santa Maria");
        ciudadValparaiso.add("Valparaíso");
        ciudadValparaiso.add("Casablanca");
        ciudadValparaiso.add("Concón");
        ciudadValparaiso.add("Juan Fernández");
        ciudadValparaiso.add("Puchuncaví");
        ciudadValparaiso.add("Quintero");
        ciudadValparaiso.add("Viña del Mar");
        final ArrayAdapter adaptad = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadValparaiso);
        ciudad.setAdapter(adaptad);

        ArrayList<String> ciudadMetropolitana = new ArrayList<>();
        ciudadMetropolitana.add("---");
        ciudadMetropolitana.add("Colina");
        ciudadMetropolitana.add("Lampa");
        ciudadMetropolitana.add("Til Til");
        ciudadMetropolitana.add("Puente Alto");
        ciudadMetropolitana.add("Pirque");
        ciudadMetropolitana.add("San José de Maipo");
        ciudadMetropolitana.add("San Bernardo");
        ciudadMetropolitana.add("Buin");
        ciudadMetropolitana.add("Calera de Tango");
        ciudadMetropolitana.add("Paine");
        ciudadMetropolitana.add("Melipilla");
        ciudadMetropolitana.add("Alhué");
        ciudadMetropolitana.add("Curacaví");
        ciudadMetropolitana.add("María Pinto");
        ciudadMetropolitana.add("San Pedro");
        ciudadMetropolitana.add("Santiago");
        ciudadMetropolitana.add("Cerrillos");
        ciudadMetropolitana.add("Cerro Navia");
        ciudadMetropolitana.add("Conchali");
        ciudadMetropolitana.add("El Bosque");
        ciudadMetropolitana.add("Estación Central");
        ciudadMetropolitana.add("Huechuraba");
        ciudadMetropolitana.add("Independencia");
        ciudadMetropolitana.add("La Cisterna");
        ciudadMetropolitana.add("La Florida");
        ciudadMetropolitana.add("La Granja");
        ciudadMetropolitana.add("La Pintana");
        ciudadMetropolitana.add("La Reina");
        ciudadMetropolitana.add("Las Condes");
        ciudadMetropolitana.add("Lo Barnechea");
        ciudadMetropolitana.add("Lo Espejo");
        ciudadMetropolitana.add("Lo Prado");
        ciudadMetropolitana.add("Macul");
        ciudadMetropolitana.add("Maipú");
        ciudadMetropolitana.add("Ñuñoa");
        ciudadMetropolitana.add("Pedro Aguirre Cerda");
        ciudadMetropolitana.add("Peñalolén");
        ciudadMetropolitana.add("Providencia");
        ciudadMetropolitana.add("Pudahuel");
        ciudadMetropolitana.add("Quilicura");
        ciudadMetropolitana.add("Quinta Normal");
        ciudadMetropolitana.add("Recoleta");
        ciudadMetropolitana.add("Renca");
        ciudadMetropolitana.add("San Joaquín");
        ciudadMetropolitana.add("San Miguel");
        ciudadMetropolitana.add("San Ramón");
        ciudadMetropolitana.add("Vitacura");
        ciudadMetropolitana.add("Talagante");
        ciudadMetropolitana.add("El Monte");
        ciudadMetropolitana.add("Isla de Maipo");
        ciudadMetropolitana.add("Padre Hurtado");
        ciudadMetropolitana.add("Peñaflor");
        final ArrayAdapter adaptado = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadMetropolitana);
        ciudad.setAdapter(adaptado);

        ArrayList<String> ciudadOhiggins = new ArrayList<>();
        ciudadOhiggins.add("---");
        ciudadOhiggins.add("Rancagua");
        ciudadOhiggins.add("Codegua");
        ciudadOhiggins.add("Coinco");
        ciudadOhiggins.add("Coltauco");
        ciudadOhiggins.add("Doñihue");
        ciudadOhiggins.add("Graneros");
        ciudadOhiggins.add("Las Cabras");
        ciudadOhiggins.add("Machalí");
        ciudadOhiggins.add("Malloa");
        ciudadOhiggins.add("Mostazal");
        ciudadOhiggins.add("Olivar");
        ciudadOhiggins.add("Peumo");
        ciudadOhiggins.add("Pichidegua");
        ciudadOhiggins.add("Quinta de Tilcoco");
        ciudadOhiggins.add("Rengo");
        ciudadOhiggins.add("Requínoa");
        ciudadOhiggins.add("San Vicente de Tagua Tagua");
        ciudadOhiggins.add("Pichilemu");
        ciudadOhiggins.add("La Estrella");
        ciudadOhiggins.add("Litueche");
        ciudadOhiggins.add("Marchigüe");
        ciudadOhiggins.add("Navidad");
        ciudadOhiggins.add("Paredones");
        ciudadOhiggins.add("San Fernando");
        ciudadOhiggins.add("Chépica");
        ciudadOhiggins.add("Chimbarongo");
        ciudadOhiggins.add("Lolol");
        ciudadOhiggins.add("Nancagua");
        ciudadOhiggins.add("Palmilla");
        ciudadOhiggins.add("Peralillo");
        ciudadOhiggins.add("Placilla");
        ciudadOhiggins.add("Pumanque");
        ciudadOhiggins.add("Santa Cruz");
        final ArrayAdapter aa = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadValparaiso);
        ciudad.setAdapter(aa);

        ArrayList<String> ciudadMaule = new ArrayList<>();
        ciudadMaule.add("---");
        ciudadMaule.add("Cauquenes");
        ciudadMaule.add("Chanco");
        ciudadMaule.add("Pelluhue");
        ciudadMaule.add("Curicó");
        ciudadMaule.add("Hualañé");
        ciudadMaule.add("Licantén");
        ciudadMaule.add("Molina");
        ciudadMaule.add("Reuco");
        ciudadMaule.add("Romeral");
        ciudadMaule.add("Sagrada Familia");
        ciudadMaule.add("Teno");
        ciudadMaule.add("Vichuquén");
        ciudadMaule.add("Linares");
        ciudadMaule.add("Colbún");
        ciudadMaule.add("Longaví");
        ciudadMaule.add("Parral");
        ciudadMaule.add("Retiro");
        ciudadMaule.add("San Javier");
        ciudadMaule.add("Villa Alegre");
        ciudadMaule.add("Yerbas Buenas");
        ciudadMaule.add("Talca");
        ciudadMaule.add("Constitución");
        ciudadMaule.add("Curepto");
        ciudadMaule.add("Empedrado");
        ciudadMaule.add("Maule");
        ciudadMaule.add("Pelarco");
        ciudadMaule.add("Pencahue");
        ciudadMaule.add("Río Claro");
        ciudadMaule.add("San Clemente");
        ciudadMaule.add("San Rafael");
        final ArrayAdapter aamaule = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadMaule);
        ciudad.setAdapter(aamaule);

        ArrayList<String> ciudadNuble = new ArrayList<>();
        ciudadNuble.add("---");
        ciudadNuble.add("Bulnes");
        ciudadNuble.add("Chillán");
        ciudadNuble.add("Chillán Viejo");
        ciudadNuble.add("El Carmen");
        ciudadNuble.add("Pemuco");
        ciudadNuble.add("Pinto");
        ciudadNuble.add("Quillón");
        ciudadNuble.add("San Ignacio");
        ciudadNuble.add("Yungay");
        ciudadNuble.add("Quirihue");
        ciudadNuble.add("Cobquecura");
        ciudadNuble.add("Coelemu");
        ciudadNuble.add("Ninhue");
        ciudadNuble.add("Portezuelo");
        ciudadNuble.add("Ránquil");
        ciudadNuble.add("Trehuaco");
        ciudadNuble.add("San Carlos");
        ciudadNuble.add("Coihueco");
        ciudadNuble.add("Ñinquén");
        ciudadNuble.add("San Fabián");
        ciudadNuble.add("San Nicolás");
        final ArrayAdapter aanuble = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadNuble);
        ciudad.setAdapter(aanuble);

        ArrayList<String> ciudadBiobio = new ArrayList<>();
        ciudadBiobio.add("---");
        ciudadBiobio.add("Lebu");
        ciudadBiobio.add("Arauco");
        ciudadBiobio.add("Cañete");
        ciudadBiobio.add("Contulmo");
        ciudadBiobio.add("Curanilahue");
        ciudadBiobio.add("Los Álamos");
        ciudadBiobio.add("Tirúa");
        ciudadBiobio.add("Los Ángeles");
        ciudadBiobio.add("Alto Bío Bío");
        ciudadBiobio.add("Antuco");
        ciudadBiobio.add("Cabrero");
        ciudadBiobio.add("Laja");
        ciudadBiobio.add("Mulchén");
        ciudadBiobio.add("Nacimiento");
        ciudadBiobio.add("Negrete");
        ciudadBiobio.add("Quilaco");
        ciudadBiobio.add("Quilleco");
        ciudadBiobio.add("San Rosendo");
        ciudadBiobio.add("Santa Bárbara");
        ciudadBiobio.add("Tucapel");
        ciudadBiobio.add("Yumbel");
        ciudadBiobio.add("Concepción");
        ciudadBiobio.add("Chiguayante");
        ciudadBiobio.add("Coronel");
        ciudadBiobio.add("Florida");
        ciudadBiobio.add("Hualpén");
        ciudadBiobio.add("Hualqui");
        ciudadBiobio.add("Lota");
        ciudadBiobio.add("Penco");
        ciudadBiobio.add("San Pedro de la Paz");
        ciudadBiobio.add("Santa Juana");
        ciudadBiobio.add("Talcahuano");
        ciudadBiobio.add("Tomé");
        final ArrayAdapter aabiobio = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadBiobio);


        ArrayList<String> ciudadAraucania = new ArrayList<>();
        ciudadAraucania.add("---");
        ciudadAraucania.add("Temuco");
        ciudadAraucania.add("Carahue");
        ciudadAraucania.add("Chol Chol");
        ciudadAraucania.add("Cunco");
        ciudadAraucania.add("Curarrehue");
        ciudadAraucania.add("Freire");
        ciudadAraucania.add("Galvarino");
        ciudadAraucania.add("Gorbea");
        ciudadAraucania.add("Lautaro");
        ciudadAraucania.add("Loncoche");
        ciudadAraucania.add("Melipeuco");
        ciudadAraucania.add("Nueva Imperial");
        ciudadAraucania.add("Padre las Casas");
        ciudadAraucania.add("Perquenco");
        ciudadAraucania.add("Pitrufquén");
        ciudadAraucania.add("Pucón");
        ciudadAraucania.add("Saavedra");
        ciudadAraucania.add("Teodoro Schmidt");
        ciudadAraucania.add("Toltén");
        ciudadAraucania.add("Vilcún");
        ciudadAraucania.add("Villarrica");
        ciudadAraucania.add("Angol");
        ciudadAraucania.add("Collipulli");
        ciudadAraucania.add("Curacautín");
        ciudadAraucania.add("Ercilla");
        ciudadAraucania.add("Lonquimay");
        ciudadAraucania.add("Los Sauces");
        ciudadAraucania.add("Lumaco");
        ciudadAraucania.add("Purén");
        ciudadAraucania.add("Renaico");
        ciudadAraucania.add("Traiguén");
        ciudadAraucania.add("Victoria");
        final ArrayAdapter aaaraucania = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadAraucania);
        ciudad.setAdapter(aaaraucania);

        ArrayList<String> ciudadRios = new ArrayList<>();
        ciudadRios.add("---");
        ciudadRios.add("La Unión");
        ciudadRios.add("Futrono");
        ciudadRios.add("Lago Ranco");
        ciudadRios.add("Río Bueno");
        ciudadRios.add("Valdivia");
        ciudadRios.add("Corral");
        ciudadRios.add("Lanco");
        ciudadRios.add("Los Lagos");
        ciudadRios.add("Máfil");
        ciudadRios.add("Mariquina");
        ciudadRios.add("Paillaco");
        ciudadRios.add("Panguipulli");
        final ArrayAdapter aarios = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadRios);
        ciudad.setAdapter(aarios);

        ArrayList<String> ciudadLagos = new ArrayList<>();
        ciudadLagos.add("---");
        ciudadLagos.add("Castro");
        ciudadLagos.add("Ancud");
        ciudadLagos.add("Chonchi");
        ciudadLagos.add("Curaco de Vélez");
        ciudadLagos.add("Dalcahue");
        ciudadLagos.add("Puqueldón");
        ciudadLagos.add("Queilén");
        ciudadLagos.add("Quellón");
        ciudadLagos.add("Quemchi");
        ciudadLagos.add("Quinchao");
        ciudadLagos.add("Puerto Montt");
        ciudadLagos.add("Calbuco");
        ciudadLagos.add("Cochamó");
        ciudadLagos.add("Fresia");
        ciudadLagos.add("Frutillar");
        ciudadLagos.add("Los Muermos");
        ciudadLagos.add("Llanquihue");
        ciudadLagos.add("Maullín");
        ciudadLagos.add("Puerto Varas");
        ciudadLagos.add("Osorno");
        ciudadLagos.add("Puerto Octay");
        ciudadLagos.add("Purranque");
        ciudadLagos.add("Puyehue");
        ciudadLagos.add("Río Negro");
        ciudadLagos.add("San Juan de la Costa");
        ciudadLagos.add("San Pablo");
        ciudadLagos.add("Chaitén");
        ciudadLagos.add("Futaleufú");
        ciudadLagos.add("Hualaihué");
        ciudadLagos.add("Palena");
        final ArrayAdapter aalagos = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadLagos);
        ciudad.setAdapter(aalagos);

        ArrayList<String> ciudadAysen = new ArrayList<>();
        ciudadAysen.add("---");
        ciudadAysen.add("Aysén");
        ciudadAysen.add("Cisnes");
        ciudadAysen.add("Guaitecas");
        ciudadAysen.add("Cochrane");
        ciudadAysen.add("O'Higgins");
        ciudadAysen.add("Tortel");
        ciudadAysen.add("Coyhaique");
        ciudadAysen.add("Lago Verde");
        ciudadAysen.add("Chile Chico");
        ciudadAysen.add("Río Ibáñez");
        final ArrayAdapter aaaysen = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadAysen);
        ciudad.setAdapter(aalagos);

        ArrayList<String> ciudadMagallanes = new ArrayList<>();
        ciudadMagallanes.add("---");
        ciudadMagallanes.add("Cabo de Hornos");
        ciudadMagallanes.add("Antártica");
        ciudadMagallanes.add("Punta Arenas");
        ciudadMagallanes.add("Laguna Blanca");
        ciudadMagallanes.add("Río Verde");
        ciudadMagallanes.add("San Gregorio");
        ciudadMagallanes.add("Porvenir");
        ciudadMagallanes.add("Primavera");
        ciudadMagallanes.add("Timaukel");
        ciudadMagallanes.add("Puerto Natales");
        ciudadMagallanes.add("Torres del Paine");
        final ArrayAdapter aamagallanes = new ArrayAdapter(modificarDatos.this, android.R.layout.simple_spinner_dropdown_item, ciudadMagallanes);
        ciudad.setAdapter(aamagallanes);



        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Bundle B = getIntent().getExtras();
                //String REGION = B.getString("region");

                if (position==0){
                    ciudad.setEnabled(true);
                    //Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_SHORT).show();
                    String REGION = region.getSelectedItem().toString();
                }
                else if (position==1){
                    ciudad.setAdapter(adaptador);
                    ciudad.setEnabled(true);
                }
                else if (position==2){
                    ciudad.setAdapter(ad);
                    ciudad.setEnabled(true);
                }
                else if (position==3){
                    ciudad.setAdapter(adap);
                    ciudad.setEnabled(true);
                }
                else if (position==4){
                    ciudad.setAdapter(adapt);
                    ciudad.setEnabled(true);
                }
                else if (position==5){
                    ciudad.setAdapter(adapta);
                    ciudad.setEnabled(true);
                }
                else if (position==6){
                    ciudad.setAdapter(adaptad);
                    ciudad.setEnabled(true);
                }
                else if (position==7){
                    ciudad.setAdapter(adaptado);
                    ciudad.setEnabled(true);
                }
                else if (position==8){
                    ciudad.setAdapter(aa);
                    ciudad.setEnabled(true);
                }
                else if (position==9){
                    ciudad.setAdapter(aamaule);
                    ciudad.setEnabled(true);
                }
                else if (position==10){
                    ciudad.setAdapter(aanuble);
                    ciudad.setEnabled(true);
                }
                else if (position==11){
                    ciudad.setAdapter(aabiobio);
                    ciudad.setEnabled(true);
                }
                else if (position==12){
                    ciudad.setAdapter(aaaraucania);
                    ciudad.setEnabled(true);
                }
                else if (position==13){
                    ciudad.setAdapter(aarios);
                    ciudad.setEnabled(true);
                }
                else if (position==14){
                    ciudad.setAdapter(aalagos);
                    ciudad.setEnabled(true);
                }
                else if (position==15){
                    ciudad.setAdapter(aaaysen);
                    ciudad.setEnabled(true);
                }
                else if (position==16){
                    ciudad.setAdapter(aamagallanes);
                    ciudad.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        guardar = (Button)findViewById(R.id.btn_guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase Db;
                SQLiteHelper Conn = new SQLiteHelper(getApplicationContext());
                Db = Conn.getWritableDatabase();

                Cursor cursor = Db.rawQuery("SELECT * FROM crearcuenta", null);
                if ((cursor!=null)&&(cursor.getCount()>0)){
                    if (cursor.moveToFirst()){  //cursor en posicion 0
                        do {
                            do {
                                String RUTT = rut.getText().toString();
                                String PK = cursor.getString(0);
                                String Nombre = nombre.getText().toString();
                                String Apellidos = apellidos.getText().toString();
                                String Correo = correo.getText().toString();
                                String Telefono = telefono.getText().toString();
                                String Region = region.toString();

                                if (RUTT.equals(PK)) {
                                    String Where = "rut=?";
                                    String[] ArgWhere = {PK};

                                    ContentValues CV = new ContentValues();
                                    CV.put("nombre", Nombre);
                                    CV.put ("apellidos", Apellidos);
                                    CV.put ("correo", Correo);
                                    CV.put ("telefono", Telefono);
                                    CV.put ("region", Region);
                                    Db.update("crearcuenta", CV, Where, ArgWhere);
                                    Db.close();
                                    Toast.makeText(getApplicationContext(), "DATOS MODIFICADOS", Toast.LENGTH_SHORT).show();
                                }
                            } while (cursor.moveToNext());
                        }
                        while (cursor.moveToNext());
                    }
                }
            }
        });
    }
}
