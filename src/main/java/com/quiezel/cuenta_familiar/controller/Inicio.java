/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiezel.cuenta_familiar.controller;

import com.quiezel.cuenta_familiar.view.Ventana;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author Chalio
 */
public class Inicio {
    private Ventana ventana;
    private static ConfigurableApplicationContext context;

    public Inicio(ConfigurableApplicationContext context) {
        Inicio.context = context;
        ventana = new Ventana();
        load();
    }
    
    private void load(){
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    public void restart(){
        if (ventana != null) {
            ventana.dispose();
        }
        ventana = new Ventana();
        load();
    }
    
    private void addPaneles(){
        
    }
    
    public static <T> T getBean(Class<T> t){
        return context.getBean(t);
    }
}
