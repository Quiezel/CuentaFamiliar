/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiezel.cuenta_familiar.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Chalio
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;

    public Usuario() {
    }

    public Usuario(String userName) {
        this.userName = userName;
    }
    
    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Cuenta> cuentas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    
    public void addCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
        cuenta.setUsuario(this);
    }
    
    public void removeCuenta(Cuenta cuenta){
        cuentas.remove(cuenta);
        cuenta.setUsuario(null);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", userName=" + userName + '}';
    }
    
}
