package com.truper.demoREST.STORE.ENTITYS;

import jakarta.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int producto_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orden_id", referencedColumnName = "orden_id")
    //private int orden_id;
    private Orden orden;
    private String codigo;
    private String descripcion;
    private double precio;

    public Producto(){}

    public Producto(Orden orden, String codigo, String descripcion, double precio) {
        this.orden = orden;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
