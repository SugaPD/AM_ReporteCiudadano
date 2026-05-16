package com.example.reporteciudadano.models;

public class ReporteRequest {

    private String nombre_interesado;
    private String direccion;
    private String colonia;
    private String celular;
    private String correo;
    private String tipo;
    private String descripcion;
    private String imagen;

    public ReporteRequest(String nombre_interesado,
                          String direccion,
                          String colonia,
                          String celular,
                          String correo,
                          String tipo,
                          String descripcion,
                          String imagen) {

        this.nombre_interesado = nombre_interesado;
        this.direccion = direccion;
        this.colonia = colonia;
        this.celular = celular;
        this.correo = correo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre_interesado() {
        return nombre_interesado;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }
}
