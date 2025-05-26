package com.truper.demoREST.STORE.ENTITYS;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orden_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sucursal_id", referencedColumnName = "sucursal_id")
    //private int sucursal_id;
    private Sucursal sucursal;
    private Date fecha;
    private Double total;

    public Orden() {
    }

    public Orden(int orden_id, Sucursal sucursal, Date fecha, Double total) {
        this.orden_id = orden_id;
        this.sucursal = sucursal;
        this.fecha = fecha;
        this.total = total;
    }

    public int getOrden_id() {
        return orden_id;
    }

    public void setOrden_id(int orden_id) {
        this.orden_id = orden_id;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
