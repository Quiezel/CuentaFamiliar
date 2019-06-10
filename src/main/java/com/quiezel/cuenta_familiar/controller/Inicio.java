/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiezel.cuenta_familiar.controller;

import com.quiezel.cuenta_familiar.view.PanelLogin;
import com.quiezel.cuenta_familiar.view.Ventana;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author Chalio
 */
@Component
public class Inicio implements ApplicationContextAware{
    private ApplicationContext context;
    private Ventana ventana;

    public Inicio() {
    }
    
    public void load(){
        ventana = context.getBean(Ventana.class);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    public void restart(){
        if (ventana != null) {
            ventana.dispose();
        }
        ventana = new Ventana(context);
        load();
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        context = ac;
    }
}
