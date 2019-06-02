/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiezel.cuenta_familiar.view;

import com.quiezel.cuenta_familiar.model.Usuario;
import com.quiezel.cuenta_familiar.model.repos.UsuarioRepo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Chalio
 */
@Component
public class PanelLogin extends javax.swing.JPanel {
    @Autowired
    private UsuarioRepo repo;
    private Map<String, Usuario> usuarios;
    private Usuario autenticado;

    /**
     * Creates new form PanelLogin
     */
    public PanelLogin() {
        initComponents();
        loadUsuarios();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        comboListaUsuarios = new javax.swing.JComboBox<>();
        botonIniciarSesion = new javax.swing.JButton();
        botonNuevoUsuario = new javax.swing.JButton();
        fieldUsuario = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        comboListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboListaUsuariosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 50, 3, 50);
        add(comboListaUsuarios, gridBagConstraints);

        botonIniciarSesion.setText("Iniciar Sesion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.1;
        add(botonIniciarSesion, gridBagConstraints);

        botonNuevoUsuario.setText("Crear Usuario");
        botonNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoUsuarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(botonNuevoUsuario, gridBagConstraints);

        fieldUsuario.setToolTipText("Nombre de usuario");
        fieldUsuario.setMinimumSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 50, 3, 50);
        add(fieldUsuario, gridBagConstraints);

        fieldPassword.setMinimumSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 50, 3, 50);
        add(fieldPassword, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoUsuarioActionPerformed
        // TODO add your handling code here:
        if (!fieldUsuario.getText().isEmpty()) {
            repo.save(new Usuario(fieldUsuario.getText()));
        }
        loadUsuarios();
    }//GEN-LAST:event_botonNuevoUsuarioActionPerformed

    private void comboListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboListaUsuariosActionPerformed
        // TODO add your handling code here:
        if (comboListaUsuarios.getSelectedIndex() >= 0) {
            fieldUsuario.setText(comboListaUsuarios.getSelectedItem().toString());
        }
    }//GEN-LAST:event_comboListaUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JButton botonNuevoUsuario;
    private javax.swing.JComboBox<String> comboListaUsuarios;
    private javax.swing.JTextField fieldPassword;
    private javax.swing.JTextField fieldUsuario;
    // End of variables declaration//GEN-END:variables

    private void loadUsuarios() {
        usuarios = new HashMap<>();
        comboListaUsuarios.removeAllItems();
        for (Usuario usuario : repo.findAll()) {
            usuarios.put(usuario.getUserName(), usuario);
            comboListaUsuarios.addItem(usuario.getUserName());
        }
    }

    public Usuario getAutenticado() {
        return autenticado;
    }
}