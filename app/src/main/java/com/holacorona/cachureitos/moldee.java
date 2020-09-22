package com.holacorona.cachureitos;

public class moldee {
    private String nombre;
    private String categoria;
    private String region;
    private String ciudad;

    public moldee (String nombre, String categoria, String region, String ciudad){
        this.nombre = nombre;
        this.categoria = categoria;
        this.region = region;
        this.ciudad = ciudad;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public String getRegion(){
        return region;
    }
    public String getCiudad(){
        return ciudad;
    }

}
