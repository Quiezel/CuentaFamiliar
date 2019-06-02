/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiezel.cuenta_familiar.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Chalio
 */
@Entity
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal monto;
    private LocalDate fecha;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Movimiento_Etiqueta",
            joinColumns = @JoinColumn(name = "movimientoId"),
            inverseJoinColumns = @JoinColumn(name = "etiquetaId"))
    private Set<Etiqueta> etiquetas = new HashSet<>();
    
    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Cuenta.class)
    @JoinColumn(name = "cuentaId")
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(String concepto, BigDecimal monto) {
        this.monto = monto;
        this.fecha = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Set<Etiqueta> getEtiquetas() {
        return etiquetas;
    }
    
    public void addEtiqueta(Etiqueta etiqueta){
        etiquetas.add(etiqueta);
        etiqueta.getMovimientos().add(this);
    }
    
    public void removeEtiqueta(Etiqueta etiqueta){
        etiquetas.remove(etiqueta);
        etiqueta.getMovimientos().remove(this);
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("Movimiento[id=%d, monto=%f.2, fecha=%s]",
                id, monto, fecha.format(formatter)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.fecha);
        hash = 13 * hash + Objects.hashCode(this.cuenta);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimiento other = (Movimiento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.cuenta, other.cuenta)) {
            return false;
        }
        return true;
    }

}
